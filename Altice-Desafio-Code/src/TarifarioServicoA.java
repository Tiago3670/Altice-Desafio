import java.sql.Time;

public class TarifarioServicoA {


    public static Boolean isElegivel(ChargingRequest request)
    {
        if(request.getService()==ServiceType.A)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static ChargingReply ServiceA(ChargingRequest request)
    {
        ChargingReply reply = null;
        if(Date.isWeekend(request)) // fim de semana (Apha 1 não pode ser usado)
        {
            if(request.isRoaming() && BillingAccount.getBucketC()>1000)// faz Alpha3
            {
                BillingAccount.setCounterC();
                CDR.setTariffId(Alpha3.getId());
                reply=Alpha3.calcularCustoAlpha3(request);
            }
            else if(!request.isRoaming() && BillingAccount.getBucketB()>1000)// faz Alpha2
            {
                CDR.setTariffId(Alpha2.getId());
                reply=Alpha2.calcularCustoAlpha2(request);
            }
        } else if (!Date.isWeekend(request)) // dia de semana
        {
            if(BillingAccount.getCounterA()<100)   //Faz alpha1
            {
                CDR.setTariffId(Alpha1.getId());
                reply=Alpha1.calcularCustoAlpha1(request);
            } else if (BillingAccount.getBucketB()>1000 && !request.isRoaming())  //faz alpha2
            {
                CDR.setTariffId(Alpha2.getId());
                reply=Alpha2.calcularCustoAlpha2(request);
            } else if (BillingAccount.getBucketC()>1000 && request.isRoaming())  //faz alpha3
            {
                BillingAccount.setCounterC();
                CDR.setTariffId(Alpha3.getId());
                reply=Alpha3.calcularCustoAlpha3(request);
            }
        }
        if(reply!=null)
        {
            BillingAccount.setCounterA(reply.getGSU());
        }
        Central.saveRequest(reply);
        return reply;
    }


}


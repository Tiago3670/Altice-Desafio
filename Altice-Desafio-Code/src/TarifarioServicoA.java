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
            if(request.isRoaming())
            {
                BillingAccount.setCounterC();
                if(BillingAccount.getBucketC()>1000) // faz Alpha3
                {

                }
            }
            else if(!request.isRoaming())
            {
                if (BillingAccount.getBucketB()>1000) // faz Alpha2
                {

                }
            }
        } else if (!Date.isWeekend(request)) // dia de semana
        {
            if(BillingAccount.getCounterA()<100)   //Faz alpha1
            {
                reply=Alpha1.calcularCustoAlpha1(request);

            } else if (BillingAccount.getBucketB()>1000)  //faz alpha2
            {

            } else if (BillingAccount.getBucketC()>1000)  //faz alpha3
            {

            }
        }
        if(reply!=null)
        {
            BillingAccount.setCounterA(reply.getGSU());
        }
        System.out.println("olha"+reply.getMsisdn());
        Central.saveRequest(reply);
        return reply;
    }


}


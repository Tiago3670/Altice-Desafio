import java.sql.Time;

public class TarifarioServicoA {
    public static ChargingReply ServiceA(ChargingRequest request)
    {
        ChargingReply reply = null;
        
         
        if(!Date.isWeekend(request) && BillingAccount.getCounterA()<100){ //Alpha1
            CDR.setTariffId(Alpha1.getId());
            reply=Alpha1.calcularCustoAlpha1(request);
        } else if (!request.isRoaming() && BillingAccount.getBucketB()>1000) { //Alpha2
            CDR.setTariffId(Alpha2.getId());
            reply=Alpha2.calcularCustoAlpha2(request);
        } else if (request.isRoaming() && BillingAccount.getBucketC()>1000) { //Apha3
            BillingAccount.setCounterC();
            CDR.setTariffId(Alpha3.getId());
            reply=Alpha3.calcularCustoAlpha3(request);
        }
        else
        {
             reply=new ChargingReply(request.getRequestId(),"Não Elegivel", 0,0, request.getMsisdn(), request.getTimeStamp());
        }


            BillingAccount.setCounterA(reply.getGSU());

        Central.saveRequest(reply);
        return reply;
    }


}


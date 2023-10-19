public class TarifarioServicoB {

    public static ChargingReply ServiceB(ChargingRequest request)
    {
        ChargingReply reply = null;

        if(!Date.isWeekend(request) || (Date.isWeekend(request) && Date.isNight(request)) ) //beta 1  (só dias da semana) ou fim de semana de noite
        {
            BillingAccount.setCounterB();

            if(request.isRoaming()){
                BillingAccount.setCounterC();
            }

            CDR.setTariffId(Beta1.getId());
            reply=Beta1.calcularCustoBeta1(request);

        } else if (!request.isRoaming() && BillingAccount.getBucketB()>1000) //beta 2 só rede local e bucket B maior que 10€
        {
            CDR.setTariffId(Beta2.getId());
            reply=Beta2.calcularCustoBeta2(request);

        }else if (request.isRoaming() && BillingAccount.getBucketC()>1000) //beta 3 só Roamming e bucket C maior que 10€
        {
            BillingAccount.setCounterC();
            CDR.setTariffId(Beta3.getId());
            reply=Beta3.calcularCustoBeta3(request);
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


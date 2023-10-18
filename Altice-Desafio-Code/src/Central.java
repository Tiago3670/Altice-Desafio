public class Central { // classe encarregue por decicidar qual tarifario vai ser usado
    public static ChargingReply setRequest(ChargingRequest request)
    {
        ChargingReply reply = null;
        TarifarioServicoA tarifarioServicoA=new TarifarioServicoA();
        if(request.getService()==ServiceType.A) // serviço A
        {
            if(Date.isWeekend(request)) // fim de semana (Apha 1 não pode ser usado)
            {
                if(request.isRoaming())
                {

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
                    reply=tarifarioServicoA.calcularCustoAlpha1(request);
                } else if (BillingAccount.getBucketB()>1000)  //faz alpha2
                {

                } else if (BillingAccount.getBucketC()>1000)  //faz alpha3
                {

                }
            }


        }
        return reply;
    }
}

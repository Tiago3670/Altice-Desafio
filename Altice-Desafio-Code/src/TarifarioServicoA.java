public class TarifarioServicoA {


    public Boolean isElegivel(ChargingRequest request)
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
    public ChargingReply calcularCustoAlpha1(ChargingRequest request) {
        String result = null;
        double gsu=0;
        boolean bucketA=false,bucketB=false, bucketC=false;
        if(isElegivel(request))
        {
            if(BillingAccount.getCounterA()<100)
            {
                double custoTotal=0;
                double custo = 100; //centimos
                if (request.isRoaming()) {
                    custo = 200; // em roaming
                }

                if (BillingAccount.getCounterA() > 10) {
                    custo -= 25; // Desconto se counterA for maior que 10
                }

                if (BillingAccount.getBucketC() > 5000) { // 5000 centimos são 50 euros
                    custo -= 10; // Desconto se bucketC for maior que 50€
                }
                custoTotal=custo*request.getRsu();

                if(request.isRoaming()) // roaming
                {
                    if(BillingAccount.getCounterB()>5)
                    {
                        result= BillingAccount.subtractBucketB(custoTotal);
                        bucketB=true;
                    }
                    else
                    {
                        result= BillingAccount.subtractBucketC(custoTotal);
                        bucketC=true;
                    }

                }
                else
                {
                    result= BillingAccount.subtractBucketA(custoTotal);
                    bucketA=true;
                }


                if(result=="OK") // resultado OK foi debitado o total gasto então foram usados todos os minutos pedidos
                {
                    gsu=request.getRsu();
                }
                else if(result=="CreditLimitReached")
                {
                    if(bucketA)
                    {
                        gsu= BillingAccount.getBucketA()/custo;
                        custoTotal=custo*gsu;
                        BillingAccount.subtractBucketA(custoTotal);

                    } else if (bucketB) {
                        gsu= BillingAccount.getBucketB()/custo;
                        custoTotal=custo*gsu;
                        BillingAccount.subtractBucketB(custoTotal);
                    } else if (bucketC) {
                        gsu= BillingAccount.getBucketC()/custo;
                        custoTotal=custo*gsu;
                        BillingAccount.subtractBucketC(custoTotal);
                    }
                }
            }
            else
            {
                result="Não Elegivel + Atingiu o limite de chamadas (100)";
                gsu=0;
            }
        }
        else
        {
            result="Não Elegivel + Não subrecreveu o srviço A";
            gsu=0;
        }

        ChargingReply reply=new ChargingReply(request.getRequestId(),result, gsu);

        return reply;
    }


}


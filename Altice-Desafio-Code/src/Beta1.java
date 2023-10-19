public class Beta1 {
    ServiceType servico;
    static int id;
    Beta1 (int id,ServiceType servico)
    {
        this.id=id;
        this.servico=servico;
    }

    public static String getId() {
        return  Integer.toString(id) ;
    }


    public static  ChargingReply calcularCustoBeta1(ChargingRequest request)
    {
        String result = null;
        double gsu=0;
        double custoTotal=0;
        boolean bucketA=false,bucketB=false, bucketC=false;
        System.out.println("Tarifario Beta1");

        if(BillingAccount.getCounterA()<100)
        {

            double custo = 1; //centimos
            if (request.isRoaming()) {
                custo = 2; // em roaming
            }

            if (BillingAccount.getCounterA() > 10) {
                custo -= 25; // Desconto se counterA for maior que 10
            }

            if (BillingAccount.getBucketC() > 5000) { // 5000 centimos são 50 euros
                custo -= 0.1; // Desconto se bucketC for maior que 50€
            }
            System.out.println("custo por minuto: "+ custo);
            custoTotal=custo*request.getRsu();
            System.out.println("custo depois de calculado para "+request.getRsu() + " minutos ="+ custoTotal +"centimos" );

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


            if(result=="OK")
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



        ChargingReply reply=new ChargingReply(request.getRequestId(),result, gsu,custoTotal/100, request.getMsisdn(), request.getTimeStamp());

        return reply;
    }
}

public class Alpha2 {
    ServiceType servico;
    static int id;
    Alpha2 (int id,ServiceType servico)
    {
        this.id=id;
        this.servico=servico;
    }
    public static String getId() {
        return  Integer.toString(id) ;
    }

    public static  ChargingReply calcularCustoAlpha2(ChargingRequest request) {
        String result = null;
        double gsu=0;
        double custoTotal=0;
        boolean bucketA=false,bucketB=false, bucketC=false;

        System.out.println("Tarifario Alpha2");

            double custo = 50; //centimos

            if(Date.isNight(request))
            {
                custo=25;
            }

            if (BillingAccount.getCounterB() > 10) {
                custo -= 2; // Desconto se counterB for maior que 10
            }

            if (BillingAccount.getBucketB() > 1500) {
                custo -= 5; // Desconto se bucketB for maior que 15€
            }

            System.out.println("custo por minuto: "+ custo);
            custoTotal=custo*request.getRsu();
            System.out.println("custo depois de calculado para "+request.getRsu() + " minutos ="+ custoTotal +"centimos" );

            result= BillingAccount.subtractBucketB(custoTotal);
            bucketB=true;



            if(result=="OK") // resultado OK foi debitado o total gasto mas podem não ter sido  usados todos os minutos pedidos
            {
                gsu=request.getRsu();
            }
            else if(result=="CreditLimitReached")
            {
                if(bucketB)
                {
                    gsu= BillingAccount.getBucketB()/custo;
                    custoTotal=custo*gsu;
                    BillingAccount.subtractBucketB(custoTotal);
                }
            }

        ChargingReply reply=new ChargingReply(request.getRequestId(),result, gsu,custoTotal/100, request.getMsisdn(), request.getTimeStamp());

        return reply;
    }
}

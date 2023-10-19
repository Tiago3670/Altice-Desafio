public class Beta3 {
    ServiceType servico;
    static int id;
    Beta3(int id, ServiceType servico)
    {
        this.id=id;
        this.servico=servico;
    }

    public static String getId() {
        return  Integer.toString(id) ;
    }


    public static ChargingReply calcularCustoBeta3(ChargingRequest request) {
        String result = null;
        double gsu=0;
        double custoTotal=0;
        boolean bucketA=false,bucketB=false, bucketC=false;

        System.out.println("Tarifario Beta3");

        double custo = 10; //centimos

        if(Date.isWeekend(request))
        {
            custo=25;
        }

        if (BillingAccount.getCounterC() > 10) {
            custo -= 2; // Desconto se counterC for maior que 10
        }

        if (BillingAccount.getBucketC() > 1500) {
            custo -= 5; // Desconto se bucketC for maior que 15€
        }

        System.out.println("custo por minuto: "+ custo);
        custoTotal=custo*request.getRsu();
        System.out.println("custo depois de calculado para "+request.getRsu() + " minutos ="+ custoTotal +"centimos" );

        result= BillingAccount.subtractBucketC(custoTotal);
        bucketC=true;



        if(result=="OK") // resultado OK foi debitado o total gasto mas podem não ter sido  usados todos os minutos pedidos
        {
            gsu=request.getRsu();
        }
        else if(result=="CreditLimitReached")
        {
            if(bucketC)
            {
                gsu= BillingAccount.getBucketC()/custo;
                custoTotal=custo*gsu;
                BillingAccount.subtractBucketC(custoTotal);
            }
        }

        ChargingReply reply=new ChargingReply(request.getRequestId(),result, gsu,custoTotal/100, request.getMsisdn(), request.getTimeStamp());
        reply.setTariff("Beta3");

        return reply;
    }
}

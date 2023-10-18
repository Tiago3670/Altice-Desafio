import java.io.IOException;
import java.sql.Time;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        char op = 0;
        String msisdn;
        String rsu;
         List<ChargingReply> replyList = new ArrayList<>();
        Scanner sc= new Scanner(System.in);
        ChargingReply reply;
        BillingAccount.addBucketA(10);
        BillingAccount.addBucketB(20);
        BillingAccount.addBucketC(15);

        do{
            System.out.println("------------------Bem vindo-------------");
            System.out.println("(1) - Charging Request");
            System.out.println("(2) - Consultar Hisotrioc");

            System.out.println("(9) - Sair");
            op = (char) System.in.read();
            System.in.read();

             if (op=='1') {
                 boolean done = false;
                 char serv;
                 ServiceType serviceOp = null;
                UUID id = UUID.randomUUID();

                do{
                    System.out.println("Qual Serviço A ou B");
                    serv = (char) System.in.read();
                    System.in.read();
                    if(serv=='A')
                    {
                        serviceOp=ServiceType.A;
                        done=true;
                    }
                    else if (serv=='B'){
                        serviceOp=ServiceType.B;
                        done=true;
                    }
                }while (done != true );

                 System.out.println("MSISDN:");
                 msisdn = sc.nextLine();
                 System.out.println("Requested Service Units(min):");
                 rsu = sc.nextLine();
                 ChargingRequest request = new ChargingRequest(id, System.currentTimeMillis(), serviceOp, false, msisdn, Integer.valueOf(rsu));

                 reply=Central.setRequest(request);

                 System.out.println("Bucket A "+CDR.getBucketA());
                 System.out.println("Bucket B "+CDR.getBucketB());
                 System.out.println("Bucket C "+CDR.getBucketC());
                 System.out.println(reply.getResult());
                 System.out.println("usou este minutos: "+reply.getGSU());

             } else if (op=='2') {
                 System.out.println("MSISDN:");
                 msisdn = sc.nextLine();
                 replyList= Central.getAllRequests();

                for (int i=0;i<replyList.size();i++){
                    if(replyList.get(i).getMsisdn().equals(msisdn))
                    {
                        System.out.println("requst "+replyList.get(i).getRequestId());
                        Time newData=new Time(replyList.get(i).getTimeStamp());
                        System.out.println("timesmp "+newData);
                        System.out.println("result "+replyList.get(i).getResult());
                        System.out.println("MSISDN "+replyList.get(i).getMsisdn());
                    }
                 }
             }

        }while (op!='9');

    }
}
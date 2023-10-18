import java.io.IOException;
import java.util.Scanner;
import java.util.UUID;

public class Main {
    public static void main(String[] args) throws IOException {
        char op = 0;
        String msisdn;
        String rsu;
        Scanner sc= new Scanner(System.in);
        ChargingReply reply;

        do{
            System.out.println("------------------Bem vindo-------------");
            System.out.println("(1) - Charging Request");
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
                 System.out.println(msisdn);

                 System.out.println("Requested Service Units(min):");
                 rsu = sc.nextLine();
                 System.out.println(rsu);
                 ChargingRequest request = new ChargingRequest(id, System.currentTimeMillis(), serviceOp, false, msisdn, Integer.valueOf(rsu));
                 reply=Central.setRequest(request);
                 System.out.println(reply.getResult());
            }

        }while (op!='9');


    }
}
import java.io.IOException;
import java.util.UUID;

public class Main {
    public static void main(String[] args) throws IOException {
        char op = 0;
        TarifarioAlfa1 tarifarioA1 = new TarifarioAlfa1();

        /*ChargingRequest request = new ChargingRequest(1, System.currentTimeMillis(), ServiceType.A, false, "123456789", 5);


        tarifarioA1.subscrever();
     //   ChargingReply resquestReply=

        if (tarifarioA1.isElegivel(request)) {
            double custo = tarifarioA1.calcularCusto(request);

            System.out.println("Charging Request: " + request.getRequestId());
            System.out.println("Tarifario: Alfa1");
            System.out.println("Custo: " + custo+ " €");
        } else {
            System.out.println("Solicitação não elegível para o tarifário Alfa1.");
        }*/

        do{
            System.out.println("------------------Bem vindo-------------");
            System.out.println("(1) - Visualizar/Subscrever Serviços");
            System.out.println("(2) - Charging Request");
            System.out.println("(9) - Sair");
            op = (char) System.in.read();
            System.in.read();

            if(op=='1') {
                char op2;
                    System.out.println("(1) - Subscrever Serviço A ");
                    System.out.println("(2) - Subscrever Serviço B ");
                    System.out.println("(9) - Voltar");
                    op2 = (char) System.in.read();
                    System.in.read();

                    if (op2 == '1') {
                        char tariffOp;
                        System.out.println("Tarifários do serviço A");
                        System.out.println("(1) - Subscrever Alpha 1 ");
                        System.out.println("(2) - Subscrever Alpha 2 ");
                        System.out.println("(3) - Subscrever Alpha 3 ");
                        tariffOp = (char) System.in.read();
                        System.in.read();
                        if (tariffOp == '1') {
                            //tarifarioA3.retirarSubscricao();
                            //tarifarioA2.retirarSubscricao();
                            tarifarioA1.subscrever();
                        } else if (tariffOp == '2') {
                            tarifarioA1.retirarSubscricao(); //assumindo que só pode ter um tarifario
                            //tarifarioA3.retirarSubscricao();
                            // tarifarioA2.subscrever();
                        } else if (tariffOp == '3') {
                            // tarifarioA3.subscrever();
                            tarifarioA1.retirarSubscricao();
                            //tarifarioA2.retirarSubscricao();
                        }

                    }

            } else if (op=='2') {
                UUID id = UUID.randomUUID();
                ChargingRequest request = new ChargingRequest(id, System.currentTimeMillis(), ServiceType.A, false, "934567891", 5);

            }

        }while (op!='9');


    }
}
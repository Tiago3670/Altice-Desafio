import java.sql.Time;
import java.util.*;

public class Central { // classe encarregue por decicidar qual tarifario vai ser usado

    static List<ChargingReply> replyList = new ArrayList<>();

    public static ChargingReply setRequest(ChargingRequest request)
    {
        Time newTime=new Time(request.getTimeStamp());
        BillingAccount.setCounterD(newTime); //guardar a data da ultima requisição

        ChargingReply reply = null;
        if(request.getService()==ServiceType.A) // serviço A
        {
            CDR.setService(ServiceType.A);
            return TarifarioServicoA.ServiceA(request); // envia para o serviço que vai defenir qual o tarifario a ser usado
        }else   if(request.getService()==ServiceType.B) // serviço B
        {
            return activeServiceB(request);
        }
        return reply;
    }

    public static ChargingReply activeServiceB(ChargingRequest request)
    {
        ChargingReply reply = null;

        return reply;
    }

    public static  List<ChargingReply> getAllRequests() {
        return replyList;
    }

    public static void saveRequest(ChargingReply reply) {
        System.out.println("fuck "+reply.getMsisdn());
        replyList.add(reply);
    }
}

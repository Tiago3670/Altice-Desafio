import java.sql.Time;
import java.util.*;

public class Central { // classe encarregue por decicidar qual servico vai ser usado

    static List<ChargingReply> replyList = new ArrayList<>();

    public static ChargingReply setRequest(ChargingRequest request)
    {
        Time newTime=new Time(request.getTimeStamp());
        BillingAccount.setCounterD(newTime); //guardar a data da ultima requisição
        CDR.setMsisdn(request.getMsisdn());
        ChargingReply reply = null;
        if(request.getService()==ServiceType.A) // serviço A
        {
            CDR.setService(ServiceType.A);
            CDR.setChargingReply(reply);

            return TarifarioServicoA.ServiceA(request); // envia para o serviço que vai defenir qual o tarifario a ser usado
        }else   if(request.getService()==ServiceType.B) // serviço B
        {
            CDR.setService(ServiceType.B);
            CDR.setChargingReply(reply);

            return TarifarioServicoB.ServiceB(request); // envia para o serviço que vai defenir qual o tarifario a ser usado
        }
        else
        {
            reply=new ChargingReply(request.getRequestId(),"Não Elegivel", 0,0, request.getMsisdn(), request.getTimeStamp());
        }

        return reply;
    }
    public static  List<ChargingReply> getAllRequests() {
        return replyList;
    }
    public static void saveRequest(ChargingReply reply) {
        replyList.add(reply);
    }
}

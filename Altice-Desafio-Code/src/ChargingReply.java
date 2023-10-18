import java.util.UUID;

public class ChargingReply {
    private UUID requestId;
    private String result; // "OK", "CreditLimitReached", "Não Elegível", etc.
    private double gsu; // minutos concedidos podem não ser o numero de minutos pedidos
    private String msisdn;
    private double custo;
    private long timeStamp; // data da realização da requisção


    public ChargingReply(UUID requestId, String result, double gsu,double custo, String msisdn,long timeStamp) {
        this.requestId = requestId;
        this.result = result;
        this.gsu = gsu;
        this.custo=custo;
        this.msisdn=msisdn;
        this.timeStamp=timeStamp;
    }
    public long getTimeStamp() {
        return timeStamp;
    }

    public String getMsisdn()
    {
        return msisdn;
    }
    public UUID getRequestId() {
        return requestId;
    }

    public String getResult() {
        return result;
    }

    public double getGSU() {
        return gsu;
    }
}

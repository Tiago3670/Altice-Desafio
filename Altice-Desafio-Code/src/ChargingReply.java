import java.util.UUID;

public class ChargingReply {
    private UUID requestId;
    private String result; // "OK", "CreditLimitReached", "Não Elegível", etc.
    private double gsu; // minutos concedidos podem não ser o numero de minutos pedidos

    public ChargingReply(UUID requestId, String result, double gsu) {
        this.requestId = requestId;
        this.result = result;
        this.gsu = gsu;
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

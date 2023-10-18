public class ChargingReply {
    private int requestId;
    private String result; // "OK", "CreditLimitReached", "Não Elegível", etc.
    private int gsu; // minutos concedidos podem não ser o numero de minutos pedidos

    public ChargingReply(int requestId, String result, int gsu) {
        this.requestId = requestId;
        this.result = result;
        this.gsu = gsu;
    }

    public int getRequestId() {
        return requestId;
    }

    public String getResult() {
        return result;
    }

    public int getGSU() {
        return gsu;
    }
}

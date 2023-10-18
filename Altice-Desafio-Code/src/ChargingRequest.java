import java.util.UUID;

public class ChargingRequest {
    private UUID requestId;
    private long timeStamp; // data da realização da requisção
    private ServiceType service; // A ou B
    private boolean roaming; // true ou false
    private String msisdn; // numero de tel
    private double rsu; // asummindo que RSU é os minutos da chamada

    public ChargingRequest(UUID requestId, long timeStamp, ServiceType service, boolean roaming, String msisdn, double rsu) {
        this.requestId = requestId;
        this.timeStamp = timeStamp;
        this.service = service;
        this.roaming = roaming;
        this.msisdn = msisdn;
        this.rsu = rsu;
    }



    public UUID getRequestId() {
        return requestId;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public ServiceType getService() {
        return service;
    }

    public boolean isRoaming() {
        return roaming;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public double getRsu() {
        return rsu;
    }
}

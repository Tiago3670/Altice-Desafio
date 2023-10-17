import java.sql.Time;

public class ChargingRequest {
    private int requestId;
    private Time timeStamp;
    private ServiceType service;
    private boolean roaming;
    private String msisdn;
    private int rsu;

    public ChargingRequest(int requestId, Time timeStamp, ServiceType service, boolean roaming, String msisdn, int rsu) {
        this.requestId = requestId;
        this.timeStamp = timeStamp;
        this.service = service;
        this.roaming = roaming;
        this.msisdn = msisdn;
        this.rsu = rsu;
    }

    public int getRequestId() {
        return requestId;
    }

    public Time getTimeStamp() {
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

    public int getRsu() {
        return rsu;
    }
}

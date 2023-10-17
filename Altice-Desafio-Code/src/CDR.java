import java.sql.Time;

public class CDR {
    private Time timeStamp;
    private String msisdn;
    private int serviceId;
    private String transactionType; // Pode ser "Charging Request" ou "Charging Reply"
    private String bucketsAndValues; // Uma representação dos buckets e valores relevantes
    private String countersAndValues; // Uma representação dos contadores e valores relevantes
    private String tariffId;

    public CDR(Time timeStamp, String msisdn, int serviceId, String transactionType, String bucketsAndValues, String countersAndValues, String tariffId) {
        this.timeStamp = timeStamp;
        this.msisdn = msisdn;
        this.serviceId = serviceId;
        this.transactionType = transactionType;
        this.bucketsAndValues = bucketsAndValues;
        this.countersAndValues = countersAndValues;
        this.tariffId = tariffId;
    }

    // Getters and setters for the attributes (if needed)

    public Time getTimeStamp() {
        return timeStamp;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public int getService() {
        return serviceId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public String getBucketsAndValues() {
        return bucketsAndValues;
    }

    public String getCountersAndValues() {
        return countersAndValues;
    }

    public String getTariffId() {
        return tariffId;
    }
}

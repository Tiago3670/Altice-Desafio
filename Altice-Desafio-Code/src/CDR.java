import java.sql.Time;

public class CDR {
    private static Time timeStamp;
    private static String msisdn;
    private static ServiceType service;
    private String transactionType; // Pode ser "Charging Request" ou "Charging Reply"
    private String bucketsAndValues; // Uma representação dos buckets e valores relevantes
    private String countersAndValues; // Uma representação dos contadores e valores relevantes
    private static String tariffId;
    private static ChargingRequest ChargingRequest;
    private static ChargingReply ChargingReply;
    private static double bucketA;
    private static double bucketB;
    private static double bucketC;
    private static int counterA;
    private static int counterB;
    private static int counterC;
    private static Time counterD;

    /*public CDR(Time timeStamp, String msisdn, ServiceType service, ChargingRequest ChargingRequest ){ //, ChargingReply ChargingReply, int bucketA, int bucketB,int bucketC,String tariffId,int counterA,int counterB,int counterC,Time counterD) {
        this.timeStamp = timeStamp;
        this.msisdn = msisdn;
        this.service = service;
        this.ChargingRequest=ChargingRequest;
        /*this.ChargingReply=ChargingReply;
        this.tariffId = tariffId;
        this.bucketA=bucketA;
        this.bucketB=bucketB;
        this.bucketC=bucketC;
        this.counterA=counterA;
        this.counterB=counterB;
        this.counterC=counterC;
        this.counterD=counterD;
    }*/

    public Time getTimeStamp() {
        return timeStamp;
    }

    public static void setTimeStamp(Time time) {
        timeStamp = time;
    }


    public static String getMsisdn() {
        return msisdn;
    }

    public static void setMsisdn(String _msisdn) {
        msisdn = _msisdn;
    }

    public static ServiceType getService() {
        return service;
    }

    public static void setService(ServiceType _service) {
        service = _service;
    }


    public String getTariffId() {
        return tariffId;
    }

    public static void setTariffId(String _tariffId) {
        tariffId = _tariffId;
    }

    public static double getBucketA() {
        return bucketA/100;
    }

    public static void setBucketA(double _bucketA) {
            bucketA = _bucketA;
    }

    public static double getBucketB() {
        return bucketB/100;
    }

    public static void setBucketB(double _bucketB) {
        bucketB = _bucketB;
    }
    public static double getBucketC() {
        return bucketC/100;
    }

    public static void setBucketC(double _bucketC) {
        bucketC = _bucketC;
    }
    public static double getCounterA() {
        return counterA;
    }

    public static void setCounterA(double counterA) {
        counterA = counterA;
    }

    public static int getCounterB() {
        return counterB;
    }

    public static void setCounterB(int counterB) {
        counterB = counterB;
    }

    public static int getCounterC() {
        return counterC;
    }

    public static void setCounterC(int counterC) {
        counterC = counterC;
    }

    public static Time getCounterD() {
        return counterD;
    }

    public static void setCounterD(Time counterD) {
        counterD = counterD;
    }
}






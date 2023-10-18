import java.sql.Time;

public class BillingAccount {
    private static String msisdn;
    private static double bucketA; // centimos
    private static double bucketB; // centimos
    private static double bucketC; // centimos
    private static int counterA;
    private static int counterB;
    private static int counterC;
    private static Time counterD;
    private static String tarifarioServicoA;
    private static String tarifarioServicoB;

    public BillingAccount(String msisdn, double bucketA, double bucketB, double bucketC, int counterA, int counterB, int counterC, Time counterD, String tarifarioServicoA, String tarifarioServicoB) {
        this.msisdn = msisdn;
        this.bucketA = bucketA;
        this.bucketB = bucketB;
        this.bucketC = bucketC;
        this.counterA = counterA;
        this.counterB = counterB;
        this.counterC = counterC;
        this.counterD = counterD;
        this.tarifarioServicoA = tarifarioServicoA;
        this.tarifarioServicoB = tarifarioServicoB;
    }


    public static String getMsisdn() {
        return msisdn;
    }

    public static double getBucketA() {
        return bucketA;
    }
    public static String subtractBucketA(double custo) {
        custo=custo*100; // passar para centimos

        if(bucketA-custo<0)
         {
             return "CreditLimitReached";         }
         else {
             bucketA = bucketA - custo;
             return "OK";
         }
    }
    public static void addBucketA(double bonus) {
        bonus=bonus*100; // passar para centimos
        bucketA=bucketA-bonus;
    }

    public static double getBucketB() {
        return bucketB;
    }
    public static String subtractBucketB(double custo) {
        custo=custo*100; // passar para centimos
        if(bucketB-custo<0)
        {
            return "CreditLimitReached";
        }
        else {
            bucketB = bucketB - custo;
            return "OK";
        }
    }
    public static void addbucketB(double bonus) {
        bonus=bonus*100; // passar para centimos

        bucketB=bucketB-bonus;
    }
    public static double getBucketC() {
        return bucketC;
    }

    public static String subtractBucketC(double custo) {
        custo=custo*100; // passar para centimos
        if(bucketC-custo<0)
        {
            return "CreditLimitReached";        }
        else {
            bucketC = bucketC - custo;
            return "OK";
        }
    }
    public static void addBucketC(double bonus) {
        bonus=bonus*100; // passar para centimos

        bucketC=bucketC-bonus;
    }

    public static int getCounterA() {
        return counterA;
    }

    public static int getCounterB() {
        return counterB;
    }

    public static int getCounterC() {
        return counterC;
    }
    public static Time getCounterD() {
        return counterD;
    }

    public String getTarifarioServicoA() {
        return tarifarioServicoA;
    }

    public String getTarifarioServicoB() {
        return tarifarioServicoB;
    }
}

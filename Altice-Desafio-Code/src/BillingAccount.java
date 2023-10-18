import java.sql.Time;

public class BillingAccount {
    private static String msisdn;
    static double bucketA; // centimos
    private static double bucketB; // centimos
    private static double bucketC; // centimos
    private static double counterA;
    private static int counterB;
    private static int counterC;
    private static Time counterD;
    private static String tarifarioServicoA;
    private static String tarifarioServicoB;


    public static String getMsisdn() {
        return msisdn;
    }

    public static double getBucketA() {
        return bucketA;
    }
    public static String subtractBucketA(double custo) {
        System.out.println(custo);

        if(bucketA-custo<0)
         {
             return "CreditLimitReached";
         }
         else {
            bucketA = bucketA - custo;
             CDR.setBucketA(bucketA);
            return "OK";
         }

    }
    public static void addBucketA(double bonus) {
        bonus=bonus*100; // passar para centimos
        bucketA=bucketA+bonus;
        CDR.setBucketA(bucketA);
    }

    public static double getBucketB() {
        return bucketB;
    }
    public static String subtractBucketB(double custo) {

        if(bucketB-custo<0)
        {
            return "CreditLimitReached";
        }
        else {
            bucketB = bucketB - custo;
            CDR.setBucketB(bucketB);
            return "OK";
        }
    }
    public static void addBucketB(double bonus) {
        bonus=bonus*100; // passar para centimos
        bucketB=bucketB+bonus;
        CDR.setBucketB(bucketB);

    }
    public static double getBucketC() {
        return bucketC;
    }

    public static String subtractBucketC(double custo) {
        if(bucketC-custo<0)
        {
            return "CreditLimitReached";        }
        else {
            bucketC = bucketC - custo;
            CDR.setBucketC(bucketC);

            return "OK";
        }
    }
    public static void addBucketC(double bonus) {
        bonus=bonus*100; // passar para centimos
        bucketC=bucketC+bonus;
        CDR.setBucketC(bucketC);

    }

    public static double getCounterA() {
        return counterA;
    }
    public static void setCounterA(double _counterA) {
        counterA = _counterA;
        CDR.setCounterA(counterA); // CDR sempre atualizado
    }

    public static int getCounterB() {
        return counterB;
    }
    public static void setCounterD(Time _time){
        counterD=_time;
    }
    public static int getCounterC() {
        return counterC;
    }
    public static void setCounterC() {
         counterC=counterC+1;
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

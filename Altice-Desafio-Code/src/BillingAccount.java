import java.sql.Time;

public class BillingAccount {
    private String msisdn;
    private double bucket1;
    private double bucket2;
    private double bucket3;
    private int counterA;
    private int counterB;
    private int counterC;
    private Time counterD;
    private String tarifarioServicoA;
    private String tarifarioServicoB;

    public BillingAccount(String msisdn, double bucket1, double bucket2, double bucket3, int counterA, int counterB, int counterC, Time counterD, String tarifarioServicoA, String tarifarioServicoB) {
        this.msisdn = msisdn;
        this.bucket1 = bucket1;
        this.bucket2 = bucket2;
        this.bucket3 = bucket3;
        this.counterA = counterA;
        this.counterB = counterB;
        this.counterC = counterC;
        this.counterD = counterD;
        this.tarifarioServicoA = tarifarioServicoA;
        this.tarifarioServicoB = tarifarioServicoB;
    }


    public String getMsisdn() {
        return msisdn;
    }

    public double getBucket1() {
        return bucket1;
    }

    public double getBucket2() {
        return bucket2;
    }

    public double getBucket3() {
        return bucket3;
    }

    public int getCounterA() {
        return counterA;
    }

    public int getCounterB() {
        return counterB;
    }

    public int getCounterC() {
        return counterC;
    }
    public Time getCounterD() {
        return counterD;
    }

    public String getTarifarioServicoA() {
        return tarifarioServicoA;
    }

    public String getTarifarioServicoB() {
        return tarifarioServicoB;
    }
}

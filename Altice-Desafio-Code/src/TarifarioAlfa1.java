
public class TarifarioAlfa1 {
    private boolean subscreveu;
    private int counterA;
    private int bucketC;

    public TarifarioAlfa1() {
        this.subscreveu = false;
        this.counterA = 0;
        this.bucketC = 0;
    }

    public void subscrever() {
        subscreveu = true;
    }
    public void retirarSubscricao() {
        subscreveu = false;
    }



    public boolean isElegivel(ChargingRequest request) {

        if (!subscreveu || request.isRoaming() || counterA >= 100) {
            if(Date.isWeekend(request)) // se for fim de semana não é possivel usar o tarifario Alpha 1
            {
                return false;
            }
        }

        return true;
    }

    public double calcularCusto(ChargingRequest request) {
        double custo = 1.0;

        if (request.isRoaming()) {
            custo = 2.0; // em roaming
        }

        if (counterA > 10) {
            custo -= 0.25; // Desconto se counterA for maior que 10
        }

        if (bucketC > 50) {
            custo -= 0.1; // Desconto se bucketC for maior que 50
        }

        return custo*request.getRsu();
    }
}

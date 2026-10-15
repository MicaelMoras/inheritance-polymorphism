package taxcalculator;

public class Individuals extends TaxPayer {
    private double gastosComSaude;

    public Individuals(String nome, double rendaAnual, double gastosComSaude){
        super(nome, rendaAnual);
        this.gastosComSaude = gastosComSaude;
    }

    public double getGastosComSaude() {
        return gastosComSaude;
    }

    public void setGastosComSaude(double gastosComSaude) {
        this.gastosComSaude = gastosComSaude;
    }

    @Override
    public double tax() {
        double basicTax = ( getRendaAnual() < 20.000) ? getRendaAnual() * 0.15 : getRendaAnual() * 0.25;
        basicTax -= getGastosComSaude() * 0.5;
        if( basicTax < 0){
            return 0.0;
        }
        else{
            return basicTax;
        }

    }
}

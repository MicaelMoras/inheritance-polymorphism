package HherancaePpolimofirmo;

public abstract class TaxPayer {
     private String nome;
     private double rendaAnual;

    public TaxPayer() {

    }

    public TaxPayer(String nome, double rendaAnual) {
        super();
        this.nome = nome;
        this.rendaAnual = rendaAnual;

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getRendaAnual() {
        return rendaAnual;
    }

    public void setRendaAnual(double rendaAnual) {
        this.rendaAnual = rendaAnual;
    }
      public abstract double tax();
}

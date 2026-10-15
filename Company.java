package taxcalculator;

public class Company extends TaxPayer{
   private Integer numeroDoFuncionario;


    public Company(String nome, double rendaAnual, Integer numeroDoFuncionario) {
        super(nome, rendaAnual);
        this.numeroDoFuncionario = numeroDoFuncionario;
    }

    public Integer getNumeroDoFuncionario() {
        return numeroDoFuncionario;
    }

    public void setNumeroDoFuncionario(Integer numeroDoFuncionario) {
        this.numeroDoFuncionario = numeroDoFuncionario;
    }

    @Override
    public double tax() {
        if(numeroDoFuncionario > 10){
            return getRendaAnual() * 0.14;
        }
        else{
        return getRendaAnual() * 0.16;
    }
  }
}

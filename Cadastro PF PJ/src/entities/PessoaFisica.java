package entities;

public class PessoaFisica extends Contribuinte{
    private double gastoComSaude;

    public PessoaFisica(String nome, double rendaAnual, double gastoComSaude){
        super(nome, rendaAnual);
        this.gastoComSaude = gastoComSaude;
    }

    public double getGastoComSaude() {
        return gastoComSaude;
    }

    @Override
    public double impostoAPagar() {
        double imposto;

        if(getRendaAnual() < 20000.00){
            imposto = getRendaAnual() * 0.15;
        }else{
            imposto = getRendaAnual() * 0.25;
        }

        imposto -= gastoComSaude * 0.5;

        return imposto;
    }
}

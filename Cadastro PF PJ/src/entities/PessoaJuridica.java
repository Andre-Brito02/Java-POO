package entities;

public class PessoaJuridica extends Contribuinte{
    private int qtdFuncionarios;

    public PessoaJuridica(String nome, double rendaAnual, int qtdFuncionarios){
        super(nome, rendaAnual);
        this.qtdFuncionarios = qtdFuncionarios;
    }

    public int getQtdFuncionarios() {
        return qtdFuncionarios;
    }

    @Override
    public double impostoAPagar() {
        double imposto;

        if(qtdFuncionarios > 10){
            imposto = getRendaAnual() * 0.14;
        }else{
            imposto = getRendaAnual() * 0.16;
        }

        return imposto;
    }
}

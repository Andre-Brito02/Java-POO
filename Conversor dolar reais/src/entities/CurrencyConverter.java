package entities;

public class CurrencyConverter {
    private double cotacaoDolar;
    private double qtdDolarComprado;
    public static double valorIOF = 0.06;

    public CurrencyConverter(double cotacaoDolar, double qtdDolarComprado){
        this.cotacaoDolar = cotacaoDolar;
        this.qtdDolarComprado = qtdDolarComprado;
    }

    public double valorAPagar(){
        return (qtdDolarComprado + (qtdDolarComprado*valorIOF)) * cotacaoDolar;
    }

    public String toString(){
        return "Amount to be paid in reais = R$ " + "%.2f".formatted(valorAPagar());
    }
}

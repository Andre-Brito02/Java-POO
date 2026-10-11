package application;
import entities.CurrencyConverter;

public class conversorDolarEmReais {
    static void main() {
        double cotacaoDolar = Double.parseDouble(IO.readln("What is the dollar price? "));
        double qtdDolarComprado = Double.parseDouble(IO.readln("How many dollars will be bought? "));
        CurrencyConverter cc = new CurrencyConverter(cotacaoDolar, qtdDolarComprado);
        IO.println(cc);
    }
}

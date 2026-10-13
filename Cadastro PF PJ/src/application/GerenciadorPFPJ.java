package application;
import java.util.List;
import java.util.ArrayList;
import java.util.Locale;

import entities.Contribuinte;
import entities.PessoaFisica;
import entities.PessoaJuridica;

public class GerenciadorPFPJ {
    static void main() {
        List<Contribuinte> contribuintes = new ArrayList<>();
        double somaTotalImposto = 0.0;

        int qtdContribuintes = Integer.parseInt(IO.readln("Informe a quantidade de contribuintes: "));

        for(int i = 1; i <= qtdContribuintes; i++){
            IO.println("Dados do contribuinte #%d:".formatted(i));
            char escolha = IO.readln("Individual ou companhia (i/c)? ").toLowerCase(Locale.ROOT).charAt(0);
            String nome = IO.readln("Nome: ");
            double rendaAnual = Double.parseDouble(IO.readln("Renda anual: "));

            switch (escolha){
                case 'i' -> {
                    double gastoComSaude = Double.parseDouble(IO.readln("Gasto com saúde: "));
                    contribuintes.add(new PessoaFisica(nome, rendaAnual, gastoComSaude));
                }

                case 'c' -> {
                    int qtdFuncionarios = Integer.parseInt(IO.readln("Quantidade de funcionários: "));
                    contribuintes.add(new PessoaJuridica(nome, rendaAnual, qtdFuncionarios));
                }

                default -> IO.println("Opção errada, tente novamente!");
            }
        }

        IO.println("\nImposto pago: ");
        for(Contribuinte c : contribuintes){
            somaTotalImposto += c.impostoAPagar();
            IO.println("%s: $ %.2f".formatted(c.getNome(), c.impostoAPagar()));
        }

        IO.println("\nTotal de imposto: $ %.2f".formatted(somaTotalImposto));
    }
}

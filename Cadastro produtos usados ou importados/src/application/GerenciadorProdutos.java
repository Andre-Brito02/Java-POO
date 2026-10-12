package application;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class GerenciadorProdutos {
    static void main() {
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        List<Product> produtos = new ArrayList<>();
        int qtd = Integer.parseInt(IO.readln("Enter the number of products: "));

        for(int i = 0; i < qtd; i++){
            IO.println("Product #%d data: ".formatted(i+1));
            char choice = IO.readln("Common, used or imported (c/u/i)? ").toLowerCase(Locale.ROOT).charAt(0);

            String name = IO.readln("Name: ");
            double price = Double.parseDouble(IO.readln("Price: "));

            switch (choice){
                case 'c'-> produtos.add(new Product(name, price));
                case 'u' -> {
                    String data = IO.readln("Manufacture date (DD/MM/YYYY): ");
                    LocalDate manufacturedData = LocalDate.parse(data, formatador);
                    produtos.add(new UsedProduct(name, price, manufacturedData));
                }
                case 'i' -> {
                     double customFee = Double.parseDouble(IO.readln("Custom fee: "));
                    produtos.add(new ImportedProduct(name, price, customFee));
                }
                default -> IO.println("Escolha errada, tente novamente!");
            }
        }

        IO.println("\nPRICE TAGS:");
        for(Product prod: produtos){
            IO.println(prod.priceTag());
        }
    }
}

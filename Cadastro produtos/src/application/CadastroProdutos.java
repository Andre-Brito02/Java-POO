package application;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class CadastroProdutos {
    static void main() {
        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        IO.println("Enter client data:");
        String name = IO.readln("Name: ");
        String email = IO.readln("Email: ");
        String bd = IO.readln("Birth date (dd/MM/yyyy): ");
        LocalDate birthDate = LocalDate.parse(bd, formatDate);
        Client client = new Client(name, email, birthDate);

        IO.println("Enter order data: ");
        String status = IO.readln("Status: ").toUpperCase(Locale.ROOT);
        Order order = new Order(LocalDateTime.now(), OrderStatus.valueOf(status), client);
        int qtd = Integer.parseInt(IO.readln("How many items to this order? "));

        for(int i = 0; i < qtd; i++){
            IO.println("Enter #%d item data: ".formatted(i+1));
            String productName = IO.readln("Product Name: ");
            double productPrice = Double.parseDouble(IO.readln("Product Price: "));
            Product product = new Product(productName, productPrice);
            int productQuantity = Integer.parseInt(IO.readln("Quantity: "));
            OrderItem orderItem = new OrderItem(productQuantity, product.getPrice(), product);

            order.addItem(orderItem);
        }

        IO.println("\nORDER SUMMARY:");
        IO.println(order);
    }
}

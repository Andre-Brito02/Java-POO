package application;
import entities.ProductsStock;

public class EstoqueDeProdutos {
    static void main() {
        IO.println("Enter product data:");
        String name = IO.readln("Name: ");
        double price = Double.parseDouble(IO.readln("Price: "));
        int quantity = Integer.parseInt(IO.readln("Quantity: "));

        ProductsStock product = new ProductsStock(name, price, quantity);

        IO.println("\nProduct data: " + product + "\n");

        quantity = Integer.parseInt(IO.readln("Enter the number of products to be added in stock: "));
        product.addProducts((quantity));
        IO.println("\nUpdated data: " + product + "\n");

        quantity = Integer.parseInt(IO.readln("Enter the number of products to be removed from stock: "));
        product.removeProducts((quantity));
        IO.println("\nUpdated data: " + product + "\n");
    }
}

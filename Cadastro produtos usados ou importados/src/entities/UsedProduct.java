package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UsedProduct extends Product{
    DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private LocalDate manufactureDate;

    public UsedProduct(String name, double price, LocalDate manufactureDate){
        super(name, price);
        this.manufactureDate = manufactureDate;
    }

    public LocalDate getManufactureDate(){
        return manufactureDate;
    }

    @Override
    public String priceTag() {
        String data = manufactureDate.format(formatador);
        return "%s (used) $ %.2f (Manufacture date: %s)".formatted(getName(), getPrice(), data);
    }
}

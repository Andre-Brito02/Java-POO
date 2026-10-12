package entities;

public class ImportedProduct extends Product{
    private double customsFee;

    public ImportedProduct(String name, double price, double customsFee){
        super(name, price);
        this.customsFee = customsFee;
    }

    public double getCustomsFee(){
        return customsFee;
    }

    public double totalPrice(){
        return getPrice() + customsFee;
    }

    @Override
    public String priceTag() {
        return "%s $ %.2f (Customs fee: $ %.2f)".formatted(getName(), totalPrice(), customsFee);
    }
}

package entities;

import entities.enums.OrderStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order {
    DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("(dd/MM/yyyy)");
    DateTimeFormatter formatDateHour = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    private LocalDateTime moment;
    private OrderStatus status;

    private Client client;
    private List<OrderItem> listaDeItens = new ArrayList<>();

    public Order(LocalDateTime moment, OrderStatus status, Client client){
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public LocalDateTime getMoment() {
        return moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public Client getClient() {
        return client;
    }

    public List<OrderItem> getListaDeItens() {
        return listaDeItens;
    }

    public void addItem(OrderItem item){
        listaDeItens.add(item);
    }

    public void removeItem(OrderItem item){
        listaDeItens.remove(item);
    }

    public double total(){
        double sum = 0.0;
        for(OrderItem o: listaDeItens){
            sum += o.subTotal();
        }
        return sum;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order moment: ").append(moment.format(formatDateHour)).append("\n");
        sb.append("Order status: ").append(status).append("\n");
        sb.append("Client: ").append(client.getName()).append(" ").append(client.getBirthDate().format(formatDate)).append(" - ").append(client.getEmail()).append("\n");
        sb.append("Order items:\n");

        for (OrderItem item : listaDeItens) {
            sb.append(item.getProduct().getName())
                    .append(", $")
                    .append(String.format("%.2f", item.getPrice()))
                    .append(", Quantity: ")
                    .append(item.getQuantity())
                    .append(", Subtotal: $")
                    .append(String.format("%.2f", item.subTotal()))
                    .append("\n");
        }

        sb.append("Total price: $").append(String.format("%.2f", total()));
        return sb.toString();
    }
}

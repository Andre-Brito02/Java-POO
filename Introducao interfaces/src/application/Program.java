package application;

import model.entities.CarRental;
import model.entities.Vehicle;
import model.services.BrazilTaxService;
import model.services.RentalService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Program {
    static void main() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        IO.println("Entre com os dados do aluguel");
        String carModel = IO.readln("Modelo do carro: ");
        String stringDataStart = IO.readln("Retirada (dd/MM/yyyy HH:mm): ");
        LocalDateTime start = LocalDateTime.parse(stringDataStart, fmt);
        String stringDataFinish = IO.readln("Retorno (dd/MM/yyyy HH:mm): ");
        LocalDateTime finish = LocalDateTime.parse(stringDataFinish, fmt);

        CarRental cr = new CarRental(start, finish, new Vehicle(carModel));

        double pricePerHour = Double.parseDouble(IO.readln("Entre com o preço por hora: "));
        double pricePerDay = Double.parseDouble(IO.readln("Enter com o preço por dia: "));

        RentalService rentalService = new RentalService(pricePerHour, pricePerDay, new BrazilTaxService());

        rentalService.processInvoice(cr);

        IO.println("Fatura");
        IO.println("Pagamento básico: %.2f".formatted(cr.getInvoice().getBasicPayment()));
        IO.println("Imposto: %.2f".formatted(cr.getInvoice().getTax()) );
        IO.println("Pagamento total: %.2f".formatted(cr.getInvoice().getTotalPayment()));
    }
}

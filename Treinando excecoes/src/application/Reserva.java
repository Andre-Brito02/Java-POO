package application;

import model.entities.Reservation;
import model.exceptions.DomainException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Reserva {
    static void main() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try{
            int roomNumber = Integer.parseInt(IO.readln("Room number: "));
            String dataCheckin = IO.readln("Check-in date (dd/MM/yyyy): ");
            LocalDate checkIn = LocalDate.parse(dataCheckin, formato);
            String dataCheckout = IO.readln("Check-out date (dd/MM/yyyy): ");
            LocalDate checkOut = LocalDate.parse(dataCheckout, formato);

            Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
            IO.println("Reservation: " + reservation);

            IO.println("\nEnter data to update the reservation:");
            dataCheckin = IO.readln("Check-in date (dd/MM/yyyy): ");
            checkIn = LocalDate.parse(dataCheckin, formato);
            dataCheckout = IO.readln("Check-out date (dd/MM/yyyy): ");
            checkOut = LocalDate.parse(dataCheckout, formato);

            reservation.updateDates(checkIn, checkOut);
            IO.println("Reservation: " + reservation);
        }
        catch (DomainException e){
            IO.println("Error in resevation: " + e.getMessage());
        }
        catch (RuntimeException e){
            IO.println("Unexpected Error");
        }

    }//main
}//reserva

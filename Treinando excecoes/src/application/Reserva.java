package application;

import model.entities.Reservation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Reserva {
    static void main() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        int roomNumber = Integer.parseInt(IO.readln("Room number: "));
        String dataCheckin = IO.readln("Check-in date (dd/MM/yyyy): ");
        LocalDate checkIn = LocalDate.parse(dataCheckin, formato);
        String dataCheckout = IO.readln("Check-out date (dd/MM/yyyy): ");
        LocalDate checkOut = LocalDate.parse(dataCheckout, formato);

        if(!checkOut.isAfter(checkIn)){
            IO.println("Error in reservation: Check-out date must be after chek-in date");
        }else{
            Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
            IO.println("Reservation: " + reservation);

            IO.println("\nEnter data to update the reservation:");
            dataCheckin = IO.readln("Check-in date (dd/MM/yyyy): ");
            checkIn = LocalDate.parse(dataCheckin, formato);
            dataCheckout = IO.readln("Check-out date (dd/MM/yyyy): ");
            checkOut = LocalDate.parse(dataCheckout, formato);

            String error = reservation.updateDates(checkIn, checkOut);
            if(error != null){
                IO.println("Error in reservation: %s".formatted(error));
            }else{
                IO.println("Reservation: " + reservation);
            }

        }//else
    }//main
}//reserva

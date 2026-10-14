package model.entities;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Reservation {
    private int roomNumber;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private static DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Reservation(int roomNumber, LocalDate checkIn, LocalDate checkOut){
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public int getRoomNumber(){
        return roomNumber;
    }

    public LocalDate getCheckIn(){
        return checkIn;
    }

    public LocalDate getCheckOut(){
        return checkOut;
    }

    public int duration(){
        Period diff = Period.between(checkIn, checkOut);
        return diff.getDays();
    }

    public void updateDates(LocalDate checkIn, LocalDate checkOut){
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    @Override
    public String toString() {
        return "Room %d, check-in: %s, check-out: %s, %d nights".formatted(roomNumber, checkIn.format(formato), checkOut.format(formato), duration());
    }
}

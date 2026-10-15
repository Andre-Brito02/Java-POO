package model.entities;

import model.exceptions.DomainException;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Reservation {
    private int roomNumber;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private static DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Reservation(int roomNumber, LocalDate checkIn, LocalDate checkOut) {
        if(!checkOut.isAfter(checkIn)){
            throw new DomainException("Check-out date must be after chek-in date");
        }
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

    public void updateDates(LocalDate checkIn, LocalDate checkOut) {
        LocalDate now = LocalDate.now();
        if(checkIn.isBefore(now) || checkOut.isBefore(now)){
            throw new DomainException("Reservation dates for update must be future dates");
        }

        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    @Override
    public String toString() {
        return "Room %d, check-in: %s, check-out: %s, %d nights".formatted(roomNumber, checkIn.format(formato), checkOut.format(formato), duration());
    }
}

package model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Contract {
    private int number;
    private LocalDate date;
    private double totalValue;
    private List<Installment> installment = new ArrayList<>();

    public Contract(int number, LocalDate date, double totalValue) {
        this.number = number;
        this.date = date;
        this.totalValue = totalValue;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }

    public List<Installment> getInstallment() {
        return installment;
    }

    public void addInstallment(Installment inst){
        installment.add(inst);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        for(Installment inst: installment){
            sb.append(inst.getDueDate().format(fmt)).append(" - ").append("%.2f".formatted(inst.getAmount())).append(System.lineSeparator());
        }

        return sb.toString();
    }
}

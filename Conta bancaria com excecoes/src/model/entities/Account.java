package model.entities;

import model.exceptions.DomainException;

public class Account {
    private int number;
    private String holder;
    private double balance;
    private double withdrawLimit;

    public Account(int number, String holder, double balance, double withdrawLimit){
        if (number <= 0){
            throw new DomainException("Account number must be greater than zero");
        }

        if(holder == null || holder.isBlank()){
            throw new DomainException("Account holder cannot be empty");
        }

        if(balance < 0){
            throw new DomainException("Initial balance cannot be negative");
        }

        if(withdrawLimit < 0){
            throw new DomainException("Withdraw limit cannot be negative");
        }

        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    public int getNumber() {
        return number;
    }

    public String getHolder() {
        return holder;
    }

    public double getBalance() {
        return balance;
    }

    public double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void deposit(double amount){
        if(amount <= 0){
            throw new DomainException("Withdraw amount must be greater than zero");
        }
        this.balance += amount;
    }

    public void withdraw(double amount){
        if(amount > withdrawLimit){
            throw new DomainException("The amount exceeds withdraw limit");
        }

        if (amount > balance){
            throw new DomainException("Not enough balance");
        }
        this.balance -= amount;
    }

    @Override
    public String toString(){
        return "Holder %s, Number Account: %d, balance: %.2f".formatted(holder, number, balance);
    }
}

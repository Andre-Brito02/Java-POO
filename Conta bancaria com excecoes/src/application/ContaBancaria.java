package application;

import model.entities.Account;
import model.exceptions.DomainException;

public class ContaBancaria {
    static void main() {
        Account acc = null;

        // Garante que a conta só seja criada com dados válidos
        while (acc == null) {
            try {
                IO.println("Enter account data");
                int number = Integer.parseInt(IO.readln("Number: "));
                String holder = IO.readln("Holder: ");
                double balance = Double.parseDouble(IO.readln("Initial balance: "));
                double withdrawLimit = Double.parseDouble(IO.readln("Withdraw limit: "));

                acc = new Account(number, holder, balance, withdrawLimit);
            } catch (DomainException e) {
                IO.println("Account creation error: " + e.getMessage() + "\nPlease try again.\n");
            } catch (NumberFormatException e) {
                IO.println("Format error: Please enter valid numeric values.\n");
            }
        }

        boolean running = true;
        while (running) {
            optionsMenu();
            try {
                int choice = Integer.parseInt(IO.readln("Which option would you like to choose? "));
                switch (choice) {
                    case 1 -> {
                        double amount = Double.parseDouble(IO.readln("\nEnter amount for deposit: "));
                        acc.deposit(amount);
                    }
                    case 2 -> {
                        double amount = Double.parseDouble(IO.readln("\nEnter amount for withdraw: "));
                        acc.withdraw(amount);
                    }
                    case 3 -> {
                        IO.println("\n" + acc);
                    }
                    case 0 -> {
                        IO.println("\nExiting program. Thanks for using our service!");
                        running = false;
                    }
                    default -> IO.println("\nInvalid option! Please choose a number between 0 and 3.");
                }
            } catch (DomainException e) {
                IO.println("Operation error: " + e.getMessage() + "\nTry again");
            } catch (NumberFormatException e) {
                IO.println("Format error: Please enter a valid number.\nTry again");
            }
        }
    }

    static void optionsMenu() {
        IO.println("\nOptions menu: ");
        IO.println("1 - Deposit");
        IO.println("2 - Withdraw");
        IO.println("3 - User data");
        IO.println("0 - Exit");
    }
}
package application;
import entities.Employee;

public class Funcionario {
    static void main() {
        String name = IO.readln("Name: ");
        double grossSalary = Double.parseDouble(IO.readln("Gross Salary: "));
        double tax = Double.parseDouble(IO.readln("Tax: "));
        Employee emp = new Employee(name, grossSalary, tax);

        IO.println("Employee: " + emp);

        double percentage = Double.parseDouble(IO.readln("Which percentage to increase salary? "));
        emp.increaseSalary(percentage);

        IO.println("Updated data: " + emp);
    }
}

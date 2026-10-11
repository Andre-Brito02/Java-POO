package entities;

public class Employees {
    private int id;
    private String name;
    private double salary;

    public Employees(int id, String name, double salary){
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void increaseSalary(double percentage){
        this.salary += this.salary * percentage / 100.0;
    }

    public String toString(){
        return id + ", " + name + ", %.2f".formatted(salary);
    }
}

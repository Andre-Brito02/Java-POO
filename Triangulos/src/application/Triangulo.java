package application;
import entities.Triangle;

public class Triangulo {
    static void main() {
        IO.println("Enter the measures of triangle x: ");
        double a = Double.parseDouble(IO.readln());
        double b = Double.parseDouble(IO.readln());
        double c = Double.parseDouble(IO.readln());
        Triangle x = new Triangle(a, b, c);

        IO.println("Enter the measures of triangle y: ");
        a = Double.parseDouble(IO.readln());
        b = Double.parseDouble(IO.readln());
        c = Double.parseDouble(IO.readln());
        Triangle y = new Triangle(a, b, c);

        double areaX = x.area();
        double areaY = y.area();

        IO.println("Triangle X area: %.4f".formatted(areaX));
        IO.println("Triangle Y area: %.4f".formatted(areaY));

        if (areaX > areaY) {
            IO.println("Larger Area: X");
        } else {
            IO.println("Larger Area: Y");
        }
    }
}
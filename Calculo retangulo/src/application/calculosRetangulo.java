package application;
import entities.Rectangle;

public class calculosRetangulo {
    static void main() {
        IO.println("Enter rectangle width and height:");
        double width = Double.parseDouble(IO.readln("Width: "));
        double height = Double.parseDouble(IO.readln("Height: "));
        Rectangle rec = new Rectangle(width, height);
        IO.println(rec);
    }
}

package entities;

public class Rectangle {
    private double width;
    private double height;

    public Rectangle(double width, double height){
        this.width = width;
        this.height = height;
    }

    public double areaRectangle(){
        return width*height;
    }

    public double perimeterRectangle(){
        return 2*(width+height);
    }

    public double diagonalRectangle(){
        return Math.sqrt(Math.pow(width, 2) + Math.pow(height, 2));
    }

    public String toString(){
        return "AREA = " + "%.2f".formatted(areaRectangle()) +
                "\nPERIMETER = " + "%.2f".formatted(perimeterRectangle()) +
                "\nDIAGONAL = " + "%.2f".formatted(diagonalRectangle());
    }
}

package entities;

public class Student {
    private String name;
    private double grade1;
    private double grade2;
    private double grade3;

    public Student(String name, double grade1, double grade2, double grade3){
        this.name = name;
        this.grade1 = grade1;
        this.grade2 = grade2;
        this.grade3 = grade3;
    }

    public double final_grade(){
        return (grade1+grade2+grade3)/3;
    }

    public String result(){
        return (final_grade() >= 60.0) ? "PASS" : "FAILED\nMISSING " +
                "%.2f".formatted(60.0-final_grade()) + " POINTS";
    }

    public String toString(){
        return "FINAL GRADE = " + "%.2f".formatted(final_grade()) +
                "\n" + result();
    }
}

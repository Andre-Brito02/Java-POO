package application;
import entities.Student;

public class notasAluno {
    static void main() {
        String name = IO.readln("Name: ");
        double grade1 = Double.parseDouble(IO.readln("Grade 1: "));
        double grade2 = Double.parseDouble(IO.readln("Grade 2: "));
        double grade3 = Double.parseDouble(IO.readln("Grade 3: "));
        Student std = new Student(name, grade1, grade2, grade3);

        IO.println(std);
    }
}

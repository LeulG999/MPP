package Lab5.prob3;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Shape> shapes = new ArrayList<>();

        shapes.add(new Rectangle(4, 5));
        shapes.add(new Triangle(3, 6));
        shapes.add(new Circle(2));
        shapes.add(new Rectangle(2, 3));

        double sum = 0;

        for (Shape s : shapes) {
            sum += s.computeArea();
        }

        System.out.println("Sum of Areas = " + sum);
    }
}

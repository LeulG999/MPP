package Lab3.prob3;

public class Circle{
    private double radius;
    Circle(double radius){
        this.radius=radius;
    }
    public double getRadius() {
        return radius;
    }
    public double computeArea(){
        return radius*radius*Math.PI;
    }
}

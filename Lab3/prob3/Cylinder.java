package Lab3.prob3;

public class Cylinder  {
    private double height;
    private Circle circle;
    Cylinder(double radius, double height){
        this.circle=new Circle(radius);
        this.height=height;
    }
    public double computeVolume(){
        return circle.computeArea()*height;
    }
}


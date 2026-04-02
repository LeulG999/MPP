package Lab3.prob4;

public class Condo extends Property{
    private int numberOfFloor;
    public Condo(int numberOfFloor){
        this.numberOfFloor=numberOfFloor;
    }

    public int getNumberOfFloor() {
        return numberOfFloor;
    }
    @Override
    public double computeRent(){
        return getNumberOfFloor()*400;
    }
}

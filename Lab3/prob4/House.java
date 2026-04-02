package Lab3.prob4;

public class House extends Property {
   private double lotSize;
    public House(double lotSize){
        this.lotSize=lotSize;
    }
    public double getLotSize() {
        return lotSize;
    }
    @Override
    public double computeRent() {
        return getLotSize()*0.1;
    }
}

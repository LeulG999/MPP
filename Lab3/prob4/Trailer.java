package Lab3.prob4;

public class Trailer extends Property {
    private String trailerParkAddress;
    public Trailer(String trailerParkAddress){
     this.trailerParkAddress=trailerParkAddress;
    }
    @Override
    public double computeRent(){
        return 500;
    }
}

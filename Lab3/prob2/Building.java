package Lab3.prob2;
import java.util.ArrayList;
import java.util.List;
public class Building {
    private List<Apartment> apartments;
    private int maintenanceCost;
    Building(int maintenanceCost){
        apartments=new ArrayList<>();
        this.maintenanceCost=maintenanceCost;
    }
    public void addApartment(Apartment apartment){
          apartments.add(apartment);
    }
    public int calculateProfit(){
        int sum=0;
        for(Apartment a:apartments){
            sum+=a.getRent();
        }
        return sum-maintenanceCost;
    }
}

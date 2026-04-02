package Lab3.prob2;

import java.util.ArrayList;
import java.util.List;

public class LandlordInfo {
    private List<Building> buildings;

    LandlordInfo(){
     buildings=new ArrayList<>();
    }
    public void addBuilding(Building building){
        buildings.add(building);
    }
    public int calcProfits(){
        int sum=0;
        for(Building b:buildings){
            sum+=b.calculateProfit();
        }
        return sum;
    }
}

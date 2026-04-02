package Lab3.prob4;

public class Driver {

	public static void main(String[] args) {

		Property[] propertyList = { new House(9000), new Condo(2), new Trailer("MIU-Parking") };
		double totalRent = Admin.computeTotalRent(propertyList);
		System.out.println(totalRent);
	}

}

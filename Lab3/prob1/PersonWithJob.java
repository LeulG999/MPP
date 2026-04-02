package Lab3.prob1;

public class PersonWithJob {
	
	private double salary;
	private Person person;
	
	public double getSalary() {
		return salary;
	}
	PersonWithJob(Person person, double s) {
		this.person=person;
		salary = s;
	}
	
	@Override
	public boolean equals(Object aPerson) {
		if(aPerson == null) return false; 
		if(!(aPerson instanceof PersonWithJob)) return false;
		PersonWithJob p = (PersonWithJob)aPerson;
		boolean isEqual = this.person.equals(p.person) &&
				this.getSalary()==p.getSalary();
		return isEqual;
	}
	public static void main(String[] args) {
		Person p1=new Person("Leul");
		Person p2=new Person("Leul");
		PersonWithJob pw2 = new PersonWithJob(p1,180000);
		PersonWithJob pw1 = new PersonWithJob(p2, 180000);

		//As PersonsWithJobs, p1 should be equal to p2
		System.out.println("p1.equals(p2)? " + p1.equals(p2));
		System.out.println("p2.equals(p1)? " + p2.equals(p1));
	}


}

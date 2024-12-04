package car;

public class Car {
	private String make;
	private String model;
	private int year;
	private int mileage;
	
	
	//Constructor
	public Car (String make, String model, int year, int mileage) {
		this.make = make;
		this.model = model;
		this.year = year;
		this.mileage = mileage;
	}
	
	public void displayCarDetails() {
		System.out.println("Make: " + this.make);
		System.out.println("Model: " + this.model);
		System.out.println("Year: " + this.year);
		System.out.println("Mileage: "+ this.mileage);
	}
	
	public void addMileage(int miles) {
		this.mileage += miles;
		System.out.println("New mileage is: " + mileage);
		
	}
	
	public static double calculateDepreciation(int year, int currentYear) {
		int age = currentYear - year;
		double depreciationRate = 0.15;
		double depreciation = 1 - Math.pow(1 - depreciationRate, age);
		return depreciation * 100;
		
	}

}

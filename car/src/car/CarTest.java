package car;
import java.util.Scanner;

public class CarTest {
	
	public static void main(String args[]) {
		Car car1 = new Car("Toyota", "Camry", 2012, 60_000);
		
		car1.displayCarDetails();
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Miles driven?: ");
		int miles = input.nextInt();
		car1.addMileage(miles);
		
		System.out.print("Enter car year: ");
		int carYear = input.nextInt();
		System.out.print("Enter current year: ");
		int currentYear = input.nextInt();
		double depreciation = Car.calculateDepreciation(carYear, currentYear);
		System.out.println("Car value has depreciated " + String.format("%.2f", depreciation) + "%.");
		input.close();
		}

}

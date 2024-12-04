package countriesList;
import java.util.ArrayList;
import java.util.Scanner;

public class CountriesList {
	ArrayList<String> countries = new ArrayList<>();
	int menuOption;
	Scanner input = new Scanner(System.in);
	
	
	public void displayWelcomeMessage() {
		System.out.println("Country List Manager\n");
	}
	
	public void displayMenu() {
		System.out.println("COMMAND MENU");
		System.out.println("1 - List countries");
		System.out.println("2 - Add a country");
		System.out.println("3 - Exit\n");
	}
	
	public int getMenuOption() {
		
		System.out.print("Enter menu number: ");
		menuOption = input.nextInt();
		input.nextLine();
		return menuOption;
	}
	
	public boolean checkForCountry(String country) {
		if (countries.contains(country)) {
			System.out.println("Country " + country + " already exists in list.");
			return true;
		}else {
			return false;
		}
	}
	
	public void addCountry() {
		
		System.out.print("Enter country: ");
		String countryToAdd = input.nextLine();
		if (!checkForCountry(countryToAdd)) {
			countries.add(countryToAdd);
			System.out.println("Country " + countryToAdd + " has beeen added to the list.");
		}
	}
	
	public void listCountries() {
		if (countries.size() == 0) {
			System.out.println("No countries in the list.");
		}else {
			for (String value : countries) {
				System.out.println(value);
			}
		}
		
	}
	public static void main(String[] args) {
		CountriesList countryList = new CountriesList();
		
		countryList.displayWelcomeMessage();
		countryList.displayMenu();
		
		
		while (countryList.menuOption != 3) {
			countryList.getMenuOption();
			if (countryList.menuOption == 3) {
				System.out.println("Goodbye!");
				break;
			}else if (countryList.menuOption == 1){
				countryList.listCountries();
			}else if (countryList.menuOption == 2) {
				countryList.addCountry();
			}else {
				System.out.println("Invalid entry, please try again.");
			}
		}
		countryList.input.close();
		
	}
	

}

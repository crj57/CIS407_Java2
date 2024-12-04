package courseProject;

public class Customer {
	private String customerID;
	private String customerSSN;
	private String lastName;
	private String firstName;
	private String customerStreet;
	private String customerCity;
	private String customerState;
	private String customerZip;
	private String customerPhone;
	
	public void setID(String id) {
		this.customerID = id;
	
	}
	
	public String getID() {
		return this.customerID;
	}
	
	public void setSSN(String ssn) {
		this.customerSSN = ssn;
		
	}
	
	public String getSSN() {
		return this.customerSSN;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public void setStreet(String street) {
		this.customerStreet = street;
	}
	
	public String getStreet() {
		return this.customerStreet;
	}
	
	public void setCity(String city) {
		this.customerCity = city;
	}
	
	public String getCity() {
		return this.customerCity;
	}
	
	public void setState(String state) {
		this.customerState = state;
	}
	
	public String getState() {
		return this.customerState;
	}
	
	public void setZip(String zip) {
		this.customerZip = zip;
	}
	
	public String getZip() {
		return this.customerZip;
	}
	
	public void setPhone(String phone) {
		this.customerPhone = phone;
	}
	
	public String getPhone() {
		return this.customerPhone;
	}
	
	public String toString() {
		return "Customer ID: " + customerID + 
				"\nCustomer SSN: " + customerSSN + 
				"\nCustomer Name: " + firstName + " " + lastName + 
				"\nCustomer Address: " + customerStreet + " " + 
										customerCity + ", " + 
										customerState + " " +
										customerZip +
				"\nCustomer Phone: " + customerPhone;
		
	}
}

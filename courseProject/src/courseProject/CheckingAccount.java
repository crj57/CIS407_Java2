package courseProject;
import java.util.Date; 

public class CheckingAccount extends Account {
	double tAmount;
	double interestRate = 0.02;
	
	@Override
	public void addInterest() {
		balance = balance * (1 + interestRate);
	}
	
	@Override
	public void withdrawal(double amount) {
		tAmount = amount; 
		serviceFee = 0.25;
		overdraftFee = 0;
		
		balance = (balance - tAmount) - serviceFee; 
		if (balance < 0) {
			overdraftFee = 30.00;
			balance = balance - overdraftFee;
		} 
		
	}

	@Override
	public void deposit(double amount) {
		tAmount = amount;
		serviceFee = 0.25;
		overdraftFee = 0;
		balance = balance + tAmount - serviceFee;
		
	}
	@Override
	public String printTransaction() {
		return "Transaction date: " + tDate + 
				"\nTransaction type: " + tType + 
				"\nTransaction amount: " + tAmount +
				"\nTransaction fees: " + (serviceFee + overdraftFee);
				
	}
	

}

package courseProject;

public class SavingsAccount extends Account {
	double tAmount;
	double interestRate = 0.05; 

	@Override
	public void addInterest() {
		balance = balance * (1 + interestRate);
	}
	
	@Override
	public void withdrawal(double amount) {
		double originalBalance = balance; 
		tAmount = amount; 
		serviceFee = 0.25; 
		
		balance = (balance - tAmount) - serviceFee; 
		if (balance < 0) {
			balance = originalBalance; 
			throw new ArithmeticException();
		}
	}
	@Override
	public void deposit(double amount) {
		tAmount = amount;
		serviceFee = 0.25;
		
		balance = balance + tAmount - serviceFee;
		
	} 
	@Override
	public String printTransaction() {
		return "Transaction date: " + tDate + 
				"\nTransaction type: " + tType + 
				"\nTransaction amount: " + tAmount +
				"\nTransaction fees: " + (serviceFee);
				
	}

}

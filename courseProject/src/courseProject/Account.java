package courseProject;

import java.util.Date;

public abstract class Account {
	protected String acctNum;
	protected String acctType;
	protected double serviceFee;
	protected double interestRate;
	protected double overdraftFee = 0;
	protected double balance = 0;
	protected Date tDate = new Date(); 
	protected String tType; 
	
	public void setDate(Date date) {
		this.tDate = date;
	}
	
	public Date getDate() {
		return this.tDate;
	}
	
	public void setTType(String type) {
		this.tType = type;
	}
	
	public String getTType() {
		return this.tType;
	}
	
	public void setAcctNum(String acctNum) {
		this.acctNum = acctNum;
	
	}
	
	public String getAcctNum() {
		return this.acctNum;
	}
	
	public void setAcctType(String type) {
		this.acctType = type;
		
	}
	
	public String getAcctType() {
		return this.acctType;
	}
	
	public void setServiceFee(double fee) {
		this.serviceFee = fee;
	}
	
	public double getServiceFee() {
		return this.serviceFee;
	}
	
	public void setInterestRate(double rate) {
		this.interestRate = rate;
	}
	
	public double getInterestRate() {
		return this.interestRate;
	}
	
	public void setOverdraftFee(double fee) {
		this.overdraftFee = fee;
	}
	
	public double getOverDraftFee() {
		return this.overdraftFee;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public double getBalance() {
		return this.balance;
	}

	
	public String toString() {
		return "Account Number: " + acctNum + 
				"\nAccount Type: " + acctType + 
				//"\nService Fee: " + String.format("$%.2f", serviceFee) + 
				//"\nInterest Rate: " + interestRate + "%" + 
				//"\nOverdraft Fee: " + String.format("$%.2f",overdraftFee) +
				"\nBalance: " + String.format("$%.2f",balance);
		
	}
	public abstract void withdrawal(double amount);
	
	public abstract void deposit(double amount); 
	
	public abstract String printTransaction();
	
	public abstract void addInterest();
	
}

//Caitlyn Janiszewski CIS407 Course Project Phase 1
package courseProject;
import java.util.Scanner;
import java.util.Date; 
import java.util.InputMismatchException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.text.ParseException;
import javax.swing.*;

public class BankAcctApp {
	public static ArrayList<Customer> customers = new ArrayList<Customer>();
	public static int customerNum = 0;
	public static ArrayList<Account> accounts = new ArrayList<Account>();

	public static void main(String[] args) {
		BankAccountGUI gui = new BankAccountGUI();
		gui.setVisible(true);		
	
/*		
		String keepGoing = "y";
		
		
		int accountIndex = -1;
		String retry = "Invalid entry. Please retry.";
		Scanner input = new Scanner(System.in);
		
		
		
		while (!keepGoing.equals("n")) {
			customers.add(new Customer());
			
			//enter and set customer ID
			inputloop: while (true) {
				try {
					System.out.print("Enter Customer ID (max 5 char, not blank): ");
					String cust_id = input.nextLine();
					
					if (DataEntry.checkStringWithLimit(cust_id, 1, 5)) {
						customers.get(customerNum).setID(cust_id);
						break inputloop;
					} else {
						throw new IllegalArgumentException("Customer ID out of limit.");
					}
						
				}catch (IllegalArgumentException e){
					System.out.println(e.getMessage());
					System.out.println(retry);
				
				}
			}
			
			//enter and set customer ssn
			inputloop: while (true) {
				try {
					System.out.print("Enter Customer SSN (9 char, not blank): ");
					String cust_ssn = input.nextLine();
					if (DataEntry.checkStringWithLimit(cust_ssn, 9, 9) && DataEntry.checkStringNumeric(cust_ssn)) {
						customers.get(customerNum).setSSN(cust_ssn);
						break inputloop;
					}else {
						throw new IllegalArgumentException("Customer SSN out of limit.");
					}
				} catch (IllegalArgumentException e) {
					System.out.println(e.getMessage());
					System.out.println(retry);
				}
			}
			
			//enter and set customer last name 
			inputloop: while (true) {
				try {
					System.out.print("Enter Customer Last Name (max 20 char, not blank): ");
					String cust_last = input.nextLine();
					if (DataEntry.checkStringWithLimit(cust_last, 1, 20)) {
						customers.get(customerNum).setLastName(cust_last);
						break inputloop;
					}else {
						throw new IllegalArgumentException("Customer name out of limit.");
					}
				}catch (IllegalArgumentException e) {
					System.out.println(e.getMessage());
					System.out.println(retry);
				}
			}
			
			//enter and set customer first name 
			inputloop: while (true) {
				try {
					System.out.print("Enter Customer First Name (max 15 char, not blank): ");
					String cust_first = input.nextLine();
					if (DataEntry.checkStringWithLimit(cust_first, 1, 15)) {
						customers.get(customerNum).setFirstName(cust_first);
						break inputloop;
					}else {
						throw new IllegalArgumentException("Customer name out of limit.");
					}
				} catch (IllegalArgumentException e) {
					System.out.println(e.getMessage());
					System.out.println(retry);
				}
			}
			
			//enter and set customer street
			inputloop: while (true) {
				try {
					System.out.print("Enter Customer Street (Address) (max 20 char, not blank): ");
					String cust_street = input.nextLine();
					if (DataEntry.checkStringWithLimit(cust_street, 1, 20)) {
						customers.get(customerNum).setStreet(cust_street);
						break inputloop;
					}else {
						throw new IllegalArgumentException("Customer address out of limit.");
					}
				} catch (IllegalArgumentException e) {
					System.out.println(e.getMessage());
					System.out.println(retry);
				}
			}
				
			//enter and set customer city 
			inputloop: while (true) {
				try {
					System.out.print("Enter Customer City (Address) (max 20 char, not blank): ");
					String cust_city = input.nextLine();
					if (DataEntry.checkStringWithLimit(cust_city, 1, 20)) {
						customers.get(customerNum).setCity(cust_city);
						break inputloop;
					}else {
						throw new IllegalArgumentException("Customer city out of limit.");
					}
				} catch (IllegalArgumentException e) {
					System.out.println(e.getMessage());
					System.out.println(retry);
				}
			}
			//enter and set customer state 
			inputloop: while (true) {
				try {
					System.out.print("Enter Customer State (Address) (2 char abbr, not blank): ");
					String cust_state = input.nextLine();
					if (DataEntry.checkStringWithLimit(cust_state, 1, 2)) {
						customers.get(customerNum).setState(cust_state);
						break inputloop;
					}else {
						throw new IllegalArgumentException("Customer state out of limit.");
					}
				} catch (IllegalArgumentException e) {
					System.out.println(e.getMessage());
					System.out.println(retry);
				}
			}
			//enter and set customer zip
			inputloop: while (true) {
				try {
					System.out.print("Enter Customer Zip (Address) (5 char, not blank): ");
					String cust_zip = input.nextLine();
					if (DataEntry.checkStringWithLimit(cust_zip, 5, 5) && DataEntry.checkStringNumeric(cust_zip)) {
						customers.get(customerNum).setZip(cust_zip);
						break inputloop;
					}else {
						throw new IllegalArgumentException("Customer zip out of limit.");
					}
				} catch (IllegalArgumentException e) {
					System.out.println(e.getMessage());
					System.out.println(retry);
				}
			}
			
			//enter and set customer phone 
			inputloop: while (true) {
				try {
					System.out.print("Enter Customer Phone (10 char, no punctuation, not blank): ");
					String cust_phone = input.nextLine();
					if (DataEntry.checkStringWithLimit(cust_phone, 10, 10) && DataEntry.checkStringNumeric(cust_phone)) {
						customers.get(customerNum).setPhone(cust_phone);
						break inputloop;
					}else {
						throw new IllegalArgumentException("Phone number out of limit.");
					}
				} catch (IllegalArgumentException e) {
					System.out.println(e.getMessage());
					System.out.println(retry);
				}
			}
			
			//Add account
			while (true) {
				System.out.print("Add account for customer? (y/n): ");
				String addAcct = input.nextLine().toLowerCase();
				if (addAcct.equals("n")) {
					break;
				} 
				
				inputloop: while (true) {
					try {
						System.out.print("Enter Acccount Type (CHK or SAV only): ");
						String acctType = input.nextLine().toUpperCase();
						
						
						if (acctType.equals("CHK") || acctType.equals("SAV")) {
							if (acctType.equals("SAV")) {
								accounts.add(new SavingsAccount());
							} else {
								accounts.add(new CheckingAccount());
							}
							accounts.get(customerNum).setAcctType(acctType);
							break inputloop;
						} else {
							throw new IllegalArgumentException("Account type not an option.");
						}
					}catch (IllegalArgumentException e){
						System.out.println(e.getMessage());
						System.out.println(retry);
					}
				}
				
				inputloop: while (true) {
					try {
						System.out.print("Enter Acccount Number (max 5 char, not blank): ");
						String acctNumber = input.nextLine();
						
						
						if (DataEntry.checkStringWithLimit(acctNumber, 1, 5)) {
							accounts.get(customerNum).setAcctNum(acctNumber);
							break inputloop;
						} else {
							throw new IllegalArgumentException("Account number out of limit.");
						}
							
					}catch (IllegalArgumentException e){
						System.out.println(e.getMessage());
						System.out.println(retry);
					}
				}
				
				inputloop: while (true) {
					try {
						System.out.print("Enter Balance: ");
						Double balance = input.nextDouble();
						input.nextLine();
						
						
						if (DataEntry.checkDouble(balance)) {
							accounts.get(customerNum).setBalance(balance);
							break inputloop;
						} else {
							throw new InputMismatchException("Balance must be valid number.");
						}
							
					}catch (InputMismatchException e){
						System.out.println(e.getMessage());
						System.out.println(retry);
					}
				}
				break;
			}
				
			
			input.nextLine();
			customerNum += 1;
			System.out.print("Add another customer? (y/n): ");
			keepGoing = input.nextLine().toLowerCase();
		}
		
		for(int i = 0; i < customers.size(); i++) {
			System.out.println("Customer #" + (i + 1));
			System.out.println(customers.get(i));
			System.out.println();
			System.out.println("Account information: ");
			System.out.println(accounts.get(i));
			System.out.println();
		}
		
		System.out.print("Perform transaction for customer? (y/n): ");
		keepGoing = input.nextLine().toLowerCase();
		
		
		while (keepGoing.equals("y")) {
			accountIndex = -1;
			//matches transaction to account number
			inputloop: while (true) {
				try {
					System.out.print("Account number: ");
					String transactionAccount = input.nextLine();
					for (int i = 0; i < customers.size(); i++) {
						if (accounts.get(i).getAcctNum().equals(transactionAccount)) {
							accountIndex = i;
						}					
					}
					if (accountIndex != -1) {
						break inputloop;
					}else {
						throw new InputMismatchException("Account number does not exist.");
					}
				} catch (InputMismatchException e){
					System.out.println(e.getMessage());
					System.out.println(retry);
				}
			}
			//loop to enter transaction date
			inputloop: while (true) {
				System.out.print("Enter transaction date (MM/dd/yyy): ");
				String strDate = input.nextLine();
				
				try {
					if (DataEntry.checkDate(strDate)) {
						SimpleDateFormat parser = new SimpleDateFormat("MM/dd/yyyy");
						accounts.get(accountIndex).setDate(parser.parse(strDate));
						break inputloop; 
					} else {
						throw new InputMismatchException("Date must be in MM/dd/yyyy format.");
					}
				}catch (InputMismatchException | ParseException e) {
					System.out.println(e.getMessage());
					System.out.println(retry);
				}
				
			}
			
			inputloop: while (true) {
				//pick transaction type
				System.out.print("Choose transaction type (DEP or WTH): ");
				String transactionType = input.nextLine().toUpperCase();
				
				try {
					if (transactionType.equals("DEP") || transactionType.equals("WTH")) {
						//if transaction type is valid, enters loop to enter transaction amount, then performs transaction
						inputloop2: while (true) {
							try {
								System.out.print("Enter transaction amount: ");
								double transactionAmount = input.nextDouble();
								input.nextLine();
								if (DataEntry.checkDouble(transactionAmount)) {
									accounts.get(accountIndex).setTType(transactionType);
									if (transactionType.equals("DEP")) {
										accounts.get(accountIndex).deposit(transactionAmount); 
									}else {
										if (accounts.get(accountIndex).getAcctType().equals("SAV")) {
											try {
												accounts.get(accountIndex).withdrawal(transactionAmount);
											} catch (ArithmeticException e) {
												System.out.println("Denied. Cannot withdraw more than current balance.");
												break inputloop2;
											}
										} else {
											accounts.get(accountIndex).withdrawal(transactionAmount);
										}
									}
									break inputloop;
								}else {
									throw new InputMismatchException("Transaction amount must be a valid number.");
								}
							}catch (InputMismatchException e){
								System.out.println(e.getMessage());
								System.out.println(retry);
							}
						}
					} else {
						throw new InputMismatchException("Transaction type must be DEP or WTH.");
					}
				}catch (InputMismatchException e) {
					System.out.println(e.getMessage());
					System.out.println(retry);
				}
			}
			
			inputloop: while (true) {
				System.out.print("Add interest earned to balance? (y/n): ");
				String addInterest = input.nextLine().toLowerCase();
				
				try {
					if (addInterest.equals("y")) {
						accounts.get(accountIndex).addInterest();
						break inputloop;
					} else if (addInterest.equals("n")) {
						break inputloop;
					} else {
						throw new InputMismatchException("Must be y or n.");
					}
				} catch (InputMismatchException e) {
					System.out.println(e.getMessage());
					System.out.println(retry);
				}
			}
			
			System.out.println("Transaction Summary: ");
			System.out.println("Customer ID: " + customers.get(accountIndex).getID());
			System.out.println(accounts.get(accountIndex));
			System.out.println(accounts.get(accountIndex).printTransaction());
			
			System.out.print("Perform another transaction? y/n: ");
			keepGoing = input.nextLine();
			
			
		}
		
		
		input.close();
*/
	}

}

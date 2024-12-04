package courseProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;


public class BankAccountGUI extends JFrame implements ActionListener{
	//customer info labels
	JLabel custIDLabel = new JLabel("Customer ID (max 5 char): ");
	JLabel ssnLabel = new JLabel("Customer SSN (9 char): ");
	JLabel lastNameLabel = new JLabel("Customer Last name (max 20 char): ");
	JLabel firstNameLabel = new JLabel("Customer First name (max 20 char): ");
	JLabel streetLabel= new JLabel("Customer Street (Address) (max 20 char): ");
	JLabel cityLabel = new JLabel("Customer City (Address) (max 20 char): ");
	JLabel stateLabel = new JLabel("Customer State (Address) (2 char abbr): ");
	JLabel zipLabel = new JLabel("Customer Zip (Address) (5 char): ");
	JLabel phoneLabel = new JLabel("Customer Phone (10 char, no punctuation): ");
	
	//text fields to enter customer info
	JTextField custIDText = new JTextField(20);
	JTextField ssnText = new JTextField(20);
	JTextField lastNameText = new JTextField(20);
	JTextField firstNameText = new JTextField(20);
	JTextField streetText = new JTextField(20);
	JTextField cityText = new JTextField(20);
	JTextField zipText = new JTextField(20);
	JTextField phoneText = new JTextField(20);
	
	//account info labels 
	JLabel acctTypeLabel= new JLabel("Acccount Type: ");
	JLabel acctNumLabel = new JLabel("Account Number (max 5 char): ");
	JLabel balanceLabel = new JLabel("Balance: ");
	
	//text fields to enter account info
	JTextField acctNumText = new JTextField(10);
	JTextField balanceText = new JTextField(10);
	
	//transaction labels 
	JLabel transAcctNumLabel = new JLabel("Account number: ");
	JLabel transDateLabel = new JLabel("Transaction date (MM/dd/yyy): ");
	JLabel transTypeLabel = new JLabel("Transaction type: ");
	JLabel transAmountLabel = new JLabel("Transaction amount: ");
	JLabel transAddIntLabel = new JLabel("Add interest earned to balance? (y/n): ");
	JLabel completedCustID = new JLabel("");
	JLabel completedAcctNum= new JLabel("");
	JLabel completedAcctType= new JLabel("");
	JLabel completedTransDate= new JLabel("");
	JLabel completedTransType = new JLabel("");
	JLabel completedTransAmount = new JLabel("");
	JLabel completedTransFees= new JLabel("");
	JLabel completedBalance = new JLabel("");
	
	//text fields to enter transaction info
	JTextField transDateText = new JTextField(10);
	JTextField transAmountText = new JTextField(10);
	JTextField transAddIntText = new JTextField(10);
	JTextField transAcctNumText = new JTextField(10);
	
	//Labels to display data 
	JTextArea displayCustAcctData = new JTextArea(20,50);
	
	
	//status label
	JLabel addDataMessage = new JLabel("");
	JLabel performTransMessage = new JLabel("");
	JLabel displayDataMessage = new JLabel("");
	
	// Radio Buttons
	JRadioButton savings = new JRadioButton("Savings");
	JRadioButton checking = new JRadioButton("Checking");
	ButtonGroup acctTypeGroup = new ButtonGroup();

	JRadioButton deposit = new JRadioButton("Deposit");
	JRadioButton withdrawal = new JRadioButton("Withdrawal");
	ButtonGroup transTypeGroup = new ButtonGroup();
			
	//Buttons
	JButton addDataButton = new JButton("Add New Customer and Account");
	JButton displayDataButton = new JButton("Display Customer and Account Data");
	JButton performTransButton = new JButton("Perform Transaction");
	JButton addDataClear = new JButton("Clear");
	JButton performTransClear = new JButton("Clear");
	JButton addDataHomeButton = new JButton("Return to home screen");
	JButton displayDataHomeButton = new JButton("Return to home screen");
	JButton performTransHomeButton = new JButton("Return to home screen");
	JButton addDataSubmit = new JButton("Submit");
	JButton performTransSubmit = new JButton("Submit");
	
	
	
	//drop down box for state
	String[] states = {"NY", "PA", "NJ", "MA", "CT"};
	JComboBox<String> stateBox = new JComboBox<>(states);
	
	//create panels
	JPanel mainPanel = new JPanel();
	JPanel home = new JPanel();
	JPanel addData = new JPanel();
	JPanel displayData = new JPanel();
	JPanel performTrans = new JPanel();
	
	GridBagConstraints gbc = new GridBagConstraints();
 	
	public BankAccountGUI() {
		super("Bank Account Application");
		setSize(1100,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		CardLayout card = new CardLayout();
		mainPanel.setLayout(card);
		mainPanel.setVisible(true);
		
		FlowLayout flow = new FlowLayout(FlowLayout.CENTER, 10, 10);
		home.setLayout(flow);
		home.add(addDataButton);
		home.add(displayDataButton);
		home.add(performTransButton);
		home.setVisible(true);
		
		GridBagLayout grid = new GridBagLayout();
		gbc.insets = new Insets(5,5,5,5);
		gbc.anchor = GridBagConstraints.WEST;
		
	//Add Data panel 
		addData.setVisible(false);
		addData.setLayout(grid);
		gbc.gridx = 0; gbc.gridy = 0;
		addData.add(custIDLabel, gbc);
		gbc.gridx = 1; gbc.gridy = 0;
		addData.add(custIDText, gbc);
		
		gbc.gridx = 0; gbc.gridy = 1;
		addData.add(ssnLabel, gbc);
		gbc.gridx = 1; gbc.gridy = 1;
		addData.add(ssnText, gbc);
		
		gbc.gridx = 0; gbc.gridy = 2;
		addData.add(lastNameLabel, gbc);
		gbc.gridx = 1; gbc.gridy = 2;
		addData.add(lastNameText, gbc);
		
		gbc.gridx = 0; gbc.gridy = 3;
		addData.add(firstNameLabel, gbc);
		gbc.gridx = 1; gbc.gridy = 3;
		addData.add(firstNameText, gbc);
		
		gbc.gridx = 0; gbc.gridy = 4;
		addData.add(streetLabel, gbc);
		gbc.gridx = 1; gbc.gridy = 4;
		addData.add(streetText, gbc);
		
		gbc.gridx = 0; gbc.gridy = 5;
		addData.add(cityLabel, gbc);
		gbc.gridx = 1; gbc.gridy = 5;
		addData.add(cityText, gbc);
		
		gbc.gridx = 0; gbc.gridy = 6;
		addData.add(stateLabel, gbc);
		gbc.gridx = 1; gbc.gridy = 6;
		addData.add(stateBox, gbc);
		
		gbc.gridx = 0; gbc.gridy = 7;
		addData.add(zipLabel, gbc);
		gbc.gridx = 1; gbc.gridy = 7;
		addData.add(zipText, gbc);
		
		gbc.gridx = 0; gbc.gridy = 8;
		addData.add(phoneLabel, gbc);
		gbc.gridx = 1; gbc.gridy = 8;
		addData.add(phoneText, gbc);
		
		acctTypeGroup.add(savings);
		acctTypeGroup.add(checking);
		savings.setSelected(true);
		gbc.gridx = 2; gbc.gridy = 0;
		addData.add(acctTypeLabel, gbc);
		gbc.gridx = 3; gbc.gridy = 0;
		addData.add(savings, gbc);
		gbc.gridx = 3; gbc.gridy = 1;
		addData.add(checking, gbc);
		
		gbc.gridx = 2; gbc.gridy = 2;
		addData.add(acctNumLabel, gbc);
		gbc.gridx = 3; gbc.gridy = 2;
		addData.add(acctNumText, gbc);
		
		gbc.gridx = 2; gbc.gridy = 3;
		addData.add(balanceLabel, gbc);
		gbc.gridx = 3; gbc.gridy = 3;
		addData.add(balanceText, gbc);
		
		gbc.gridx = 0; gbc.gridy = 10;
		addData.add(addDataClear);
		
		gbc.gridx = 0; gbc.gridy = 11;
		addData.add(addDataSubmit);
		
		gbc.gridx = 1; gbc.gridy = 10;
		addData.add(addDataHomeButton,gbc);
		
		gbc.gridx = 1; gbc.gridy = 12; 
		addData.add(addDataMessage, gbc);
		
	//perform transaction panel
		performTrans.setVisible(false);
		performTrans.setLayout(grid);
		
		gbc.gridx = 0; gbc.gridy = 0;
		performTrans.add(transAcctNumLabel, gbc);
		gbc.gridx = 1; gbc.gridy = 0;
		performTrans.add(transAcctNumText, gbc);
		
		gbc.gridx = 0; gbc.gridy = 1;
		performTrans.add(transDateLabel, gbc);
		gbc.gridx = 1; gbc.gridy = 1;
		performTrans.add(transDateText, gbc);
		
		transTypeGroup.add(deposit);
		transTypeGroup.add(withdrawal);
		deposit.setSelected(true);
		gbc.gridx = 0; gbc.gridy = 2;
		performTrans.add(transTypeLabel, gbc);
		gbc.gridx = 1; gbc.gridy = 2;
		performTrans.add(deposit, gbc);
		gbc.gridx = 2; gbc.gridy = 2;
		performTrans.add(withdrawal, gbc);
		
		gbc.gridx = 0; gbc.gridy = 3;
		performTrans.add(transAmountLabel, gbc);
		gbc.gridx = 1; gbc.gridy = 3;
		performTrans.add(transAmountText, gbc);
		
		gbc.gridx = 0; gbc.gridy = 4;
		performTrans.add(transAddIntLabel, gbc);
		gbc.gridx = 1; gbc.gridy = 4;
		performTrans.add(transAddIntText, gbc);
		
		gbc.gridx = 2; gbc.gridy = 6;
		performTrans.add(completedCustID,gbc);
		gbc.gridx = 2; gbc.gridy = 7;
		performTrans.add(completedAcctNum,gbc);
		gbc.gridx = 2; gbc.gridy = 8;
		performTrans.add(completedAcctType,gbc);
		gbc.gridx = 2; gbc.gridy = 9;
		performTrans.add(completedTransDate,gbc);
		gbc.gridx = 2; gbc.gridy = 10;
		performTrans.add(completedTransType,gbc);
		gbc.gridx = 2; gbc.gridy = 11;
		performTrans.add(completedTransAmount,gbc);
		gbc.gridx = 2; gbc.gridy = 12;
		performTrans.add(completedTransFees,gbc);
		gbc.gridx = 2; gbc.gridy = 13;
		performTrans.add(completedBalance,gbc);
		
		gbc.gridx = 0; gbc.gridy = 10;
		performTrans.add(performTransClear);
		
		gbc.gridx = 0; gbc.gridy = 11;
		performTrans.add(performTransSubmit);
		
		gbc.gridx = 1; gbc.gridy = 10;
		performTrans.add(performTransHomeButton,gbc);
		
		gbc.gridx = 1; gbc.gridy = 12; 
		performTrans.add(performTransMessage, gbc);
		
		//Display data panel
		displayData.setVisible(false);
		displayData.setLayout(grid);
		
		displayCustAcctData.setEditable(false);
		gbc.gridx = 0; gbc.gridy = 1;
		displayData.add(displayCustAcctData,gbc);
		
		gbc.gridx = 0; gbc.gridy = 0;
		displayData.add(displayDataMessage, gbc);
		
		gbc.gridx = 1; gbc.gridy = 10;
		displayData.add(displayDataHomeButton,gbc);
		
		
		addDataButton.addActionListener(this);
		displayDataButton.addActionListener(this);
		performTransButton.addActionListener(this);
		addDataHomeButton.addActionListener(this);
		displayDataHomeButton.addActionListener(this);
		performTransHomeButton.addActionListener(this);
		addDataClear.addActionListener(this);
		performTransClear.addActionListener(this);
		addDataSubmit.addActionListener(this);
		performTransSubmit.addActionListener(this);
		
		
		mainPanel.add(home, "Home");
		mainPanel.add(addData, "Add New Customer and Account");
		mainPanel.add(displayData, "Display Data");
		mainPanel.add(performTrans, "Perform Transaction");
		
		add(mainPanel);
	
		
	}

	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
	//switching between panels 
		if (source == addDataButton) {
			home.setVisible(false);
			addData.setVisible(true);
		} else if (source == displayDataButton) {
			home.setVisible(false);
			displayData.setVisible(true);
			System.out.println(BankAcctApp.customers.size());
			
			if (BankAcctApp.customers.size() > 0) {
				StringBuilder str = new StringBuilder();
				for(int i = 0; i < BankAcctApp.customers.size(); i++) {
					str.append("Customer information: \n");
					str.append(BankAcctApp.customers.get(i).toString());
					str.append("\n");
					str.append("Account information: \n");
					str.append(BankAcctApp.accounts.get(i).toString());
					str.append("\n");
					displayCustAcctData.setText(str.toString());
				}
			}else {
				displayCustAcctData.setText("");
				displayDataMessage.setVisible(true);
				displayDataMessage.setText("No customers or accounts have been added.");
				displayDataMessage.repaint();
			}
		} else if (source == performTransButton) {
			home.setVisible(false);
			performTrans.setVisible(true);
		} else if (source == addDataHomeButton || source == displayDataHomeButton || source == performTransHomeButton) {
			home.setVisible(true);
			addData.setVisible(false);
			displayData.setVisible(false);
			performTrans.setVisible(false);
		}
		
		if (source == addDataClear) {
			custIDText.setText("");
			ssnText.setText("");
			lastNameText.setText("");
			firstNameText.setText("");
			streetText.setText("");
			cityText.setText("");
			zipText.setText("");
			phoneText.setText("");
			acctNumText.setText("");
			balanceText.setText("");
		} else if (source == performTransClear) {
			transDateText.setText("");
			transAmountText.setText("");
			transAddIntText.setText("");
			transAcctNumText.setText("");
			
		}
		
		if (source == addDataSubmit) {
		//add new customer to customers 
			Customer newCustomer = new Customer();
			
			String cust_id = custIDText.getText();
			if (DataEntry.checkStringWithLimit(cust_id, 1, 5)) {
				newCustomer.setID(cust_id);
			} else {
				addDataMessage.setText("Customer ID out of limit. Customer not added.");
			}
			
			String ssn = ssnText.getText();
			if (DataEntry.checkStringWithLimit(ssn, 9, 9)) {
				newCustomer.setSSN(ssn);
			} else {
				addDataMessage.setText("Customer SSN out of limit. Customer not added.");
			}
			
			String last_name = lastNameText.getText();
			if (DataEntry.checkStringWithLimit(last_name, 1, 20)) {
				newCustomer.setLastName(last_name);
			} else {
				addDataMessage.setText("Last name out of limit. Customer not added.");
			}
			
			String first_name = firstNameText.getText();
			if (DataEntry.checkStringWithLimit(first_name, 1, 15)) {
				newCustomer.setFirstName(first_name);
			} else {
				addDataMessage.setText("First Name out of limit. Customer not added.");
			}
			
			String street = streetText.getText();
			if (DataEntry.checkStringWithLimit(street, 1, 20)) {
				newCustomer.setStreet(street);
			} else {
				addDataMessage.setText("Street out of limit. Customer not added.");
			}
			
			String city = cityText.getText();
			if (DataEntry.checkStringWithLimit(city, 1, 20)) {
				newCustomer.setCity(city);
			} else {
				addDataMessage.setText("City out of limit. Customer not added.");
			}
			
			String state = stateBox.getSelectedItem().toString();
			newCustomer.setState(state);
			
			String zip = zipText.getText();
			if (DataEntry.checkStringWithLimit(zip, 5, 5)) {
				newCustomer.setZip(zip);
			} else {
				addDataMessage.setText("Zipcode out of limit. Customer not added.");
			}
			
			String phone = phoneText.getText();
			if (DataEntry.checkStringWithLimit(phone, 10, 10)) {
				newCustomer.setPhone(phone);
			} else {
				addDataMessage.setText("Phone out of limit. Customer not added.");
			}
			
		//add checking or saving account to accounts
			String acctType;
			String acctNum = "";
			Double balance = 0.0;
	
			if (savings.isSelected()) {
				acctType = "SAV";
				Account newSavings = new SavingsAccount();
				newSavings.setAcctType(acctType);
				
				acctNum = acctNumText.getText();
				if (DataEntry.checkStringWithLimit(acctNum, 1, 5)) {
					newSavings.setAcctNum(acctNum);
				} else {
					addDataMessage.setText("Account Number out of limit. Customer/Account not added.");
				}
				
				
				try {
					balance = Double.parseDouble(balanceText.getText());
					if (DataEntry.checkDouble(balance)) {
						newSavings.setBalance(balance);
					} else {
						throw new NumberFormatException();
					}
				}catch (NumberFormatException ex) {
					addDataMessage.setText("Invalid balance. Customer/Account not added.");
				}
				//make sure all fields are filled out
				if (cust_id == null || cust_id.trim().isEmpty() ||
						ssn == null || ssn.trim().isEmpty() ||
						last_name == null || last_name.trim().isEmpty() ||
						first_name == null || first_name.trim().isEmpty() ||
						street == null || street.trim().isEmpty() ||
						city == null || city.trim().isEmpty() ||
						zip == null || zip.trim().isEmpty() ||
						phone == null || phone.trim().isEmpty() ||
						acctNum == null || acctNum.trim().isEmpty() ||
						balance == null || acctNum == null || acctNum.trim().isEmpty()) {
					    
					    addDataMessage.setText("All fields are required.");
					    
				} else {	    
					BankAcctApp.customers.add(newCustomer);
					BankAcctApp.accounts.add(newSavings);
					addDataMessage.setText("Customer/Account added.");	
				}
				
			} else if (checking.isSelected()) {
				acctType = "CHK";
				Account newChecking = new CheckingAccount();
				newChecking.setAcctType(acctType);
				
				acctNum = acctNumText.getText();
				if (DataEntry.checkStringWithLimit(acctNum, 1, 5)) {
					newChecking.setAcctNum(acctNum);
				} else {
					addDataMessage.setText("Account Number out of limit. Customer/Account not added.");
				}
				
				try {
					balance = Double.parseDouble(balanceText.getText());
					if (DataEntry.checkDouble(balance)) {
						newChecking.setBalance(balance);
					} else {
						throw new NumberFormatException();
					}
				}catch (NumberFormatException ex) {
					addDataMessage.setText("Invalid balance. Customer/Account not added.");
				}
				//make sure all fields are filled out
				if (cust_id == null || cust_id.trim().isEmpty() ||
						ssn == null || ssn.trim().isEmpty() ||
						last_name == null || last_name.trim().isEmpty() ||
						first_name == null || first_name.trim().isEmpty() ||
						street == null || street.trim().isEmpty() ||
						city == null || city.trim().isEmpty() ||
						zip == null || zip.trim().isEmpty() ||
						phone == null || phone.trim().isEmpty() ||
						acctNum == null || acctNum.trim().isEmpty() ||
						balance == null || acctNum == null || acctNum.trim().isEmpty()) {
					    
					    addDataMessage.setText("All fields are required.");
					    
				} else {	    
					BankAcctApp.customers.add(newCustomer);
					BankAcctApp.accounts.add(newChecking);
					addDataMessage.setText("Customer/Account added.");	
				}
					
				
			}
		
		}
		
		if (source == performTransSubmit) {
			Double transactionAmount = 0.0;
			int accountIndex = -1;
			String strDate = "";
			String transType = "";
			String transAcctNum = transAcctNumText.getText();
			if (DataEntry.checkStringWithLimit(transAcctNum, 1, 5)) {
				for (int i = 0; i < BankAcctApp.customers.size(); i++) {
					if (BankAcctApp.accounts.get(i).getAcctNum().equals(transAcctNum)) {
						accountIndex = i;
					} 				
				}
				if (accountIndex == -1) {
					performTransMessage.setText("Account number not found.");
				}  else {
				//set transaction date
					strDate = transDateText.getText();
					try {
						if (DataEntry.checkDate(strDate)) {
							SimpleDateFormat parser = new SimpleDateFormat("MM/dd/yyyy");
							BankAcctApp.accounts.get(accountIndex).setDate(parser.parse(strDate));
						} else {
							throw new InputMismatchException("Date must be in MM/dd/yyyy format.");
						}
					}catch (InputMismatchException | ParseException ex) {
						performTransMessage.setText("Invalid date.");
					}
				//get transaction type
					
					if (deposit.isSelected()) {
						transType = "DEP";
					}else if (withdrawal.isSelected()) {
						transType = "WTH";
					}
					BankAcctApp.accounts.get(accountIndex).setTType(transType);
					
					try {
						transactionAmount = Double.parseDouble(transAmountText.getText());
						if (DataEntry.checkDouble(transactionAmount)) {
							if (transType.equals("DEP")) {
								BankAcctApp.accounts.get(accountIndex).deposit(transactionAmount); 
								performTransMessage.setText("Transaction performed.");
							}else {
								if (BankAcctApp.accounts.get(accountIndex).getAcctType().equals("SAV")) {
									try {
										BankAcctApp.accounts.get(accountIndex).withdrawal(transactionAmount);
										performTransMessage.setText("Transaction performed.");
									} catch (ArithmeticException ex) {
	
										performTransMessage.setText("Denied. Cannot withdraw more than current balance.");
								
									}
								} else {
									BankAcctApp.accounts.get(accountIndex).withdrawal(transactionAmount);
									performTransMessage.setText("Transaction performed.");
								}
							}
						} else {
							throw new NumberFormatException();
						}
					}catch (NumberFormatException ex) {
						performTransMessage.setText("Invalid transaction amount. No transaction performed.");
					}
					
					String addInt = transAddIntText.getText().toLowerCase();
					if (addInt.equals("y")) {
						BankAcctApp.accounts.get(accountIndex).addInterest();
					} else if (addInt.equals("n")) {
						
					}else {
						performTransMessage.setText("Enter y or n to add interest or to not add interest.");
					}
					
				}
				
				completedCustID.setText("Transaction customer ID: " + BankAcctApp.customers.get(accountIndex).getID());
				completedAcctNum.setText("Transaction account number: " + BankAcctApp.accounts.get(accountIndex).getAcctNum());
				completedAcctType.setText("Transaction account type: " + BankAcctApp.accounts.get(accountIndex).getAcctType());
				completedTransDate.setText("Transaction date: " + BankAcctApp.accounts.get(accountIndex).getDate());
				completedTransType.setText("Transaction type: " + transType);
				completedTransAmount.setText("Transaction amount: " + transactionAmount);
				double fees = BankAcctApp.accounts.get(accountIndex).getOverDraftFee() + BankAcctApp.accounts.get(accountIndex).getServiceFee();
				completedTransFees.setText("Transaction fees: " + fees);
				completedBalance.setText("Balance after transaction: " + String.format("$%.2f",BankAcctApp.accounts.get(accountIndex).getBalance()));
			
			} else {
				performTransMessage.setText("Account Number invalid.");
			}
		}
	}
}

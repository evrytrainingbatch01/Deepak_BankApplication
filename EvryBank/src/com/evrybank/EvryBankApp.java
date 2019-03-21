package com.evrybank;

import java.util.Scanner;
import java.util.Set;

import com.evrybank.entity.Account;
import com.evrybank.entity.Admin;
import com.evrybank.entity.Customer;
import com.evrybank.entity.Transaction;
import com.evrybank.entity.TransactionType;
import com.evrybank.managerImpl.EBAdminManagerImpl;
import com.evrybank.managerImpl.EBBankManagerImpl;
import com.evrybank.managerImpl.EBCustomerManagerImpl;

/**
 * 
 * @author DEEPAK J A
 *
 */
public class EvryBankApp {

	public static void main(String[] args) {

		System.out.println("---------WELCOME TO EVRY BANK ATM----------");
		Scanner sc = new Scanner(System.in);

		EBAdminManagerImpl ebAdminManagerImpl = new EBAdminManagerImpl();
		EBCustomerManagerImpl ebCustomerManagerImpl = new EBCustomerManagerImpl();
		EBBankManagerImpl ebBankManagerImpl = new EBBankManagerImpl();

		System.out.println("Select Your Choice");
		System.out.println("1. Get All Admins");
		System.out.println("2. Get Admin");
		System.out.println("3. Delete Admin");
		System.out.println("4. Update Admin");
		System.out.println("5. Add Customer");
		System.out.println("6. Delete a Customer");
		System.out.println("7. Get All Customers");
		System.out.println("8. Get Customer");
		System.out.println("9. Open an Account");
		System.out.println("10. Show Account Info");
		System.out.println("11. Deposit");
		System.out.println("12. Withdraw");
		System.out.println("13. Transfer");
		Integer choice = sc.nextInt();
			
		switch (choice) {
		case 1:
			getAllAdmins(sc, choice, ebAdminManagerImpl);
			break;
		case 2:
			getAdmin(sc, choice, ebAdminManagerImpl);
			break;
		case 3:
			deleteAdmin(sc, choice, ebAdminManagerImpl);
			break;
		case 4:
			updateAdmin(sc, choice, ebAdminManagerImpl);
			break;
		case 5:
			addCustomer(sc, choice, ebAdminManagerImpl, ebBankManagerImpl, ebCustomerManagerImpl);
			break;
		case 6:
			deleteCustomer(sc, choice, ebAdminManagerImpl);
			break;
		case 7:
			getAllCustomers(sc, choice, ebAdminManagerImpl);
			break;
		case 8:
			getCustomer(sc, choice, ebAdminManagerImpl);
			break;
		case 9:
			openAccount(sc, choice, ebBankManagerImpl);
			break;
		case 10:
			showAccountInfo(sc, choice, ebBankManagerImpl);
			break;
		case 11:
			deposit(sc, choice, ebBankManagerImpl);
			break;
		case 12:
			withdraw(sc, choice, ebBankManagerImpl);
			break;
		case 13:
			transfer(sc, choice, ebBankManagerImpl);
			break;
		default: 
			break; 
		}
		
		System.out.println("\n------ THANK YOU !!! -------");
	}

	// 1.GET ALL ADMINS
	public static void getAllAdmins(Scanner sc, Integer choice, EBAdminManagerImpl ebAdminManagerImpl) {
		if (choice.equals(1)) {
			Set<Admin> setOfAdmins = ebAdminManagerImpl.getAllAdmins();
			// System.out.println(setOfAdmins);
			System.out.println("The Admin users are : ");
			for (Admin adminUser : setOfAdmins) {
				System.out.println( "User Id : " + adminUser.getId() + "\n" + 
										"First Name : " + adminUser.getFirstname() + "\n" + 
											"Last Name : " + adminUser.getLastname() + "\n" + 
												"Age : " + adminUser.getAge() + "\n");
			}
		}
	}

	// 2.GET ADMIN
	public static void getAdmin(Scanner sc, Integer choice, EBAdminManagerImpl ebAdminManagerImpl) {
		if (choice.equals(2)) {
			System.out.println("Please provide id of user to be fetched from the database : ");
			Integer idOfAdminUserToBeFetched = sc.nextInt();
			Admin adminUser = ebAdminManagerImpl.getAdmin(idOfAdminUserToBeFetched);
			// System.out.println(setOfAdmins);
			System.out.println("Admin details : ");
			System.out.println("User Id : " + adminUser.getId() + "\n" + 
								"First Name : " + adminUser.getFirstname() + "\n" + 
									"Last Name : " + adminUser.getLastname()+ "\n" + 
										"Age : " + adminUser.getAge());
		}
	}

	// 3.DELETE ADMIN
	public static void deleteAdmin(Scanner sc, Integer choice, EBAdminManagerImpl ebAdminManagerImpl) {
		if (choice.equals(3)) {
			// to delete a user get that user first and then try to delete
			System.out.println("Which Admin user you want to delete ? Please provide the id of that user : ");
			Integer idOfAdminUserToBeDeleted = sc.nextInt();
			Admin adminUser = ebAdminManagerImpl.getAdmin(idOfAdminUserToBeDeleted);
			// now call the delete method
			boolean isDeleted = ebAdminManagerImpl.deleteAdmin(adminUser, idOfAdminUserToBeDeleted);
			if (isDeleted) {
				System.out.println("Admin user deleted");
			}
		}
	}

	// 4.UPDATE ADMIN USER
	public static void updateAdmin(Scanner sc, Integer choice, EBAdminManagerImpl ebAdminManagerImpl) {
		if (choice.equals(4)) {
			boolean isNewAdminUpdationRequest = false;
			System.out.println("Are you sure you want to update Admin ? (true/false)");
			isNewAdminUpdationRequest = sc.nextBoolean();
			if (isNewAdminUpdationRequest == true) {
				System.out.println("Please provide id of user to be updated : ");
				Integer idOfAdminUserToBeUpdated = sc.nextInt();

				Admin adminUser = ebAdminManagerImpl.getAdmin(idOfAdminUserToBeUpdated);
				System.out.println("What you want to update from the below options ?");
				System.out.println("1. Update Firstname "+ "\n"+ 
										"2. Update Lastname" + "\n" + 
												"3. Update Age");
				int number = sc.nextInt();
				switch (number) {

				case 1:
					System.out.println("Update Firstname selected");
					System.out.println("What should be the firstname ?");
					adminUser.setFirstname(sc.next());
					System.out.println("Firstname Updated");
					break;

				case 2:
					System.out.println("Update Lastname selected");
					System.out.println("What should be the lastname ?");
					adminUser.setLastname(sc.next());
					System.out.println("Lastname Updated");
					break;

				case 3:
					System.out.println("Update Age selected");
					System.out.println("What should be the age ?");
					adminUser.setAge(sc.nextInt());
					System.out.println("Age Updated");
					break;

				case 0:
					System.out.println("Select an option");
					break;
				}

				boolean isUpdated = ebAdminManagerImpl.updateAdmin(adminUser);
				if (isUpdated) {
					System.out.println("Admin User Updated");
				}
			}
		}
	}

	// 5.ADD CUSTOMER
	public static void addCustomer(Scanner sc, Integer choice, EBAdminManagerImpl ebAdminManagerImpl, EBBankManagerImpl ebBankManagerImpl, EBCustomerManagerImpl ebCustomerManagerImpl) {
		if (choice.equals(5)) {

			Customer newCustomer = createCustomerEntry(sc);
			
			System.out.println("Account Number will be automatically generated : ");
			Double accNumberToBeAssigned = Math.floor(Math.random() * 899999 + 100000);
			Integer accNumberToBeAssignedToCustomer = accNumberToBeAssigned.intValue();
			System.out.println("Generated account number is : " + accNumberToBeAssignedToCustomer);
			///////////////// DB Insertion
			newCustomer.setCustomerAccountId(accNumberToBeAssignedToCustomer);
				
			boolean isNewCustomerCreated = ebAdminManagerImpl.addCustomer(newCustomer);
			if (isNewCustomerCreated) {
				
				Account account = new Account();
				account.setAccountNumber(accNumberToBeAssignedToCustomer);
				account.setAccountbalance(newCustomer.getBalAmount());
//				account.setCustomerId(newCustomer.getCustomerAccountId());
				
				
				/*//UPDATE THE CUSTOMER 
				ebCustomerManagerImpl.updateCustomer(newCustomer, accNumberToBeAssignedToCustomer);
				
				ebBankManagerImpl.createAccount(account, newCustomer.getId());*/
				ebBankManagerImpl.createAccount(account);
				System.out.println("New Customer Created Successfully");
			}
		}
	}

	public static Customer createCustomerEntry(Scanner sc) {
		Customer newCustomer = new Customer();
		System.out.println("What is firstname of the Customer :");
		newCustomer.setFirstname(sc.next());
		System.out.println("What is the lastname of the Customer :");
		newCustomer.setLastname(sc.next());
		System.out.println("What is the age of the Customer :");
		newCustomer.setAge(sc.nextInt());
		System.out.println("Which city is he/she from :");
		newCustomer.setCity(sc.next());
		System.out.println("Which country is he/she from :");
		newCustomer.setCountry(sc.next());
		System.out.println("Contact number :");
		newCustomer.setPhoneNumber(sc.nextInt());

		System.out.println("Would you like to add an amount to balanceamount initially ? true/false");
		boolean ifAddAmount = sc.nextBoolean();
		if (ifAddAmount) {
			System.out.println("What is the amount that you would like to add initially?");
			newCustomer.setBalAmount(sc.nextInt());
		}
		return newCustomer;
	}

	// 6.DELETE CUSTOMER
	public static void deleteCustomer(Scanner sc, Integer choice, EBAdminManagerImpl ebAdminManagerImpl) {
		if (choice.equals(6)) {
			// To delete a customer get that user first and then try to delete
			System.out.println("Which Customer you want to delete ? Please provide the id : ");
			Integer idOfCustomerToBeDeleted = sc.nextInt();
			Customer customer = ebAdminManagerImpl.getCustomer(idOfCustomerToBeDeleted);
			// now call the delete method
			boolean isDeleted = ebAdminManagerImpl.deleteCustomer(customer, idOfCustomerToBeDeleted);
			if (isDeleted) {
				System.out.println("Customer deleted");
			}
		}
	}

	// 7. GET ALL CUSTOMERS
	public static void getAllCustomers(Scanner sc, Integer choice, EBAdminManagerImpl ebAdminManagerImpl) {
		if (choice.equals(7)) {
			Set<Customer> setOfCustomers = ebAdminManagerImpl.getAllCustomers();
			// System.out.println(setOfAdmins);
			System.out.println("The Customers are : ");
			for (Customer customer : setOfCustomers) {
				System.out.println("Customer Id : " + customer.getId() + "\n" + 
										"Firstname : " + customer.getFirstname() + "\n" + 
												"Lastname : " + customer.getLastname()+ "\n" + 
													"Age : " + customer.getAge() + "\n" + 
														"City : " + customer.getCity() + "\n" + 
															"Country : " + customer.getCountry() + "\n" + 
																"Phone : " + customer.getPhoneNumber() + "\n" + 
																	"BalAmount : " + customer.getBalAmount() + "\n");
			}
		}
	}

	// 8. GET CUSTOMER
	public static void getCustomer(Scanner sc, Integer choice, EBAdminManagerImpl ebAdminManagerImpl) {
		if (choice.equals(8)) {
			System.out.println("Please provide id of Customer to be fetched from the database : ");
			Integer idOfCustomerToBeFetched = sc.nextInt();
			Customer customer = ebAdminManagerImpl.getCustomer(idOfCustomerToBeFetched);
			// System.out.println(setOfAdmins);
			System.out.println("Customer details : ");
			System.out.println("Customer Id : " + customer.getId() + "\n" + 
									"Firstname : " + customer.getFirstname() + "\n" + 
										"Lastname : " + customer.getLastname()+ "\n" + 
											"Age : " + customer.getAge() + "\n" + 
												"City : " + customer.getCity() + "\n" + 
													"Country : " + customer.getCountry() + "\n" + 
														"Phone : " + customer.getPhoneNumber() + "\n" + 
															"BalAmount : " + customer.getBalAmount() + "\n");
		}
	}

	// BANK OPERATIONS// 
	// 9. OPENING A NEW CUSTOMER ACCOUNT
	public static void openAccount(Scanner sc, Integer choice, EBBankManagerImpl ebBankManagerImpl) {
		if (choice.equals(9)) {
			Customer customer = createCustomerEntry(sc);
			System.out.println("Account Number will be automatically generated : ");
			Double accNumberToBeAssigned = Math.floor(Math.random() * 899999 + 100000);
			Integer accNumberToBeAssignedToCustomer = accNumberToBeAssigned.intValue();
			System.out.println("Generated account number is : " + accNumberToBeAssignedToCustomer);
			///////////////// DB Insertion
			customer.setCustomerAccountId(accNumberToBeAssignedToCustomer);
			
			Account account = new Account();
			account.setAccountNumber(accNumberToBeAssignedToCustomer);
//			account.setCustomerId(customer.getId());
			account.setAccountbalance(customer.getBalAmount());
			
			/*Transaction newTransaction = new Transaction();
			newTransaction.setTransactionType(TransactionType.CREDIT);
			account.setTransactionId(newTransaction.getId());
			
			ebBankManagerImpl.createTransaction(newTransaction, customer);*/
			ebBankManagerImpl.createAccount(account);
			System.out.println("Account has been created successfully for this customer");
		}
	}

	//10. SHOW ACCOUNT INFORMATION
	public static void showAccountInfo(Scanner sc, Integer choice, EBBankManagerImpl ebBankManagerImpl) {
		if (choice.equals(10)) {
			System.out.println("Enter the account number to display account details :");
			Account account = ebBankManagerImpl.getAccountInfo(sc.nextInt());
			System.out.println( "Account Number : " + account.getAccountNumber() + "\n" + 
									"Account balance : " +  account.getAccountbalance());
		}
	}
	
	//11. DEPOSIT
	public static void deposit(Scanner sc, Integer choice, EBBankManagerImpl ebBankManagerImpl) {
		
		if(choice.equals(11)){
			System.out.println("Enter the Account Number you want to deposit money to : ");
			Integer enteredAccountNumberByUser = sc.nextInt();
			System.out.println("Enter the amount you need to deposit : ");
			Integer enteredAmountByUser = sc.nextInt();
			Account account = ebBankManagerImpl.getAccountInfo(enteredAccountNumberByUser);
			Integer accBalance = account.getAccountbalance();
			Integer currentAccBalance = accBalance + enteredAmountByUser;
			System.out.println("Your new account balance is " + currentAccBalance);
			
			boolean updateAccount = ebBankManagerImpl.updateAccount(account,currentAccBalance);
			if(updateAccount){
				/*Transaction newTransaction = new Transaction();
				newTransaction.setTransactionType(TransactionType.CREDIT);
				newTransaction.setCustomerId(account.getCustomerId());*/
				
				
//				ebBankManagerImpl.createTransaction(newTransaction, customer)
				System.out.println("Amount Deposited to your account");
				System.out.println("Account Updated");
			}
			System.out.println("Thank you");
		}
	}
	
	//12. WITHDRAW
	public static void withdraw(Scanner sc, Integer choice, EBBankManagerImpl ebBankManagerImpl) {
		
		if(choice.equals(12)){
			System.out.println("Enter the Account Number you want to withdraw money from : ");
			Integer enteredAccountNumberByUser = sc.nextInt();
			System.out.println("Enter the amount you need to deposit : ");
			Integer enteredAmountByUser = sc.nextInt();
			Account account = ebBankManagerImpl.getAccountInfo(enteredAccountNumberByUser);
			Integer accBalance = account.getAccountbalance();
			Integer currentAccBalance = accBalance - enteredAmountByUser;
			System.out.println("Your new account balance is " + currentAccBalance);
			
			boolean updateAccount = ebBankManagerImpl.updateAccount(account,currentAccBalance);
			if(updateAccount){
				System.out.println("Amount "+ enteredAmountByUser +" withdrawn from your account ");
				System.out.println("Account Updated");
			}
			System.out.println("Thank you");
		}
	}

	//13. TRANSFER AMOUNT
	public static void transfer(Scanner sc, Integer choice, EBBankManagerImpl ebBankManagerImpl) {
		if(choice.equals(13)){
			System.out.println("Enter From Account Number");
			Integer fromAccountNumber = sc.nextInt();
		
			System.out.println("Enter To Account Number");
			Integer toAccountNumber = sc.nextInt();
			
			System.out.println("Enter the amount you want to transfer : ");
			Integer amountToBeTransferred = sc.nextInt();
			
			Account accountOfTo = ebBankManagerImpl.getAccountInfo(toAccountNumber);
			Account accountOfFrom = ebBankManagerImpl.getAccountInfo(fromAccountNumber);
			
			Integer sumOfamount = Integer.sum(accountOfTo.getAccountbalance(), amountToBeTransferred);
			Integer differenceOfamount = Integer.sum(accountOfFrom.getAccountbalance(), -amountToBeTransferred);
			
			boolean isUpdateSumAccount = ebBankManagerImpl.updateAccount(accountOfTo,sumOfamount);
			boolean isUpdateDifferenceAccount = ebBankManagerImpl.updateAccount(accountOfFrom, differenceOfamount);
			
			if(isUpdateSumAccount && isUpdateDifferenceAccount){
				System.out.println("Amount has been transferred");
				System.out.println("your new balance of TO amount is : " + accountOfTo.getAccountbalance());
				System.out.println("your new balance of FROM amount is : " + accountOfFrom.getAccountbalance());
			}
		}
		
	}

}

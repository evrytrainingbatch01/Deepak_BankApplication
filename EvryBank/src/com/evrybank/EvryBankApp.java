package com.evrybank;

import java.util.Scanner;
import java.util.Set;

import com.evrybank.entity.Admin;
import com.evrybank.entity.Customer;
import com.evrybank.managerImpl.EBAdminManagerImpl;
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

		System.out.println("Select Your Choice");
		System.out.println("1.Get All Admins");
		System.out.println("2.Get Admin");
		System.out.println("3.Delete Admin");
		System.out.println("4.Update Admin");
		System.out.println("5.Add Customer");
		Integer choice = sc.nextInt();
		switch (choice) {
		case 1: getAllAdmins(sc, choice, ebAdminManagerImpl);
				break;
		case 2: getAdmin(sc, choice, ebAdminManagerImpl);
				break;
		case 3: deleteAdmin(sc, choice, ebAdminManagerImpl);
				break;
		case 4: updateAdmin(sc, choice, ebAdminManagerImpl);
				break;
		case 5: addCustomer(sc, choice, ebAdminManagerImpl);
		break;
		default:
				break;
		}


		
		
		
		
		
		
		
		
		EBCustomerManagerImpl ebCustomerManagerImpl = new EBCustomerManagerImpl();

		// VIEW ALL CUSTOMERS

		// ADD CUSTOMER

		// DELETE CUSTOMER

		// UPDATE CUSTOMER (ADD MONEY TO CUSTOMERS BALANCE_AMOUNT)

		System.out.println("------ THANK YOU !!! -------");
	}

	public static void getAllAdmins(Scanner sc, Integer choice, EBAdminManagerImpl ebAdminManagerImpl) {
		// GET ALL ADMINS
		if (choice.equals(1)) {
			Set<Admin> setOfAdmins = ebAdminManagerImpl.getAllAdmins();
			// System.out.println(setOfAdmins);
			System.out.println("The Admin users are : ");
			for (Admin adminUser : setOfAdmins) {
				System.out.println(adminUser.getId() + "\t" + adminUser.getFirstname() + "\t" + adminUser.getLastname()
						+ "\t" + adminUser.getAge());
			}
		}
	}

	public static void getAdmin(Scanner sc, Integer choice, EBAdminManagerImpl ebAdminManagerImpl) {
		// GET ADMIN
		if (choice.equals(2)) {
			System.out.println("Please provide id of user to be fetched from the database : ");
			Integer idOfAdminUserToBeFetched = sc.nextInt();
			Admin adminUser = ebAdminManagerImpl.getAdmin(idOfAdminUserToBeFetched);
			// System.out.println(setOfAdmins);
			System.out.println("Admin details : ");
			System.out.println(adminUser.getId() + "\t" + adminUser.getFirstname() + "\t" + adminUser.getLastname()
					+ "\t" + adminUser.getAge());
		}
	}

	public static void deleteAdmin(Scanner sc, Integer choice, EBAdminManagerImpl ebAdminManagerImpl) {
		// DELETE ADMIN
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

	public static void updateAdmin(Scanner sc, Integer choice, EBAdminManagerImpl ebAdminManagerImpl) {
		// UPDATE ADMIN USER
		if (choice.equals(4)) {
			boolean isNewAdminUpdationRequest = false;
			System.out.println("Are you sure you want to update Admin ? (true/false)");
			isNewAdminUpdationRequest = sc.nextBoolean();
			if (isNewAdminUpdationRequest == true) {
				System.out.println("Please provide id of user to be updated : ");
				Integer idOfAdminUserToBeUpdated = sc.nextInt();

				Admin adminUser = ebAdminManagerImpl.getAdmin(idOfAdminUserToBeUpdated);
				System.out.println("What you want to update from the below options ?");
				System.out.println("1. Update Firstname 2. Update Lastname 3. Update Age");
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
	
	
	public static void addCustomer(Scanner sc, Integer choice, EBAdminManagerImpl ebAdminManagerImpl) {
		// ADD CUSTOMER
		if (choice.equals(5)) {
			
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
			
			System.out.println("Would you like to add an amount to his/her balance initially ? true/false");
			boolean ifAddAmount = sc.nextBoolean();
			if(ifAddAmount){
				System.out.println("What is the amount that you would like to add initially?");
				newCustomer.setBalAmount(sc.nextInt());
			}
			
			boolean isNewCustomerCreated = ebAdminManagerImpl.addCustomer(newCustomer);
			if (isNewCustomerCreated) {
				System.out.println("New Customer Created Successfully");
			}
		}
	}
}

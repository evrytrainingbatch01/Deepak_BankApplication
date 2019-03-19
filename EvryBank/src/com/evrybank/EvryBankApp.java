package com.evrybank;

import java.util.Scanner;
import java.util.Set;

import com.evrybank.entity.Admin;
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
		System.out.println("Enter the method to be executed......");
		Scanner sc = new Scanner(System.in);
		String ebUserMethodInput = sc.next();

		EBAdminManagerImpl ebAdminManagerImpl = new EBAdminManagerImpl();

		// GET ALL ADMINS
		if (ebUserMethodInput.equalsIgnoreCase("getAllAdmins")) {
			Set<Admin> setOfAdmins = ebAdminManagerImpl.getAllAdmins();
			// System.out.println(setOfAdmins);
			System.out.println("The Admin users are : ");
			for (Admin adminUser : setOfAdmins) {
				System.out.println(adminUser.getId() + "\t" + adminUser.getFirstname() + "\t" + adminUser.getLastname()
						+ "\t" + adminUser.getAge());
			}
		}

		// GET ADMIN
		if (ebUserMethodInput.equalsIgnoreCase("getAdmin")) {
			System.out.println("Please provide id of user to be fetched from the database : ");
			Integer idOfAdminUserToBeFetched = sc.nextInt();
			Admin adminUser = ebAdminManagerImpl.getAdmin(idOfAdminUserToBeFetched);
			// System.out.println(setOfAdmins);
			System.out.println("Admin details : ");
			System.out.println(adminUser.getId() + "\t" + adminUser.getFirstname() + "\t" + adminUser.getLastname()
					+ "\t" + adminUser.getAge());
		}

		// DELETE ADMIN
		if (ebUserMethodInput.equalsIgnoreCase("deleteAdmin")) {
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

		// UPDATE ADMIN USER
		if (ebUserMethodInput.equalsIgnoreCase("updateAdmin")) {
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
				
				case 1: System.out.println("Update Firstname selected");
						System.out.println("What should be the firstname ?");
						adminUser.setFirstname(sc.next());
						System.out.println("Firstname Updated");
						break;
						
				case 2: System.out.println("Update Lastname selected");
						System.out.println("What should be the lastname ?");
						adminUser.setLastname(sc.next());
						System.out.println("Lastname Updated");
						break;
				
				case 3: System.out.println("Update Age selected");
						System.out.println("What should be the age ?");
						adminUser.setAge(sc.nextInt());
						System.out.println("Age Updated");
						break;

				case 0: System.out.println("Select an option");
						 break;
				}
				
				boolean isUpdated = ebAdminManagerImpl.updateAdmin(adminUser);
				if (isUpdated) {
					System.out.println("Admin User Updated");
				}
			}
		}

		EBCustomerManagerImpl ebCustomerManagerImpl = new EBCustomerManagerImpl();
		
		
		
		

		// VIEW ALL CUSTOMERS

		// ADD CUSTOMER

		// DELETE CUSTOMER

		// UPDATE CUSTOMER (ADD MONEY TO CUSTOMERS BALANCE_AMOUNT)
		
		
		
		

		System.out.println("------ THANK YOU !!! -------");
	}
}

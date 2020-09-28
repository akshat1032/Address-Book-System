package com.capgemini.addressbooksystem;

import java.util.ArrayList;
import java.util.Scanner;


public class AddressBookMain {
	
	public static void main(String[] args) {
		
		//Local variables
		String firstName;
		String lastName;
		String address;
		String cityName;
		long zipCode;
		long phoneNumber;
		String email;
		
		Scanner sc = new Scanner(System.in);
		boolean defaultOption = true;
		
		//Creating an array list for storing contacts
		ArrayList<ContactPerson> personObject = new ArrayList<>();
		
		//Loop to perform multiple operations based on user choice
		while (defaultOption) {
			
			//Enter user choice
			System.out.println("User choices : -\n1. ADD A NEW CONTACT\n2. EDIT A CONTACT\n3. DELETE A CONTACT\n4. PERFORM MORE OPERATIONS\n5. EXIT");
			System.out.println("Enter your choice");

			int choice = sc.nextInt();
			sc.nextLine();		

			switch(choice) {
			case 1:
				System.out.println("Enter the details of the person to be added");
				sc.nextLine();
				System.out.println("First name : ");
				firstName = sc.nextLine();
				System.out.println("Last name : ");
				lastName = sc.nextLine();
				System.out.println("Address : ");
				address = sc.nextLine();
				System.out.println("City Name : ");
				cityName = sc.nextLine();
				System.out.println("Zip Code : ");
				zipCode = sc.nextLong();
				System.out.println("Phone number : ");
				phoneNumber = sc.nextLong();
				sc.nextLine();
				System.out.println("Email : ");
				email = sc.nextLine();
				ContactPerson personContact = new ContactPerson();
			
				//Storing the contact details in Address Book
				personContact.setFirstName(firstName);
				personContact.setLastName(lastName);
				personContact.setAddress(address);
				personContact.setCityName(cityName);
				personContact.setZipCode(zipCode);
				personContact.setPhoneNumber(phoneNumber);
				personContact.setEmail(email);
				personObject.add(personContact);
				break;
			case 2:
				System.out.println("Enter the name of the contact to be edited");
				String firstNameToEdit = sc.next();
				int whileLoopCounter = 0;
				while(whileLoopCounter<personObject.size()) {
					
					if(firstNameToEdit.equals(personObject.get(whileLoopCounter).getFirstName())) {
						
						System.out.println("Enter the details of the person to be edited");
						System.out.println("Address : ");
						address = sc.nextLine();
						System.out.println("City Name : ");
						cityName = sc.nextLine();
						System.out.println("Zip Code : ");
						zipCode = sc.nextLong();
						System.out.println("Phone number : ");
						phoneNumber = sc.nextLong();
						sc.nextLine();
						System.out.println("Email : ");
						email = sc.nextLine();
						
						//Adding edited details to the address book
						personObject.get(whileLoopCounter).setAddress(address);
						personObject.get(whileLoopCounter).setCityName(cityName);
						personObject.get(whileLoopCounter).setZipCode(zipCode);
						personObject.get(whileLoopCounter).setPhoneNumber(phoneNumber);
						personObject.get(whileLoopCounter).setEmail(email);
					}
					whileLoopCounter++;
				}
				break;
			case 3:
				System.out.println("Enter the name of contact to be deleted");
				String firstNameToDelete = sc.next();
				int whileLoopCount = 0;
				while(whileLoopCount<personObject.size()) {
					
					if(firstNameToDelete.equals(personObject.get(whileLoopCount).getFirstName())) {
						
						System.out.println("Contact to be deleted");
						System.out.println("First name : "+personObject.get(whileLoopCount).getFirstName());
						System.out.println("Last name : "+personObject.get(whileLoopCount).getLastName());
						System.out.println("Address : "+personObject.get(whileLoopCount).getAddress());
						System.out.println("City Name : "+personObject.get(whileLoopCount).getCityName());
						System.out.println("Zip Code : "+personObject.get(whileLoopCount).getZipCode());
						System.out.println("Phone number : "+personObject.get(whileLoopCount).getPhoneNumber());
						System.out.println("Email : "+personObject.get(whileLoopCount).getEmail());
						//Deletion of record
						personObject.remove(whileLoopCount);
					}
					whileLoopCount++;
				}
				break;
			case 4:
				continue;
			case 5:
				defaultOption = false;
				break;
			default:
				System.exit(0);
			}
		}
	}
}

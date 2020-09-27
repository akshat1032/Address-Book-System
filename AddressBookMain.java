package com.capgemini.addressbooksystem;

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
		int personObjectCounter = 0;
		
		ContactPerson personObject[] = new ContactPerson[1000];//Assuming maximum no. of records to be stored is 1000
		
		//Loop to perform multiple operations based on user choice
		while (defaultOption) {
			
			//Enter user choice
			System.out.println("User choices : -\n1. ADD A NEW CONTACT\n2. EDIT A CONTACT\n3. PERFORM MORE OPERATIONS\n4. EXIT");
			System.out.println("Enter your choice");
			int choice = sc.nextInt();		
			

			//Storing the contact details in Address Book
			personObject[personObjectCounter] = new ContactPerson();
			personObject[personObjectCounter].setFirstName(firstName);
			personObject[personObjectCounter].setLastName(lastName);
			personObject[personObjectCounter].setAddress(address);
			personObject[personObjectCounter].setCityName(cityName);
			personObject[personObjectCounter].setZipCode(zipCode);
			personObject[personObjectCounter].setPhoneNumber(phoneNumber);
			personObject[personObjectCounter].setEmail(email);
			personObject[personObjectCounter].setPersonObject(personObject[personObjectCounter]);

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
			
				//Storing the contact details in Address Book
				personObject[personObjectCounter] = new ContactPerson();
				personObject[personObjectCounter].setFirstName(firstName);
				personObject[personObjectCounter].setLastName(lastName);
				personObject[personObjectCounter].setAddress(address);
				personObject[personObjectCounter].setCityName(cityName);
				personObject[personObjectCounter].setZipCode(zipCode);
				personObject[personObjectCounter].setPhoneNumber(phoneNumber);
				personObject[personObjectCounter].setEmail(email);
				personObject[personObjectCounter].setPersonObject(personObject[personObjectCounter]);
				personObjectCounter++;
				break;
			case 2:
				System.out.println("Enter the name of the contact to be edited");
				String firstNameToEdit = sc.next();
				int whileLoopCounter = 0;
				while(whileLoopCounter<1000) {
					if(firstNameToEdit.equals(personObject[whileLoopCounter].getFirstName())) {
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
						personObject[whileLoopCounter].setAddress(address);
						personObject[whileLoopCounter].setCityName(cityName);
						personObject[whileLoopCounter].setZipCode(zipCode);
						personObject[whileLoopCounter].setPhoneNumber(phoneNumber);
						personObject[whileLoopCounter].setEmail(email);
						personObject[whileLoopCounter].setPersonObject(personObject[whileLoopCounter]);
					}
					whileLoopCounter++;
				}
				break;
			case 3:
				continue;
			case 4:
				defaultOption = false;
			default:
				System.exit(0);
			}
		}
	}
}

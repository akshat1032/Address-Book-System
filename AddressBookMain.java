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
			
			//Asking for user's choice
			System.out.println("Do you wish to add another record?(Y/N)");
			char userChoice = sc.next().charAt(0);
			if (userChoice == 'Y' || userChoice == 'y') {
				personObjectCounter ++;
				defaultOption = true;
				continue;
			}
			else if (userChoice == 'N' || userChoice == 'n') {
				defaultOption = false;
			}
			else
				System.exit(0);
		}
	}
}

package com.capgemini.addressbooksystem;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

public class AddressBookMain {

	public static void main(String[] args) {

		// Local variables
		String firstName;
		String lastName;
		String address;
		String cityName;
		long zipCode;
		long phoneNumber;
		String email;

		Scanner sc = new Scanner(System.in);
		boolean defaultOption = true;

		System.out.println("Enter name for the address book");
		String addressBookName = sc.nextLine(); // Taking name of first address book

		// Creating an array list for storing contacts
		ArrayList<ContactPerson> personObject = new ArrayList<>();
		HashMap<String, ArrayList<ContactPerson>> addressBook = new HashMap<>();
		Dictionary<String,ArrayList<String>> cityPerson = new Hashtable<String, ArrayList<String>>();
		ArrayList<String> personName = new ArrayList<>();
		
		// Loop to perform multiple operations based on user choice
		while (defaultOption) {

			// Enter user choice
			System.out.println(
					"User choices : -\n1. ADD A NEW CONTACT\n2. EDIT A CONTACT\n3. DELETE A CONTACT\n4. ADD NEW ADDRESS BOOK\n5. SEARCH PERSON IN CITY \n6. VIEW PERSON BY CITY \n7. PERFORM MORE OPERATIONS\n8. EXIT");
			System.out.println("Enter your choice");

			int choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
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

				// Storing the contact details in Address Book
				personContact.setFirstName(firstName);
				personContact.setLastName(lastName);
				personContact.setAddress(address);
				personContact.setCityName(cityName);
				personContact.setZipCode(zipCode);
				personContact.setPhoneNumber(phoneNumber);
				personContact.setEmail(email);
				for (ContactPerson contactPerson : personObject) {
					if (contactPerson.equals(personContact)) {
						System.out.println("Duplicate person");
					} else {
						personObject.add(personContact);
						personName.add(personContact.getFirstName()+" "+personContact.getLastName());
					}
				}
				cityPerson.put(cityName, personName);
				
				break;
			case 2:
				System.out.println("Enter the name of the contact to be edited");
				String firstNameToEdit = sc.next();
				int whileLoopCounter = 0;
				while (whileLoopCounter < personObject.size()) {

					if (firstNameToEdit.equals(personObject.get(whileLoopCounter).getFirstName())) {

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

						// Adding edited details to the address book
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
				while (whileLoopCount < personObject.size()) {

					if (firstNameToDelete.equals(personObject.get(whileLoopCount).getFirstName())) {

						System.out.println("Contact to be deleted");
						System.out.println("First name : " + personObject.get(whileLoopCount).getFirstName());
						System.out.println("Last name : " + personObject.get(whileLoopCount).getLastName());
						System.out.println("Address : " + personObject.get(whileLoopCount).getAddress());
						System.out.println("City Name : " + personObject.get(whileLoopCount).getCityName());
						System.out.println("Zip Code : " + personObject.get(whileLoopCount).getZipCode());
						System.out.println("Phone number : " + personObject.get(whileLoopCount).getPhoneNumber());
						System.out.println("Email : " + personObject.get(whileLoopCount).getEmail());
						// Deletion of record
						personObject.remove(whileLoopCount);
					}
					whileLoopCount++;
				}
				break;
			case 4:
				addressBook.put(addressBookName, personObject);
				System.out.println("Enter the name for address book");
				addressBookName = sc.nextLine();
				personObject = new ArrayList<>();
				break;
			case 5:
				System.out.println("Enter the name of city to search for person");
				String city = sc.nextLine();
				for (String cityToSearch : addressBook.keySet()) {
					if (cityToSearch.contentEquals(city)) {
						System.out.println("City : "+cityToSearch);
						for (ContactPerson contactPerson : addressBook.get(cityToSearch)) {
							System.out.println("Person Name : " + contactPerson.getFirstName() + " "
									+ contactPerson.getLastName());
						}
					}
				}
				break;
			case 6:
				System.out.println("Enter the name of city to get list of person: ");
				String cityForPerson = sc.nextLine();
				Enumeration<String> keys = cityPerson.keys();
				if(cityForPerson.equals(keys)) {
					Enumeration<ArrayList<String>> person = cityPerson.elements();
					System.out.println("Person in city, "+cityForPerson);
					System.out.println(person);
				}
				break;
			case 7:
				addressBook.put(addressBookName, personObject);
				continue;
			case 8:
				addressBook.put(addressBookName, personObject);
				defaultOption = false;
				break;
			default:
				addressBook.put(addressBookName, personObject);
				System.exit(0);
			}
		}
	}
}

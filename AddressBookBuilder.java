package com.capgemini.addressbooksystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Logger;

public class AddressBookBuilder {

	public static void main(String[] args) {

		Logger logger = Logger.getLogger(AddressBookMain.class.getName());

		ArrayList<ContactPerson> personObjectList = new ArrayList<>();
		Map<String, ArrayList<ContactPerson>> addressBook = new HashMap<>();
		Map<String, List<String>> dictionaryCity = new HashMap<>();
		Map<String, List<String>> dictionaryState = new HashMap<>();

		AddressBookMain addressBookMain = new AddressBookMain(personObjectList, addressBook, dictionaryCity,
				dictionaryState);
		Scanner inputReader = new Scanner(System.in);
		int choice = 0;
		do {
			// Enter user choice
			System.out.println(
					"User choices : -\n1. ADD A NEW CONTACT\n2. EDIT A CONTACT\n3. DELETE A CONTACT\n4. ADD NEW ADDRESS BOOK\n5. SEARCH PERSON IN CITY OR STATE \n6. VIEW PERSON BY CITY OR STATE \n7. DISPLAY NUMBER OF PERSON BY CITY NAME \n8. SORT BY NAME AND PRINT\n9. SORT BY CHOICE AND PRINT \n10. WRITE DATA TO FILE \n11.EXIT");
			System.out.println("Enter your choice");

			choice = inputReader.nextInt();
			inputReader.nextLine();
			switch (choice) {
			case 1:
				addressBookMain.addPersonData(inputReader, logger);
				break;
			case 2:
				logger.info("Enter the name of the contact to be edited");
				logger.info("First Name :");
				String firstNameToEdit = inputReader.next();
				logger.info("Last Name :");
				String lastNameToEdit = inputReader.next();
				String isEdited = addressBookMain.editPersonData(inputReader, firstNameToEdit, lastNameToEdit, logger);
				if (isEdited == null)
					logger.info("Contact does not exist");
				else
					logger.info(firstNameToEdit + " " + lastNameToEdit + "details edited");
				break;
			case 3:
				logger.info("Enter the name of contact to be deleted");
				logger.info("First name : ");
				String firstNameToDelete = inputReader.next();
				logger.info("Last name : ");
				String lastNameToDelete = inputReader.next();
				String isDeleted = addressBookMain.deletePersonData(firstNameToDelete, lastNameToDelete, logger);
				if (isDeleted == null)
					logger.info("Contact does not exist");
				else
					logger.info(isDeleted + "\nDeleted");
				break;
			case 4:
				addressBookMain.createNewAddressBook(inputReader, logger);
				break;
			case 5:
				addressBookMain.searchPersonInCityOrState(inputReader, logger);
				break;
			case 6:
				addressBookMain.createDictionary();
				addressBookMain.printPersonByCityOrState(inputReader, logger);
				break;
			case 7:
				int noOfPerson = addressBookMain.countNoOfPersonByCityOrState(inputReader, logger);
				logger.info("No of person : " + noOfPerson);
				break;
			case 8:
				addressBookMain.sortByName();
				break;
			case 9:
				addressBookMain.sortByChoice(inputReader, logger);
				break;
			case 10:
				logger.info("Writing to file");
				addressBookMain.writeDataToFile();
				break;
			case 11:
				logger.info("EXITING");
				break;
			}
		} while (choice != 11);
	}
}

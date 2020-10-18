package com.capgemini.addressbooksystem;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import java.util.logging.Logger;

public class AddressBookMain {

	private ArrayList<ContactPerson> personObjectList;
	private Map<String, ArrayList<ContactPerson>> addressBook;
	private Map<String, List<String>> dictionaryCity;
	private Map<String, List<String>> dictionaryState;

	public AddressBookMain() {
	}

	public AddressBookMain(ArrayList<ContactPerson> personObjectList, Map<String, ArrayList<ContactPerson>> addressBook,
			Map<String, List<String>> dictionaryCity, Map<String, List<String>> dictionaryState) {
		this.personObjectList = personObjectList;
		this.addressBook = addressBook;
		this.dictionaryCity = dictionaryCity;
		this.dictionaryState = dictionaryState;
	}

	// Reading unique contact person data
	public void addPersonData(Scanner inputReader, Logger logger) {
		logger.info("Enter the details of the person to be added");
		inputReader.nextLine();
		logger.info("First name : ");
		String firstName = inputReader.next();
		logger.info("Last name : ");
		String lastName = inputReader.next();
		logger.info("Address : ");
		String address = inputReader.nextLine();
		logger.info("City Name : ");
		String cityName = inputReader.nextLine();
		logger.info("State Name : ");
		String stateName = inputReader.nextLine();
		logger.info("Zip Code : ");
		long zipCode = inputReader.nextLong();
		logger.info("Phone number : ");
		long phoneNumber = inputReader.nextLong();
		inputReader.nextLine();
		logger.info("Email : ");
		String email = inputReader.nextLine();
		boolean isDuplicate = this.personObjectList.stream().anyMatch(person -> person.equals(
				new ContactPerson(firstName, lastName, address, cityName, stateName, zipCode, phoneNumber, email)));
		if (isDuplicate == true) {
			logger.info("Contact already exists");
		} else
			personObjectList.add(
					new ContactPerson(firstName, lastName, address, cityName, stateName, zipCode, phoneNumber, email));
	}

	// Edit person data if person exits in list
	public String editPersonData(Scanner inputReader, String firstNameToEdit, String lastNameToEdit, Logger logger) {
		int personCounter = 0;
		while (personCounter < personObjectList.size()) {

			if (firstNameToEdit.equals(personObjectList.get(personCounter).getFirstName())
					&& lastNameToEdit.equals(personObjectList.get(personCounter).getLastName())) {
				logger.info("Enter the details of the person to be added");
				inputReader.nextLine();
				logger.info("First name : ");
				String firstName = inputReader.next();
				logger.info("Last name : ");
				String lastName = inputReader.next();
				logger.info("Address : ");
				String address = inputReader.nextLine();
				logger.info("City Name : ");
				String cityName = inputReader.nextLine();
				logger.info("State Name : ");
				String stateName = inputReader.nextLine();
				logger.info("Zip Code : ");
				long zipCode = inputReader.nextLong();
				logger.info("Phone number : ");
				long phoneNumber = inputReader.nextLong();
				inputReader.nextLine();
				logger.info("Email : ");
				String email = inputReader.nextLine();
				personObjectList.set(personCounter, new ContactPerson(firstName, lastName, address, cityName, stateName,
						zipCode, phoneNumber, email));
				return "Contact Edited";
			}
			personCounter++;
		}
		return null;
	}

	// Delete a person if person exists
	public String deletePersonData(String firstNameToDelete, String lastNameToDelete, Logger logger) {
		int personCounter = 0;
		String toDelete = null;
		while (personCounter < personObjectList.size()) {

			if (firstNameToDelete.equals(personObjectList.get(personCounter).getFirstName())
					&& lastNameToDelete.equals(personObjectList.get(personCounter).getLastName())) {
				logger.info("Contact to delete");
				toDelete = personObjectList.get(personCounter).toString();
				personObjectList.remove(personCounter);
				return toDelete;
			}
			personCounter++;
		}
		return null;
	}
	
	// Add the contacts to an address book
	public void createNewAddressBook(Scanner inputReader, Logger logger) {
		logger.info("Enter name for the address book");
		String addressBookName = inputReader.nextLine();
		this.addressBook.put(addressBookName, this.personObjectList);
		this.personObjectList = new ArrayList<ContactPerson>();
	}

	// Search person in city or state and display the person/ persons
	public void searchPersonInCityOrState(Scanner inputReader, Logger logger) {
		logger.info("Enter the name of city or state to search for person");
		logger.info("City Name : ");
		String cityToSearchForPerson = inputReader.nextLine();
		logger.info("State Name : ");
		String stateToSearchForPerson = inputReader.nextLine();
		addressBook.entrySet().stream()
				.forEach(key -> key.getValue().stream()
						.filter(person -> person.getCityName().equals(cityToSearchForPerson))
						.forEach(name -> System.out.println(name.getFirstName() + " " + name.getLastName())));

		addressBook.entrySet().stream()
				.forEach(key -> key.getValue().stream()
						.filter(person -> person.getStateName().equals(stateToSearchForPerson))
						.forEach(name -> System.out.println(name.getFirstName() + " " + name.getLastName())));
	}

	// Creating dictionary by city and person and state and person
	public void createDictionary() {
		List<String> personNameCity = new ArrayList<>();
		Iterator addressBookIterator = addressBook.entrySet().iterator();
		while (addressBookIterator.hasNext()) {
			Map.Entry<String, ArrayList<ContactPerson>> mapAddress = (Map.Entry<String, ArrayList<ContactPerson>>) addressBookIterator
					.next();
			ArrayList<ContactPerson> personList = mapAddress.getValue();
			for (ContactPerson contactPerson : personList) {
				String city = contactPerson.getCityName();
				for (ArrayList<ContactPerson> personData : addressBook.values()) {
					if (city.equals(personData.iterator().next().getCityName())) {
						personNameCity.add(personData.iterator().next().getFirstName() + " "
								+ personData.iterator().next().getLastName());
					}
				}
				dictionaryCity.put(city, personNameCity);
				personNameCity = new ArrayList<>();
			}
		}

		List<String> personNameState = new ArrayList<>();
		Iterator addressBookIterator2 = addressBook.entrySet().iterator();
		while (addressBookIterator2.hasNext()) {
			Map.Entry<String, ArrayList<ContactPerson>> mapAddress = (Map.Entry<String, ArrayList<ContactPerson>>) addressBookIterator2
					.next();
			ArrayList<ContactPerson> personList = mapAddress.getValue();
			for (ContactPerson contactPerson : personList) {
				String state = contactPerson.getStateName();
				for (ArrayList<ContactPerson> personData : addressBook.values()) {
					if (state.equals(personData.iterator().next().getCityName())) {
						personNameState.add(personData.iterator().next().getFirstName() + " "
								+ personData.iterator().next().getLastName());
					}
				}
				dictionaryState.put(state, personNameState);
				personNameState = new ArrayList<>();
			}
		}
	}

	// Print person by city or state
	public void printPersonByCityOrState(Scanner inputReader, Logger logger) {
		int choice = 0;
		do {
			logger.info("Do you want to print person in city or state?\nEnter 1 for city\nEnter 2 for state");
			choice = inputReader.nextInt();
			if (choice != 1 || choice != 2) {
				logger.info("Enter choice again");
				continue;
			}
		} while (choice != 1 || choice != 2);
		if (choice == 1) {
			logger.info("Enter city to print person");
			String city = inputReader.nextLine();
			dictionaryCity.get(city).forEach(System.out::println);
		} else {
			logger.info("Enter state to print person");
			String state = inputReader.nextLine();
			dictionaryState.get(state).forEach(System.out::println);
		}
	}

	// Count no of person by city or state
	public int countNoOfPersonByCityOrState(Scanner inputReader, Logger logger) {
		int choice = 0;
		do {
			logger.info("Do you want to count no of person in city or state?\nEnter 1 for city\nEnter 2 for state");
			choice = inputReader.nextInt();
			if (choice != 1 || choice != 2) {
				logger.info("Enter choice again");
				continue;
			}
		} while (choice != 1 || choice != 2);
		if (choice == 1) {
			logger.info("Enter name of city to count person");
			String city = inputReader.nextLine();
			return dictionaryCity.get(city).size();
		} else {
			logger.info("Enter name of state to count person");
			String state = inputReader.nextLine();
			return dictionaryState.get(state).size();
		}
	}

	// Sort entries alphabetically by first name
	public void sortByName() {
		addressBook.entrySet().stream()
				.forEach(key -> key.getValue().stream().sorted(
						(personName1, personName2) -> personName1.getFirstName().compareTo(personName2.getFirstName()))
						.collect(Collectors.toList()));
		addressBook.entrySet().stream().forEach(key -> System.out.print(key.getValue()));
	}

	// Sort by choice
	public void sortByChoice(Scanner inputReader, Logger logger) {
		int choice = 0;
		do {
			logger.info("Options\n1. Sort By City\n2. Sort By State\n3. Sort By Zip");
			choice = inputReader.nextInt();
			if (choice != 1 || choice != 2 || choice != 3) {
				logger.info("Wrong choice");
				continue;
			}
		} while (choice != 1 || choice != 2 || choice != 3);
		if (choice == 1) {
			addressBook.entrySet().stream().forEach(key -> key.getValue().stream().sorted(
					(personName1, personName2) -> personName1.getCityName().compareTo(personName2.getCityName()))
					.collect(Collectors.toList()));
			logger.info("Sorted by city name");
			addressBook.entrySet().stream().forEach(key -> System.out.print(key.getValue()));
		} else if (choice == 2) {
			addressBook.entrySet().stream().forEach(key -> key.getValue().stream().sorted(
					(personName1, personName2) -> personName1.getStateName().compareTo(personName2.getStateName()))
					.collect(Collectors.toList()));
			logger.info("Sorted by state name");
			addressBook.entrySet().stream().forEach(key -> System.out.print(key.getValue()));
		} else {
			addressBook.entrySet().stream()
					.forEach(key -> key
							.getValue().stream().sorted((personName1, personName2) -> Long
									.valueOf(personName1.getZipCode()).compareTo(personName2.getZipCode()))
							.collect(Collectors.toList()));
			logger.info("Sorted by zip code");
			addressBook.entrySet().stream().forEach(key -> System.out.print(key.getValue()));
		}
	}
}

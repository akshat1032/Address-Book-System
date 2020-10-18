package com.capgemini.addressbooksystem;

public class ContactPerson {

	// Variables
	private String firstName;
	private String lastName;
	private String address;
	private String cityName;
	private String stateName;
	private long zipCode;
	private long phoneNumber;
	private String email;

	// Param constructor to initialize the field
	public ContactPerson(String firstName, String lastName, String address, String cityName, String stateName,
			long zipCode, long phoneNumber, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.cityName = cityName;
		this.stateName = stateName;
		this.zipCode = zipCode;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAddress() {
		return address;
	}

	public String getCityName() {
		return cityName;
	}

	public String getStateName() {
		return stateName;
	}

	public long getZipCode() {
		return zipCode;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	// Override equals method
	public boolean equals(ContactPerson person) {
		if (this.firstName.equals(person.firstName) && this.lastName.equals(person.lastName)) {
			return true;
		} else {
			return false;
		}
	}

	// Overriding toString method
	public String toString() {
		return "Name : " + this.firstName + " " + this.lastName + "\nAddress : " + this.address + "\nCity : "
				+ this.cityName + "\nState : " + this.stateName + "\nZip Code : " + this.zipCode + "\nPhone Number : "
				+ this.phoneNumber + "\nEmail : " + this.email;
	}
}

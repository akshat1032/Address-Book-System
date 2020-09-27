package com.capgemini.addressbooksystem;

public class ContactPerson {
	
	//Variables
	private String firstName;
	private String lastName;
	private String address;
	private String cityName;
	private long zipCode;
	private long phoneNumber;
	private String email;
	
	//Constructor to initialize the Address Book
	public ContactPerson(String firstName,String lastName, String address, String cityName, long zipCode, long phoneNumber, String email) {
		
		// TODO Auto-generated constructor stub
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.cityName = cityName;
		this.zipCode = zipCode;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}
}

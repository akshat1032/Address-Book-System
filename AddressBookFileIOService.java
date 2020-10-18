package com.capgemini.addressbooksystem;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class AddressBookFileIOService {
	
	public static String addressBookFile = "D:\\project\\AddressBookSystem\\src\\com\\capgemini\\addressbooksystem\\AddressBook.txt";
	
	public void writeToFile(List<ContactPerson> personObjectList) {
		StringBuffer addressBookBuffer = new StringBuffer();
		personObjectList.forEach(person ->{
			String personData = person.toString().concat("\n");
			addressBookBuffer.append(personData);
		});
		try {
			Files.write(Paths.get(addressBookFile), addressBookBuffer.toString().getBytes());
		}catch(IOException e) {}
	}
}

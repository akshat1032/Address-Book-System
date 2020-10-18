package com.capgemini.addressbooksystem;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import com.google.gson.Gson;

public class AddressBookSystemJSonService {

	// field to store address book path
	private static final String ADDRESSBOOK_JSON_FILE_PATH = "D:\\project\\AddressBookSystem\\src\\com\\capgemini\\addressbooksystem\\AddressBookJ.json";

	// writing data into file
	public void writeDataJson() throws IOException {
		Writer writeToFile = Files.newBufferedWriter(Paths.get(ADDRESSBOOK_JSON_FILE_PATH));
		List<ContactPerson> personObjectList = new ArrayList<>();
		personObjectList.add(new ContactPerson("Naruto", "Uzumaki", "Hokage Office", "Konohagakure", "Fire", 800065,
				78456987, "uzumakinaruto@gmail.com"));
		personObjectList.add(new ContactPerson("Sasuke", "Uchiha", "Ronin", "Konohagakure", "Mist", 900087, 6523147,
				"sasuke.sharingan@gmail.com"));		
		new Gson().toJson(personObjectList, writeToFile);
		writeToFile.close();
	}
	
	// reading data from a file
	public void readDataJson(Logger logger) throws IOException {
		List<ContactPerson> personsObjectList = new ArrayList<ContactPerson>();
		try {
			Reader readFromFile = Files.newBufferedReader(Paths.get(ADDRESSBOOK_JSON_FILE_PATH));
			logger.warning(" "+personsObjectList.addAll(Arrays.asList(new Gson().fromJson(readFromFile, ContactPerson[].class))));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}

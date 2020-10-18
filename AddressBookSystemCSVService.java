package com.capgemini.addressbooksystem;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.opencsv.CSVReader;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;

public class AddressBookSystemCSVService {
	// field to store address book path
	private static final String ADDRESSBOOK_CSV_FILE_PATH = "D:\\project\\AddressBookSystem\\src\\com\\capgemini\\addressbooksystem\\AddressBook.csv";

	// write data to csv file
	public void writeCSVData() throws Exception {
		try (Writer writer = Files.newBufferedWriter(Paths.get(ADDRESSBOOK_CSV_FILE_PATH));) {
			StatefulBeanToCsvBuilder<ContactPerson> builder = new StatefulBeanToCsvBuilder<>(writer);
			StatefulBeanToCsv<ContactPerson> beanWriter = builder.build();
			List<ContactPerson> personObjectList = new ArrayList<>();
			personObjectList.add(new ContactPerson("Naruto", "Uzumaki", "Hokage Office", "Konohagakure", "Fire", 800065,
					78456987, "uzumakinaruto@gmail.com"));
			personObjectList.add(new ContactPerson("Sasuke", "Uchiha", "Ronin", "Konohagakure", "Mist", 900087, 6523147,
					"sasuke.sharingan@gmail.com"));
			beanWriter.write(personObjectList);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// read data from csv file
	public void readCSVData(Logger logger) throws Exception {
		try (Reader personDataReader = Files.newBufferedReader(Paths.get(ADDRESSBOOK_CSV_FILE_PATH));
				CSVReader cSVReader = new CSVReader(personDataReader);) {
			String recordOfPerson[];
			while ((recordOfPerson = cSVReader.readNext()) != null) {
				logger.info("Name : " + recordOfPerson[0] + " " + recordOfPerson[1]);
				logger.info("Address : " + recordOfPerson[2]);
				logger.info("City : " + recordOfPerson[3]);
				logger.info("State : " + recordOfPerson[4]);
				logger.info("Zip Code : " + recordOfPerson[5]);
				logger.info("Phone number : " + recordOfPerson[6]);
				logger.info("Email : " + recordOfPerson[7]);
			}
		} catch (IOException e) {
		}
	}
}

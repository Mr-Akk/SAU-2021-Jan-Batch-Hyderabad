package com.java.fundamentals;

import java.io.BufferedWriter;
import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import javax.swing.text.GapContent;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import com.java.schema.StudentSchema;
import com.java.schema.WithRankSchema;


public class Main {
	
	static Students students;
	static HashMap<Integer, Integer> marksRollHashMap = new HashMap<Integer, Integer>();
	static List<WithRankSchema> toppers;
	
	static void parse() throws Exception {
		
		try {
			File file = new File("./src/com/java/fundamentals/studentsdata.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Students.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			students = (Students) jaxbUnmarshaller.unmarshal(file);
			
			System.out.println("Parsed Objects");
			System.out.println(students);
		}catch (Exception e) {
			throw new Exception("Error while parsing!!");
		}
	}
	
static void groupTheStudents() throws Exception {
	for(Student s : students.getStudent()) {
		
		if(s.getMarks()<0) {
			throw new Exception("Negative values are not allowed as marks");
		}
		else {
			
			if(marksRollHashMap.containsKey(s.getRoll())) {
				
				int curMark = s.getMarks();
				int prevMark = marksRollHashMap.get(s.getRoll());
				marksRollHashMap.put(s.getRoll(), curMark+prevMark);
				
			}
			else {
				marksRollHashMap.put(s.getRoll(), s.getMarks());
			}
		}
	}
	
	for(Integer i : marksRollHashMap.keySet()) {
		System.out.println("rollno " + i + "with marks " + marksRollHashMap.get(i) );
	}
	}
	
	static void executeSingleton() {
		Singleton singleton = Singleton.getInstance();
		singleton.printString();
	}
	
	static List<WithRankSchema> getToppers(int n , List<StudentSchema> list) {
		
		
		List<WithRankSchema> toppersList = new ArrayList<WithRankSchema>();
		HashMap<Integer, Integer> checkRank = new HashMap<Integer, Integer>();
		
		int count = 0;
		int rank = 0;
		for(StudentSchema sSchema : list) {
			
			if(checkRank.containsKey(sSchema.getMark())) {
				toppersList.add(new WithRankSchema(rank , sSchema.getRoll() , sSchema.getMark()));
			}
			else {
				count++;
				rank++;
				if(count>n) {
					break;
				}
				else {
					toppersList.add(new WithRankSchema(rank , sSchema.getRoll() , sSchema.getMark()));

				}
			}
			
		}
		
			return toppersList;
			
	}
	
	static void serialize() throws Exception  {
		try {
			FileOutputStream fileOutputStream = new FileOutputStream("studentsdata.txt");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			
			//converting it to a schema for serialisation
			
			for(Integer i : marksRollHashMap.keySet() ) {
				StudentSchema sSchema = new StudentSchema(i , marksRollHashMap.get(i));
//				System.out.println(sSchema);
				objectOutputStream.writeObject(sSchema);
				System.out.println("Student with rollno " + i + " serialized");
			}
		} catch (Exception e) {
			throw new Exception("Error while serializing");
			
		}
		
	}
	
	static void deSerialize() throws FileNotFoundException, IOException {
		List<StudentSchema> sSchemaList = new ArrayList<StudentSchema>();
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("studentsdata.txt"));
		try {
			while(true) {
				
				StudentSchema sDeserialised = (StudentSchema)in.readObject();
				sSchemaList.add(sDeserialised);
				System.out.println(sDeserialised);

				
			}
		}
		
		//will always create a error
		catch (Exception e) {
				System.out.println("Deserialization Over ");
				System.out.println();
		}
		

		Collections.sort(sSchemaList);
//		System.out.println(sSchemaList);
		
		System.out.println("Top n rank students are");
		toppers =  getToppers(3, sSchemaList);
		for(WithRankSchema t : toppers) {
			System.out.println(t);
		}
		
	}
	
	static void writeToCsv() throws Exception {
		try {
			FileWriter fw = new FileWriter("toppers.csv");
			BufferedWriter bw = new BufferedWriter(fw);
			
			for(WithRankSchema s : toppers) {
			
				PrintWriter pw = new PrintWriter(bw);
	        	pw.println(s.getRank() + "," + s.getRoll() +","+s.getMarks());
	        	pw.flush();

	        	
	        }
		} catch (Exception e) {
			throw new Exception("Error when writing to csv");
		}
	}
	public static void main(String[] args) throws Exception {
	
	
		System.out.println("parsing starts!");
		parse();
		System.out.println();
		
		
		System.out.println("grouping starts");
		System.out.println("Grouped Students ");
		groupTheStudents();
		System.out.println();
		
		System.out.println("Serialization starts!!!");
		serialize();
		System.out.println();
		
		System.out.println("deserialization starts");
		deSerialize();
		System.out.println();
		
		System.out.println("csv writing starts!!!!!!");
		writeToCsv();
		
		
		System.out.println("executing singleton");
		executeSingleton();
		System.out.println();
		System.out.println("all done");

}

	 
	
	}

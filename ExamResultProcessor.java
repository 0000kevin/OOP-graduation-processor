/**
 * 
 */
package mscGraduationProcessor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Kevin O'Shea
 *
 */
public class ExamResultProcessor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<MScStudent> students = new ArrayList<>();
		String[] studentDetails;
		String studentRecord;
		File moduleScores = new File("ModuleScoresMSc.csv");
		
		try {
			FileReader fr = new FileReader(moduleScores);
			BufferedReader br = new BufferedReader(fr);
			
			br.readLine();
			studentRecord = br.readLine();
			
			while(studentRecord!=null) {
				MScStudent student = new MScStudent();
				studentDetails = studentRecord.split(",");
				student.setStudentNumber(Integer.parseInt(studentDetails[0]));
				student.setFirstName(studentDetails[1]);
				student.setLastName(studentDetails[2]);
				student.setProgramming(Integer.parseInt(studentDetails[3]));
				student.setCompFound(Integer.parseInt(studentDetails[4]));
				student.setDatabases(Integer.parseInt(studentDetails[5]));
				student.setWebDev(Integer.parseInt(studentDetails[6]));
				student.setSoftwareEng(Integer.parseInt(studentDetails[7]));
				
				students.add(student);
				studentRecord = br.readLine();
			}
			
			fr.close();
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		for(MScStudent student : students) {
			student.classifyStudent();
			student.displayStudentClassicitaions();
		}
		
		System.out.println("Number of records: "+students.size());
			
		File file = new File("ListForGraduation.txt");
		
		
		try {
			while(!file.exists()){
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			
			for(MScStudent student : students) {
				bw.write(student.getStudentNumber()+", "+student.getFirstName()+", "+student.getLastName()+", "+student.getClassification()+"\n");
			}
			bw.close();
			fw.close();
			
		} catch (IOException e) {
			System.out.println("Not able to write to file");
			e.printStackTrace();
		}
		

	}

}

/**
 * 
 */
package mscGraduationProcessor;

/**
 * @author Kevin O'Shea
 *
 */
public class MScStudent extends Student {
	private int programming;
	private int compFound;
	private int databases;
	private int webDev;
	private int softwareEng;
	
	private String clasification = "Not Available";
	
	public MScStudent() {
		
	}

	/**
	 * @param studentNumber
	 * @param firstName
	 * @param lastName
	 * @param programming
	 * @param compFound
	 * @param databases
	 * @param webDev
	 * @param softwareEng
	 */
	public MScStudent(int studentNumber, String firstName, String lastName, int programming, int compFound, int databases, int webDev, int softwareEng) {
		super(studentNumber, firstName, lastName);
		this.programming = programming;
		this.compFound = compFound;
		this.databases = databases;
		this.webDev = webDev;
		this.softwareEng = softwareEng;
	}

	/**
	 * @return the programming
	 */
	public int getProgramming() {
		return programming;
	}

	/**
	 * @param programming the programming to set
	 */
	public void setProgramming(int programming) {
		this.programming = programming;
	}
	
	/**
	 * @return the compFound
	 */
	public int getCompFound() {
		return compFound;
	}

	/**
	 * @param compFound the compFound to set
	 */
	public void setCompFound(int compFound) {
		this.compFound = compFound;
	}

	/**
	 * @return the databases
	 */
	public int getDatabases() {
		return databases;
	}

	/**
	 * @param databases the databases to set
	 */
	public void setDatabases(int databases) {
		this.databases = databases;
	}

	/**
	 * @return the webDev
	 */
	public int getWebDev() {
		return webDev;
	}

	/**
	 * @param webDev the webDev to set
	 */
	public void setWebDev(int webDev) {
		this.webDev = webDev;
	}

	/**
	 * @return the softwareEng
	 */
	public int getSoftwareEng() {
		return softwareEng;
	}

	/**
	 * @param softwareEng the softwareEng to set
	 */
	public void setSoftwareEng(int softwareEng) {
		this.softwareEng = softwareEng;
	}
	
	/**
	 * Gets the classification
	 * @return
	 */
	public String getClassification() {
		return this.clasification;
	}

	/**
	 * Outputs all fields to screen
	 */
	public void displayStudentRecord() {
		System.out.println("Student no.: \t"+this.getStudentNumber());
		System.out.println("First Name: \t"+this.getFirstName());
		System.out.println("Last Name: \t"+this.getLastName());
		System.out.println("Module Results");
		System.out.println("Programming: \t"+this.programming);
		System.out.println("Comp Found: \t"+this.compFound);
		System.out.println("DBs: \t\t"+this.databases);
		System.out.println("Web Dev: \t"+this.webDev);
		System.out.println("Software Eng: \t"+this.softwareEng);
		System.out.println("Average: \t"+this.calculateAverage());
		System.out.println("Classification: "+this.clasification);
	}

	public void displayStudentClassicitaions() {
		System.out.println("Student no.: \t"+this.getStudentNumber());
		System.out.println("First Name: \t"+this.getFirstName());
		System.out.println("Last Name: \t"+this.getLastName());
		System.out.println("Average: \t"+this.calculateAverage());
		System.out.println("Classification: "+this.getClassification());
	}
	
	public int calculateAverage() {
		int average;
		average = (((this.programming*2)+this.compFound+this.databases+this.webDev+this.softwareEng)/6);
		return average;
	}
	
	/**
	 * Calculates and sets the classification for this student
	 * error < 0 or > 100
	 * distinction 70 - 100
	 * commendation 60 - 69 
	 * pass 50 -59
	 * fail 0 - 49 
	 */
	public void classifyStudent() {
		int average = calculateAverage();
		if(average<0 || average>100) {
			this.clasification = "Error";
		} else if(average>=69 && average<=100) {
			this.clasification = "Distinction";
		} else if(average>=60 && average<=69) {
			this.clasification = "Commendation";
		} else if(average>=50 && average <=59) {
			this.clasification = "Pass";
		} else if(average>=0 && average <=49) {
			this.clasification = "Fail";
		}
	}
	
	
}

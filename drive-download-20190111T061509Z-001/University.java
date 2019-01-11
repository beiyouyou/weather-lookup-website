
public class University {
	private String name;
	private Student[] allStudents;
	private int numStudents; // actual number enrolled
	
	private  final int MAX_CAPACITY; // largest the student array can be
	public static final int DEFAULT_CAPACITY = 20;
	
	
	/**
	 * @param name
	 * @param allStudents: array of max capacity for the University
	 *  but array may be partially filled from the left
	 */
	public University(String name, Student[] allStudents) {
		this.name = name;
		this.allStudents = allStudents;
		MAX_CAPACITY = allStudents.length;
		numStudents = countActualStudentsInArray(allStudents);
		
	}
	public University(String name) {
		this(name, new Student[DEFAULT_CAPACITY]);
	}
	public University(String name, int maxStudents) {
		this(name, new Student[maxStudents]);
	}
	
	public void enrollStudent(Student c) {
		//todo make sure array stays within bounds
		allStudents[numStudents] = c;
		numStudents++;
	}
	public void printStudents() {
		for(int i = 0; i < numStudents; i++) {
			System.out.println(allStudents[i]);
		}
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the allStudents
	 */
	public Student[] getAllStudents() {
		return allStudents;
	}
	/**
	 * @return the numStudents
	 */
	public int getNumStudents() {
		return numStudents;
	}
	private int countActualStudentsInArray(Student[] allStudents2) {
		// TODO Auto-generated method stub
		return 0;
	}


	
	
}

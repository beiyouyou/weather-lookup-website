/**
 * 
 */

/**
 * @author kendra
 *
 */
public class Student {
	//instance variables
	private String name;
	private int age;
	private double gpa;
	private String major;
	private boolean needsCoffee;
	/**
	 * @param name
	 * @param age
	 * @param gpa
	 * @param major
	 * @param needsCoffee
	 */
	public Student(String name, int age, double gpa, String major, 
			boolean needsCoffee) {
		this.name = name;
		this.age = age;
		this.gpa = gpa;
		this.major = major;
		this.needsCoffee = needsCoffee;
	}
	/**
	 * @param name
	 * @param age
	 * @param gpa
	 * @param major
	 */
	public Student(String name, int age, double gpa, String major) {
		this(name, age, gpa, major, true);
	}
	/**
	 * @param name
	 * @param age
	 */
	public Student(String name, int age) {
		this(name, age, 4.0, "undeclared", true);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", gpa=" + gpa + ", major=" + major + ", needsCoffee="
				+ needsCoffee + "]";
	}
	public void doHomework() {
		System.out.println(name + " is doing homework");
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
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * @return the major
	 */
	public String getMajor() {
		return major;
	}
	/**
	 * @param major the major to set
	 */
	public void setMajor(String major) {
		this.major = major;
	}
	/**
	 * @return the needsCoffee
	 */
	public boolean needsCoffee() {
		return needsCoffee;
	}
	/**
	 * @param needsCoffee the needsCoffee to set
	 */
	public void setNeedsCoffee(boolean needsCoffee) {
		this.needsCoffee = needsCoffee;
	}
	/**
	 * @return the gpa
	 */
	public double getGpa() {
		return gpa;
	}
	
	
}

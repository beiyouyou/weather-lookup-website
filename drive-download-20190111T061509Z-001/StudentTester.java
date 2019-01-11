
public class StudentTester {
	private Student x;
	private Student y;
	
	public StudentTester() {
		x = new Student("Aaron", 19, 4.0, "CS");
		y = new Student("Mitchell", 21);
	}
	public static void main(String[] args) {
		StudentTester test = new StudentTester();
		test.run();
	}
	private void run() {
		System.out.println("Student x is: " + x);
		
		System.out.println("Student y is: " + y);
		x.doHomework();
		y.doHomework();
	}

}

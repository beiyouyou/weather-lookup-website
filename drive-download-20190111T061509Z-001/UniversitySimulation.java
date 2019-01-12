import java.util.Scanner;

public class UniversitySimulation {
	private University u;
	private Scanner sc;
	
	public UniversitySimulation(){
		u = new University("USC");
		sc = new Scanner(System.in);
	}
	
	public static void main(String[] args) {
		UniversitySimulation sim = new UniversitySimulation();
		sim.run();
	}

	private void run() {
		System.out.println("Welcome to the simulation\n" + u);
			boolean keepGoing = true;
		do {
			System.out.println("1 to enroll student");
			System.out.println("2 to print all students");
			System.out.println("3 to quit");
			
			int choice = InputHelper.getInt("What's your choice?", sc);
			
			switch(choice) {
			case 1: enroll(); break;
			case 2: u.printStudents(); break;
			case 3: keepGoing = false; break;
			default: System.out.println(choice + " NOT recognized");
			}
		}while(keepGoing);		
	}

	private void enroll() {
		System.out.println("Enter name");
	
		String name = sc.nextLine();
		u.enrollStudent(new Student(name, 18));
		
	}
}

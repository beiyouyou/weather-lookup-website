


/* It is the companyUI class that tests the functionality of your company class
 * 
 * @author Beiyou Zhu
 * ITP 368, Fall 2018
 * Assignment1
 * beiyouzh@usc.edu
 */
import java.util.Scanner;

public class MyCompanyUI {

	private Scanner sc;
	private Company myCompany;

	public MyCompanyUI() {
		sc = new Scanner(System.in);
	}


	public static void main(String[] args) {
		MyCompanyUI commandUI = new MyCompanyUI();
		commandUI.run(); 
	}


	private void run() {
		
		//Test 1: making a company with no users and printing it
		System.out.println("*** User Interface for Company Systems. ***\n\nTest1: simple company constructor"); 
		printCompany(new Company("Sample 1"));
		InputHelper.getString("Hit enter to continue", sc);

		//Test 2: making a company with 3 users and printing it
		System.out.println("Test2: company with predefined users"); 
		Company sampleCompany = new Company("Ocean-Sand Inc", new User[]{ new User("Tommy", "tom@email.com", "pass" ), 
																			new User("curtis",  "curtis@email.com", "asdf"), 
																			new User("Sally", "sally@email.com" , "1234"), null});
		printCompany(sampleCompany);
		InputHelper.getString("Hit enter to continue", sc);

		//Test 3: using company from test 2 and checking password feature
		System.out.println("Test3: testing user functionality for " + sampleCompany.getName()); 
		User user = sampleCompany.getUsers()[0];  // user Tommy from above
		testUserFunctionality(user);
		InputHelper.getString("Hit enter to continue", sc);
		
		//Test 4: using company from test 2 and seeing if find user works
		System.out.println("Test4: testing user functionality (finding a user based on name) "); 
		User u1 = sampleCompany.findUserByName("Sally"); //in array
		User u2 = sampleCompany.findUserByName("Kendra"); //not in array, will be null
		User u3 = sampleCompany.findUserByEmail("tom@email.com"); //in array
		System.out.println("u1 should be valid user Sally -->" + u1);
		System.out.println("u2 kendra is not in company sample2, should be null  -->" + u2);
		System.out.println("u3 should be user with email tom@email.com-->" + u3);
		InputHelper.getString("Hit enter to continue", sc);
		
		//Test 5: making your own company, using InputHelper
		System.out.println("Test5: creating company with user input: "); 
		myCompany = initializeCompany();
		printCompany(myCompany);
		InputHelper.getString("Hit enter to continue", sc);


		System.out.println("AUTOMATIC TESTING ENDED, you may add your own tests if there is functionality you still aren't sure about");
	}



	/**
	 * @param myCompany
	 */
	private  void testUserFunctionality(User user) {
		System.out.println("user is: " + user);
		String current = InputHelper.getString("Please enter password for " + user.getName() + " Hint: it's \"pass\"", sc);
		if(user.checkPassword(current)) {
			String prompt = "Password is correct. Would you like to change it (y/n)?";
			boolean wantsToChange = InputHelper.getBoolean(prompt, sc);
			if(wantsToChange) {
				String newPword = InputHelper.getString("Please enter new password  ", sc);
				System.out.println("The new password: " + newPword);
				boolean changed = user.changePassword(current, newPword);
				if (changed) System.out.println("Password updated");
				else System.out.println("Mismatch. Password NOT changed.");

			}
		}
		else {
			System.out.println("Password is not correct.");
		}
	}

	// DO NOT EDIT: prints company information (for any given company)
	private static void printCompany(Company com) {
		System.out.println("Made the company: (ugly printing) \n" + com);
		System.out.println("COMPANY: " + com.getName());
		System.out.printf("%d/%d users currently in database %n", com.getCurrentNumUsers(), com.getMaxCapacity());
		System.out.println(com.usersToString());

	}

	// DO NOT EDIT: initializes and returns a Company object
	private static Company initializeCompany() {
		Company c;
		Scanner sc = new Scanner(System.in);
		String name = InputHelper.getString("Welcome. Please enter name for your company: ", sc);

		int numMax = InputHelper.getInt("Please enter MAXIMUM number of users", 2 , 1000, sc);


		User[] myUsers = new User[numMax];
		int numUsers = InputHelper.getInt("Please enter current number of users to be entered:", 0, numMax, sc);
		for(int i = 0; i < numUsers; i++ ) {
			System.out.println("Enter user #" + (i+1));
			myUsers[i] = InputHelper.getUserObject(sc);
		}
		c = new Company(name, myUsers);

		return c;
	}
}

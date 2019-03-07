package BackEnd;

import java.util.List;

public class testapo {
	public static void main(String[]args) {
	String username = "kerenli";
	String password= "beiyou";
	System.out.println(validation.validateUsername(username));
	System.out.println(validation.validatePassword(username, password));
	
	List<String> result3 = validation.searchResult("beiyouzh");
	for(String s: result3) {
		System.out.println(s);
	}
	}
}

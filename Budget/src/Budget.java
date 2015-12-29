import java.io.IOException;
import java.util.Scanner;
import java.net.*;

import javax.mail.internet.*;

public class Budget {
	public static void main(String[] args){
		AccountManager am = new AccountManager();
		am.read_CSV_file("../testBudget.csv");
		String lOrR = loginOrRegister();
		
		if(lOrR.equalsIgnoreCase("login")){
			try {
				Account account = logIntoAccount();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(lOrR.equalsIgnoreCase("register")){
			System.out.println("Registration");
			try {
				Account account = registerAccount(am);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

	
	private static String loginOrRegister() {
		// TODO Auto-generated method stub
		System.out.println("Would you like to login or register? Please type help if needed");
	    // create a scanner so we can read the command-line input
	    Scanner scanner = new Scanner(System.in);
	    String loginOrReg = scanner.next();
	    // Checking weather the user wants to register or login
	    //Loops until either chose is made
	    for(;; loginOrReg = scanner.next()){
	    	
		    if(loginOrReg.equalsIgnoreCase("login")){
		    	break;
		    }
		    else if(loginOrReg.equalsIgnoreCase("register")){
		    	break;
		    }
		    //help statement if user needs help choosing
		    else if(loginOrReg.equalsIgnoreCase("help")){
		    	System.out.print("-Type 'login' to log into account\n"
		    					+ "-Type 'register' to register\n");
		    	System.out.println("Would you like to log in or register?");
		    }
		    else{
		    	System.out.println("Invalid input:");
		    	System.out.println("Would you like to login or register?");
		    }
	    }

		return loginOrReg;
	}

	private static Account registerAccount(AccountManager am) throws IOException {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		AccountManager user = null;

		String email = "";
		String firstName = null;
		String lastName = null;
		String username = null;
		String password = null;
		String temp;
		
		boolean email_valid = false;
		
		while(!email_valid) {
			System.out.println("What is your email address?");
			email = s.nextLine();
			email_valid = isValidEmailAddress(email);
		}
		
//		try {
//			email = s.nextLine();
//			isValidEmailAddress(email);
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.out.println("uh.. oh");
//		}
		if(user.doesAccountExist(email)){
			System.out.println("An account already exist with this email address!");
		}
		else{
			System.out.println("What is your first name?");
			firstName = s.nextLine();
			
			System.out.println("Whats your last name?");
			lastName = s.nextLine();

			for(boolean usernameSet = false; !usernameSet;  ){
				System.out.println("Make a username?");
				username = s.nextLine();
				
				if(user.doesUsernameExist(username) != null){
					System.out.println("UserName: " + username + " already exist! Please try another username");
				}
				else{
					usernameSet = true;
					System.out.println("Username is available");
				}
			}
			
			for(boolean passwordSet = false; !passwordSet;  ){
				System.out.println("Make a password?");
				password = s.nextLine();
				
				System.out.println("Repeat password");
				temp = s.nextLine();
				if(!password.equals(temp)){
					System.out.println("Passwords did not match");
				}
				else{
					passwordSet = true;
					System.out.println("Password created successfully");
				}
			}

				
		}
		s.close();
		Account account = am.add_account(firstName, lastName, username, email, password);

		am.generateCsvFile("../testBudget.csv");
		am.print_account_info(1);
		int accountNumber =  account.get_accountNumber();
		return am.Accounts.get(accountNumber);
	}

	private static Account logIntoAccount() throws IOException {
		// TODO Auto-generated method stub
		String username = "";
		String password = "";
		boolean loggedIn = false;
		
		Scanner scanner = new Scanner(System.in);
		AccountManager user = new AccountManager();
		Account account = null;
		
		while(!loggedIn ){
			System.out.println("Username: ");
			username = scanner.nextLine();
			
			System.out.println("Password: ");
			password = scanner.nextLine();
			account = user.login(username, password);
			if(account != null){
				loggedIn = true;
			}
		}
		
		return account;
	}
	
	private static boolean isValidEmailAddress(String email) {
		boolean result = true;
		try {
			InternetAddress emailAddr = new InternetAddress(email);
			emailAddr.validate();
		} catch (AddressException ex) {
			System.out.println("Email Address is not valid.");
			result = false;
		}
		return result;
	}

	private static String checkIfUsernameOrEmailaddress(String username) {
		return "ed";
		// TODO Auto-generated method stub
		
	}
	
}

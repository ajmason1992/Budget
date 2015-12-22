import java.util.Scanner;


public class Budget {
	public static void main(String[] args){
		AccountManager am = new AccountManager();
		Account account = login(am);
		

	    

	}
	
	private static Account login(AccountManager am){
		Account user = null;
		System.out.println("Would you like to login or register? Please type help if needed");
	    // create a scanner so we can read the command-line input
	    Scanner scanner = new Scanner(System.in);
	    String loginOrNah = scanner.next();
	    for(boolean login = false; login == false;loginOrNah = scanner.next() ){
		    if(loginOrNah.equalsIgnoreCase("login")){
		    	//System.out.println("login works!");
		    	logIntoAccount();
		    	login = true;
		    }
		    else if(loginOrNah.equalsIgnoreCase("register")){
		    	registerAccount(am);
		    	System.out.println("register works!");
		    }
		    else if(loginOrNah.equalsIgnoreCase("help")){
		    	System.out.print("-Type 'login' to log into account\n"
		    					+ "-Type 'register to register\n");
		    	System.out.println("Would you like to log in or register?");
		    }
		    else{
		    	System.out.println("Invalid input:");
		    	System.out.println("Would you like to log in or register?");
		    }
	    }
		return user;
	}

	private static void registerAccount(AccountManager am) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String email;
		String firstName = null;
		String lastName = null;
		String username = null;
		String password = null;
		String temp;
		
		System.out.println("What is your email address?");
		email = scanner.nextLine();
		if(doesAccountExist(email)){
			System.out.println("An account already exist with this email address!");
		}
		else{
			System.out.println("What is your first name?");
			firstName = scanner.nextLine();
			
			System.out.println("Whats your last name?");
			lastName = scanner.nextLine();

			for(boolean usernameSet = false; !usernameSet;  ){
				System.out.println("Make a username?");
				username = scanner.nextLine();
				
				if(doesUsernameExist()){
					System.out.println("UserName: " + username + " already exist! Please try another username");
				}
				else{
					usernameSet = true;
					System.out.println("Username created successfully");
				}
			}
			
			for(boolean passwordSet = false; !passwordSet;  ){
				System.out.println("Make a password?");
				password = scanner.nextLine();
				
				System.out.println("Repeat password");
				temp = scanner.nextLine();
				if(!password.equals(temp)){
					System.out.println("Passwords did not match");
				}
				else{
					passwordSet = true;
					System.out.println("Password created successfully");
				}
			}

				
		}
		am.add_account(firstName, lastName, username, email, password);

		am.generateCsvFile("../testBudget.csv");
		am.print_account_info(1);
	}

	private static boolean doesUsernameExist() {
		// TODO Auto-generated method stub
		return false;
	}

	private static boolean doesAccountExist(String email) {
		// TODO Auto-generated method stub
		return false;
	}

	private static Account logIntoAccount() {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		Account user = null;
		return user;
		
		
	}
	
}

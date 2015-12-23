import java.io.IOException;
import java.util.Scanner;


public class Budget {
	public static void main(String[] args){
		AccountManager am = new AccountManager();
		am.read_CSV_file("../testInput.csv");
		String lOrR = loginOrRegister();
		
		if(lOrR.equalsIgnoreCase("login")){
			Account account = login(am);
			logIntoAccount();
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
		    					+ "-Type 'register to register\n");
		    	System.out.println("Would you like to log in or register?");
		    }
		    else{
		    	System.out.println("Invalid input:");
		    	System.out.println("Would you like to login or register?");
		    }
	    }

		return loginOrReg;
	}

	private static Account login(AccountManager am){
		Account user = null;
		System.out.println("Login");
		return user;
	}

	private static Account registerAccount(AccountManager am) throws IOException {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);

		String email = "";
		String firstName = null;
		String lastName = null;
		String username = null;
		String password = null;
		String temp;
		
		System.out.println("What is your email address?");
		try {
			email = s.nextLine();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("uh.. oh");
		}
		if(doesAccountExist(email)){
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

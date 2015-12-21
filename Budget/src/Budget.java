import java.util.Scanner;


public class Budget {
	public static void main(String[] args){
		Account account = login();
		

	    

	}
	
	private static Account login(){
		Account user = null;
		System.out.print("Would you like to login or register? Please type help if needed");
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
		    	registerAccount();
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

	private static void registerAccount() {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String email;
		Account user;
		System.out.println("What is your email address?");
		email = scanner.nextLine();
		if(doesAccountExist(email)){
			
		}
		
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

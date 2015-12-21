import java.util.HashMap;


public class AccountManager {
	
	HashMap<Integer, Account>  Accounts = new HashMap<Integer, Account>();  
	private Integer accountNo;
	
	public void add_account(Integer accountNo, String firstName, String lastName,
							String username, String email, String Password) {
		accountNo++;
		
		Account account = new Account(accountNo, firstName, lastName, username, email,  Password);
		Accounts.put(accountNo, account);
	}
	
	public void delete_account(Integer accountNo){
		Accounts.remove(accountNo);
	}
	
	public Account get_account(Integer accountNo){
		return Accounts.get(accountNo);
	}
	
	public void print_account_info(Integer accountNo){
		System.out.println("Account Number: " + Accounts.get(accountNo).get_accountNumber());
		System.out.println("Account Name: " + Accounts.get(accountNo).get_fullName());
		System.out.println("Account username: " + Accounts.get(accountNo).get_username());
	}
	
	public AccountManager() {
		accountNo = 0;
	}
	
}

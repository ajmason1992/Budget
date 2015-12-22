import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;


public class AccountManager {
	
	public AccountManager() {
		accountNo = 0;
	}
	
	static HashMap<Integer, Account>  Accounts = new HashMap<Integer, Account>();  
	private Integer accountNo;
	static Account account;
	
	private static final String FILE_HEADER = "Account No.,First Name,Last Name,Username,"
			+ "Email, Password";
	private static final String COMMA_DELIMITER = ",";
	private static final String NEW_LINE = "\n";
	
	public void add_account(String firstName, String lastName,
							String username, String email, String Password) {
		accountNo++;
		
		Account account = new Account(accountNo, firstName, lastName, username, email,  Password);
		Accounts.put(accountNo, account);
	}
	
	public void delete_account(Integer accountNo) {
		Accounts.remove(accountNo);
	}
	
	public Account get_account(Integer accountNo) {
		return Accounts.get(accountNo);
	}
	
	public void print_account_info(Integer accountNo) {
		System.out.println("Account Number: " + Accounts.get(accountNo).get_accountNumber());
		System.out.println("Account Name: " + Accounts.get(accountNo).get_fullName());
		System.out.println("Account username: " + Accounts.get(accountNo).get_username());
	}
	
	public void read_CSV_file(String fileName) throws FileNotFoundException {
		try{
			BufferedReader br = new BufferedReader( new FileReader(fileName));
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public void generateCsvFile(String fileName) {
	
		try {
			FileWriter writer = new FileWriter(fileName);
		
			for(Integer key : Accounts.keySet()) {
				account = Accounts.get(key);
				System.out.printf("Key : %s and Value: %s %n", key, account.get_firstName());
				writer.append(FILE_HEADER);
				writer.append(NEW_LINE);
				writer.append((account.get_accountNumber().toString()));
				writer.append(COMMA_DELIMITER);
				writer.append(account.get_firstName());
				writer.append(COMMA_DELIMITER);
				writer.append(account.get_lastName());
				writer.append(COMMA_DELIMITER);
				writer.append(account.get_username());
				writer.append(COMMA_DELIMITER);
				writer.append(account.get_email());
				writer.append(COMMA_DELIMITER);
				writer.append(account.get_password());
				writer.append(NEW_LINE);
				writer.flush();
				writer.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}


public class Account {
	
	private Integer accountNumber;
	private String firstName;
	private String lastName;
	private String fullName;
	private String username;
	private String email;
	private String password;
	
	public Integer get_accountNumber() {
		return this.accountNumber;
	}
	
	public String get_firstName() {
		return this.firstName;
	}
	
	public String get_lastName() {
		return this.lastName;
	}
	
	public String get_fullName() {
		return this.fullName;
	}
	
	public String get_username() {
		return this.username;
	}
	
	public String get_email() {
		return this.email;
	}
	
	public String get_password() {
		return this.password;
	}
	
	public void set_firstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void set_lastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void set_fullName(String fullName) {
		this.fullName = fullName;
	}
	
	public void set_username(String username) {
		this.username = username;
	}
	
	public void set_email(String email) {
		this.email = email;
	}
	
	public void set_password(String password) {
		this.password = password;
	}
	
	public Account(Integer accountNumber, String firstName, String lastName,
				   String username, String email, String password) {
		this.accountNumber = accountNumber;
		this.firstName = firstName;
		this.lastName = lastName; 
		this.fullName = firstName + lastName;
		this.username = username;
		this.email = email;
		this.password = password;
	}
	
}



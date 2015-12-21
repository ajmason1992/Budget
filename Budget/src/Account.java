
public class Account {
	
	private String name;
	private String password;
	
	public String get_name() {
		return this.name;
	}
	
	public String get_password() {
		return this.password;
	}
	
	public Account(String name, String password) {
		this.name = name;
		this.password = password;
	}
	
}

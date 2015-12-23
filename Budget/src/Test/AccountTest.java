package Test;

import junit.framework.*;
import static org.junit.Assert.*;



public class AccountTest extends TestCase {
	
	public void setUp(){
		
	}
	private boolean createUsername() {
		// TODO Auto-generated method stub
		return true;
	}
	private boolean createAccount() {
		// TODO Auto-generated method stub
		return false;
	}
	
	private boolean emailExist() {
		// TODO Auto-generated method stub
		return false;
	}
	private boolean deleteUsername() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void testUsernameExist(){
		assertTrue(createUsername());  
	}
	
	public void testEmailExist(){
		assertTrue(createAccount());
	}

	public void testEmailAlreadyExist(){
		assertTrue(emailExist());
	}
	
	public void testDeleteUsername(){
		assertTrue(deleteUsername());
	}


	
	

}

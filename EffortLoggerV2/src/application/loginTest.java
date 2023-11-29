package application;

import static org.junit.Assert.*;

import org.junit.Test;

public class loginTest {
	private LoginController login = new LoginController();
	private RegisterController register = new RegisterController();
	@Test
	public void test1() throws Exception {
		// Test several usernames and passwords
		assertFalse(register.createAccountTest("", "", ""));
	}
	
	@Test
	public void test2() throws Exception {
		assertFalse(register.createAccountTest("user", "password", "pasword"));
	}
	
	@Test
	public void test3() throws Exception {
		assertFalse(register.createAccountTest("use", "password", "password"));
	}
	
	@Test
	public void test4() throws Exception {
		assertFalse(register.createAccountTest("user", "passworddddddddddddddddddddddddddddddddddddddddddddd", "passworddddddddddddddddddddddddddddddddddddddddddddd"));
	}
	
	@Test
	public void test6() throws Exception {		
		assertTrue(register.createAccountTest("user", "password", "password"));
	}
	
	@Test
	public void test7() throws Exception {		
		assertFalse(login.isValid("", ""));
	}
	
	@Test
	public void test8() throws Exception {		
		assertFalse(login.isValid("aws", "asdssndks"));
	}
	
	@Test
	public void test9() throws Exception {		
		assertTrue(login.isValid("user", "password"));
	}
	
	
	
	
	
	
	
	

}

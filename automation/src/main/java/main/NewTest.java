package main;

import javax.security.auth.login.LoginContext;
import gettersetter.*;
import org.junit.BeforeClass;
import org.testng.annotations.Test;
import Stepdefenation.*;
public class NewTest {
 @BeforeClass
  public static void main(String arg[]) throws Throwable
  {
	 
	 Login sr= new  Login();
	 sr.open_google_with_helpof_url();
	 sr.search_intragram();
	 sr.i_complete_action_open_first_url();
	
  }
}

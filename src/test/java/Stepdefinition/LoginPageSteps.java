package Stepdefinition;

import Pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {
	
	LoginPage login = new LoginPage();

	@Given("user launch site url")
		public void user_launch_site_url(){
			login.userlaunchsite();
		}
	
	@When("user enter username and password")
	public void user_enter_username_and_password() {
		
	}
	
	
	@And("user click on login button")
	public void user_click_on_login_button() {
		
	}
	
	@Then("User is successfully logged in")
	public void User_is_successfully_logged_in() {
		
		
	}
		
	}



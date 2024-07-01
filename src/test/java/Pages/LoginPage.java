package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Baseclasspack.Base;

public class LoginPage extends Base{
	
	
public void userlaunchsite() {
	launchapplications();
}

public void user_enter_username_and_password() {
	WebElement username = driver.findElement(By.cssSelector("input#user-name"));
	clearAndEnterText(username,prop.getProperty("username"));
	
	WebElement password=	driver.findElement(By.cssSelector("input#password"));
	clearAndEnterText(username,prop.getProperty("password"));

}
}

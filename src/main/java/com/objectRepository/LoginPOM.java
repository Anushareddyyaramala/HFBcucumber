package com.objectRepository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtils.PropertyFile;

public class LoginPOM {

WebDriver driver;
	
PropertyFile plib = new PropertyFile();

	/*creating webelements*/
	
	@FindBy(xpath="//input[@name='email']")
	public WebElement Email;
	
	@FindBy(xpath="//input[@id='continue']")
	public WebElement continuebutton;
	
	@FindBy(xpath="//input[@id='ap_password']")
	public WebElement password;
	
	@FindBy(xpath="//input[@id='signInSubmit']")
	public WebElement Signin;
	
	
	public WebElement getEmail() {
		return Email;
	}
	public WebElement getContinuebutton() {
		return continuebutton;
	}
	public WebElement getPassword() {
		return password;
	}
	public WebElement getSignin() {
		return Signin;
	}
	
	public LoginPOM(WebDriver driver){
		
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
		
	}
	public void loggin() throws IOException {
		String userName=plib.readDataFromPropertyFile("Username");
		Email.sendKeys(userName);
		continuebutton.click();
		String pass=plib.readDataFromPropertyFile("password");
		password.sendKeys(pass);
		
	}
}

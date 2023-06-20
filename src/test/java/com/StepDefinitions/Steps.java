package com.StepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.GenericUtils.PropertyFile;
import com.GenericUtils.WebdriverUtility;
import com.objectRepository.CheckoutPOM;
import com.objectRepository.HomePagePOM;
import com.objectRepository.LogOutPOM;
import com.objectRepository.LoginPOM;
import com.objectRepository.ProductDisplayPOM;

import hooks.Baseclass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps {
	WebDriver driver;
	Baseclass base = new Baseclass();
	PropertyFile plib = new PropertyFile();
	
	LogOutPOM logout;
	HomePagePOM home = new HomePagePOM(Baseclass.driver);
	ProductDisplayPOM pro;
	CheckoutPOM check;
	WebdriverUtility wLib=new WebdriverUtility();
	LoginPOM login ;
	
	@Given("Launching the browser")
	public void launching_the_browser() throws IOException {

		base.launchbrowser();
	}

	@Given("Launch the application")
	public void launch_the_application( ) throws IOException {
		base.appbrowser();
	}

	@When("enter the  valid data")
	public void enter_the_valid_data() throws IOException {
		login = new LoginPOM(Baseclass.driver);
		login.loggin();

	}

	@When("clcik on sign in button")
	public void clcik_on_sign_in_button() {
		
		LoginPOM login = new LoginPOM(Baseclass.driver);
		login.Signin.click();
		wLib.takeScreenShot(Baseclass.driver);
	}

	@When("click on the hamburger icon")
	public void click_on_the_hamburger_icon() {
		
		logout = new LogOutPOM(Baseclass.driver);
		
		logout.icon.click();

	}

	@Then("click on signout")
	public void click_on_signout() {
		
		wLib.scrollAction(Baseclass.driver);
		logout.signout.click();

	}

	@Then("Select the product")
	public void select_the_product() throws IOException {
		home = new HomePagePOM(Baseclass.driver);
		String item = plib.readDataFromPropertyFile("Item");
		home.searchbox.sendKeys(item);
		home.Searchbutton.click();
		
	}

	@Then("click on the product")
	public void click_on_the_product() {
     home.products.click();
     
	}

	@Then("click on the Buynow Button")
	public void click_on_the_buynow_button() {
		pro=new ProductDisplayPOM(Baseclass.driver);
		wLib.WindowHandles(Baseclass.driver, 1);
		wLib.scrollAction(Baseclass.driver);
		pro.BuyNow.click();
	}

	@Then("Add the address details")
	
	public void add_the_address_details() throws IOException, InterruptedException {
		
		check=new CheckoutPOM(Baseclass.driver);
		String name = plib.readDataFromPropertyFile("FirstName");
		String mobile = plib.readDataFromPropertyFile("Mobile");
		String pinno = plib.readDataFromPropertyFile("Pinno");
		String address1 = plib.readDataFromPropertyFile("Address1");
		String address12 = plib.readDataFromPropertyFile("Address12");
		String land = plib.readDataFromPropertyFile("Landmark");
		String mandal = plib.readDataFromPropertyFile("Town");
		String card=plib.readDataFromPropertyFile("Card");
		String cardna=plib.readDataFromPropertyFile("Cardname");
		String cvv=plib.readDataFromPropertyFile("CvvNo");

	check.chechout( name, mobile , pinno, address1, address12, land, mandal, card, cardna, cvv);

wLib.takeScreenShot(Baseclass.driver);
	}}

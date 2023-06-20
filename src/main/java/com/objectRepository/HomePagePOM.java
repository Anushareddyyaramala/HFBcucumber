package com.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePagePOM {

WebDriver driver;
	
	public HomePagePOM(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="twotabsearchtextbox")
	public WebElement searchbox;
	
	@FindBy(id="nav-search-submit-button")
	public WebElement Searchbutton;
	
	@FindBy(xpath="//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[8]/div/div/div/div/div[2]/div[1]/h2/a/span")
	public WebElement products;
	

	public WebElement getSearchbox() {
		return searchbox;
	}

	public WebElement getSearchbutton() {
		return Searchbutton;
	}

	public WebElement getproducts() {
		return products;
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
}

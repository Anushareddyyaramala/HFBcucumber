package com.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDisplayPOM {

	WebDriver driver;
	
	@FindBy(xpath="//input[@title='Buy Now']")
	public WebElement BuyNow;



	public WebElement getBuyNow() {
		return BuyNow;
	}

	//	public WebElement getAddtocart() {
//		return addtocart;
//	}
//	public WebElement getproceedtocheck() {
//		return proceedtocheck;
//	}
//	
	public ProductDisplayPOM(WebDriver driver){
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
}

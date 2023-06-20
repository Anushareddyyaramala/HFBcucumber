package com.objectRepository;



	import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.GenericUtils.WebdriverUtility;


	public class CheckoutPOM   {
		WebdriverUtility wLib=new WebdriverUtility();

		WebDriver driver;
		@FindBy(linkText = "Checkout")
		private WebElement Checkout;
		@FindBy(css = "#addressChangeLinkId")
		private WebElement change;
		@FindBy(xpath = "//a[@id='add-new-address-popover-link']")
		private WebElement addnewaddress;
		@FindBy(xpath = "//*[@id='address-ui-widgets-countryCode-dropdown-nativeId']")
		private WebElement country;
		@FindBy(xpath = "//input[@id='address-ui-widgets-enterAddressFullName']")
		private WebElement firstname;
		@FindBy(xpath = "//input[@id='address-ui-widgets-enterAddressPhoneNumber']")
		private WebElement Mobile;
		@FindBy(css = "#address-ui-widgets-enterAddressPostalCode")
		private WebElement Pincode;
		@FindBy(xpath = "//input[@id='address-ui-widgets-enterAddressLine1']")
		private WebElement address;
		@FindBy(xpath = "//input[@id='address-ui-widgets-enterAddressLine2']")
		private WebElement address2;
		@FindBy(xpath = "//input[@id='address-ui-widgets-landmark']")
		private WebElement landmark;
		@FindBy(xpath = "//input[@id='address-ui-widgets-enterAddressCity']")
		private WebElement town;
		@FindBy(xpath = "//select[@id='address-ui-widgets-enterAddressStateOrRegion-dropdown-nativeId']")
		private WebElement state;
		@FindBy(xpath = "//span[@class='a-button a-button-primary']")
		private WebElement Usethisaddress;
		@FindBy(xpath = "//*[@id=\"address-list\"]/div/div[1]/div/fieldset[2]/div[1]/span/div/label/span/span[2]/text()")
		private WebElement total;
		@FindBy(css = "#orderSummaryPrimaryActionBtn")
		private WebElement useaddress;
		@FindBy(xpath = "//input[@value='SelectableAddCreditCard']")
		private WebElement paywithcards;
		@FindBy(xpath = "//span[@class='pmts-indiv-issuer-image'][2]")
		private WebElement mastercard;
		@FindBy(xpath = "//a[@class='a-link-emphasis pmts-add-cc-default-trigger-link']")
		private WebElement carddetails;
		
		@FindBy(xpath = "//input[@type=\"tel\"]")
		private WebElement cardno;
		
		@FindBy(xpath = "//input[@value='kolimi mahaboobbhasha']")
		private WebElement cardname;
		@FindBy(xpath = "//select[@name='ppw-expirationDate_month']")
		private WebElement month;
		@FindBy(xpath = "//span[text()='Enter card details']")
		private WebElement enterclick;
		@FindBy(xpath = "//input[@type='password']")
		private WebElement cvv;
		@FindBy(xpath = "a-button a-button-primary pmts-button-input apx-compact-continue-action pmts-portal-component pmts-portal-components-pp-qIdwV0-6 primary-action-button")
		private WebElement usepayment;
		@FindBy(css=".a-column.a-span9")private WebElement newpop;

		public WebElement getchange() {
			return change;
		}

		public WebElement getAddnewaddress() {
			return addnewaddress;
		}

		public WebElement getCountry() {
			return country;
		}

		public WebElement getFirstname() {
			return firstname;
		}

		public WebElement getMobile() {
			return Mobile;
		}

		public WebElement getPin() {
			return Pincode;
		}

		public WebElement getAddress() {
			return address;
		}

		public WebElement getAddress2() {
			return address2;
		}

		public WebElement getLandmark() {
			return landmark;
		}

		public WebElement getTown() {
			return town;
		}

		public WebElement getState() {
			return state;
		}

		public WebElement getusethisAddress() {
			return Usethisaddress;
		}

		public WebElement getpaywithcards() {
			return paywithcards;
		}

		public WebElement getmastercard() {
			return mastercard;
		}

		public WebElement getcarddetails() {
			return carddetails;
		}

		public WebElement getcardno() {
			return cardno;
		}

		public WebElement getcardname() {
			return cardname;
		}

		public WebElement getmonth() {
			return month;
		}

		public WebElement getenterclick() {
			return enterclick;
		}

		public WebElement getcvv() {
			return cvv;
		}

		public WebElement getusepayment() {
			return usepayment;
		}

		public CheckoutPOM(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}

		public void chechout(String name, String mobile, String Pinno, String address1, String Address12, String land,
				String mandal, String Card, String cardna, String cvvno) throws InterruptedException {

			change.click();
			addnewaddress.click();
			wLib.handleDropDown(country, "India");
			firstname.sendKeys(name);
			Mobile.sendKeys(mobile);
			Pincode.sendKeys(Pinno);
			address.sendKeys(address1);
			address2.sendKeys(Address12);
			landmark.sendKeys(land);
			town.sendKeys(mandal);
			
			String title=driver.getTitle();
			System.out.println(title);
			Assert.assertTrue(title.contains("Checkout"));
			Usethisaddress.click();
			paywithcards.click();
			mastercard.click();
			carddetails.click();
			Reporter.log("card  details", true);
//			wLib.WindowHandles(driver, 2);
	//	
//			cardno.click();
//			Thread.sleep(3000);
//			cardno.sendKeys(Card);
//			Reporter.log("card no. done", true);
//			cardname.clear();
//			cardname.sendKeys(cardna);
//			wLib.handleDropDown(month, "11");
//			enterclick.click();
//			cvv.sendKeys(cvvno);
//			usepayment.click();
		
		}
	}
	//System.out.println(total.getText());

	//useaddress.click();
	//wLib.switchToFrame(driver, 1);


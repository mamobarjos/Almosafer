/*Scenario to automate:

		Navigate to URL https://www.almosafeer.com/en

		Once the website is loaded, make below assertions:

		Default language is correct (EN).
		Default currency is correct (SAR).
		Contact numbers are correct (check yourself).
		Verify “qitaf” logo is displayed in footer.
		Hotels search tab is NOT selected by default.
		Flight departure date is set to "today+1day" by default.
		Flight return date is set to "today+2days" by default.
		Make any other assertions that you want to do.
		Use random method to change language (sometime keep AR, sometime change to EN):

		Make assertion that language is updated as you chose.
		Switch to hotel search tab:

		In location field, type value:
		➤ If current-lang is EN, then randomly type from (Dubai, Jeddah, Riyadh).
		➤ If current-lang is AR, then randomly type from (دبي، جدة، رياض).
		Click on first result from autocomplete list.
		Randomly select “1 room, 2 adults, 0 children” or “1 room, 1 adult, 0 children” option.

		Click on search hotels button.

		On new page (which is “Search results page”):

		Wait for loading fully complete (wait for loading bar or API).
		Important: do some assertions.*/
package mypackage;


import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTestCases extends Parameters {
	// can use this or extends Parameters
	// Parameters object = new Parameters();

	@BeforeTest
	public void MySetup() {
		ConfigurationToAcces();	
	}

	@Test(priority = 1, description = "assertion the defult languge is correct (EN)", enabled = false)
	public void CheckTheDefultLanguge() {

		// assertion the defult languge is correct (EN)
		// driver.findElement(By.tagName("html")).getDomAttribute("lang");
		// asseration if the html tag have lang attribute en for defualt
		System.out.println(driver.findElement(By.tagName("html")).getDomAttribute("lang"));
		String ActualLanguage = driver.findElement(By.tagName("html")).getDomAttribute("lang");
		Assert.assertEquals(ActualLanguage, ExpectedLanguage);
	}

	@Test(priority = 2, description = "Check The Defult Currency", enabled = false)
	public void CheckTheDefultCurrency() {
		// use cssselector we have class with space
		String ActualCurrency = driver.findElement(By.cssSelector(".sc-dRFtgE.fPnvOO")).getText();
		Assert.assertEquals(ActualCurrency, ExpectedCurrency);
	}
	@Test(priority=3 , description="Check mobile number", enabled = false)
	public void CheckMobileNumber ( ) {
		String ActualMobileNumber =driver.findElement(By.tagName("strong")).getText();
		Assert.assertEquals(ActualMobileNumber, ExpectedMobileNumber);
		}
	@Test(priority=4 , description="Check The Logo of Qitaf ", enabled = false)
	public void CheckQitafLogo () {
		WebElement TheFooter = driver.findElement(By.cssSelector(".sc-dEfkYy.byExGa"));
		WebElement TheContaniar = TheFooter.findElement(By.cssSelector(".sc-ghsgMZ.hIElfs"));
		WebElement QitafLogo = TheContaniar.findElement(By.tagName("svg"));
		boolean ActualQitaflogoDisplay = QitafLogo.isDisplayed();
		
		Assert.assertEquals(ActualQitaflogoDisplay, ExpectedQitafLogoDisplay);
	    }
	
	@Test(priority=5 , description="Check Hotel Tap Is Selected", enabled=false)
	public void HotelTapIsNotSelected() { 
		WebElement HotelTap = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));
		String ActualAriaSelected = HotelTap.getDomAttribute("aria-selected");
		Assert.assertEquals(ActualAriaSelected, ExpectedAriaSelected);
		}
	@Test(priority=6, description="Chek The Depature Date is set today + Day by defult", enabled=false)
	public void CheckDepatureDate() {
		//LocalDate date = LocalDate.now();
		//System.out.println(date);
		//int Today =date.getDayOfMonth();
		//System.out.println(Today);
		//int Tomorrow =date.plusDays(1).getDayOfMonth();
		//System.out.println(Tomorrow);
		List<WebElement> Dates = driver.findElements(By.cssSelector(".sc-fvLVrH.hNjEjT"));
		//System.out.println(Dates.size());
		String ActualDepaturDate =Dates.get(0).getText();
		System.out.println(ActualDepaturDate);
		String Tomorrow =Integer.toString(date.plusDays(1).getDayOfMonth());
		System.out.println(Tomorrow);
		Assert.assertEquals(ActualDepaturDate, Tomorrow);
	}
	@Test(priority=7,description="Check Return Date is Set To day + 2day by defult",enabled=true)
	public void CheckReturnDate () {
		List<WebElement> Dates = driver.findElements(By.cssSelector(".sc-fvLVrH.hNjEjT"));
		String ActualReturnDate =Dates.get(1).getText();
		System.out.println(ActualReturnDate);
		String ExpectedReturnDate =Integer.toString(date.plusDays(2).getDayOfMonth());
		System.out.println(ExpectedReturnDate);
		Assert.assertEquals(ActualReturnDate,ExpectedReturnDate);

	}
}

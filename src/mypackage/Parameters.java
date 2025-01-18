package mypackage;

import java.time.Duration;
import java.time.LocalDate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Parameters {
	String Myname = "Mahmood";
	String TheDefaultURL = "https://www.almosafer.com/en";
	String ExpectedLanguage = "en";
	String ExpectedCurrency = "SAR";
	String ExpectedMobileNumber = "+966554400000";
	String ExpectedAriaSelected = "false";
	WebDriver driver = new ChromeDriver();
	boolean ExpectedQitafLogoDisplay = true;
	LocalDate date = LocalDate.now();
	int Today =date.getDayOfMonth();
	//we must to convert int Tomorrow to string because actual depaturdate is string 
	//int Tomorrow =date.plusDays(1).getDayOfMonth();
	String Tomorrow =Integer.toString(date.plusDays(1).getDayOfMonth());
	String ExpectedReturnDate =Integer.toString(date.plusDays(2).getDayOfMonth());
	public void ConfigurationToAcces() {
		// native to URL https://www.almosafer.com
		driver.get(TheDefaultURL);
		// this run if use this Parameters object = new Parameters();
		// maximaize window
		driver.manage().window().maximize();
		// for wait some second during search
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		// System.out.println(object.Myname);
		// System.out.println(Myname);
		WebElement SelectSARMessage = driver
				.findElement(By.cssSelector(".sc-jTzLTM.hQpNle.cta__button.cta__saudi.btn.btn-primary"));
		SelectSARMessage.click();
		
	}

}

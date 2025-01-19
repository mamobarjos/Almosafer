package mypackage;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Parameters {
	WebDriver driver = new ChromeDriver();
	LocalDate date = LocalDate.now();
    Random rand = new Random();
	String Myname = "Mahmood";
	String TheDefaultURL = "https://www.almosafer.com/en";
	String ExpectedLanguage = "en";
	String ExpectedEnglishLanguage = "en";
	String ExpectedArabicLanguage = "ar";
	String ExpectedCurrency = "SAR";
	String ExpectedMobileNumber = "+966554400000";
	String ExpectedAriaSelected = "false";
	boolean ExpectedQitafLogoDisplay = true;
	int Today =date.getDayOfMonth();
	//we must to convert int Tomorrow to string because actual depaturdate is string 
	//int Tomorrow =date.plusDays(1).getDayOfMonth();
	String Tomorrow =Integer.toString(date.plusDays(1).getDayOfMonth());
	String ExpectedReturnDate =Integer.toString(date.plusDays(2).getDayOfMonth());
	String[] WebSites = {"https://www.almosafer.com/en?ncr=1" , "https://www.almosafer.com/ar?ncr=1"};
	int RandomIndexForTheWebSItes = rand.nextInt(WebSites.length);
	String[] EnglishCities = {"Dubai","Jeddah","Riyadh"};
	int RandomIndexForEnglishCities =rand.nextInt(EnglishCities.length);
	String[] ArabicCities = {"دبي" , "جدة" , "الرياض"};
	int RandomIndexForArabicCities =rand.nextInt(ArabicCities.length);
	boolean ExpectedResult =true;
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

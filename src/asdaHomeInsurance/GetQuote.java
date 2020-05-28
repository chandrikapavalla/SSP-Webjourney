package asdaHomeInsurance;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class GetQuote {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "E:/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// navigate to UrL
		driver.navigate().to("https://money.asda.com/home-insurance/");
		String link = driver.getWindowHandle();

		// page menu

		selectByTextInList(driver, "get a quote", "[class='overview-page-menu']>div>div>div>ul>li");

		Set<String> links = driver.getWindowHandles();
		List<String> list = links.stream().collect(Collectors.toList());
		driver.switchTo().window(list.get(1));

		// driver.switchTo().window(driver.getWindowHandle());
		// click on buildings cover

		Actions a = new Actions(driver);

		Thread.sleep(2000L);
		WebElement buildings = driver.findElement(By.cssSelector("div[data-label='Click|Building']"));
		a.moveToElement(buildings).click().build().perform();
//first page
		String title1=ValuesFromExcel.getValue("Title");
		
		selectByTextInList(driver,title1 , "input[data-fieldname='ProposerTitle']+span");
		String firstName=ValuesFromExcel.getValue("first_name");
		signUpDetails(driver, "ProposerFirstName",firstName );
		String lastName=ValuesFromExcel.getValue("last_name");
		signUpDetails(driver, "ProposerLastName", lastName);
		String emailId=ValuesFromExcel.getValue("email");
		signUpDetails(driver, "ProposerEmail", emailId);
		signUpDetails(driver, "ProposerPhoneNumber", "05865543258");

		selectByTextInList(driver, "9", "#dob-wrapper-day>select>option");
		selectByTextInList(driver, "12", "#dob-wrapper-month>select>option");
		selectByTextInList(driver, "1994", "#dob-wrapper-year>select>option");
		// postcode nr1 1xr
		signUpDetails(driver, "Postcode", "NR1 1XR");

		// find my address

		driver.findElement(By.cssSelector("button[value='Find my address']>span")).click();
		Thread.sleep(2000L);
		// address list
		selectByTextInList(driver, "3 River Heights, Wherry Road, Norwich, NR1 1XR",
				"select[data-fieldname='UkAdressDropdown']>option");
		selectByTextInList(driver, "married", "input[data-fieldname='ProposerMaritalStatus']+span>label");

		selectByTextInList(driver, "Unemployed", "select[data-fieldname='OccupationType']>option");
		Thread.sleep(2000L);
		driver.findElement(By.cssSelector("[data-fieldname='ProposerAdditionalOccupation-N']+span>label")).click();
		Thread.sleep(2000L);
		selectByTextInList(driver, "no", "[data-fieldname='JointPolicy']+span>label");
		driver.findElement(By.cssSelector(".checkmark")).click();
		driver.findElement(By.cssSelector("[data-fieldname='continue']>span")).click();
		// 2nd page
		selectByTextInList(driver, "i rent", "[data-fieldname='PropertyOwnershipType']+span>label");
		selectByTextInList(driver, "6", "[data-fieldname='YearsAtProperty']>option");
		selectByTextInList(driver, "yes", "[data-fieldname='MainResidence']>option");
		driver.findElement(By.cssSelector("[data-fieldname='Occupants-ISF']+span>label")).click();
		selectByTextInList(driver, "no", "[data-fieldname='PropertySmokers']+span>label");
		Thread.sleep(2000L);
		selectByTextInList(driver, "day and night", "[data-fieldname='PropertyOccupied']+span>label");
		Thread.sleep(2000L);
		selectByTextInList(driver, "3", "[data-fieldname='PropertyOccupantsAdults']>option");
		Thread.sleep(1000L);
		selectByTextInList(driver, "1", "[data-fieldname='PropertyOccupantsChildren']>option");
		selectByTextInList(driver, "no", "[data-fieldname='PropertyEmpty']+span>label");
		selectByTextInList(driver, "no business use", "[data-fieldname='PropertyBusinessUse']+span>label");
		signUpDetails(driver, "Year", "1998");
		selectByTextInList(driver, "no", "input[data-fieldname='PropertyForSale']+span>label");
		selectByTextInList(driver, "flat", "input[data-fieldname='HouseType']+div>div+label");
		Thread.sleep(1000L);
		selectByTextInList(driver, "Flat/apartment - purpose build(self contained)", "[data-fieldname='PropertyType']>option");
		selectByTextInList(driver, "first floor", "[data-fieldname='PropertyType']>option");
	
		signUpDetails(driver, "CurrentMarketValue", "80,000");
		signUpDetails(driver, "RebuildCost", "20000");
		selectByTextInList(driver, "no", "input[data-fieldname='PropertyInBuilding']+span>label");
		selectByTextInList(driver, "yes", "input[data-fieldname='PropertyUnderpinned']+span>label");
		selectByTextInList(driver, "yes", "input[data-fieldname='PropertyState']+span>label");
		selectByTextInList(driver, "grade 1", "input[data-fieldname='PropertyListed']+span>label");
		driver.findElement(By.cssSelector("[data-fieldname='continue']")).click();
		//3 page
		selectByTextInList(driver, "yes", "[data-fieldname='Distance from water']+span>label");
		selectByTextInList(driver, "no", "[data-fieldname='PropertyTrees']+span>label");
		selectByTextInList(driver, "no", "[data-fieldname='IsBuildingAtRisk']+span>label");
		selectByTextInList(driver, "no", "[data-fieldname='FloodedProperty']+span>label");
		selectByTextInList(driver, "concrete", "[data-fieldname='ExternalWallsMaterials']+span>label");
		selectByTextInList(driver, "no", "[data-fieldname='ExternalWallsCracks']+span>label");
		selectByTextInList(driver, "concrete", "[data-fieldname='RoofMaterial']+span>label");
		selectByTextInList(driver, "about a half", "[data-fieldname='FlatRoof']>option");
		selectByTextInList(driver, "2", "[data-fieldname='NumberOfBedrooms']+span>label");
		selectByTextInList(driver, "1", "[data-fieldname='NumberOfBathrooms']+span>label");
		selectByTextInList(driver, "0", "[data-fieldname='ReceptionRooms']+span>label");
		selectByTextInList(driver, "0", "[data-fieldname='OtherRooms']+span>label");
		driver.findElement(By.cssSelector("[data-fieldname='LockType-5LeverMorticeLock']+div>div+label")).click();
		Thread.sleep(1000L);
		selectByTextInList(driver, "no patio door", "[data-fieldname='PatioDoorsLocks']+span>label");
		Thread.sleep(1000L);
		selectByTextInList(driver, "no other door leads outside", "[data-fieldname='OtherDoorsLock']+span>label");
		Thread.sleep(1000L);
		selectByTextInList(driver, "no", "[data-fieldname='WindowsLocks']+span>label");
		Thread.sleep(1000L);
		driver.findElement(By.cssSelector("[data-fieldname='WorkingAlarm-Y']+span>label")).click();
		Thread.sleep(1000L);
		driver.findElement(By.cssSelector("[data-fieldname='MaintainedAlarm-Y']+span>label")).click();
		Thread.sleep(1000L);
		driver.findElement(By.cssSelector("[data-fieldname='MonitoredAlarm-Y']+span>label")).click();
		
		Thread.sleep(1000L);
		selectByTextInList(driver, "2", "[data-fieldname='SmokeAlarms']+span>label");
		Thread.sleep(1000L);
		selectByTextInList(driver, "yes", "[data-fieldname='NeighbourhoodWatch']+span>label");
		Thread.sleep(1000L);
		driver.findElement(By.cssSelector("[data-fieldname='continue']")).click();
		Thread.sleep(1000L);
		//4th   page
		
		driver.findElement(By.cssSelector("input[data-fieldname='HasClaims-N']+span")).click();
		selectByTextInList(driver, "3", "[data-fieldname='Dropdown']>option");
		Thread.sleep(1000L);
		selectByTextInList(driver, "400", "[data-about='voluntary-excess-buildings']>option");
		Thread.sleep(1000L);
		selectByTextInList(driver, "yes", "[data-fieldname='AccidentalDamageBuildings']+span>label");
		Thread.sleep(1000L);
		
		selectByTextInList(driver, "11", "[data-fieldname='PolicyStart']>option");
		Thread.sleep(1000L);
		selectByTextInList(driver, "4", "[autocomplete='bday-month']>option");
		selectByTextInList(driver, "2020", "[autocomplete='bday-year']>option");
		selectByTextInList(driver, "monthly", "input[data-fieldname='PolicyPay']+span>label");
		Thread.sleep(1000L);
		selectByTextInList(driver, "no", "input[data-fieldname='PolicyImposed']+span>label");
		selectByTextInList(driver, "no", "input[data-fieldname='PolicyConviction']+span>label");
		selectByTextInList(driver, "no", "input[data-fieldname='PolicyBankruptcy']+span>label");
		Thread.sleep(1000L);
		driver.findElement(By.cssSelector("span[class='checkmark-email']")).click();
		Thread.sleep(1000L);
		driver.findElement(By.cssSelector("button[data-fieldname='continue']")).click();
		
		Thread.sleep(60000L);
		String thanks="Thanks for getting a quote iuddrt";
		Thread.sleep(1000L);
		WebElement labeltitle=driver.findElement(By.cssSelector("[class='label-title']"));
		Thread.sleep(1000L);
		String title=labeltitle.getText();
		Thread.sleep(1000L);
		System.out.println(title);
		Thread.sleep(1000L);
		if(title.equalsIgnoreCase(thanks))
		{
		System.out.println("labeltitile matched with name");
		Thread.sleep(1000L);
		}
		else
			System.out.println("not matched");
		Thread.sleep(1000L);
		
		String quoteref="2020041112130" ;
		System.out.println("reference number matched"+quoteref);
		Thread.sleep(1000L);
		WebElement ref=driver.findElement(By.cssSelector("[class='quote-ref']>b"));
		Thread.sleep(1000L);
		String actualref=ref.getText();
		Thread.sleep(1000L);
		if(actualref.equalsIgnoreCase(quoteref))
		{
			System.out.println("reference number matched");
			Thread.sleep(1000L);
			
		}
		
		else
			System.out.println("ref number not matched");
		Thread.sleep(1000L);
		
		
		driver.navigate().to("https://homeinsurance.asda.com/?_ga=2.11010353.462059740.1586594025-43689212.1586438712");
		Thread.sleep(1000L);
		selectByTextInList(driver, "retrieve a quote", "[class='retrieve-link']>span");
		Thread.sleep(1000L);
		signUpDetails(driver, "QuoteReferenceNumber", actualref);
		Thread.sleep(1000L);
		signUpDetails(driver, "Email", "abcd@gmail.com");
		Thread.sleep(1000L);
		driver.findElement(By.cssSelector("button[data-fieldname='RetrieveQuoteButton']")).click();
	}
	

	/**
	 * @param driver
	 */

	/**
	 * @param driver
	 * @throws InterruptedException
	 */
	private static void scrollToViewEle(WebDriver driver, WebElement first) throws InterruptedException {
		// proposer first name

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", first);
		Thread.sleep(500);
	}

	/**
	 * @param driver
	 * @throws InterruptedException
	 */

	/**
	 * @param driver
	 * @throws Exception
	 */
	private static void signUpDetails(WebDriver driver, String css1, String text) throws Exception {

		WebElement signUpField = driver.findElement(By.cssSelector("input[data-fieldname='" + css1 + "']"));
		scrollToViewEle(driver, signUpField);
		signUpField.sendKeys(text);
	}

	/**
	 * @param driver
	 * @param itr
	 */
	private static void selectByTextInList(WebDriver driver, String match, String css) {
		List<WebElement> dates = driver.findElements(By.cssSelector(css));
		Iterator itr2 = dates.iterator();

		while (itr2.hasNext()) {
			WebElement element2 = (WebElement) itr2.next();
			String detail = element2.getText();
			System.out.println(detail);
			if (detail.equalsIgnoreCase(match)) {

				element2.click();
				break;
			}
		}
	}

}

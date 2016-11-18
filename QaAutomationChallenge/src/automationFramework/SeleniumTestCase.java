/*
Requirements
Write an automated test that finds a player within the EPL Soccer league on our website
(http://www.thescore.com) and verify the specified stats. Assume the project you create will be
the foundation for an automation suite, so please build appropriate abstractions as necessary.

Automate the following steps using your automation framework of choice:
1. Navigate to http://www.thescore.com
2. Verify the URL is correct
3. Click on the main menu button
4. Click on “EPL Soccer”
5. Click on “Leaders”
6. Click on a random player
7. Verify that the height and birthdate display correctly (fields exist, proper format, etc)
*/
package automationFramework;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SeleniumTestCase {

	public static void main(String[] args) {
		// Storing the path to the Chrome Driver on the local machine in the String variable
		// Change the chromeDriverPath value below to match the path the chromeDriver is stored on your local machine
		String chromeDriverPath = "C:\\chromedriver_win32\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		
		// Create a new instance of the Chrome driver
		WebDriver driver = new ChromeDriver();
		
		//
		// Task 1. Navigate to http://www.thescore.com
		//
		System.out.println("\nTask 1. Navigate to http://www.thescore.com");
		// Storing the Application's URL in the String variable
		String appUrl = "http://www.thescore.com";
		// Launch theScore website
		driver.get(appUrl);
		System.out.println("Launched theScore website using Chrome Browser.");
		// Wait up to 20 seconds until page elements are loaded
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		
		//
		// Task 2. Verify the URL is correct
		//
		System.out.println("\nTask 2. Verify the URL is correct");
		// Storing Actual URL in String variable
		String actualUrl = driver.getCurrentUrl();
		 
		if (actualUrl.equals(appUrl))
		{					
			System.out.println("URL Verification Successful - The correct URL is opened.");
		}
		else
		{
			System.out.println("URL Verification Failed - An incorrect URL is opened.");
			System.out.println("Actual URL is : " + actualUrl);
			System.out.println("Expected URL is : " + appUrl);
		}
		
		//
		// Task 3. Click on the main menu button
		//
		System.out.println("\nTask 3. Click on the main menu button");
		// Locate the Main Menu button on the page and store it into WebElement variable mainMenu
		WebElement mainMenu = driver.findElement(By.className("icon-menu"));
		// Click the main menu button
		mainMenu.click();
		System.out.println("Main Menu Button Clicked."); 
		
		
		//
		// Task 4. Click on “EPL Soccer”
		//
		System.out.println("\nTask 4. Click on \"EPL Soccer\"");
		// Locate the EPL Soccer link on the page and store it into WebElement variable eplSoccer
		WebElement eplSoccer = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("EPL Soccer")));
		// Click on "EPL Soccer"
		eplSoccer.click();
		System.out.println("Clicked on EPL Soccer."); 
		
		
		//
		// Task 5. Click on “Leaders”
		//
		System.out.println("\nTask 5. Click on \"Leaders\"");
		// Locate the Leaders link on the page and store it into WebElement variable leaders
		WebElement leaders = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("LEADERS")));
		// Click on "Leaders"
		leaders.click();
		System.out.println("Clicked on Leaders.");
		
		
		//
		// Task 6. Click on a random player
		//
		System.out.println("\nTask 6. Click on a random player");
		// Storing leaders list into a list of web elements
		List<WebElement> leadersList = (List<WebElement>) wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/div[3]/div/div/div[2]/div/section/div/div[1]/ul/li")));
		// Selecting a random player from the list
		WebElement randomPlayer = leadersList.get(new Random().nextInt(leadersList.size()));
		// Click on random player
		randomPlayer.click();
		System.out.println("Random Player selected is: " + randomPlayer.getText());
		System.out.println("Clicked on Random Player.");
		
		//
		// Task 7. Verify that the height and birthdate display correctly (fields exist, proper format, etc)
		//
		System.out.println("\nTask 7. Verify that the height and birthdate display correctly (fields exist, proper format, etc)");
		// Locate the Height/Weight label on the page and store it into WebElement variable heightWeightLabel
		WebElement heightWeightLabel = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div/div/div[2]/div/section/div[1]/div/div/div[3]/div/div/div[1]/span[1]")));
		if(heightWeightLabel.getText() == null)
		{
			System.out.println("Height/Weight Label does not exist on the page.");
		}
		else if(heightWeightLabel.getText().matches("HEIGHT / WEIGHT"))
		{
			System.out.println("Height/Weight Label exists on the page as: " + heightWeightLabel.getText());
		}
		
		// Locate the Height/Weight value on the page and store it into WebElement variable heightWeightValue
		WebElement heightWeightValue = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div/div/div[2]/div/section/div[1]/div/div/div[3]/div/div/div[1]/span[2]")));
		if(heightWeightValue.getText() == null)
		{
			System.out.println("Height/Weight Value does not exist on the page.");
		}
		else if(heightWeightValue.getText() != null)
		{
			System.out.println("Height/Weight Value exists on the page as: " + heightWeightValue.getText());
		}
				
		// Locate the Birth Date label on the page and store it into WebElement variable birthdateLabel
		WebElement birthDateLabel = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div/div/div[2]/div/section/div[1]/div/div/div[3]/div/div/div[2]/span[1]")));
		if(birthDateLabel.getText() == null)
		{
			System.out.println("Birth Date Label does not exist on the page.");
		}
		else if( birthDateLabel.getText().matches("BIRTHDATE"))
		{
			System.out.println("Birth Date Label exists on the page as: " + birthDateLabel.getText());
		}
		
		// Locate the Birth Date value on the page and store it into WebElement variable birthdateValue
		WebElement birthDateValue = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div/div/div[2]/div/section/div[1]/div/div/div[3]/div/div/div[2]/span[2]")));
		if(birthDateValue.getText() == null)
		{
			System.out.println("Birth Date Value does not exist on the page.");
		}
		else if(birthDateValue.getText() != null)
		{
			System.out.println("Birth Date Value exists on the page as: " + birthDateValue.getText());
		}
		String displayedDob = birthDateValue.getText().substring(0, 10);
		System.out.println("Displayed DOB is: " + displayedDob);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try
		{
			Date displayedDate = (Date) dateFormat.parse(displayedDob);
			Date today = new Date();
			String todaysDateString=dateFormat.format(today);
			Date todaysDate = dateFormat.parse(todaysDateString);
			long calculatedAgeMilliseconds = todaysDate.getTime() - displayedDate.getTime();
			int calculatedAge = (int) Math.floor((calculatedAgeMilliseconds / 31536000) / 1000);
			System.out.println("Calculated Age is: " + calculatedAge);
			String displayedAge = birthDateValue.getText().substring(12, 14);
			System.out.println("Displayed Age is: " + displayedAge);
			int displayedAgeValue = Integer.valueOf(displayedAge);
			if (displayedAgeValue == calculatedAge)
			{
				System.out.println("Age Verfication Successful - Age displayed matches calculated Age value.");				
			}
			else
			{
				System.out.println("Age Verfication Failed - Age displayed does not match calculated Age value.");
			}
		} 
		catch (ParseException e)
		{			
			e.printStackTrace();
		}
		
		
		
		// Locate the Birth Place label on the page and store it into WebElement variable birthPlaceLabel
		WebElement birthPlaceLabel = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div/div/div[2]/div/section/div[1]/div/div/div[3]/div/div/div[3]/span[1]")));
		if(birthPlaceLabel.getText() == null)
		{
			System.out.println("Birth Place Label does not exist on the page.");
		}
		else if(birthPlaceLabel.getText().toString().matches("BIRTHPLACE"))
		{
			System.out.println("Birth Place Label exists on the page as: " + birthPlaceLabel.getText());
		}
				
		// Locate the Birth Place value on the page and store it into WebElement variable birthPlaceValue
		WebElement birthPlaceValue = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div/div/div[2]/div/section/div[1]/div/div/div[3]/div/div/div[3]/span[2]")));
		if(birthPlaceValue.getText() == null)
		{
			System.out.println("Birth Place Value does not exist on the page.");
		}
		else if(birthPlaceValue.getText() != null)
		{
			System.out.println("Birth Place Value exists on the page as: " + birthPlaceValue.getText());
		}
		
		// Close browser
		driver.close();
		System.out.println("\nClosed Chrome Browser.");
	}

}

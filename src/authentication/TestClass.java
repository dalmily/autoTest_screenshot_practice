package authentication;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class TestClass {

	public static void main(String[] args) throws IOException {

		System.setProperty("webdriver.edgediver.driver", "/Users/imac/Downloads/edgedriver_mac64");

		WebDriver driver = new EdgeDriver();

		driver.get("http://127.0.0.1:5500/index.html");

		
		List<WebElement> theStudents = driver.findElements(By.tagName("option"));

		// int TheTotalNmberOfStudents = theStudents.size();

		 System.out.println(theStudents.size()+" this is the orginal number before removing ");
		// System.out.println(TheTotalNmberOfStudents);

		// System.out.println(HowManyItems+"this is the number of items i have removed
		// ");

		for (int i = 0; i < theStudents.size(); i++) {
			if (i % 2 == 0) {

				theStudents.get(i).click();
				System.err.println("i will remove " + theStudents.get(i).getText());

				driver.findElement(By.xpath("//*[@id=\"remove\"]")).click();

			} else {

				System.out.println("i will keep " + theStudents.get(i).getText());

			}

		}
		
		List<WebElement> theStudentsAfterRemoving = driver.findElements(By.tagName("option"));
		System.out.println(theStudentsAfterRemoving.size()+" this is the number after removing ");
		
		
		Date currentDate = new Date();
		String TheActualDate = currentDate.toString().replace(":", "-");

		TakesScreenshot src = ((TakesScreenshot) driver);

		File SrcFile = src.getScreenshotAs((OutputType.FILE));
		File dest = new File("./mypictures/" + currentDate + ".png");
		FileUtils.copyFile(SrcFile, dest);

		// List <WebElement> theStudentsAfterRemove =
		// driver.findElements(By.tagName("option"));

		// int ActualNumber = theStudentsAfterRemove.size();
		// System.out.println(ActualNumber+"this is the new actual number ");

		// int expectedItems = TheTotalNmberOfStudents/2;

		// System.out.println(expectedItems+"the the expected numvber");

		// Assert.assertEquals(ActualNumber, expectedItems);

	}
}

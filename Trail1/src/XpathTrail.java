import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathTrail {

	public static void main(String[] args)

	{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		try {
			driver.get("https://www.amazon.in/");
			// driver.manage().timeouts().implicitlyWait(5,SECONDS);
			List<WebElement> elements = driver.findElements(By.xpath("//a[@class='nav-a  ']"));
			for (WebElement tab : elements) {
				System.out.println(tab.getText());
			}
		} catch (Exception e) {
			File f1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		}

		driver.close();
	}
	 public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{

	        //Convert web driver object to TakeScreenshot

	        TakesScreenshot scrShot =((TakesScreenshot)webdriver);

	        //Call getScreenshotAs method to create image file

	                File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

	            //Move image file to new destination

	                File DestFile=new File(fileWithPath);

	                //Copy file at destination

	                FileUtils.copyFile(SrcFile, DestFile);

	    }
}

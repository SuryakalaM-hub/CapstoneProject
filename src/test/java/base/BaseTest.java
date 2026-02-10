package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class BaseTest {

    protected static WebDriver driver;
    

    @BeforeSuite
    public void setup() {

               System.out.println("Launching Chrome browser...");

            //WebDriverManager.chromedriver().setup();
           /*
            driver = new ChromeDriver();

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            System.out.println("Launching Flipkart URL...");
            driver.get("https://www.flipkart.com/");
     */
               WebDriverManager.chromedriver().setup();

               // Add options to prevent session creation failure
               ChromeOptions options = new ChromeOptions();
               options.addArguments("--remote-allow-origins=*");
               options.setBinary("C:\\Program Files\\Google\\Chrome Beta\\Application\\chrome.exe"); // optional

              // ChromeDriver driver = new ChromeDriver(options);
                driver = new ChromeDriver(options);
               driver.manage().window().maximize();
               driver.get("https://www.flipkart.com");
               driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       
    }

    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        	//System.out.println("Success");
        }
    }
}

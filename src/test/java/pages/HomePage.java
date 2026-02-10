package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    By flipkartLogo = By.xpath("//img[@title='Flipkart']");
   // By searchBox = By.name("q");
    By searchBox = By.xpath("//input[@name='q'][1]");
    By searchButton = By.xpath("//button[@type='submit']");

    public boolean verifyLogo() {
        return driver.findElement(flipkartLogo).isDisplayed();
    }

    public void searchProduct(String product) throws InterruptedException {
    	Thread.sleep(15);
    	driver.findElement(searchBox).click();
        driver.findElement(searchBox).sendKeys(product);
        driver.findElement(searchButton).click();
    }
}

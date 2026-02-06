package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class ProductPage {

    WebDriver driver;
    WebDriverWait wait;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    By addToCartBtn = By.xpath("//button[text()='Add to cart']");
    //By cartText = By.xpath("//span[text()='Cart']");
    By cartText = By.xpath("//a[contains(@class,'Xd1D1s')]");
    
    By loginPopupCloseBtn = By.xpath("//button[contains(@class,'_2KpZ6l _2doB4z')]");

    // Switch to the product tab (assuming the new tab opens at the end)
    public void switchToProductTab() {
        String currentWindow = driver.getWindowHandle();
        Set<String> windows = driver.getWindowHandles();
        for (String win : windows) {
            if (!win.equals(currentWindow)) {
                driver.switchTo().window(win);
                break;
            }
        }
    }

    // Close login popup if it appears
    public void closeLoginPopupIfPresent() {
        try {
            WebElement popupClose = wait.until(ExpectedConditions.elementToBeClickable(loginPopupCloseBtn));
            popupClose.click();
        } catch (Exception e) {
            // Popup not displayed, continue
        }
    }

    // Add product to cart
    public void addToCart() {
        closeLoginPopupIfPresent();
        JavascriptExecutor js = (JavascriptExecutor) driver;

     // scroll down 300 pixels
     js.executeScript("window.scrollBy(0,300)");
        wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn)).click();
        System.out.println("hai");
    }

    // Verify product added to cart
    
  /*  public boolean verifyAddedToCart() {
        // Click on cart icon to ensure cart page is visible
    	 System.out.println("hai");
    	 
        return wait.until(ExpectedConditions.visibilityOfElementLocated(cartText)).isDisplayed();
    }*/
    public boolean verifyAddedToCart() {
        try {
        	//System.out.println(wait.until(ExpectedConditions.visibilityOfElementLocated(cartText)));
            return wait.until(ExpectedConditions.visibilityOfElementLocated(cartText)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}

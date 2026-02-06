package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultsPage {

    WebDriver driver;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    By firstProduct = By.xpath("(//div[@data-id])[1]");

    public void clickFirstProduct() {
        driver.findElement(firstProduct).click();
    }
}

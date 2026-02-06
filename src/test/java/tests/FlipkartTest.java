package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductPage;
import pages.SearchResultsPage;

public class FlipkartTest extends BaseTest {

    @Test
    public void addProductToCartTest() throws InterruptedException {

        HomePage home = new HomePage(driver);
        Assert.assertTrue(home.verifyLogo(), "Flipkart logo not displayed");

        home.searchProduct("TV");

        SearchResultsPage results = new SearchResultsPage(driver);
        results.clickFirstProduct();

        ProductPage product = new ProductPage(driver);
        product.switchToProductTab();
        product.addToCart();
        Thread.sleep(10);
        boolean b=false;
         b=product.verifyAddedToCart();
        System.out.println(b);
        //System.out.println(Assert.assertTrue(b,"Added"));
        if (b) {
            Reporter.log("Product is added to cart", true);
        }

        Assert.assertTrue(b, "Product not added to cart successfully");
        
    //    Assert.assertTrue(b,"Added");
    //   Assert.assertTrue(product.verifyAddedToCart(),"Product not added to cart successfully");
        Thread.sleep(10);
    }
}

package saucedemo.test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import saucedemo.pages.CartPage;
import saucedemo.pages.CheckoutPage;
import saucedemo.pages.LoginPage;
import saucedemo.pages.ProductsPage;
import saucedemo.pages.ThankYouPage;

public class SaucedemoTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testCompletePurchase() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addFirstProductToCart();
        productsPage.goToCart();

        CartPage cartPage = new CartPage(driver);
        wait.until(ExpectedConditions.elementToBeClickable(cartPage.getCheckoutButton()));
        cartPage.clickCheckout();

        wait.until(ExpectedConditions.urlContains("checkout-step-one.html"));
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.fillCheckoutInfo("John", "Doe", "12345");
        checkoutPage.clickContinue();
        checkoutPage.finishCheckout();

        ThankYouPage thankYouPage = new ThankYouPage(driver);
        assertTrue(thankYouPage.isThankYouMessageDisplayed(), "Mensaje de gracias no se muestra.");
    }
}

package saucedemo.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
        wait.until(ExpectedConditions.urlContains("inventory.html"));
    }

    public void addFirstProductToCart() {
        WebElement firstAddToCartBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.btn_inventory")));
        firstAddToCartBtn.click();
    }

    public void goToCart() {
        WebElement cartIcon = wait.until(ExpectedConditions.elementToBeClickable(By.className("shopping_cart_link")));
        cartIcon.click();
    }
}
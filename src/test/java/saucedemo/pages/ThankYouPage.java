package saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ThankYouPage {
    private WebDriver driver;

    public ThankYouPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isThankYouMessageDisplayed() {
        return driver.findElement(By.className("complete-header")).isDisplayed();
    }
}

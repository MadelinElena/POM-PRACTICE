package saucedemo.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import saucedemo.base.BasePage;

public class CartPage extends BasePage {

    @FindBy(css = ".cart_item")
    private List<WebElement> cartItems;

    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    @FindBy(className = "cart_button")
    private List<WebElement> removeButtons;

    @FindBy(id = "continue-shopping")
    private WebElement continueShoppingButton;

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("cart_list")));
    }

    public void clickCheckout() {
        wait.until(ExpectedConditions.elementToBeClickable(checkoutButton)).click();
    }

    public void clickContinueShopping() {
        click(continueShoppingButton);
    }

    public int getCartItemCount() {
        return cartItems.size();
    }

    public void removeAllItems() {
        for (WebElement button : removeButtons) {
            click(button);
        }
    }

    public boolean isCartEmpty() {
        return getCartItemCount() == 0;
    }

    public WebElement getCheckoutButton() {
        return checkoutButton;
    }
}

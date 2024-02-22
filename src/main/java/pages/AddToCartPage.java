package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddToCartPage extends BasePage {
    @FindBy(css = "a[onclick='addToCart(9)']")
    WebElement addToCartButton;
    @FindBy(id = "cartur")
    WebElement goToCartButton;


    public AddToCartPage(WebDriver driver) {
        super(driver);
    }

    public void addToCart() {
        addToCartButton.click();
    }

    public void goToCart() {
        goToCartButton.click();
    }
}

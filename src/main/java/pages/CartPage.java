package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {
    @FindBy(css = ".btn.btn-success")
    WebElement cartButton;


    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void placeOrder() {
        cartButton.click();
    }
}

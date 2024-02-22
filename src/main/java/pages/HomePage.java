package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Constants;

public class HomePage extends BasePage {
    @FindBy(css = "#login2")
    WebElement inputLogin;
    @FindBy(css = "#loginusername")
    WebElement loginUserButton;
    @FindBy(css = "#loginpassword")
    WebElement loginPassword;
    @FindBy(css = "button[onclick='logIn()']")
    WebElement acceptButton;
    @FindBy(xpath = "//button[contains(text(),'Next')]")
    WebElement next;
    @FindBy(xpath = "(//img[@class='card-img-top img-fluid'])[9]")
    WebElement product;


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void loginButton() {
        inputLogin.click();
    }

    public void loginName() {
        loginUserButton.sendKeys(Constants.NEW_NAME);
    }

    public void loginPassword() {
        loginPassword.sendKeys(Constants.New_PASSWORD);
    }

    public void submitButton() {
        acceptButton.click();
    }

    public void nextButton() {
        scrollToElement(next);
        next.click();
    }

    public void selectProduct() {
        product.click();
    }
}

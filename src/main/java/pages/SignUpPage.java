package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Constants;

public class SignUpPage extends BasePage {

    @FindBy(xpath = "//a[contains(text(),'Sign up')]")
    WebElement signUp;
    @FindBy(css = "#sign-username")
    WebElement signInUserName;

    @FindBy(css = "#sign-password")
    WebElement signInPassword;
    @FindBy(css = "button[onclick='register()']")
    WebElement registerButton;


    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    public void signUpButton() {
        signUp.click();
    }

    public void inputName() {
        signInUserName.sendKeys(Constants.NEW_NAME);
    }

    public void inputPassword() {
        signInPassword.sendKeys(Constants.New_PASSWORD);
    }

    public void signUpRegister() {
        registerButton.click();
    }
}

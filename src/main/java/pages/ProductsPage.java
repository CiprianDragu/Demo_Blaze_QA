package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Constants;

public class ProductsPage extends BasePage {
    @FindBy(css = "#name")
    WebElement nameText;
    @FindBy(css = "#country")
    WebElement nameCountry;
    @FindBy(css = "#city")
    WebElement nameCity;
    @FindBy(css = "#card")
    WebElement cardNumber;
    @FindBy(css = "#month")
    WebElement month;
    @FindBy(css = "#year")
    WebElement year;
    @FindBy(css = "button[onclick='purchaseOrder()']")
    WebElement purchaseOrder;
    @FindBy(xpath = "//h2[contains(text(),'Thank you for your purchase!')]")
    WebElement textMessage;
    @FindBy(xpath = "//button[contains(text(),'OK')]")
    WebElement okMessage;


    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void inputName() {
        nameText.sendKeys(Constants.NEW_NAME);
    }

    public void inputCountry() {
        nameCountry.sendKeys(Constants.COUNTRY);
    }

    public void inputCity() {
        nameCity.sendKeys(Constants.CITY);
    }

    public void inputCreditCard() {
        cardNumber.sendKeys(Constants.CREDIT_CARD);
    }

    public void inputMonth() {
        month.sendKeys(Constants.MONTH);
    }

    public void inputYear() {
        year.sendKeys(Constants.YEAR);
    }

    public void purchaseButton() {
        purchaseOrder.click();
    }

    public String ThankYouMessage() {
        return textMessage.getText();
    }

    public void okButton() {
        okMessage.click();
    }

}


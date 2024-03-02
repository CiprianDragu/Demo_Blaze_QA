import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;
import utils.Constants;

public class BaseTest {
    WebDriver driver;

    @BeforeTest
    public void setUP() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(Constants.URL);
    }

    @Test
    public void goToWebsiteAndVerifyTest() {
        String actualMessage = driver.findElement(By.xpath("//a[@id='nava']")).getText();
        String expectedMessage = "PRODUCT STORE";
        Assert.assertEquals(actualMessage, expectedMessage);
        String actualColor = driver.findElement(By.xpath("//a[@id='nava']")).getCssValue("color");
        String expectedColor = "rgba(255, 255, 255, 1)";
        Assert.assertEquals(actualColor, expectedColor);

    }

    @Test
    public void goToWebsiteSignUpTest() {
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.signUpButton();
        signUpPage.waitInSeconds(4);
        signUpPage.inputName();
        signUpPage.inputPassword();
        signUpPage.signUpRegister();
        signUpPage.waitInSeconds(3);
        driver.switchTo().alert().dismiss();
    }

    @Test
    public void goToLoginTest() {
        HomePage homePage = new HomePage(driver);
        homePage.loginButton();
        homePage.waitInSeconds(4);
        homePage.loginName();
        homePage.loginPassword();
        homePage.submitButton();
        homePage.waitInSeconds(4);
        String actualMessage = driver.findElement(By.xpath("//a[contains(text(),'Welcome Boris.Masaciuc')]")).getText();
        String expectedMessage = "Welcome Boris.Masaciuc";
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @Test
    public void addProductTest() {
        HomePage homePage = new HomePage(driver);
        homePage.waitInSeconds(5);
        homePage.nextButton();
        homePage.selectProduct();
        AddToCartPage addToCartPage = new AddToCartPage(driver);
        addToCartPage.waitInSeconds(4);
        addToCartPage.addToCart();
        addToCartPage.waitInSeconds(3);
        driver.switchTo().alert().dismiss();
        addToCartPage.waitInSeconds(4);
        driver.quit();
    }

    @Test
    public void endToEndTest() {
        HomePage homePage = new HomePage(driver);
        homePage.waitInSeconds(5);
        homePage.nextButton();
        homePage.selectProduct();
        AddToCartPage addToCartPage = new AddToCartPage(driver);
        addToCartPage.waitInSeconds(4);
        addToCartPage.addToCart();
        addToCartPage.waitInSeconds(3);
        driver.switchTo().alert().dismiss();
        addToCartPage.goToCart();
        CartPage cartPage = new CartPage(driver);
        cartPage.placeOrder();
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.waitInSeconds(4);
        productsPage.inputName();
        productsPage.inputCountry();
        productsPage.inputCity();
        productsPage.inputCreditCard();
        productsPage.inputMonth();
        productsPage.inputYear();
        productsPage.purchaseButton();
        String actualMessage = productsPage.ThankYouMessage();
        String expectedMessage = "Thank you for your purchase!";
        Assert.assertEquals(actualMessage, expectedMessage);
        productsPage.waitInSeconds(4);
        productsPage.okButton();
        productsPage.waitInSeconds(4);
        driver.quit();
    }
}




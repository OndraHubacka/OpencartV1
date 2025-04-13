package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    // constructor
    public HomePage(WebDriver driver)
    {
        super(driver); // invoke parent constructor
    }



    // Locators
    @FindBy(xpath = "//span[normalize-space()='My Account']")
    WebElement linkMyAccount;

    @FindBy(xpath = "//a[normalize-space()='Register']")
    WebElement linkRegister;

    // session 51 | Step 5
    @FindBy(linkText = "Login")
    WebElement linkLogin;




    // Action Methods
    public void clickMyAccount()
    {
        linkMyAccount.click();
    }
    public void clickRegister()
    {
        linkRegister.click();
    }

    public void clickLogin()
    {
        linkLogin.click();
    }

}

package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountRegistrationPage extends BasePage{

    public AccountRegistrationPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//input[@id='input-firstname']")
    WebElement txtFirstName;

    @FindBy(xpath = "//input[@id='input-lastname']")
    WebElement txtLastName;

    @FindBy(xpath = "//input[@id='input-email']")
    WebElement txtEmail;

    @FindBy(xpath = "//input[@id='input-telephone']")
    WebElement txtTelephone;

    @FindBy(xpath = "//input[@id='input-password']")
    WebElement txtPassword;

    @FindBy(xpath = "//input[@id='input-confirm']")
    WebElement txtConfirmPassword;

    @FindBy(xpath = "//input[@name='agree']")
    WebElement chkdPolicy;

    @FindBy(xpath = "//input[@value='Continue']")
    WebElement btnContinue;

    @FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
    WebElement msgConfirmation;

    public void setFirstName(String fname){
        txtFirstName.sendKeys(fname);
    }
    public void setLastName(String lname){
        txtLastName.sendKeys(lname);
    }
    public void setEmail(String email){
        txtEmail.sendKeys(email);
    }
    public void setTelephone(String tel){
        txtTelephone.sendKeys(tel);
    }
    public void setPassword(String pwd){
        txtPassword.sendKeys(pwd);
    }
    public void setConfirmPassword(String cpwd){
        txtConfirmPassword.sendKeys(cpwd);
    }
    public void confirmPrivacyPolicy(){
        chkdPolicy.click();
    }

    public void clickContinue(){
        btnContinue.click();

        // btnContinue.submit();
        // btnContinue.sendK
        // WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // myWait.until(ExpectedConditions.elementToBeClickable(btnContinue));
    }

    public String getConfirmationMsg()
    {
        try {
            return (msgConfirmation.getText());
        }
        catch (Exception e){
            return (e.getMessage());
        }
    }



}

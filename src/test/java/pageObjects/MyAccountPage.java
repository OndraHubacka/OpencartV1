package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{

    // constructor
    public MyAccountPage(WebDriver driver){
        super(driver);
    }


    // locators
    @FindBy(xpath = "//h2[normalize-space()='My Account']") // My Account page heading
    WebElement msgHeadingMyAccount;

    @FindBy(xpath = "//div[@class='list-group']//a[text()='Logout']")   // added in Step6
    WebElement lnkLogout;


    // Action Methods
    public boolean isMyAccountPageExisting(){
        try{
            return (msgHeadingMyAccount.isDisplayed());
        }
        catch (Exception e){
            return false;
        }
    }

    public void clickLogout(){  // added in Step6 in Framework
        lnkLogout.click();
    }

}

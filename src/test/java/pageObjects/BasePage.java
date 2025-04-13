package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


// #####################################
// Parent of all pageObject classes!!!!

public class BasePage {

    WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
}

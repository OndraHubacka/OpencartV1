package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {


    @Test(groups = {"Sanity", "Master"})
    public void verifyLogin(){
        logger.info("***** Starting TC002_LoginTest *****");

        try {

        // HomePage
        HomePage hp = new HomePage(driver);
        hp.clickMyAccount();
        hp.clickLogin();

        // Login
        LoginPage lp = new LoginPage(driver);
        lp.setEmail(p.getProperty("email"));
        lp.setPassword(p.getProperty("password"));
        lp.clickLogin();

        // MyAccount
        MyAccountPage myacc = new MyAccountPage(driver);
        boolean targetPage = myacc.isMyAccountPageExisting();

        Assert.assertTrue(targetPage);  // Assert.assertEquals(targetPage, true, "Login failed");

        logger.info("***** Finishing TC002_LoginTest *****");

        }
        catch (Exception e){
            Assert.fail();
        }
    }
}

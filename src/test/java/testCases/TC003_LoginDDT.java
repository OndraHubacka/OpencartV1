package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass {

    @Test(dataProvider = "Provider1_LoginData", dataProviderClass = DataProviders.class, groups = "DataDriven")
    public void verify_LoginDDT(String email, String pwd, String exp){

        logger.info("***** Starting TC_003_LoginDDT *****");

        try {

            // HomePage
            HomePage hp = new HomePage(driver);
            hp.clickMyAccount();
            hp.clickLogin();

            // Login
            LoginPage lp = new LoginPage(driver);
            lp.setEmail(email);
            lp.setPassword(pwd);
            lp.clickLogin();

            // MyAccount
            MyAccountPage macc = new MyAccountPage(driver);
            boolean targetPage = macc.isMyAccountPageExisting();


        /*
    Data is valid - login success - test passes - logout
    Data is valid - login unsuccessful - test fail


    Data invalid - login success - test fail - logout
    Data invalid - login failed  - test pass
     */
            if (exp.equalsIgnoreCase("Valid")) {
                if (targetPage == true) {
                    macc.clickLogout();
                    Assert.assertTrue(true);
                } else {
                    Assert.assertTrue(false);
                }
            }

            if (exp.equalsIgnoreCase("Invalid")) {
                if (targetPage == true) {
                    macc.clickLogout();
                    Assert.assertTrue(false);
                } else {
                    Assert.assertTrue(true);
                }
            }
        }
        catch (Exception e){
            Assert.fail();
        }

        logger.info("***** Finishing TC_003_LoginDDT *****");


    }
}

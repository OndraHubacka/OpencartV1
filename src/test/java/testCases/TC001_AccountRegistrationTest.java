package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {

    @Test(groups = {"Regression", "Master"})
    public void verifyAccountRegistration()
    {

        try {
            logger.info("***** Starting TC001_AccountRegistrationTest *****");
            HomePage hp = new HomePage(driver);
            hp.clickMyAccount();
            logger.info("Clicked on MyAccount link");

            hp.clickRegister();
            logger.info("Clicked on Register link");

            AccountRegistrationPage regpage = new AccountRegistrationPage(driver);

            logger.info("Providing customer details..");
            regpage.setFirstName(randomString().toUpperCase());
            regpage.setLastName(randomString().toUpperCase());
            regpage.setEmail(randomString() + "@gmail.com"); // randomly generated
            regpage.setTelephone(randomNumber());

            String password = randomAlphaNumeric();

            regpage.setPassword(password);
            regpage.setConfirmPassword(password);

            regpage.confirmPrivacyPolicy();
            regpage.clickContinue();

            logger.info("Validating expected message..");

            String confmsg = regpage.getConfirmationMsg();
            logger.debug("Confirmation message received: " + confmsg);

            if (confmsg.equals("Your Account Has Been Created!")){
                Assert.assertTrue(true);
            }
            else{
                logger.error("Test failed.. Expected message not found.");
                logger.debug("Actual message: " + confmsg);
                Assert.fail("Expected message not found. Actual: " + confmsg);
            }

        }
        catch (Exception e){
            logger.error("Exception occurred: ", e);
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }

        logger.info("***** Finished TC001_AccountRegistrationTest *****");

    }
}

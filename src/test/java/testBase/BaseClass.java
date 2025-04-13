package testBase;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager; // log4j
import org.apache.logging.log4j.Logger; // log4j
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

public class BaseClass {

    public WebDriver driver;
    public Logger logger;   // Log4j2
    // public static final Logger logger = LogManager.getLogger(BaseClass.class);
    public Properties p;


    @BeforeClass(groups = {"Sanity", "Regression", "Master"})
    @Parameters({"os", "browser"})
    public void setup(String os, String br) throws IOException {


        // Loading config.properties file
        FileReader file = new FileReader("./src//test//resources//config.properties");
        p = new Properties();
        p.load(file);


        logger = LogManager.getLogger(this.getClass());
        logger.info("LOGGER IS WORKING");

        // SeleniumGRID --> REMOTE
        if (p.getProperty("execution_env").equalsIgnoreCase("remote"))
        {
            DesiredCapabilities capabilities = new DesiredCapabilities();

            // 1) Static
            // capabilities.setPlatform(Platform.WIN10);
            // capabilities.setBrowserName("chrome");


            // 2) getting info from .xml file
            // os
            if (os.equalsIgnoreCase("windows")){
                capabilities.setPlatform(Platform.WIN10);
            }
            else if (os.equalsIgnoreCase("linux")){
                capabilities.setPlatform(Platform.LINUX);
            }
            else {
                System.out.println("No matching OS..");
                return;
            }

            // browser
            switch (br.toLowerCase()){
                case "chrome": capabilities.setBrowserName("chrome"); break;
                case "edge": capabilities.setBrowserName("MicrosoftEdge"); break;
                case "firefox": capabilities.setBrowserName("firefox"); break;
                default:
                    System.out.println("No matching browser"); return;
            }

            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);

        }

        // LOCAL
        if (p.getProperty("execution_env").equalsIgnoreCase("local"))
        {
            // browser
            switch (br.toLowerCase()){
                case "chrome" : driver = new ChromeDriver(); break;
                case "edge" : driver = new EdgeDriver(); break;
                case "firefox" : driver = new FirefoxDriver(); break;
                default: System.out.println("Invalid browser name.."); return;
            }

        }


        /*
        switch (br.toLowerCase()){

            case "chrome" : driver = new ChromeDriver(); break;
            case "edge" : driver = new EdgeDriver(); break;
            case "firefox" : driver = new FirefoxDriver(); break;
            default: System.out.println("Invalid browser name.."); return;
        }

         */

        // driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://tutorialsninja.com/demo/index.php?route=common/home");
        // driver.get(p.getProperty("appUrl")); // reading URL from config.properties file
        driver.manage().window().maximize();
    }

    @AfterClass(groups = {"Sanity", "Regression", "Master"})
    public void tearDown(){
        driver.quit();
    }



    public String randomString(){
        String generatedstring = RandomStringUtils.randomAlphabetic(5);
        return generatedstring;
    }

    public String randomNumber(){
        String generatednumber = RandomStringUtils.randomAlphanumeric(10);
        return generatednumber;
    }

    public String randomAlphaNumeric(){
        String generatedString = RandomStringUtils.randomAlphabetic(3);
        String generatedNumber = RandomStringUtils.randomAlphanumeric(4);
        return (generatedString+"#"+generatedNumber);
    }

}

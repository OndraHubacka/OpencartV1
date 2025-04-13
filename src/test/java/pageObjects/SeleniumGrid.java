package pageObjects;


// !!! DO NOT USE !!! just basic overview
// !!! DO NOT USE !!! just basic overview
// !!! DO NOT USE !!! just basic overview


import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class SeleniumGrid {
    public static void main(String[] args) throws MalformedURLException {

        // The URL will be IP address of Hub Machine + Hub Port + /wd/hub
        // http://192.168.1.21:4444/wd/hub      or      http://localhost:4444/wd/hub

        String hubUrl = "http://localhost:4444/wd/hub";
        DesiredCapabilities desCap = new DesiredCapabilities();

        desCap.setPlatform(Platform.WIN10); // desCap.setPlatform(Platform.LINUX);
        desCap.setBrowserName("chrome");    // desCap.setBrowserName("edge");

        WebDriver driver = new RemoteWebDriver(new URL(hubUrl), desCap);

        driver.get("https://www.google.com");
        System.out.println(driver.getTitle());
        driver.quit();
    }
}


/*

// SeleniumGRID --> REMOTE (gets data from properties file)
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
                default:
                    System.out.println("No matching browser"); return;
            }

            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);

        }


// LOCAL execution (data from properties file)
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
 */



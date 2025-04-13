package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ExtentReportManager implements ITestListener {

    public ExtentSparkReporter sparkReporter;
    public ExtentReports extReports;
    public ExtentTest extTest;

    String repName;

    public void onStart(ITestContext testContext){

        /*
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
        Date dateDT = new Date();
        String currentDateTimeStamp = dateFormat.format(dateDT);
        */

        // above same as below
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());  // time stamp


        repName = "Test-Report-" + timeStamp + ".html";
        sparkReporter = new ExtentSparkReporter(".//reports"+ repName); // specify location of the report

        sparkReporter.config().setDocumentTitle("opencart Automation Report");  // Title of report
        sparkReporter.config().setReportName("opencart Functional Testing");    // name of the report
        sparkReporter.config().setTheme(Theme.DARK);


        extReports= new ExtentReports();
        extReports.attachReporter(sparkReporter);
        extReports.setSystemInfo("Application", "opencart");
        extReports.setSystemInfo("Module", "Admin");
        extReports.setSystemInfo("Sub Module", "Customers");
        extReports.setSystemInfo("User Name", System.getProperty("user.name"));
        extReports.setSystemInfo("Environment", "QA");




        String os = testContext.getCurrentXmlTest().getParameter("os");
        extReports.setSystemInfo("Operating System", os);

        String browser = testContext.getCurrentXmlTest().getParameter("browser");
        extReports.setSystemInfo("Browser", browser);

        List <String> includedGroups = testContext.getCurrentXmlTest().getIncludedGroups();
        if (!includedGroups.isEmpty()) {
            extReports.setSystemInfo("Groups", includedGroups.toString());
        }




    }
}

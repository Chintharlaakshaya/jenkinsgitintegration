package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
            try {
                ConfigReader.loadConfig();
            } catch (Exception e) {
                System.out.println("⚠ Warning: ConfigReader not loaded properly, using defaults.");
            }

            // Generate timestamped report path
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String reportPath = System.getProperty("user.dir") + "/reports/ExtentReports/ExtentReport_" + timestamp + ".html";

            ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
            spark.config().setReportName("nopCommerce Automation Report");
            spark.config().setDocumentTitle("Automation Test Results");

            extent = new ExtentReports();
            extent.attachReporter(spark);

            // Adding system/environment info
            extent.setSystemInfo("Tester", "Akshaya"); 
            extent.setSystemInfo("Browser", ConfigReader.getProperty("browser") != null ? ConfigReader.getProperty("browser") : "chrome");
            extent.setSystemInfo("Base URL", ConfigReader.getProperty("url") != null ? ConfigReader.getProperty("url") : "https://demo.nopcommerce.com");
        }
        return extent;
    }
}

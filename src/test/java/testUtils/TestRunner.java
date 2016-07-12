package testUtils; /**
 * Created by logovskoy on 12/3/2015.
 */

import com.unitedsofthouse.ucucumberpackage.tools.WebCucDriver;
import helpers.SystemHelper;
import arp.ReportService;
import pages.base.PageInstance;
import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.junit.Cucumber;
import arp.CucumberArpReport;
import arp.ReportClasses.Report;
import arp.ReportClasses.Step;
import arp.ReportClasses.Test;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

import static com.unitedsofthouse.ucucumberpackage.typesfactory.factory.TypeFactory.setArpReportClient;

//import pages.LoginPage;

/**
 * @RunWith Class with this annotation will run a Cucumber Feature. The class should be empty without any fields or methods.
 * @CucumberOptions This annotation provides the same options as the cucumber command line.
 * @params format What formatter(s) to use.
 * @params features The paths to the feature(s).
 * @params glue Where to look for glue code (stepdefs and hooks).
 * @params tags Identify scenarios or features to run.
 */
@RunWith(Cucumber.class)

@CucumberOptions(format = {"pretty",
        "html:target/cucumber-htmlreport",
        //"json:target/cucumber-report.json",
        "junit:target/cucumber-junit-report/cuc.xml"}
        , glue = {"stepdefinition", "testUtils"}
        , features = {"src/test/resources"}
        , tags = {"@High"}
)
public class TestRunner extends PageInstance {

    @BeforeClass
    public static void BeforeClass() {
        try {
            File dir = new File("src/test/resources");
            List<File> features = Arrays.stream(dir.listFiles()).filter(p -> p.getName().contains(".feature")).collect(Collectors.toList());
            BufferedReader br = new BufferedReader(new FileReader(features.get(0)));
            String featureName = "";
            while (true) {
                String stringFromFile = br.readLine();
                if (stringFromFile.contains("Feature:")) {
                    featureName = stringFromFile.replace("Feature:", "");
                    while (featureName.startsWith(" ") || featureName.endsWith(" ")) {
                        featureName = featureName.trim().toLowerCase().replace(" ","-");
                    }
                    break;
                }
            }
            CucumberArpReport.open("B26AAC2A-4D91-4231-9315-9FFA4B6DCD16", featureName);
            //arpClient.enableScreenshotLogging();
            List<Step> steps = new ArrayList();

            Step reportStep = new Step();
            reportStep.Description = "Login process";
            reportStep.PublicKey = UUID.randomUUID();
            reportStep.ExpectedResult = "Sucsessfull login";
            steps.add(reportStep);

            Test test = new Test();
            test.Name = "Login";
            test.Steps = steps;
            test.IsStarted = true;
            test.StartTime = new Date();
            CucumberArpReport.addTest(test);
            CucumberArpReport.setLastAddedTestActive();
            setArpReportClient(new CucumberArpReport());
            ChromeOptions options = new ChromeOptions();
            options.addArguments("test-type");
            options.addArguments("disable-popup-blocking");
            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
            WebCucDriver.setWebdriver("CH", capabilities, null);
            driver = WebCucDriver.getDriver();
            String url = SystemHelper.URL;
            driver.navigate().to(url);
            driver.manage().window().maximize();
            //LoginPage lg = new LoginPage();
            //lg.performLogin();
            Thread.sleep(10000);
            CucumberArpReport.getReport();
            ReportService.turnOnJUnitLogging();
            Report report = CucumberArpReport.getReport();
            ReportService.ReportAction("Login was succesfull", true);
            for (Step step : report.TestSuite.Tests.get(0).Steps) {
                step.StartTime = new Date();
                step.EndTime = new Date();
            }
            CucumberArpReport.setReport(report);
            CucumberArpReport.decideTestStatus();
            ReportService.FinishTest();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public static void CreateReport() throws Exception {
        try {
            CucumberArpReport.getReport();
            ReportService.closeAndSendToAnotherURL("http://10.10.80.162:90/Services/Deployment.asmx?WSDL");
            try {
                Scenario scenario = BeforeAfter.lastScenario;
                Field f = null;
                try {
                    f = scenario.getClass().getDeclaredField("reporter");
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                }
                f.setAccessible(true);
            } catch (Exception ex) {
            }
            driver.quit();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            driver = null;
        }
    }
}

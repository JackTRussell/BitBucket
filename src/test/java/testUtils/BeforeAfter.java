package testUtils;

import helpers.SystemHelper;
import arp.ReportService;
import pages.base.PageInstance;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import arp.CucumberArpReport;

import static com.unitedsofthouse.ucucumberpackage.typesfactory.factory.TypeFactory.setArpReportClient;
import static helpers.SystemHelper.MAINWINDOWHANDLER;
import static helpers.SystemHelper.Reset_Values;

//import pages.LoginPage;

/**
 * Created by logovskoy on 12/3/2015.
 */
public class BeforeAfter extends PageInstance {

    public static Scenario lastScenario;

    /*@Autowired
    @Lazy
    public LoginPage loginPage;*/

    //@Autowired
    //@Lazy
    //public HomePage homePage;

    //@Autowired
    //PopUp popup;


    @Before
    public void setUp(Scenario scenario) {
        Reset_Values();
        try {
            MAINWINDOWHANDLER = driver.getWindowHandle();
            setArpReportClient(new CucumberArpReport());
            if (!scenario.getId().startsWith(arpClient.getTestSuiteName().toLowerCase())) {
                ReportService.closeAndSendToAnotherURL("http://10.10.80.162:90/Services/Deployment.asmx?WSDL");
                arpClient.open("B26AAC2A-4D91-4231-9315-9FFA4B6DCD16", scenario.getId());
            }
            arpClient.addTestToTestSuite(scenario);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown(Scenario scenario) throws Exception {
        try {
            arpClient.decideTestStatus();
            arpClient.FinishTest();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Thread x = new Thread() {
                public void run() {
                    driver.navigate().to(SystemHelper.URL);
                }
            };
            Thread y = new Thread() {
                public void run() {
                    try {
                        //popup.clickAccept();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    driver.switchTo().activeElement();
                    driver.navigate().to(SystemHelper.URL);
                }
            };
            x.start();
            Thread.sleep(2000L);
            if (x.isAlive()) {
                x.interrupt();
                y.start();
                Thread.sleep(10000L);
                if (y.isAlive()) {
                    y.interrupt();
                }
            }
        }
    }
}
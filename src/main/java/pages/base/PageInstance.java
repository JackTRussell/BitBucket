package pages.base;


import arp.CucumberArpReport;
import arp.ReportClasses.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;

/**
 * Created by logovskoy on 12/3/2015.
 */

@ContextConfiguration("classpath:cucumber-context.xml")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public abstract class PageInstance{
    public static WebDriver driver;
    public static CucumberArpReport arpClient;
    public static PageInstance currentPageObject;

    public static boolean checkIfFurtherStepsAreNeeded() {
        try {
            List<Step> passedSteps = arpClient.getReport().CurrentTestCase.Steps.stream().filter(p -> p.Actions != null && p.Actions.size() > 0).collect(Collectors.toList());
            if (passedSteps.stream().anyMatch(p -> !p.Status.equals("pass"))) {
                try {
                    arpClient.ReportAction("Step is blocked by further step fails", false);
                    arpClient.nextStep();
                    return false;
                } catch (Throwable e) {
                }
            }
            return true;
        } catch (Throwable ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public void waitForJStoLoad() throws InterruptedException, TimeoutException {
        // wait for jQuery to load
        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    return ((Long) ((JavascriptExecutor) driver).executeScript("return jQuery.active") == 0);
                } catch (Exception e) {
                    return true;
                }
            }
        };
        // wait for Javascript to load
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState")
                        .toString().equals("complete");
            }
        };
        int counter = 0;
        int multiplier=1;
        while (true) {
            if (jQueryLoad.apply(driver) && jsLoad.apply(driver)) {
                return;
            } else {
                counter++;
                multiplier+=multiplier;
                if (multiplier > 29) {
                    throw new TimeoutException("Javascript is taking too long to finish");
                } else {
                    Thread.sleep(1000*multiplier);
                }
            }
        }
    }
}

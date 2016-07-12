package stepdefinition;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import helpers.SystemHelper;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import pages.base.PageInstance;
import pages.home.OrganisationPage;
import pages.sections.Breadcrumbs;

/**
 * Created by pasichniy on 05-Feb-16.
 */
public class OrganisationPageStepDefinition extends PageInstance {

    @Autowired
    OrganisationPage organisationPage;

    @Autowired
    Breadcrumbs breadcrumbs;

    @Given("^I`m on Organisation Chart page$")
    public void I_m_on_Organisation_Chart_Page() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            waitForJStoLoad();

            breadcrumbs.getLink("Organizations").click();
            Thread.sleep(5000);
            arpClient.ReportAction("I`m on Organisation Chart page", driver.getCurrentUrl().equals(SystemHelper.URL + "#organization") || driver.getCurrentUrl().equals(SystemHelper.URL));
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            arpClient.ReportAction(e.getMessage(), false);
        } finally {
            arpClient.nextStep();
        }
    }

    @And("^I select \"(.+)\" from Select Organistion DropDown$")
    public void selectFromOrganisationDropDown(String value) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            waitForJStoLoad();
            organisationPage.selectFromOrgNameDropDown(value);
            arpClient.ReportAction("Value '" + value + "' was selected in Organistion DropDown", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            arpClient.ReportAction(e.getMessage(), false);
        } finally {
            arpClient.nextStep();
        }
    }

    @And("^I expand \"(.+)\" \"(.+)\" chartitem$")
    public void expandSomeChartitem(String chartitemName, String chartitemType) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            waitForJStoLoad();
            organisationPage.expandChartItem(chartitemName, chartitemType);
            arpClient.ReportAction("Chartitem '" + chartitemName + "' '" + chartitemType + "' was expanded", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            arpClient.ReportAction(e.getMessage(), false);
        } finally {
            arpClient.nextStep();
        }
    }

    @And("^I drag \"(.+)\" \"(.+)\" chartitem to \"(.+)\" \"(.+)\" chartitem$")
    public void drugChartitem(String chartitemName, String chartitemType, String destinationChartItemName, String destinationChartItemType) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            waitForJStoLoad();
            organisationPage.drugChartItemTo(chartitemName, chartitemType, destinationChartItemName, destinationChartItemType);
            Thread.sleep(1000);
            arpClient.ReportAction("Chartitem '" + chartitemName + "' '" + chartitemType + "' was successfully draged to '" + destinationChartItemName + "' '" + destinationChartItemType + "'", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            arpClient.ReportAction(e.getMessage(), false);
        } finally {
            arpClient.nextStep();
        }
    }

    @And("^I see \"(.+)\" \"(.+)\" chartitem (not contains|contains) \"(.+)\" \"(.+)\" chartitem$")
    public void checkChildren(String chartitemName, String chartitemType, String expected, String childChartItemName, String childChartItemType) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            waitForJStoLoad();
            Boolean exp, result;
            exp = expected.equals("contains") ? true : false;
            result = organisationPage.isChildrenOfChartitemEqualsToExpected(chartitemName, chartitemType, childChartItemName, childChartItemType, true);
            if (result.equals(exp)) {
                arpClient.ReportAction("Chartitem '" + chartitemName + "' with type '" + chartitemType + ", "
                        + expected + " children chartitem '" + childChartItemName + "' with type '" + childChartItemType
                        + "'", true);
            } else {
                arpClient.ReportAction("Chartitem '" + chartitemName + "' with type '" + chartitemType + ", "
                        + (expected.equals("contains") ? "not contains" : "contains") + " children chartitem '" + childChartItemName
                        + "' with type '" + childChartItemType + "', as NOT Expected", false);
            }
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            arpClient.ReportAction(e.getMessage(), false);
        } finally {
            arpClient.nextStep();
        }
    }

    @When("^I drag \"([^\"]*)\" chartitem from Structure table to \"([^\"]*)\" \"([^\"]*)\" chartitem$")
    public void iDragChartitemFromStructureTableToChartitem(String component, String targetName, String targetType) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            waitForJStoLoad();
            WebElement source = organisationPage.getStructureItemFromStructureList(component);
            WebElement target = organisationPage.getChartItemByNameAndType(targetName, targetType);
            SystemHelper.drugElementTo(source, target);
            arpClient.ReportAction(component + "chartitem was druged to '" + targetName + "' '" + targetType + "' chartitem", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            arpClient.ReportAction(e.getMessage(), false);
        } finally {
            arpClient.nextStep();
        }
    }

    @And("^I drag \"([^\"]*)\" customer chartitem from Customer table to \"([^\"]*)\" \"([^\"]*)\" chartitem$")
    public void iDragCustomerChartitemFromCustomerTableToChartitem(String customer, String targetName, String targetType) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            waitForJStoLoad();
            WebElement source = organisationPage.getCustomerFromCustomerTable(customer);
            WebElement target = organisationPage.getChartItemByNameAndType(targetName, targetType);
            SystemHelper.drugElementTo(source, target);
            arpClient.ReportAction(customer + "chartitem was druged to '" + targetName + "' '" + targetType + "' chartitem", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            arpClient.ReportAction(e.getMessage(), false);
        } finally {
            arpClient.nextStep();
        }
    }

    @And("^I delete \"([^\"]*)\" \"([^\"]*)\" chartitem$")
    public void iDeleteChartitem(String chartitemName, String chartitemType) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            waitForJStoLoad();
            organisationPage.deleteChartItem(chartitemName, chartitemType);
            arpClient.ReportAction("Delete button for'" + chartitemName + "' '" + chartitemType + "' chart item was clicked", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            arpClient.ReportAction(e.getMessage(), false);
        } finally {
            arpClient.nextStep();
        }
    }

    @And("^I save structure of \"(.+)\" organisation$")
    public void saveOrgStruct(String orgName) throws Exception {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            waitForJStoLoad();
            SystemHelper.tree = organisationPage.saveTreeStructure(orgName);
            arpClient.ReportAction("Structure was saved", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            arpClient.ReportAction(e.getMessage(), false);
        } finally {
            arpClient.nextStep();
        }
    }

    @And("^I restore structure of \"(.+)\" organisation$")
    public void restoreOrgStruct(String orgName) throws Exception {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            waitForJStoLoad();
            organisationPage.restoreTree(organisationPage.saveTreeStructure(orgName));
            arpClient.ReportAction("Structure was restored", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            arpClient.ReportAction(e.getMessage(), false);
        } finally {
            arpClient.nextStep();
        }
    }
}

package stepdefinition;

import com.unitedsofthouse.ucucumberpackage.typesfactory.types.tables.Cell;
import com.unitedsofthouse.ucucumberpackage.typesfactory.types.tables.HeaderBasedTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.SystemHelper;
import arp.CucumberArpReport;
import arp.ReportService;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import pages.base.PageInstance;
import pages.home.HomePage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by beckmambetov on 2/3/2016.
 */
public class HomePageStepDefinition extends PageInstance {

    @Autowired
    HomePage homePage;

    @Given("^I`m on a homepage$")
    public void I_m_on_a_homepage() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            ReportService.ReportAction("I`m on a home page", driver.getCurrentUrl().equals(SystemHelper.URL + "#home") || driver.getCurrentUrl().equals(SystemHelper.URL));
            Thread.sleep(1000);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @When("^I enter in a text field called 'Enter search text' following text \"([^\"]*)\"$")
    public void I_enter_in_a_text_field_called_Enter_search_text_following_text(String arg1) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
//            homePage = new HomePage();
            homePage.textInputSearch.enterText(arg1);
            Thread.sleep(2000);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }


    @Then("^I see value \"([^\"]*)\" in \"([^\"]*)\" column$")
    public void I_see_value_in_column(String arg1, String arg2) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            List<String> tempList = homePage.tableData().listColumn(arg2);
            for (String temp : tempList) {
                if (temp.equals(arg1)) {
                    ReportService.ReportAction("Expected value was found in corresponding column", true);
                    return;
                }
            }
            ReportService.ReportAction("Expected value was not found in corresponding column", false);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @When("^I save values from columns$")
    public void I_save_values_from_columns() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            HeaderBasedTable table = homePage.tableData();
            List<String> headers = table.List_Headers();
            List<List<String>> tableData = new ArrayList<>();
            for (String header : headers) {
                tableData.add(table.listColumn(header));
            }
            homePage.savedTableValues = tableData;
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I press 'Next Page' button$")
    public void I_press_Next_Page_button() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            homePage.pagination.buttonNextPage.click();
            Thread.sleep(1000);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I see value '(\\d+)' in page text field$")
    public void I_see_value_in_page_text_field(int arg1) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            ReportService.ReportAction("Current page value should be " + arg1, homePage.pagination.textInputPageNum.getText().equals(String.valueOf(arg1)));
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^columns values have changed$")
    public void columns_values_have_changed() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            HeaderBasedTable table = homePage.tableData();
            List<String> headers = table.List_Headers();
            List<List<String>> tableData = new ArrayList<>();
            for (String header : headers) {
                tableData.add(table.listColumn(header));
            }
            ReportService.ReportAction("Current table valuse should differ from saved one", !homePage.savedTableValues.equals(tableData));
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I press 'Last Page' button$")
    public void I_press_Last_Page_button() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            Thread.sleep(1000);
            homePage.pagination.buttonLastPage.click();
            Thread.sleep(1000);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I see value 'Last page' in page text field$")
    public void I_see_value_Last_page_in_page_text_field() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            ReportService.ReportAction("Current page value should be equal to the number pof last one", homePage.pagination.textInputPageNum.getText().equals(homePage.pagination.labelTotalPages.getText().replace("of ", "")));
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^button 'Next Page' is not active$")
    public void button_Next_Page_is_not_active() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            ReportService.ReportAction("Button Next Page is not avaliable", homePage.pagination.buttonNextPage.getAttribute("unselectable").equals("on"));
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^button 'Last Page' is not active$")
    public void button_Last_Page_is_not_active() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            ReportService.ReportAction("Button Last Page is not avaliable", homePage.pagination.buttonLastPage.getAttribute("unselectable").equals("on"));
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I press 'Previous Page' button$")
    public void I_press_Previous_Page_button() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            homePage.pagination.buttonBackToPrevious.click();
            Thread.sleep(1000);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I see value Last page \"([^\"]*)\" in page text field$")
    public void I_see_value_Last_page_in_page_text_field(String arg1) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            ReportService.ReportAction("Current page value should be equal to the number pof last one", homePage.pagination.textInputPageNum.getText().equals(String.valueOf(Integer.parseInt(homePage.pagination.labelTotalPages.getText().replace("of ", "")) + Integer.parseInt(arg1))));
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I press 'First Page' button$")
    public void I_press_First_Page_button() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            homePage.pagination.buttonBackToFirst.click();
            Thread.sleep(1000);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^button 'First Page' is not active$")
    public void button_First_Page_is_not_active() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            ReportService.ReportAction("Button First Page is not avaliable", homePage.pagination.buttonBackToFirst.getAttribute("unselectable").equals("on"));
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^button 'Previous Page' is not active$")
    public void button_Previous_Page_is_not_active() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            ReportService.ReportAction("Button Previous Page is not avaliable", homePage.pagination.buttonBackToPrevious.getAttribute("unselectable").equals("on"));
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I enter \"([^\"]*)\" in 'Page' text field and press ENTER$")
    public void I_enter_in_Page_text_field_and_press_ENTER(String arg1) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            homePage.pagination.textInputPageNum.clear();
            homePage.pagination.textInputPageNum.sendKeys(arg1, Keys.ENTER);
            Thread.sleep(1000);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I save number of pages$")
    public void I_save_number_of_pages() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            Thread.sleep(1000);
            homePage.savedNumberOfPages = Integer.parseInt(homePage.pagination.labelTotalPages.getText().replace("of ", ""));
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I select \"([^\"]*)\" from 'Customer Type' dropdown list$")
    public void I_select_from_Customer_Type_dropdown_list(String arg1) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            homePage.getCustomerTypeDropdownElement(arg1).click();
            ReportService.ReportAction("Expected option was chosen", true);
            Thread.sleep(1000);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^number of pages is less than \"([^\"]*)\"$")
    public void number_of_pages_is_less_than(String arg1) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            if (arg1.equals("saved one")) {
                arg1 = (String.valueOf(homePage.savedNumberOfPages));
            }
            ReportService.ReportAction("Total number of pages should be less than " + arg1, Integer.parseInt(homePage.pagination.labelTotalPages.getText().replace("of ", "")) < Integer.parseInt(arg1));
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^filter \"([^\"]*)\" is displayed on page$")
    public void filter_is_displayed_on_page(String arg1) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            ReportService.ReportAction("Expected filter should be displayed on page", homePage.getAppliedFilter(arg1).containerMain.getText().equals(arg1));
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^number of pages is greater than \"([^\"]*)\"$")
    public void number_of_pages_is_greater_than(String arg1) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            if (arg1.equals("saved one")) {
                arg1 = (String.valueOf(homePage.savedNumberOfPages));
            }
            ReportService.ReportAction("Total number of pages should be greater than " + arg1, Integer.parseInt(homePage.pagination.labelTotalPages.getText().replace("of ", "")) > Integer.parseInt(arg1));
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I press 'Clear' link$")
    public void I_press_Clear_link() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            homePage.cancelFilterLink.click();
            Thread.sleep(1000);
            ReportService.ReportAction("Expected filter should be displayed on page", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^number of pages is \"([^\"]*)\"$")
    public void number_of_pages_is(String arg1) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            if (arg1.equals("saved one")) {
                arg1 = (String.valueOf(homePage.savedNumberOfPages));
            }
            ReportService.ReportAction("Total number of pages should be greater than " + arg1, Integer.parseInt(homePage.pagination.labelTotalPages.getText().replace("of ", "")) == Integer.parseInt(arg1));
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^filter \"([^\"]*)\" is not displayed on page$")
    public void filter_is_not_displayed_on_page(String arg1) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            try {
                //waitForJStoLoad();
                ReportService.ReportAction("Expected filter should be displayed on page", homePage.getAppliedFilter(arg1).containerMain.getText() == null);
            } catch (NullPointerException ex) {
                ReportService.ReportAction("Expected filter is not present on page", true);
            }
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I press remove \"([^\"]*)\" filter$")
    public void I_press_remove_filter(String arg1) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            Cell filter = homePage.getAppliedFilter(arg1);
            filter.containerMain.findElement(By.xpath("//div[@class=\"remove-token-icon\"]")).click();
            ReportService.ReportAction("Filter was succesfully cancelled", true);
            Thread.sleep(1000);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^The column \"([^\"]*)\" on position \"([^\"]*)\"$")
    public void theColumnOnPosition(String columnName, int position) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            int currentPos = homePage.tableData().List_Headers().indexOf(columnName);
            if ((position - 1) == currentPos) {
                ReportService.ReportAction("Current position of column '" + columnName + "' is " + (currentPos + 1), true);
            } else {
                ReportService.ReportAction("Current position of column '" + columnName + "' is " + (currentPos + 1) + ", as NOT Expected", false);
            }

        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^The column \"([^\"]*)\" on position \"([^\"]*)\" in membership table$")
    public void theColumnOnPositionInMembershipTable(String columnName, int position) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            int currentPos = homePage.membershipTable().List_Headers().indexOf(columnName);
            if ((position - 1) == currentPos) {
                ReportService.ReportAction("Current position of column '" + columnName + "' is " + (currentPos + 1), true);
            } else {
                ReportService.ReportAction("Current position of column '" + columnName + "' is " + (currentPos + 1) + ", as NOT Expected", false);
            }

        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^The column \"([^\"]*)\" on position \"([^\"]*)\" in contacts table$")
    public void theColumnOnPositionInContactsTable(String columnName, int position) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            int currentPos = homePage.contactsTable().List_Headers().indexOf(columnName);
            if ((position - 1) == currentPos) {
                ReportService.ReportAction("Current position of column '" + columnName + "' is " + (currentPos + 1), true);
            } else {
                ReportService.ReportAction("Current position of column '" + columnName + "' is " + (currentPos + 1) + ", as NOT Expected", false);
            }

        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @When("^I drag column \"([^\"]*)\" to position \"([^\"]*)\"$")
    public void iDragColumnToPosition(String columnName, String position) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            int indexOfElement = homePage.tableData().List_Headers().indexOf(columnName);
            HeaderBasedTable<Cell> table = homePage.tableData();
            WebElement elementToDrug = table.listHeadersCells().get(indexOfElement).takeCustomElements(".").get(0);
            WebElement elementWhereDrug = table.listHeadersCells().get(Integer.parseInt(position)).takeCustomElements(".").get(0);
            SystemHelper.drugElementTo(elementToDrug, elementWhereDrug);
            ReportService.ReportAction("Column '" + columnName + "' was moved to position " + position, true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @When("^I drag column \"([^\"]*)\" to position \"([^\"]*)\" in membership table$")
    public void iDragMembershipColumnToPosition(String columnName, String position) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            int indexOfElement = homePage.membershipTable().List_Headers().indexOf(columnName);
            HeaderBasedTable<Cell> table = homePage.membershipTable();
            WebElement elementToDrug = table.listHeadersCells().get(indexOfElement).takeCustomElements(".").get(0);
            WebElement elementWhereDrug = table.listHeadersCells().get(Integer.parseInt(position) - 1).takeCustomElements(".").get(0);
            SystemHelper.drugElementTo(elementToDrug, elementWhereDrug);
            ReportService.ReportAction("Column '" + columnName + "' was moved to position " + position, true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @When("^I drag column \"([^\"]*)\" to position \"([^\"]*)\" in contacts table$")
    public void iDragContactsColumnToPosition(String columnName, String position) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            int indexOfElement = homePage.contactsTable().List_Headers().indexOf(columnName);
            HeaderBasedTable<Cell> table = homePage.contactsTable();
            WebElement elementToDrug = table.listHeadersCells().get(indexOfElement).takeCustomElements(".").get(0);
            WebElement elementWhereDrug = table.listHeadersCells().get(Integer.parseInt(position) - 1).takeCustomElements(".").get(0);
            SystemHelper.drugElementTo(elementToDrug, elementWhereDrug);
            ReportService.ReportAction("Column '" + columnName + "' was moved to position " + position, true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^Column \"([^\"]*)\" is (present|absent) in customer list table$")
    public void columnIsAbsent(String value, String expected) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            Thread.sleep(2000);
            Boolean exp = expected.equals("absent");
            Boolean result = !homePage.tableData().List_Headers().stream().anyMatch(p -> p.equals(value));
            if (exp.equals(result)) {
                ReportService.ReportAction("Column " + value + " is " + expected + ", as Expected", true);
            } else {
                ReportService.ReportAction("Column " + value + " is Not " + expected, false);
            }

        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^Column \"([^\"]*)\" is (present|absent) in membership list table$")
    public void columnIsAbsentInMembership(String value, String expected) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            Thread.sleep(2000);
            Boolean exp = expected.equals("absent");
            Boolean result = !homePage.membershipTable().List_Headers().stream().anyMatch(p -> p.equals(value));
            if (exp.equals(result)) {
                ReportService.ReportAction("Column " + value + " is " + expected + ", as Expected", true);
            } else {
                ReportService.ReportAction("Column " + value + " is Not " + expected, false);
            }

        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^Column \"([^\"]*)\" is (present|absent) in contacts list table$")
    public void columnIsAbsentInContacts(String value, String expected) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            Thread.sleep(2000);
            Boolean exp = expected.equals("absent");
            Boolean result = !homePage.contactsTable().List_Headers().stream().anyMatch(p -> p.equals(value));
            if (exp.equals(result)) {
                ReportService.ReportAction("Column " + value + " is " + expected + ", as Expected", true);
            } else {
                ReportService.ReportAction("Column " + value + " is Not " + expected, false);
            }

        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @When("^I select \"([^\"]*)\" from Columns dropdown in header \"([^\"]*)\" dropdown in customer details table$")
    public void iSelectFromDropdownInDropdownInCustomerDetails(String sort, String headerName) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            homePage.tableData().selectSortingFromColumnSortDropdown(headerName, sort);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @When("^I select \"([^\"]*)\" from Columns dropdown in header \"([^\"]*)\" dropdown in membership table$")
    public void iSelectFromDropdownInDropdownInMembershipTable(String sort, String headerName) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            homePage.membershipTable().selectSortingFromColumnSortDropdown(headerName, sort);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @When("^I select \"([^\"]*)\" from Columns dropdown in header \"([^\"]*)\" dropdown in contacts table$")
    public void iSelectFromDropdownInDropdownInContactsTable(String sort, String headerName) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            homePage.contactsTable().selectSortingFromColumnSortDropdown(headerName, sort);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I click on table row with \"([^\"]*)\"$")
    public void I_click_on_table_row_with(String arg1) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            Cell cell = null;
            try {
                //waitForJStoLoad();
                cell = homePage.tableData().listColumnCells("Name").get(0);
                arpClient.ReportAction("Row with value '" + arg1 + "' was found", true);
            } catch (Exception e) {
                arpClient.ReportAction("Row with value '" + arg1 + "' was NOT found", false);
                throw e;
            }
            cell.containerMain.click();
            Thread.sleep(1000);
            ReportService.ReportAction("Expected element was clicked on", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {

            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I enter in a text field called 'Name' following text \"([^\"]*)\"$")
    public void I_enter_in_a_text_field_called_Name_following_text(String arg1) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            homePage.textInputNameCD.clear();
            homePage.textInputNameCD.sendKeys(arg1);
            ReportService.ReportAction("Values was entered into text field 'Name'", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I enter in a text field called 'Legal' following text \"([^\"]*)\"$")
    public void I_enter_in_a_text_field_called_Legal_following_text(String arg1) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            homePage.textInputLegalCD.clear();
            homePage.textInputLegalCD.sendKeys(arg1);
            ReportService.ReportAction("Values was entered into text field 'Legal'", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I enter in a text field called 'Short name' following text \"([^\"]*)\"$")
    public void I_enter_in_a_text_field_called_Short_name_following_text(String arg1) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            homePage.textInputShortNameCD.clear();
            homePage.textInputShortNameCD.sendKeys(arg1);
            ReportService.ReportAction("Values was entered into text field 'Short name'", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I enter in a text field called 'Search' following text \"([^\"]*)\"$")
    public void I_enter_in_a_text_field_called_Search_following_text(String arg1) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            homePage.textInputSearchCD.clear();
            homePage.textInputSearchCD.sendKeys(arg1);
            ReportService.ReportAction("Values was entered into text field 'Search'", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I enter in a text field called 'IATA' following text \"([^\"]*)\"$")
    public void I_enter_in_a_text_field_called_IATA_following_text(String arg1) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            homePage.textInputIATACD.clear();
            homePage.textInputIATACD.sendKeys(arg1);
            ReportService.ReportAction("Values was entered into text field 'IATA'", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I enter in a text field called 'CASS' following text \"([^\"]*)\"$")
    public void I_enter_in_a_text_field_called_CASS_following_text(String arg1) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            homePage.textInputCASSCD.clear();
            homePage.textInputCASSCD.sendKeys(arg1);
            ReportService.ReportAction("Values was entered into text field 'CASS'", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I enter in a text field called 'Account No' following text \"([^\"]*)\"$")
    public void I_enter_in_a_text_field_called_Account_No_following_text(String arg1) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            homePage.textInputAccountNoCD.clear();
            homePage.textInputAccountNoCD.sendKeys(arg1);
            ReportService.ReportAction("Values was entered into text field 'Account No'", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I select checkbox \"([^\"]*)\"$")
    public void I_select_checkbox(String arg1) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            if (homePage.getCellfromCheckboxesList(arg1).listButtons.get(0).getWrappedElement().getAttribute("aria-checked").equals("true")) {
                ReportService.ReportAction("Expected checkbox was already checked", true);
            } else {
                homePage.getCheckboxfromCheckboxesList(arg1).click();
            }
            ReportService.ReportAction("Expected checkbox was checked", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^checkbox \"([^\"]*)\" is selected$")
    public void checkbox_is_selected(String arg1) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            ReportService.ReportAction("Expected checkbox is checked", homePage.getCellfromCheckboxesList(arg1).listButtons.get(0).getWrappedElement().getAttribute("aria-checked").equals("true"));
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I unselect checkbox \"([^\"]*)\"$")
    public void I_unselect_checkbox(String arg1) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            if (homePage.getCellfromCheckboxesList(arg1).listButtons.get(0).getWrappedElement().getAttribute("aria-checked").equals("true")) {
                homePage.getCheckboxfromCheckboxesList(arg1).click();
            } else {
                ReportService.ReportAction("Expected checkbox was already unchecked", true);
            }
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^checkbox \"([^\"]*)\" is unselected$")
    public void checkbox_is_unselected(String arg1) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            ReportService.ReportAction("Expected checkbox is unchecked", !homePage.getCheckboxfromCheckboxesList(arg1).isSelected());
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I select \"([^\"]*)\" from 'Organisation' dropdown list$")
    public void I_select_from_Organisation_dropdown_list(String arg1) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            homePage.getOrganisationCDDropdownElement(arg1).click();
            ReportService.ReportAction("Expected element was clicked", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }


    @And("^text field 'Region' is readonly$")
    public void text_field_Region_is_readonly() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            ReportService.ReportAction("Text field Region is readonly", homePage.textInputRegionCD.getAttribute("readonly").equals("true"));
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^text field 'City' is readonly$")
    public void text_field_City_is_readonly() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            ReportService.ReportAction("Text field City is readonly", homePage.textInputCityCD.getAttribute("readonly").equals("true"));
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^text field 'Airport' is readonly$")
    public void text_field_Airport_is_readonly() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            ReportService.ReportAction("Text field Airport is readonly", homePage.textInputAirportCD.getAttribute("readonly").equals("true"));
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^text field 'Country' is readonly$")
    public void text_field_Country_is_readonly() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            ReportService.ReportAction("Text field Country is readonly", homePage.textInputCountryCD.getAttribute("readonly").equals("true"));
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I select \"([^\"]*)\" from 'Currency' dropdown$")
    public void I_select_from_Currency_dropdown(String arg1) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            homePage.getCurrencyCDDropdownElement(arg1).click();
            ReportService.ReportAction("Expected element was clicked", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I select \"([^\"]*)\" from 'Language' dropdown$")
    public void I_select_language_from_Language_dropdown(String arg1) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            homePage.getLanguageCDDropdownElement(arg1).click();
            ReportService.ReportAction("Expected element was clicked", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^CompanyDetail tab opens up$")
    public void CompanyDetail_tab_opens_up() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            ReportService.ReportAction("CompanyDetail elements are visible", homePage.textInputPriorityCD.isDisplayed());
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I see that it's fields contain expected information$")
    public void I_see_that_it_s_fields_contain_expected_information() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            ReportService.ReportAction("Name is present", homePage.textInputNameCD.getText().length() > 0);
            ReportService.ReportAction("Short Name is present", homePage.textInputShortNameCD.getText().length() > 0);
            ReportService.ReportAction("Search is present", homePage.textInputSearchCD.getText().length() > 0);
            List<WebElement> temp = new ArrayList<>();
            temp.add(homePage.getCellfromCheckboxesList("Agent").listButtons.get(0).getWrappedElement());
            temp.add(homePage.getCellfromCheckboxesList("Shipper").listButtons.get(0).getWrappedElement());
            temp.add(homePage.getCellfromCheckboxesList("Consignee").listButtons.get(0).getWrappedElement());
            temp.add(homePage.getCellfromCheckboxesList("Airline").listButtons.get(0).getWrappedElement());
            ReportService.ReportAction("At least one checkbox is checked", temp.stream().anyMatch(p -> {
                try {
                    //waitForJStoLoad();
                    return p.getAttribute("aria-checked").equals("true");
                } catch (Throwable ex) {
                    return false;
                }
            }));

        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I click on accordion \"(.+)\"$")
    public void iClickOnAccordionMembership(String accordionName) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            homePage.clickOnAccordionLink(accordionName);
            Thread.sleep(1000);
            ReportService.ReportAction("I click on accordion " + accordionName, true);

        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I press button 'Add' on accordion 'Memberships'$")
    public void iPressButtonAddOnAccordionMemberships() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            homePage.buttonAddMembership.click();
            Thread.sleep(1000);
            ReportService.ReportAction("I click on  button Add on accordion 'Memberships'", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }


    @And("^I select \"(.+)\" from Type dropdown at 'Memberships' table$")
    public void iSelectBAExecutiveClubFromTypeDropdown(String value) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            homePage.editMemberships("Type", value);
            ReportService.ReportAction("Value '" + value + "' from Type dropdown at 'Memberships' table was selected", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }


    @And("^I enter \"([^\"]*)\" into \"(Number|From|To)\" field at 'Memberships' table$")
    public void iEnterIntoFromDateField(String value, String column) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            homePage.editMemberships(column, value);
            ReportService.ReportAction("Value '" + value + "' was typed in '" + column + "' at 'Memberships' table was selected", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I press button \"(Update|Cancel)\" at 'Memberships' table$")
    public void iPressButtonUpdate(String button) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();

            if (button.equals("Update")) {
                homePage.buttonRowEditorUpdateMembership.click();
            } else {
                homePage.buttonRowEditorCancelMembership.click();
                Thread.sleep(1000);
            }
            ReportService.ReportAction("Button " + button + " at 'Memberships' table was clicked", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I see that field \"(.+)\" in Membership table has value \"([^\"]*)\"$")
    public void iSeeThatTextFieldHasValue(String field, String expectedValue) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            expectedValue = SystemHelper.replaceDate(expectedValue);

            Boolean result = homePage.isFieldInMembershipsTableContainsValue(field, expectedValue);
            if (result) {
                ReportService.ReportAction("I see that field '" + field + "' in Membership table has value " + expectedValue + "'", true);
            } else {
                ReportService.ReportAction("I see that field '" + field + "' in Membership table hasn't value " + expectedValue + "'", false);
            }
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I enter in a text field called 'Website' following text \"([^\"]*)\"$")
    public void I_enter_in_a_text_field_called_Website_following_text_http_some_site_com(String arg1) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            homePage.textInputWebsiteCD.clear();
            homePage.textInputWebsiteCD.enterText(arg1);
            ReportService.ReportAction("Value was entered into Website text field", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I select \"([^\"]*)\" from 'Priority' dropdown$")
    public void I_select_from_Priority_dropdown(String arg1) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            homePage.getPriorityCDDropdownElement(arg1).click();
            ReportService.ReportAction("Expected element was selected from Priority dropdown", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I see in text field 'Priority'  text \"([^\"]*)\"$")
    public void I_see_in_text_field_Priority_text(String arg1) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            if (homePage.labelPriorityCD.getText().equals(arg1)) {
                ReportService.ReportAction("Expected text was found in priority text field", true);
            } else {
                ReportService.ReportAction("Expected text was not found in priority text field", false);
            }
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I see that text field 'Priority' is readonly$")
    public void I_see_that_text_field_Priority_is_readonly() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            ReportService.ReportAction("Text field 'Priority' is expected to be read only", homePage.labelPriorityCD.getAttribute("readonly").equals("true"));
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I click on a text field called 'Name' and clear it$")
    public void I_click_on_a_text_field_called_Name_and_clear_it() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();

            homePage.textInputNameCD.click();
            homePage.textInputNameCD.clear();
            ReportService.ReportAction("Text field called 'Name' was clicked", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I click on a text field called 'Short name' and clear it$")
    public void I_click_on_a_text_field_called_Short_name_and_clear_it() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            homePage.textInputShortNameCD.click();
            homePage.textInputShortNameCD.clear();
            ReportService.ReportAction("Text field called 'Short name' was clicked", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I click on a text field called 'Search' and clear it$")
    public void I_click_on_a_text_field_called_Search_and_clear_it() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            homePage.textInputSearchCD.click();
            homePage.textInputSearchCD.clear();
            ReportService.ReportAction("Text field called 'Search' was clicked", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I click on dropdown 'Currency' on text area and clear it$")
    public void I_click_on_dropdown_Currency_on_text_area_and_clear_it() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            homePage.textInputCurrencyCD.click();
            homePage.textInputCurrencyCD.clear();
            ReportService.ReportAction("Text area of Dropdown called 'Currency' was clicked", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I click on dropdown 'Language' on text area and clear it$")
    public void I_click_on_dropdown_Language_on_text_area_and_clear_it() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            homePage.textInputLanguageCD.click();
            homePage.textInputLanguageCD.clear();
            ReportService.ReportAction("Text area of Dropdown called 'Language' was clicked", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I see that 'Name' text field shows that it's input is wrong$")
    public void I_see_that_Name_text_field_shows_that_it_s_input_is_wrong() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            ReportService.ReportAction("Text field is wrapped in container that shows invalid state of element", homePage.textInputNameCD.getAttribute("aria-invalid").equals("true"));
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I hover mouse over 'Name' text field$")
    public void I_hover_mouse_over_Name_text_field() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            SystemHelper.navigateTo(homePage.textInputNameCD.getWrappedElement());
            Thread.sleep(1000);
            ReportService.ReportAction("Mouse was moved to 'Name' text field", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I see that text \"([^\"]*)\" appear$")
    public void I_see_that_text_appear(String arg1) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            String errorText = homePage.errorTooltip.getWrappedElement().getText();
            Boolean result = errorText.equals(arg1);
            SystemHelper.navigateTo(homePage.placeHolderGridItemContainer.getWrappedElement());
            ReportService.ReportAction("Expected text appeared", result);
            Thread.sleep(1000);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I see that 'Short name' text field shows that it's input is wrong$")
    public void I_see_that_Short_name_text_field_shows_that_it_s_input_is_wrong() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            ReportService.ReportAction("Text field is wrapped in container that shows invalid state of element", homePage.textInputShortNameCD.getAttribute("aria-invalid").equals("true"));
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I hover mouse over 'Short name' text field$")
    public void I_hover_mouse_over_Short_name_text_field() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            SystemHelper.navigateTo(homePage.textInputShortNameCD.getWrappedElement());
            Thread.sleep(1000);
            ReportService.ReportAction("Mouse was moved to 'Name' text field", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I see that 'Search' text field shows that it's input is wrong$")
    public void I_see_that_Search_text_field_shows_that_it_s_input_is_wrong() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            ReportService.ReportAction("Text field is wrapped in container that shows invalid state of element", homePage.textInputSearchCD.getAttribute("aria-invalid").equals("true"));
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I hover mouse over 'Search' text field$")
    public void I_hover_mouse_over_Search_text_field() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            SystemHelper.navigateTo(homePage.textInputSearchCD.getWrappedElement());
            Thread.sleep(1000);
            ReportService.ReportAction("Mouse was moved to 'Name' text field", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I see that check box area shows that it's input is wrong$")
    public void I_see_that_check_box_area_shows_that_it_s_input_is_wrong() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            ReportService.ReportAction("Text field is wrapped in container that shows invalid state of element", homePage.containerForCheckboxes.getAttribute("aria-describedby").contains("ariaErrorEl"));
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I hover mouse over 'Agent' checkbox$")
    public void I_hover_mouse_over_Agent_checkbox() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            SystemHelper.navigateTo(homePage.getCheckboxfromCheckboxesList("Agent"));
            Thread.sleep(1000);
            ReportService.ReportAction("Mouse was moved to 'Agent' checkbox", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I see that 'Currency' dropdown shows that it's input is wrong$")
    public void I_see_that_Currency_dropdown_shows_that_it_s_input_is_wrong() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            ReportService.ReportAction("Text field is wrapped in container that shows invalid state of element", homePage.textInputCurrencyCD.getAttribute("aria-invalid").equals("true"));
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I hover mouse over 'Currency' text field$")
    public void I_hover_mouse_over_Currency_text_field() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            SystemHelper.navigateTo(homePage.textInputCurrencyCD.getWrappedElement());
            Thread.sleep(1000);
            ReportService.ReportAction("Mouse was moved to 'Currency' text field", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I see that 'Language' dropdown shows that it's input is wrong$")
    public void I_see_that_Language_dropdown_shows_that_it_s_input_is_wrong() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            ReportService.ReportAction("Text field is wrapped in container that shows invalid state of element", homePage.textInputLanguageCD.getAttribute("aria-invalid").equals("true"));
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I hover mouse over 'Language' text field$")
    public void I_hover_mouse_over_Language_text_field() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            SystemHelper.navigateTo(homePage.textInputLanguageCD.getWrappedElement());
            Thread.sleep(1000);
            ReportService.ReportAction("Mouse was moved to 'Language' text field", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I see that input field \"(Type|Number)\" has red borders$")
    public void iSeeThatTextFieldTypeHasRedBorders(String field) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            String borderParametr;
            if (field.equals("Type")) {
                borderParametr = homePage.textInputTypeTableMembership.getWrappedElement().findElement(By.xpath(".//ancestor::*[@data-ref='triggerWrap']")).getCssValue("border");
            } else {
                borderParametr = homePage.textInputNumberTableMembership.getWrappedElement().findElement(By.xpath(".//ancestor::*[@data-ref='triggerWrap']")).getCssValue("border");
            }
            int size = Integer.parseInt(borderParametr.substring(0, borderParametr.indexOf("px")));
            String color = borderParametr.substring(borderParametr.indexOf("rgb"), borderParametr.indexOf(")") + 1);
            if (size > 0 && color.equals("rgb(207, 76, 53)")) {
                ReportService.ReportAction("Text field '" + field + "' has red borders and size > 0", true);
            } else {
                ReportService.ReportAction("Text field '" + field + "' has NOT red borders, OR size = 0", false);
            }
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I hover cursor over input field \"(Type|Number)\"$")
    public void iHoverCursorOverDropdownType(String field) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            WebElement toNavigate;
            if (field.equals("Type")) {
                toNavigate = homePage.textInputTypeTableMembership.getWrappedElement();
            } else {
                toNavigate = homePage.textInputNumberTableMembership.getWrappedElement();
            }
            SystemHelper.navigateTo(toNavigate);
            Thread.sleep(500);
            ReportService.ReportAction("Cursor hovered over dropdown 'Type'", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I see that button Update is not active$")
    public void iSeeThatButtonUpdateIsNotActive() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            if (homePage.buttonRowEditorUpdateMembership.isEnabled()) {
                ReportService.ReportAction("Button 'Update' is not active", true);
            } else {
                ReportService.ReportAction("Button 'Update' is active, as NOT Expected", false);
            }
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I see that input field \"(Type|Number)\" is not present$")
    public void iSeeThatInputFieldIsNotPresent(String field) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            Boolean result;
            if (field.equals("Type")) {
                result = homePage.textInputTypeTableMembership.isDisplayed();
            } else {
                result = homePage.textInputNumberTableMembership.isDisplayed();
            }
            if (!result) {
                ReportService.ReportAction("Field " + field + " is not present", true);
            } else {
                ReportService.ReportAction("Field " + field + " is present, as NOT Expected", false);
            }
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I double click Type text field$")
    public void iDoubleClickTypeTextField() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            Actions actions = new Actions(driver);
            HeaderBasedTable<Cell> table = homePage.membershipTable();
            WebElement element = table.takeCell("Type", 0).containerMain.getWrappedElement();
            actions.doubleClick(element).build().perform();
            Thread.sleep(1000);
            ReportService.ReportAction("I double click on 'Type' text field successful", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I click on 'Number' text field$")
    public void iClickOnNumberTextField() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            HeaderBasedTable<Cell> table = homePage.membershipTable();
            table.takeCell("Type", 0).containerMain.getWrappedElement().click();
            ReportService.ReportAction("I click on 'Number' text field successful", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I press button 'Remove'$")
    public void iPressButtonRemove() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            homePage.buttonRemoveMembership.click();
            ReportService.ReportAction("I click on 'Remove' button successful", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I see that no text field \"([^\"]*)\" with value \"([^\"]*)\"$")
    public void iSeeThatNoTextFieldWithValue(String field, String value) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            HeaderBasedTable<Cell> table = homePage.membershipTable();
            int result = table.listColumn(field).stream().filter(p -> p.equals("value")).collect(Collectors.toList()).size();
            if (result == 0) {
                ReportService.ReportAction("I see that no text field '" + field + "' with value '" + value + "'", true);
            } else {
                ReportService.ReportAction("I see text field '" + field + "' with value '" + value + "', as NOT Expected", false);
            }
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I press button 'Add' on accordion 'Addresses'$")
    public void I_press_button_Add_on_accordion_Addresses() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            homePage.buttonAddAddress.click();
            ReportService.ReportAction("Button Add was clicked", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @When("^I press 'Add' button$")
    public void I_press_Add_button() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            homePage.buttonAdd.click();
            ReportService.ReportAction("Button Add was clicked", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I press 'Save' button$")
    public void I_press_Save_button() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            homePage.buttonSaveCustomer.click();
            ReportService.ReportAction("Button Save was clicked", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I see that text field called 'Name' contains following text \"([^\"]*)\"$")
    public void I_see_that_text_field_called_Name_contains_following_text(String arg1) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            ReportService.ReportAction("Expected value is in Name text field", homePage.textInputNameCD.getText().equals(arg1));
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I see that text field called 'Legal' contains following text \"([^\"]*)\"$")
    public void I_see_that_text_field_called_Legal_contains_following_text(String arg1) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            ReportService.ReportAction("Expected value is in Legal text field", homePage.textInputLegalCD.getText().equals(arg1));
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I see that text field called 'Short name' contains following text \"([^\"]*)\"$")
    public void I_see_that_text_field_called_Short_name_contains_following_text(String arg1) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            ReportService.ReportAction("Expected value is in Short Name text field", homePage.textInputShortNameCD.getText().equals(arg1));
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I see that text field called 'Search' contains following text \"([^\"]*)\"$")
    public void I_see_that_text_field_called_Search_contains_following_text(String arg1) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            ReportService.ReportAction("Expected value is in Search text field", homePage.textInputSearchCD.getText().equals(arg1));
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I see that text field called 'IATA' contains following text \"([^\"]*)\"$")
    public void I_see_that_text_field_called_IATA_contains_following_text(String arg1) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            ReportService.ReportAction("Expected value is in IATA text field", homePage.textInputIATACD.getText().equals(arg1));
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I see that text field called 'CASS' contains following text \"([^\"]*)\"$")
    public void I_see_that_text_field_called_CASS_contains_following_text(String arg1) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            ReportService.ReportAction("Expected value is in CASS text field", homePage.textInputCASSCD.getText().equals(arg1));
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I see that text field called 'Account No' contains following text \"([^\"]*)\"$")
    public void I_see_that_text_field_called_Account_No_contains_following_text(String arg1) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            ReportService.ReportAction("Expected value is in Account No text field", homePage.textInputAccountNoCD.getText().equals(arg1));
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I see that dropdown 'Organisation' contains value \"([^\"]*)\"$")
    public void I_see_that_dropdown_Organisation_contains_value(String arg1) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            ReportService.ReportAction("Expected value is in Organisation text field", homePage.getOrganisationCDTextElement().getText().equals(arg1));
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I see that dropdown 'Currency' contains value \"([^\"]*)\"$")
    public void I_see_that_dropdown_Currency_contains_value(String arg1) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            ReportService.ReportAction("Expected value is in Currency text field", homePage.textInputCurrencyCD.getText().equals(arg1));
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I see that dropdown 'Language' contains value \"([^\"]*)\"$")
    public void I_see_that_dropdown_Language_contains_value(String arg1) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            ReportService.ReportAction("Expected value is in Language text field", homePage.textInputLanguageCD.getText().equals(arg1));
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I see that dropdown 'Priority' contains value \"([^\"]*)\"$")
    public void I_see_that_dropdown_Priority_contains_value(String arg1) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            ReportService.ReportAction("Expected value is in Priority text field", homePage.textInputPriorityCD.getText().equals(arg1));
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I see that text field called 'Website' contains following text \"([^\"]*)\"$")
    public void I_see_that_text_field_called_Website_contains_following_text(String arg1) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            ReportService.ReportAction("Expected value is in Website text field", homePage.textInputWebsiteCD.getText().equals(arg1));
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I delete record \"([^\"]*)\"$")
    public void I_delete_record(String arg1) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            homePage.tableData().listRows().stream().filter(p -> p.findElement(By.xpath("./td[1]/div[1]")).getText().equals(arg1)).findFirst().get().findElements(By.xpath("./td[5]/div")).get(0).click();
            ReportService.ReportAction("Deletion of record was initiated", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I see no result \"([^\"]*)\"$")
    public void I_see_no_result(String arg1) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            ReportService.ReportAction("Expected result is missing", homePage.tableData().listRows().stream().filter(p -> p.findElement(By.xpath("./td[1]/div[1]")).getText().equals(arg1)).collect(Collectors.toList()).size() == 0);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I press 'Cancel' button$")
    public void iPressCancelButton() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            homePage.buttonCancelCustomer.click();
            ReportService.ReportAction("I press 'Cancel' button", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I select \"([^\"]*)\" from Type dropdown in \"([^\"]*)\" Address form$")
    public void I_select_from_Type_dropdown_in_first_Address_form(String arg1, String arg2) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            homePage.getAddressBlock(arg2).getTypeDropdownElement(arg1).click();
            ReportService.ReportAction("Expected result was chosen from dropdown", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I enter \"([^\"]*)\" into 'Address Line 1' text field in \"([^\"]*)\" Address form$")
    public void I_enter_into_Address_Line_one_text_field_in_first_Address_form(String arg1, String arg2) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            homePage.getAddressBlock(arg2).textInputAddressLineOne.clear();
            homePage.getAddressBlock(arg2).textInputAddressLineOne.sendKeys(arg1);
            ReportService.ReportAction("Text was entered in a text input field", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I enter \"([^\"]*)\" into 'Address Line 2' text field in \"([^\"]*)\" Address form$")
    public void I_enter_into_Address_Line_two_text_field_in_first_Address_form(String arg1, String arg2) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            homePage.getAddressBlock(arg2).textInputAddressLineTwo.clear();
            homePage.getAddressBlock(arg2).textInputAddressLineTwo.sendKeys(arg1);
            ReportService.ReportAction("Text was entered in a text input field", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I select \"([^\"]*)\" in 'State / County' dropdown in \"([^\"]*)\" Address form$")
    public void I_select_in_State_Country_dropdown_in_first_Address_form(String arg1, String arg2) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            homePage.getAddressBlock(arg2).getStateDropdownElement(arg1).click();
            ReportService.ReportAction("Expected result was chosen from dropdown", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I select \"([^\"]*)\" in 'Country' dropdown in \"([^\"]*)\" Address form$")
    public void I_select_in_Country_dropdown_in_first_Address_form(String arg1, String arg2) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            homePage.getAddressBlock(arg2).getCountryDropdownElement(arg1).click();
            ReportService.ReportAction("Expected result was chosen from dropdown", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I select \"([^\"]*)\" in 'City' dropdown in \"([^\"]*)\" Address form$")
    public void I_select_in_City_dropdown_in_first_Address_form(String arg1, String arg2) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            homePage.getAddressBlock(arg2).getCityDropdownElement(arg1).click();
            ReportService.ReportAction("Expected result was chosen from dropdown", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I enter \"([^\"]*)\" into 'Zip / Postcode' text field in \"([^\"]*)\" Address form$")
    public void I_enter_into_Zip_Postcode_text_field_in_first_Address_form(String arg1, String arg2) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            homePage.getAddressBlock(arg2).textInputPostcode.sendKeys(arg1);
            ReportService.ReportAction("Text was entered in a text input field", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I see value \"([^\"]*)\" in Type dropdown in \"([^\"]*)\" Address form$")
    public void I_see_value_in_Type_dropdown_in_Address_form(String arg1, String arg2) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            ReportService.ReportAction("Expected text is in text field", homePage.getAddressBlock(arg2).textInputTypeDropdown.equals(arg1));
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I see value \"([^\"]*)\" in 'Address Line 1' text field in \"([^\"]*)\" Address form$")
    public void I_see_value_in_Address_Line_one_text_field_in_Address_form(String arg1, String arg2) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            ReportService.ReportAction("Expected text is in text field", homePage.getAddressBlock(arg2).textInputAddressLineOne.equals(arg1));
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I see value \"([^\"]*)\" in 'Address Line 2' text field in \"([^\"]*)\" Address form$")
    public void I_see_value_in_Address_Line_two_text_field_in_Address_form(String arg1, String arg2) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            ReportService.ReportAction("Expected text is in text field", homePage.getAddressBlock(arg2).textInputAddressLineTwo.equals(arg1));
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I see value \"([^\"]*)\" in 'Country' dropdown in \"([^\"]*)\" Address form$")
    public void I_see_value_in_Country_dropdown_in_Address_form(String arg1, String arg2) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            ReportService.ReportAction("Expected text is in text field", homePage.getAddressBlock(arg2).textInputCountryDropdown.equals(arg1));
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I see value \"([^\"]*)\" in 'City' dropdown in \"([^\"]*)\" Address form$")
    public void I_see_value_in_City_dropdown_in_Address_form(String arg1, String arg2) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            ReportService.ReportAction("Expected text is in text field", homePage.getAddressBlock(arg2).textInputCityDropdown.equals(arg1));
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I see value \"([^\"]*)\" in 'State / County' dropdown in \"([^\"]*)\" Address form$")
    public void I_see_value_in_State_County_dropdown_in_Address_form(String arg1, String arg2) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            ReportService.ReportAction("Expected text is in text field", homePage.getAddressBlock(arg2).textInputStateDropdown.equals(arg1));
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I see value \"([^\"]*)\" in 'Zip / Postcode' text field in \"([^\"]*)\" Address form$")
    public void I_see_value_in_Zip_Postcode_text_field_in_Address_form(String arg1, String arg2) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            ReportService.ReportAction("Expected text is in text field", homePage.getAddressBlock(arg2).textInputPostcode.equals(arg1));
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I click on button Add in 'Addresses' accordion$")
    public void I_click_on_button_Add_in_Addresses_accordion() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            homePage.buttonAddAddress.click();
            ReportService.ReportAction("Button Add was clicked", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I delete \"([^\"]*)\" address$")
    public void I_delete_address(String arg1) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            homePage.getAddressBlock(arg1).triggerDelete.click();
            ReportService.ReportAction("Button delete was clicked", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I see (\\d+) address avaliable$")
    public void I_see_address_avaliable(int arg1) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            ReportService.ReportAction("Expected number of addresses was returned", homePage.getAddressBlocksNumber() == arg1);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I click on Type dropdown in \"([^\"]*)\" Address form  and clear it$")
    public void I_click_on_Type_dropdown_in_Address_form_and_clear_it(String arg1) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            homePage.getAddressBlock(arg1).textInputTypeDropdown.clear();
            homePage.getAddressBlock(arg1).textInputTypeDropdown.click();
            ReportService.ReportAction("Field was cleared and clicked on", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I click on 'Address Line 1' text field in \"([^\"]*)\" Address form and clear it$")
    public void I_click_on_Address_Line_one_text_field_in_Address_form_and_clear_it(String arg1) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            homePage.getAddressBlock(arg1).textInputAddressLineOne.clear();
            homePage.getAddressBlock(arg1).textInputAddressLineOne.click();
            ReportService.ReportAction("Field was cleared and clicked on", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I click on 'Address Line 2' text field in \"([^\"]*)\" Address form and clear it$")
    public void I_click_on_Address_Line_two_text_field_in_Address_form_and_clear_it(String arg1) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            homePage.getAddressBlock(arg1).textInputAddressLineTwo.clear();
            homePage.getAddressBlock(arg1).textInputAddressLineTwo.click();
            ReportService.ReportAction("Field was cleared and clicked on", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I click on 'Country' dropdown in \"([^\"]*)\" Address form and clear it$")
    public void I_click_on_Country_dropdown_in_Address_form_and_clear_it(String arg1) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            homePage.getAddressBlock(arg1).textInputCountryDropdown.clear();
            homePage.getAddressBlock(arg1).textInputCountryDropdown.click();
            ReportService.ReportAction("Field was cleared and clicked on", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I click on 'City' dropdown in \"([^\"]*)\" Address form and clear it$")
    public void I_click_on_City_dropdown_in_Address_form_and_clear_it(String arg1) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            homePage.getAddressBlock(arg1).textInputCityDropdown.clear();
            homePage.getAddressBlock(arg1).textInputCityDropdown.click();
            Thread.sleep(1000);
            ReportService.ReportAction("Field was cleared and clicked on", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I see that Type dropdown in \"([^\"]*)\" Address form shows that it's input is wrong$")
    public void I_see_that_Type_dropdown_in_Address_form_shows_that_it_s_input_is_wrong(String arg1) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            ReportService.ReportAction("Text field is wrapped in container that shows invalid state of element", homePage.getAddressBlock(arg1).textInputTypeDropdown.getAttribute("aria-invalid").equals("true"));
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I see that 'Address Line 1' text field in \"([^\"]*)\" Address form  shows that it's input is wrong$")
    public void I_see_that_Address_Line_text_field_in_Address_form_shows_that_it_s_input_is_wrong(String arg1) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            ReportService.ReportAction("Text field is wrapped in container that shows invalid state of element", homePage.getAddressBlock(arg1).textInputAddressLineOne.getAttribute("aria-invalid").equals("true"));
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I see that Country dropdown in \"([^\"]*)\" Address form shows that it's input is wrong$")
    public void I_see_that_Country_dropdown_in_Address_form_shows_that_it_s_input_is_wrong(String arg1) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            ReportService.ReportAction("Text field is wrapped in container that shows invalid state of element", homePage.getAddressBlock(arg1).textInputCountryDropdown.getAttribute("aria-invalid").equals("true"));
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I see that City dropdown in \"([^\"]*)\" Address form shows that it's input is wrong$")
    public void I_see_that_City_dropdown_in_Address_form_shows_that_it_s_input_is_wrong(String arg1) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            ReportService.ReportAction("Text field is wrapped in container that shows invalid state of element", homePage.getAddressBlock(arg1).textInputCityDropdown.getAttribute("aria-invalid").equals("true"));
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I hover mouse over Type dropdown in \"([^\"]*)\" Address form$")
    public void I_hover_mouse_over_Type_dropdown_in_Address_form(String arg1) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            SystemHelper.navigateTo(homePage.getAddressBlock(arg1).textInputTypeDropdown);
            ReportService.ReportAction("Mouse was moved to element", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I hover mouse over 'Address Line 1' text field in \"([^\"]*)\" Address form$")
    public void I_hover_mouse_over_Address_Line_text_field_in_Address_form(String arg1) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            SystemHelper.navigateTo(homePage.getAddressBlock(arg1).textInputAddressLineOne);
            ReportService.ReportAction("Mouse was moved to element", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I hover mouse over Country dropdown in \"([^\"]*)\" Address form$")
    public void I_hover_mouse_over_Country_dropdown_in_Address_form(String arg1) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            SystemHelper.navigateTo(homePage.getAddressBlock(arg1).textInputAddressLineOne);
            ReportService.ReportAction("Mouse was moved to element", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I hover mouse over City dropdown in \"([^\"]*)\" Address form$")
    public void I_hover_mouse_over_City_dropdown_in_Address_form(String arg1) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            SystemHelper.navigateTo(homePage.getAddressBlock(arg1).textInputCityDropdown);
            ReportService.ReportAction("Mouse was moved to element", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I see that button Add is not clickable$")
    public void I_see_that_button_Add_is_not_clickable() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //waitForJStoLoad();
            homePage.buttonAddAddress.getAttribute("unselectable").equals("on");
            ReportService.ReportAction("Mouse was moved to element", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction(e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }



    /*@And("^I select \"([^\"]*)\" from Type dropdown in created Address form$")
    public void I_select_from_Type_dropdown_in_created_Address_form(String arg1) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try { //waitForJStoLoad();
            homePage.textInputCustomerType.click();
            arpClient.ReportAction("Button Add was clicked", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            arpClient.ReportAction(e.getMessage(), false);
        } finally {
            arpClient.nextStep();
        }
    }*/
}



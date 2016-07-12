package pages.home;

import com.unitedsofthouse.ucucumberpackage.typesfactory.annotations.Container;
import com.unitedsofthouse.ucucumberpackage.typesfactory.annotations.FindIn;
import com.unitedsofthouse.ucucumberpackage.typesfactory.factory.TypeFactory;
import com.unitedsofthouse.ucucumberpackage.typesfactory.types.*;
import com.unitedsofthouse.ucucumberpackage.typesfactory.types.tables.Cell;
import com.unitedsofthouse.ucucumberpackage.typesfactory.types.tables.RowBasedTable;
import helpers.AddressBlock;
import helpers.HeaderDropdownBasedTable;
import helpers.SystemHelper;
import arp.ReportService;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import pages.base.BasePage;
import pages.sections.Pagination;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by beckmambetov on 2/3/2016.
 */
public class HomePage extends BasePage {

    public void init() {
        TypeFactory.containerInitHTMLElements(this);
    }

    public HomePage() {
        TypeFactory.containerInitHTMLElements(this);
    }

    @Lazy
    public List savedTableValues;

    @Lazy
    public int savedNumberOfPages;

    @Autowired
    public Pagination pagination;

    @Lazy
    @Container(name = "CustomersListHeaderToolbar")
    @FindBy(xpath = ".//div[contains(@id,'customersListHeaderToolbar') and @role='toolbar']")
    private HTMLContainer containerCustomersListHeaderToolbar;

    @Lazy
    @FindIn(value = ".//input[contains(@placeholder, 'search')]", containerName = "CustomersListHeaderToolbar")
    public TextInput textInputSearch;

    @Lazy
    @FindIn(value = ".//input[contains(@id ,'combobox')]", containerName = "CustomersListHeaderToolbar")
    public PlaceHolder textInputCustomerType;

    @Lazy
    @FindIn(value = ".//*[contains(@id, 'trigger-picker')]", containerName = "CustomersListHeaderToolbar")
    public Button buttonCustomerType;

    @Lazy
    @FindBy(xpath = "//div[@id='ext-form-error-tip' and @aria-hidden='false']//li")
    public Label errorTooltip;

//    @Lazy
//    @FindBy(xpath = ".//*[contains(@id,'customersListHeaderToolbar')]//input[contains(@placeholder, 'search')]")
//    public TextInput textInputSearch;

    @Lazy
    @FindIn(value = ".//*[contains(@id, 'trigger-search')]", containerName = "CustomersListHeaderToolbar")
    public Button buttonSearch;

    @Lazy
    @FindIn(value = ".//*[contains(@id, 'trigger-clear')]", containerName = "CustomersListHeaderToolbar")
    public Button buttonClearSearch;

    @Lazy
    @FindBy(xpath = ".//*[contains(@id, 'customerslist') and @role='grid']")
    public PlaceHolder placeHolderCustomerList;

    @Lazy
    @FindBy(xpath = ".//div[contains(@class, 'x-grid-item-container')]")
    public PlaceHolder placeHolderGridItemContainer;

    @Lazy
    @FindBy(xpath = ".//*[contains(@id,'customersListBottomToolbar')]//*[contains(text(), 'Add')]")
    public Button buttonAdd;

    @Lazy
    @Container(name = "containerCompanyDetails")
    @FindBy(xpath = ".//*[contains(@id,'companydetails')]")
    private HTMLContainer containerCompanyDetails;

    @Lazy
    @FindIn(value = ".//*[contains(text(), 'Name')]/parent::*/following-sibling::*//input", containerName = "containerCompanyDetails")
    public TextInput textInputNameCD;

    @Lazy
    @FindIn(value = ".//*[contains(text(), 'Legal')]/parent::*/following-sibling::*//input", containerName = "containerCompanyDetails")
    public TextInput textInputLegalCD;

    @Lazy
    @FindIn(value = ".//*[contains(text(), 'Short name')]/parent::*/following-sibling::*//input", containerName = "containerCompanyDetails")
    public TextInput textInputShortNameCD;

    @Lazy
    @FindIn(value = ".//*[contains(text(), 'Search')]/parent::*/following-sibling::*//input", containerName = "containerCompanyDetails")
    public TextInput textInputSearchCD;

    @Lazy
    @FindIn(value = ".//*[contains(text(), 'IATA')]/parent::*/following-sibling::*//input", containerName = "containerCompanyDetails")
    public TextInput textInputIATACD;

    @Lazy
    @FindIn(value = ".//*[contains(text(), 'CASS')]/parent::*/following-sibling::*//input", containerName = "containerCompanyDetails")
    public TextInput textInputCASSCD;

    @Lazy
    @FindIn(value = ".//*[contains(text(), 'Account No')]/parent::*/following-sibling::*//input", containerName = "containerCompanyDetails")
    public TextInput textInputAccountNoCD;

    @Lazy
    @FindBy(xpath = ".//div[contains(@id,'companydetails')]//*[contains(@id,'checkboxgroup')]//div[contains(@id,'checkbox') or contains(@id,'shipper')]/span")
    public List<PlaceHolder> listPlaceHoldersCheckboxesCD;

    @Lazy
    @FindBy(xpath = ".//div[contains(@id,'checkboxgroup')]")
    public PlaceHolder containerForCheckboxes;

    @Lazy
    @FindBy(xpath = ".//*[contains(@id,'organizationSelection') and (contains(@data-ref,'body'))]")
    public PlaceHolder placeholderOrganisationCD;

    @Lazy
    @FindIn(value = ".//*[contains(text(), 'Currency')]/parent::*/following-sibling::*//input", containerName = "containerCompanyDetails")
    public TextInput textInputCurrencyCD;

    @Lazy
    @FindIn(value = ".//*[contains(text(), 'Currency')]/parent::*/following-sibling::*//*[contains(@id, 'trigger-picker')]", containerName = "containerCompanyDetails")
    public Button buttonCurrencyCD;

    @Lazy
    @FindIn(value = ".//*[contains(text(), 'Language')]/parent::*/following-sibling::*//input", containerName = "containerCompanyDetails")
    public TextInput textInputLanguageCD;

    @Lazy
    @FindIn(value = ".//*[contains(text(), 'Region')]/parent::*/following-sibling::*//input", containerName = "containerCompanyDetails")
    public TextInput textInputRegionCD;

    @Lazy
    @FindIn(value = ".//*[contains(text(), 'City')]/parent::*/following-sibling::*//input", containerName = "containerCompanyDetails")
    public TextInput textInputCityCD;

    @Lazy
    @FindIn(value = ".//*[contains(text(), 'Airport')]/parent::*/following-sibling::*//input", containerName = "containerCompanyDetails")
    public TextInput textInputAirportCD;

    @Lazy
    @FindIn(value = ".//*[contains(text(), 'Country')]/parent::*/following-sibling::*//input", containerName = "containerCompanyDetails")
    public TextInput textInputCountryCD;

    @Lazy
    @FindIn(value = ".//*[contains(text(), 'Language')]/parent::*/following-sibling::*//*[contains(@id, 'trigger-picker')]", containerName = "containerCompanyDetails")
    public Button buttonLanguageCD;

    @Lazy
    @FindIn(value = ".//*[contains(text(), 'Website')]/parent::*/following-sibling::*//input", containerName = "containerCompanyDetails")
    public TextInput textInputWebsiteCD;

    @Lazy
    @FindIn(value = ".//*[contains(text(), 'Priority')]/parent::*/following-sibling::*//input", containerName = "containerCompanyDetails")
    public TextInput textInputPriorityCD;

    @Lazy
    @FindIn(value = ".//*[contains(text(), 'Priority')]/parent::*/following-sibling::*//*[contains(@id, 'trigger-picker')]", containerName = "containerCompanyDetails")
    public Button buttonPriorityCD;

    @Lazy
    @FindBy(xpath = "//div[contains(@class,'x-form-item-no-label')]/div[contains(@id,'textfield') and contains(@data-ref,'bodyEl')]//input[contains(@aria-readonly,'true')]")
    public TextInput labelPriorityCD;

    @Lazy
    @FindBy(xpath = ".//*[contains(@id,'toolbar') and (contains(@class, 'docked-bottom'))]//*[contains(text(), 'Add')]")
    public Button buttonAddMembership;

    @Lazy
    @FindBy(xpath = "//div[contains(@id,'addresses')]//a//span[text()='Add' and contains(@id,'btnInnerEl')]")
    public Button buttonAddAddress;

    @Lazy
    @FindBy(xpath = ".//*[contains(@id,'toolbar') and (contains(@class, 'docked-bottom'))]//*[contains(text(), 'Remove')]")
    public Button buttonRemoveMembership;

    @Lazy
    @FindBy(xpath = ".//*[contains(@id,'customerdetails')]/following-sibling::*[contains(@id, 'toolbar')]//*[(contains(text(), 'Save'))]")
    public Button buttonSaveCustomer;

    @Lazy
    @FindBy(xpath = ".//*[contains(@id,'customerdetails')]/following-sibling::*[contains(@id, 'toolbar')]//*[(contains(text(), 'Cancel'))]")
    public Button buttonCancelCustomer;

    @Lazy
    @FindBy(xpath = ".//*[contains(@id,'memberShipsGrid') and (@role='grid')]")
    public PlaceHolder containerMemberShip;

    @Lazy
    @FindBy(xpath = ".//*[contains(@id,'contactsGrid') and (@role='grid')]")
    public PlaceHolder containerContacts;

    @Lazy
    @FindBy(xpath = ".//*[contains(@id,'memberShipsGrid') and (@role='grid')]//*[@name='membershipType']")
    public TextInput textInputTypeTableMembership;
    @Lazy
    @FindBy(xpath = ".//*[contains(@id,'memberShipsGrid') and (@role='grid')]//div[contains(@id,'combobox')]//div[contains(@class,'arrow')]")
    public TextInput triggerTypeTableMembership;
    @Lazy
    @FindBy(xpath = ".//*[contains(@id,'memberShipsGrid') and (@role='grid')]//*[@name='number']")
    public TextInput textInputNumberTableMembership;
    @Lazy
    @FindBy(xpath = ".//*[contains(@id,'memberShipsGrid') and (@role='grid')]//*[@name='validFromDate']")
    public TextInput textInputFromTableMembership;
    @Lazy
    @FindBy(xpath = ".//*[contains(@id,'memberShipsGrid') and (@role='grid')]//*[@name='validToDate']")
    public TextInput textInputToTableMembership;

    @FindBy(xpath = ".//*[contains(@class,'tokens-container')]//div[@class='token']")
    private List<PlaceHolder> listOfAppliedFilters;

    @Lazy
    @FindBy(xpath = ".//*[contains(@id,'link')]//span[text()='Clear']")
    public Link cancelFilterLink;

    @Lazy
    @FindBy(xpath = ".//*[contains(@id,'roweditorbuttons')]/a[contains(., 'Update')]")
    public Button buttonRowEditorUpdateMembership;

    @Lazy
    @FindBy(xpath = ".//*[contains(@id,'roweditorbuttons')]/a[contains(., 'Cancel')]")
    public Button buttonRowEditorCancelMembership;

    @FindBy(xpath = ".//*[contains(@class, 'accordion-item')]")
    public List<WebElement> listButtonsAccordion;

    @Lazy
    @FindBy (xpath = ".//*[contains(@id,'boundlist') and contains(@id, 'listEl')]/*")
    public List<WebElement> listDropdownOptionsTypeMembership;

    @Lazy
    @FindBy (xpath = ".//span[contains(text(),'Add Contact')]")
    public WebElement buttonAddContact;

    @Lazy
    @FindBy (xpath = ".//input[@placeholder='Title']")
    public WebElement textInputTitle;

    @Lazy
    @FindBy (xpath = ".//div/input[@placeholder='Title']/../following-sibling::div")
    public WebElement triggerInputTitle;

    @Lazy
    @FindBy (xpath = ".//input[@placeholder='Firstname']")
    public WebElement textInputFirstName;

    @Lazy
    @FindBy (xpath = ".//input[@placeholder='Middle']")
    public WebElement textInputMiddleName;

    @Lazy
    @FindBy (xpath = ".//input[@placeholder='Surname']")
    public WebElement textInputSurname;

    @Lazy
    @FindBy (xpath = ".//span[text()='Department:']/../following-sibling::div//input")
    public WebElement textInputDepartment;

    @Lazy
    @FindBy (xpath = ".//table//span[text()='Language:']/../following-sibling::div//input")
    public WebElement textInputLanguageContacts;

    @Lazy
    @FindBy (xpath = ".//table//span[text()='Language:']/../following-sibling::div//input/../following-sibling::div")
    public WebElement triggerInputLanguageContacts;

    @Lazy
    @FindBy (xpath = ".//table//a//span[contains(text(),'Add')]")
    public WebElement buttonAddInContact;

    public Cell getAppliedFilter(String name) throws Exception {
        WebElement container = null;
        for (PlaceHolder x : listOfAppliedFilters) {
            if (x.getText().equals(name)) {
                container = x.getWrappedElement();
                break;
            }
        }
        return new Cell(container);
    }

    @Lazy
    @FindBy (xpath = "")
    public HTMLContainer tableContacts;

    public HeaderDropdownBasedTable<Cell> contactsInnerTable() throws Exception {
        HeaderDropdownBasedTable<Cell> table = new HeaderDropdownBasedTable<>(Cell.class, containerMemberShip);
        table.setCellLocator(By.xpath(".//td"));
        table.setRowLocator(By.xpath(".//table"));
        table.setHeadersNameLocator(By.xpath(".//div[@role = 'columnheader']"));
        return table;
    }

    public HeaderDropdownBasedTable<Cell> membershipTable() throws Exception {
        HeaderDropdownBasedTable<Cell> table = new HeaderDropdownBasedTable<>(Cell.class, containerMemberShip);
        table.setCellLocator(By.xpath(".//td"));
        table.setRowLocator(By.xpath(".//table"));
        table.setHeadersNameLocator(By.xpath(".//div[@role = 'columnheader']"));
        return table;
    }

    public HeaderDropdownBasedTable<Cell> contactsTable() throws Exception {
        HeaderDropdownBasedTable<Cell> table = new HeaderDropdownBasedTable<>(Cell.class, containerContacts);
        table.setCellLocator(By.xpath(".//td"));
        table.setRowLocator(By.xpath(".//table"));
        table.setHeadersNameLocator(By.xpath(".//div[@role = 'columnheader']"));
        return table;
    }

    public RowBasedTable<Cell> organisationTable() throws Exception {
        RowBasedTable<Cell> table = new RowBasedTable<>(Cell.class, placeholderOrganisationCD);
        table.setRowsLocator(By.xpath(".//div[contains(@class,'x-field x-form-item')]"));
        table.setColumnsNameLocator(By.xpath(".//span"));
        table.setCellLocator(By.xpath("./div"));
        return table;
    }

    public HeaderDropdownBasedTable<Cell> tableData() throws Exception {
        HeaderDropdownBasedTable<Cell> table = new HeaderDropdownBasedTable<>(Cell.class, placeHolderCustomerList);
        table.setCellLocator(By.xpath(".//td/div"));
        table.setRowLocator(By.xpath(".//tbody/tr"));
//        table.setHeadersNameLocator(By.xpath(".//*[contains(@id, 'gridcolumn') and @data-ref='titleEl']"));
        table.setHeadersNameLocator(By.xpath(".//*[@aria-hidden='false']/*[@data-ref='titleEl']"));
        return table;
    }

    public WebElement getCheckboxfromCheckboxesList(String name) {
        List<PlaceHolder> container = listPlaceHoldersCheckboxesCD.stream().filter(p -> {
            try {
                return p.getAttribute("textContent").contains(name);
            } catch (Exception e) {
                return false;
            }
        }).collect(Collectors.toList());
        return container.get(0).getWrappedElement();
    }

    public Cell getCellfromCheckboxesList(String name) {
        WebElement container = listPlaceHoldersCheckboxesCD.stream().filter(p -> {
            try {
                return p.getAttribute("textContent").contains(name);
            } catch (Exception e) {
                return false;
            }
        }).findFirst().get().getWrappedElement();
        return new Cell(container);
    }


    public WebElement getCustomerTypeDropdownElement(String name) throws Exception {
        textInputCustomerType.click();
        Thread.sleep(1000);
        return driver.findElement(By.xpath(".//ul/li[text()='" + name + "']"));

    }

    public WebElement getOrganisationCDDropdownElement(String name) throws Exception {
        Cell x = organisationTable().takeCell("Organization:", 0);
        x.containerMain.getWrappedElement().findElement(By.xpath(".//div[contains(@id,'trigger-picker')]")).click();
        Thread.sleep(1000);
        return driver.findElement(By.xpath(".//ul/li[text()='" + name + "']"));

    }

    public WebElement getOrganisationCDTextElement() throws Exception {
        Cell x = organisationTable().takeCell("Organization:", 0);
        return x.containerMain.getWrappedElement().findElement(By.xpath(".//input"));

    }

    public WebElement getCurrencyCDDropdownElement(String name) throws Exception {
        buttonCurrencyCD.click();
        Thread.sleep(1000);
        return driver.findElement(By.xpath(".//ul/li[text()='" + name + "']"));

    }

    public WebElement getLanguageCDDropdownElement(String name) throws Exception {
        buttonLanguageCD.click();
        Thread.sleep(1000);
        return driver.findElement(By.xpath(".//ul/li[text()='" + name + "']"));

    }

    public WebElement getPriorityCDDropdownElement(String name) throws Exception {
        this.buttonPriorityCD.click();
        Thread.sleep(1000);
        return driver.findElement(By.xpath(".//ul/li[text()='" + name + "']"));

    }

    public WebElement getTitleDropdownElement(String name) throws Exception {
        this.triggerInputTitle.click();
        Thread.sleep(1000);
        return driver.findElement(By.xpath(".//ul/li[text()='" + name + "']"));

    }

    public WebElement getContactsLanguageDropdownElement(String name) throws Exception {
        this.triggerInputLanguageContacts.click();
        Thread.sleep(1000);
        return driver.findElement(By.xpath(".//ul/li[text()='" + name + "']"));

    }

    @Override
    protected WebElement elementForLoading() throws Exception {
        return placeHolderGridItemContainer.getWrappedElement();
    }

    public void clickOnAccordionLink(String name) throws Exception {
        try {
            WebElement _activeAccordion =
                    listButtonsAccordion.stream().filter(p -> {
                        try {
                            return p.getAttribute("textContent").contains(name);
                        } catch (Exception e) {
                            return false;
                        }
                    }).findFirst().get();
            _activeAccordion.click();
            ReportService.ReportAction("Accordion item with name '" + name + "' was selected", true);
        } catch (Exception e) {
            ReportService.ReportAction("Accordion item with name '" + name + "' NOT selected", false);
            throw e;
        }
    }

    public void editMemberships(String columnName, String value) throws Exception {
        try {
            value = SystemHelper.replaceDate(value);
            switch (columnName) {
                case "Type": {
                    triggerTypeTableMembership.click();
                    Thread.sleep(1000);
                    for (WebElement element : listDropdownOptionsTypeMembership){
                        if (element.getText().toLowerCase().equals(value.toLowerCase())){
                            element.click();
                            break;
                        }
                    }
                   // driver.findElement(By.xpath(".//ul/li[contains(text(),'" + value + "')]")).click();
                    break;
                }
                case "Number": {
                    textInputNumberTableMembership.enterText(value);
                    break;
                }
                case "From": {
                    if (textInputFromTableMembership.getText().equals(value)) {
                        ReportService.ReportAction("Text in field 'From' contains '" + value + "'", true);
                    }
                    textInputFromTableMembership.clear();
                    textInputFromTableMembership.enterText(value);
                    break;
                }
                case "To": {
                    if (textInputToTableMembership.getText().equals("31/12/9999")) {
                        ReportService.ReportAction("Field 'To' contains value '31/12/9999'", true);
                    }
                    textInputToTableMembership.clear();
                    textInputToTableMembership.enterText(value);
                    Thread.sleep(1000);
                    break;
                }
            }
            ReportService.ReportAction("Value '" + value + "' was typed in field '" + columnName + "'", true);
        } catch (Exception e) {
            ReportService.ReportAction("Value '" + value + "' was NOT typed in field '" + columnName + "', reason: " + e.getMessage(), false);
            throw e;
        }
    }

    public Boolean isFieldInMembershipsTableContainsValue(String field, String expectedValue) throws Exception {
        expectedValue = SystemHelper.replaceDate(expectedValue);
        String text = membershipTable().takeCell(field, 0).text();
        return text.equals(expectedValue);
    }

    public AddressBlock getAddressBlock(String arg2) throws Exception {
        int index = 0;
        switch (arg2) {
            case "first": {
                index = 0;
                break;
            }
            case "second": {
                index = 1;
                break;
            }
            case "third": {
                index = 2;
                break;
            }
            default: {
                break;
            }

        }
        return new AddressBlock(driver.findElement(By.xpath(".//div[contains(@id,'addresses')]//div[contains(@class,'address-box')][" + (index + 1) + "]")));
    }

    public int getAddressBlocksNumber() {
        return driver.findElements(By.xpath(".//div[contains(@id,'addresses')]//div[contains(@class,'address-box')]")).size();
    }
}





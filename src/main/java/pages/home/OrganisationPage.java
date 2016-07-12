package pages.home;

import com.unitedsofthouse.ucucumberpackage.tools.Waiters;
import com.unitedsofthouse.ucucumberpackage.typesfactory.types.*;
import helpers.SystemHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import organisationtree.ChartItem;
import organisationtree.ChartItemParent;
import pages.base.BasePage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by pasichniy on 05-Feb-16.
 */
@Component
public class OrganisationPage extends BasePage {
    @Override
    protected WebElement elementForLoading() throws Exception {
        return null;
    }

    @Lazy
    @FindBy(xpath = ".//*[contains(text(), 'Select Organization:')]/parent::*/following-sibling::*//input")
    public DropDown dropDownSelectOrganisation;

    @Lazy
    @FindBy(xpath = ".//*[contains(@id, 'ext-organization-charttree')]")
    public PlaceHolder placeHolderOrganizationChartTree;

    @Lazy
    @FindBy(xpath = ".//*[contains (@id,'organization-customers')]/*")
    public List<WebElement> listWebElementsCustomerItems;

    @Lazy
    @FindBy(xpath = ".//*[@role = 'listbox']/li")
    public List<Link> listLinksOrganisationDropDown;

    @Lazy
    @FindBy(xpath = ".//*[@role='status'][2]")
    public WebElement loadIndicator;

    @Lazy
    @FindBy(xpath = ".//ul[contains (@id, 'organization-structure')]/*")
    public List<WebElement> listWebElementsStructureItems;


    public void expandChartItem(String chartitemName, String chartitemType) throws Exception {
        WebElement element;
        try {
            element = getChartItemByNameAndType(chartitemName, chartitemType);
            arpClient.ReportAction("Chartitem '" + chartitemName + "' with type '" + chartitemType + "' was found", true);
        } catch (Exception e) {
            arpClient.ReportAction("Chartitem '" + chartitemName + "' with type '" + chartitemType + "' was NOT found", false);
            throw e;
        }

        try {
            getExpanderForChartItem(element).click();
            arpClient.ReportAction("Expander for chartitem " + chartitemName + " was found and num of childrens > 0", true);
        } catch (Exception e) {
            arpClient.ReportAction("Expander for chartitem " + chartitemName + " was NOT found OR num of childrens = 0", false);
            throw e;
        }
    }

    public WebElement getChartItemByNameAndType(String chartitemName, String chartitemType) throws Exception {
        WebElement element;
        String itemType;
        switch (chartitemType) {
            case "Organisation":
                itemType = "organization";
                break;
            case "Customer":
                itemType = "customer";
                break;
            default:
                itemType = chartitemType.toLowerCase();
                break;
        }
        try {
            element = placeHolderOrganizationChartTree.findElement(By.xpath(String.format(".//*[contains(@title, '%1$s')]/ancestor::div[contains(@class, 'item-%2$s')]", chartitemName, itemType)));
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    private WebElement getExpanderForChartItem(WebElement chartItem) throws Exception {
        WebElement expander = null;
        PlaceHolder holder = new PlaceHolder(chartItem);
        try {
            expander = holder.findElement(By.xpath(".//*[contains(@class, 'item-expander') and (text() !='0')]"));
        } catch (Exception e) {
            throw e;
        }
        return expander;
    }


    public void drugChartItemTo(String chartitemName, String chartitemType, String destinationChartItemName, String destinationChartItemType) throws Exception {
        WebElement chartItem;
        WebElement destinationChartItem;
        try {
            chartItem = getChartItemByNameAndType(chartitemName, chartitemType);
            arpClient.ReportAction("Target chartitem '" + chartitemName + "' with type '" + chartitemType + "' was found", true);
        } catch (Exception e) {
            arpClient.ReportAction("Target chartitem '" + chartitemName + "' with type '" + chartitemType + "' was NOT found", false);
            throw e;
        }
        try {
            destinationChartItem = getChartItemByNameAndType(destinationChartItemName, destinationChartItemType);
            arpClient.ReportAction("Chartitem for destination '" + destinationChartItemName + "' with type '" + destinationChartItemType + "' was found", true);
        } catch (Exception e) {
            arpClient.ReportAction("Chartitem for destination '" + destinationChartItemName + "' with type '" + destinationChartItemType + "' was NOT found", false);
            throw e;
        }
        SystemHelper.drugElementTo(chartItem, destinationChartItem);
        arpClient.ReportAction("Try to move Chartitem '" + chartitemName + "' with type '" + chartitemType + "' to " +
                "Chartitem '" + destinationChartItemName + "' with type '" + destinationChartItemType + "'", true);
    }

    public void selectFromOrgNameDropDown(String option) throws Exception {
        dropDownSelectOrganisation.click();
        Thread.sleep(1000);
        try {
            listLinksOrganisationDropDown.stream().filter(p -> {
                try {
                    return p.getText().equals(option);
                } catch (Exception e) {
                    return false;
                }
            }).findFirst().get().click();
            Waiters.waitDisappearsOf(10, loadIndicator, 2);
            arpClient.ReportAction("Option '" + option + "' from Organisation Name DropDown was selected", true);
        } catch (Exception e) {
            arpClient.ReportAction("Option '" + option + "' from Organisation Name DropDown was NOT selected", false);
            throw e;
        }
    }

    private List<WebElement> getChartItemChildrens(String chartitemName, String chartitemType) throws Exception {
        List<WebElement> toRreturn;
        WebElement chartItem = getChartItemByNameAndType(chartitemName, chartitemType);
        toRreturn = getChartItemChildrens(chartItem);
        return toRreturn;
    }

    public List<WebElement> getChartItemChildrens(WebElement chartItem) throws Exception {
        PlaceHolder holder = new PlaceHolder(chartItem);
        return holder.findElements(By.xpath("./parent::*/following-sibling::*/li/div/*"));
    }

    public Boolean isChildrenOfChartitemEqualsToExpected(String chartitemName, String chartitemType, String childChartItemName, String childChartItemType, boolean expected) throws Exception {
        WebElement chartItem = null;
        Boolean result;
        try {
            chartItem = getChartItemByNameAndType(childChartItemName, childChartItemType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String chartText = chartItem.getText();
        String chartType = chartItem.getAttribute("class");
        chartType = chartType.substring(chartType.lastIndexOf("-")).replaceAll("-", "");
        final String finalChartType = chartType;
        result = getChartItemChildrens(chartitemName, chartitemType).stream().anyMatch(p -> p.getText().contains(chartText) && p.getAttribute("class").contains(finalChartType));
        return result;
    }

    public WebElement getStructureItemFromStructureList(String item) {
        WebElement el = listWebElementsStructureItems.stream().filter(p -> p.getText().equals(item)).findFirst().get();
        return el;
    }

    public WebElement getCustomerFromCustomerTable(String customer) {
        WebElement el = listWebElementsCustomerItems.stream().filter(p -> p.getText().equals(customer)).findFirst().get();
        return el;
    }

    public void deleteChartItem(String chartitemName, String chartitemType) throws Exception {
        WebElement element;
        try {
            element = getChartItemByNameAndType(chartitemName, chartitemType);
            arpClient.ReportAction("Chartitem '" + chartitemName + "' with type '" + chartitemType + "' was found", true);
        } catch (Exception e) {
            arpClient.ReportAction("Chartitem '" + chartitemName + "' with type '" + chartitemType + "' was NOT found", false);
            throw e;
        }

        try {
            getDeleteButtonForChartItem(element).click();
            arpClient.ReportAction("Delete button for chartitem " + chartitemName + " was found", true);
        } catch (Exception e) {
            arpClient.ReportAction("Delete button for chartitem " + chartitemName + " was NOT found", false);
            throw e;
        }
    }

    private WebElement getDeleteButtonForChartItem(WebElement chartItem) throws Exception {
        WebElement deleteButton = null;
        PlaceHolder holder = new PlaceHolder(chartItem);
        try {
            deleteButton = holder.findElement(By.xpath(".//*[contains(@class, 'item-remove')"));
        } catch (Exception e) {
            throw e;
        }
        return deleteButton;
    }

    public String getChartItemName(WebElement chartitem) {
        return chartitem.getAttribute("textContent");
    }

    public String getChartItemType(WebElement chartitem) {
        String chartType = chartitem.getAttribute("class");
        return chartType.substring(chartType.lastIndexOf("-")).replaceAll("-", "");
    }

    public Map<ChartItem, organisationtree.ChartItemParent> saveTreeStructure(String organisationName) throws Exception {
        Map<ChartItem, organisationtree.ChartItemParent> tree = new HashMap<>();
        tree.put(new ChartItem(organisationName, "Organisation", this, tree), new ChartItemParent("", ""));
        return tree;
    }


    public void restoreTree(Map<ChartItem, ChartItemParent> map) throws Exception {
        if (SystemHelper.tree.size() == 0) {
            arpClient.ReportAction("Previous state of tree not saved", false);
            return;
        }
        if (SystemHelper.tree.size() > map.size()) {
            arpClient.ReportAction("Some chart item was deleted. Couldn't restore", false);
            return;
        }

        map.forEach((chartNew, parentNew) -> SystemHelper.tree.forEach((chartOld, parentOld) -> {
            if (chartNew.type.equals(chartOld.type) && chartNew.name.equals(chartOld.name)) {
                if (!parentNew.type.equals(parentOld.type) || !parentNew.name.equals(parentOld.name)) {
                    try {
                        arpClient.ReportAction("Chart item with name '" + chartNew.name + "' and type '" + chartNew.type
                                + "' changed it position", true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    try {
                        SystemHelper.drugElementTo(
                                getChartItemByNameAndType(chartNew.name, chartNew.type)
                                , getChartItemByNameAndType(parentOld.name, parentOld.type));
                        arpClient.ReportAction("Chart item with name '" + chartNew.name + "' and type '" + chartNew.type
                                + "' moved to original position", true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }));
    }
}

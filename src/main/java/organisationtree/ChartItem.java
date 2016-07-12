package organisationtree;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.home.OrganisationPage;

import java.util.List;
import java.util.Map;

/**
 * Created by pasichniy on 16-Feb-16.
 */
public class ChartItem {
    public String name;
    public String type;
    Map<ChartItem, ChartItemParent> tree;

    public ChartItem(String name, String type, OrganisationPage organisationPage, Map<ChartItem, ChartItemParent> tree) throws Exception {
        this.name = name;
        this.type = type;
        this.tree = tree;
        WebElement element = organisationPage.getChartItemByNameAndType(name, type);
        List<WebElement> list = organisationPage.getChartItemChildrens(element);
        ChartItemParent parent = new ChartItemParent(this.name, this.type);
        if (list.size() != 0) {
            for (WebElement elementTmp : list) {
                String childType = organisationPage.getChartItemType(elementTmp);
                String childName = elementTmp.findElement(By.xpath(".//*[@title]")).getAttribute("title");
                tree.put(new ChartItem(childName, childType, organisationPage, tree), parent);
            }
        }
    }
}

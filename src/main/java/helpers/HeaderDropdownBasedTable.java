package helpers;

import com.unitedsofthouse.ucucumberpackage.typesfactory.types.Element;
import com.unitedsofthouse.ucucumberpackage.typesfactory.types.tables.Cell;
import com.unitedsofthouse.ucucumberpackage.typesfactory.types.tables.HeaderBasedTable;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.List;

/**
 * Created by bilokon_tanya on 2/5/2016.
 */
public class HeaderDropdownBasedTable<T extends Cell> extends HeaderBasedTable<T> {
    public HeaderDropdownBasedTable(Class<T> clazz, Element table) throws Exception {
        super(clazz, table);
    }

    public WebElement getFirstSortingDropdown(String columnName) throws Exception {
        int indexColumn = this.List_Headers().indexOf(columnName);
        WebElement element = listHeadersCells().get(indexColumn).containerMain.getWrappedElement();
        SystemHelper.navigateTo(element);
        element.findElement(By.xpath(".//*[contains(@id, 'triggerEl')]")).click();

        return container.findElement(By.xpath("//div[contains(@id, 'menu') and contains(., 'Sort') and @aria-hidden='false']"));
    }

    public void selectDirectionSortType(String columnName, String sort) throws Exception {
        WebElement container = getFirstSortingDropdown(columnName);
        container.findElements(By.xpath(".//div[contains(@id, 'menuitem') and not(@role='presentation')]")).stream().filter(p->p.getText().contains(sort)).findFirst().get().click();
        Thread.sleep(1000);
    }

    public void selectSortingFromColumnSortDropdown(String columnName, String sort) throws Exception {
        selectDirectionSortType(columnName, "Columns");
        container.findElements(By.xpath("//div[contains(@id, 'menucheckitem') and not(@data-ref='checkEl')]")).stream().filter(p->p.getText().equals(sort)).findFirst().get().click();
        Thread.sleep(1000);
    }


}


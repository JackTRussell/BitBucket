package helpers;

import com.unitedsofthouse.ucucumberpackage.typesfactory.annotations.Container;
import com.unitedsofthouse.ucucumberpackage.typesfactory.annotations.FindIn;
import com.unitedsofthouse.ucucumberpackage.typesfactory.types.HTMLContainer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.context.annotation.Lazy;
import pages.base.PageInstance;

/**
 * Created by beckmambetov on 2/12/2016.
 */
public class AddressBlock {

    @Lazy
    @Container(name = "containerAddress")
    public HTMLContainer container;

    @Lazy
    @FindIn(value = ".//div[contains(@class,'tool-close')]", containerName = "containerAddress")
    public WebElement triggerDelete;
    @Lazy
    @FindIn(value = ".//label[contains(.,'Type')]/following-sibling::div/div/div[contains(@id,'trigger')]", containerName = "containerAddress")
    public WebElement triggerTypeDropdown;
    @Lazy
    @FindIn(value = ".//label[contains(.,'Type')]/following-sibling::div//input", containerName = "containerAddress")
    public WebElement textInputTypeDropdown;
    @Lazy
    @FindIn(value = ".//input[contains(@placeholder,'Address Line 1')]", containerName = "containerAddress")
    public WebElement textInputAddressLineOne;
    @Lazy
    @FindIn(value = ".//input[contains(@placeholder,'Address Line 2')]", containerName = "containerAddress")
    public WebElement textInputAddressLineTwo;
    @Lazy
    @FindIn(value = ".//inpult[contains(@placeholder,'City')]/../following-sibling::div", containerName = "containerAddress")
    public WebElement triggerCityDropdown;
    @Lazy
    @FindIn(value = ".//input[contains(@placeholder,'City')]", containerName = "containerAddress")
    public WebElement textInputCityDropdown;
    @Lazy
    @FindIn(value = ".//input[contains(@placeholder,'Country')]/../following-sibling::div", containerName = "containerAddress")
    public WebElement triggerCountryDropdown;
    @Lazy
    @FindIn(value = ".//input[contains(@placeholder,'Country')]", containerName = "containerAddress")
    public WebElement textInputCountryDropdown;
    @Lazy
    @FindIn(value = ".//input[contains(@placeholder,'State')]/../following-sibling::div", containerName = "containerAddress")
    public WebElement triggerStateDropdown;
    @Lazy
    @FindIn(value = ".//input[contains(@placeholder,'State')]", containerName = "containerAddress")
    public WebElement textInputStateDropdown;
    @Lazy
    @FindIn(value = ".//input[contains(@placeholder,'Postcode')]", containerName = "containerAddress")
    public WebElement textInputPostcode;

    public AddressBlock(WebElement element) throws Exception {
        container = new HTMLContainer(element);
        triggerDelete = container.findElement(By.xpath(".//div[contains(@class,'tool-close')]"));
        triggerTypeDropdown = container.findElement(By.xpath(".//label[contains(.,'Type')]/following-sibling::div/div/div[contains(@id,'trigger')]"));
        textInputTypeDropdown = container.findElement(By.xpath(".//label[contains(.,'Type')]/following-sibling::div//input"));
        textInputAddressLineOne = container.findElement(By.xpath(".//input[contains(@placeholder,'Address Line 1')]"));
        textInputAddressLineTwo = container.findElement(By.xpath(".//input[contains(@placeholder,'Address Line 2')]"));
        triggerCityDropdown = container.findElement(By.xpath(".//input[contains(@placeholder,'City')]/../following-sibling::div"));
        textInputCityDropdown = container.findElement(By.xpath(".//input[contains(@placeholder,'City')]"));
        triggerCountryDropdown = container.findElement(By.xpath(".//input[contains(@placeholder,'Country')]/../following-sibling::div"));
        textInputCountryDropdown = container.findElement(By.xpath(".//input[contains(@placeholder,'Country')]"));
        triggerStateDropdown = container.findElement(By.xpath(".//input[contains(@placeholder,'State')]/../following-sibling::div"));
        textInputStateDropdown = container.findElement(By.xpath(".//input[contains(@placeholder,'State')]"));
        textInputPostcode = container.findElement(By.xpath(".//input[contains(@placeholder,'Postcode')]"));
    }

    public WebElement getTypeDropdownElement(String value) throws InterruptedException {
        triggerTypeDropdown.click();
        Thread.sleep(1000);
        return PageInstance.driver.findElement(By.xpath(".//ul/li[text()='" + value + "']"));
    }

    public WebElement getStateDropdownElement(String value) throws InterruptedException {
        textInputStateDropdown.sendKeys(value);
        Thread.sleep(1000);
        return PageInstance.driver.findElement(By.xpath(".//ul/li[text()='" + value + "']"));
    }

    public WebElement getCountryDropdownElement(String value) throws InterruptedException {
        textInputCountryDropdown.sendKeys(value);
        Thread.sleep(1000);
        return PageInstance.driver.findElement(By.xpath(".//ul/li[text()='" + value + "']"));
    }

    public WebElement getCityDropdownElement(String value) throws InterruptedException {
        textInputCityDropdown.sendKeys(value);
        Thread.sleep(1000);
        return PageInstance.driver.findElement(By.xpath(".//ul/li[text()='" + value + "']"));
    }
}

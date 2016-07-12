package pages.sections;

import com.unitedsofthouse.ucucumberpackage.typesfactory.annotations.Container;
import com.unitedsofthouse.ucucumberpackage.typesfactory.annotations.FindIn;
import com.unitedsofthouse.ucucumberpackage.typesfactory.types.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import pages.base.BasePage;

/**
 * Created by pasichniy on 11-Feb-16.
 */
@Component
public class Dialogs extends BasePage{

    @Override
    protected WebElement elementForLoading() throws Exception {
        return null;
    }

    @Lazy
    @Container(name = "containerConfirmationPopUp")
    @FindBy(xpath = ".//*[contains(@id,'confirmationWindow') and contains(@class,'x-window-default')]")
    public HTMLContainer placeHolderConfirmationPopUp;

    @Lazy
    @FindIn (value=  ".//a[contains(., 'OK')]" , containerName = "containerConfirmationPopUp")
    public Button buttonOkConfirmationPopUp;

    @Lazy
    @FindIn (value = ".//a[contains(., 'Cancel')]", containerName = "containerConfirmationPopUp")
    public Button buttonCancelConfirmationPopUp;

    @Lazy
    @Container(name = "containerNewItemPopUp")
    @FindBy(xpath = ".//*[contains(@id,'ext-comp') and contains(@class,'x-panel-default')]")
    public HTMLContainer placeHolderAddNewItemPopUp;

    @Lazy
    @FindIn(value = ".//a[contains(.,'OK')]", containerName = "containerNewItemPopUp")
    public Button buttonOKNewItemPopup;

    @Lazy
    @FindIn(value = ".//a[contains(.,'Cancel')]", containerName = "containerNewItemPopUp")
    public Link linkCancelNewItemPopup;

    @Lazy
    @FindIn(value = ".//input", containerName = "containerNewItemPopUp")
    public TextInput textInputEnterNameNewItemPopup;

    @Lazy
    @FindBy (xpath = ".//*[contains(@class,'boundlist') and @data-ref='listWrap']//ul[@aria-hidden='false']")
    public Link linkElementFromDropdownEnterNamePopUp;

    @Lazy
    @Container(name = "containerErrorNotification")
    @FindBy (xpath = ".//*[contains(@id, 'toast')]")
    public HTMLContainer containerErrorNotification;

    @Lazy
    @FindIn (value = ".//*[@data-qtip='Close panel']", containerName = "containerErrorNotification")
    public Button buttonCloseErrorNotification;
}

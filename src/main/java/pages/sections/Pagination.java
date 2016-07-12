package pages.sections;


import com.unitedsofthouse.ucucumberpackage.typesfactory.types.Button;
import com.unitedsofthouse.ucucumberpackage.typesfactory.types.Label;
import com.unitedsofthouse.ucucumberpackage.typesfactory.types.Link;
import com.unitedsofthouse.ucucumberpackage.typesfactory.types.TextInput;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import pages.base.BasePage;

/**
 * Created by pasichniy on 04-Feb-16.
 */

@Component
public class Pagination extends BasePage {

    @Override
    protected WebElement elementForLoading() throws Exception {
        return labelTotalPages.getWrappedElement();
    }

    @Lazy
    @FindBy(xpath = ".//*[contains(@data-qtip, 'First Page')]")
    public Button buttonBackToFirst;

    @Lazy
    @FindBy(xpath = ".//*[contains(@data-qtip, 'Previous Page')]")
    public Button buttonBackToPrevious;

    @Lazy
    @FindBy(xpath = ".//*[contains(@id, 'pagingtoolbar')]//input[contains(@id, 'numberfield')]")
    public TextInput textInputPageNum;

    @Lazy
    @FindBy(xpath = ".//*[contains(@id,'tbtext') and (contains(text(), 'of'))]")
    public Label labelTotalPages;

    @Lazy
    @FindBy(xpath = ".//*[contains(@data-qtip, 'Next Page')]")
    public Button buttonNextPage;

    @Lazy
    @FindBy(xpath = ".//*[contains(@data-qtip, 'Last Page')]")
    public Button buttonLastPage;

    @Lazy
    @FindBy(xpath = ".//*[contains(@data-qtip, 'Refresh')]")
    public Button buttonRefreshTable;
}

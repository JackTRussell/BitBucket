package pages.sections;

import com.unitedsofthouse.ucucumberpackage.typesfactory.types.Link;
import com.unitedsofthouse.ucucumberpackage.typesfactory.types.PlaceHolder;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import pages.base.BasePage;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by pasichniy on 04-Feb-16.
 */
@Component
public class Breadcrumbs extends BasePage {
    @Override
    protected WebElement elementForLoading() throws Exception {
        return null;
    }

    @FindBy(xpath = ".//*[contains(text(),'Home')]/parent::*[contains(@id, 'toolbar')]/child::a")
    private List<Link> listLinks;

    public Link getLink(String text) throws Exception {
        Link link = null;
        try {
            link = listLinks.stream().filter(p -> {
                try {
                    return p.getText().equals(text);
                } catch (Exception e) {
                    return false;
                }
            }).findFirst().get();
            arpClient.ReportAction("Link '" + text + "' was found", true);
        } catch (Exception e) {
            arpClient.ReportAction("Link '" + text + "' was NOT found", false);
            throw e;
        }
        return link;
    }
}

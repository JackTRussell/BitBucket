package pages.base;

import com.unitedsofthouse.ucucumberpackage.typesfactory.factory.TypeFactory;
import org.openqa.selenium.WebElement;

/**
 * Created by logovskoy on 12/3/2015.
 */
public abstract class BasePage extends PageInstance {
    protected int timeOut = 60;

    public BasePage() {
        TypeFactory.containerInitHTMLElements(this);

        //PageFactory.initElements(driver, this);
        //try {
        //    WaitFor.waitAppearanceOf(timeOut, elementForLoading());
       //} catch (Exception e) {
        //    e.printStackTrace();
        //}
    }
    /**
     * @Return Element is waiting for to define page is loaded.
     */
    protected abstract WebElement elementForLoading() throws Exception;

    /**
     * @Return Page class name.
     */
    public String toString(){
        return this.getClass().getSimpleName();
    }
}
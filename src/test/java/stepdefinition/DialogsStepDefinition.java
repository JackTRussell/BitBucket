package stepdefinition;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;
import pages.base.PageInstance;
import pages.sections.Dialogs;

/**
 * Created by pasichniy on 11-Feb-16.
 */
public class DialogsStepDefinition extends PageInstance {

    @Autowired
    Dialogs dialogs;

    @And("^I press button \"(OK|Cancel)\" on Confirmation dialog")
    public void iPressButtonOk(String button) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            waitForJStoLoad();
            if (button.equals("OK")) {
                dialogs.buttonOkConfirmationPopUp.click();
            } else {
                dialogs.buttonCancelConfirmationPopUp.click();
            }
            if (dialogs.placeHolderConfirmationPopUp.isDisplayed()) {
                arpClient.ReportAction("Button '" + button + "' was NOT clicked", false);
            } else {
                arpClient.ReportAction("Button '\"+button+\"' was clicked", true);
            }
            arpClient.ReportAction("I click on 'Remove' button successful", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            arpClient.ReportAction(e.getMessage(), false);
        } finally {
            arpClient.nextStep();
        }
    }

    @And("^I press \"(OK|Cancel)\" button on 'New Item' dialog")
    public void iPressButtonOnPopup(String button) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            waitForJStoLoad();
            if (button.equals("OK")) {
                dialogs.buttonOKNewItemPopup.click();
            } else {
                dialogs.linkCancelNewItemPopup.click();
            }
            if (dialogs.placeHolderAddNewItemPopUp.isDisplayed()) {
                arpClient.ReportAction("Button '" + button + "' was NOT clicked", false);
            } else {
                arpClient.ReportAction("Button '\"+button+\"' was clicked", true);
            }
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            arpClient.ReportAction(e.getMessage(), false);
        } finally {
            arpClient.nextStep();
        }
    }

    @And("^I type \"([^\"]*)\" in 'Enter name' field on 'New Item' dialog")
    public void iTypeInEnterNameFieldOnPopup(String text) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            waitForJStoLoad();
            dialogs.textInputEnterNameNewItemPopup.enterText(text);
            Thread.sleep(1500);
            dialogs.linkElementFromDropdownEnterNamePopUp.click();
            if (dialogs.textInputEnterNameNewItemPopup.getText().equals(text)) {
                arpClient.ReportAction("Text '" + text + "' was entered", true);
            } else {
                arpClient.ReportAction("Text '" + text + "' was NOT entered", false);
            }
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            arpClient.ReportAction(e.getMessage(), false);
        } finally {
            arpClient.nextStep();
        }
    }

    @Then("^I see message \"([^\"]*)\" in 'Error Notification' container$")
    public void iSeeMessageInErrorNotificationContainer(String message) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            waitForJStoLoad();
            String text = dialogs.containerErrorNotification.getText();
            if (text.contains(message)) {
                arpClient.ReportAction("'Error Notification' message contains text'" + message + "'", true);
            } else {
                arpClient.ReportAction("'Error Notification' message contains text'" + text + "' instead '" + message + "", false);
            }

        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            arpClient.ReportAction(e.getMessage(), false);
        } finally {
            arpClient.nextStep();
        }
    }

    @And("^I close 'Notification' container$")
    public void iCloseNotificationContainer() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            waitForJStoLoad();
            dialogs.buttonCloseErrorNotification.click();
            if (!dialogs.containerErrorNotification.isDisplayed()) {
                arpClient.ReportAction("I close 'Notification' container", true);
            } else {
                arpClient.ReportAction("'Notification' container steel displayed", false);
            }
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            arpClient.ReportAction(e.getMessage(), false);
        } finally {
            arpClient.nextStep();
        }
    }
}

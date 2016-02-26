package ro.payu.secure;

import com.sdl.selenium.utils.config.WebDriverConfig;
import cucumber.api.java.en.Then;
import org.fasttrackit.util.TestBase;
import ro.btrl.Secure3DPassword;

public class PayUSteps extends TestBase {
    private CardView cardView = new CardView();
    private Secure3DPassword secure3DPassword = new Secure3DPassword();

    @Then("^I enter my PayU card details \"([^\"]*)\"/\"([^\"]*)\" that expires on \"([^\"]*)\"/\"([^\"]*)\" and owned by \"([^\"]*)\"$")
    public void enterCardDetails(String number, String cvv, String month, String year, String owner) throws Throwable {
        cardView.setValues(number, cvv, month, year, owner);
    }

    @Then("^I type \"([^\"]*)\" into PayU password$")
    public void I_type_into_PayU_password(String password) throws Throwable {
        cardView.switchToPopup();
        secure3DPassword.setPassword(password);
    }

    @Then("^I finalize payment on PayU site$")
    public void I_finalize_payment_on_PayU_site() throws Throwable {
        secure3DPassword.clickContinue();

        WebDriverConfig.getDriver().switchTo().defaultContent();
        // TODO see what driver I get after switchTo defaultContent
    }

    @Then("^I get a success notification from PayU$")
    public void iGetASuccessNotificationFromPayU() throws Throwable {
        cardView.successfullyPaid();
        // TODO close last tab
    }
}

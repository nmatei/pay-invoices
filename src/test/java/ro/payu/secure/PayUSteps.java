package ro.payu.secure;

import com.sdl.selenium.utils.config.WebDriverConfig;
import cucumber.api.java.en.Then;
import org.fasttrackit.util.BankCardDetails;
import org.fasttrackit.util.TestBase;
import ro.btrl.Secure3DPassword;

public class PayUSteps extends TestBase {
    private CardView cardView = new CardView();
    private Secure3DPassword secure3DPassword = new Secure3DPassword();

    @Then("^I enter my PayU card details \"([^\"]*)\"/\"([^\"]*)\" that expires on \"([^\"]*)\"/\"([^\"]*)\" and owned by \"([^\"]*)\"$")
    public void enterCardDetails(String number, String cvv, String month, String year, String owner) {
        cardView.setValues(number, cvv, month, year, owner);
    }

    @Then("^I enter my PayU card details$")
    public void enterCardDetails() {
        BankCardDetails card = new BankCardDetails();
        cardView.setValues(card);
    }

    @Then("^I type \"([^\"]*)\" into PayU password$")
    public void enterPassword(String password) {
        cardView.switchToPopup();
        secure3DPassword.setPassword(password);
    }

    @Then("^I enter PayU password$")
    public void enterPassword() throws Throwable {
        cardView.switchToPopup();
        BankCardDetails card = new BankCardDetails();
        secure3DPassword.setPassword(card.getPassword());
    }

    @Then("^I finalize payment on PayU site$")
    public void I_finalize_payment_on_PayU_site() {
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

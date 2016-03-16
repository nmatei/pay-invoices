package ro.secure11gw;

import com.sdl.selenium.utils.config.WebDriverConfig;
import cucumber.api.java.en.Then;
import org.fasttrackit.util.BankCardDetails;
import org.fasttrackit.util.TestBase;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SecureGwSteps extends TestBase {

    private CardView cardView = new CardView();

    @Then("^I enter my SecureGW card details \"([^\"]*)\"/\"([^\"]*)\" that expires on \"([^\"]*)\"/\"([^\"]*)\" and owned by \"([^\"]*)\"$")
    public void enterCardDetails(String number, String cvv, String month, String year, String owner) {
        cardView.setValues(number, cvv, month, year, owner);
    }

    @Then("^I enter my SecureGW card details$")
    public void enterCardDetails() {
        BankCardDetails card = new BankCardDetails();
        cardView.setValues(card);
    }

    @Then("^I proceed to SecureGW payment$")
    public void iProceedToSecureGWPayment() {
        cardView.pay();

        WebDriverWait wait = new WebDriverWait(WebDriverConfig.getDriver(), 5);
        wait.until(ExpectedConditions.alertIsPresent());
        WebDriverConfig.getDriver().switchTo().alert().accept();
    }

    @Then("^I get a success notification from SecureGW$")
    public void iGetASuccessNotificationFromPayU() {
        cardView.successfullyPaid();
        // TODO close last tab
    }
}

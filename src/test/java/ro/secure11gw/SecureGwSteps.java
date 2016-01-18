package ro.secure11gw;

import com.sdl.selenium.utils.config.WebDriverConfig;
import cucumber.api.java.en.Then;
import org.fasttrackit.util.TestBase;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ro.btrl.Secure3DPassword;

public class SecureGwSteps extends TestBase {

    private CardView cardView = new CardView();

    @Then("^I enter my SecureGW card details \"([^\"]*)\"/\"([^\"]*)\" that expires on \"([^\"]*)\"/\"([^\"]*)\" and owned by \"([^\"]*)\"$")
    public void I_enter_my_PayU_card_details_that_expires_on_and_owned_by(String number, String cvv, String month, String year, String owner) throws Throwable {
        cardView.setValues(number, cvv, month, year, owner);
    }

    @Then("^I proceed to SecureGW payment$")
    public void iProceedToSecureGWPayment() throws Throwable {
        cardView.pay();

        WebDriverWait wait = new WebDriverWait(WebDriverConfig.getDriver(), 5);
        wait.until(ExpectedConditions.alertIsPresent());
        WebDriverConfig.getDriver().switchTo().alert().accept();
    }

    @Then("^I get a success notification from SecureGW$")
    public void iGetASuccessNotificationFromPayU() throws Throwable {
        cardView.successfullyPaid();
        // TODO close last tab
    }
}

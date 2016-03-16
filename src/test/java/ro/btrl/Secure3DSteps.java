package ro.btrl;

import cucumber.api.java.en.Then;
import org.fasttrackit.util.BankCardDetails;
import org.fasttrackit.util.TestBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Secure3DSteps extends TestBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(Secure3DSteps.class);

    private Secure3DPassword secure3DPassword = new Secure3DPassword();

    @Then("^I type \"([^\"]*)\" into BT 3DSecure password$")
    public void enterPayUPassword(String password) throws Throwable {
        secure3DPassword.setPassword(password);
    }

    @Then("^I enter BT 3DSecure password$")
    public void enterPayUPassword() throws Throwable {
        BankCardDetails card = new BankCardDetails();
        secure3DPassword.setPassword(card.getPassword());
    }

    @Then("^I finalize payment on BT 3DSecure$")
    public void I_finalize_payment_on_PayU_site() throws Throwable {
        secure3DPassword.clickContinue();
    }
}

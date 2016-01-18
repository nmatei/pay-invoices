package ro.rcsrds.digicare;

import com.sdl.selenium.web.utils.Utils;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fasttrackit.util.TestBase;
import ro.euplatesc.secure.CardView;

public class DigiSteps extends TestBase {
    private LoginView loginView = new LoginView();
    private InvoiceListView invoicesView = new InvoiceListView();
    private CardView cardView = new CardView();

    @Then("^I login on DIGI using \"([^\"]*)\"/\"([^\"]*)\"$")
    public void iLoginOnDIGIUsing(String user, String pass) {
        loginView.login(user, pass);
        Utils.sleep(2);
    }

    @When("^I open invoice list on DIGI$")
    public void iOpenInvoiceListOnDIGI() throws Throwable {
        invoicesView.selectAll();
    }

    @Then("^I select to pay all invoices on DIGI$")
    public void iSelectToPayAllInvoicesOnDIGI() {
        invoicesView.payAll();
    }

    @Then("^I enter my EuPlatesc card details \"([^\"]*)\"/\"([^\"]*)\" that expires on \"([^\"]*)\"/\"([^\"]*)\" and owned by \"([^\"]*)\"$")
    public void I_enter_my_PayU_card_details_that_expires_on_and_owned_by(String number, String cvv, String month, String year, String owner) throws Throwable {
        cardView.setValues(number, cvv, month, year, owner);
    }
}

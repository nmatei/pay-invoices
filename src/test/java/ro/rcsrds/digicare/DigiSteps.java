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
    public void login(String user, String pass) {
        loginView.login(user, pass);
        Utils.sleep(2);
    }

    @When("^I open invoice list on DIGI$")
    public void openInvoiceList() throws Throwable {
        invoicesView.selectAll();
    }

    @Then("^I select to pay all invoices on DIGI$")
    public void selectToPayAllInvoices() {
        invoicesView.payAll();
    }

    @Then("^I enter my EuPlatesc card details \"([^\"]*)\"/\"([^\"]*)\" that expires on \"([^\"]*)\"/\"([^\"]*)\" and owned by \"([^\"]*)\"$")
    public void enterCardDetails(String number, String cvv, String month, String year, String owner) throws Throwable {
        cardView.setValues(number, cvv, month, year, owner);
    }
}

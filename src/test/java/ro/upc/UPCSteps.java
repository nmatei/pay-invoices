package ro.upc;

import cucumber.api.java.en.Then;
import org.fasttrackit.util.TestBase;

public class UPCSteps extends TestBase {
    private LoginView loginView = new LoginView();

    @Then("^I login on UPC using \"([^\"]*)\"/\"([^\"]*)\"$")
    public void login(String user, String pass) {
        loginView.login(user, pass);
    }
}

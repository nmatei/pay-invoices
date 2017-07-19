package ro.eon;

import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.utils.Utils;
import cucumber.api.java.en.Then;
import org.fasttrackit.util.TestBase;

public class EonSteps extends TestBase {
    private LoginView loginView = new LoginView();

    private WebLocator acceptCookie = new WebLocator().setText("OK, am înțeles");

    @Then("^I login on EON using \"([^\"]*)\"/\"([^\"]*)\"$")
    public void login(String user, String pass) {
        loginView.login(user, pass);

        if(acceptCookie.isElementPresent()) {
            acceptCookie.doClick();
            Utils.sleep(1000);// fading
        }
    }
}

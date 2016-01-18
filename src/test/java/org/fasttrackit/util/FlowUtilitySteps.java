package org.fasttrackit.util;

import com.sdl.selenium.utils.config.WebDriverConfig;
import com.sdl.selenium.web.utils.Utils;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.Dimension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class FlowUtilitySteps extends TestBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(FlowUtilitySteps.class);

    @Given("^I wait (\\d+) seconds$")
    public void wait_seconds(int seconds) {
        LOGGER.info("Waiting {} seconds", seconds);
        Utils.sleep(seconds * 1000);
    }

    @When("^I open url \"([^\"]*)\"$")
    public void I_open_LC_path(String url) {
        AppUtils.openUrl(url);
    }

    @Given("^I set browser size to (\\d+), (\\d+)$")
    public void setBrowserSize(int width, int height) {
        LOGGER.info("I set browser size to ({}, {})", width, height);
        WebDriverConfig.getDriver().manage().window().setSize(new Dimension(width, height));
    }

    @Given("^I maximize browser$")
    public void maximizeBrowser() {
        WebDriverConfig.getDriver().manage().window().maximize();
    }

    @Then("^I should be on url \"([^\"]*)\"$")
    public void I_should_be_on_url(String url) {
        assertThat(WebDriverConfig.getDriver().getCurrentUrl(), is(url));
    }

    @When("^I switch browser to last tab$")
    public void I_switch_last_browser_tab() throws Throwable {
        WebDriverConfig.switchToLastTab();
    }
}

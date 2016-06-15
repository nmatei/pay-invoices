package org.fasttrackit.util;

import com.sdl.selenium.web.SearchType;
import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.button.Button;
import com.sdl.selenium.web.button.InputButton;
import com.sdl.selenium.web.form.TextField;
import com.sdl.selenium.web.link.WebLink;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestyUtilitySteps extends TestBase {

    @When("^I click on link with text \"([^\"]*)\"$")
    public void I_click_on_link_with_text(String text) {
        WebLink link = new WebLink().setText(text);
        link.click();
    }

    @When("^I click on link containing text \"([^\"]*)\"$")
    public void iClickOnLinkContainingText(String text) throws Throwable {
        WebLink link = new WebLink().setText(text, SearchType.TRIM, SearchType.CHILD_NODE);
        link.click();
    }

    @When("^I click on element with text \"([^\"]*)\"$")
    public void I_click_on_element_with_text(String text) throws Throwable {
        WebLocator element = new WebLocator().setText(text);
        element.click();
    }
    
    @When("^I click on input button with text \"([^\"]*)\"$")
    public void I_click_on_input_button_with_text(String text) {
        InputButton button = new InputButton().setText(text);
        button.click();
    }

    @When("^I click on \"([^\"]*)\" button$")
    public void I_click_button(String text) {
        Button button = new Button().setText(text, SearchType.EQUALS, SearchType.TRIM, SearchType.DEEP_CHILD_NODE_OR_SELF);
        button.click();
    }

    @Then("^I should see an element with text \"([^\"]*)\"$")
    public void assertHaveElementWithText(String text) {
        WebLocator element = new WebLocator().setText(text);
        element.assertReady();
    }

    @Then("^I should see an element containing text \"([^\"]*)\"$")
    public void assertHaveElementContainingText(String text) {
        WebLocator element = new WebLocator().setText(text, SearchType.CONTAINS, SearchType.DEEP_CHILD_NODE_OR_SELF);
        element.assertReady();
    }

    @Then("^I should see following elements with texts \"(.*)\"$")
    public void assertHaveElementsWithText(List<String> texts) {
        for (String text : texts) {
            assertHaveElementWithText(text);
        }
    }

    @When("^I type \"([^\"]*)\" into \"([^\"]*)\" field$")
    public void typeIntoField(String value, String label) {
        TextField field = new TextField().setLabel(label, SearchType.DEEP_CHILD_NODE_OR_SELF);
        field.setValue(value);
    }

    @Then("^field \"([^\"]*)\" should have value \"([^\"]*)\"$")
    public void text_field_with_label_should_have_value(String label, String value) {
        TextField field = new TextField().setLabel(label, SearchType.DEEP_CHILD_NODE_OR_SELF);
        assertThat(field.getValue(), is(value));
    }

    @When("^I mouse over on element with text \"([^\"]*)\"$")
    public void I_mouse_over_on_element_with_text(String text) {
        WebLocator element = new WebLocator().setText(text);
        element.mouseOver();
    }
}

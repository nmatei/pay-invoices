package ro.btrl;

import com.sdl.selenium.web.SearchType;
import com.sdl.selenium.web.table.Cell;
import com.sdl.selenium.web.table.Table;
import com.sdl.selenium.web.utils.Utils;
import cucumber.api.java.en.Then;
import org.fasttrackit.util.BankCardDetails;
import org.fasttrackit.util.TestBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Secure3DSteps extends TestBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(Secure3DSteps.class);

    private Secure3DPassword secure3DPassword = new Secure3DPassword();

    @Then("^I type \"([^\"]*)\" into BT 3DSecure password$")
    public void enterPassword(String password) throws Throwable {
        secure3DPassword.setPassword(password);
    }

    @Then("^I enter BT 3DSecure password$")
    public void enterPassword() throws Throwable {
        BankCardDetails card = new BankCardDetails();
        secure3DPassword.setPassword(card.getPassword());

        BankCardDetails.LAST_AMOUNT = getCurrentAmount();
        LOGGER.info("Paid amount: {}", BankCardDetails.LAST_AMOUNT);
    }

    private String getCurrentAmount() {
        Cell cell = new Table().getCell(2, new Cell(1, "Suma:", SearchType.DEEP_CHILD_NODE_OR_SELF));
        cell.setResultIdx(2);
        String text;
        int retryCount = 0;
        do {
            cell.ready(10);
            Utils.sleep(500);
            text = cell.getText();
            retryCount++;
        } while ((text == null || "".equals(text)) && retryCount > 20);
        if (text == null) {
            text = "";
        }
        return text.split(" ")[0];
    }

    @Then("^I finalize payment on BT 3DSecure$")
    public void I_finalize_payment_on_PayU_site() throws Throwable {
        secure3DPassword.clickContinue();
    }
}

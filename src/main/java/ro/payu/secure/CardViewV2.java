package ro.payu.secure;

import com.sdl.selenium.WebLocatorUtils;
import com.sdl.selenium.bootstrap.form.SelectPicker;
import com.sdl.selenium.utils.config.WebDriverConfig;
import com.sdl.selenium.web.SearchType;
import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.button.Button;
import com.sdl.selenium.web.form.TextField;
import org.fasttrackit.util.BankCardDetails;

public class CardViewV2 extends WebLocator {
    private final String LABEL_POSITION = "//following-sibling::*//";

    private TextField numberField = new TextField().setLabel("Numărul cardului:", SearchType.DEEP_CHILD_NODE_OR_SELF).setLabelPosition(LABEL_POSITION);
    private TextField ownerField = new TextField().setLabel("Numele deținătorului:", SearchType.DEEP_CHILD_NODE_OR_SELF).setLabelPosition(LABEL_POSITION);
    private SelectPicker monthField = new SelectPicker().setLabel("Data expirării:", SearchType.DEEP_CHILD_NODE_OR_SELF).setLabelPosition(LABEL_POSITION).setAttribute("data-id", "cc_expiration_month");
    private SelectPicker yearField = new SelectPicker().setLabel("Data expirării:", SearchType.DEEP_CHILD_NODE_OR_SELF).setLabelPosition(LABEL_POSITION).setAttribute("data-id", "cc_expiration_year");
    private TextField cvv2Field = new TextField().setLabel("Cod securitate:", SearchType.DEEP_CHILD_NODE_OR_SELF).setLabelPosition(LABEL_POSITION);

    private Button payButton = new Button().setText("Plăteşte");

    private WebLocator successMessageElement = new WebLocator().setText("Plata s-a inregistrat cu succes!", SearchType.CHILD_NODE);

    public void setValues(String number, String cvv, String month, String year, String owner) {
        // TODO use paste? because is typing only first 4 numbers
//        numberField.setValue(number);
        numberField.pasteInValue(number);

        cvv2Field.setValue(cvv);
        monthField.select(month);
        yearField.select(year);
        ownerField.setValue(owner);
    }

    public void setValues(BankCardDetails card) {
        // month is in format "05 (Mai)"
        String month = card.getMonth();
        setValues(card.getNumber(), card.getCvv(), month, card.getYear(), card.getOwner());
    }

    public void switchToPopup() {
        WebLocator popup = new WebLocator().setClasses("popup");
        WebLocator iframe = new WebLocator(popup).setTag("iframe");
        iframe.assertReady();
        WebDriverConfig.getDriver().switchTo().frame(iframe.currentElement);
    }

    public void successfullyPaid() {
        successMessageElement.assertReady();
    }

    public static void main(String[] args) {
        CardViewV2 viewV2 = new CardViewV2();
        WebLocatorUtils.getXPathScript(viewV2);
    }
}

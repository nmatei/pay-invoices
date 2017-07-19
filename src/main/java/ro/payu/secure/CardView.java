package ro.payu.secure;

import com.sdl.selenium.utils.config.WebDriverConfig;
import com.sdl.selenium.web.SearchType;
import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.button.InputButton;
import com.sdl.selenium.web.form.ComboBox;
import com.sdl.selenium.web.form.TextField;
import org.fasttrackit.util.BankCardDetails;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Locale;

public class CardView extends WebLocator {
    private final String LABEL_POSITION = "/parent::*/following-sibling::td[1]//";

    private TextField numberField = new TextField().setLabel("Numărul cardului:").setLabelTag("span").setLabelPosition(LABEL_POSITION);
    private TextField ownerField = new TextField().setLabel("Titular card:").setLabelTag("span").setLabelPosition(LABEL_POSITION);
    private ComboBox monthField = new ComboBox().setLabel("Data de expirare a cardului:").setLabelTag("span").setLabelPosition(LABEL_POSITION).setPosition(1);
    private ComboBox yearField = new ComboBox().setLabel("Data de expirare a cardului:").setLabelTag("span").setLabelPosition(LABEL_POSITION).setPosition(2);
    private TextField cvv2Field = new TextField().setLabel("Codul CVV2/CVC2 al cardului:").setLabelTag("span").setLabelPosition(LABEL_POSITION);

    private InputButton payButton = new InputButton().setText("Plateste");

    private WebLocator successMessageElement = new WebLocator().setText("Plata s-a inregistrat cu succes!", SearchType.CHILD_NODE);

    public void setValues(String number, String cvv, String month, String year, String owner) {
        numberField.setValue(number);
        cvv2Field.setValue(cvv);
        monthField.select(month);
        yearField.select(year);
        ownerField.setValue(owner);
    }

    public void setValues(BankCardDetails card) {
        // month is in format "05 (Mai)"
        String month = card.getMonth() + " (" + card.getMonthName(new Locale("ro")) + ")";
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
}

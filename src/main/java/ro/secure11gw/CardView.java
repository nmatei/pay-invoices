package ro.secure11gw;

import com.sdl.selenium.utils.config.WebDriverConfig;
import com.sdl.selenium.web.SearchType;
import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.button.InputButton;
import com.sdl.selenium.web.form.ComboBox;
import com.sdl.selenium.web.form.TextField;

public class CardView extends WebLocator {
    private TextField numberField = new TextField().setLabel("Numarul cardului", SearchType.TRIM).setLabelTag("div");
    private TextField ownerField = new TextField().setLabel("Numele scris pe card", SearchType.TRIM).setLabelTag("div");
    private ComboBox monthField = new ComboBox().setLabel("Data expirarii cardului", SearchType.TRIM).setLabelTag("div").setPosition(1);
    private ComboBox yearField = new ComboBox().setLabel("Data expirarii cardului", SearchType.TRIM).setLabelTag("div").setPosition(2);
    private TextField cvv2Field = new TextField().setLabel("Codul CVV2/CVC2", SearchType.TRIM).setLabelTag("div");

    private InputButton payButton = new InputButton().setText("Efectueaza plata");

    private WebLocator successMessageElement = new WebLocator().setText("Plata dumneavoastră a fost înregistrată cu success!");

    public void setValues(String number, String cvv, String month, String year, String owner) {
        numberField.setValue(number);
        cvv2Field.setValue(cvv);
        monthField.select(month);
        yearField.select(year);
        ownerField.setValue(owner);
    }

    public void pay() {
        payButton.assertClick();
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

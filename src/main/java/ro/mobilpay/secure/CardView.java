package ro.mobilpay.secure;

import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.button.InputButton;
import com.sdl.selenium.web.form.ComboBox;
import com.sdl.selenium.web.form.TextField;

public class CardView extends WebLocator {
    private TextField numberField = new TextField().setPlaceholder("Numar Card");
    private TextField ownerField = new TextField().setPlaceholder("Nume detinator card");
    private ComboBox monthField = new ComboBox().setId("paymentExpMonth");
    private ComboBox yearField = new ComboBox().setId("paymentExpYear");
    private TextField cvv2Field = new TextField().setPlaceholder("CVV2/CVC");

    private InputButton payButton = new InputButton().setText("Platesc in siguranta");

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
}

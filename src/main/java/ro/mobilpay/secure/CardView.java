package ro.mobilpay.secure;

import com.sdl.selenium.web.SearchType;
import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.button.Button;
import com.sdl.selenium.web.form.ComboBox;
import com.sdl.selenium.web.form.TextField;
import org.fasttrackit.util.BankCardDetails;

public class CardView extends WebLocator {
    private TextField numberField = new TextField().setPlaceholder("Numar Card");
    private TextField ownerField = new TextField().setPlaceholder("Nume detinator card");
    private ComboBox monthField = new ComboBox().setId("paymentExpMonth");
    private ComboBox yearField = new ComboBox().setId("paymentExpYear");
    private TextField cvv2Field = new TextField().setPlaceholder("CVV2/CVC");

    private Button payButton = new Button().setText("Platesc in siguranta", SearchType.TRIM);

    public void setValues(String number, String cvv, String month, String year, String owner) {
        numberField.setValue(number);
        cvv2Field.setValue(cvv);
        monthField.select(month);
        yearField.select(year);
        ownerField.setValue(owner);
    }

    public void setValues(BankCardDetails card) {
        String month = card.getMonth();
        setValues(card.getNumber(), card.getCvv(), month, card.getYear(), card.getOwner());
    }

    public void pay() {
        payButton.click();
    }
}

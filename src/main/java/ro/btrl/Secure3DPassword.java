package ro.btrl;

import com.sdl.selenium.web.button.InputButton;
import com.sdl.selenium.web.form.TextField;

public class Secure3DPassword {

    private TextField passwordField = new TextField().setName("PASSWORD").setRenderMillis(10000);
    private InputButton continueButton = new InputButton().setText("Continua");

    public void setPassword(String password) {
        passwordField.setValue(password);
    }

    public void clickContinue() {
        continueButton.click();
    }
}

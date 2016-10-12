package ro.btrl;

import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.form.TextField;

public class Secure3DPassword {

    private TextField passwordField = new TextField().setName("PASSWORD").setRenderMillis(10000);
    private WebLocator continueButton = new WebLocator().setTag("img").setAttribute("src", "images/Continua.jpg");


    public void setPassword(String password) {
        passwordField.setValue(password);
    }

    public void clickContinue() {
        continueButton.click();
    }
}

package ro.electricafurnizare.oficiulvirtual;

import com.sdl.selenium.web.SearchType;
import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.button.InputButton;
import com.sdl.selenium.web.form.TextField;

public class LoginView extends WebLocator {

    public LoginView() {
        setTag("form");
    }

    private TextField userNameField = new TextField(this).setLabel("Utilizator:", SearchType.TRIM);
    private TextField passwordField = new TextField(this).setLabel("Parola:", SearchType.TRIM);
    private InputButton loginButton = new InputButton(this, "Submit");

    public void login(String user, String pass) {
        userNameField.setValue(user);
        passwordField.setValue(pass);
        loginButton.assertClick();
    }
}

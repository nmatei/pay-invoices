package ro.upc;

import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.button.Button;
import com.sdl.selenium.web.form.TextField;

public class LoginView extends WebLocator {

    public LoginView() {
        setTag("form");
    }

    private TextField userNameField = new TextField(this).setPlaceholder("E-mail");
    private TextField passwordField = new TextField(this).setPlaceholder("Parola");
    private Button loginButton = new Button(this, "Intră în cont");

    public void login(String user, String pass) {
        userNameField.setValue(user);
        passwordField.setValue(pass);
        loginButton.click();
    }
}

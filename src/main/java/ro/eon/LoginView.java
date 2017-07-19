package ro.eon;

import com.sdl.selenium.web.SearchType;
import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.button.Button;
import com.sdl.selenium.web.form.TextField;

public class LoginView extends WebLocator {

    public LoginView() {
        setTag("form");
    }

    private TextField userNameField = new TextField(this).setPlaceholder("Utilizator");
    private TextField passwordField = new TextField(this).setPlaceholder("Parolă");
    private Button loginButton = new Button(this, "Login", SearchType.DEEP_CHILD_NODE);

    public void login(String user, String pass) {
        userNameField.setValue(user);
        passwordField.setValue(pass);
        loginButton.click();
    }
}

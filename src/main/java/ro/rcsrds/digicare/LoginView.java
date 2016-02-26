package ro.rcsrds.digicare;

import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.button.Button;
import com.sdl.selenium.web.form.TextField;

public class LoginView extends WebLocator {

    public LoginView() {
        setTag("form");
        WebLocator header = new WebLocator().setText("Intrare în contul meu Digi");
        setChildNodes(header);
    }

    private TextField userNameField = new TextField(this).setPlaceholder("Cod Client sau Email");
    private TextField passwordField = new TextField(this).setPlaceholder("Parolă");
    private Button loginButton = new Button(this, "Autentificare");

    public void login(String user, String pass) {
        userNameField.setValue(user);
        passwordField.setValue(pass);
        loginButton.assertClick();
    }
}

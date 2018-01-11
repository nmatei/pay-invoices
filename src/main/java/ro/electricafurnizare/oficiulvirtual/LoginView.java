package ro.electricafurnizare.oficiulvirtual;

import com.sdl.selenium.WebLocatorUtils;
import com.sdl.selenium.web.SearchType;
import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.button.Button;
import com.sdl.selenium.web.form.TextField;
import com.sdl.selenium.web.utils.Utils;

public class LoginView extends WebLocator {

    public LoginView() {
        setTag("form");
    }

    private TextField userNameField = new TextField(this).setLabel("Nume utilizator / email", SearchType.TRIM).setLabelPosition("//following-sibling::*//");
    private TextField passwordField = new TextField(this).setName("myelectrica_pass");
    private Button loginButton = new Button(this, "Acceseaza");

    public void login(String user, String pass) {
        userNameField.setValue(user);
        passwordField.setValue(pass);
        Utils.sleep(200);
        loginButton.click();
    }

    public static void main(String[] args) {
        WebLocatorUtils.getXPathScript(new LoginView());
    }
}

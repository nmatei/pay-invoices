package ro.electricafurnizare.oficiulvirtual;

import com.sdl.selenium.conditions.Condition;
import com.sdl.selenium.conditions.ConditionManager;
import com.sdl.selenium.conditions.ElementRemovedSuccessCondition;
import com.sdl.selenium.web.SearchType;
import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.button.Button;
import com.sdl.selenium.web.form.CheckBox;
import com.sdl.selenium.web.form.ComboBox;
import com.sdl.selenium.web.link.WebLink;
import com.sdl.selenium.web.utils.Utils;

public class InvoiceListView extends WebLocator {
    private WebLink invoiceMenuItem = new WebLink().setText("Facturi / Plati", SearchType.TRIM, SearchType.DEEP_CHILD_NODE);
    private WebLink payOnline = new WebLink().setText("Plateste online", SearchType.TRIM, SearchType.CHILD_NODE).setVisibility(true);
    private ComboBox placeCombo = new ComboBox().setName("select_nlc"); //.setLabel("Selecteaza locul de Consum")
    private CheckBox selectAllButton = new CheckBox().setId("myelectrica_checkall");
    private Button payAllButton = new Button().setText("Continua plata");
    private Button confirmButton = new Button().setText("Confirmati plata online", SearchType.CHILD_NODE);
    private WebLocator loading = new WebLocator().setClasses("loading-overlay").setVisibility(true);

    public static void main(String[] args) {
        System.out.println(new InvoiceListView().loading.getSelector());
    }

    public void selectAll(String place) {
        // Other element would receive the click: <div class="ov-navcontainer-loading-overlayer">...</div>
        Utils.sleep(1000);
        invoiceMenuItem.mouseOver();
        invoiceMenuItem.click();
        payOnline.click();
        placeCombo.select(place);
        waitToLoad();
        selectAllButton.click();
    }

    public Condition waitToLoad() {
        ConditionManager conditionManager = new ConditionManager().add(new ElementRemovedSuccessCondition(loading));
        Condition condition = conditionManager.execute();
        return condition;
    }

    public void payAll() {
        payAllButton.click();
        waitToLoad();
        confirmButton.click();
    }
}

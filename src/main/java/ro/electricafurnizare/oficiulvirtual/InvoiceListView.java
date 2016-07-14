package ro.electricafurnizare.oficiulvirtual;

import com.sdl.selenium.web.SearchType;
import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.button.InputButton;
import com.sdl.selenium.web.form.CheckBox;
import com.sdl.selenium.web.form.ComboBox;
import com.sdl.selenium.web.link.WebLink;
import com.sdl.selenium.web.utils.Utils;

public class InvoiceListView extends WebLocator {
    private WebLink invoiceMenuItem = new WebLink().setText("Facturi / Plati", SearchType.TRIM, SearchType.CHILD_NODE);
    private WebLink payOnline = new WebLink().setText("Plateste Online", SearchType.TRIM, SearchType.CHILD_NODE).setVisibility(true);
    private ComboBox placeCombo = new ComboBox().setLabel("Selecteaza locul de Consum");
    private CheckBox selectAllButton = new CheckBox().setId("bifeazaTot");
    private InputButton payAllButton = new InputButton().setText("Continua plata");
    private InputButton confirmButton = new InputButton().setText("Confirmati plata online");

    public void selectAll(String place) {
        // Other element would receive the click: <div class="ov-navcontainer-loading-overlayer">...</div>
        Utils.sleep(1000);
        invoiceMenuItem.mouseOver();
        invoiceMenuItem.click();
        payOnline.click();
        placeCombo.select(place);
        selectAllButton.click();
    }

    public void payAll() {
        payAllButton.click();
        confirmButton.click();
    }
}

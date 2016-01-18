package ro.rcsrds.digicare;

import com.sdl.selenium.WebLocatorUtils;
import com.sdl.selenium.conditions.Condition;
import com.sdl.selenium.conditions.ConditionManager;
import com.sdl.selenium.conditions.ElementRemovedSuccessCondition;
import com.sdl.selenium.web.SearchType;
import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.button.Button;
import com.sdl.selenium.web.link.WebLink;
import com.sdl.selenium.web.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InvoiceListView extends WebLocator {
    private WebLocator invoiceMenuItem = new WebLocator().setText("Facturi");
    private WebLink invoicesListItem = new WebLink().setText("Listă Facturi", SearchType.TRIM, SearchType.CHILD_NODE);
    private Button selectAllButton = new Button().setText("Selectaţi tot").setVisibility(true);
    private Button payAllButton = new Button().setText("Plătiţi factura", SearchType.STARTS_WITH);
    private WebLink seeInvoices = new WebLink().setAttribute("data-request", "/invoices-list-orig");

    private WebLocator promoPopup = new WebLocator().setClasses("popup");
    private WebLocator closePromo = new WebLocator(promoPopup).setClasses("close").setRenderMillis(500);

    public void selectAll() {
        invoiceMenuItem.mouseOver();
        invoicesListItem.assertClick();

        WebLocator waiting = new WebLocator().setText("Se încarcă...");
        ConditionManager conditionManager = new ConditionManager().add(new ElementRemovedSuccessCondition(waiting));
        Condition condition = conditionManager.execute();

        closePromo.click();

        if (seeInvoices.isElementPresent()) {
            seeInvoices.assertClick();
        }

        closePromo.click();

        selectAllButton.assertClick();
    }

    public void payAll() {
        payAllButton.assertClick();
    }
}

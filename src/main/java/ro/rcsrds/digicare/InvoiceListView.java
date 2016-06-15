package ro.rcsrds.digicare;

import com.sdl.selenium.conditions.Condition;
import com.sdl.selenium.conditions.ConditionManager;
import com.sdl.selenium.conditions.ElementRemovedSuccessCondition;
import com.sdl.selenium.web.SearchType;
import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.button.Button;
import com.sdl.selenium.web.link.WebLink;

public class InvoiceListView extends WebLocator {
    private WebLocator invoiceMenuItem = new WebLocator().setText("Facturi");
    private WebLink invoicesListItem = new WebLink().setText("Listă Facturi", SearchType.TRIM, SearchType.CHILD_NODE);
    private Button selectAllButton = new Button().setText("Selectaţi tot").setVisibility(true);
    private Button payAllButton = new Button().setText("Plătiţi factura", SearchType.STARTS_WITH);
    private WebLink seeInvoices = new WebLink().setAttribute("data-request", "/invoices-list");

    private WebLocator promoPopup = new WebLocator().setClasses("popup");
    private WebLocator closePromo = new WebLocator(promoPopup).setClasses("close").setRenderMillis(500);

    private WebLocator promoPopup2 = new WebLocator().setClasses("ui-dialog", "ui-front");
    private WebLocator closePromo2 = new WebLocator(promoPopup2).setClasses("ui-dialog-titlebar-close");

    public void selectAll() {
        closePromo2.doClick();
        invoiceMenuItem.mouseOver();
        invoicesListItem.click();

        WebLocator waiting = new WebLocator().setText("Se încarcă...");
        ConditionManager conditionManager = new ConditionManager().add(new ElementRemovedSuccessCondition(waiting));
        Condition condition = conditionManager.execute();

        closePromo.doClick();

        if (seeInvoices.isElementPresent()) {
            seeInvoices.click();
        }

        closePromo.doClick();

        selectAllButton.click();
    }

    public void payAll() {
        payAllButton.click();
    }
}

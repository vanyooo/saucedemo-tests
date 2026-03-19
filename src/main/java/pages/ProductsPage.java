package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ProductsPage extends BasePage {

    @FindBy(css = ".inventory_list")
    private WebElement inventoryList;

    @FindBy(how = How.CSS, using = ".shopping_cart_link")
    private WebElement cartLinkButton;

    @FindBy(how = How.XPATH, using = "//*[@data-test='add-to-cart-sauce-labs-backpack']")
    private WebElement addToCartSauceLabsBackpackButton;

    @FindBy(how = How.CSS, using = ".shopping_cart_badge")
    private WebElement shoppingCartBadgeField;

    @FindBy(how = How.CSS, using = "[data-test='add-to-cart-sauce-labs-bike-light']")
    private WebElement addToCartSauceLabsBikeLightButton;

    @FindBy(how = How.CSS, using = "[data-test='remove-sauce-labs-backpack']")
    private WebElement removeSauceLabsBackpackButton;

    public ProductsPage(WebDriver driver) {
        super(driver);
        URL = URL + "/inventory.html";
    }

    public CartPage cartButtonClick() {
        cartLinkButton.click();
        return new CartPage(driver);
    }

    public ProductsPage addToCartSauceLabsBackpackClick() {
        addToCartSauceLabsBackpackButton.click();
        return this;
    }

    public int getCountItem() {
        String value = shoppingCartBadgeField.getText();
        return Integer.parseInt(value);
    }

    public ProductsPage addToCartSauceLabsBikeLightClick() {
        addToCartSauceLabsBikeLightButton.click();
        return this;
    }

    public ProductsPage removeSauceLabsBackpackButtonClick() {
        removeSauceLabsBackpackButton.click();
        return this;
    }

    public boolean isInventoryDisplayed() {
        return inventoryList.isDisplayed();
    }
}

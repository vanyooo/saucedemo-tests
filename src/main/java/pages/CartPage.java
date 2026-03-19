package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
        URL = URL + "/cart.html";
    }

    @FindBy(how = How.CSS, using = ".shopping_cart_link")
    private WebElement cartFooterField;

    public boolean isCartFooterDisplayed() {
        return cartFooterField.isDisplayed();
    }

}

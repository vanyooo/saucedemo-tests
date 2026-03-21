package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
        URL = URL + "/cart.html";
    }

    @FindBy(how = How.CSS, using = ".shopping_cart_link")
    private WebElement cartFooterField;

    @Step("Check openid cart")
    public boolean isCartFooterDisplayed() {
        return cartFooterField.isDisplayed();
    }

}

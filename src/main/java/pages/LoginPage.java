package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends BasePage {

    @FindBy(how = How.CSS, using = "#user-name")
    private WebElement userNameInput;

    @FindBy(how = How.CSS, using = "#password")
    private WebElement passwordInput;

    @FindBy(how = How.CSS, using = "#login-button")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
        URL = URL + "/";
    }

    public void open() {
        driver.navigate().to(URL);
    }

    public LoginPage fillUserNameInput(String name) {
        userNameInput.sendKeys(name);
        return this;
    }

    public LoginPage fillPasswordInput(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    public ProductsPage clickLogin() {
        loginButton.click();
        return new ProductsPage(driver);
    }

    public ProductsPage login(String username, String password) {
        open();
        return fillUserNameInput(username)
                .fillPasswordInput(password)
                .clickLogin();
    }
}

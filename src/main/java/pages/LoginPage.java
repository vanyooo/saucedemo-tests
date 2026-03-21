package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import io.qameta.allure.Step;

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

    @Step("Open login page")
    public void open() {
        driver.navigate().to(URL);
    }

    @Step("Input full name with value {name}")
    public LoginPage fillUserNameInput(String name) {
        userNameInput.sendKeys(name);
        return this;
    }

    @Step("Input password with value {0}")
    public LoginPage fillPasswordInput(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    @Step("Click button login")
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

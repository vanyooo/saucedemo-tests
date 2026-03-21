package com.javarush;

import config.Config;
import extension.Driver;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("Check work cart")
@Feature("Cart")
@Story("Correct work")
public class TestSauceDemo {

    WebDriver driver;
    LoginPage loginPage;
    ProductsPage productsPage;

    @BeforeEach
    @Step("Open main page")
    void setUp() {
        driver = Driver.get();
        loginPage = new LoginPage(driver);
        productsPage = loginPage.login(Config.usernameValid, Config.PASSWORD);
    }

    @Test
    @Step("Login")
    void loginTest() {
        assertTrue(productsPage.isInventoryDisplayed());
    }

    @Test
    @Step("Open cart")
    void goToCart() {
        CartPage cartPage = productsPage.cartButtonClick();
        assertTrue(cartPage.isCartFooterDisplayed());
    }

    @Test
    @Step("Add goods to cart")
    void addItemToEmptyCart() {
        int countItem = productsPage.addToCartSauceLabsBackpackClick()
                .getCountItem();
        assertEquals(1, countItem);
    }

    @Test
    @Step("Add goods to cart not empty")
    void shouldIncreaseCartCountWhenAddingItems() {
        int countItemAfter = productsPage.addToCartSauceLabsBackpackClick()
                .getCountItem();
        int countItemBefore = productsPage.addToCartSauceLabsBikeLightClick()
                .getCountItem();
        assertEquals(countItemAfter + 1, countItemBefore, "Ожидаем увеличение количества товаров на 1 шт");
    }

    @Test
    @Step("delete goods from cart")
    void deleteItemFromCart() {
        int countItemAfter = productsPage.addToCartSauceLabsBackpackClick()
                .addToCartSauceLabsBikeLightClick()
                .getCountItem();
        assertEquals(2, countItemAfter, "Ожидаем увеличение количества товаров на 2 шт");
        int countItemBefore = productsPage.removeSauceLabsBackpackButtonClick().getCountItem();
        assertEquals(1, countItemBefore, "Ожидаем уменьшение количества товаров на 1 шт");
    }

    @AfterEach
    void tearDown() {
        Driver.close();
    }
}

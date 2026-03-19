package com.javarush;

import config.Config;
import extension.Driver;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestSauceDemo {

    WebDriver driver;
    LoginPage loginPage;
    ProductsPage productsPage;

    @BeforeEach
    void setUp() {
        driver = Driver.get();
        loginPage = new LoginPage(driver);
        productsPage = loginPage.login(Config.usernameValid, Config.PASSWORD);
    }

    @Test
    void loginTest() {
        assertTrue(productsPage.isInventoryDisplayed());
    }

    @Test
    void goToCart() {
        CartPage cartPage = productsPage.cartButtonClick();
        assertTrue(cartPage.isCartFooterDisplayed());
    }

    @Test
    void addItemToEmptyCart() {
        int countItem = productsPage.addToCartSauceLabsBackpackClick()
                .getCountItem();
        assertEquals(1, countItem);
    }

    @Test
    void shouldIncreaseCartCountWhenAddingItems() {
        int countItemAfter = productsPage.addToCartSauceLabsBackpackClick()
                .getCountItem();
        int countItemBefore = productsPage.addToCartSauceLabsBikeLightClick()
                .getCountItem();
        assertEquals(countItemAfter + 1, countItemBefore, "Ожидаем увеличение количества товаров на 1 шт");
    }

    @Test
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

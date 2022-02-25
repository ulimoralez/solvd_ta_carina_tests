package com.solvd.web.demoblaze;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.solvd.web.demoblaze.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CategoriesTest extends AbstractTest {

    @Test
    public void test_categories() {
        HomePage homePage = new HomePage(getDriver());
        homePage.clickPhones();
        Assert.assertTrue(homePage.isNokiaLumiaVisible(), "Nokia Lumia isn't visible");
        homePage.clickLaptops();
        Assert.assertTrue(homePage.isSonyVaioVisible(), "Laptop Sony Vaio I7 isn't visible");
        homePage.clickMonitors();
        Assert.assertTrue(homePage.isAsusFullHDVisible(), "Monitor Asus Full HD isn't visible");
    }

    @Test
    public void test_get_cheapest_phone() {
        HomePage homePage = new HomePage(getDriver());
        homePage.phones_clickPhonesButton();
        Assert.assertEquals(homePage.getCheapestProduct().getPrice(), 320, "Fail");
    }

    @Test
    public void test_get_cheapest_laptop() {
        HomePage homePage = new HomePage(getDriver());
        homePage.clickLaptops();
        Assert.assertEquals(homePage.getCheapestProduct().getPrice(), 700, "Fail");
    }

    @Test
    public void test_get_cheapest_monitor() {
        HomePage homePage = new HomePage(getDriver());
        homePage.clickMonitors();
        Assert.assertEquals(homePage.getCheapestProduct().getPrice(), 230, "Fail");
    }
}
package com.solvd.web.demoblaze;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CartPage extends AbstractPage {

    @FindBy(xpath = "//*[@id='page-wrapper']/div/div[2]/button")
    private ExtendedWebElement placeOrderButton;

    @FindBy(xpath = "//*[@id='name']")
    private ExtendedWebElement nameInput;

    @FindBy(xpath = "//*[@id='country']")
    private ExtendedWebElement countryInput;

    @FindBy(xpath = "//*[@id='city']")
    private ExtendedWebElement cityInput;

    @FindBy(xpath = "//*[@id='card']")
    private ExtendedWebElement creditCardInput;

    @FindBy(xpath = "//*[@id='month']")
    private ExtendedWebElement monthInput;

    @FindBy(xpath = "//*[@id='year']")
    private ExtendedWebElement yearInput;

    @FindBy(xpath = "//*[@id='orderModal']/div/div/div[3]/button[2]")
    private ExtendedWebElement purchaseButton;

    private ExtendedWebElement cancelButton;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void fillPurchaseModal(String name, String country, String city, String creditCard, String month, String year){
        nameInput.type(name);
        countryInput.type(country);
        cityInput.type(city);
        creditCardInput.type(creditCard);
        monthInput.type(month);
        yearInput.type(year);
    }
}

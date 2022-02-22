package com.solvd.web.demoblaze.services;

import com.solvd.web.demoblaze.HomePage;
import org.openqa.selenium.WebDriver;

public interface IContactService {

    default HomePage fillContactForm(WebDriver driver, String contactEmail, String contactName, String message){
        HomePage homePage = new HomePage(driver);
        homePage.clickContactLink();
        homePage.sendContactMail(contactEmail);
        homePage.sendContactName(contactName);
        homePage.sendContactMessage(message);
        homePage.clickSendMessage();
        return homePage;
    }

}

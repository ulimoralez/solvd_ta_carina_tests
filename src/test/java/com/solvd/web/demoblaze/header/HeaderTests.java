package com.solvd.web.demoblaze.header;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.solvd.web.demoblaze.HomePage;
import com.solvd.web.demoblaze.services.IContactService;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HeaderTests implements IAbstractTest, IContactService {

    @Test
     public void test_click_home_button() throws InterruptedException {
         HomePage homePage = new HomePage(getDriver());
         TimeUnit.SECONDS.sleep(2);
         homePage.clickHomeLink();
         Assert.assertEquals(getDriver().getCurrentUrl(), "https://www.demoblaze.com/index.html", "Error clicking Home link");
     }

     @Test
     public void test_fill_contact_form_with_all_the_info() throws InterruptedException {
        HomePage homePage = fillContactForm(getDriver(), "mail@mail.com", "umoralez", "Test message");
        TimeUnit.SECONDS.sleep(2);
        Assert.assertEquals(homePage.alert_getText(), "Thanks for the message!!", "Error during sending the message");
     }

    @Test
    public void test_fill_contact_form_without_mail() throws InterruptedException {
        HomePage homePage = fillContactForm(getDriver(), null, "umoralez", "Test message");
        TimeUnit.SECONDS.sleep(2);
        Assert.assertEquals(homePage.alert_getText(), "Thanks for the message!!", "Error during sending the message");
    }

    @Test
    public void test_fill_contact_form_without_contactName(){
        HomePage homePage = fillContactForm(getDriver(), "null@null.com", null, "Test message");
        Assert.assertEquals(homePage.alert_getText(), "Thanks for the message!!", "Error during sending the message");
        homePage.alert_clickToAccept();
    }

    @Test
    public void test_fill_contact_form_without_message() throws InterruptedException {
        HomePage homePage = fillContactForm(getDriver(), "null@null.com", "username", null);
        TimeUnit.SECONDS.sleep(2);
        Assert.assertEquals(homePage.alert_getText(), "Thanks for the message!!", "Error during sending the message");
    }

    @Test
    public void test_fill_contact_form_without_email_or_contactName() throws InterruptedException {
        HomePage homePage = fillContactForm(getDriver(), null, null, "Test message");
        TimeUnit.SECONDS.sleep(2);
        Assert.assertEquals(homePage.alert_getText(), "Thanks for the message!!", "Error during sending the message");
    }

    @Test
    public void test_fill_contact_form_empty() throws InterruptedException {
        HomePage homePage = fillContactForm(getDriver(), null, null, null);
        TimeUnit.SECONDS.sleep(2);
        Assert.assertEquals(homePage.alert_getText(), "Thanks for the message!!", "Error during sending the message");
    }

}

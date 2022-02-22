package com.solvd.web.demoblaze.account;

import com.github.javafaker.Faker;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.solvd.web.demoblaze.HomePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SingInSignUpTest implements IAbstractTest {

    Faker faker = new Faker();

    String username = "umoralez";
    String password = "umoralez";

    String newUsername = faker.name().username();
    String newPassword = faker.leagueOfLegends().champion();

    //Sign Up Tests - - - - - - -
    @Test
    public void test_sign_up_with_new_credentials(){
        HomePage homePage = new HomePage(getDriver());
        homePage.clickSignUp();
        Assert.assertEquals(homePage.getSignUpFormText(), "Sign up", "Error opening the Sign up card");
        homePage.setSignUpWithCredentials(newUsername, newPassword);
        homePage.clickSignUpButton();

        Assert.assertEquals(homePage.alert_getText(), "Sign up successful.", "Error in the sign up");
        homePage.alert_clickToAccept();
    }

    @Test
    public void test_sing_up_without_username(){
        HomePage homePage = new HomePage(getDriver());
        homePage.clickSignUp();
        Assert.assertEquals(homePage.getSignUpFormText(), "Sign up", "Error opening the Sign up card");
        homePage.sendSignUpPassword(newPassword);
        homePage.clickSignUpButton();

        Assert.assertEquals(homePage.alert_getText(), "Please fill out Username and Password.", "Error in the sign up without username");
        homePage.alert_clickToAccept();
    }

    @Test
    public void test_sing_up_without_password(){
        HomePage homePage = new HomePage(getDriver());
        homePage.clickSignUp();
        Assert.assertEquals(homePage.getSignUpFormText(), "Sign up", "Error opening the Sign up card");
        homePage.sendSignUpUsername(newUsername);
        homePage.clickSignUpButton();

        Assert.assertEquals(homePage.alert_getText(), "Please fill out Username and Password.", "Error in the sign up without username");
        homePage.alert_clickToAccept();
    }

    @Test
    public void test_sing_up_with_an_existing_username(){
        HomePage homePage = new HomePage(getDriver());
        homePage.clickSignUp();
        Assert.assertEquals(homePage.getSignUpFormText(), "Sign up", "Error opening the Sign up card");
        homePage.sendSignUpUsername(username);
        homePage.clickSignUpButton();

        Assert.assertEquals(homePage.alert_getText(), "Please fill out Username and Password.", "Error in the sign up without username");
        homePage.alert_clickToAccept();
    }

    @Test
    public void test_sing_up_without_credentials(){
        HomePage homePage = new HomePage(getDriver());
        homePage.clickSignUp();
        Assert.assertEquals(homePage.getSignUpFormText(), "Sign up", "Error opening the Sign up card");
        homePage.clickSignUpButton();

        Assert.assertEquals(homePage.alert_getText(), "Please fill out Username and Password.", "Error in the sign up without username");
        homePage.alert_clickToAccept();
    }
    // Sign In Tests - - - - - - - - - - - - - - - - - -

    @Test
    public void test_sing_in_correctly() throws InterruptedException {
        HomePage homePage = new HomePage(getDriver());
        homePage.clickLogIn();

        Assert.assertEquals(homePage.getLogInFormText(), "Log in", "Error showing the sign in form");

        homePage.setLogInCredentials(username, password);

        homePage.clickLoginButton();

        TimeUnit.SECONDS.sleep(3);
        Assert.assertEquals(homePage.getWelcomeMessage(), "Welcome umoralez", "Failed Sign in");
    }

    @Test
    public void test_sing_in_without_credentials(){
        HomePage homePage = new HomePage(getDriver());
        homePage.clickLogIn();
        Assert.assertEquals(homePage.getLogInFormText(), "Log in", "Error showing the sign in form");
        homePage.clickLoginButton();

        Assert.assertEquals(homePage.alert_getText(), "Please fill out Username and Password.", "Failed signing without credentials");
    }

    @Test
    public void test_sing_in_with_incorrect_password(){
        HomePage homePage = new HomePage(getDriver());
        homePage.clickLogIn();
        homePage.setLogInCredentials(username, "PasswordWithFailures");
        homePage.clickLoginButton();

        Assert.assertEquals(homePage.alert_getText(), "Wrong password.", "Failed incorrect password test");
        homePage.alert_clickToAccept();
    }

    @Test
    public void test_sing_in_with_an_unexisting_username(){
        HomePage homePage = new HomePage(getDriver());
        homePage.clickLogIn();
        homePage.setLogInCredentials("NoCreoQueEsteUsernameExista2", "PasswordWithFailures");
        homePage.clickLoginButton();
        Assert.assertEquals(homePage.alert_getText(), "User does not exist.", "Failed incorrect user test");
        homePage.alert_clickToAccept();
    }

    @Test
    public void test_sing_out() throws InterruptedException {
        HomePage homePage = new HomePage(getDriver());
        homePage.clickLogIn();
        homePage.setLogInCredentials(username, password);
        homePage.clickLoginButton();
        TimeUnit.SECONDS.sleep(3);
        Assert.assertEquals(homePage.getWelcomeMessage(), "Welcome umoralez", "Failed Sign in");
        homePage.clickLogOut();
        TimeUnit.SECONDS.sleep(3);
        Assert.assertTrue(homePage.isSignUpDisplayed(), "Sign Up Button is not displayed");
    }

}

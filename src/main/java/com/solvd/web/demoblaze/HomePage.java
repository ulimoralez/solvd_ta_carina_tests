package com.solvd.web.demoblaze;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

    //Header Buttons
    // - - No sé como agarrarlo de mejor manera
    @FindBy(xpath = "//*[@id='navbarExample']/ul/li[1]/a")
    private ExtendedWebElement homeLink;
    @FindBy(linkText = "Contact")
    private ExtendedWebElement contactLink;
    @FindBy(linkText = "About us")
    private ExtendedWebElement aboutUsLink;
    @FindBy(linkText = "Cart")
    private ExtendedWebElement cartPage;

    //Login & SignUp section
    @FindBy(linkText = "Log in")
    private ExtendedWebElement logIn;
    @FindBy(id = "logInModalLabel")
    private ExtendedWebElement logInForm;
    @FindBy(id = "loginusername")
    private ExtendedWebElement usernameLogInField;
    @FindBy(id = "loginpassword")
    private ExtendedWebElement passwordLogInField;
    @FindBy(xpath = "//div[@id='logInModal']/div/div/div[3]/button[2]")
    private ExtendedWebElement loginButton;

    @FindBy(linkText = "Sign up")
    private ExtendedWebElement signUp;
    @FindBy(id = "signInModalLabel")
    private ExtendedWebElement signUpForm;

    @FindBy(id = "sign-username")
    private ExtendedWebElement usernameSignUpField;

    @FindBy(id = "sign-password")
    private ExtendedWebElement passwordSignUpField;

    @FindBy(css = "#signInModal > div > div > div.modal-footer > button.btn.btn-primary")
    private ExtendedWebElement signUpButton;

    @FindBy(id = "nameofuser")
    private ExtendedWebElement welcomeMessage;
    @FindBy(xpath = "//div[@id='logInModal']/div/div/div[3]/button[1]")
    private ExtendedWebElement cancelButton;

    @FindBy(id = "logout2")
    private ExtendedWebElement logOut;
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    //Contact

    @FindBy(id = "recipient-email")
    private ExtendedWebElement contactEmailInput;

    @FindBy(id = "recipient-name")
    private ExtendedWebElement contactNameInput;

    @FindBy(id = "message-text")
    private ExtendedWebElement contactMessageInput;

    @FindBy(css = "#exampleModal > div > div > div.modal-footer > button.btn.btn-primary")
    private ExtendedWebElement sendMessageButton;

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    // Categories Section
    @FindBy(linkText = "Phones")
    private ExtendedWebElement phones;
    @FindBy(linkText = "Laptops")
    private ExtendedWebElement laptops;
    @FindBy(linkText = "Monitors")
    private ExtendedWebElement monitors;

    @FindAll({@FindBy(className = "col-lg-4 col-md-6 mb-4")})
    private ExtendedWebElement products;
    @FindBy(id = "prev2")
    private ExtendedWebElement previousButton;
    @FindBy(id = "next2")
    private ExtendedWebElement nextButton;

    //Constructor
    public HomePage(WebDriver driver) {
        super(driver);
        open();
    }

    public String getWebDriver() {
        String text = driver.switchTo().alert().getText();
        driver.getWindowHandle();
        return text;
    }

    //Methods HeaderButtons
    public void clickHomeLink() {
        homeLink.click();
    }

    public void clickContactLink() {
        contactLink.click();
    }

    public void clickAboutUsLink() {
        aboutUsLink.click();
    }

    public void clickCartPage() {
        cartPage.click();
    }

    public void clickLogIn() {
        logIn.click();
    }

    public void clickSignUp() {
        signUp.click();
    }

    public void clickLogOut() {
        logOut.click();
    }

    //Methods Categories
    public void clickPhones() {
        phones.click();
    }

    public void clickLaptops() {
        laptops.click();
    }

    public void clickMonitors() {
        monitors.click();
    }

    public void clickProducts() {
        products.click();
    }

    public void clickPreviousButton() {
        previousButton.click();
    }

    public void clickNextButton() {
        nextButton.click();
    }

    public String getLogInFormText() {
        return logInForm.getText();
    }

    public String getSignUpFormText() {
        return signUpForm.getText();
    }

    public String getWelcomeMessage() {
        return welcomeMessage.getText();
    }

    public boolean isSignUpDisplayed(){
        return signUp.isElementPresent();
    }

    //Log In
    public void clickLoginButton() {
        loginButton.click();
    }

    public void setLogInCredentials(String username, String password) {
        sendLoginUsername(username);
        sendLoginPassword(password);
    }

    public void sendLoginUsername(String username) {
        usernameLogInField.type(username);
    }

    public void sendLoginPassword(String password) {
        passwordLogInField.type(password);
    }
    // - - - - -

    //Sign Up

    public void setSignUpWithCredentials(String username, String password) {
        sendSignUpUsername(username);
        sendSignUpPassword(password);
    }
    public void sendSignUpUsername(String username) {
        usernameSignUpField.type(username);
    }
    public void sendSignUpPassword(String password) {
        passwordSignUpField.type(password);
    }
    public void clickSignUpButton() {
        signUpButton.click();
    }

    // - - - -

    //Contact Form
    public void sendContactMail(String email){
        contactEmailInput.type(email);
    }

    public void sendContactName(String name){
        contactNameInput.type(name);
    }

    public void sendContactMessage(String message){
        contactMessageInput.type(message);
    }

    public void clickSendMessage(){
        sendMessageButton.click();
    }

    // - - - -

    //Alerts
    public void alert_clickToAccept() {
        driver.switchTo().alert().accept();
    }
    public String alert_getText() {
        return driver.switchTo().alert().getText();
    }

}

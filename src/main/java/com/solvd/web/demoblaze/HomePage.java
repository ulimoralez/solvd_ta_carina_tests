package com.solvd.web.demoblaze;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

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

    @FindBy(css = "#tbodyid > div:nth-child(1) > div > div > h4 > a")
    private ExtendedWebElement phoneNokiaLumia;

    @FindBy(css = "#tbodyid > div:nth-child(1) > div > div > h4 > a")
    private ExtendedWebElement laptopSonyVaioIFive;

    @FindBy(css = "#tbodyid > div:nth-child(2) > div > div > h4 > a")
    private ExtendedWebElement monitorAsusFullHD;

    @FindBy(id = "prev2")
    private ExtendedWebElement previousButton;
    @FindBy(id = "next2")
    private ExtendedWebElement nextButton;

    //Constructor
    public HomePage(WebDriver driver) {
        super(driver);
        open();
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
    public void clickPreviousButton() {
        previousButton.click();
    }
    public void clickNextButton() {
        nextButton.click();
    }
    //
    //Register methods
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
        acceptAlert();
    }
    public String alert_getText() {
        return driver.switchTo().alert().getText();
    }

    // - - - -

    // Categories

    public boolean isNokiaLumiaVisible(){
        return phoneNokiaLumia.isVisible();
    }

    public boolean isSonyVaioVisible(){
        return laptopSonyVaioIFive.isVisible();
    }

    public boolean isAsusFullHDVisible(){
        return monitorAsusFullHD.isVisible();
    }

    // - - - - - -

    //-------------------------------------------
    //PHONE ELEMENTS
    @FindBy(xpath = "//a[@id='itemc' and text()='Phones']")
    private ExtendedWebElement phonesSection;

    @FindBy(xpath = "//div[@class='card h-100']")
    private List<ExtendedWebElement> allPhonesBoxes;

    @FindBy(xpath = ("//h4[@class='card-title']/a"))
    private List<ExtendedWebElement> productsName;

    @FindBy(xpath = ("//h4[@class='card-title']/a"))
    private ExtendedWebElement productName;

    @FindBy(xpath = ("//div[@class='card-block']/h5"))
    private List<ExtendedWebElement> productsPrice;

    public void phones_clickPhonesButton() {
        phonesSection.click();
    }

    public List<ExtendedWebElement> phones_getAllPhones() {
        new WebDriverWait(driver, 6).until(ExpectedConditions.numberOfElementsToBe(By.xpath("//h4[@class='card-title']/a"), 7));
        return allPhonesBoxes;
    }

    public Product getCheapestProduct() {
        new WebDriverWait(driver, 4);
        Product productElement = new Product("Nn", 1200);
        for (ExtendedWebElement element :
                productsPrice) {
            int price = Integer.parseInt(element.getText().replaceAll("(?:(?!\\d|Free)(?s:.))*(\\d+(?:[.,]\\d+)*|Free)?", "$1"));
            if (price < productElement.getPrice()) {
                productElement.setPrice(price);
            }
        }
        return productElement;
    }

    public Product getMostExpensiveProduct() {
        new WebDriverWait(driver, 4);
        Product productElement = new Product("Nn", 0);
        for (ExtendedWebElement element :
                productsPrice) {
            int price = Integer.parseInt(element.getText().replaceAll("(?:(?!\\d|Free)(?s:.))*(\\d+(?:[.,]\\d+)*|Free)?", "$1"));
            if (price > productElement.getPrice()) {
                productElement.setPrice(price);
            }
        }
        return productElement;
    }
}

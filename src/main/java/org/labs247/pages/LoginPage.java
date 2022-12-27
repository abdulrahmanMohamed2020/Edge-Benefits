package org.labs247.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final By usernameField = By.id("username");
    private final By passwordField = By.id("password");
    private final By signInButton = By.id("submit");
    private final By errorMessage = By.xpath("//div[contains(@class,'v-messages__message')]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Enter the username")
    public void enterUsername(String username) {
        typeText(usernameField,username);
    }

    @Step("Enter the password")
    public void enterPassword(String password) {
        typeText(passwordField,password);
    }

    @Step("Click on the continue button")
    public void clickOnSignIn() {
        actionClick(signInButton);
    }

    public String getErrorMessage() {
        return findElement(errorMessage).getText();
    }

}

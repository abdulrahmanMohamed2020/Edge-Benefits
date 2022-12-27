package org.labs247.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private final By homeLogo = By.xpath("//div[@class='ml-1']");
    private final By addNewRtqButton = By.xpath("//span[contains(text(),'New RTQ')]");
    private final By continueButton = By.xpath("//span[contains(text(),'Continue')]");


    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Step("Click on the + New RTQ button")
    public void clickOnNewRtqButton() {
        actionClick(addNewRtqButton);
    }

    @Step("Click on the Continue button")
    public void clickOnContinue() {
        actionClick(continueButton);
    }

    public boolean isLogoVisible() {
        return elementVisible(homeLogo);
    }

}

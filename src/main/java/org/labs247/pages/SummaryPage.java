package org.labs247.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SummaryPage extends BasePage{

    private final By headlineText = By.xpath("//h5[contains(text(),'Your quote request has been sent')]");
    private final By submitButton = By.xpath("//span[contains(text(),'Submit Request')]");
    private final By toastMessage = By.xpath("//div[@role='status']//child::div");

    public SummaryPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click on the Submit Request Button")
    public void clickSubmitButton() {
        actionClickByJS(submitButton);
    }

    public String getHeadLineText() {
        return findElement(headlineText).getText();
    }

    public String getToastMessage() {
        return findElement(toastMessage).getText();
    }
}

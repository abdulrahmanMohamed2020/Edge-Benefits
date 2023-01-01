package org.labs247.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PlanRequestPage extends BasePage{

    private final By productType = By.xpath("//div[contains(text(),'Disability Insurance (Guaranteed Issue - Injury Only)')]//parent::div//following-sibling::button");
    private final By addProductButton = By.xpath("//span[contains(text(),'Add Product')]");
    private final By nextButton = By.xpath("//span[contains(text(),'Next')]");

    public PlanRequestPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click on Disability Insurance (Guaranteed Issue - Injury Only)")
    public void clickOnProductType() {
        actionClickByJS(productType);
    }

    @Step("Click on the + Add Product button")
    public void clickOnAddProduct() {
        actionClickByJS(addProductButton);
    }

    @Step("Click on the Next Button")
    public void clickOnNextButton() {
        actionClick(nextButton);
    }

}

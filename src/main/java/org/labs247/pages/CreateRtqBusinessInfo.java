package org.labs247.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateRtqBusinessInfo extends BasePage{

    private final By companyNameField = By.id("company_name");
    private final By headOfficeProvinceDropDown = By.xpath("//div[contains(@role,'combobox')]");
    private final String headOfficeProvince = "//div[text()='@val']";
    private final By companyContactField = By.id("company_representative");
    private final By contactEmailAddressField = By.id("company_representative_email");
    private final By contactPhone = By.id("phone");
    //private final By applicantsRequireCoverage = By.xpath("");
    private final By benefitPlanCoverage = By.id("expected_applicants");
    private final By targetEffectiveDateMonth = By.xpath("//div[@role='button']");
    private final By targetEffectiveDateYear = By.xpath("//label[text()='Year']//following-sibling::input");

    public CreateRtqBusinessInfo(WebDriver driver) {
        super(driver);
    }

    @Step("Enter the Company Name")
    public void enterCompanyName(String companyName) {
        typeText(companyNameField,companyName);
    }

    @Step("Click on the Head Office Province drop-down menu")
    public void clickOnHeadOfficeProvince() {
        actionClick(headOfficeProvinceDropDown);
    }

    @Step("Select a Head Office Province from drop-down menu")
    public void selectHeadOfficeProvince(String province) {
        actionClick(By.xpath(headOfficeProvince.replace("@val",province)));
    }

    @Step("Enter the Company Contact")
    public void enterCompanyContact(String companyContact) {
        typeText(companyContactField,companyContact);
    }

    @Step("Enter the Contact's Email Address")
    public void enterContactEmail(String contactEmailAddress) {
        typeText(contactEmailAddressField,contactEmailAddress);
    }

    @Step("Enter the Contact's Phone")
    public void enterContactPhone(String phone) {
        typeText(contactPhone,phone);
    }

    @Step("Enter number in How many applicants will require coverage?")
    public void enterApplicantsNumber(String applicantsNumber) {
        typeText(benefitPlanCoverage,applicantsNumber);
    }
}

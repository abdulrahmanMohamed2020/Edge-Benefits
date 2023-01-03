package org.labs247.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BusinessInfoPage extends BasePage{

    private final By companyNameField = By.id("company_name");
    private final By headOfficeProvinceDropDown = By.xpath("//div[contains(@role,'combobox')]");
    private final String valueFromDropdown = "//div[text()='@val']";
    //private final String headOfficeProvinceStr = "//div[text()='@val']";
    private final By companyContactField = By.id("company_representative");
    private final By contactEmailAddressField = By.id("company_representative_email");
    private final By contactPhone = By.id("phone");
    private final String healthCoverageRadioButtonStr = "//div[@id='package.has_hd']//child::label[text()='@val']";
    private final By benefitPlanCoverage = By.id("expected_applicants");
    private final String samePlanForEveryoneRadioButtonStr = "//div[@id='package_has_groups']//child::label[text()='@val']";
    private final By targetEffectiveDateMonthDropDown = By.xpath("//div[@role='button']");
    private final By targetEffectiveDateYear = By.xpath("//label[text()='Year']//following-sibling::input");
    private final By nextButton = By.xpath("//button[@type='submit']");
    private final By toastMessage = By.xpath("//div[@role='status']//child::div");

    public BusinessInfoPage(WebDriver driver) {
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

    @Step("Select a {0} from drop-down menu")
    public void selectHeadOfficeProvince(String province) {
        actionClick(By.xpath(valueFromDropdown.replace("@val",province)));
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

    @Step("Select {0} from Will the benefit plan include Health & Dental coverage?")
    public void willIncludeHealthCoverage(String yseOrNo) {
        actionClick(By.xpath(healthCoverageRadioButtonStr.replace("@val",yseOrNo)));
    }

    @Step("Select {0} from Will the plan design be the same for everyone?")
    public void willPlanBeTheSameForEveryone(String yseOrNo) {
        actionClick(By.xpath(samePlanForEveryoneRadioButtonStr.replace("@val",yseOrNo)));
    }

    @Step("Enter {0} in How many applicants will require coverage?")
    public void enterApplicantsNumber(String applicantsNumber) {
        typeText(benefitPlanCoverage,applicantsNumber);
    }

    @Step("Click on the Months drop-down menu")
    public void clickOnMonthsDropDown() {
        actionClick(targetEffectiveDateMonthDropDown);
    }

    @Step("Select a {0} of Target Effective Date")
    public void selectMonth(String month) {
        actionClick(By.xpath(valueFromDropdown.replace("@val",month)));
    }

    @Step("Enter {0} in the Year of Target Effective Date")
    public void enterYear(String year) {
        WebElement element = findElement(targetEffectiveDateYear);
        element.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
        element.sendKeys(year);
    }

    @Step("Click on the Next Button")
    public void clickOnNextButton() {
        actionClick(nextButton);
    }

    public String getToastMessage() {
        return findElement(toastMessage).getText();
    }

}

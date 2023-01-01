package org.labs247.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddCensusDataPage extends BasePage{

    private final By submitIndividually = By.xpath("//h2[text()='Submit Individually']");
    private final By applicantNameField = By.id("applicant_name");
    private final By monthDropDown = By.xpath("//label[text()='Month']//parent::div//parent::div[@role='button']");
    private final By dayField = By.xpath("//label[text()='Day']//following-sibling::input");
    private final By yearField = By.xpath("//label[text()='Year']//following-sibling::input");
    private final By genderDropDown = By.xpath("//label[contains(text(),'Gender')]//following-sibling::div");
    private final By familyStatusDropDown = By.xpath("//label[contains(text(),'Family Status')]//following-sibling::div");
    private final By provinceOfResidenceDropDown = By.xpath("//label[contains(text(),'Province of Residence')]//following-sibling::div");
    private final By residencyStatusDropDown = By.xpath("//label[contains(text(),'Residency Status')]//following-sibling::div//child::div[@role='combobox']");
    private final String valueFromDropdownStr = "//div[text()='@val']";
    private final By saveApplicant = By.xpath("//span[contains(text(),'Save Applicant')]");
    private final By censusOptionsDropDown = By.xpath("//span[contains(text(),' Census Options ')]//parent::span//parent::button");
    private final By addNewApplicant = By.xpath("//div[contains(text(),'Add New Applicant')]");
    private final By nextButton = By.xpath("//span[contains(text(),'Next')]");

    public AddCensusDataPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click on the Submit Individually Model")
    public void clickOnSubmitIndividually() {
        actionClick(submitIndividually);
    }

    @Step("Enter the Applicant Name")
    public void enterApplicantName(String applicantName) {
        typeText(applicantNameField,applicantName);
    }

    @Step("Click on the Month drop-down menu")
    public void clickOnMonth() {
        actionClick(monthDropDown);
    }

    @Step("Select {0} from Months drop-down menu")
    public void selectMonth(String month) {
        actionClick(By.xpath(valueFromDropdownStr.replace("@val",month)));
    }

    @Step("Enter {0} in the Applicant Day of birth")
    public void enterDayOfBirth(String day) {
        typeText(dayField,day);
    }

    @Step("Enter {0} in the Applicant Year of birth")
    public void enterYearOfBirth(String year) {
        typeText(yearField,year);
    }

    @Step("Click on the Gender drop-down menu")
    public void clickOnGender() {
        actionClick(genderDropDown);
    }

    @Step("Select {0} from Gender drop-down menu")
    public void selectGender(String gender) {
        actionClick(By.xpath(valueFromDropdownStr.replace("@val",gender)));
    }

    @Step("Click on the Family Status drop-down menu")
    public void clickOnFamilyStatus() {
        actionClick(familyStatusDropDown);
    }

    @Step("Select {0} from Family Status drop-down menu")
    public void selectFamilyStatus(String familyStatus) {
        actionClick(By.xpath(valueFromDropdownStr.replace("@val",familyStatus)));
    }

    @Step("Click on the Province of Residence drop-down menu")
    public void clickOnProvinceOfResidence() {
        actionClick(provinceOfResidenceDropDown);
    }

    @Step("Select {0} from Province of Residence drop-down menu")
    public void selectProvince(String province) {
        actionClick(By.xpath(valueFromDropdownStr.replace("@val",province)));
    }

    @Step("Click on the Residency Status drop-down menu")
    public void clickOnResidencyStatus() {
        actionClick(residencyStatusDropDown);
    }

    @Step("Select {0} from Residency Status drop-down menu")
    public void selectResidencyStatus(String residencyStatus) {
        actionClick(By.xpath(valueFromDropdownStr.replace("@val",residencyStatus)));
    }

    @Step("Click on the Save button")
    public void clickOnSaveButton() {
        actionClick(saveApplicant);
    }

    @Step("Click on the Census Options drop-down menu")
    public void clickOnCensusOptions() {
        actionClick(censusOptionsDropDown);
    }

    @Step("Select Add New Applicant from Census Options drop-down menu")
    public void selectAddNewApplicant() {
        actionClick(addNewApplicant);
    }

    @Step("Click on the Next Button")
    public void clickOnNextButton() {
        actionClick(nextButton);
    }

}

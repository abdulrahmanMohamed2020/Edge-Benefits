package uitils;

import org.labs247.pages.*;
import org.openqa.selenium.WebDriver;
import tests.BaseTest;

import java.util.HashMap;

public class Helper extends BaseTest {

    private static BusinessInfoPage businessInfoPage;

    public static void loginToApp(WebDriver webDriver) {
        LoginPage loginPage = new LoginPage(webDriver);

        loginPage.enterUsername(Constants.VALID_USERNAME_ADVISOR);
        loginPage.enterPassword(Constants.CORRECT_PASSWORD);
        loginPage.clickOnSignIn();
    }

    public static void createNewRtq(WebDriver webDriver) {
        HomePage homePage = new HomePage(webDriver);

        homePage.clickOnNewRtqButton();
        homePage.clickOnContinue();
    }

    public static void createBusinessInfo(WebDriver webDriver) {
        businessInfoPage = new BusinessInfoPage(webDriver);
        HashMap<String,String> testData = GenerateTestData.createBusinessTestData();

        businessInfoPage.enterCompanyName(testData.get("companyName"));
        businessInfoPage.clickOnHeadOfficeProvince();
        businessInfoPage.selectHeadOfficeProvince(testData.get("headOfficeProvince"));
        businessInfoPage.enterCompanyContact(testData.get("companyContactName"));
        businessInfoPage.enterContactEmail(testData.get("companyContactEmail"));
        businessInfoPage.enterContactPhone(testData.get("companyContactPhone"));
        businessInfoPage.willIncludeHealthCoverage(testData.get("includeCoverage"));
        businessInfoPage.enterApplicantsNumber(testData.get("applicantsNumber"));
        businessInfoPage.willPlanBeTheSameForEveryone(testData.get("willPlanBeTheSameForEveryone"));
        businessInfoPage.clickOnMonthsDropDown();
        businessInfoPage.selectMonth(testData.get("month"));
        businessInfoPage.enterYear(testData.get("year"));
        businessInfoPage.clickOnNextButton();
    }

    public static void createCensusData(WebDriver webDriver) {
        AddCensusDataPage addCensusDataPage = new AddCensusDataPage(webDriver);
        addCensusDataPage.clickOnSubmitIndividually();

        HashMap<String,String> testData;

        for (int i=0 ; i<3 ; i++) {
            testData = GenerateTestData.createCensusTestData();
            addCensusDataPage.enterApplicantName(testData.get("applicantName"));
            addCensusDataPage.clickOnMonth();
            addCensusDataPage.selectMonth(testData.get("month"));
            addCensusDataPage.enterDayOfBirth(testData.get("dayOfBirth"));
            addCensusDataPage.enterYearOfBirth(testData.get("yearOfBirth"));
            addCensusDataPage.clickOnGender();
            addCensusDataPage.selectGender(testData.get("gender"));
            addCensusDataPage.clickOnFamilyStatus();
            addCensusDataPage.selectFamilyStatus(testData.get("familyStatus"));
            addCensusDataPage.clickOnProvinceOfResidence();
            addCensusDataPage.selectProvince(testData.get("province"));
            addCensusDataPage.clickOnResidencyStatus();
            addCensusDataPage.selectResidencyStatus(testData.get("residencyStatus"));
            addCensusDataPage.clickOnSaveButton();
            if (i<2) {
                addCensusDataPage.clickOnCensusOptions();
                addCensusDataPage.selectAddNewApplicant();
            }
        }
        addCensusDataPage.clickOnNextButton();
    }

    public static void selectPlan(WebDriver webDriver) {
        PlanRequestPage planRequestPage = new PlanRequestPage(webDriver);

        planRequestPage.clickOnProductType();
        planRequestPage.clickOnAddProduct();
        planRequestPage.clickOnNextButton();
    }

    public static String getToastMessage() {
        return businessInfoPage.getToastMessage();
    }
}

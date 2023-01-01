package tests;

import org.labs247.pages.*;
import org.testng.annotations.Test;
import uitils.Constants;

import static org.testng.Assert.assertEquals;

public class CreateRtqBusinessInfoTest extends BaseTest{

    private CreateRtqBusinessInfo createRtqBusinessInfo;
    private LoginPage loginPage;
    private HomePage homePage;
    private AddCensusDataPage addCensusDataPage;
    private PlanRequestPage planRequestPage;
    private SummaryPage summaryPage;

    @Test(description = "Verify that there is an error message when the username is empty")
    public void testTest(){
        loginPage = new LoginPage(getDriver());

        loginPage.enterUsername(Constants.VALID_USERNAME_ADVISOR);
        loginPage.enterPassword(Constants.CORRECT_PASSWORD);
        loginPage.clickOnSignIn();

        homePage = new HomePage(getDriver());

        homePage.clickOnNewRtqButton();
        homePage.clickOnContinue();

        createRtqBusinessInfo = new CreateRtqBusinessInfo(getDriver());

        createRtqBusinessInfo.enterCompanyName("Test");
        createRtqBusinessInfo.clickOnHeadOfficeProvince();
        createRtqBusinessInfo.selectHeadOfficeProvince("Ontario");
        createRtqBusinessInfo.enterCompanyContact("Ahmed");
        createRtqBusinessInfo.enterContactEmail("abdo1@test.com");
        createRtqBusinessInfo.enterContactPhone("(3423143431");
        createRtqBusinessInfo.willIncludeHealthCoverage("No");
        createRtqBusinessInfo.enterApplicantsNumber("3");
        createRtqBusinessInfo.willPlanBeTheSameForEveryone("Yes");
        createRtqBusinessInfo.clickOnMonthsDropDown();
        createRtqBusinessInfo.selectMonth("November");
        createRtqBusinessInfo.enterYear("2024");
        createRtqBusinessInfo.clickOnNextButton();

        assertEquals(createRtqBusinessInfo.getToastMessage(),"Request was created successfully");

        addCensusDataPage = new AddCensusDataPage(getDriver());
        getDriver().manage().window().maximize();

        addCensusDataPage.clickOnSubmitIndividually();

        for (int i=0 ; i<3 ; i++) {
            addCensusDataPage.enterApplicantName("Abdo");
            addCensusDataPage.clickOnMonth();
            addCensusDataPage.selectMonth("March");
            addCensusDataPage.enterDayOfBirth("14");
            addCensusDataPage.enterYearOfBirth("1997");
            addCensusDataPage.clickOnGender();
            addCensusDataPage.selectGender("Male");
            addCensusDataPage.clickOnFamilyStatus();
            addCensusDataPage.selectFamilyStatus("Couple");
            addCensusDataPage.clickOnProvinceOfResidence();
            addCensusDataPage.selectProvince("Ontario");
            addCensusDataPage.clickOnResidencyStatus();
            addCensusDataPage.selectResidencyStatus("Canadian Citizen");
            addCensusDataPage.clickOnSaveButton();
            if (i<2) {
                addCensusDataPage.clickOnCensusOptions();
                addCensusDataPage.selectAddNewApplicant();
            }
        }
        addCensusDataPage.clickOnNextButton();

        planRequestPage = new PlanRequestPage(getDriver());

        planRequestPage.clickOnProductType();
        planRequestPage.clickOnAddProduct();
        planRequestPage.clickOnNextButton();

        summaryPage = new SummaryPage(getDriver());

        summaryPage.clickSubmitButton();

        assertEquals(summaryPage.getHeadLineText(),"Your quote request has been sent");

    }
}

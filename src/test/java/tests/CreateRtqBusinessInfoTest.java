package tests;

import org.labs247.pages.CreateRtqBusinessInfo;
import org.labs247.pages.HomePage;
import org.labs247.pages.LoginPage;
import org.testng.annotations.Test;
import uitils.Constants;

import static org.testng.Assert.assertEquals;

public class CreateRtqBusinessInfoTest extends BaseTest{

    private CreateRtqBusinessInfo createRtqBusinessInfo;
    private LoginPage loginPage;
    private HomePage homePage;

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
        createRtqBusinessInfo.enterApplicantsNumber("4");
        createRtqBusinessInfo.willPlanBeTheSameForEveryone("Yes");
        createRtqBusinessInfo.clickOnMonthsDropDown();
        createRtqBusinessInfo.selectMonth("November");
        createRtqBusinessInfo.enterYear("2024");
        createRtqBusinessInfo.clickOnNextButton();

        assertEquals(createRtqBusinessInfo.getToastMessage(),"Request was created successfully");
    }
}

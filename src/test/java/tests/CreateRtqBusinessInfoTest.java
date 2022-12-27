package tests;

import org.labs247.pages.CreateRtqBusinessInfo;
import org.labs247.pages.HomePage;
import org.labs247.pages.LoginPage;
import org.testng.annotations.Test;
import uitils.Constants;

import static org.testng.Assert.assertEquals;

public class CreateRtqBusinessInfoTest extends BaseTest{

    CreateRtqBusinessInfo createRtqBusinessInfo;
    LoginPage loginPage;
    HomePage homePage;

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

        createRtqBusinessInfo.enterCompanyName("Abdo");
        createRtqBusinessInfo.clickOnHeadOfficeProvince();
        createRtqBusinessInfo.selectHeadOfficeProvince("Ontario");
        createRtqBusinessInfo.enterCompanyContact("Helal");
        createRtqBusinessInfo.enterContactEmail("hela@test.com");
        createRtqBusinessInfo.enterContactPhone("1212112212");
        createRtqBusinessInfo.enterApplicantsNumber("8");

        assertEquals(loginPage.getErrorMessage(),"This field may not be blank.");
    }
}

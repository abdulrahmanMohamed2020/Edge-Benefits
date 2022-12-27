package tests;

import org.labs247.pages.HomePage;
import org.labs247.pages.LoginPage;
import org.testng.annotations.Test;
import uitils.Constants;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest{

    private LoginPage loginPage;

    @Test(description = "Verify the user is redirected to the Home page when entering valid Credentials")
    public void loginWithValidCredentials(){
        loginPage = new LoginPage(getDriver());

        loginPage.enterUsername(Constants.VALID_USERNAME_ADVISOR);
        loginPage.enterPassword(Constants.CORRECT_PASSWORD);
        loginPage.clickOnSignIn();

        assertTrue(new HomePage(getDriver()).isLogoVisible(),"The Logo is not displayed on home page");
        assertEquals(getDriver().getCurrentUrl(),"https://edgedev.edgebenefits.com/portal/advisor/quotes/multi-life");
    }

    @Test(description = "Verify that there is an error message when the username is empty")
    public void loginWithEmptyUsername(){
        loginPage = new LoginPage(getDriver());

        loginPage.enterUsername("");
        loginPage.enterPassword(Constants.CORRECT_PASSWORD);
        loginPage.clickOnSignIn();

        assertEquals(loginPage.getErrorMessage(),"This field may not be blank.");
    }

    @Test(description = "Verify that there is an error message when the password is empty")
    public void loginWithEmptyPassword(){
        loginPage = new LoginPage(getDriver());

        loginPage.enterUsername(Constants.VALID_USERNAME_SC);
        loginPage.enterPassword("");
        loginPage.clickOnSignIn();

        assertEquals(loginPage.getErrorMessage(),"This field may not be blank.");
    }
}

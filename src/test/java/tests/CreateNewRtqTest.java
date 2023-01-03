package tests;

import org.labs247.pages.*;
import org.testng.annotations.Test;
import uitils.Helper;

import static org.testng.Assert.assertEquals;

public class CreateNewRtqTest extends BaseTest{

    @Test(description = "Verify that the user can create RTQ")
    public void verifyCreateRtq(){
        Helper.loginToApp(getDriver());
        Helper.createNewRtq(getDriver());
        Helper.createBusinessInfo(getDriver());

        assertEquals(Helper.getToastMessage(),"Request was created successfully");

        Helper.createCensusData(getDriver());
        Helper.selectPlan(getDriver());

        SummaryPage summaryPage = new SummaryPage(getDriver());

        summaryPage.clickSubmitButton();

        assertEquals(summaryPage.getHeadLineText(),"Your quote request has been sent");
    }
}

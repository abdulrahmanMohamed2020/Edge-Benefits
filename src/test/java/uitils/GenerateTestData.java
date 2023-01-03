package uitils;

import com.github.javafaker.Faker;

import java.util.HashMap;

public class GenerateTestData {

    private static final Faker faker = new Faker();

    public static HashMap<String,String> createCensusTestData() {
        HashMap<String,String> testData = new HashMap<>();

        testData.put("applicantName",faker.name().firstName());
        testData.put("month","March");
        testData.put("dayOfBirth", String.valueOf(faker.number().numberBetween(1,30)));
        testData.put("yearOfBirth", String.valueOf(faker.number().numberBetween(1953,2004)));
        if(faker.number().numberBetween(0,3) == 0)
            testData.put("gender","Male");
        else
            testData.put("gender","Female");
        testData.put("familyStatus","Couple");
        testData.put("province","Ontario");
        testData.put("residencyStatus","Canadian Citizen");

        return testData;
    }

    public static HashMap<String ,String> createBusinessTestData() {
        HashMap<String ,String> testData = new HashMap<>();

        testData.put("companyName",faker.name().name());
        testData.put("headOfficeProvince","Ontario");
        testData.put("companyContactName",faker.name().firstName());
        testData.put("companyContactEmail",faker.internet().emailAddress());
        testData.put("companyContactPhone",faker.phoneNumber().subscriberNumber(10));
        testData.put("includeCoverage","No");
        testData.put("applicantsNumber","3");
        testData.put("willPlanBeTheSameForEveryone","Yes");
        testData.put("month","November");
        testData.put("year", String.valueOf(faker.number().numberBetween(2023,2050)));

        return testData;
    }
}

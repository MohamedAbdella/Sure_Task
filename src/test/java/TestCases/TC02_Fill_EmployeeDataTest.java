package TestCases;

import APITestCases.AddEmployeeTest;
import BaseTest.baseTest;
import Pages.*;
import Utalities.ContactDetails;
import Utalities.TestDataReader;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Listeners.TestListeners;

import java.nio.file.Paths;

@Listeners(TestListeners.class)
public class TC02_Fill_EmployeeDataTest extends baseTest {

    private ContactDetails contactDetails;
    private static final String FILE_PATH = Paths.get("test-data/sample-pdf-file.pdf").toAbsolutePath().toString();


    @Test(priority = 0)
    public void User_Can_Login_With_Valid_Data() {
        String URL_Of_HomePage = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
        P01_LoginPage loginPage = new P01_LoginPage(driver);
        loginPage.login("Admin", "admin123");
        P02_HomePage homePage = new P02_HomePage(driver);
        Assert.assertTrue(homePage.Get_URL_Of_HomePage().contains(URL_Of_HomePage));
    }

    @Test(priority = 1)
    public void User_SearchFor_Employee_And_NavigateTo_AddInfo() {
        P02_HomePage homePage = new P02_HomePage(driver);
        P03_PimPage pimPage = homePage.User_NavigateTo_PimPage();
        P04_PersonaldetailsPage personaldetailsPage = pimPage.User_NavigateTo_Edit_Employee(AddEmployeeTest.empId);
        Assert.assertTrue(personaldetailsPage.Is_Page_Appeared());
    }

    @Test(priority = 2)
    public void User_Add_His_ContactDetails() throws InterruptedException {
        P04_PersonaldetailsPage personaldetailsPage = new P04_PersonaldetailsPage(driver);
        personaldetailsPage.User_NavigateTo_ContactDetailsPage();
        Thread.sleep(2000);
        // Load the JSON data into the ContactDetails object
        contactDetails = TestDataReader.getContactDetails("test-data/ContactDetails.json");
        if (contactDetails == null) {
            throw new RuntimeException("Failed to load contact details data. Check the JSON file.");
        }
        P05_ContactDetailsPage contactDetailsPage = new P05_ContactDetailsPage(driver);
        contactDetailsPage.fillContactDetails(contactDetails);
        Assert.assertTrue(contactDetailsPage.Is_ValidatiomMessage_Appears());
        contactDetailsPage.uploadAttachment(FILE_PATH);
        Assert.assertTrue(contactDetailsPage.Is_ValidatiomMessage_Appears());
        Assert.assertTrue(contactDetailsPage.newRecordIsAdded());
    }


}

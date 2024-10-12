package TestCases;

import BaseTest.baseTest;
import Pages.P01_LoginPage;
import Pages.P02_HomePage;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC01_LoginTest extends baseTest {

    @Test(priority = 0)
    public void User_Can_Login_With_Valid_Data() {
        String URL_Of_HomePage = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
        P01_LoginPage loginPage = new P01_LoginPage(driver);
        loginPage.login("Admin", "admin123");
        P02_HomePage homePage = new P02_HomePage(driver);
        Assert.assertTrue(homePage.Get_URL_Of_HomePage().contains(URL_Of_HomePage));
    }

    @Test(priority = 1)
    public void User_Login_With_Invalid_Data() {
        Faker fakeData = new Faker();  //Use faker class to generate random data
        String userName = fakeData.name().username();
        String pass = fakeData.number().digits(5).toString();
        P01_LoginPage loginPage = new P01_LoginPage(driver);
        loginPage.login(userName, pass);
        Assert.assertTrue(loginPage.get_Validatio_Message_When_Login_With_Invalid_Data().contains("Invalid credentials"));
    }
}
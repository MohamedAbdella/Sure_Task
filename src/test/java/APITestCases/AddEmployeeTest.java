package APITestCases;

import BaseTest.baseTest;
import Pages.P01_LoginPage;
import Utalities.EmployeeData;
import Utalities.TestDataReader;
import io.restassured.response.Response;
import org.openqa.selenium.Cookie;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class AddEmployeeTest extends baseTest {
    private EmployeeData employeeData;
    private String authCookie;
    private String empNumber;
    public static String empId;
    @BeforeClass
    public void setupData() throws InterruptedException {
        P01_LoginPage loginPage = new P01_LoginPage(driver);
        loginPage.login("Admin", "admin123");
        Thread.sleep(2000);
        // Step 2: Get cookies after login
        Cookie cookie = driver.manage().getCookieNamed("orangehrm");
        if (cookie != null) {
            authCookie = cookie.getValue();
        }
        employeeData = new EmployeeData();

    }

    @Test(priority = 1)
    public void testAddEmployee() {
        Response response = given()
                .header("Content-Type", "application/json")
                .cookie("orangehrm", authCookie)
                .body(employeeData.getEmployee())
                .post("pim/employees");

        response.then().statusCode(200).log().all();
         empNumber = response.jsonPath().getString("data.empNumber");
        empId = response.jsonPath().getString("data.employeeId");
    }

    @Test(priority = 2, dependsOnMethods = {"testAddEmployee"})
    public void testAddPersonalDetails() {
        given()
                .header("Content-Type", "application/json")
                .cookie("orangehrm", authCookie)
                .body(employeeData.getPersonalDetails())
                .put("pim/employees/" + empNumber + "/personal-details")
                .then()
                .log().all()
                .statusCode(200)
                .body("data.empNumber", equalTo(Integer.parseInt(empNumber)));


    }
}

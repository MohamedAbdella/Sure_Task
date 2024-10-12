package Pages;

import BasePage.basePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class P03_PimPage extends basePage {

    private WebDriver driver;
    JavascriptExecutor js = (JavascriptExecutor) driver;
    private By employeeNumField = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
    private By searchBtn = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']");
    private By editBtn = By.xpath("//i[@class='oxd-icon bi-pencil-fill']");


    public P03_PimPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;
    }

    public P04_PersonaldetailsPage User_NavigateTo_Edit_Employee(String empNumber) {

        waitForVisibility(driver.findElement(employeeNumField));
        driver.findElement(employeeNumField).sendKeys(empNumber);
        driver.findElement(searchBtn).click();
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(editBtn));
        waitForVisibility(driver.findElement(editBtn));
        driver.findElement(editBtn).click();
        return new P04_PersonaldetailsPage(driver);
    }


}

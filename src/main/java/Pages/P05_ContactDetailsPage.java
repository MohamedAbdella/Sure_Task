package Pages;

import BasePage.basePage;
import Utalities.ContactDetails;
import Utalities.TestDataReader;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.time.Duration;

public class P05_ContactDetailsPage extends basePage {
    private WebDriver driver;
    JavascriptExecutor js = (JavascriptExecutor) driver;
    private By street1Field = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
    private By Street2Field = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
    private By cityField = By.xpath("(//input[@class='oxd-input oxd-input--active'])[3]");
    private By stateField = By.xpath("(//input[@class='oxd-input oxd-input--active'])[4]");
    private By zipCodeField = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div[5]/div/div[2]/input");
    private By mobileField = By.xpath("(//input[@class='oxd-input oxd-input--active'])[8]");
    private By emailField = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[3]/div/div[1]/div/div[2]/input");
    private By saveBtn = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']");
    private By successMessage = By.xpath("//div[@class='oxd-toast oxd-toast--success oxd-toast-container--toast']");
    private By addAttcahmentBtn = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--text']");
    private By broswebtn = By.cssSelector("input[type='file']");
    private By saveBtn2 = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[2]/div/form/div[3]/button[2]");
    private By gridRow = By.cssSelector("div[role='row']");
    private By JopDetailsLink = By.linkText("Job");


    public P05_ContactDetailsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;
    }

    public void fillContactDetails(ContactDetails details) throws InterruptedException {
        Faker faker = new Faker();
        driver.findElement(street1Field).sendKeys(details.getStreet1());
        driver.findElement(Street2Field).sendKeys(details.getStreet2());
        driver.findElement(cityField).sendKeys(details.getCity());
        driver.findElement(stateField).sendKeys(details.getState());
        driver.findElement(zipCodeField).sendKeys(details.getZipCode());
        driver.findElement(mobileField).sendKeys(details.getMobilePhone());
        driver.findElement(emailField).sendKeys(faker.internet().emailAddress());
        Thread.sleep(1000);
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(saveBtn));
        waitForElementToBeClickable(driver.findElement(saveBtn));
        driver.findElement(saveBtn).click();
    }

    public void uploadAttachment(String filePath) {
        driver.findElement(addAttcahmentBtn).click();
        File uploadFile = new File("test-data/sample-pdf-file.pdf");
        driver.findElement(broswebtn).sendKeys(uploadFile.getAbsolutePath());
        driver.findElement(saveBtn2).click();
    }

    public Boolean Is_ValidatiomMessage_Appears() {
        waitForVisibility(driver.findElement(successMessage));
        return driver.findElement(successMessage).isDisplayed();
    }

    public boolean newRecordIsAdded() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        return driver.findElement(gridRow).isDisplayed();
    }

    public P05_JobDetailsPage User_NavigateTo_JobDetailsPage() {
        driver.findElement(JopDetailsLink).click();
        return new P05_JobDetailsPage(driver);
    }


}

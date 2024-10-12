package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class P04_PersonaldetailsPage {
    private WebDriver driver;
    private By pageTitle = By.linkText("Personal Details");
    private By contactDetails_Link = By.xpath("//a[contains(@class, 'orangehrm-tabs-item') and text()='Contact Details']");


    public P04_PersonaldetailsPage(WebDriver driver) {
        this.driver = driver;

    }

    public Boolean Is_Page_Appeared() {
        return driver.findElement(pageTitle).isDisplayed();
    }

    public P05_ContactDetailsPage User_NavigateTo_ContactDetailsPage() {
        driver.findElement(contactDetails_Link).click();
        return new P05_ContactDetailsPage(driver);
    }
}

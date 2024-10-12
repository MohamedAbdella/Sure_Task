package Pages;

import BasePage.basePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P01_LoginPage  {

    private WebDriver driver;
    private By userNameField = By.name("username");
    private By passField=By.name("password");
    private By loginBtn=By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']");
    private By ValidationMessage=By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']");

    public P01_LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public P02_HomePage login(String username, String password) {
        driver.findElement(userNameField).sendKeys(username);
        driver.findElement(passField).sendKeys(password);
        driver.findElement(loginBtn).click();
        return new P02_HomePage(driver);
    }

    public String get_Validatio_Message_When_Login_With_Invalid_Data() {
        return driver.findElement(ValidationMessage).getText();
    }



}

package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P02_HomePage {

    private WebDriver driver;
    private By PimBtn= By.xpath("//a[contains(@class, 'oxd-main-menu-item') and contains(@href, 'pim/viewPimModule')]\n");


    public P02_HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public P03_PimPage User_NavigateTo_PimPage(){
        driver.findElement(PimBtn).click();
        return new P03_PimPage(driver);
    }


    public String Get_URL_Of_HomePage(){
        return driver.getCurrentUrl();
    }
}

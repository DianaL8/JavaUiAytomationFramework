package online.tekwill.pageobjects;

import online.tekwill.managers.ScrollManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends Page{
    public AccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
    private WebElement logOutBtn;

    public void logOutTheAccount(){
        ScrollManager.scrollToElement(logOutBtn);
        logOutBtn.click();
        System.out.println("The user is logged out!");
    }
}
package online.tekwill.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Page{
    public LoginPage(WebDriver driver){
        super(driver);
    }


    @FindBy(css = "#input-email")
    private WebElement emailInput;

    @FindBy(css = "#input-passwor")
    private WebElement passwordInput;

    @FindBy(css = "button[type='submit']")
    private WebElement loginBtn;

    public void completeLoginForm(String email, String password){
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
    }

    public void clickTheLoginBtn(){
        clickTheLoginBtn();
    }
}

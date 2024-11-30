package online.tekwill;

import online.tekwill.managers.DriverManager;
import online.tekwill.managers.RandomDataManager;
import online.tekwill.pageobjects.AccountPage;
import online.tekwill.pageobjects.HomePage;
import online.tekwill.pageobjects.LoginPage;
import online.tekwill.pageobjects.RegisterPage;
import org.openqa.selenium.WebDriver;

public class TestRunnerWithPageObjects {
    public static void main(String[] args) {

        WebDriver driver = DriverManager.getInstance().getDriver();
        driver.get("https://tekwillacademy-opencart.online/");

        HomePage homePage = new HomePage(driver);

        homePage.navigateRegisterPage();

        RegisterPage registerPage = new RegisterPage(driver);

        // Generate random data
        String firstname = RandomDataManager.getRandomFirstName();
        String lastName = RandomDataManager.getRandomLastName();
        String email = RandomDataManager.getRandomEmail();
        String password = RandomDataManager.getRandomPassword();

        // Actions on the Register page
        registerPage.completeTheRegisterForm(firstname, lastName, email, password);
        registerPage.enableTheToggleBar();
        registerPage.clickOnTheContinueBtn();

        Thread.sleep(5000);

        // Account related actions
        AccountPage accountPage = new AccountPage(driver);
        accountPage.logOutTheAccount();

        homePage.navigateToLoginPage();
        Thread.sleep(6000);

        // Login page related actions
        LoginPage loginPage = new LoginPage(driver);
        loginPage.completeLoginForm(email, password);
        loginPage.clickTheLoginBtn();

        Thread.sleep(4000);

        driver.quit();

    }
}

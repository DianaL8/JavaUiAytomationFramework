package online.tekwill;

import online.tekwill.managers.DriverManager;
import online.tekwill.managers.RandomDataManager;
import online.tekwill.pageobjects.AccountPage;
import online.tekwill.pageobjects.HomePage;
import online.tekwill.pageobjects.LoginPage;
import online.tekwill.pageobjects.RegisterPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

public class RegisterFlowWithJunit {

    private WebDriver driver;
    private HomePage homePage;
    private RegisterPage registerPage;



    @BeforeAll
    public static void beforeAllTheTest(){
        System.out.println("This methods is run before all te tests from this class");
    }

    @BeforeEach
    public void beforeEachTest(){
        WebDriver driver = DriverManager.getInstance().getDriver();
        driver.get("https://tekwillacademy-opencart.online/");
        HomePage homePage = new HomePage(driver);
        homePage.navigateRegisterPage();
        registerPage = new RegisterPage(driver);
    }


    @Test
    @DisplayName("User is redirected to Account page when registering with valid data.")
    public void registerFlowWithValidDataRedirectsTheUserToAccountPage() throws InterruptedException {
        //WebDriver driver = DriverManager.getInstance().getDriver();
        // driver.get("https://tekwillacademy-opencart.online/");

        //HomePage homePage = new HomePage(driver);

        //homePage.navigateRegisterPage();

        // Generate random data
        String firstname = RandomDataManager.getRandomFirstName();
        String lastName = RandomDataManager.getRandomLastName();
        String email = RandomDataManager.getRandomEmail();
        String password = RandomDataManager.getRandomPassword();

        // Actions on the Register page
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.completeTheRegisterForm(firstname, lastName, email, password);
        registerPage.enableTheToggleBar();
        registerPage.clickOnTheContinueBtn();

        Thread.sleep(5000);

        boolean urlContainSuccessKeyword = driver.getCurrentUrl().contains("success");
        Assertions.assertTrue(urlContainSuccessKeyword, "The URL of the page contains the Success keyword. ");

        // Account related actions
        //AccountPage accountPage = new AccountPage(driver);
        //accountPage.logOutTheAccount();

       // homePage.navigateToLoginPage();
       // Thread.sleep(6000);

        // Login page related actions
        //LoginPage loginPage = new LoginPage(driver);
        //loginPage.completeLoginForm(email, password);
        //loginPage.clickTheLoginBtn();

        //Thread.sleep(4000);

        //DriverManager.getInstance().quitTheDriver();
    }

    @Test
    @DisplayName("The user remains on the Register page when registering without accepting privacy rules");
    public void userRemainOnRegisterPageWhenRegisteringWithoutAcceptingPrivacyRules() throws InterruptedException {
        public void registerFlowWithValidDataRedirectsTheUserToAccountPage() throws InterruptedException {
            //WebDriver driver = DriverManager.getInstance().getDriver();
            //driver.get("https://tekwillacademy-opencart.online/");

            //HomePage homePage = new HomePage(driver);

            //homePage.navigateRegisterPage();

            // Generate random data
            String firstname = RandomDataManager.getRandomFirstName();
            String lastName = RandomDataManager.getRandomLastName();
            String email = RandomDataManager.getRandomEmail();
            String password = RandomDataManager.getRandomPassword();

            // Actions on the Register page
            RegisterPage registerPage = new RegisterPage(driver);
            registerPage.completeTheRegisterForm(firstname, lastName, email, password);
            // registerPage.enableTheToggleBar();
            registerPage.clickOnTheContinueBtn();

            Assertions.assertTrue(driver.getCurrentUrl().contains("register"));

            //DriverManager.getInstance().quitTheDriver();
    }


    @Test
    @DisplayName("Navigate to Login page from Register page.")
    public void navigateToLoginPageFromRegisterPage(){
            registerPage.navigateToLoginPage();
            Assertions.assertTrue(driver.getCurrentUrl().contains("login"));
        }


    @AfterEach
    public void afterEachTest(){
            DriverManager.getInstance().quitTheDriver();
        }


    @AfterAll
    public static void afterAllTheTests(){
            System.out.println("This methods is executed after all the tests.");
        }
}



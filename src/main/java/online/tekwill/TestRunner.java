package online.tekwill;

import online.tekwill.managers.DriverManager;
import online.tekwill.managers.RandomDataManager;
import online.tekwill.managers.ScrollManager;
import org.openqa.selenium.*;

public class TestRunner {
    public static void main(String[] args) {
        // System.out.println("Hello world!");

        //DriverManager.getInstance().getDriver().get("https://www.google.com/");
        WebDriver driver = DriverManager.getInstance().getDriver();
        driver.get("https://www.google.com/");
        System.out.println("The diver is on page: "+ driver.getCurrentUrl());

        String theNameOfTheFirstTab = driver.getWindowHandle();

        // Open a new window and navigate to diez page
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://tekwillacademy-opencart.online/");
        System.out.println("The diver is on page: "+ driver.getCurrentUrl());


        WebElement myAccountDropDownIcon = driver.findElement(By.xpath("//i[@class='fa-solid fa-user']"));
        myAccountDropDownIcon.click();

        WebElement registerLink = driver.findElement(By.xpath("//a[normalize-space()='Register']"));
        registerLink.click();

        // Print the url of a new page
        System.out.println("The diver is on page: "+ driver.getCurrentUrl());

        WebElement firstNameInput = driver.findElement(By.id("input-firstname"));
        firstNameInput.sendKeys(RandomDataManager.getRandomFirstName());

        WebElement lastNameInput = driver.findElement(By.id("input-lastname"));
        lastNameInput.sendKeys(RandomDataManager.getRandomLastName());

        WebElement emailInput = driver.findElement(By.id("input-email"));
        String emailData = RandomDataManager.getRandomEmail();
        System.out.println("Email: " + emailData);
        emailInput.sendKeys(emailData);
        //emailInput.sendKeys(RandomDataManager.getRandomEmail());

        WebElement passWordInput = driver.findElement(By.cssSelector("#input-password"));
        String passwordData = RandomDataManager.getRandomPassword();
        System.out.println("Password: " + passwordData);
        passWordInput.sendKeys(passwordData);

        WebElement privacyToggleBar = driver.findElement(By.name("agree"));
        ScrollManager.scrollToElement(privacyToggleBar);


        //privacyToggleButton.click();


        WebElement continueButton =driver.findElement(By.cssSelector("button[type='submit']"));
        continueButton.click();
        System.out.println("The diver is on page: "+ driver.getCurrentUrl());



        // Thread.sleep("5000");
        // Close the current tab
        driver.close();

        driver.switchTo().window(theNameOfTheFirstTab);
        // driver.get("https://www.stiri.md");
        System.out.println("The diver is on page: "+ driver.getCurrentUrl());
        // Thread.sleep("3000");
        driver.quit();
    }
}
//DriverManager.getInstance().getDriver().quit();
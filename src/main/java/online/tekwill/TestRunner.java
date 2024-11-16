package online.tekwill;

import online.tekwill.managers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

public class TestRunner {
    public static void main(String[] args) {
        // System.out.println("Hello world!");

        //DriverManager.getInstance().getDriver().get("https://www.google.com/");
        WebDriver driver = DriverManager.getInstance().getDriver();
        driver.get("https://www.google.com/");

        String theNameOfTheFirstTab = driver.getWindowHandle();

        // Open a new window and navigate to diez page
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://diez.md/");
        Thread.sleep("5000");
        // Close the current tab
        driver.close();

        driver.switchTo().window(theNameOfTheFirstTab);
        driver.get("https://www.stiri.md");
        Thread.sleep("3000");
        driver.quit();
    }
}
//DriverManager.getInstance().getDriver().quit();
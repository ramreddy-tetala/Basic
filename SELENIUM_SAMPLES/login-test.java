/*
 * Example Selenium Test: Login Test
 * Author: [Your Name]
 * Date: [Today's Date]
 * 
 * This test demonstrates a simple login scenario using Selenium WebDriver and JUnit.
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.*;

public class LoginTest {

    private WebDriver driver;
    private static final String BASE_URL = "https://app.example.com/login";
    private static final String USERNAME = "johndoe@example.com";
    private static final String PASSWORD = "MySecurePassword!123";

    @Before
    public void setUp() {
        // Set WebDriver path if necessary, e.g.:
        // System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testSuccessfulLogin() {
        driver.get(BASE_URL);

        // Locate input fields and login button
        WebElement usernameInput = driver.findElement(By.id("username")); // adjust ID as per your app
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement loginButton   = driver.findElement(By.id("loginButton"));

        // Perform login actions
        usernameInput.sendKeys(USERNAME);
        passwordInput.sendKeys(PASSWORD);
        loginButton.click();

        // Wait for successful login indication (e.g., dashboard or profile)
        // Replace with appropriate wait as needed (could use WebDriverWait)
        try {
            Thread.sleep(2000); // For demo only. Prefer WebDriverWait in real tests.
        } catch (InterruptedException e) {
            // Handle exception
        }

        // Validation: Check user is redirected to dashboard (replace locator as needed)
        assertTrue("Login success indicator is not displayed.",
            driver.findElement(By.id("dashboardHome")).isDisplayed()
        );
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

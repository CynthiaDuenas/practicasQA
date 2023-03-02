import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SwagLabsTests {

    private WebDriver driver;

    @BeforeTest
    public void beforeTest() {
        System.setProperty("webdriver.chrome.drive", "./chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");

    }

    @AfterTest
    public void afterTest() {
        driver.close();
        driver.quit();
    }

    @Test
    public void login() throws InterruptedException {
        WebElement login_txtUsername = driver.findElement(By.id("user-name"));
        WebElement login_textPass = driver.findElement(By.id("password"));
        WebElement login_btnLogin = driver.findElement(By.id("login-button"));

        login_txtUsername.sendKeys("standard_user");
        login_textPass.sendKeys("secret_sauce");
        login_btnLogin.click();

        TimeUnit.SECONDS.sleep(4);

        WebElement products_spanTitle =
                driver.findElement(By.xpath("//div[@class='header_secondary_container']/span[@class='title']"));
        assert(products_spanTitle.isDisplayed());

    }
}

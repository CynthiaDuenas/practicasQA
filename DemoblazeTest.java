import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class DemoblazeTest {

    private WebDriver driver;

    @BeforeTest
    public void beforeTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.drive", "./chromedriver");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.demoblaze.com/index.html");

    }

    @AfterTest
    public void afterTest() {
        driver.close();
        driver.quit();
    }

    @Test
    public void selecArticle() throws InterruptedException {

        //pagina principal
        WebElement search_Phone=driver.findElement(By.id("itemc"));
        search_Phone.click();
        TimeUnit.SECONDS.sleep(2);

        //Elegir Producto 1
        WebElement selecPhone=driver.findElement(By.xpath("//div[@id='tbodyid']//following::a"));
        selecPhone.click();
        TimeUnit.SECONDS.sleep(2);
        WebElement addCard=driver.findElement(By.xpath("//div[@id='tbodyid']//following::a"));
        addCard.click();
        TimeUnit.SECONDS.sleep(3);
        driver.switchTo().alert().accept();

        driver.navigate().back();
        driver.navigate().back();

        //Elegir Producto 2
        WebElement selecPhoneTwo=driver.findElement(By.xpath("//div[@id='tbodyid']//following::a[2]"));
        selecPhoneTwo.click();
        TimeUnit.SECONDS.sleep(2);
        WebElement addCardTwo=driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a"));
        addCardTwo.click();
        TimeUnit.SECONDS.sleep(3);
        driver.switchTo().alert().accept();

        driver.navigate().back();

        // Pagina de Carrito de Compra
        WebElement windowCart=driver.findElement(By.xpath("//*[@id=\"navbarExample\"]/ul/li[4]/a"));
        windowCart.click();
        TimeUnit.SECONDS.sleep(3);
    }

    
}
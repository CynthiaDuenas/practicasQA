import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ToolsTest {
    private WebDriver driver;

    @BeforeTest
    public void beforeTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.drive", "./chromedriver");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/elements");
    }

    @AfterTest
    public void afterTest() {
        driver.close();
        driver.quit();
    }

    @Test
    public void form() throws InterruptedException {
        //primer formulario
        WebElement buttonWebTables=driver.findElement(By.id("item-3"));
        buttonWebTables.click();

        WebElement buttonAdd=driver.findElement(By.id("addNewRecordButton"));
        buttonAdd.click();
        TimeUnit.SECONDS.sleep(2);
        WebElement fistName=driver.findElement(By.id("firstName"));
        WebElement lastName=driver.findElement(By.id("lastName"));
        WebElement email=driver.findElement(By.id("userEmail"));
        WebElement age=driver.findElement(By.id("age"));
        WebElement salary=driver.findElement(By.id("salary"));
        WebElement departament=driver.findElement(By.id("department"));
        WebElement button_Submit=driver.findElement(By.id("submit"));
        fistName.sendKeys("Itza");
        lastName.sendKeys("Bedoya");
        email.sendKeys("itzabedoya16@example.com");
        age.sendKeys("22");
        salary.sendKeys("1200");
        departament.sendKeys("Recursos Humanos");
        TimeUnit.SECONDS.sleep(3);
        button_Submit.click();


        //Modificar Datos formulario

        WebElement buttonModify=driver.findElement(By.xpath("//*[@id=\"edit-record-4\"]"));
        buttonModify.click();
        TimeUnit.SECONDS.sleep(4);


        lastName=driver.findElement(By.id("lastName"));
        salary=driver.findElement(By.id("salary"));
        departament=driver.findElement(By.id("department"));
        button_Submit=driver.findElement(By.id("submit"));

        lastName.clear();
        salary.clear();
        departament.clear();
        TimeUnit.SECONDS.sleep(3);
        lastName.sendKeys("Dueñas");
        salary.sendKeys("999");
        departament.sendKeys("Desarrollo");
        TimeUnit.SECONDS.sleep(4);
        button_Submit.click();


        //Eliminar formulario
        WebElement buttonDelate= driver.findElement(By.xpath("//*[@id=\"delete-record-4\"]"));
        TimeUnit.SECONDS.sleep(3);
        buttonDelate.click();

        driver.navigate().refresh();
        TimeUnit.SECONDS.sleep(3);

    }

}


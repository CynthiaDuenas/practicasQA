import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AmazonTest {

    private WebDriver driver;

    @BeforeTest
    public void beforeTest() {
        System.setProperty("webdriver.chrome.drive", "./chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com");
    }
    @AfterTest
    public  void afterTest() {
        driver.close();
        driver.quit();

    }
    @Test
    public void selecArt() throws InterruptedException {
        // Pagina principal
        WebElement txtSearchBar = driver.findElement(By.id("twotabsearchtextbox"));
        WebElement btnSearch = driver.findElement(By.id("nav-search-submit-button"));


        txtSearchBar.sendKeys("tenis nike air force 1 para hombre");
        btnSearch.click();

        // Pagina de productos
        WebElement selecArt_spanBestSeller =
                driver.findElement(By.xpath("(//span[@id='B07Q3GPLSG-best-seller'][1]//following::a)[1]"));

        String js_code = "arguments[0].scrollIntoView();";
        ((JavascriptExecutor) driver).executeScript(js_code, selecArt_spanBestSeller);
        selecArt_spanBestSeller.click();

        // Pagina del producto buscado
        WebElement spanSelectSize = driver.findElement(By.id("dropdown_selected_size_name"));
        WebElement sizeOption = driver.findElement(By.id("native_dropdown_selected_size_name_1"));
        WebElement btnAddToCart =driver.findElement(By.id("add-to-cart-button"));

        spanSelectSize.click();
        sizeOption.click();
        btnAddToCart.click();

        


    }
}

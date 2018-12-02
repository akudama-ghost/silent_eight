/*import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestClass {

    private static WebDriver driver;

    @BeforeClass
    public static void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "C:/program_files/another_resources/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterClass
    public static void afterClass() {
        driver.close();
        driver.quit();
    }

    @Test
    public void test1() {
        driver.get("http://www.google.com.pl");
    }

    @Test
    public void test2() {
        driver.findElement(By.xpath("//input[@title='Szukaj']")).sendKeys("elo");
        driver.findElement(By.xpath("//input[@title='Szukaj']")).sendKeys(Keys.RETURN);
    }
}
*/
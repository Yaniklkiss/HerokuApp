package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HerokuAppCheckBoxTest {
    @Test
    public void herokuAppCheckBoxTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(false);
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--disable-popup-blocking");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/checkboxes");
        List<WebElement> elements = driver.findElements(By.cssSelector("[type=checkbox]"));
        Assert.assertEquals(elements.get(0).isSelected(),false);
        Assert.assertEquals(elements.get(1).isSelected(),true);
        elements.get(0).click();
        Assert.assertEquals(elements.get(0).isSelected(),true);
        elements.get(1).click();
        Assert.assertEquals(elements.get(1).isSelected(),false);
    }
}


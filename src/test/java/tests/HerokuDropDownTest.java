package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HerokuDropDownTest {

    @Test
    public void herokuAppDropDownTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(false);
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--disable-popup-blocking");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/dropdown");
        Select select = new Select (driver.findElement(By.id("dropdown")));
        List<WebElement> optionsList = select.getOptions();
        Assert.assertEquals(optionsList.size(),3);

        select.selectByValue("1");
        String option1 = select.getFirstSelectedOption().getText();
        Assert.assertEquals(option1,"Option 1");

        select.selectByValue("2");
        String option2 = select.getFirstSelectedOption().getText();
        Assert.assertEquals(option2,"Option 1");
    }
}

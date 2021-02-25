import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class FirstTest {


    @Test
    public void checkUrl() {

        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");

        WebDriver driver =  new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("https://next.privat24.ua/mobile");

        By phoneNumber = By.xpath(".//input[@data-qa-node='phone-number']");
        By amount = By.xpath(".//input[@data-qa-node='amount']");
        By cardNumber = By.xpath(".//input[@data-qa-node='numberdebitSource']");
        By cardExpire = By.xpath(".//input[@data-qa-node='expiredebitSource']");
        By cardCvv = By.xpath(".//input[@data-qa-node='cvvdebitSource']");
        By submit = By.xpath(".//button[@data-qa-node='submit']");

        driver.findElement(phoneNumber).sendKeys("949551222");
        driver.findElement(amount).clear();
        driver.findElement(amount).sendKeys("10");
        driver.findElement(cardNumber).sendKeys("4506909324274797");
        driver.findElement(cardExpire).sendKeys("0622");
        driver.findElement(cardCvv).sendKeys("123");
        driver.findElement(submit).click();

        By detail = By.xpath(".//span[@data-qa-node='details']");
        By payerCard = By.xpath(".//td[@data-qa-node='card']");
        By operstor = By.xpath(".//span[@data-qa-node='nameB']");
        By amount2 = By.xpath(".//span[@data-qa-node='amount']");
        By currency1 = By.xpath(".//small[@data-qa-node='currency']");
        By amount3 = By.xpath(".//span[@data-qa-node='commission']");
        By commission = By.xpath(".//small[@data-qa-node='commission-currency']");

        Assert.assertEquals("Поповнення телефону. На номер +380949551222", driver.findElement(detail).getText());
        Assert.assertEquals("4506 **** **** 4797", driver.findElement(payerCard).getText());
        Assert.assertEquals("Intertelecom Ukraine", driver.findElement(operstor).getText());
        Assert.assertEquals("10", driver.findElement(amount2).getText());
        Assert.assertEquals(" UAH", driver.findElement(currency1).getText());
        Assert.assertEquals("2", driver.findElement(amount3).getText());
        Assert.assertEquals(" UAH", driver.findElement(commission).getText());

        driver.close();

    }
}

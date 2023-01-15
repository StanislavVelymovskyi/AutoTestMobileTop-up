import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebElement;

import java.time.Duration;


public class AutoTest {
    WebDriver driver = new ChromeDriver();

    //Description of the page elemements
    By phoneCode = By.xpath("//button[@data-qa-node='phone-code']/div/span/div/div[2]");
    By search = By.xpath("//input[@placeholder='Пошук' or @placeholder='Search']");
    By phoneNumber = By.xpath("//input[@data-qa-node='phone-number']");
    By amount = By.xpath("//input[@data-qa-node='amount']");
    By cardFrom = By.xpath("//input[@data-qa-node='numberdebitSource']");
    By expDate = By.xpath("//input[@data-qa-node='expiredebitSource']");
    By cvv = By.xpath("//input[@data-qa-node='cvvdebitSource']");
    By firstName = By.xpath("//input[@data-qa-node='firstNamedebitSource']");
    By lastName = By.xpath("//input[@data-qa-node='lastNamedebitSource']");
    By submitBtn = By.xpath("//button[@data-qa-node='submit']");
    By resiverNumber = By.xpath("//div[@data-qa-node='details']");
    By nameOperator = By.xpath("//span[@data-qa-node='nameB']");
    By finalAmount = By.xpath("//div[@data-qa-node='amount']");
    By comission = By.xpath("//span[@data-qa-node='commission']");
    By comissionCurrency = By.xpath("//span[@data-qa-node='commission-currency']");
    By getCardFrom = By.xpath("//td[@data-qa-node='card']");

    @Test
   void checkAddToBasketMinTopUpMobSum(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://next.privat24.ua/mobile");

        driver.findElement(phoneCode).click();
        driver.findElement(search).sendKeys("+380");
        driver.findElement(phoneCode).click();
        driver.findElement(phoneNumber).sendKeys("959490230");
        driver.findElement(amount).sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
        driver.findElement(amount).sendKeys("1");
        driver.findElement(cardFrom).sendKeys("4004159115449003");
        driver.findElement(expDate).sendKeys("1225");
        driver.findElement(cvv).sendKeys("123");
        driver.findElement(firstName).sendKeys("STANISLAV");
        driver.findElement(lastName).sendKeys("VELYMOVSKIY");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(submitBtn).submit();
        //Assertions
        Assertions.assertEquals("Поповнення телефону. На номер +380959490230",driver.findElement(resiverNumber).getText());
        Assertions.assertEquals("4004 **** **** 9003",driver.findElement(getCardFrom).getText());
        Assertions.assertEquals("Vodafone",driver.findElement(nameOperator).getText());
        Assertions.assertEquals("1 UAH",driver.findElement(finalAmount).getText());
        Assertions.assertEquals("2 UAH",driver.findElement(comission).getText() + driver.findElement(comissionCurrency).getText());

   }

}

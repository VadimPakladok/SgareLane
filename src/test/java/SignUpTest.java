import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SignUpTest {

    @Test
    public void zipCodeShouldAccept5Digits() {
        //Открыть страницу https://sharelane.com/cgi-bin/register.py
        //Ввести любые 5 цифр (12345)
        //Нажать кнопку Continue
        //Убедиться что мы на странице SIGN UP
        //Закрыть браузер
        //Установка переменной среды
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Открыть страницу https://sharelane.com/cgi-bin/register.py
        driver.get("https://sharelane.com/cgi-bin/register.py");
        //Ввести любые 5 цифр (12345)
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        //Нажать кнопку Continue
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        boolean isOpened = driver.findElement(By.cssSelector("[value=Register]")).isDisplayed();
        //Убедиться что мы на странице SIGN UP
        Assert.assertTrue(isOpened, "Страница регистрации не открылась");
        //Закрыть браузер
        driver.quit();
    }

    @Test
    public void zipCodeShouldNotAccept4Digits() {
        //Открыть страницу https://sharelane.com/cgi-bin/register.py
        //Ввести любые 6 цифр (123456)
        //Нажать кнопку Continue
        //Убедиться что мы на странице SIGN UP
        //Закрыть браузер
        //Установка переменной среды
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Открыть страницу https://sharelane.com/cgi-bin/register.py
        driver.get("https://sharelane.com/cgi-bin/register.py");
        //Ввести любые 5 цифр (12345)
        driver.findElement(By.name("zip_code")).sendKeys("123456");
        //Нажать кнопку Continue
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        String error = driver.findElement(By.cssSelector("[class=error_message]")).getText();
        Assert.assertEquals(error, "Oops, error on page. ZIP code should have 5 digits",
                "Сообщение об ошибке (zipcode) некорректное");
        //Закрыть браузер
        driver.quit();
    }

    @Test
    public void zipCodeShouldNotAccept6Digits() {
        //Открыть страницу https://sharelane.com/cgi-bin/register.py
        //Ввести любые 4 цифр (1234)
        //Нажать кнопку Continue
        //Убедиться что мы на странице SIGN UP
        //Закрыть браузер
        //Установка переменной среды
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Открыть страницу https://sharelane.com/cgi-bin/register.py
        driver.get("https://sharelane.com/cgi-bin/register.py");
        //Ввести любые 6 цифр (123456)
        driver.findElement(By.name("zip_code")).sendKeys("123456");
        //Нажать кнопку Continue
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        String error = driver.findElement(By.cssSelector("[class=error_message]")).getText();
        Assert.assertEquals(error, "Oops, error on page. ZIP code should have 5 digits",
                "Сообщение об ошибке (zipcode) некорректное");
        //Закрыть браузер
        driver.quit();
    }


    @Test
    public void successfullSignUp() {
        //Открыть страницу https://sharelane.com/cgi-bin/register.py
        //Ввести любые 6 цифр (123456)
        //Нажать кнопку Continue
        //Убедиться что мы на странице SIGN UP
        //Закрыть браузер
        //Установка переменной среды
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Открыть страницу https://sharelane.com/cgi-bin/register.py
        driver.get("https://sharelane.com/cgi-bin/register.py");
        //Ввести любые 5 цифр (12345)
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        //Нажать кнопку Continue
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        driver.findElement(By.name("first_name")).sendKeys("Alex");
        driver.findElement(By.name("last_name")).sendKeys("Potter");
        driver.findElement(By.name("email")).sendKeys("alexpotter@hfh.com");
        driver.findElement(By.name("password1")).sendKeys("123456");
        driver.findElement(By.name("password2")).sendKeys("123456");
        driver.findElement(By.cssSelector("[value=Register]")).click();
        String massage = driver.findElement(By.cssSelector("[class=confirmation_message]")).getText();
        Assert.assertEquals(massage, "Account is created!", "Аккаунт не был создан");
//        //Закрыть браузер
        driver.quit();

    }

    @Test
    public void signUpNameNull() {
        //Открыть страницу https://sharelane.com/cgi-bin/register.py
        //Ввести любые 5 цифр (12345)
        //Нажать кнопку Continue
        //Убедиться что мы на странице SIGN UP
        //Закрыть браузер
        //Установка переменной среды
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Открыть страницу https://sharelane.com/cgi-bin/register.py
        driver.get("https://sharelane.com/cgi-bin/register.py");
        //Ввести любые 5 цифр (12345)
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        //Нажать кнопку Continue
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        driver.findElement(By.name("first_name")).sendKeys("");
        driver.findElement(By.name("last_name")).sendKeys("Potter");
        driver.findElement(By.name("email")).sendKeys("alexpotter@hfh.com");
        driver.findElement(By.name("password1")).sendKeys("123456");
        driver.findElement(By.name("password2")).sendKeys("123456");
        driver.findElement(By.cssSelector("[value=Register]")).click();
        String massage = driver.findElement(By.cssSelector("[class=error_message]")).getText();
        Assert.assertEquals(massage, "Oops, error on page. Some of your fields have invalid data or email was previously used", "Ошибка");
//        //Закрыть браузер
        driver.quit();

    }

    @Test
    public void signUpAllFieldIsNull() {
        //Открыть страницу https://sharelane.com/cgi-bin/register.py
        //Ввести любые 5 цифр (12345)
        //Нажать кнопку Continue
        //Убедиться что мы на странице SIGN UP
        //Закрыть браузер
        //Установка переменной среды
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Открыть страницу https://sharelane.com/cgi-bin/register.py
        driver.get("https://sharelane.com/cgi-bin/register.py");
        //Ввести любые 5 цифр (12345)
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        //Нажать кнопку Continue
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        driver.findElement(By.name("first_name")).sendKeys("");
        driver.findElement(By.name("last_name")).sendKeys("");
        driver.findElement(By.name("email")).sendKeys("");
        driver.findElement(By.name("password1")).sendKeys("");
        driver.findElement(By.name("password2")).sendKeys("");
        driver.findElement(By.cssSelector("[value=Register]")).click();
        String massage = driver.findElement(By.cssSelector("[class=error_message]")).getText();
        Assert.assertEquals(massage, "Oops, error on page. Some of your fields have invalid data or email was previously used", "Удивительно, но работает");
//        //Закрыть браузер
        driver.quit();

    }

    @Test
    public void signUpAllFirstNameDigits() {
        //Открыть страницу https://sharelane.com/cgi-bin/register.py
        //Ввести любые 5 цифр (12345)
        //Нажать кнопку Continue
        //Убедиться что мы на странице SIGN UP
        //Закрыть браузер
        //Установка переменной среды
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Открыть страницу https://sharelane.com/cgi-bin/register.py
        driver.get("https://sharelane.com/cgi-bin/register.py");
        //Ввести любые 5 цифр (12345)
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        //Нажать кнопку Continue
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        driver.findElement(By.name("first_name")).sendKeys("12345");
        driver.findElement(By.name("last_name")).sendKeys("Potter");
        driver.findElement(By.name("email")).sendKeys("alexpotter@hfh.com");
        driver.findElement(By.name("password1")).sendKeys("123456");
        driver.findElement(By.name("password2")).sendKeys("123456");
        driver.findElement(By.cssSelector("[value=Register]")).click();
        String massage = driver.findElement(By.cssSelector("[class=error_message]")).getText();
        Assert.assertEquals(massage, "Oops, error on page. Some of your fields have invalid data or email was " +
                "previously used", "Удивительно, но работает");
//        //Закрыть браузер
        driver.quit();

    }

    @Test
    public void signUpPasswordAndConfirmPasswordNotTheSame() {
        //Открыть страницу https://sharelane.com/cgi-bin/register.py
        //Ввести любые 6 цифр (123456)
        //Нажать кнопку Continue
        //Убедиться что мы на странице SIGN UP
        //Закрыть браузер
        //Установка переменной среды
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Открыть страницу https://sharelane.com/cgi-bin/register.py
        driver.get("https://sharelane.com/cgi-bin/register.py");
        //Ввести любые 5 цифр (12345)
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        //Нажать кнопку Continue
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        driver.findElement(By.name("first_name")).sendKeys("Alex");
        driver.findElement(By.name("last_name")).sendKeys("Potter");
        driver.findElement(By.name("email")).sendKeys("alexpotter@hfh.com");
        driver.findElement(By.name("password1")).sendKeys("123456");
        driver.findElement(By.name("password2")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value=Register]")).click();
        String massage = driver.findElement(By.cssSelector("[class=error_message]")).getText();
        Assert.assertEquals(massage, "Oops, error on page. Some of your fields have invalid data or email was " +
                "previously used", "Удивительно, но работает");
//        //Закрыть браузер
        driver.quit();

    }

    @Test
    public void signUpPasswordNull() {
        //Открыть страницу https://sharelane.com/cgi-bin/register.py
        //Ввести любые 6 цифр (123456)
        //Нажать кнопку Continue
        //Убедиться что мы на странице SIGN UP
        //Закрыть браузер
        //Установка переменной среды
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
        //Открыть страницу https://sharelane.com/cgi-bin/register.py
        driver.get("https://sharelane.com/cgi-bin/register.py");
        //Ввести любые 5 цифр (12345)
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        //Нажать кнопку Continue
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        driver.findElement(By.name("first_name")).sendKeys("Alex");
        driver.findElement(By.name("last_name")).sendKeys("Potter");
        driver.findElement(By.name("email")).sendKeys("alexpotter@hfh.com");
        driver.findElement(By.name("password1")).sendKeys("");
        driver.findElement(By.name("password2")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value=Register]")).click();
        String massage = driver.findElement(By.cssSelector("[class=error_message]")).getText();
        Assert.assertEquals(massage, "Oops, error on page. Some of your fields have invalid data or email was " +
                "previously used", "Удивительно, но работает");
//        //Закрыть браузер
        driver.quit();

    }

    @Test
    public void logInAndPassword() {
        //Открыть страницу https://sharelane.com/cgi-bin/register.py
        //Ввести любые 6 цифр (123456)
        //Нажать кнопку Continue
        //Убедиться что мы на странице SIGN UP
        //Закрыть браузер
        //Установка переменной среды
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
        //Открыть страницу https://sharelane.com/cgi-bin/register.py
        driver.get("https://sharelane.com/cgi-bin/register.py");
        //Ввести любые 5 цифр (12345)
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        //Нажать кнопку Continue
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        driver.findElement(By.name("first_name")).sendKeys("Alex");
        driver.findElement(By.name("last_name")).sendKeys("Potter");
        driver.findElement(By.name("email")).sendKeys("alexpotter@hfh.com");
        driver.findElement(By.name("password1")).sendKeys("12345");
        driver.findElement(By.name("password2")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value=Register]")).click();
//        String massage = driver.findElement(By.cssSelector("[class=error_message]")).getText();
//        Assert.assertEquals(massage, "Oops, error on page. Some of your fields have invalid data or email was " +
//                "previously used", "Удивительно, но работает");
        String email = driver.findElement(By.xpath("(//b)[2]")).getText();
        driver.get("https://sharelane.com/cgi-bin/main.py");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys("1111");
        driver.findElement(By.cssSelector("[value=Login]")).click();

//        //Закрыть браузер
//        driver.quit();

    }

    @Test
    public void buyBookAndChangeQuantity() {
        //Открыть страницу https://sharelane.com/cgi-bin/register.py
        //Ввести любые 6 цифр (123456)
        //Нажать кнопку Continue
        //Убедиться что мы на странице SIGN UP
        //Закрыть браузер
        //Установка переменной среды
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
        //Открыть страницу https://sharelane.com/cgi-bin/register.py
        driver.get("https://sharelane.com/cgi-bin/register.py");
        //Ввести любые 5 цифр (12345)
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        //Нажать кнопку Continue
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        driver.findElement(By.name("first_name")).sendKeys("Alex");
        driver.findElement(By.name("last_name")).sendKeys("Potter");
        driver.findElement(By.name("email")).sendKeys("alexpotter@hfh.com");
        driver.findElement(By.name("password1")).sendKeys("12345");
        driver.findElement(By.name("password2")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value=Register]")).click();
        String email = driver.findElement(By.xpath("(//b)[2]")).getText();
        driver.get("https://sharelane.com/cgi-bin/main.py");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys("1111");
        driver.findElement(By.cssSelector("[value=Login]")).click();
        driver.findElement(By.name("keyword")).sendKeys("The Adventures of Huckleberry Finn");
        driver.findElement(By.cssSelector("[value=Search]")).click();
        driver.findElement(By.xpath(("//a[contains(@href, 'add_to_cart')]") )).click();
//        driver.get("https://www.sharelane.com/cgi-bin/shopping_cart.py");
        driver.findElement(By.xpath(("//a[contains(@href, 'shopping_cart')]") )).click();
        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("19");
        driver.findElement(By.cssSelector("[value=Update]")).click();
        String massage = driver.findElement(By.cssSelector("[class=confirmation_message]")).getText();
        Assert.assertEquals(massage, "Cart Updated", "ERROR");
        // закрыть браузер
        driver.quit();
    }
}

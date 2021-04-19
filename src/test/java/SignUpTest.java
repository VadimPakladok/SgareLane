import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

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
    public void SignUpNameNull() {
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
    public void SignUpAllFieldIsNull() {
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
    public void SignUpAllFirstNameDigits() {
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
    public void SignUpPasswordAndConfirmPasswordNotTheSame() {
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
    public void SignUpPasswordNull() {
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
        driver.findElement(By.name("password1")).sendKeys("");
        driver.findElement(By.name("password2")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value=Register]")).click();
        String massage = driver.findElement(By.cssSelector("[class=error_message]")).getText();
        Assert.assertEquals(massage, "Oops, error on page. Some of your fields have invalid data or email was " +
                "previously used", "Удивительно, но работает");
//        //Закрыть браузер
        driver.quit();

    }



}

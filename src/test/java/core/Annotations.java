package core;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import page.OrderPageStep1Page;

public abstract class Annotations extends Driver {
    @Before
    public void setting(){
        // драйвер для браузера Chrome
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        // переход на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");
        OrderPageStep1Page orderPageStep1Page = new OrderPageStep1Page();
        orderPageStep1Page.closeCookie();
    }
    @After
    public void exit(){
        driver.quit();
    }
}

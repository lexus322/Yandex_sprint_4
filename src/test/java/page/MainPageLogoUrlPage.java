package page;
import core.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class MainPageLogoUrlPage extends Driver {

    //Лого Яндекс
    private final By logoYandex = By.xpath(".//a[contains(@class,'Header_LogoYandex')]");
    //Лого Самокат
    private final By logoSamokat = By.xpath(".//a[contains(@class,'Header_LogoScooter')]");
    //Капча на странице яндекса
    private final By captcha = By.className("CheckboxCaptcha-Button");
    //Строка поиска на странице Яндекса
    private final By stringSearchYandex = By.className("content");
    //Проверка url после перехода на сайт при помощи логотипов в шапке
    public final String checkUrl(int select){
        //переход на сайт Яндекс
        if(select == 1){
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(logoYandex));
        driver.findElement(logoYandex).click();
        ArrayList<String> newTab = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(newTab.get(1));
        String captchaUrl = driver.getCurrentUrl();
            if (captchaUrl.contains("https://yandex.ru/showcaptcha")){
                driver.findElement(captcha).click();
            }
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(stringSearchYandex));
        return driver.getCurrentUrl();}
        //переход на сайт Самокат
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(logoSamokat));
        driver.findElement(logoSamokat).click();
        return driver.getCurrentUrl();
    }
}

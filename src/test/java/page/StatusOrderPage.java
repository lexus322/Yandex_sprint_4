package page;

import core.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StatusOrderPage extends Driver {
    //Кнопка "Статус заказа"
    private final By buttonStatusOrder = By.xpath(".//button[contains(@class,'Header_Link')]");
    //Шапка
    private final By header = By.xpath(".//div[contains(@class,'Header_Header')]");
    //Inpit ввода номера заказа
    private final By inputStatusOrder = By.xpath(".//input[@placeholder='Введите номер заказа']");
    //Кнопка "GO"
    private final By buttonGo = By.xpath(".//button[text()='Go!']");
    //Изображение при поиске несуществующего заказа
    private final By imgNotFound = By.cssSelector("img[alt='Not found']");

    //Нажатие на кнопку "Статус заказа"
    public void clickButtonStatusOrder() {
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(header));
        driver.findElement(buttonStatusOrder).click();

    }

    //Ввод в поле номер заказа
    public void sendStatusOrder(String numberOrder) {
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(inputStatusOrder));
        driver.findElement(inputStatusOrder).click();
        driver.findElement(inputStatusOrder).clear();
        driver.findElement(inputStatusOrder).sendKeys(numberOrder);
        driver.findElement(buttonGo).click();
    }

    //Сравнение с исходными данными
    public boolean resultSearch() {
        return driver.findElement(imgNotFound).isDisplayed();
    }
}

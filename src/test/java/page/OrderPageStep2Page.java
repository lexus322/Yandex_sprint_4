package page;

import core.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDate;

public class OrderPageStep2Page extends Driver {

    //Input Даты доставки
    private final By inputDateDelivery = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    //Календарь
    private final By blockCalendar = By.xpath(".//div[contains(@class,'react-datepicker')]");
    //Input Срок аренды
    private final By inputRentalPeriod = By.xpath(".//div[contains(@class,'Dropdown-control')]");
    //Список Cрока аренды
    private final By listRentalPeriod = By.xpath(".//div[contains(@class,'Dropdown-menu')]");
    //Выбор из спика срока аренда "двое суток"
    private final By setRentalPeriod2Days = By.xpath(".//div[contains(@class,'Dropdown-menu')]/div[text()='двое суток']");
    //CheckBox Черный цвет самоката
    private final By checkBoxColorScooterBlack = By.id("black");
    //Кнопка "Заказать" на втором шаге формы
    private final By buttonOrderInForm = By.xpath("//div[contains(@class,'Order_Buttons')]//button[text()='Заказать']");
    //Кнопка "Да" на форме "Хотите оформить заказ"
    private final By buttonYesInForm = By.xpath(".//div[contains(@class,'Order_Modal')]//button[text()='Да']");
    //Input Комментарий для курьера
    private final By inputCommentCourier = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    //Метод получение текущей даты + 1 день
    private By getDate(){
        LocalDate date = LocalDate.now();
        return By.xpath(String.format(".//div[contains(@class,'react-datepicker__month')]//div[text()='%s']",date.getDayOfMonth()+1));
    }
    //Метод заполнение даты в форме на шаге 2
    private void setDateForm(){
        driver.findElement(inputDateDelivery).click();
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(blockCalendar));
        driver.findElement(getDate()).click();
    }
    //Метод заполнение периода в форме на шаге 2
    private void setRentalPeriod(){
        driver.findElement(inputRentalPeriod).click();
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(listRentalPeriod));
        driver.findElement(setRentalPeriod2Days).click();
    }
    //Метод выбора цвета самоката в форме на шаге 2
    private void setColorScooter(){
        driver.findElement(checkBoxColorScooterBlack).click();
    }
    //Метод заполнения комментария для курьера в форме на шаге 2
    private void setCommentCourier(){
        driver.findElement(inputCommentCourier).sendKeys("Ты лучший доставщик");
    }
    //Метод нажатия на кнопку "Заказать" в форме на шаге 2
    private void clickButtonOrderInForm(){
        driver.findElement(buttonOrderInForm).click();
    }
    //Метод нажатия на кнопку "Да" в форме на подтверждение заказа на шаге 2
    private void clickButtonYesInForm(){
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(buttonYesInForm));
        driver.findElement(buttonYesInForm).click();
    }
    //Шаг 2 для заполнение формы заказа самоката
    public void setInputFormStep2(){
    setDateForm();
    setRentalPeriod();
    setColorScooter();
    setCommentCourier();
    clickButtonOrderInForm();
    clickButtonYesInForm();
    }
}

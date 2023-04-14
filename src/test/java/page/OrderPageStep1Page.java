package page;
import core.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderPageStep1Page extends Driver {
    //Кнопка "Заказать" в шапке
    private final By buttonOrderHeader = By.xpath(".//button[contains(@class,'Button_Button')]");
    //Кнопка "Заказать" в разделе "Как это работает"
    private final By buttonOrderBody = By.xpath(".//div[contains(@class,'Home_FinishButton')]/button[text()='Заказать']");
    //Контейнер для кнопки "Заказать" в разделе "Как это работает"
    private final By containerButtonOrderBody = By.xpath(".//div[contains(@class,'Home_ThirdPart')]");
    //Шапка
    private final By header = By.xpath(".//div[contains(@class,'Header_Header')]");
    //Input имя
    private final By inputNameForm = By.xpath(".//input[@placeholder='* Имя']");
    //Input фамилия
    private final By inputSecondNameForm = By.xpath(".//input[@placeholder='* Фамилия']");
    //Input Адрес
    private final By inputAdressForm = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    //Input Метро
    private final By inputMetroForm = By.xpath(".//input[@placeholder='* Станция метро']");
    //Список метро
    private final By listMetro = By.className("select-search__row");
    //Input номер телефона
    private final By inputNumberForm = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    //Кнопка "Далее" на форме "Для кого самокат"
    private final By buttonNextForm = By.xpath(".//div[contains(@class,'Order_NextButton')]/button[text()='Далее']");
    //Кнопка "Да все привыкли"
    private final By buttonCookie = By.xpath(".//div[contains(@class,'App_CookieConsent')]//button[contains(@class,'App_CookieButton')]");

    //Метод нажатия кнопки "Заказать" в шапке сайта или в его теле в зависимости от параметра
    public void clickButtonOrder(int button){
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(header));
        if(button == 1) {
            new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(containerButtonOrderBody));
            WebElement element = driver.findElement(containerButtonOrderBody);
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
            new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(buttonOrderBody));
            driver.findElement(buttonOrderBody).click();
        }
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(buttonOrderHeader));
        driver.findElement(buttonOrderHeader).click();
    }
    //Метод заполнение имени в форме на шаге 1
    public void setInputNameForm(String name){
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(inputNameForm));
        driver.findElement(inputNameForm).sendKeys(name);
    }
    //Метод заполнение фамилии в форме на шаге 1
    public void setInputSecondNameForm(String secondName){
        new WebDriverWait(driver, 1).until(ExpectedConditions.visibilityOfElementLocated(inputSecondNameForm));
        driver.findElement(inputSecondNameForm).sendKeys(secondName);
    }
    //Метод заполнение адреса в форме на шаге 1
    public void setInputAdressForm(String adress){
        new WebDriverWait(driver, 1).until(ExpectedConditions.visibilityOfElementLocated(inputAdressForm));
        driver.findElement(inputAdressForm).sendKeys(adress);
    }
    //Метод выбора метро в форме на шаге 1
    public void setInputMetroForm(){
        new WebDriverWait(driver, 1).until(ExpectedConditions.visibilityOfElementLocated(inputMetroForm));
        driver.findElement(inputMetroForm).click();
        WebElement element = driver.findElements(listMetro).get(20);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(listMetro));
        element.click();
    }
    //Метод заполнение номера телефона в форме на шаге 1
    public void setInputNumberForm(String number){
        new WebDriverWait(driver, 1).until(ExpectedConditions.visibilityOfElementLocated(inputNumberForm));
        driver.findElement(inputNumberForm).sendKeys(number);
        driver.findElement(buttonNextForm).click();
    }
    //Закритие Куки
    public void closeCookie(){
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(buttonCookie));
        driver.findElement(buttonCookie).click();
    }
    //Шаг 1 для заполнение формы заказа самоката
    public void setInputFormStep1(String name, String secondName, String adress, String number){
    setInputNameForm(name);
    setInputSecondNameForm(secondName);
    setInputAdressForm(adress);
    setInputMetroForm();
    setInputNumberForm(number);
    }
}

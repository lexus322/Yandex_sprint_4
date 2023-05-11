package page;

import core.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import java.util.List;

public class MainPageAccordionPage extends Driver {

    //Получение текста из параграфа в аккордиона на сайте
    public String getAllElementAccordion(int numberAccordion) {
        List<WebElement> elementsParagraf = driver.findElements(By.xpath(".//div[contains(@class,'accordion')]/div[contains(@class,'accordion__item')]" +
                "/div[contains(@class,'accordion__panel')]/p"));
        return elementsParagraf.get(numberAccordion).getAttribute("innerHTML");
    }
    //Получение точки входа для раскрытия аккордиона
    public WebElement getButtonAccordion(int numberAccordion){
        List<WebElement> elementsHeader = driver.findElements(By.xpath(".//div[contains(@class,'accordion__item')]"));
        return elementsHeader.get(numberAccordion);
    }
    // Сравнение заголовков аккордиона
    public String checkHeaderElementAccordion(int numberAccordion,String textHeaderAccordion) {
        List<WebElement> elementsHeader = driver.findElements(By.xpath(".//div[contains(@class,'accordion')]//div[contains(@id,'accordion__heading')]"));
        String elementHeader = elementsHeader.get(numberAccordion).getAttribute("innerHTML");
        if (textHeaderAccordion.equals(elementHeader)) {
            return elementHeader;
        }
        return elementHeader;
    }
    //Сравнение наполнения текстом
    public String checkParagrafAccordion(int numberAccordion, String textParagrafAccordion) {
        WebElement element = getButtonAccordion(numberAccordion);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
        if (textParagrafAccordion.equals(getAllElementAccordion(numberAccordion))) {
            return getAllElementAccordion(numberAccordion);
        }
        return getAllElementAccordion(numberAccordion);
    }
}


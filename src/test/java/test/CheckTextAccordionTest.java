package test;

import core.Annotations;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import page.MainPageAccordionPage;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CheckTextAccordionTest extends Annotations {

    private final String textParagrafAccordion;
    private final String textHeaderAccordion;
    private final int numberAccordion;

    public CheckTextAccordionTest(int numberAccordion, String textHeaderAccordion,String textParagrafAccordion) {
        this.numberAccordion = numberAccordion;
        this.textHeaderAccordion = textHeaderAccordion;
        this.textParagrafAccordion = textParagrafAccordion;

    }
    @Parameterized.Parameters
    public static Object[][] getCredentials() {
        return new Object[][] {
                { 0,"Сколько это стоит? И как оплатить?","Сутки — 400 рублей. Оплата курьеру — наличными или картой." },
                { 1,"Хочу сразу несколько самокатов! Так можно?","Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим." },
                { 2,"Как рассчитывается время аренды?","Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30." },
                { 3,"Можно ли заказать самокат прямо на сегодня?","Только начиная с завтрашнего дня. Но скоро станем расторопнее." },
                { 4,"Можно ли продлить заказ или вернуть самокат раньше?","Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010." },
                { 5,"Вы привозите зарядку вместе с самокатом?","Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится." },
                { 6,"Можно ли отменить заказ?","Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои." },
                { 7,"Я жизу за МКАДом, привезёте?","Да, обязательно. Всем самокатов! И Москве, и Московской области." },
        };
    }
    @Test
    public void checkHeader() {
        MainPageAccordionPage mainPageAccordionPage = new MainPageAccordionPage();
        mainPageAccordionPage.checkHeaderElementAccordion(numberAccordion,textHeaderAccordion);
        assertEquals("Заголовки не совпадают",textHeaderAccordion,mainPageAccordionPage.checkHeaderElementAccordion(numberAccordion,textHeaderAccordion));
    }
    @Test
    public void checkParagraf() {
        MainPageAccordionPage mainPageAccordionPage = new MainPageAccordionPage();
        mainPageAccordionPage.checkParagrafAccordion(numberAccordion,textParagrafAccordion);
        assertEquals("Текст внутри параграфа не совпадает", textParagrafAccordion, mainPageAccordionPage.checkParagrafAccordion(numberAccordion,textParagrafAccordion));
    }

}

package test;

import core.Annotations;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import page.OrderPageStep1Page;
import page.OrderPageStep2Page;

@RunWith(Parameterized.class)
public class OrderSamokatTest extends Annotations {
    private final int button;
    private final String name;
    private final String secondName;
    private final String adress;
    private final String number;

    public OrderSamokatTest(int button, String name, String secondName, String adress, String number) {
        this.button = button;
        this.name = name;
        this.secondName = secondName;
        this.adress = adress;
        this.number = number;
    }
    @Parameterized.Parameters
    public static Object[][] getCredentials() {
        return new Object[][] {
                { 1, "Алексей", "Тюрин", "ул.Мамонтовой д.5","89003005050" },
                { 2, "Максим", "Максимович", "ул.Тархова д.22","89004005050" },
        };
    }
    @Test
        public void fillingFormOrderSamokat() {
        OrderPageStep1Page orderPageStep1Page = new OrderPageStep1Page();
        OrderPageStep2Page orderPageStep2Page = new OrderPageStep2Page();
        orderPageStep1Page.clickButtonOrder(button);
        orderPageStep1Page.setInputFormStep1(name, secondName, adress, number);
        orderPageStep2Page.setInputFormStep2();
    }
}
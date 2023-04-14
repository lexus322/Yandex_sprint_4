package test;

import core.Annotations;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import page.StatusOrderPage;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ChechStatusOrderTest extends Annotations {
    private final String numberOrder;
    private final boolean extend;

    public ChechStatusOrderTest(String numberOrder, boolean extend) {
        this.numberOrder = numberOrder;
        this.extend = extend;
    }

    @Parameterized.Parameters
    public static Object[][] getCredentials() {
        return new Object[][]{
                {"777", false},
                {"123123", false}
        };
    }

    @Test
    public void checkNumberOrder() {
        StatusOrderPage statusOrderPage = new StatusOrderPage();
        statusOrderPage.clickButtonStatusOrder();
        statusOrderPage.sendStatusOrder(numberOrder);
        assertEquals("Заказ с таким номером существует", extend, statusOrderPage.resultSearch());
    }
}

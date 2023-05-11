package test;

import core.Annotations;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import page.MainPageLogoUrlPage;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CheckLogoTransitionTest extends Annotations {

    private final String url;
    private final int select;
    public CheckLogoTransitionTest(String url, int select) {
        this.url = url;
        this.select = select;
    }

    @Parameterized.Parameters
    public static Object[][] getCredentials() {
        return new Object[][] {
                {"https://ya.ru/", 1},
                {"https://qa-scooter.praktikum-services.ru/", 2}
        };
    }
    @Test
    public void checkUrlForLogo() {
        MainPageLogoUrlPage mainPageLogoUrlPage = new MainPageLogoUrlPage();
        assertEquals("Url не совпадает",url, mainPageLogoUrlPage.checkUrl(select));
    }
}

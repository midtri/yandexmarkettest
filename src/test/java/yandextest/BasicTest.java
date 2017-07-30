package yandextest;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;

import static yandextest.Statics.clearLocaleStorage;
import static yandextest.Statics.closeDriver;
import static yandextest.Statics.getDriver;

public class BasicTest {

    @Before
    public void setUpMethod() {
        getDriver().get(Config.baseUrl);
    }

    @After
    public void tearDownMethod() {
        clearLocaleStorage();
        getDriver().manage().deleteAllCookies();
    }

    @AfterClass
    public static void tearDownClass() {
        closeDriver();
    }
}

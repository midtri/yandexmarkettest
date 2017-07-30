package yandextest.pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static yandextest.Statics.shouldBeVisible;

public class YandexMenu extends BasicPageObject {

    @FindBy(css = ".home-tabs [data-id='market']")
    private WebElement market;

    @Step
    public void openMarketMenu() {
        shouldBeVisible(market).click();
    }
}

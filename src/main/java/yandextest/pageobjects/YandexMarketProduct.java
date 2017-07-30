package yandextest.pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static yandextest.Statics.shouldBeVisible;

public class YandexMarketProduct extends BasicPageObject {

    @FindBy(css = ".n-product-title [itemprop='name']")
    private WebElement name;

    @Step
    public String getName() {
        return shouldBeVisible(name).getText();
    }
}

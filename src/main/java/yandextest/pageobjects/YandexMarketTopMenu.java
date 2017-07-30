package yandextest.pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static yandextest.Statics.shouldBeVisible;

public class YandexMarketTopMenu extends BasicPageObject {

    @FindBy(xpath = "//*[@class='topmenu__list']//li/a[text()='Компьютеры']")
    private WebElement computers;

    @Step
    public void openComputersMenu() {
        shouldBeVisible(computers).click();
    }
}

package yandextest.pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static yandextest.Statics.shouldBeVisible;
import static yandextest.Statics.shouldNotBeExists;

public class YandexMarketLeftMenu extends BasicPageObject {

    @FindBy(xpath = "//*[@class='catalog-menu__item'][a[text()='Компьютеры']]//a[text()='Ноутбуки']")
    private WebElement notebooks;

    @FindBy(xpath = "//*[@class='catalog-menu__item'][a[text()='Компьютеры']]//a[text()='Планшеты']")
    private WebElement tablets;

    @Step
    public void openNotebooksMenu() {
        shouldBeVisible(notebooks).click();
    }

    @Step
    public void openTabletsMenu() {
        shouldBeVisible(tablets).click();
    }
}

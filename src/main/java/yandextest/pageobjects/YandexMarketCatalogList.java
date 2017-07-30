package yandextest.pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Objects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static yandextest.Statics.shouldBeVisible;
import static yandextest.Statics.shouldNotBeExists;

public class YandexMarketCatalogList extends BasicPageObject {

    @FindBy(id = "glf-pricefrom-var")
    private WebElement priceFrom;

    @FindBy(id = "glf-priceto-var")
    private WebElement priceTo;

    @FindAll(@FindBy(xpath = "//*[contains(@class, 'filter-block')][.//*[text()='Производитель']]//div/a"))
    private List<WebElement> brands;

    @FindBy(css = ".button.button_action_n-filter-apply")
    private WebElement apply;

    @FindAll(@FindBy(css = ".n-filter-applied-results .snippet-list .n-snippet-card .snippet-card__content h3 a span"))
    private List<WebElement> itemList;

    @FindBy(css = ".preloadable__preloader_visibility_visible")
    private WebElement loader;

    @FindBy(id = "header-search")
    private WebElement search;

    @FindBy(css = ".search2 button")
    private WebElement applySearch;

    @FindBy(xpath = "//*[@class='popup__content']//a[contains(@href, '/product/')]")
    private List<WebElement> searchPopupList;

    @Step
    public void setPriceFrom(int price) {
        shouldBeVisible(priceFrom).clear();
        priceFrom.sendKeys(String.valueOf(price));
    }

    @Step
    public void setPriceTo(int price) {
        shouldBeVisible(priceTo).clear();
        priceTo.sendKeys(String.valueOf(price));
    }

    @Step
    public void setBrand(final String brandName) {
        shouldBeVisible(brands.get(0));
        brands.stream().filter(item -> Objects.equals(item.getText().toLowerCase(), brandName.toLowerCase()))
                .findFirst().orElseThrow(java.util.NoSuchElementException::new).click();
    }

    @Step
    public void applyFilter() {
        shouldBeVisible(apply).click();
        shouldNotBeExists(loader);
    }

    @Step
    public int getItemListSize() {
        shouldBeVisible(itemList.get(0));
        return itemList.size();
    }

    @Step
    public String getItemListResult(int index) {
        shouldBeVisible(itemList.get(0));
        return itemList.get(index).getText();
    }

    @Step
    public void search(String text) {
        shouldBeVisible(search).clear();
        search.sendKeys(text);
        shouldNotBeExists(loader);
    }

    @Step
    public String getSearchValue() {
        return shouldBeVisible(search).getAttribute("value");
    }

    @Step
    public void openFirstSearchResult() {
        shouldBeVisible(searchPopupList.get(0)).click();
        //shouldBeVisible(applySearch).click();
    }
}

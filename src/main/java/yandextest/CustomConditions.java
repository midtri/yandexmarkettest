package yandextest;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;

import static yandextest.Statics.getJsExecutor;

public class CustomConditions {
    public static ExpectedCondition<Boolean> invisibilityOf(final WebElement element) {
        return driver -> {
            try {
                return !element.isDisplayed();
            } catch (NoSuchElementException | StaleElementReferenceException e) {
                return true;
            }
        };
    }

    public static ExpectedCondition<Boolean> jsLoading() {
        return driver -> getJsExecutor().executeScript("return document.readyState").equals("complete")
                    && (Boolean)getJsExecutor().executeScript("return window.jQuery == undefined || jQuery.active === 0");
    }
}

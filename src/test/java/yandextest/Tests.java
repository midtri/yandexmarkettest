package yandextest;

import org.junit.Test;
import yandextest.pageobjects.*;

import static org.junit.Assert.assertEquals;
import static yandextest.Statics.pageObject;

public class Tests extends BasicTest {
    @Test
    public void YandexMarketNotebookTest() {
        pageObject(YandexMenu.class).openMarketMenu();
        pageObject(YandexMarketTopMenu.class).openComputersMenu();
        pageObject(YandexMarketLeftMenu.class).openNotebooksMenu();
        YandexMarketCatalogList catalogList = pageObject(YandexMarketCatalogList.class);

        catalogList.setPriceTo(30000);
        catalogList.setBrand("HP");
        catalogList.setBrand("Lenovo");
        catalogList.applyFilter();

        assertEquals(12, catalogList.getItemListSize());

        String firstResult = catalogList.getItemListResult(0);
        catalogList.search(firstResult);

        assertEquals(firstResult, catalogList.getSearchValue());

        catalogList.openFirstSearchResult();

        assertEquals(firstResult, pageObject(YandexMarketProduct.class).getName());
    }

    @Test
    public void YandexMarketTabletTest() {
        pageObject(YandexMenu.class).openMarketMenu();
        pageObject(YandexMarketTopMenu.class).openComputersMenu();
        pageObject(YandexMarketLeftMenu.class).openTabletsMenu();
        YandexMarketCatalogList catalogList = pageObject(YandexMarketCatalogList.class);

        catalogList.setPriceFrom(20000);
        catalogList.setPriceTo(25000);
        catalogList.setBrand("Acer");
        catalogList.setBrand("Asus");
        catalogList.applyFilter();

        assertEquals(12, catalogList.getItemListSize());

        String firstResult = catalogList.getItemListResult(0);
        catalogList.search(firstResult);

        assertEquals(firstResult, catalogList.getSearchValue());

        catalogList.openFirstSearchResult();

        assertEquals(firstResult, pageObject(YandexMarketProduct.class).getName());
    }
}

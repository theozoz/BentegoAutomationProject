package org.bentego.test;

import org.bentego.base.BaseDriver;
import org.bentego.methods.Methods;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;


public class Work extends BaseDriver {

    Methods methods;
    String email="n11test@yopmail.com";
    String password="ZX.zx.12";
    int number;
    public By homeLoginBtnLocator=By.cssSelector("a.btnSignIn");
    public By loginEmailLocator=By.id("email");
    public By loginPasswordLocator=By.id("password");
    public By loginBtnLocator=By.id("loginButton");
    public By productNumberLocator=By.cssSelector("li.column");
    public By searchBoxLocator=By.id("searchData");
    public By searchBtnLocator=By.cssSelector("a.searchBtn");
    public By closePopupLocator=By.xpath("//div//span[@class=\"btn baseBtn-green\"]");
    public By searchPageTwoLocator=By.xpath("//div[@class=\"pagination\"]//a[text()=\"2\"]");
    public By productDetailTextLocator=By.cssSelector("h1.proName");
    public By addBasketBtnLocator=By.cssSelector("button.addBasketUnify");
    public By goToBasketLocator=By.xpath("//a[@title=\"Sepetim\"]");
    public By basketClosePopupLocator=By.xpath("//div//span[@class=\"btn btnBlack\"][text()=\"Tamam\"]");
    public By basketProductTitleLocator=By.xpath("//div//a[@class=\"prodDescription\"]");
    public By basketProductDeleteLocator=By.cssSelector("span.removeProd");
    public By productDeletePopupLocator=By.id("deleteBtnDFLB");
    public By emptyBasketLocator=By.xpath("//div[@class=\"cartEmptyText\"]//h2[text()=\"Sepetin Boş Görünüyor\"]");


    @Test
    public void Login()
    {
        methods= new Methods();
        String productBasketText,productDetailText;
        methods.clickElement(closePopupLocator);
        methods.clickElement(homeLoginBtnLocator);
        methods.sendKeys(loginEmailLocator,email);
        methods.sendKeys(loginPasswordLocator,password);
        methods.clickElement(loginBtnLocator);
        methods.clickElement(searchBoxLocator);
        methods.sendKeys(searchBoxLocator,"telefon");
        methods.clickElement(searchBtnLocator);
        methods.scrollToElement(searchPageTwoLocator);
        methods.clickElement(searchPageTwoLocator);
        number=methods.randomNumber();
        methods.setWait(1);
        methods.clickElements(productNumberLocator);
        productDetailText=methods.getText(productDetailTextLocator);
        methods.clickElement(addBasketBtnLocator);
        methods.clickElement(goToBasketLocator);
        methods.clickElement(basketClosePopupLocator);
        productBasketText=methods.getText(basketProductTitleLocator);
        Assertions.assertEquals(productBasketText,productDetailText);
        methods.clickElement(basketProductDeleteLocator);
        methods.clickElement(productDeletePopupLocator);
        methods.clickElement(emptyBasketLocator);
        methods.setWait(1);
    }
}

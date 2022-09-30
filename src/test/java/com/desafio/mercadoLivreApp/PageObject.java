package com.desafio.mercadoLivreApp;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public abstract class PageObject {
    protected AppiumDriver driver;

    protected PageObject(AppiumDriver appiumDriver) {
        this.driver = appiumDriver;
    }

    public void visualizaElemento(AppiumDriver driver, int timeLimitInSeconds, By idElement){
        WebDriverWait wait = new WebDriverWait(driver, timeLimitInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(idElement));
    }
}

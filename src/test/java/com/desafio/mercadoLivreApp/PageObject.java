package com.desafio.mercadoLivreApp;

import com.desafio.mercadoLivreApp.AppiumDriverConfig;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class PageObject {
    protected final AppiumDriver driver;

    protected PageObject(AppiumDriver driver) {
        this.driver = driver;
    }

    public abstract void buscarElementos();

    public void visualizaElemento(AppiumDriver driver, int timeLimitInSeconds, By idElement){
        WebDriverWait wait = new WebDriverWait(driver, timeLimitInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(idElement));
    }
}

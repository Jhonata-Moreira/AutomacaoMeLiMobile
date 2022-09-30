package com.desafio.mercadoLivreApp.PagesObjects;

import com.desafio.mercadoLivreApp.PageObject;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;

public class TelaLoginPage extends PageObject {

    By lblTelaLogin = By.id("com.mercadolibre:id/login_phone_title");
    By btnPular = By.id("com.mercadolibre:id/home_onboarding_action_skip_text_view");
    By btnVoltar = By.className("android.widget.ImageButton");

    public TelaLoginPage(AppiumDriver driver) {
        super(driver);
    }

    public HomePage acessaHome(){
        try{
            visualizaElemento(driver, 50, lblTelaLogin);
            driver.findElement(btnVoltar).click();
            visualizaElemento(driver, 30, btnPular);
            driver.findElement(btnPular).click();
        }catch(TimeoutException e){
            driver.findElement(btnPular).click();
        }

        return new HomePage(driver);
    }

}

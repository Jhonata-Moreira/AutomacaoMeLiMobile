package com.desafio.mercadoLivreApp.PagesObjects;

import com.desafio.mercadoLivreApp.AppiumDriverConfig;
import com.desafio.mercadoLivreApp.MobileElements.TelaLoginElements;
import com.desafio.mercadoLivreApp.PageObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class TelaLoginPage extends PageObject {

    By lblTelaLogin = By.id("com.mercadolibre:id/login_phone_title");
    By btnPular = By.id("com.mercadolibre:id/home_onboarding_action_skip_text_view");
    By btnVoltar = By.className("android.widget.ImageButton");
    By inptUser = By.id("com.mercadolibre:id/andes_textfield_edittext");
    By btnContinuar = By.id("com.mercadolibre:id/login_phone_continueButton");
    By btnCriarConta = By.id("com.mercadolibre:id/andes_button_text");

    public TelaLoginPage(AppiumDriver driver) {
        super(driver);
    }

    public HomePage acessaHome(){
        visualizaElemento(driver, 50, lblTelaLogin);
        driver.findElement(btnVoltar).click();
        visualizaElemento(driver, 50, btnPular);
        driver.findElement(btnPular).click();
        return new HomePage(driver);
    }

    public void preencheEmailClicaContinuar(){
        driver.findElements(inptUser);
    }

    @Override
    public void buscarElementos() {

    }
}

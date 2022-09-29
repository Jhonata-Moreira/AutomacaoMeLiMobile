package com.desafio.mercadoLivreApp.PagesObjects;

import com.desafio.mercadoLivreApp.PageObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import java.util.List;

public class WidgetProdutosPage extends PageObject {

    By lblMensagemErro = By.id("com.mercadolibre:id/ui_error_view_title");
    By lblProduto = By.id("com.mercadolibre:id/search_cell_title_text_view");

    protected WidgetProdutosPage(AppiumDriver driver) {
        super(driver);
    }

    @Override
    public void buscarElementos() {

    }

    public String retornoPesquisa(){
        try{
            visualizaElemento(driver, 30, lblProduto);
            return driver.findElement(lblProduto).getText();
        }catch(Exception e){
            visualizaElemento(driver, 30, lblMensagemErro);
            return driver.findElement(lblMensagemErro).getText();
        }

    }

}

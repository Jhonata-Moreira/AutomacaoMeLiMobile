package com.desafio.mercadoLivreApp.PagesObjects;

import com.desafio.mercadoLivreApp.CommosUtils;
import com.desafio.mercadoLivreApp.PageObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import java.io.IOException;

public class HomePage extends PageObject {

    By btnBusca = By.id("com.mercadolibre:id/ui_components_action_bar_title_toolbar");
    By inpBuscaProduto = By.id("com.mercadolibre:id/search_input_edittext");

    protected HomePage(AppiumDriver driver) {
        super(driver);
    }

    public void buscaProduto(String item) throws IOException {
        visualizaElemento(driver, 50, btnBusca);
        driver.findElement(btnBusca);
        // Busca item do CSV que será utilizado na pesquisa
        CommosUtils.retornaDadosCSV("nome");
        // Converte o item do BDD para poder pegar o valor em array
        driver.findElement(inpBuscaProduto).sendKeys(CommosUtils.produtoCSV[Integer.parseInt(item)]);
    }

    @Override
    public void buscarElementos() {

    }
}

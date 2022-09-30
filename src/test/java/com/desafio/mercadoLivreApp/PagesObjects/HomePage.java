package com.desafio.mercadoLivreApp.PagesObjects;

import com.desafio.mercadoLivreApp.CommosUtils;
import com.desafio.mercadoLivreApp.PageObject;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

import java.io.IOException;
import java.util.ArrayList;

public class HomePage extends PageObject {

    By btnBusca = By.id("com.mercadolibre:id/ui_components_action_bar_title_toolbar");
    By inpBuscaProduto = By.id("com.mercadolibre:id/search_input_edittext");

    protected HomePage(AppiumDriver driver) {
        super(driver);
    }

    public WidgetProdutosPage buscaProduto(String item) throws IOException {
        visualizaElemento(driver, 50, btnBusca);
        driver.findElement(btnBusca).click();

        // Busca item do CSV que será utilizado na pesquisa
        ArrayList<String> produto = CommosUtils.retornaDadosCSV("nome");

        // Converte o item do BDD para poder pegar o valor em array
        driver.findElement(inpBuscaProduto).sendKeys(produto.get(Integer.parseInt(item)));
        driver.executeScript("mobile: performEditorAction", ImmutableMap.of("action", "search"));

        CommosUtils.getScreenshoot(driver, "Busca o produto - " +
                produto.get(Integer.parseInt(item)) + "");

        return new WidgetProdutosPage(driver);
    }

}

package com.desafio.mercadoLivreApp.PagesObjects;

import com.desafio.mercadoLivreApp.CommosUtils;
import com.desafio.mercadoLivreApp.PageObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WidgetProdutosPage extends PageObject {

    By lblMensagemErro = By.id("com.mercadolibre:id/ui_error_view_title");
    By lblProduto = By.id("com.mercadolibre:id/search_cell_title_text_view");

    protected WidgetProdutosPage(AppiumDriver driver) {
        super(driver);
    }

    public boolean encontraProdutoPesquisa(String produtoProcurado) throws IOException {
        ArrayList<Boolean> textoEncontrado = new ArrayList<>();
        String labelProduto;

        try {
            visualizaElemento(driver, 30, lblProduto);
            List<WebElement> listaResultados = driver.findElements(lblProduto);

            for (WebElement resultado : listaResultados){
                labelProduto = resultado.getText();
                System.out.println(labelProduto);
                textoEncontrado.add(labelProduto.toLowerCase().contains(produtoProcurado.toLowerCase()));
            }
            CommosUtils.getScreenshoot(driver, "Produto procurado - " + produtoProcurado);
            return textoEncontrado.contains(true);
        } catch (Exception e) {
            visualizaElemento(driver, 10, lblMensagemErro);
            labelProduto = driver.findElement(lblMensagemErro).getText();

            CommosUtils.getScreenshoot(driver, "Mensagem de erro encontrado - " + produtoProcurado);
            return labelProduto.toLowerCase().contains(produtoProcurado.toLowerCase());
        }
    }

}

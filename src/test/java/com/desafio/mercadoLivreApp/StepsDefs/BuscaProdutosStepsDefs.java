package com.desafio.mercadoLivreApp.StepsDefs;

import com.desafio.mercadoLivreApp.CommosUtils;
import com.desafio.mercadoLivreApp.DriverConfig;
import com.desafio.mercadoLivreApp.PagesObjects.HomePage;
import com.desafio.mercadoLivreApp.PagesObjects.TelaLoginPage;
import com.desafio.mercadoLivreApp.PagesObjects.WidgetProdutosPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.io.IOException;

public class BuscaProdutosStepsDefs {

    private TelaLoginPage loginPage;
    private HomePage homePage;
    private WidgetProdutosPage widgetProdutosPage;

    private AppiumDriver driver;

    @Before
    public void inicializa(Scenario scenario) throws IOException {
        System.out.println(scenario.getName());
        driver = DriverConfig.getDriver();
        CommosUtils.getScreenshoot(driver, scenario.getName());
    }

    @After
    public void finalizaExecucao(){
        if (driver.getSessionId() != null){
            driver.quit();
        }
    }

    @Given("acesso a home de produtos")
    public void acessoAoAppNaTelaDeLogin() throws IOException {
        loginPage = new TelaLoginPage(driver);
        homePage = loginPage.acessaHome();
        CommosUtils.getScreenshoot(driver, "Acessa Home de produtos");
    }

    @When("realizo uma busca pelo item {string} da lista de produtos")
    public void realizoUmaBuscaPorUm(String item) throws IOException {
        // A lista encontra-se dentro da pasta massa/lista_produtos.csv
        widgetProdutosPage = homePage.buscaProduto(item);
    }

    @Then("vejo se o produto pesquisado foi encontrado com o nome {string} na lista de resultados")
    public void vejoSeOProdutoPesquisadoFoiEncontradoComONome(String produtoProcurado) throws IOException {
        Assert.assertTrue(widgetProdutosPage.encontraProdutoPesquisa(produtoProcurado));
    }

    @Then("vejo se a mensagem de erro foi encontrada {string}")
    public void vejoSeAMensagemDeErroFoiEncontrada(String mensagem) throws IOException {
        Assert.assertTrue(widgetProdutosPage.encontraProdutoPesquisa(mensagem));
    }
}

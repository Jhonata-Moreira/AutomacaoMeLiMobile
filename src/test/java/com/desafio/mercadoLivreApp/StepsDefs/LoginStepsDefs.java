package com.desafio.mercadoLivreApp.StepsDefs;

import com.desafio.mercadoLivreApp.AppiumDriverConfig;
import com.desafio.mercadoLivreApp.CommosUtils;
import com.desafio.mercadoLivreApp.PagesObjects.HomePage;
import com.desafio.mercadoLivreApp.PagesObjects.TelaLoginPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.io.IOException;

public class LoginStepsDefs {

    private TelaLoginPage loginPage;
    private HomePage homePage;

    @Given("acesso a home de produtos")
    public void acessoAoAppNaTelaDeLogin() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        loginPage = new TelaLoginPage(driver);
        homePage = loginPage.acessaHome();

    }

    @When("realizo uma busca pelo item {string} da lista de produtos")
    public void realizoUmaBuscaPorUm(String item) throws IOException {
        // A lista encontra-se dentro da pasta massa/lista_produtos.csv
        homePage.buscaProduto(item);
    }

    @Then("vejo se o produto pesquisado foi encontrado com o nome {string}")
    public void vejoSeOProdutoPesquisadoFoiEncontradoComONome(String arg0) {

    }

    @Then("vejo se a mensagem de erro foi encontrada {string}")
    public void vejoSeAMensagemDeErroFoiEncontrada(String arg0) {
    }
}

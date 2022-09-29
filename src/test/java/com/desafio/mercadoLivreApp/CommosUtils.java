package com.desafio.mercadoLivreApp;

import org.junit.jupiter.api.Test;

import java.io.*;

public class CommosUtils {

    public static String[] produtoCSV;

    public static String retornaDadosCSV(String produto) throws IOException {
        String line = "";

        try {
            // Parseia arquivo CSV em um buffer para leitura
            BufferedReader bufferedReader = new BufferedReader(
                    new FileReader("C:\\Users\\Dell\\Documents\\desafioAutomacao\\AutomacaoMeLiMobile\\src\\test\\resources\\massa\\lista_produtos.csv")
            );
            while ((line = bufferedReader.readLine()) != null)
            // Retornando true
            {
                produtoCSV = line.split(",");
                if (produto.equals("indice")){
                    return produtoCSV[0];
                }
                if(produto.equals("nome")){
                    return produtoCSV[1];
                }else if (produto.equals("descricao")){
                    return produtoCSV[2];
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }

        return line;
    }

    @Test
    public void testRetornaDadosSc() throws IOException {
        retornaDadosCSV("nome");
    }
}

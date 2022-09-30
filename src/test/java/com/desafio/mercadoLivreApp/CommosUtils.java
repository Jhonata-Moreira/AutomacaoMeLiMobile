package com.desafio.mercadoLivreApp;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class CommosUtils {

    public static ArrayList<String> produtos;
    public static String[] produtoCSV;

    public static ArrayList<String> retornaDadosCSV(String produto) throws IOException {
        String line = "";
        produtos = new ArrayList<>();
        try {
            // Parseia arquivo CSV em um buffer para leitura
            BufferedReader bufferedReader = new BufferedReader(
                    new FileReader(System.getProperty("user.dir") + "\\src\\test\\resources\\massa\\lista_produtos.csv")
            );
            while ((line = bufferedReader.readLine()) != null)
            // Retornando true
            {
                produtoCSV = line.split(",");
                switch (produto) {
                    case "indice":
                        produtos.add(produtoCSV[0]);
                        break;
                    case "nome":
                        produtos.add(produtoCSV[1]);
                        break;
                    default:
                        return produtos;
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return produtos;
    }

    public static void getScreenshoot(AppiumDriver<MobileElement> d, String nomeScenario) throws IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy hh mm ss");
        Date date = new Date();
        String fileName = sdf.format(date);
        File des = d.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(des, new File(System.getProperty("user.dir") + "\\Screenshot\\" + fileName + " - " +
                nomeScenario + ".png"));
    }
}

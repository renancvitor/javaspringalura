package com.renan.javaspring.principal;

import com.renan.javaspring.service.ConsumoApi;

import java.util.Scanner;

public class Principal {

    private Scanner scan = new Scanner(System.in);
    private ConsumoApi consumo = new ConsumoApi();

    private final String API_KEY = "1653b8ce";
    private final String ENDERECO = "https://www.omdbapi.com/?apikey=" + API_KEY + "&t=";

    public void exibeMenu() {
        System.out.println("Digite o nom e da série para buscar:");
        var nomeSerie = scan.nextLine();
        var json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ", "+"));
        // https://www.omdbapi.com/?apikey=1653b8ce&t=Supernatural&Season=5&Episode=3
    }
}

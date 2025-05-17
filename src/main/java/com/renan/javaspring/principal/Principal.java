package com.renan.javaspring.principal;

import com.renan.javaspring.model.DadosSerie;
import com.renan.javaspring.model.DadosTemporada;
import com.renan.javaspring.service.ConsumoApi;
import com.renan.javaspring.service.ConverteDados;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

    private Scanner scan = new Scanner(System.in);
    private ConsumoApi consumo = new ConsumoApi();
    private ConverteDados conversor = new ConverteDados();

    private final String API_KEY = "1653b8ce";
    private final String ENDERECO = "https://www.omdbapi.com/?apikey=" + API_KEY + "&t=";

    public void exibeMenu() {
        System.out.println("Digite o nom e da série para buscar:");
        var nomeSerie = scan.nextLine();
        var json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ", "+"));

        conversor = new ConverteDados();
        DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
        System.out.println(dados);

        List<DadosTemporada> temporadas = new ArrayList<>();

		for (int i = 1; i <= dados.totalTemporadas(); i++) {
			json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ", "+") +
                    "&Season=" + i);
			DadosTemporada dadosTemporada = conversor.obterDados(json, DadosTemporada.class);
			temporadas.add(dadosTemporada);
		}
		temporadas.forEach(System.out::println);

        // https://www.omdbapi.com/?apikey=1653b8ce&t=Supernatural&Season=5&Episode=3
    }
}

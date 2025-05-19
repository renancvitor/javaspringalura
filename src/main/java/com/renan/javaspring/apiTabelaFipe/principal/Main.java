package com.renan.javaspring.apiTabelaFipe.principal;

import com.renan.javaspring.apiTabelaFipe.model.DadosMarcas;
import com.renan.javaspring.apiTabelaFipe.model.DadosVeiculos;
import com.renan.javaspring.apiTabelaFipe.service.ConsumoApiFipe;
import com.renan.javaspring.apiTabelaFipe.service.ConverteDadosFipe;

import java.util.List;
import java.util.Scanner;

public class Main {

    private Scanner scan = new Scanner(System.in);
    private ConsumoApiFipe consumoFipe = new ConsumoApiFipe();
    private ConverteDadosFipe conversorFipe = new ConverteDadosFipe();
    
    private final String ENDERECO = "https://parallelum.com.br/fipe/api/v1/";

    public void exibeMenuFipe() {
        System.out.println("Digite o tipo de veículo (carros, motos, caminhoes):");
        var tipoVeiculo = scan.nextLine().trim().toLowerCase();

        if (!tipoVeiculo.equals("carros") && !tipoVeiculo.equals("motos") && !tipoVeiculo.equals("caminhoes")) {
            System.out.println("Tipo de veículo inválido.");
            return;
        }
        var json = consumoFipe.obterDadosFipe(ENDERECO + tipoVeiculo.replace(" ", "+") + "/marcas/");

        consumoFipe = new ConsumoApiFipe();
        List<DadosMarcas> marcas = conversorFipe.obterLista(json, DadosMarcas.class);
        System.out.println(marcas);

        marcas.forEach(m -> System.out.println("Código: " + m.codigo() + " | Marca: " + m.nome()));

    }
}

package com.renan.javaspring.apiTabelaFipe.principal;

import com.renan.javaspring.apiTabelaFipe.model.DadosMarcas;
import com.renan.javaspring.apiTabelaFipe.model.DadosModelos;
import com.renan.javaspring.apiTabelaFipe.model.DadosVeiculos;
import com.renan.javaspring.apiTabelaFipe.model.Modelo;
import com.renan.javaspring.apiTabelaFipe.service.ConsumoApiFipe;
import com.renan.javaspring.apiTabelaFipe.service.ConverteDadosFipe;

import java.util.*;

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

        marcas.forEach(m -> System.out.println("Código: " + m.codigo() +
                " | Marca: " + m.nome()));

        Map<String, String> mapaMarcas = new HashMap<>();
        for (DadosMarcas marca : marcas) {
            mapaMarcas.put(marca.nome().toLowerCase(), marca.codigo());
        }

        System.out.println("Digite o nome da marca:");
        var nomeMarca = scan.nextLine().toLowerCase();

        var marcaEncontrada = marcas.stream()
                .filter(m -> m.nome().toLowerCase().contains(nomeMarca))
                .findFirst();

        if (marcaEncontrada.isEmpty()) {
            System.out.println("Marca não encontrada.");
            return;
        }

        var marca = marcaEncontrada.get();
        var jsonMarca = consumoFipe.obterDadosFipe(
                ENDERECO + tipoVeiculo + "/marcas/" + marca.codigo() + "/modelos"
        );

        DadosModelos respostaModelos = conversorFipe.obterDadosFipe(jsonMarca, DadosModelos.class);
        List<Modelo> modelos = respostaModelos.modelos();
        modelos.forEach(m -> System.out.println("Modelo: " + m.nome() + " | Código: " + m.codigo()));

    }
}

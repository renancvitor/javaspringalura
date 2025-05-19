package com.renan.javaspring.apiTabelaFipe.principal;

import com.renan.javaspring.apiTabelaFipe.service.ConsumoApiFipe;
import com.renan.javaspring.apiTabelaFipe.service.ConverteDadosFipe;

import java.util.Scanner;

public class Main {

    private Scanner scan = new Scanner(System.in);
    private ConsumoApiFipe consumoFipe = new ConsumoApiFipe();
    private ConverteDadosFipe conversorFipe = new ConverteDadosFipe();
    
    private final String ENDERECO = "https://parallelum.com.br/fipe/api/v1/";

    public void exibeMenuFipe() {

    }
}

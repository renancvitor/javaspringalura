package com.renan.javaspring.apiTabelaFipe.model;

public class Veiculos {
    private String tipo;
    private String marca;
    private String modelo;
    private Integer ano;
    private String valor;
    private String codigoFipe;

    public Veiculos(DadosVeiculos dadosVeiculos) {
        this.tipo = dadosVeiculos.tipoVeiculo();
        this.marca = dadosVeiculos.marca();
        this.modelo = dadosVeiculos.modelo();
        this.ano = dadosVeiculos.anoModelo();
        this.valor = dadosVeiculos.valor();
        this.codigoFipe = dadosVeiculos.codigoFipe();
    }

    public String getTipo() {
        return tipo;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public Integer getAno() {
        return ano;
    }

    public String getValor() {
        return valor;
    }

    public String getCodigoFipe() {
        return codigoFipe;
    }
}

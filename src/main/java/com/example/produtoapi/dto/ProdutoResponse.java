package com.example.produtoapi.dto;

public class ProdutoResponse {

    private Long id;
    private String nome;
    private Double preco;

    public ProdutoResponse(Long id, String nome, Double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    //Geters
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Double getPreco() {
        return preco;
    }
}

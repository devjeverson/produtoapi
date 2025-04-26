package com.example.produtoapi.service;

import com.example.produtoapi.dto.ProdutoRequest;
import com.example.produtoapi.dto.ProdutoResponse;
import com.example.produtoapi.model.Produto;
import com.example.produtoapi.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public List<ProdutoResponse> listarTodos() {
       return repository.findAll()
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public ProdutoResponse salvar(ProdutoRequest request) {
        Produto produto = Produto.builder()
                .nome(request.getNome())
                .preco(request.getPreco())
                .build();

        Produto salvo = repository.save(produto);
        return toResponse(salvo);
    }

    private ProdutoResponse toResponse(Produto produto) {
        return new ProdutoResponse(produto.getId(), produto.getNome(), produto.getPreco());
    }
}

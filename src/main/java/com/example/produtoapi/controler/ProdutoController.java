package com.example.produtoapi.controler;

import com.example.produtoapi.dto.ProdutoRequest;
import com.example.produtoapi.dto.ProdutoResponse;
import com.example.produtoapi.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @GetMapping
    public List<ProdutoResponse> listar() {
        return service.listarTodos();
    }

    @PostMapping
    public ProdutoResponse criar(@RequestBody @Valid ProdutoRequest request) {
        return service.salvar(request);
    }
}

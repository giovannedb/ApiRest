package com.cursoapiudemy.cursor_api_udemy.controller;

import org.springframework.web.bind.annotation.RestController;

import com.cursoapiudemy.cursor_api_udemy.model.Produto;
import com.cursoapiudemy.cursor_api_udemy.services.ProdutoService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/produtos")

public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    // para o controller saber que esse método é uma consulta precisa da anotação:
    @GetMapping
    public List<Produto> obterTodos() {
        return produtoService.obterTodos();
    }

    // Digo que oque vier depois da barra do id, o spring pega o valor e transforma
    // em id com o @pathVariable
    @GetMapping("/{id}")
    public Optional<Produto> obterPorId(@PathVariable Integer id) {
        // obter o id que venho pela URL
        return produtoService.obterPorId(id);
    }

    // Metodo adicionar é um postMapping
    @PostMapping
    // usando o @ResquetBody estou falando para o spring que oque ele receber do
    // usuario
    // ele tranforma em "Produto"
    public Produto adicionar(@RequestBody Produto produto) {
        // retorno meu adicionar o produto
        return produtoService.adicionar(produto);
    }

    // Deleta pelo id da URL
    @DeleteMapping("/{id}")
    public String deletar(@PathVariable Integer id) {
        produtoService.deletar(id);
        return "O produto com o ID: " + id + ", foi deletado com sucesso! ";
        // return "Produto com o id:" + id + "foi deletado com sucesso!";
    }

    // passando o id para saber qual produto vou adicionar
    // recebo o produto e recebo o id e converto em id
    @PutMapping("/{id}")
    public Produto atualizar(@RequestBody Produto produto, @PathVariable Integer id) {

        // recebe id da url os dados do json e transforma em produto e manda para o
        // service resolver
        return produtoService.atualizar(id, produto);
    }
}

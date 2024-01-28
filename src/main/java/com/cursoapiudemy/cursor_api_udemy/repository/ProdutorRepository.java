package com.cursoapiudemy.cursor_api_udemy.repository;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import org.apache.tomcat.util.file.ConfigurationSource.Resource;
import org.springframework.stereotype.Repository;

import com.cursoapiudemy.cursor_api_udemy.model.Produto;
import com.cursoapiudemy.cursor_api_udemy.model.exception.ResourceNotFoundExcepetion;

import java.util.Optional;

@Repository
public class ProdutorRepository {

    // Simulando um banco de dados.
    // Tudo aqui está em memoria, quando reiniado será todos produtos atualizado
    private ArrayList<Produto> produtos = new ArrayList<Produto>();
    private Integer ultimoId = 0;

    /**
     * Quando chamar esse metodo, ele me retorna uma lista de produtos
     * 
     * @return lista de produtos
     */
    public List<Produto> obterTodos() {
        return produtos;
    }

    /**
     * Metodo que retorna o produto encontrado pelo seu ID
     * 
     * @param id do produto que será localizado
     * @return Um produto caso seja encontrado
     */
    public Optional<Produto> obterPorId(Integer id) {
        return produtos
                .stream()
                // filtro pego somente o produto que tiver o getId = o id do parametro
                .filter(produto -> produto.getId() == id)
                // first devolve o option, option garante que não vai dar erro se não encontrar
                // ninguem ele devolve vazio
                // e pego o primeiro e retorno o ID unico
                .findFirst();
    }

    /**
     * Metodo par adicionar produto na lista
     * 
     * @param produto que será adicionado
     * @return produto que foi adicionado na lista
     */
    public Produto adicionar(Produto produto) {

        // pega o ultimo id e adiciona mais 1
        ultimoId++;
        // gravo no produto novo id
        produto.setId(ultimoId);
        // adicionando no banco
        produtos.add(produto);

        return produto;
    }

    /**
     * Metodo para deletar produto por id
     * 
     * @param id do produto a ser deletado
     */
    public void deletar(Integer id) {
        // removeif - remove dentro de uma lista de acordo com o filtro que vc passar a
        // ela
        // se o id que estou passando é igual o produto que tenho la dentro, e se achar
        // ele deleta
        // ele faz um for em todos produtos
        produtos.removeIf(produto -> produto.getId() == id);
    }

    /**
     * Metodo para atualizar produto
     * 
     * @param produto
     * @return
     */
    public Produto atualizar(Produto produto) {
        // encontrar produto na lista
        // o
        Optional<Produto> produtoEncontrado = obterPorId(produto.getId());
        // se não encontrou nenhuma produto - isEmpty = vazio
        if (produtoEncontrado.isEmpty()) {
            throw new ResourceNotFoundExcepetion("Produto não encontrado");
        }

        // remover o produto antigo da lista
        deletar(produto.getId());

        // adicionar o produto atualizado na lista
        produtos.add(produto);

        return produto;
    }

}

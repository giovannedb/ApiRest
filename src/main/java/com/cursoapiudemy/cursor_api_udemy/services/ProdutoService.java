package com.cursoapiudemy.cursor_api_udemy.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursoapiudemy.cursor_api_udemy.model.Produto;
import com.cursoapiudemy.cursor_api_udemy.repository.ProdutorRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutorRepository produtorRepository;

    /**
     * Metodo para retornar uma lista de produtos
     * 
     * @return Lista de produtos
     */
    public List<Produto> obterTodos() {
        // serviço pede para o repositorio devolver a lista de produtos.
        // obtendo todos produtos sem nenhuma regra
        return produtorRepository.obterTodos();
    }

    public Optional<Produto> obterPorId(Integer id) {
        return produtorRepository.obterPorId(id);
    }

    /**
     * Metodo para adicionar produto
     * 
     * @param produto
     * @return
     */
    public Produto adicionar(Produto produto) {
        // posso colocar regra para adicionar produto
        return produtorRepository.adicionar(produto);
    }

    /**
     * Deletar produto por id
     * 
     * @param id
     */
    public void deletar(Integer id) {
        // colocar logica de validação para deletar
        produtorRepository.deletar(id);
    }

    /**
     * Atualizar produto na lista
     * 
     * @param id      do produto
     * @param produto que será atualizado
     * @return Produto atualizado
     */
    public Produto atualizar(Integer id, Produto produto) {
        // validação no id
        produto.setId(id);
        return produtorRepository.atualizar(produto);

    }
}

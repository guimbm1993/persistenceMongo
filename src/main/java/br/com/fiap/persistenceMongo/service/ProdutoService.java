package br.com.fiap.persistenceMongo.service;

import br.com.fiap.persistenceMongo.entity.Produto;

public interface ProdutoService {

    Produto saveProduto(Produto produto);
    Iterable<Produto> saveAllProdutos(Iterable<Produto> produtos);
    Iterable<Produto> findAll();
    Produto findById(String id);
    String deleteById(String id);

}

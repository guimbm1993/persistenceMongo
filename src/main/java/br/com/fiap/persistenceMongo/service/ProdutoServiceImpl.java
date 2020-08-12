package br.com.fiap.persistenceMongo.service;

import br.com.fiap.persistenceMongo.entity.Produto;
import br.com.fiap.persistenceMongo.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    @Override
    public Produto saveProduto(Produto produto) {
        if(produto.getValor() == null){
            produto.setValor(0.0);
        }
        if(produto.getQuantidade() == null){
            produto.setQuantidade(0);
        }
        return produtoRepository.save(produto);
    }

    @Override
    public Iterable<Produto> saveAllProdutos(Iterable<Produto> produtos) {
        return produtoRepository.saveAll(produtos);
    }

    @Override
    public Iterable<Produto> findAll() {
        return produtoRepository.findAll();
    }

    @Override
    public Produto findById(String id) {
        return produtoRepository.findById(id).orElseThrow(()->new RuntimeException("Produto não encontrado"));
    }

    @Override
    public String deleteById(String id) {

        produtoRepository.deleteById(id);
        return  "Produto excluído";
    }
}

package br.com.fiap.persistenceMongo.service;

import br.com.fiap.persistenceMongo.entity.Cliente;
import br.com.fiap.persistenceMongo.entity.Endereco;
import br.com.fiap.persistenceMongo.entity.Pedido;
import br.com.fiap.persistenceMongo.entity.Produto;
import br.com.fiap.persistenceMongo.entity.dto.PedidoDTO;
import br.com.fiap.persistenceMongo.entity.dto.ProdutoDTO;
import br.com.fiap.persistenceMongo.repository.ClienteRepository;
import br.com.fiap.persistenceMongo.repository.EnderecoRepository;
import br.com.fiap.persistenceMongo.repository.PedidoRepository;
import br.com.fiap.persistenceMongo.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoServiceImpl implements  PedidoService {

    @Autowired
    PedidoRepository pedidoRepository;

    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    EnderecoRepository enderecoRepository;

    @Override
    public Pedido savePedido(PedidoDTO pedidoDTO) {

        Pedido pedido = new Pedido();
        pedido.setData(new Date().toString());
        Cliente cliente = clienteRepository
                .findById(pedidoDTO.getIdCliente())
                .orElseThrow(()->new RuntimeException("cliente não encontrado"));
        Endereco endereco = enderecoRepository.findById(pedidoDTO.getIdEndereco())
                .orElseThrow(()->new RuntimeException("Endereço de entrega não encontrado"));
        pedido.setEnderecoEntrega(endereco);
        pedido.setCliente(cliente);
        List<Produto> produtos = new ArrayList<>();
        //atualizando estoque
        for(ProdutoDTO produtoAux: pedidoDTO.getProdutos()){
            Optional<Produto> produtoEstoque = produtoRepository.findById(produtoAux.getIdProduto());
            Optional<Produto> produtoPedido = produtoRepository.findById(produtoAux.getIdProduto());
            if(produtoEstoque.isPresent()){
                produtoEstoque.get().setQuantidade(produtoEstoque.get().getQuantidade() - produtoAux.getQuantidade());
                produtoRepository.save(produtoEstoque.get());
            }
            if(produtoPedido.isPresent()){
                produtos.add(produtoPedido.get());
            }
        }
        pedido.setProdutos(produtos);
        return pedidoRepository.save(pedido);
    }

    @Override
    public Iterable<Pedido> findAll() {
        return pedidoRepository.findAll();
    }

    @Override
    public Pedido findById(String id) {
        return pedidoRepository.findById(id).orElseThrow(()-> new RuntimeException("Pedido não encontrado"));
    }

    @Override
    public String deleteById(String id) {

        Optional<Pedido> pedido = pedidoRepository.findById(id);

        if(pedido.isPresent()){
            if(!pedido.get().getProdutos().isEmpty()){
                for(Produto produtoAux:pedido.get().getProdutos()){
                    Optional<Produto> produtoEstoque = produtoRepository.findById(produtoAux.getId());
                    if(produtoEstoque.isPresent()){
                        produtoEstoque.get()
                                .setQuantidade(produtoEstoque.get().getQuantidade()+produtoAux.getQuantidade());
                        produtoRepository.save(produtoEstoque.get());
                    }
                }
            }
            pedidoRepository.deleteById(id);
            return "Pedido excluído";
        }

        return "Pedido não encontrado";
    }
}

package br.com.fiap.persistenceMongo.service;

import br.com.fiap.persistenceMongo.entity.Pedido;
import br.com.fiap.persistenceMongo.entity.dto.PedidoDTO;

public interface PedidoService {

    Pedido savePedido(PedidoDTO pedidoDTO);
    Iterable<Pedido> findAll();
    Pedido findById(String id);
    String deleteById(String id);

}

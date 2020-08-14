package br.com.fiap.persistenceMongo.repository;

import br.com.fiap.persistenceMongo.entity.Pedido;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends MongoRepository<Pedido,String> {
}

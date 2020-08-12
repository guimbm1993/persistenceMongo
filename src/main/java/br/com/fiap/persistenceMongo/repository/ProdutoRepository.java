package br.com.fiap.persistenceMongo.repository;

import br.com.fiap.persistenceMongo.entity.Produto;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProdutoRepository extends MongoRepository<Produto,String> {
}

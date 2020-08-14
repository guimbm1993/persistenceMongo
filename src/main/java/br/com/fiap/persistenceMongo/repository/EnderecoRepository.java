package br.com.fiap.persistenceMongo.repository;

import br.com.fiap.persistenceMongo.entity.Endereco;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends MongoRepository<Endereco,String> {
}

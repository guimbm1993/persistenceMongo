package br.com.fiap.persistenceMongo.repository;


import br.com.fiap.persistenceMongo.entity.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClienteRepository extends MongoRepository<Cliente,String> {
}

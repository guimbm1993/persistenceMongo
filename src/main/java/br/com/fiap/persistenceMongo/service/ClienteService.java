package br.com.fiap.persistenceMongo.service;

import br.com.fiap.persistenceMongo.entity.Cliente;

public interface ClienteService {

    Cliente saveCliente(Cliente cliente);
    Iterable<Cliente> findAll();
    Cliente findById(String id);
    String deleteById(String id);

}

package br.com.fiap.persistenceMongo.service;

import br.com.fiap.persistenceMongo.entity.Cliente;
import br.com.fiap.persistenceMongo.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public Cliente saveCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Iterable<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente findById(String id) {
        return clienteRepository.findById(id).orElseThrow(()-> new RuntimeException("não encontrado"));
    }

    @Override
    public String deleteById(String id) {
        Optional<Cliente> result = clienteRepository.findById(id);
        if(result.isPresent()){
            clienteRepository.delete(result.get());
            return "Registro excluído";
        }
        return "Não foi possível excluir";
    }
}

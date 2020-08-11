package br.com.fiap.persistenceMongo.controller;

import br.com.fiap.persistenceMongo.entity.Cliente;
import br.com.fiap.persistenceMongo.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @PostMapping("/clients")
    public @ResponseBody
    ResponseEntity<?> salvarCliente(@RequestBody Cliente cliente){
        return ResponseEntity.ok().body(clienteService.saveCliente(cliente));
    }

    @GetMapping("/clients")
    public @ResponseBody
    ResponseEntity<?> listarTodos(){
        return ResponseEntity.ok().body(clienteService.findAll());
    }

    @GetMapping("/clients/{id}")
    public @ResponseBody ResponseEntity<?> listarPorId(@PathVariable String id){
        return ResponseEntity.ok().body(clienteService.findById(id));
    }

    @PutMapping("/clients")
    public @ResponseBody ResponseEntity<?> atualizarCliente(@RequestBody Cliente cliente){
        return ResponseEntity.ok().body(clienteService.saveCliente(cliente));
    }

    @DeleteMapping("/clients/{id}")
    public @ResponseBody ResponseEntity<?> deletarCliente(@PathVariable String id){
        return ResponseEntity.ok().body(clienteService.deleteById(id));
    }


}

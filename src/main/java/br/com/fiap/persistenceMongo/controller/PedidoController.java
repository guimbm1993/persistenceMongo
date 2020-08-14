package br.com.fiap.persistenceMongo.controller;

import br.com.fiap.persistenceMongo.entity.dto.PedidoDTO;
import br.com.fiap.persistenceMongo.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PedidoController {

    @Autowired
    PedidoService pedidoService;

    @PostMapping("/orders")
    public @ResponseBody
    ResponseEntity<?> salvarPedido(@RequestBody PedidoDTO pedidoDTO){
        return ResponseEntity.ok().body(pedidoService.savePedido(pedidoDTO));
    }

    @GetMapping("/orders")
    public @ResponseBody ResponseEntity<?> listarTodos(){
        return ResponseEntity.ok().body(pedidoService.findAll());
    }

    @GetMapping("/orders/{id}")
    public @ResponseBody ResponseEntity<?> listarPorId(@PathVariable String id){
        return ResponseEntity.ok().body(pedidoService.findById(id));
    }

    @DeleteMapping("orders/{id}")
    public @ResponseBody ResponseEntity<?> deletarPorId(@PathVariable String id){
        return ResponseEntity.ok().body(pedidoService.deleteById(id));
    }


}

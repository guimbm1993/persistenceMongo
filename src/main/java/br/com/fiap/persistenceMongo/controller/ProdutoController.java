package br.com.fiap.persistenceMongo.controller;

import br.com.fiap.persistenceMongo.entity.Produto;
import br.com.fiap.persistenceMongo.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @PostMapping("/products")
    public @ResponseBody
    ResponseEntity<?> salvarProduto(@RequestBody Produto produto){
        return ResponseEntity.ok().body(produtoService.saveProduto(produto));
    }

    @GetMapping("/products")
    public @ResponseBody ResponseEntity<?> listarTodos(){
        return ResponseEntity.ok().body(produtoService.findAll());
    }

    @GetMapping("/products/{id}")
    public @ResponseBody ResponseEntity<?> listarPorId(@PathVariable String id){
        return ResponseEntity.ok().body(produtoService.findById(id));
    }

    @PutMapping("/products")
    public @ResponseBody ResponseEntity<?> alterarProduto(@RequestBody Produto produto){
        return ResponseEntity.ok().body(produtoService.saveProduto(produto));
    }

    @DeleteMapping("/products/{id}")
    public @ResponseBody ResponseEntity<?> deleteProduto(@PathVariable String id){
        return ResponseEntity.ok().body(produtoService.deleteById(id));
    }

}

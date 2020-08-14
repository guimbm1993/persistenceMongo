package br.com.fiap.persistenceMongo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Pedido {

    @Id
    private String idPedido;
    private Endereco enderecoEntrega;
    private  Cliente cliente;
    private List<Produto> produtos;
    private String data;
}

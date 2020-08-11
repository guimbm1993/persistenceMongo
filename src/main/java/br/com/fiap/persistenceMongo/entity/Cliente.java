package br.com.fiap.persistenceMongo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Cliente {

    @Id
    private String id;
    private String cpf;
    private String nome;
    private String email;
    private List<Endereco> enderecos;

    public Cliente(String cpf, String nome, String email, List<Endereco> enderecos) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.enderecos = enderecos;
    }
}

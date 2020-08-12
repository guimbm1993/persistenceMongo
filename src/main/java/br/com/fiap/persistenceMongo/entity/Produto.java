package br.com.fiap.persistenceMongo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Produto {

    @Id
    private String id;
    private String nome;
    private Double valor;
    private Integer quantidade;

}

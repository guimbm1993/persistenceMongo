package br.com.fiap.persistenceMongo.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class ProdutoDTO {

    private String idProduto;
    private int quantidade;

}
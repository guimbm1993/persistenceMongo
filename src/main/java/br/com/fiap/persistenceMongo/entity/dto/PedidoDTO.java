package br.com.fiap.persistenceMongo.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class PedidoDTO {

    private String idCliente;
    private String idEndereco;
    private List<ProdutoDTO> produtos;

}

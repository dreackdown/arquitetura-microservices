package dev.hugofaria.msclientes.api.model.input;

import dev.hugofaria.msclientes.domain.model.Cliente;
import lombok.Data;

@Data
public class ClienteDTO {
    private String cpf;
    private String nome;
    private Integer idade;

    public Cliente toModel() {
        return new Cliente(cpf, nome, idade);
    }
}
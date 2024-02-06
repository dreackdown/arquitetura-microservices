package dev.hugofaria.msavaliadorcredito.domain.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class DadosSolicitacaoEmissaoCartao {
    private Long cartaoId;
    private String cpf;
    private String endereco;
    private BigDecimal limiteLiberado;
}
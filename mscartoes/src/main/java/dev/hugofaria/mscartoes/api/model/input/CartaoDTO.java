package dev.hugofaria.mscartoes.api.model.input;

import dev.hugofaria.mscartoes.domain.model.BandeiraCartao;
import dev.hugofaria.mscartoes.domain.model.Cartao;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartaoDTO {
    private String nome;
    private BandeiraCartao bandeira;
    private BigDecimal renda;
    private BigDecimal limite;

    public Cartao toModel() {
        return new Cartao(nome, bandeira, renda, limite);
    }
}
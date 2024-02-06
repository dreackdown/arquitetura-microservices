package dev.hugofaria.mscartoes.domain.service;

import dev.hugofaria.mscartoes.domain.model.Cartao;
import dev.hugofaria.mscartoes.domain.repository.CartaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CartaoService {

    private final CartaoRepository cartaoRepository;

    @Transactional
    public void cadastrar(Cartao novoCartao) {
        cartaoRepository.save(novoCartao);
    }

    public List<Cartao> buscaCartoesRendaMenorIgual(Long renda) {

        var rendaBigDecimal = BigDecimal.valueOf(renda);
        return cartaoRepository.findByRendaLessThanEqual(rendaBigDecimal);
    }
}
package dev.hugofaria.mscartoes.domain.service;

import dev.hugofaria.mscartoes.domain.model.ClienteCartao;
import dev.hugofaria.mscartoes.domain.repository.ClienteCartaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteCartaoService {

    private final ClienteCartaoRepository repository;

    public List<ClienteCartao> buscaCartoesPorCpf(String cpf) {
        return repository.findByCpf(cpf);
    }
}
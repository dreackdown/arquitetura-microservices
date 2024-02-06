package dev.hugofaria.msclientes.domain.service;

import dev.hugofaria.msclientes.domain.model.Cliente;
import dev.hugofaria.msclientes.domain.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    @Transactional
    public void cadastrar(Cliente novoCliente) {
        clienteRepository.save(novoCliente);
    }

    public Optional<Cliente> buscarPorCPF(String cpf) {
        return clienteRepository.findByCpf(cpf);
    }
}
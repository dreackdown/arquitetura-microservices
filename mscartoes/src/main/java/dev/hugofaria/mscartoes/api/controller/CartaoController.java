package dev.hugofaria.mscartoes.api.controller;

import dev.hugofaria.mscartoes.api.model.CartoesPorClienteDTO;
import dev.hugofaria.mscartoes.api.model.input.CartaoDTO;
import dev.hugofaria.mscartoes.domain.model.Cartao;
import dev.hugofaria.mscartoes.domain.model.ClienteCartao;
import dev.hugofaria.mscartoes.domain.service.CartaoService;
import dev.hugofaria.mscartoes.domain.service.ClienteCartaoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cartoes")
@RequiredArgsConstructor
@Slf4j
public class CartaoController {

    private final CartaoService cartaoService;
    private final ClienteCartaoService clienteCartaoService;

    @GetMapping
    public String status() {
        log.info("Obtendo o status do microservice de cartoes");
        return "ok";
    }

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody CartaoDTO request) {

        var cartao = request.toModel();
        cartaoService.cadastrar(cartao);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(params = "renda")
    public ResponseEntity<?> buscaCartoesRendaMenorIgual(@RequestParam("renda") Long renda) {

        List<Cartao> cartoes = cartaoService.buscaCartoesRendaMenorIgual(renda);
        return ResponseEntity.ok(cartoes);
    }

    @GetMapping(params = "cpf")
    public ResponseEntity<List<CartoesPorClienteDTO>> buscaCartoesPorCpf(@RequestParam("cpf") String cpf) {

        List<ClienteCartao> cartoes = clienteCartaoService.buscaCartoesPorCpf(cpf);

        List<CartoesPorClienteDTO> resultado = cartoes.stream()
                .map(CartoesPorClienteDTO::fromModel)
                .collect(Collectors.toList());

        return ResponseEntity.ok(resultado);
    }
}
package dev.hugofaria.msavaliadorcredito.infra.clients;

import dev.hugofaria.msavaliadorcredito.domain.model.Cartao;
import dev.hugofaria.msavaliadorcredito.domain.model.CartaoCliente;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "mscartoes", path = "/cartoes")
public interface CartoesResourceClient {

    @GetMapping(params = "cpf")
    ResponseEntity<List<CartaoCliente>> buscaCartoesPorCliente(@RequestParam("cpf") String cpf);

    @GetMapping(params = "renda")
    ResponseEntity<List<Cartao>> buscaCartoesRendaMenorIgual(@RequestParam("renda") Long renda);
}
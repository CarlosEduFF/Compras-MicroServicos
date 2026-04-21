package com.api.produto.controller;

import com.api.produto.controller.adapter.CompraControllerAdapter;
import com.api.produto.controller.dto.request.CompraRequest;
import com.api.produto.controller.dto.response.CompraResponse;
import com.api.produto.entity.Compra;
import com.api.produto.integration.ClienteClient;
import com.api.produto.integration.dto.ClienteResponse;
import com.api.produto.repository.CompraRepository;
import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
public class CompraController {

    private final CompraRepository compraRepository;
    private final ClienteClient clienteClient;

    public CompraController(CompraRepository compraRepository, ClienteClient clienteClient) {
        this.compraRepository = compraRepository;
        this.clienteClient = clienteClient;
    }

    @PostMapping("/produto/compra/cadastrar")
    public CompraResponse cadastrar(@RequestBody CompraRequest request) {
        // Valida se o cliente existe através do Feign Client.
        try {
            ClienteResponse cliente = clienteClient.consultarCliente(request.clienteId());
            if (cliente == null) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado.");
            }
        } catch (FeignException.NotFound e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado.");
        } catch (FeignException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao se comunicar com a API de Cliente.");
        }

        Compra compra = CompraControllerAdapter.castRequest(request);
        Compra compraSalva = compraRepository.cadastrar(compra);
        return CompraControllerAdapter.castResponse(compraSalva);
    }

    @GetMapping("/produto/compra/cliente/{clienteId}")
    public Collection<CompraResponse> listarPorCliente(@PathVariable String clienteId) {
        Collection<Compra> compras = compraRepository.consultarPorCliente(clienteId);
        return compras.stream()
                .map(CompraControllerAdapter::castResponse)
                .collect(Collectors.toList());
    }
}

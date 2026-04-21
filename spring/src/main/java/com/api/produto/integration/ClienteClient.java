package com.api.produto.integration;

import com.api.produto.integration.dto.ClienteResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "api-cliente", url = "http://localhost:8080")
public interface ClienteClient {

    @GetMapping("/cliente/{id}")
    ClienteResponse consultarCliente(@PathVariable("id") String id);

}

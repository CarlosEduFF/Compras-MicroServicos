package com.api.produto.controller.adapter;

import com.api.produto.controller.dto.request.CompraRequest;
import com.api.produto.controller.dto.response.CompraResponse;
import com.api.produto.entity.Compra;

import java.util.UUID;

public class CompraControllerAdapter {

    private CompraControllerAdapter() {
    }

    public static Compra castRequest(CompraRequest request) {
        return new Compra(
                UUID.randomUUID().toString(),
                request.clienteId(),
                request.produtoIds()
        );
    }

    public static CompraResponse castResponse(Compra compra) {
        return new CompraResponse(
                compra.id(),
                compra.clienteId(),
                compra.produtoIds()
        );
    }
}

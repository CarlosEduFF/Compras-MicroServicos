package com.api.produto.controller.adapter;

import com.api.produto.controller.dto.request.ProdutoRequest;
import com.api.produto.controller.dto.response.ProdutoResponse;
import com.api.produto.entity.Produto;

import java.util.UUID;

public class ProdutoControllerAdapter {
    public static Produto castRequest(ProdutoRequest request) {

        String id = request.id();

        if (id == null || id.isBlank()) {
            id = UUID.randomUUID().toString();
        }

        return new Produto(
                id,
                request.nome(),
                request.preco()
        );
    }

    public static ProdutoResponse castResponse(Produto produto) {
        return new ProdutoResponse(
                produto.id(),
                produto.nome(),
                produto.preco()
        );
    }

}

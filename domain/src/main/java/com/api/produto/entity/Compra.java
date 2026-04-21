package com.api.produto.entity;

import java.util.List;

public record Compra(
        String id,
        String clienteId,
        List<String> produtoIds
) {
}

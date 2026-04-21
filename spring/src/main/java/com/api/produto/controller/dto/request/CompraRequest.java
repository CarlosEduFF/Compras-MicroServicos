package com.api.produto.controller.dto.request;

import java.util.List;

public record CompraRequest(
        String clienteId,
        List<String> produtoIds
) {
}

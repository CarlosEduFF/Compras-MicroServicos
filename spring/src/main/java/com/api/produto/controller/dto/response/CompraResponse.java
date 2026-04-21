package com.api.produto.controller.dto.response;

import java.util.List;

public record CompraResponse(
        String id,
        String clienteId,
        List<String> produtoIds
) {
}

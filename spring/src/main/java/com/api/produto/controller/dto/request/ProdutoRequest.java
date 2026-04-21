package com.api.produto.controller.dto.request;

import java.math.BigDecimal;

public record ProdutoRequest (
            String id,
            String nome,
            BigDecimal preco
    ){
}

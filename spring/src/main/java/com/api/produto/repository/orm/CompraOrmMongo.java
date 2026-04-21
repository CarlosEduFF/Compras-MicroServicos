package com.api.produto.repository.orm;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "compras")
public record CompraOrmMongo(
        @Id String id,
        String clienteId,
        List<String> produtoIds
) {
}

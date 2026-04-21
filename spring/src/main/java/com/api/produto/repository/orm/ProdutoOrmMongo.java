package com.api.produto.repository.orm;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(value = "produto")
public record ProdutoOrmMongo(
        @Id
        String id,
        String nome,
        BigDecimal preco
) {
}

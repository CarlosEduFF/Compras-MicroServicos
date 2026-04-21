package com.api.produto.repository.adapter;

import com.api.produto.entity.Produto;
import com.api.produto.repository.orm.ProdutoOrmMongo;

public class ProdutoRepositoryAdapter {

    private ProdutoRepositoryAdapter() {
    }

    public static Produto castOrm(ProdutoOrmMongo orm) {
        return new Produto(
                orm.id(),
                orm.nome(),
                orm.preco()
        );
    }

    public static ProdutoOrmMongo castEntity(Produto entity) {
        return new ProdutoOrmMongo(
                entity.id(),
                entity.nome(),
                entity.preco()
        );
    }
}

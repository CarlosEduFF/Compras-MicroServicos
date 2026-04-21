package com.api.produto.repository.adapter;

import com.api.produto.entity.Compra;
import com.api.produto.repository.orm.CompraOrmMongo;

public class CompraRepositoryAdapter {

    private CompraRepositoryAdapter() {
    }

    public static Compra castOrm(CompraOrmMongo orm) {
        return new Compra(
                orm.id(),
                orm.clienteId(),
                orm.produtoIds()
        );
    }

    public static CompraOrmMongo castEntity(Compra entity) {
        return new CompraOrmMongo(
                entity.id(),
                entity.clienteId(),
                entity.produtoIds()
        );
    }
}

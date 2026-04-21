package com.api.produto.repository;

import com.api.produto.entity.Compra;
import com.api.produto.repository.adapter.CompraRepositoryAdapter;
import com.api.produto.repository.mongo.CompraRepositoryWithMongoDB;
import com.api.produto.repository.orm.CompraOrmMongo;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CompraRepositoryImpl implements CompraRepository {

    private final CompraRepositoryWithMongoDB repository;

    public CompraRepositoryImpl(CompraRepositoryWithMongoDB repository) {
        this.repository = repository;
    }

    @Override
    public Compra cadastrar(Compra compra) {
        CompraOrmMongo orm = CompraRepositoryAdapter.castEntity(compra);
        CompraOrmMongo ormSave = repository.save(orm);
        return CompraRepositoryAdapter.castOrm(ormSave);
    }

    @Override
    public Collection<Compra> consultarPorCliente(String clienteId) {
        List<CompraOrmMongo> comprasDoCliente = repository.findByClienteId(clienteId);
        return comprasDoCliente.stream()
                .map(CompraRepositoryAdapter::castOrm)
                .collect(Collectors.toList());
    }
}

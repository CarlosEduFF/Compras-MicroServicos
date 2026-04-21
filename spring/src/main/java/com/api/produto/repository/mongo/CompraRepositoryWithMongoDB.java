package com.api.produto.repository.mongo;

import com.api.produto.repository.orm.CompraOrmMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface CompraRepositoryWithMongoDB extends MongoRepository<CompraOrmMongo, String> {
    List<CompraOrmMongo> findByClienteId(String clienteId);
}

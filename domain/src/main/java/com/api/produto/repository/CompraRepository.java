package com.api.produto.repository;

import com.api.produto.entity.Compra;
import java.util.Collection;

public interface CompraRepository {
    Compra cadastrar(Compra compra);
    Collection<Compra> consultarPorCliente(String clienteId);
}

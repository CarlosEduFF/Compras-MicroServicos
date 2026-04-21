package com.api.produto.integration.dto;

import java.util.Date;

public record ClienteResponse (
        String id,
        String nome,
        Date dataNascimento,
        String endereco
){
}

package com.wellscosta.services;

import com.wellscosta.domain.Cliente;

public interface IClienteService {
    void salvar(Cliente cliente);

    Cliente buscarPorCpf(Long cpf);
}

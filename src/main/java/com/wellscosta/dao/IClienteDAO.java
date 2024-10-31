package com.wellscosta.dao;

import com.wellscosta.domain.Cliente;

public interface IClienteDAO {
    void salvar(Cliente cliente);
    Cliente buscarPorCpf(Long cpf);
}

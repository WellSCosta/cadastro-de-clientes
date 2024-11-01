package com.wellscosta.dao;

import com.wellscosta.domain.Cliente;

public interface IClienteDAO {
    Boolean salvar(Cliente cliente);
    Cliente buscarPorCpf(Long cpf);
    void excluir(Long cpf);

    void alterar(Cliente cliente);
}

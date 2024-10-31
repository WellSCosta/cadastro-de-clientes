package com.wellscosta.dao;

import com.wellscosta.domain.Cliente;

public class ClienteDAO implements IClienteDAO {

    @Override
    public Boolean salvar(Cliente cliente) {
        return true;
    }

    @Override
    public Cliente buscarPorCpf(Long cpf) {
        return null;
    }

    @Override
    public void excluir(Long cpf) {

    }
}

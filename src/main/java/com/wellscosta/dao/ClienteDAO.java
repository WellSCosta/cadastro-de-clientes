package com.wellscosta.dao;

import com.wellscosta.domain.Cliente;

import java.util.HashMap;
import java.util.Map;

public class ClienteDAO implements IClienteDAO {

    private Map<Long, Cliente> map;

    public ClienteDAO() {
        this.map = new HashMap<>();
    }

    @Override
    public Boolean salvar(Cliente cliente) {
        if (this.map.containsKey(cliente.getCpf())) {
            return false;
        }
        this.map.put(cliente.getCpf(), cliente);
        return true;
    }

    @Override
    public Cliente buscarPorCpf(Long cpf) {
        return this.map.get(cpf);
    }

    @Override
    public void excluir(Long cpf) {
        Cliente clienteCadastrado = this.map.get(cpf);
        if (clienteCadastrado != null) {
            this.map.remove(cpf, clienteCadastrado);
        }
    }

    @Override
    public Cliente alterar(Cliente cliente) {
        Cliente clienteCadastrado = this.map.get(cliente.getCpf());
        if (clienteCadastrado != null) {
            clienteCadastrado.setNome(cliente.getNome());
            clienteCadastrado.setTel(cliente.getTel());
            clienteCadastrado.setEnd(cliente.getEnd());
            clienteCadastrado.setEstado(cliente.getEstado());
            clienteCadastrado.setNumero(cliente.getNumero());
            clienteCadastrado.setCidade(cliente.getCidade());
            return this.map.replace(cliente.getCpf(), clienteCadastrado);
        }
        return null;
    }
}

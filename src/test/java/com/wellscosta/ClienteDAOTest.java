package com.wellscosta;

import com.wellscosta.dao.ClienteDaoMock;
import com.wellscosta.dao.IClienteDAO;
import com.wellscosta.domain.Cliente;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClienteDAOTest {
    IClienteDAO clienteDao;
    Cliente cliente;

    public ClienteDAOTest() {
        clienteDao = new ClienteDaoMock();
    }

    @Before
    public void init() {
        cliente = new Cliente();
        cliente.setCpf(5555555555L);
        cliente.setNome("Wellington");
        cliente.setNumero(2);
        cliente.setEstado("BA");
        cliente.setCidade("Feira de Santana");
        cliente.setEnd("Endereco");
        cliente.setTel(99999999999L);
        clienteDao.salvar(cliente);
    }

    @Test
    public void salvarCliente() {
        Boolean retorno = clienteDao.salvar(cliente);
        Assert.assertTrue(retorno);
    }

    @Test
    public void pesquisarCliente() {
        Cliente clienteConsultado = clienteDao.buscarPorCpf(cliente.getCpf());
        Assert.assertNotNull(clienteConsultado);
    }

    @Test
    public void excluirCliente() {
        clienteDao.excluir(cliente.getCpf());
    }
}

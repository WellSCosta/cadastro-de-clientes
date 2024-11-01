package com.wellscosta;

import com.wellscosta.dao.ClienteDAO;
import com.wellscosta.dao.IClienteDAO;
import com.wellscosta.domain.Cliente;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClienteDAOTest {
    IClienteDAO clienteDao;
    Cliente cliente;

    public ClienteDAOTest() {
        clienteDao = new ClienteDAO();
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

    }

    @Test
    public void salvarCliente() {
        Boolean retorno = clienteDao.salvar(cliente);
        Assert.assertTrue(retorno);
    }

    @Test
    public void pesquisarCliente() {
        salvarCliente();
        Cliente clienteConsultado = clienteDao.buscarPorCpf(cliente.getCpf());
        Assert.assertNotNull(clienteConsultado);
    }

    @Test
    public void alterarCliente() {
        salvarCliente();
        cliente.setNome("Wellington Santos");
        Cliente clienteAlterado = clienteDao.alterar(cliente);
        Assert.assertEquals("Wellington Santos", clienteAlterado.getNome());
    }

    @Test
    public void excluirCliente() {
        clienteDao.excluir(cliente.getCpf());
    }
}

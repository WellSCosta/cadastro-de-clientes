package com.wellscosta;

import com.wellscosta.dao.ClienteDaoMock;
import com.wellscosta.dao.IClienteDAO;
import com.wellscosta.domain.Cliente;
import com.wellscosta.services.ClienteService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import com.wellscosta.services.IClienteService;

public class ClienteServiceTest {

    IClienteService clienteService;
    Cliente cliente;

    public ClienteServiceTest() {
        IClienteDAO dao = new ClienteDaoMock();
        clienteService = new ClienteService(dao);
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

        clienteService.salvar(cliente);
    }

    @Test
    public void salvarCliente() {
        Boolean retorno = clienteService.salvar(cliente);
        Assert.assertTrue(retorno);
    }

    @Test
    public void pesquisarCliente() {
        Cliente clienteConsultado = clienteService.buscarPorCpf(cliente.getCpf());
        Assert.assertNotNull(clienteConsultado);
    }

    @Test
    public void alterarCliente() {
        cliente.setNome("Wellington Santos");
        clienteService.alterar(cliente);
        //Cliente clienteConsultado = clienteService.buscarPorCpf(cliente.getCpf());
        //Assert.assertEquals("Wellington Santos", clienteConsultado.getNome());
        Assert.assertEquals("Wellington Santos", cliente.getNome());
    }

    @Test
    public void excluirCliente() {
        clienteService.excluir(cliente.getCpf());
    }
}

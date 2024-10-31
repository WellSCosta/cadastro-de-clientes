package com.wellscosta;

import com.wellscosta.dao.ClienteDAO;
import com.wellscosta.dao.ClienteDaoMock;
import com.wellscosta.dao.IClienteDAO;
import com.wellscosta.domain.Cliente;
import com.wellscosta.services.ClienteService;
import org.junit.Assert;
import org.junit.Test;
import com.wellscosta.services.IClienteService;

public class ClienteTest {

    IClienteService clienteService;

    public ClienteTest() {
        IClienteDAO dao = new ClienteDaoMock();
        clienteService = new ClienteService(dao);
    }

    @Test
    public void pesquisarCliente() {

        Cliente cliente = new Cliente();
        cliente.setCpf(5555555555L);
        cliente.setNome("Wellington");
        cliente.setNumero(2);
        cliente.setEstado("BA");
        cliente.setCidade("Feira de Santana");
        cliente.setEnd("Endereco");
        cliente.setTel(99999999999L);

        clienteService.salvar(cliente);
        Cliente clienteConsultado = clienteService.buscarPorCpf(cliente.getCpf());

        Assert.assertNotNull(clienteConsultado);
    }
}

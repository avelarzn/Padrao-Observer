package observer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {
    @Test
    void deveNotificarUmCliente() {
        Compra compra = new Compra(12, "A caminho para transportadora");
        Cliente cliente = new Cliente("Leonardo");
        cliente.comprar(compra);
        compra.atualizarStatusEntrega();
        assertEquals("Leonardo, a entrega está EntregaEncomenda{codigoRastreamento=12, status='A caminho para transportadora'}", cliente.getUltimaAtualizacaoEntrega());
    }

    @Test
    void deveNotificarCliente() {
        Compra compra = new Compra(12, "A caminho para transportadora");
        Cliente cliente1 = new Cliente("Leonardo");
        Cliente cliente2 = new Cliente("Marcos");
        cliente1.comprar(compra);
        cliente2.comprar(compra);
        compra.atualizarStatusEntrega();
        assertEquals("Leonardo, a entrega está EntregaEncomenda{codigoRastreamento=12, status='A caminho para transportadora'}", cliente1.getUltimaAtualizacaoEntrega());
        assertEquals("Marcos, a entrega está EntregaEncomenda{codigoRastreamento=12, status='A caminho para transportadora'}", cliente2.getUltimaAtualizacaoEntrega());
    }

    @Test
    void naoDeveNotificarAluno() {
        Compra compra = new Compra(12, "A caminho para transportadora");
        Cliente cliente = new Cliente("Leonardo");
        compra.atualizarStatusEntrega();
        assertEquals(null, cliente.getUltimaAtualizacaoEntrega());
    }

    @Test
    void deveNotificarAlunoTurmaA() {
        Compra compra1 = new Compra(12, "A caminho para transportadora");
        Compra compra2 = new Compra(13, "Recebido pela transportadora");
        Cliente cliente1 = new Cliente("Leonardo");
        Cliente cliente2 = new Cliente("Marcos");
        cliente1.comprar(compra1);
        cliente2.comprar(compra2);
        compra1.atualizarStatusEntrega();
        assertEquals("Leonardo, a entrega está EntregaEncomenda{codigoRastreamento=12, status='A caminho para transportadora'}", cliente1.getUltimaAtualizacaoEntrega());
        assertEquals(null, cliente2.getUltimaAtualizacaoEntrega());
    }
}
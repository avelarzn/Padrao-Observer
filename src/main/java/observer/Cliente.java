package observer;

import java.util.Observable;
import java.util.Observer;

public class Cliente implements Observer {

    private String nome;
    private String ultimaAtualizacaoEntrega;

    public Cliente(String nome) {
        this.nome = nome;
    }

    public String getUltimaAtualizacaoEntrega() {
        return this.ultimaAtualizacaoEntrega;
    }

    public void comprar(Compra compra) {
        compra.addObserver(this);
    }

    public void update(Observable compra, Object arg1) {
        this.ultimaAtualizacaoEntrega = this.nome + ", a entrega está " + compra.toString();
        // System.out.println(this.ultimaNotificacao);
    }
}

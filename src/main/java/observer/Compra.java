package observer;

import java.util.Observable;

public class Compra extends Observable {

    private Integer codigoRastreamento;
    private String status;

    public Compra(Integer codigoRastreamento, String status) {
        this.codigoRastreamento = codigoRastreamento;
        this.status = status;
    }

    public void atualizarStatusEntrega() {
        setChanged();
        notifyObservers();
    }

    public Integer getCodigoRastreamento() {
        return codigoRastreamento;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "EntregaEncomenda{" +
                "codigoRastreamento=" + codigoRastreamento +
                ", status='" + status + '\'' +
                '}';
    }
}

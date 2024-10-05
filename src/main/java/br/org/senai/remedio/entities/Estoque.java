package br.org.senai.remedio.entities;

public class Estoque {

    private Integer remedioId;
    private Integer quantidade;

    public Integer getRemedioId() {
        return remedioId;
    }

    public void setRemedioId(Integer remedioId) {
        this.remedioId = remedioId;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}

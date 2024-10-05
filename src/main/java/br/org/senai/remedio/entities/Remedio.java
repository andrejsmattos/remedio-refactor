package br.org.senai.remedio.entities;

public class Remedio {

    private Integer id;
    private String nome;
    private Integer dosagemEmMg;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getDosagemEmMg() {
        return dosagemEmMg;
    }

    public void setDosagemEmMg(Integer dosagemEmMg) {
        this.dosagemEmMg = dosagemEmMg;
    }
}

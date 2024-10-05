package br.org.senai.remedio.services;

public interface AdicionarEstoqueUseCase {

    void adicionar(Integer quantidade, Integer remedioId, String remedioNome, Integer remedioDosagemMg);

}

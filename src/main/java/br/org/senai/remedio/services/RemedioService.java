package br.org.senai.remedio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RemedioService {

    private final SalvarRemedioUseCase salvarRemedioUseCase;
    private final AdicionarEstoqueUseCase adicionarEstoqueUseCase;

    @Autowired
    public RemedioService(SalvarRemedioUseCase salvarRemedioUseCase,
                          AdicionarEstoqueUseCase adicionarEstoqueUseCase) {
        this.salvarRemedioUseCase = salvarRemedioUseCase;
        this.adicionarEstoqueUseCase = adicionarEstoqueUseCase;
    }

    public void salvarRemedio(String nome, Integer dosagemEmMg) {
        salvarRemedioUseCase.salvar(nome, dosagemEmMg);
    }

    public void adicionarAoEstoque(Integer remedioId, Integer quantidade, String remedioNome, Integer remedioDosagemMg) {
        adicionarEstoqueUseCase.adicionar(quantidade, remedioId, remedioNome, remedioDosagemMg);
    }
}
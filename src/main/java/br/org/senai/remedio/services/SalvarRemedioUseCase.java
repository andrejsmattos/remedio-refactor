package br.org.senai.remedio.services;

import br.org.senai.remedio.entities.Remedio;

public interface SalvarRemedioUseCase {
    Remedio salvar(String nome, Integer dosagemEmMg);
}

package br.org.senai.remedio.services;

import br.org.senai.remedio.entities.Remedio;

public interface GaranteExistenciaRemedioUseCase {
    Remedio obterRemedio(Integer remedioId, String remedioNome, Integer remedioDosagemMg);
}

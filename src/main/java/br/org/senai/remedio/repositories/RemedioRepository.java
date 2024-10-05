package br.org.senai.remedio.repositories;

import br.org.senai.remedio.entities.Remedio;
import org.springframework.stereotype.Repository;

@Repository
public class RemedioRepository {
    public Integer salvar(Remedio remedio) {
        return null;
    }

    public boolean existe(Integer remedioId) {
        return false;
    }

    public Remedio getRemedioPorId(Integer remedioId) {
    }

    public boolean existePorNome(String remedioNome) {
    }

    public Remedio getRemedioPorNome(String remedioNome) {
    }
}

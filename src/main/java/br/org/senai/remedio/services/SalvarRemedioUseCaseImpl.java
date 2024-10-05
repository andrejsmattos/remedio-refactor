package br.org.senai.remedio.services;

import br.org.senai.remedio.entities.Remedio;
import br.org.senai.remedio.exceptions.ParametroInvalidoException;
import br.org.senai.remedio.repositories.RemedioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SalvarRemedioUseCaseImpl implements SalvarRemedioUseCase {

    @Autowired
    private RemedioRepository remedioRepository;

    @Override
    public Remedio salvar(String nome, Integer dosagemEmMg) {
        validaExistenciaDeNome(nome);
        validaExitenciaDeDosagem(dosagemEmMg);
        validaDosagemPositiva(dosagemEmMg);
        
        Remedio remedio = new Remedio();
        remedio.setNome(nome);
        remedio.setDosagemEmMg(dosagemEmMg);
        remedioRepository.salvar(remedio);

        return remedio;
    }

    private void validaDosagemPositiva(Integer dosagemEmMg) {
        if (dosagemEmMg < 0) {
            throw new ParametroInvalidoException("dosagemEmMg", "Dosagem não pode ser negativa");
        }

    }

    private void validaExitenciaDeDosagem(Integer dosagemEmMg) {
        if (dosagemEmMg == null) {
            throw new ParametroInvalidoException("dosagemEmMg", "Remédio precisa possuir dosagem");
        }
    }

    private void validaExistenciaDeNome(String nome) {
        if (nome == null || nome.isEmpty() || nome.trim().isEmpty()) {
            throw new ParametroInvalidoException("nome", "Nome do remédio não pode ser vazio");
        }
    }

}

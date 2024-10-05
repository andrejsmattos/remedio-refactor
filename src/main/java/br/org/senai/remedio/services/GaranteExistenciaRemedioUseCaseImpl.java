package br.org.senai.remedio.services;

import br.org.senai.remedio.entities.Remedio;
import br.org.senai.remedio.repositories.RemedioRepository;
import org.springframework.stereotype.Component;

@Component
public class GaranteExistenciaRemedioUseCaseImpl implements GaranteExistenciaRemedioUseCase {

    private final RemedioRepository remedioRepository;
    private final SalvarRemedioUseCase salvarRemedioUseCase;

    public GaranteExistenciaRemedioUseCaseImpl(RemedioRepository remedioRepository,
                                               SalvarRemedioUseCase salvarRemedioUseCase) {

        this.remedioRepository = remedioRepository;
        this.salvarRemedioUseCase = salvarRemedioUseCase;
    }

    @Override
    public Remedio obterRemedio(Integer remedioId, String remedioNome, Integer remedioDosagemMg) {
        if(remedioRepository.existe(remedioId)) {
            return remedioRepository.getRemedioPorId(remedioId);
        }
        if(remedioRepository.existePorNome(remedioNome)) {
            return remedioRepository.getRemedioPorNome(remedioNome);
        }
        return salvarRemedioUseCase.salvar(remedioNome, remedioDosagemMg);
    }
}

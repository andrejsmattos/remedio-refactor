package br.org.senai.remedio.services;

import br.org.senai.remedio.entities.Estoque;
import br.org.senai.remedio.entities.Remedio;
import br.org.senai.remedio.exceptions.ParametroInvalidoException;
import br.org.senai.remedio.repositories.EstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdicionarEstoqueUseCaseImpl implements AdicionarEstoqueUseCase {

    private final GaranteExistenciaRemedioUseCase garanteExistenciaRemedioUseCase;
    private final EstoqueRepository estoqueRepository;

    @Autowired
    private AdicionarEstoqueUseCaseImpl(EstoqueRepository estoqueRepository,
                                        GaranteExistenciaRemedioUseCase garanteExistenciaRemedioUseCase) {
        this.estoqueRepository = estoqueRepository;
        this.garanteExistenciaRemedioUseCase = garanteExistenciaRemedioUseCase;
    }


    @Override
    public void adicionar(Integer quantidade, Integer remedioId, String remedioNome, Integer remedioDosagemMg) {
        validaQuantidadePositiva(quantidade);
        Remedio remedio = garanteExistenciaRemedioUseCase.obterRemedio(remedioId, remedioNome, remedioDosagemMg);
        Estoque estoque = encontrarEstoque(remedio);
        estoque.setQuantidade(estoque.getQuantidade() + quantidade);

        estoqueRepository.save(estoque);
        }

    private Estoque encontrarEstoque(Remedio remedio) {
        Estoque estoqueAtual = estoqueRepository.getEstoqueAtual(remedio.getId());
        if (estoqueAtual == null) {
            estoqueAtual = new Estoque();
            estoqueAtual.setQuantidade(0);
            estoqueAtual.setRemedioId(remedio.getId());

        }
        return estoqueAtual;
    }

    private void validaQuantidadePositiva(Integer quantidade) {
        if (quantidade < 0) {
            throw new ParametroInvalidoException("quantidade", "Quantidade adicionada no estoque não pode ser negativa");
        }
    }
}


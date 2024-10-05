package br.org.senai.remedio.exceptions;

import static java.lang.String.*;

public class ParametroInvalidoException extends RuntimeException {
    private final String campo;

    public ParametroInvalidoException(String campo, String mensagem) {
        super(format("Campo %s é inválido: %s", campo, mensagem));
        this.campo = campo;
    }
}

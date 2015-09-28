package org.ocristian.tdcpoa2015.lambda;

import java.io.IOException;
import java.util.function.Predicate;

import org.ocristian.tdcpoa2015.enums.Posicao;
import org.ocristian.tdcpoa2015.model.Jogador;

public class ExemploComposeLambdas {

    public static void main(String[] args) {
	try {
	    new ExemploComposeLambdas().readFile();
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    private void readFile() throws IOException {
	Predicate<Jogador> filter = (Jogador j) -> Posicao.ATACANTE.equals(j.getPosicao());
	
	filter.and((Jogador j) -> Posicao.ATACANTE.equals(j.getPosicao()))
		.or((Jogador j) -> Posicao.MEIO_CAMPO.equals(j.getPosicao()))
		.and((Jogador j) -> j.getNome().startsWith("C"));
    }
}

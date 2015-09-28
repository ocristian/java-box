package org.ocristian.tdcpoa2015.model;

public class AproveitamentoUltimosJogos {

    private String aproveitamento;

    private Jogo jogo;

    public AproveitamentoUltimosJogos() {
	super();
    }

    public AproveitamentoUltimosJogos(String aproveitamento, Jogo jogo) {
	super();
	this.aproveitamento = aproveitamento;
	this.jogo = jogo;
    }

    public String getAproveitamento() {
	return aproveitamento;
    }

    public void setAproveitamento(String aproveitamento) {
	this.aproveitamento = aproveitamento;
    }

    public Jogo getJogo() {
	return jogo;
    }

    public void setJogo(Jogo jogo) {
	this.jogo = jogo;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((aproveitamento == null) ? 0 : aproveitamento.hashCode());
	result = prime * result + ((jogo == null) ? 0 : jogo.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	AproveitamentoUltimosJogos other = (AproveitamentoUltimosJogos) obj;
	if (aproveitamento == null) {
	    if (other.aproveitamento != null)
		return false;
	} else if (!aproveitamento.equals(other.aproveitamento))
	    return false;
	if (jogo == null) {
	    if (other.jogo != null)
		return false;
	} else if (!jogo.equals(other.jogo))
	    return false;
	return true;
    }

    @Override
    public String toString() {
	return "AproveitamentoUltimosJogos [aproveitamento=" + aproveitamento + ", jogo=" + jogo + "]";
    }

}

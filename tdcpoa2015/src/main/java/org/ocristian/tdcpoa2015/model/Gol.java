package org.ocristian.tdcpoa2015.model;

public class Gol {

    private String jogador_apelido;

    private String equipe_nome;

    private String periodo;

    private String momento;

    private String tipo;

    public Gol() {
	super();
    }

    public Gol(String jogador_apelido, String equipe_nome, String periodo, String momento, String tipo) {
	super();
	this.jogador_apelido = jogador_apelido;
	this.equipe_nome = equipe_nome;
	this.periodo = periodo;
	this.momento = momento;
	this.tipo = tipo;
    }

    public String getJogador_apelido() {
	return jogador_apelido;
    }

    public void setJogador_apelido(String jogador_apelido) {
	this.jogador_apelido = jogador_apelido;
    }

    public String getEquipe_nome() {
	return equipe_nome;
    }

    public void setEquipe_nome(String equipe_nome) {
	this.equipe_nome = equipe_nome;
    }

    public String getPeriodo() {
	return periodo;
    }

    public void setPeriodo(String periodo) {
	this.periodo = periodo;
    }

    public String getMomento() {
	return momento;
    }

    public void setMomento(String momento) {
	this.momento = momento;
    }

    public String getTipo() {
	return tipo;
    }

    public void setTipo(String tipo) {
	this.tipo = tipo;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((equipe_nome == null) ? 0 : equipe_nome.hashCode());
	result = prime * result + ((jogador_apelido == null) ? 0 : jogador_apelido.hashCode());
	result = prime * result + ((momento == null) ? 0 : momento.hashCode());
	result = prime * result + ((periodo == null) ? 0 : periodo.hashCode());
	result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
	Gol other = (Gol) obj;
	if (equipe_nome == null) {
	    if (other.equipe_nome != null)
		return false;
	} else if (!equipe_nome.equals(other.equipe_nome))
	    return false;
	if (jogador_apelido == null) {
	    if (other.jogador_apelido != null)
		return false;
	} else if (!jogador_apelido.equals(other.jogador_apelido))
	    return false;
	if (momento == null) {
	    if (other.momento != null)
		return false;
	} else if (!momento.equals(other.momento))
	    return false;
	if (periodo == null) {
	    if (other.periodo != null)
		return false;
	} else if (!periodo.equals(other.periodo))
	    return false;
	if (tipo == null) {
	    if (other.tipo != null)
		return false;
	} else if (!tipo.equals(other.tipo))
	    return false;
	return true;
    }

    @Override
    public String toString() {
	return "Gol [jogador_apelido=" + jogador_apelido + ", equipe_nome=" + equipe_nome + ", periodo=" + periodo + ", momento=" + momento
		+ ", tipo=" + tipo + "]";
    }

}

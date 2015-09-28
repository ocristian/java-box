package org.ocristian.tdcpoa2015.model;

import java.util.List;

public class Classificacao {

    private int variacao;

    private int ordem;

    private String equipe_url;

    private int saldo_gols;

    private int empates;

    private int pontos;

    private int derrotas;

    private String variacao_label;

    private Equipe equipe;

    private List<AproveitamentoUltimosJogos> aproveitamento_ultimos_jogos;

    private int vitorias;

    public Classificacao() {
	super();
    }

    public Classificacao(int variacao, int ordem, String equipe_url, int saldo_gols, int empates, int pontos, int derrotas,
	    String variacao_label, Equipe equipe, List<AproveitamentoUltimosJogos> aproveitamento_ultimos_jogos, int vitorias) {
	super();
	this.variacao = variacao;
	this.ordem = ordem;
	this.equipe_url = equipe_url;
	this.saldo_gols = saldo_gols;
	this.empates = empates;
	this.pontos = pontos;
	this.derrotas = derrotas;
	this.variacao_label = variacao_label;
	this.equipe = equipe;
	this.aproveitamento_ultimos_jogos = aproveitamento_ultimos_jogos;
	this.vitorias = vitorias;
    }

    public int getVariacao() {
	return variacao;
    }

    public void setVariacao(int variacao) {
	this.variacao = variacao;
    }

    public int getOrdem() {
	return ordem;
    }

    public void setOrdem(int ordem) {
	this.ordem = ordem;
    }

    public String getEquipe_url() {
	return equipe_url;
    }

    public void setEquipe_url(String equipe_url) {
	this.equipe_url = equipe_url;
    }

    public int getSaldo_gols() {
	return saldo_gols;
    }

    public void setSaldo_gols(int saldo_gols) {
	this.saldo_gols = saldo_gols;
    }

    public int getEmpates() {
	return empates;
    }

    public void setEmpates(int empates) {
	this.empates = empates;
    }

    public int getPontos() {
	return pontos;
    }

    public void setPontos(int pontos) {
	this.pontos = pontos;
    }

    public int getDerrotas() {
	return derrotas;
    }

    public void setDerrotas(int derrotas) {
	this.derrotas = derrotas;
    }

    public String getVariacao_label() {
	return variacao_label;
    }

    public void setVariacao_label(String variacao_label) {
	this.variacao_label = variacao_label;
    }

    public Equipe getEquipe() {
	return equipe;
    }

    public void setEquipe(Equipe equipe) {
	this.equipe = equipe;
    }

    public List<AproveitamentoUltimosJogos> getAproveitamento_ultimos_jogos() {
	return aproveitamento_ultimos_jogos;
    }

    public void setAproveitamento_ultimos_jogos(List<AproveitamentoUltimosJogos> aproveitamento_ultimos_jogos) {
	this.aproveitamento_ultimos_jogos = aproveitamento_ultimos_jogos;
    }

    public int getVitorias() {
	return vitorias;
    }

    public void setVitorias(int vitorias) {
	this.vitorias = vitorias;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((aproveitamento_ultimos_jogos == null) ? 0 : aproveitamento_ultimos_jogos.hashCode());
	result = prime * result + derrotas;
	result = prime * result + empates;
	result = prime * result + ((equipe == null) ? 0 : equipe.hashCode());
	result = prime * result + ((equipe_url == null) ? 0 : equipe_url.hashCode());
	result = prime * result + ordem;
	result = prime * result + pontos;
	result = prime * result + saldo_gols;
	result = prime * result + variacao;
	result = prime * result + ((variacao_label == null) ? 0 : variacao_label.hashCode());
	result = prime * result + vitorias;
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
	Classificacao other = (Classificacao) obj;
	if (aproveitamento_ultimos_jogos == null) {
	    if (other.aproveitamento_ultimos_jogos != null)
		return false;
	} else if (!aproveitamento_ultimos_jogos.equals(other.aproveitamento_ultimos_jogos))
	    return false;
	if (derrotas != other.derrotas)
	    return false;
	if (empates != other.empates)
	    return false;
	if (equipe == null) {
	    if (other.equipe != null)
		return false;
	} else if (!equipe.equals(other.equipe))
	    return false;
	if (equipe_url == null) {
	    if (other.equipe_url != null)
		return false;
	} else if (!equipe_url.equals(other.equipe_url))
	    return false;
	if (ordem != other.ordem)
	    return false;
	if (pontos != other.pontos)
	    return false;
	if (saldo_gols != other.saldo_gols)
	    return false;
	if (variacao != other.variacao)
	    return false;
	if (variacao_label == null) {
	    if (other.variacao_label != null)
		return false;
	} else if (!variacao_label.equals(other.variacao_label))
	    return false;
	if (vitorias != other.vitorias)
	    return false;
	return true;
    }

    @Override
    public String toString() {
	return "Classificacao [variacao=" + variacao + ", ordem=" + ordem + ", equipe_url=" + equipe_url + ", saldo_gols=" + saldo_gols
		+ ", empates=" + empates + ", pontos=" + pontos + ", derrotas=" + derrotas + ", variacao_label=" + variacao_label
		+ ", equipe=" + equipe + ", aproveitamento_ultimos_jogos=" + aproveitamento_ultimos_jogos + ", vitorias=" + vitorias + "]";
    }

}

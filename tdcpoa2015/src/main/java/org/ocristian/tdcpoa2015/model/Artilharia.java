package org.ocristian.tdcpoa2015.model;

public class Artilharia {

    private long id;

    private long total_gols;

    private long total_partidas;

    private String jogador_nome;

    private String jogador_posicao;

    private String equipe_nome;

    private String equipe_url_logo;

    public Artilharia() {
	super();
    }

    public Artilharia(long id, long total_gols, long total_partidas, String jogador_nome, String jogador_posicao, String equipe_nome,
	    String equipe_url_logo) {
	super();
	this.id = id;
	this.total_gols = total_gols;
	this.total_partidas = total_partidas;
	this.jogador_nome = jogador_nome;
	this.jogador_posicao = jogador_posicao;
	this.equipe_nome = equipe_nome;
	this.equipe_url_logo = equipe_url_logo;
    }

    public long getId() {
	return id;
    }

    public void setId(long id) {
	this.id = id;
    }

    public long getTotal_gols() {
	return total_gols;
    }

    public void setTotal_gols(long total_gols) {
	this.total_gols = total_gols;
    }

    public long getTotal_partidas() {
	return total_partidas;
    }

    public void setTotal_partidas(long total_partidas) {
	this.total_partidas = total_partidas;
    }

    public String getJogador_nome() {
	return jogador_nome;
    }

    public void setJogador_nome(String jogador_nome) {
	this.jogador_nome = jogador_nome;
    }

    public String getJogador_posicao() {
	return jogador_posicao;
    }

    public void setJogador_posicao(String jogador_posicao) {
	this.jogador_posicao = jogador_posicao;
    }

    public String getEquipe_nome() {
	return equipe_nome;
    }

    public void setEquipe_nome(String equipe_nome) {
	this.equipe_nome = equipe_nome;
    }

    public String getEquipe_url_logo() {
	return equipe_url_logo;
    }

    public void setEquipe_url_logo(String equipe_url_logo) {
	this.equipe_url_logo = equipe_url_logo;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((equipe_nome == null) ? 0 : equipe_nome.hashCode());
	result = prime * result + ((equipe_url_logo == null) ? 0 : equipe_url_logo.hashCode());
	result = prime * result + (int) (id ^ (id >>> 32));
	result = prime * result + ((jogador_nome == null) ? 0 : jogador_nome.hashCode());
	result = prime * result + ((jogador_posicao == null) ? 0 : jogador_posicao.hashCode());
	result = prime * result + (int) (total_gols ^ (total_gols >>> 32));
	result = prime * result + (int) (total_partidas ^ (total_partidas >>> 32));
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
	Artilharia other = (Artilharia) obj;
	if (equipe_nome == null) {
	    if (other.equipe_nome != null)
		return false;
	} else if (!equipe_nome.equals(other.equipe_nome))
	    return false;
	if (equipe_url_logo == null) {
	    if (other.equipe_url_logo != null)
		return false;
	} else if (!equipe_url_logo.equals(other.equipe_url_logo))
	    return false;
	if (id != other.id)
	    return false;
	if (jogador_nome == null) {
	    if (other.jogador_nome != null)
		return false;
	} else if (!jogador_nome.equals(other.jogador_nome))
	    return false;
	if (jogador_posicao == null) {
	    if (other.jogador_posicao != null)
		return false;
	} else if (!jogador_posicao.equals(other.jogador_posicao))
	    return false;
	if (total_gols != other.total_gols)
	    return false;
	if (total_partidas != other.total_partidas)
	    return false;
	return true;
    }

    @Override
    public String toString() {
	return "Artilharia [id=" + id + ", total_gols=" + total_gols + ", total_partidas=" + total_partidas + ", jogador_nome="
		+ jogador_nome + ", jogador_posicao=" + jogador_posicao + ", equipe_nome=" + equipe_nome + ", equipe_url_logo="
		+ equipe_url_logo + "]";
    }

}

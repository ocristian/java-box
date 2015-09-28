package org.ocristian.tdcpoa2015.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties({ "escudos" })
public class EquipeVisitante {

    private long equipe_id;

    private String nome;

    private String nome_popular;

    private String sigla;

    private String genero;

    private Escudo escudos;

    private Cor cores;

    private String slug;

    public EquipeVisitante() {
	super();
    }

    public EquipeVisitante(long equipe_id, String nome, String nome_popular, String sigla, String genero, Escudo escudos, Cor cores,
	    String slug) {
	super();
	this.equipe_id = equipe_id;
	this.nome = nome;
	this.nome_popular = nome_popular;
	this.sigla = sigla;
	this.genero = genero;
	this.escudos = escudos;
	this.cores = cores;
	this.slug = slug;
    }

    public long getEquipe_id() {
	return equipe_id;
    }

    public void setEquipe_id(long equipe_id) {
	this.equipe_id = equipe_id;
    }

    public String getNome() {
	return nome;
    }

    public void setNome(String nome) {
	this.nome = nome;
    }

    public String getNome_popular() {
	return nome_popular;
    }

    public void setNome_popular(String nome_popular) {
	this.nome_popular = nome_popular;
    }

    public String getSigla() {
	return sigla;
    }

    public void setSigla(String sigla) {
	this.sigla = sigla;
    }

    public String getGenero() {
	return genero;
    }

    public void setGenero(String genero) {
	this.genero = genero;
    }

    public Escudo getEscudos() {
	return escudos;
    }

    public void setEscudos(Escudo escudos) {
	this.escudos = escudos;
    }

    public Cor getCores() {
	return cores;
    }

    public void setCores(Cor cores) {
	this.cores = cores;
    }

    public String getSlug() {
	return slug;
    }

    public void setSlug(String slug) {
	this.slug = slug;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((cores == null) ? 0 : cores.hashCode());
	result = prime * result + (int) (equipe_id ^ (equipe_id >>> 32));
	result = prime * result + ((escudos == null) ? 0 : escudos.hashCode());
	result = prime * result + ((genero == null) ? 0 : genero.hashCode());
	result = prime * result + ((nome == null) ? 0 : nome.hashCode());
	result = prime * result + ((nome_popular == null) ? 0 : nome_popular.hashCode());
	result = prime * result + ((sigla == null) ? 0 : sigla.hashCode());
	result = prime * result + ((slug == null) ? 0 : slug.hashCode());
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
	EquipeVisitante other = (EquipeVisitante) obj;
	if (cores == null) {
	    if (other.cores != null)
		return false;
	} else if (!cores.equals(other.cores))
	    return false;
	if (equipe_id != other.equipe_id)
	    return false;
	if (escudos == null) {
	    if (other.escudos != null)
		return false;
	} else if (!escudos.equals(other.escudos))
	    return false;
	if (genero == null) {
	    if (other.genero != null)
		return false;
	} else if (!genero.equals(other.genero))
	    return false;
	if (nome == null) {
	    if (other.nome != null)
		return false;
	} else if (!nome.equals(other.nome))
	    return false;
	if (nome_popular == null) {
	    if (other.nome_popular != null)
		return false;
	} else if (!nome_popular.equals(other.nome_popular))
	    return false;
	if (sigla == null) {
	    if (other.sigla != null)
		return false;
	} else if (!sigla.equals(other.sigla))
	    return false;
	if (slug == null) {
	    if (other.slug != null)
		return false;
	} else if (!slug.equals(other.slug))
	    return false;
	return true;
    }

    @Override
    public String toString() {
	return "EquipeVisitante [equipe_id=" + equipe_id + ", nome=" + nome + ", nome_popular=" + nome_popular + ", sigla=" + sigla
		+ ", genero=" + genero + ", escudos=" + escudos + ", cores=" + cores + ", slug=" + slug + "]";
    }

}

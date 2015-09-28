package org.ocristian.tdcpoa2015.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties({ "escudos" })
public class Equipe {

    private long equipe_id;

    private String genero;

    private String nome;

    private Escudo escudos;

    private String slug;

    private Cor cor;

    private String nome_popular;

    private String sigla;

    public Equipe(String nome, String sigla) {
	super();
	this.sigla = sigla;
	this.nome = nome;
    }

    public Equipe() {
	super();
    }

    public Equipe(long equipe_id, String genero, String nome, Escudo escudos, String slug, Cor cor, String nome_popular, String sigla) {
	super();
	this.equipe_id = equipe_id;
	this.genero = genero;
	this.nome = nome;
	this.escudos = escudos;
	this.slug = slug;
	this.cor = cor;
	this.nome_popular = nome_popular;
	this.sigla = sigla;
    }

    public long getEquipe_id() {
	return equipe_id;
    }

    public void setEquipe_id(long equipe_id) {
	this.equipe_id = equipe_id;
    }

    public String getGenero() {
	return genero;
    }

    public void setGenero(String genero) {
	this.genero = genero;
    }

    public String getNome() {
	return nome;
    }

    public void setNome(String nome) {
	this.nome = nome;
    }

    public Escudo getEscudos() {
	return escudos;
    }

    public void setEscudos(Escudo escudos) {
	this.escudos = escudos;
    }

    public String getSlug() {
	return slug;
    }

    public void setSlug(String slug) {
	this.slug = slug;
    }

    public Cor getCor() {
	return cor;
    }

    public void setCores(Cor cor) {
	this.cor = cor;
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

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((cor == null) ? 0 : cor.hashCode());
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
	Equipe other = (Equipe) obj;
	if (cor == null) {
	    if (other.cor != null)
		return false;
	} else if (!cor.equals(other.cor))
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
	return "Equipe [equipe_id=" + equipe_id + ", genero=" + genero + ", nome=" + nome + ", escudos=" + escudos + ", slug=" + slug
		+ ", cor=" + cor + ", nome_popular=" + nome_popular + ", sigla=" + sigla + "]";
    }

}

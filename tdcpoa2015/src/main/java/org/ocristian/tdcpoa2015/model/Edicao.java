package org.ocristian.tdcpoa2015.model;

public class Edicao {

    private long edicao_id;

    private String nome;

    private String slug;

    private long campeonato_id;

    private Campeonato campeonato;

    private String slug_editorial;

    public Edicao() {
	super();
    }

    public Edicao(long edicao_id, String nome, String slug, long campeonato_id, Campeonato campeonato, String slug_editorial) {
	super();
	this.edicao_id = edicao_id;
	this.nome = nome;
	this.slug = slug;
	this.campeonato_id = campeonato_id;
	this.campeonato = campeonato;
	this.slug_editorial = slug_editorial;
    }

    public long getEdicao_id() {
	return edicao_id;
    }

    public void setEdicao_id(long edicao_id) {
	this.edicao_id = edicao_id;
    }

    public String getNome() {
	return nome;
    }

    public void setNome(String nome) {
	this.nome = nome;
    }

    public String getSlug() {
	return slug;
    }

    public void setSlug(String slug) {
	this.slug = slug;
    }

    public long getCampeonato_id() {
	return campeonato_id;
    }

    public void setCampeonato_id(long campeonato_id) {
	this.campeonato_id = campeonato_id;
    }

    public Campeonato getCampeonato() {
	return campeonato;
    }

    public void setCampeonato(Campeonato campeonato) {
	this.campeonato = campeonato;
    }

    public String getSlug_editorial() {
	return slug_editorial;
    }

    public void setSlug_editorial(String slug_editorial) {
	this.slug_editorial = slug_editorial;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((campeonato == null) ? 0 : campeonato.hashCode());
	result = prime * result + (int) (campeonato_id ^ (campeonato_id >>> 32));
	result = prime * result + (int) (edicao_id ^ (edicao_id >>> 32));
	result = prime * result + ((nome == null) ? 0 : nome.hashCode());
	result = prime * result + ((slug == null) ? 0 : slug.hashCode());
	result = prime * result + ((slug_editorial == null) ? 0 : slug_editorial.hashCode());
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
	Edicao other = (Edicao) obj;
	if (campeonato == null) {
	    if (other.campeonato != null)
		return false;
	} else if (!campeonato.equals(other.campeonato))
	    return false;
	if (campeonato_id != other.campeonato_id)
	    return false;
	if (edicao_id != other.edicao_id)
	    return false;
	if (nome == null) {
	    if (other.nome != null)
		return false;
	} else if (!nome.equals(other.nome))
	    return false;
	if (slug == null) {
	    if (other.slug != null)
		return false;
	} else if (!slug.equals(other.slug))
	    return false;
	if (slug_editorial == null) {
	    if (other.slug_editorial != null)
		return false;
	} else if (!slug_editorial.equals(other.slug_editorial))
	    return false;
	return true;
    }

    @Override
    public String toString() {
	return "Edicao [edicao_id=" + edicao_id + ", nome=" + nome + ", slug=" + slug + ", campeonato_id=" + campeonato_id + ", campeonato="
		+ campeonato + ", slug_editorial=" + slug_editorial + "]";
    }

}

package org.ocristian.tdcpoa2015.model;

public class Campeonato {

    private long campeonato_id;

    private String nome;

    private String genero;

    private String slug;

    public Campeonato() {
	super();
    }

    public Campeonato(long campeonato_id, String nome, String genero, String slug) {
	super();
	this.campeonato_id = campeonato_id;
	this.nome = nome;
	this.genero = genero;
	this.slug = slug;
    }

    public long getCampeonato_id() {
	return campeonato_id;
    }

    public void setCampeonato_id(long campeonato_id) {
	this.campeonato_id = campeonato_id;
    }

    public String getNome() {
	return nome;
    }

    public void setNome(String nome) {
	this.nome = nome;
    }

    public String getGenero() {
	return genero;
    }

    public void setGenero(String genero) {
	this.genero = genero;
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
	result = prime * result + (int) (campeonato_id ^ (campeonato_id >>> 32));
	result = prime * result + ((genero == null) ? 0 : genero.hashCode());
	result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
	Campeonato other = (Campeonato) obj;
	if (campeonato_id != other.campeonato_id)
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
	if (slug == null) {
	    if (other.slug != null)
		return false;
	} else if (!slug.equals(other.slug))
	    return false;
	return true;
    }

    @Override
    public String toString() {
	return "Campeonato [campeonato_id=" + campeonato_id + ", nome=" + nome + ", genero=" + genero + ", slug=" + slug + "]";
    }

}

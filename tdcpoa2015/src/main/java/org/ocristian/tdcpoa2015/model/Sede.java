package org.ocristian.tdcpoa2015.model;

public class Sede {
    private long sede_id;

    private String nome;

    private String nome_popular;

    private Tipo tipo;

    public Sede() {
	super();
    }

    public Sede(long sede_id, String nome, String nome_popular, Tipo tipo) {
	super();
	this.sede_id = sede_id;
	this.nome = nome;
	this.nome_popular = nome_popular;
	this.tipo = tipo;
    }

    public long getSede_id() {
	return sede_id;
    }

    public void setSede_id(long sede_id) {
	this.sede_id = sede_id;
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

    public Tipo getTipo() {
	return tipo;
    }

    public void setTipo(Tipo tipo) {
	this.tipo = tipo;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((nome == null) ? 0 : nome.hashCode());
	result = prime * result + ((nome_popular == null) ? 0 : nome_popular.hashCode());
	result = prime * result + (int) (sede_id ^ (sede_id >>> 32));
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
	Sede other = (Sede) obj;
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
	if (sede_id != other.sede_id)
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
	return "Sede [sede_id=" + sede_id + ", nome=" + nome + ", nome_popular=" + nome_popular + ", tipo=" + tipo + "]";
    }

}

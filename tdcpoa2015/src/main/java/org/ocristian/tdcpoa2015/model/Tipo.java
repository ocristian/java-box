package org.ocristian.tdcpoa2015.model;

public class Tipo {

    private long tipo_id;

    private String descricao;

    public Tipo() {
	super();
    }

    public Tipo(long tipo_id, String descricao) {
	super();
	this.tipo_id = tipo_id;
	this.descricao = descricao;
    }

    public long getTipo_id() {
	return tipo_id;
    }

    public void setTipo_id(long tipo_id) {
	this.tipo_id = tipo_id;
    }

    public String getDescricao() {
	return descricao;
    }

    public void setDescricao(String descricao) {
	this.descricao = descricao;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
	result = prime * result + (int) (tipo_id ^ (tipo_id >>> 32));
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
	Tipo other = (Tipo) obj;
	if (descricao == null) {
	    if (other.descricao != null)
		return false;
	} else if (!descricao.equals(other.descricao))
	    return false;
	if (tipo_id != other.tipo_id)
	    return false;
	return true;
    }

    @Override
    public String toString() {
	return "Tipo [tipo_id=" + tipo_id + ", descricao=" + descricao + "]";
    }

}

package org.ocristian.tdcpoa2015.model;

public class Formato {

    private long formato_id;

    private String descricao;

    private String label;

    private int quantidade_de_jogos;

    public Formato() {
	super();
    }

    public Formato(long formato_id, String descricao, String label, int quantidade_de_jogos) {
	super();
	this.formato_id = formato_id;
	this.descricao = descricao;
	this.label = label;
	this.quantidade_de_jogos = quantidade_de_jogos;
    }

    public long getFormato_id() {
	return formato_id;
    }

    public void setFormato_id(long formato_id) {
	this.formato_id = formato_id;
    }

    public String getDescricao() {
	return descricao;
    }

    public void setDescricao(String descricao) {
	this.descricao = descricao;
    }

    public String getLabel() {
	return label;
    }

    public void setLabel(String label) {
	this.label = label;
    }

    public int getQuantidade_de_jogos() {
	return quantidade_de_jogos;
    }

    public void setQuantidade_de_jogos(int quantidade_de_jogos) {
	this.quantidade_de_jogos = quantidade_de_jogos;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
	result = prime * result + (int) (formato_id ^ (formato_id >>> 32));
	result = prime * result + ((label == null) ? 0 : label.hashCode());
	result = prime * result + quantidade_de_jogos;
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
	Formato other = (Formato) obj;
	if (descricao == null) {
	    if (other.descricao != null)
		return false;
	} else if (!descricao.equals(other.descricao))
	    return false;
	if (formato_id != other.formato_id)
	    return false;
	if (label == null) {
	    if (other.label != null)
		return false;
	} else if (!label.equals(other.label))
	    return false;
	if (quantidade_de_jogos != other.quantidade_de_jogos)
	    return false;
	return true;
    }

    @Override
    public String toString() {
	return "Formato [formato_id=" + formato_id + ", descricao=" + descricao + ", label=" + label + ", quantidade_de_jogos="
		+ quantidade_de_jogos + "]";
    }

}

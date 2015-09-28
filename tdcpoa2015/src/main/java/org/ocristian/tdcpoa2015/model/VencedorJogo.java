package org.ocristian.tdcpoa2015.model;

public class VencedorJogo {

    private long equipe_id;
    private String label;

    public VencedorJogo() {
	super();
    }

    public VencedorJogo(long equipe_id, String label) {
	super();
	this.equipe_id = equipe_id;
	this.label = label;
    }

    public long getEquipe_id() {
	return equipe_id;
    }

    public void setEquipe_id(long equipe_id) {
	this.equipe_id = equipe_id;
    }

    public String getLabel() {
	return label;
    }

    public void setLabel(String label) {
	this.label = label;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + (int) (equipe_id ^ (equipe_id >>> 32));
	result = prime * result + ((label == null) ? 0 : label.hashCode());
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
	VencedorJogo other = (VencedorJogo) obj;
	if (equipe_id != other.equipe_id)
	    return false;
	if (label == null) {
	    if (other.label != null)
		return false;
	} else if (!label.equals(other.label))
	    return false;
	return true;
    }

    @Override
    public String toString() {
	return "VencedorJogo [equipe_id=" + equipe_id + ", label=" + label + "]";
    }

}

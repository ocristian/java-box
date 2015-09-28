package org.ocristian.tdcpoa2015.model;

public class Cor {

    private String primaria;
    private String secundaria;
    private String terciaria;

    public Cor() {
	super();
    }

    public Cor(String primaria, String secundaria, String terciaria) {
	super();
	this.primaria = primaria;
	this.secundaria = secundaria;
	this.terciaria = terciaria;
    }

    public String getPrimaria() {
	return primaria;
    }

    public void setPrimaria(String primaria) {
	this.primaria = primaria;
    }

    public String getSecundaria() {
	return secundaria;
    }

    public void setSecundaria(String secundaria) {
	this.secundaria = secundaria;
    }

    public String getTerciaria() {
	return terciaria;
    }

    public void setTerciaria(String terciaria) {
	this.terciaria = terciaria;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((primaria == null) ? 0 : primaria.hashCode());
	result = prime * result + ((secundaria == null) ? 0 : secundaria.hashCode());
	result = prime * result + ((terciaria == null) ? 0 : terciaria.hashCode());
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
	Cor other = (Cor) obj;
	if (primaria == null) {
	    if (other.primaria != null)
		return false;
	} else if (!primaria.equals(other.primaria))
	    return false;
	if (secundaria == null) {
	    if (other.secundaria != null)
		return false;
	} else if (!secundaria.equals(other.secundaria))
	    return false;
	if (terciaria == null) {
	    if (other.terciaria != null)
		return false;
	} else if (!terciaria.equals(other.terciaria))
	    return false;
	return true;
    }

    @Override
    public String toString() {
	return "Cor [primaria=" + primaria + ", secundaria=" + secundaria + ", terciaria=" + terciaria + "]";
    }

}

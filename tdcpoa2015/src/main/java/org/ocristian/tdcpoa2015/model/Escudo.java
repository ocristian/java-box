package org.ocristian.tdcpoa2015.model;

import java.util.Map;

public class Escudo {

    private Map<String, String> escudos;

    public Escudo() {
    }

    public Escudo(Map<String, String> escudos) {
	super();
	this.escudos = escudos;
    }

    public Map<String, String> getEscudos() {
	return escudos;
    }

    public void setEscudos(Map<String, String> escudos) {
	this.escudos = escudos;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((escudos == null) ? 0 : escudos.hashCode());
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
	Escudo other = (Escudo) obj;
	if (escudos == null) {
	    if (other.escudos != null)
		return false;
	} else if (!escudos.equals(other.escudos))
	    return false;
	return true;
    }

    @Override
    public String toString() {
	return "Escudo [escudos=" + escudos + "]";
    }

}

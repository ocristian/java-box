package org.ocristian.tdcpoa2015.service;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.ocristian.tdcpoa2015.model.Brasileirao;

public class CarregarCampeonato {

    private Brasileirao brasileirao;

    public CarregarCampeonato() {
	super();
	this.brasileirao = obterBrasileirao();
    }

    public CarregarCampeonato(Brasileirao brasileirao) {
	super();
	this.brasileirao = brasileirao;
    }

    private Brasileirao obterBrasileirao() {
	ObjectMapper mapper = new ObjectMapper();

	ClassLoader classLoader = getClass().getClassLoader();
	File file = new File(classLoader.getResource("brasileirao.json").getFile());

	try {
	    return mapper.readValue(file, Brasileirao.class);
	} catch (JsonParseException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (JsonMappingException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

	return null;
    }

    public Brasileirao getBrasileirao() {
	return brasileirao;
    }

    public void setBrasileirao(Brasileirao brasileirao) {
	this.brasileirao = brasileirao;
    }

    @Override
    public String toString() {
	return "CarregarCampeonato [brasileirao=" + brasileirao + "]";
    }

    public static void main(String[] args) {

	CarregarCampeonato carregarCampeonato = new CarregarCampeonato();

	System.out.println(carregarCampeonato);

    }
}

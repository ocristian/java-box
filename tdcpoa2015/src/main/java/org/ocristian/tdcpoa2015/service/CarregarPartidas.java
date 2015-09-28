package org.ocristian.tdcpoa2015.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.JavaType;
import org.ocristian.tdcpoa2015.model.Partida;

public class CarregarPartidas {

    private List<Partida> partidas;

    public CarregarPartidas() {
	super();
	this.partidas = obterPartidas();
    }

    public CarregarPartidas(List<Partida> partidas) {
	super();
	this.partidas = partidas;
    }

    private List<Partida> obterPartidas() {
	ObjectMapper mapper = new ObjectMapper();

	ClassLoader classLoader = getClass().getClassLoader();
	File file = new File(classLoader.getResource("partidas.json").getFile());

	try {
	    JavaType type = mapper.getTypeFactory().constructCollectionType(List.class, Partida.class);

	    return mapper.readValue(file, type);
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

    public List<Partida> getPartidas() {
	return partidas;
    }

    public void setPartidas(List<Partida> partidas) {
	this.partidas = partidas;
    }

    @Override
    public String toString() {
	return "CarregarPartidas [partidas=" + partidas + "]";
    }

    public static void main(String[] args) {

	CarregarPartidas carregarPartidas = new CarregarPartidas();

	System.out.println(carregarPartidas);
	System.out.println("");
    }
}

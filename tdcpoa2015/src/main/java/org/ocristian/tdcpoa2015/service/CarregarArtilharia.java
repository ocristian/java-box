package org.ocristian.tdcpoa2015.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.JavaType;
import org.ocristian.tdcpoa2015.model.Artilharia;

public class CarregarArtilharia {

    private List<Artilharia> artilharia;

    public CarregarArtilharia() {
	this.artilharia = obterArtilharia();
    }

    public CarregarArtilharia(List<Artilharia> artilharia) {
	super();
	this.artilharia = artilharia;
    }

    private List<Artilharia> obterArtilharia() {
	ObjectMapper mapper = new ObjectMapper();

	ClassLoader classLoader = getClass().getClassLoader();
	File file = new File(classLoader.getResource("artilharia.json").getFile());

	try {
	    JavaType type = mapper.getTypeFactory().constructCollectionType(List.class, Artilharia.class);

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

    public List<Artilharia> getArtilharia() {
	return artilharia;
    }

    public void setArtilharia(List<Artilharia> artilharia) {
	this.artilharia = artilharia;
    }

    @Override
    public String toString() {
	return "CarregarArtilharia [artilharia=" + artilharia + "]";
    }

    public static void main(String[] args) {

	CarregarArtilharia carregarArtilharia = new CarregarArtilharia();

	System.out.println(carregarArtilharia);
	System.out.println("");
    }

}

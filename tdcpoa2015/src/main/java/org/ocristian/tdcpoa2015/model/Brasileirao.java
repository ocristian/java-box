package org.ocristian.tdcpoa2015.model;

import java.util.List;
import java.util.Map;

public class Brasileirao {

    private String url;

    private String nome_fase;

    private Map<String, String> class_names;

    private Edicao edicao;

    private List<Classificacao> classificacao;

    private Campeonato campeonato;

    private String img_url;

    private String css;

    public Brasileirao() {
	super();
    }

    public Brasileirao(String url, String nome_fase, Map<String, String> class_names, Edicao edicao, List<Classificacao> classificacao,
	    Campeonato campeonato, String img_url, String css) {
	super();
	this.url = url;
	this.nome_fase = nome_fase;
	this.class_names = class_names;
	this.edicao = edicao;
	this.classificacao = classificacao;
	this.campeonato = campeonato;
	this.img_url = img_url;
	this.css = css;
    }

    public String getUrl() {
	return url;
    }

    public void setUrl(String url) {
	this.url = url;
    }

    public String getNome_fase() {
	return nome_fase;
    }

    public void setNome_fase(String nome_fase) {
	this.nome_fase = nome_fase;
    }

    public Map<String, String> getClass_names() {
	return class_names;
    }

    public void setClass_names(Map<String, String> class_names) {
	this.class_names = class_names;
    }

    public Edicao getEdicao() {
	return edicao;
    }

    public void setEdicao(Edicao edicao) {
	this.edicao = edicao;
    }

    public List<Classificacao> getClassificacao() {
	return classificacao;
    }

    public void setClassificacao(List<Classificacao> classificacao) {
	this.classificacao = classificacao;
    }

    public Campeonato getCampeonato() {
	return campeonato;
    }

    public void setCampeonato(Campeonato campeonato) {
	this.campeonato = campeonato;
    }

    public String getImg_url() {
	return img_url;
    }

    public void setImg_url(String img_url) {
	this.img_url = img_url;
    }

    public String getCss() {
	return css;
    }

    public void setCss(String css) {
	this.css = css;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((campeonato == null) ? 0 : campeonato.hashCode());
	result = prime * result + ((class_names == null) ? 0 : class_names.hashCode());
	result = prime * result + ((classificacao == null) ? 0 : classificacao.hashCode());
	result = prime * result + ((css == null) ? 0 : css.hashCode());
	result = prime * result + ((edicao == null) ? 0 : edicao.hashCode());
	result = prime * result + ((img_url == null) ? 0 : img_url.hashCode());
	result = prime * result + ((nome_fase == null) ? 0 : nome_fase.hashCode());
	result = prime * result + ((url == null) ? 0 : url.hashCode());
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
	Brasileirao other = (Brasileirao) obj;
	if (campeonato == null) {
	    if (other.campeonato != null)
		return false;
	} else if (!campeonato.equals(other.campeonato))
	    return false;
	if (class_names == null) {
	    if (other.class_names != null)
		return false;
	} else if (!class_names.equals(other.class_names))
	    return false;
	if (classificacao == null) {
	    if (other.classificacao != null)
		return false;
	} else if (!classificacao.equals(other.classificacao))
	    return false;
	if (css == null) {
	    if (other.css != null)
		return false;
	} else if (!css.equals(other.css))
	    return false;
	if (edicao == null) {
	    if (other.edicao != null)
		return false;
	} else if (!edicao.equals(other.edicao))
	    return false;
	if (img_url == null) {
	    if (other.img_url != null)
		return false;
	} else if (!img_url.equals(other.img_url))
	    return false;
	if (nome_fase == null) {
	    if (other.nome_fase != null)
		return false;
	} else if (!nome_fase.equals(other.nome_fase))
	    return false;
	if (url == null) {
	    if (other.url != null)
		return false;
	} else if (!url.equals(other.url))
	    return false;
	return true;
    }

    @Override
    public String toString() {
	return "Brasileirao [url=" + url + ", nome_fase=" + nome_fase + ", class_names=" + class_names + ", edicao=" + edicao
		+ ", classificacao=" + classificacao + ", campeonato=" + campeonato + ", img_url=" + img_url + ", css=" + css + "]";
    }

}

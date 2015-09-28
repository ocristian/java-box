package org.ocristian.tdcpoa2015.model;

public class Fase {

    private long fase_id;
    private String nome;

    private String data_inicio;
    private String data_fim;

    private boolean atual;

    private long edicao_id;
    private Edicao edicao;

    private int ordem;

    private Tipo tipo;

    private Formato formato;

    private String slug;
    private String disclaimer;

    public Fase() {
	super();
    }

    public Fase(long fase_id, String nome, String data_inicio, String data_fim, boolean atual, long edicao_id, Edicao edicao, int ordem,
	    Tipo tipo, Formato formato, String slug, String disclaimer) {
	super();
	this.fase_id = fase_id;
	this.nome = nome;
	this.data_inicio = data_inicio;
	this.data_fim = data_fim;
	this.atual = atual;
	this.edicao_id = edicao_id;
	this.edicao = edicao;
	this.ordem = ordem;
	this.tipo = tipo;
	this.formato = formato;
	this.slug = slug;
	this.disclaimer = disclaimer;
    }

    public long getFase_id() {
	return fase_id;
    }

    public void setFase_id(long fase_id) {
	this.fase_id = fase_id;
    }

    public String getNome() {
	return nome;
    }

    public void setNome(String nome) {
	this.nome = nome;
    }

    public String getData_inicio() {
	return data_inicio;
    }

    public void setData_inicio(String data_inicio) {
	this.data_inicio = data_inicio;
    }

    public String getData_fim() {
	return data_fim;
    }

    public void setData_fim(String data_fim) {
	this.data_fim = data_fim;
    }

    public boolean isAtual() {
	return atual;
    }

    public void setAtual(boolean atual) {
	this.atual = atual;
    }

    public long getEdicao_id() {
	return edicao_id;
    }

    public void setEdicao_id(long edicao_id) {
	this.edicao_id = edicao_id;
    }

    public Edicao getEdicao() {
	return edicao;
    }

    public void setEdicao(Edicao edicao) {
	this.edicao = edicao;
    }

    public int getOrdem() {
	return ordem;
    }

    public void setOrdem(int ordem) {
	this.ordem = ordem;
    }

    public Tipo getTipo() {
	return tipo;
    }

    public void setTipo(Tipo tipo) {
	this.tipo = tipo;
    }

    public Formato getFormato() {
	return formato;
    }

    public void setFormato(Formato formato) {
	this.formato = formato;
    }

    public String getSlug() {
	return slug;
    }

    public void setSlug(String slug) {
	this.slug = slug;
    }

    public String getDisclaimer() {
	return disclaimer;
    }

    public void setDisclaimer(String disclaimer) {
	this.disclaimer = disclaimer;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + (atual ? 1231 : 1237);
	result = prime * result + ((data_fim == null) ? 0 : data_fim.hashCode());
	result = prime * result + ((data_inicio == null) ? 0 : data_inicio.hashCode());
	result = prime * result + ((disclaimer == null) ? 0 : disclaimer.hashCode());
	result = prime * result + ((edicao == null) ? 0 : edicao.hashCode());
	result = prime * result + (int) (edicao_id ^ (edicao_id >>> 32));
	result = prime * result + (int) (fase_id ^ (fase_id >>> 32));
	result = prime * result + ((formato == null) ? 0 : formato.hashCode());
	result = prime * result + ((nome == null) ? 0 : nome.hashCode());
	result = prime * result + ordem;
	result = prime * result + ((slug == null) ? 0 : slug.hashCode());
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
	Fase other = (Fase) obj;
	if (atual != other.atual)
	    return false;
	if (data_fim == null) {
	    if (other.data_fim != null)
		return false;
	} else if (!data_fim.equals(other.data_fim))
	    return false;
	if (data_inicio == null) {
	    if (other.data_inicio != null)
		return false;
	} else if (!data_inicio.equals(other.data_inicio))
	    return false;
	if (disclaimer == null) {
	    if (other.disclaimer != null)
		return false;
	} else if (!disclaimer.equals(other.disclaimer))
	    return false;
	if (edicao == null) {
	    if (other.edicao != null)
		return false;
	} else if (!edicao.equals(other.edicao))
	    return false;
	if (edicao_id != other.edicao_id)
	    return false;
	if (fase_id != other.fase_id)
	    return false;
	if (formato == null) {
	    if (other.formato != null)
		return false;
	} else if (!formato.equals(other.formato))
	    return false;
	if (nome == null) {
	    if (other.nome != null)
		return false;
	} else if (!nome.equals(other.nome))
	    return false;
	if (ordem != other.ordem)
	    return false;
	if (slug == null) {
	    if (other.slug != null)
		return false;
	} else if (!slug.equals(other.slug))
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
	return "Fase [fase_id=" + fase_id + ", nome=" + nome + ", data_inicio=" + data_inicio + ", data_fim=" + data_fim + ", atual="
		+ atual + ", edicao_id=" + edicao_id + ", edicao=" + edicao + ", ordem=" + ordem + ", tipo=" + tipo + ", formato=" + formato
		+ ", slug=" + slug + ", disclaimer=" + disclaimer + "]";
    }

}

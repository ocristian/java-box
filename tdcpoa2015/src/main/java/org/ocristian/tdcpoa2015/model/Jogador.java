package org.ocristian.tdcpoa2015.model;

import java.time.LocalDate;

import org.ocristian.tdcpoa2015.enums.Posicao;

public class Jogador {

    private String nome;

    private Double peso;

    private LocalDate dataNascimento;

    private Double altura;

    private Posicao posicao;

    public Jogador() {
	super();
    }

    public Jogador(String nome, Double peso, LocalDate dataNascimento, Double altura, Posicao posicao) {
	super();
	this.nome = nome;
	this.peso = peso;
	this.dataNascimento = dataNascimento;
	this.altura = altura;
	this.posicao = posicao;
    }

    public String getNome() {
	return nome;
    }

    public void setNome(String nome) {
	this.nome = nome;
    }

    public Double getPeso() {
	return peso;
    }

    public void setPeso(Double peso) {
	this.peso = peso;
    }

    public LocalDate getDataNascimento() {
	return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
	this.dataNascimento = dataNascimento;
    }

    public Double getAltura() {
	return altura;
    }

    public void setAltura(Double altura) {
	this.altura = altura;
    }

    public Posicao getPosicao() {
	return posicao;
    }

    public void setPosicao(Posicao posicao) {
	this.posicao = posicao;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((altura == null) ? 0 : altura.hashCode());
	result = prime * result + ((dataNascimento == null) ? 0 : dataNascimento.hashCode());
	result = prime * result + ((nome == null) ? 0 : nome.hashCode());
	result = prime * result + ((peso == null) ? 0 : peso.hashCode());
	result = prime * result + ((posicao == null) ? 0 : posicao.hashCode());
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
	Jogador other = (Jogador) obj;
	if (altura == null) {
	    if (other.altura != null)
		return false;
	} else if (!altura.equals(other.altura))
	    return false;
	if (dataNascimento == null) {
	    if (other.dataNascimento != null)
		return false;
	} else if (!dataNascimento.equals(other.dataNascimento))
	    return false;
	if (nome == null) {
	    if (other.nome != null)
		return false;
	} else if (!nome.equals(other.nome))
	    return false;
	if (peso == null) {
	    if (other.peso != null)
		return false;
	} else if (!peso.equals(other.peso))
	    return false;
	if (posicao != other.posicao)
	    return false;
	return true;
    }

    @Override
    public String toString() {
	return "Jogador [nome=" + nome + ", peso=" + peso + ", dataNascimento=" + dataNascimento + ", altura=" + altura + ", posicao="
		+ posicao + "]";
    }

}
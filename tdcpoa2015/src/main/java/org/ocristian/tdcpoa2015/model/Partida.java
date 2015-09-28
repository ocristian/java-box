package org.ocristian.tdcpoa2015.model;

import java.util.List;

public class Partida {

    private long id;

    private long id_api;

    private List<Gol> gols;

    private String equipe_mandante_nome;

    private String equipe_mandante_url_logo;

    private String equipe_mandante_sigla;

    private int placar_mandante;

    private int placar_penaltis_mandante;

    private String tecnico_mandante;

    private String equipe_visitante_nome;

    private String equipe_visitante_url_logo;

    private String equipe_visitante_sigla;

    private int placar_visitante;

    private int placar_penaltis_visitante;

    private String tecnico_visitante;

    private String campeonato_nome;

    private int rodada_campeonato;

    private String taca;

    private String grupo;

    private String fase;

    private int temporada;

    private String cidade;

    private String nome_estadio;

    private String data;

    private String match_date;

    private String arbitro;

    private long publico;

    private double renda;

    private int num_jogo_chave;

    private boolean tem_data_definida;

    private boolean tem_hora_definida;

    private boolean tem_estatistica;

    private boolean tem_narracao;

    private long equipe_mandante;

    private long equipe_visitante;

    private int campeonato;

    private int fase_campeonato;

    private int fase_ordem;

    public Partida() {
	super();
    }

    public Partida(long id, long id_api, List<Gol> gols, String equipe_mandante_nome, String equipe_mandante_url_logo,
	    String equipe_mandante_sigla, int placar_mandante, int placar_penaltis_mandante, String tecnico_mandante,
	    String equipe_visitante_nome, String equipe_visitante_url_logo, String equipe_visitante_sigla, int placar_visitante,
	    int placar_penaltis_visitante, String tecnico_visitante, String campeonato_nome, int rodada_campeonato, String taca,
	    String grupo, String fase, int temporada, String cidade, String nome_estadio, String data, String match_date, String arbitro,
	    long publico, double renda, int num_jogo_chave, boolean tem_data_definida, boolean tem_hora_definida, boolean tem_estatistica,
	    boolean tem_narracao, long equipe_mandante, long equipe_visitante, int campeonato, int fase_campeonato, int fase_ordem) {
	super();
	this.id = id;
	this.id_api = id_api;
	this.gols = gols;
	this.equipe_mandante_nome = equipe_mandante_nome;
	this.equipe_mandante_url_logo = equipe_mandante_url_logo;
	this.equipe_mandante_sigla = equipe_mandante_sigla;
	this.placar_mandante = placar_mandante;
	this.placar_penaltis_mandante = placar_penaltis_mandante;
	this.tecnico_mandante = tecnico_mandante;
	this.equipe_visitante_nome = equipe_visitante_nome;
	this.equipe_visitante_url_logo = equipe_visitante_url_logo;
	this.equipe_visitante_sigla = equipe_visitante_sigla;
	this.placar_visitante = placar_visitante;
	this.placar_penaltis_visitante = placar_penaltis_visitante;
	this.tecnico_visitante = tecnico_visitante;
	this.campeonato_nome = campeonato_nome;
	this.rodada_campeonato = rodada_campeonato;
	this.taca = taca;
	this.grupo = grupo;
	this.fase = fase;
	this.temporada = temporada;
	this.cidade = cidade;
	this.nome_estadio = nome_estadio;
	this.data = data;
	this.match_date = match_date;
	this.arbitro = arbitro;
	this.publico = publico;
	this.renda = renda;
	this.num_jogo_chave = num_jogo_chave;
	this.tem_data_definida = tem_data_definida;
	this.tem_hora_definida = tem_hora_definida;
	this.tem_estatistica = tem_estatistica;
	this.tem_narracao = tem_narracao;
	this.equipe_mandante = equipe_mandante;
	this.equipe_visitante = equipe_visitante;
	this.campeonato = campeonato;
	this.fase_campeonato = fase_campeonato;
	this.fase_ordem = fase_ordem;
    }

    public long getId() {
	return id;
    }

    public void setId(long id) {
	this.id = id;
    }

    public long getId_api() {
	return id_api;
    }

    public void setId_api(long id_api) {
	this.id_api = id_api;
    }

    public List<Gol> getGols() {
	return gols;
    }

    public void setGols(List<Gol> gols) {
	this.gols = gols;
    }

    public String getEquipe_mandante_nome() {
	return equipe_mandante_nome;
    }

    public void setEquipe_mandante_nome(String equipe_mandante_nome) {
	this.equipe_mandante_nome = equipe_mandante_nome;
    }

    public String getEquipe_mandante_url_logo() {
	return equipe_mandante_url_logo;
    }

    public void setEquipe_mandante_url_logo(String equipe_mandante_url_logo) {
	this.equipe_mandante_url_logo = equipe_mandante_url_logo;
    }

    public String getEquipe_mandante_sigla() {
	return equipe_mandante_sigla;
    }

    public void setEquipe_mandante_sigla(String equipe_mandante_sigla) {
	this.equipe_mandante_sigla = equipe_mandante_sigla;
    }

    public int getPlacar_mandante() {
	return placar_mandante;
    }

    public void setPlacar_mandante(int placar_mandante) {
	this.placar_mandante = placar_mandante;
    }

    public int getPlacar_penaltis_mandante() {
	return placar_penaltis_mandante;
    }

    public void setPlacar_penaltis_mandante(int placar_penaltis_mandante) {
	this.placar_penaltis_mandante = placar_penaltis_mandante;
    }

    public String getTecnico_mandante() {
	return tecnico_mandante;
    }

    public void setTecnico_mandante(String tecnico_mandante) {
	this.tecnico_mandante = tecnico_mandante;
    }

    public String getEquipe_visitante_nome() {
	return equipe_visitante_nome;
    }

    public void setEquipe_visitante_nome(String equipe_visitante_nome) {
	this.equipe_visitante_nome = equipe_visitante_nome;
    }

    public String getEquipe_visitante_url_logo() {
	return equipe_visitante_url_logo;
    }

    public void setEquipe_visitante_url_logo(String equipe_visitante_url_logo) {
	this.equipe_visitante_url_logo = equipe_visitante_url_logo;
    }

    public String getEquipe_visitante_sigla() {
	return equipe_visitante_sigla;
    }

    public void setEquipe_visitante_sigla(String equipe_visitante_sigla) {
	this.equipe_visitante_sigla = equipe_visitante_sigla;
    }

    public int getPlacar_visitante() {
	return placar_visitante;
    }

    public void setPlacar_visitante(int placar_visitante) {
	this.placar_visitante = placar_visitante;
    }

    public int getPlacar_penaltis_visitante() {
	return placar_penaltis_visitante;
    }

    public void setPlacar_penaltis_visitante(int placar_penaltis_visitante) {
	this.placar_penaltis_visitante = placar_penaltis_visitante;
    }

    public String getTecnico_visitante() {
	return tecnico_visitante;
    }

    public void setTecnico_visitante(String tecnico_visitante) {
	this.tecnico_visitante = tecnico_visitante;
    }

    public String getCampeonato_nome() {
	return campeonato_nome;
    }

    public void setCampeonato_nome(String campeonato_nome) {
	this.campeonato_nome = campeonato_nome;
    }

    public int getRodada_campeonato() {
	return rodada_campeonato;
    }

    public void setRodada_campeonato(int rodada_campeonato) {
	this.rodada_campeonato = rodada_campeonato;
    }

    public String getTaca() {
	return taca;
    }

    public void setTaca(String taca) {
	this.taca = taca;
    }

    public String getGrupo() {
	return grupo;
    }

    public void setGrupo(String grupo) {
	this.grupo = grupo;
    }

    public String getFase() {
	return fase;
    }

    public void setFase(String fase) {
	this.fase = fase;
    }

    public int getTemporada() {
	return temporada;
    }

    public void setTemporada(int temporada) {
	this.temporada = temporada;
    }

    public String getCidade() {
	return cidade;
    }

    public void setCidade(String cidade) {
	this.cidade = cidade;
    }

    public String getNome_estadio() {
	return nome_estadio;
    }

    public void setNome_estadio(String nome_estadio) {
	this.nome_estadio = nome_estadio;
    }

    public String getData() {
	return data;
    }

    public void setData(String data) {
	this.data = data;
    }

    public String getMatch_date() {
	return match_date;
    }

    public void setMatch_date(String match_date) {
	this.match_date = match_date;
    }

    public String getArbitro() {
	return arbitro;
    }

    public void setArbitro(String arbitro) {
	this.arbitro = arbitro;
    }

    public long getPublico() {
	return publico;
    }

    public void setPublico(long publico) {
	this.publico = publico;
    }

    public double getRenda() {
	return renda;
    }

    public void setRenda(double renda) {
	this.renda = renda;
    }

    public int getNum_jogo_chave() {
	return num_jogo_chave;
    }

    public void setNum_jogo_chave(int num_jogo_chave) {
	this.num_jogo_chave = num_jogo_chave;
    }

    public boolean isTem_data_definida() {
	return tem_data_definida;
    }

    public void setTem_data_definida(boolean tem_data_definida) {
	this.tem_data_definida = tem_data_definida;
    }

    public boolean isTem_hora_definida() {
	return tem_hora_definida;
    }

    public void setTem_hora_definida(boolean tem_hora_definida) {
	this.tem_hora_definida = tem_hora_definida;
    }

    public boolean isTem_estatistica() {
	return tem_estatistica;
    }

    public void setTem_estatistica(boolean tem_estatistica) {
	this.tem_estatistica = tem_estatistica;
    }

    public boolean isTem_narracao() {
	return tem_narracao;
    }

    public void setTem_narracao(boolean tem_narracao) {
	this.tem_narracao = tem_narracao;
    }

    public long getEquipe_mandante() {
	return equipe_mandante;
    }

    public void setEquipe_mandante(long equipe_mandante) {
	this.equipe_mandante = equipe_mandante;
    }

    public long getEquipe_visitante() {
	return equipe_visitante;
    }

    public void setEquipe_visitante(long equipe_visitante) {
	this.equipe_visitante = equipe_visitante;
    }

    public int getCampeonato() {
	return campeonato;
    }

    public void setCampeonato(int campeonato) {
	this.campeonato = campeonato;
    }

    public int getFase_campeonato() {
	return fase_campeonato;
    }

    public void setFase_campeonato(int fase_campeonato) {
	this.fase_campeonato = fase_campeonato;
    }

    public int getFase_ordem() {
	return fase_ordem;
    }

    public void setFase_ordem(int fase_ordem) {
	this.fase_ordem = fase_ordem;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((arbitro == null) ? 0 : arbitro.hashCode());
	result = prime * result + campeonato;
	result = prime * result + ((campeonato_nome == null) ? 0 : campeonato_nome.hashCode());
	result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
	result = prime * result + ((data == null) ? 0 : data.hashCode());
	result = prime * result + (int) (equipe_mandante ^ (equipe_mandante >>> 32));
	result = prime * result + ((equipe_mandante_nome == null) ? 0 : equipe_mandante_nome.hashCode());
	result = prime * result + ((equipe_mandante_sigla == null) ? 0 : equipe_mandante_sigla.hashCode());
	result = prime * result + ((equipe_mandante_url_logo == null) ? 0 : equipe_mandante_url_logo.hashCode());
	result = prime * result + (int) (equipe_visitante ^ (equipe_visitante >>> 32));
	result = prime * result + ((equipe_visitante_nome == null) ? 0 : equipe_visitante_nome.hashCode());
	result = prime * result + ((equipe_visitante_sigla == null) ? 0 : equipe_visitante_sigla.hashCode());
	result = prime * result + ((equipe_visitante_url_logo == null) ? 0 : equipe_visitante_url_logo.hashCode());
	result = prime * result + ((fase == null) ? 0 : fase.hashCode());
	result = prime * result + fase_campeonato;
	result = prime * result + fase_ordem;
	result = prime * result + ((gols == null) ? 0 : gols.hashCode());
	result = prime * result + ((grupo == null) ? 0 : grupo.hashCode());
	result = prime * result + (int) (id ^ (id >>> 32));
	result = prime * result + (int) (id_api ^ (id_api >>> 32));
	result = prime * result + ((match_date == null) ? 0 : match_date.hashCode());
	result = prime * result + ((nome_estadio == null) ? 0 : nome_estadio.hashCode());
	result = prime * result + num_jogo_chave;
	result = prime * result + placar_mandante;
	result = prime * result + placar_penaltis_mandante;
	result = prime * result + placar_penaltis_visitante;
	result = prime * result + placar_visitante;
	result = prime * result + (int) (publico ^ (publico >>> 32));
	long temp;
	temp = Double.doubleToLongBits(renda);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	result = prime * result + rodada_campeonato;
	result = prime * result + ((taca == null) ? 0 : taca.hashCode());
	result = prime * result + ((tecnico_mandante == null) ? 0 : tecnico_mandante.hashCode());
	result = prime * result + ((tecnico_visitante == null) ? 0 : tecnico_visitante.hashCode());
	result = prime * result + (tem_data_definida ? 1231 : 1237);
	result = prime * result + (tem_estatistica ? 1231 : 1237);
	result = prime * result + (tem_hora_definida ? 1231 : 1237);
	result = prime * result + (tem_narracao ? 1231 : 1237);
	result = prime * result + temporada;
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
	Partida other = (Partida) obj;
	if (arbitro == null) {
	    if (other.arbitro != null)
		return false;
	} else if (!arbitro.equals(other.arbitro))
	    return false;
	if (campeonato != other.campeonato)
	    return false;
	if (campeonato_nome == null) {
	    if (other.campeonato_nome != null)
		return false;
	} else if (!campeonato_nome.equals(other.campeonato_nome))
	    return false;
	if (cidade == null) {
	    if (other.cidade != null)
		return false;
	} else if (!cidade.equals(other.cidade))
	    return false;
	if (data == null) {
	    if (other.data != null)
		return false;
	} else if (!data.equals(other.data))
	    return false;
	if (equipe_mandante != other.equipe_mandante)
	    return false;
	if (equipe_mandante_nome == null) {
	    if (other.equipe_mandante_nome != null)
		return false;
	} else if (!equipe_mandante_nome.equals(other.equipe_mandante_nome))
	    return false;
	if (equipe_mandante_sigla == null) {
	    if (other.equipe_mandante_sigla != null)
		return false;
	} else if (!equipe_mandante_sigla.equals(other.equipe_mandante_sigla))
	    return false;
	if (equipe_mandante_url_logo == null) {
	    if (other.equipe_mandante_url_logo != null)
		return false;
	} else if (!equipe_mandante_url_logo.equals(other.equipe_mandante_url_logo))
	    return false;
	if (equipe_visitante != other.equipe_visitante)
	    return false;
	if (equipe_visitante_nome == null) {
	    if (other.equipe_visitante_nome != null)
		return false;
	} else if (!equipe_visitante_nome.equals(other.equipe_visitante_nome))
	    return false;
	if (equipe_visitante_sigla == null) {
	    if (other.equipe_visitante_sigla != null)
		return false;
	} else if (!equipe_visitante_sigla.equals(other.equipe_visitante_sigla))
	    return false;
	if (equipe_visitante_url_logo == null) {
	    if (other.equipe_visitante_url_logo != null)
		return false;
	} else if (!equipe_visitante_url_logo.equals(other.equipe_visitante_url_logo))
	    return false;
	if (fase == null) {
	    if (other.fase != null)
		return false;
	} else if (!fase.equals(other.fase))
	    return false;
	if (fase_campeonato != other.fase_campeonato)
	    return false;
	if (fase_ordem != other.fase_ordem)
	    return false;
	if (gols == null) {
	    if (other.gols != null)
		return false;
	} else if (!gols.equals(other.gols))
	    return false;
	if (grupo == null) {
	    if (other.grupo != null)
		return false;
	} else if (!grupo.equals(other.grupo))
	    return false;
	if (id != other.id)
	    return false;
	if (id_api != other.id_api)
	    return false;
	if (match_date == null) {
	    if (other.match_date != null)
		return false;
	} else if (!match_date.equals(other.match_date))
	    return false;
	if (nome_estadio == null) {
	    if (other.nome_estadio != null)
		return false;
	} else if (!nome_estadio.equals(other.nome_estadio))
	    return false;
	if (num_jogo_chave != other.num_jogo_chave)
	    return false;
	if (placar_mandante != other.placar_mandante)
	    return false;
	if (placar_penaltis_mandante != other.placar_penaltis_mandante)
	    return false;
	if (placar_penaltis_visitante != other.placar_penaltis_visitante)
	    return false;
	if (placar_visitante != other.placar_visitante)
	    return false;
	if (publico != other.publico)
	    return false;
	if (Double.doubleToLongBits(renda) != Double.doubleToLongBits(other.renda))
	    return false;
	if (rodada_campeonato != other.rodada_campeonato)
	    return false;
	if (taca == null) {
	    if (other.taca != null)
		return false;
	} else if (!taca.equals(other.taca))
	    return false;
	if (tecnico_mandante == null) {
	    if (other.tecnico_mandante != null)
		return false;
	} else if (!tecnico_mandante.equals(other.tecnico_mandante))
	    return false;
	if (tecnico_visitante == null) {
	    if (other.tecnico_visitante != null)
		return false;
	} else if (!tecnico_visitante.equals(other.tecnico_visitante))
	    return false;
	if (tem_data_definida != other.tem_data_definida)
	    return false;
	if (tem_estatistica != other.tem_estatistica)
	    return false;
	if (tem_hora_definida != other.tem_hora_definida)
	    return false;
	if (tem_narracao != other.tem_narracao)
	    return false;
	if (temporada != other.temporada)
	    return false;
	return true;
    }

    @Override
    public String toString() {
	return "Partida [id=" + id + ", id_api=" + id_api + ", gols=" + gols + ", equipe_mandante_nome=" + equipe_mandante_nome
		+ ", equipe_mandante_url_logo=" + equipe_mandante_url_logo + ", equipe_mandante_sigla=" + equipe_mandante_sigla
		+ ", placar_mandante=" + placar_mandante + ", placar_penaltis_mandante=" + placar_penaltis_mandante + ", tecnico_mandante="
		+ tecnico_mandante + ", equipe_visitante_nome=" + equipe_visitante_nome + ", equipe_visitante_url_logo="
		+ equipe_visitante_url_logo + ", equipe_visitante_sigla=" + equipe_visitante_sigla + ", placar_visitante="
		+ placar_visitante + ", placar_penaltis_visitante=" + placar_penaltis_visitante + ", tecnico_visitante=" + tecnico_visitante
		+ ", campeonato_nome=" + campeonato_nome + ", rodada_campeonato=" + rodada_campeonato + ", taca=" + taca + ", grupo="
		+ grupo + ", fase=" + fase + ", temporada=" + temporada + ", cidade=" + cidade + ", nome_estadio=" + nome_estadio
		+ ", data=" + data + ", match_date=" + match_date + ", arbitro=" + arbitro + ", publico=" + publico + ", renda=" + renda
		+ ", num_jogo_chave=" + num_jogo_chave + ", tem_data_definida=" + tem_data_definida + ", tem_hora_definida="
		+ tem_hora_definida + ", tem_estatistica=" + tem_estatistica + ", tem_narracao=" + tem_narracao + ", equipe_mandante="
		+ equipe_mandante + ", equipe_visitante=" + equipe_visitante + ", campeonato=" + campeonato + ", fase_campeonato="
		+ fase_campeonato + ", fase_ordem=" + fase_ordem + "]";
    }

}

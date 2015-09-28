package org.ocristian.tdcpoa2015.model;

public class Jogo {

    private long jogo_id;
    private int rodada;
    private VencedorJogo vencedor_jogo;

    private long equipe_mandante_id;
    private long equipe_visitante_id;

    private long escalacao_mandante_id;
    private long escalacao_visitante_id;

    private boolean cancelado;
    private boolean suspenso;
    private boolean wo;
    private boolean decisivo;

    private String placar_penaltis_mandante;
    private String placar_penaltis_visitante;

    private long fase_id;
    private Fase fase;

    private EquipeVisitante equipe_visitante;
    private EquipeMandante equipe_mandante;

    private long sede_id;
    private Sede sede;

    private int placar_oficial_visitante;
    private int placar_oficial_mandante;

    private String hora_realizacao;
    private String data_realizacao;

    public Jogo() {
	super();
    }

    public Jogo(long jogo_id, int rodada, VencedorJogo vencedor_jogo, long equipe_mandante_id, long equipe_visitante_id,
	    long escalacao_mandante_id, long escalacao_visitante_id, boolean cancelado, boolean suspenso, boolean wo, boolean decisivo,
	    String placar_penaltis_mandante, String placar_penaltis_visitante, long fase_id, Fase fase, EquipeVisitante equipe_visitante,
	    EquipeMandante equipe_mandante, long sede_id, Sede sede, int placar_oficial_visitante, int placar_oficial_mandante,
	    String hora_realizacao, String data_realizacao) {
	super();
	this.jogo_id = jogo_id;
	this.rodada = rodada;
	this.vencedor_jogo = vencedor_jogo;
	this.equipe_mandante_id = equipe_mandante_id;
	this.equipe_visitante_id = equipe_visitante_id;
	this.escalacao_mandante_id = escalacao_mandante_id;
	this.escalacao_visitante_id = escalacao_visitante_id;
	this.cancelado = cancelado;
	this.suspenso = suspenso;
	this.wo = wo;
	this.decisivo = decisivo;
	this.placar_penaltis_mandante = placar_penaltis_mandante;
	this.placar_penaltis_visitante = placar_penaltis_visitante;
	this.fase_id = fase_id;
	this.fase = fase;
	this.equipe_visitante = equipe_visitante;
	this.equipe_mandante = equipe_mandante;
	this.sede_id = sede_id;
	this.sede = sede;
	this.placar_oficial_visitante = placar_oficial_visitante;
	this.placar_oficial_mandante = placar_oficial_mandante;
	this.hora_realizacao = hora_realizacao;
	this.data_realizacao = data_realizacao;
    }

    public long getJogo_id() {
	return jogo_id;
    }

    public void setJogo_id(long jogo_id) {
	this.jogo_id = jogo_id;
    }

    public int getRodada() {
	return rodada;
    }

    public void setRodada(int rodada) {
	this.rodada = rodada;
    }

    public VencedorJogo getVencedor_jogo() {
	return vencedor_jogo;
    }

    public void setVencedor_jogo(VencedorJogo vencedor_jogo) {
	this.vencedor_jogo = vencedor_jogo;
    }

    public long getEquipe_mandante_id() {
	return equipe_mandante_id;
    }

    public void setEquipe_mandante_id(long equipe_mandante_id) {
	this.equipe_mandante_id = equipe_mandante_id;
    }

    public long getEquipe_visitante_id() {
	return equipe_visitante_id;
    }

    public void setEquipe_visitante_id(long equipe_visitante_id) {
	this.equipe_visitante_id = equipe_visitante_id;
    }

    public long getEscalacao_mandante_id() {
	return escalacao_mandante_id;
    }

    public void setEscalacao_mandante_id(long escalacao_mandante_id) {
	this.escalacao_mandante_id = escalacao_mandante_id;
    }

    public long getEscalacao_visitante_id() {
	return escalacao_visitante_id;
    }

    public void setEscalacao_visitante_id(long escalacao_visitante_id) {
	this.escalacao_visitante_id = escalacao_visitante_id;
    }

    public boolean isCancelado() {
	return cancelado;
    }

    public void setCancelado(boolean cancelado) {
	this.cancelado = cancelado;
    }

    public boolean isSuspenso() {
	return suspenso;
    }

    public void setSuspenso(boolean suspenso) {
	this.suspenso = suspenso;
    }

    public boolean isWo() {
	return wo;
    }

    public void setWo(boolean wo) {
	this.wo = wo;
    }

    public boolean isDecisivo() {
	return decisivo;
    }

    public void setDecisivo(boolean decisivo) {
	this.decisivo = decisivo;
    }

    public String getPlacar_penaltis_mandante() {
	return placar_penaltis_mandante;
    }

    public void setPlacar_penaltis_mandante(String placar_penaltis_mandante) {
	this.placar_penaltis_mandante = placar_penaltis_mandante;
    }

    public String getPlacar_penaltis_visitante() {
	return placar_penaltis_visitante;
    }

    public void setPlacar_penaltis_visitante(String placar_penaltis_visitante) {
	this.placar_penaltis_visitante = placar_penaltis_visitante;
    }

    public long getFase_id() {
	return fase_id;
    }

    public void setFase_id(long fase_id) {
	this.fase_id = fase_id;
    }

    public Fase getFase() {
	return fase;
    }

    public void setFase(Fase fase) {
	this.fase = fase;
    }

    public EquipeVisitante getEquipe_visitante() {
	return equipe_visitante;
    }

    public void setEquipe_visitante(EquipeVisitante equipe_visitante) {
	this.equipe_visitante = equipe_visitante;
    }

    public EquipeMandante getEquipe_mandante() {
	return equipe_mandante;
    }

    public void setEquipe_mandante(EquipeMandante equipe_mandante) {
	this.equipe_mandante = equipe_mandante;
    }

    public long getSede_id() {
	return sede_id;
    }

    public void setSede_id(long sede_id) {
	this.sede_id = sede_id;
    }

    public Sede getSede() {
	return sede;
    }

    public void setSede(Sede sede) {
	this.sede = sede;
    }

    public int getPlacar_oficial_visitante() {
	return placar_oficial_visitante;
    }

    public void setPlacar_oficial_visitante(int placar_oficial_visitante) {
	this.placar_oficial_visitante = placar_oficial_visitante;
    }

    public int getPlacar_oficial_mandante() {
	return placar_oficial_mandante;
    }

    public void setPlacar_oficial_mandante(int placar_oficial_mandante) {
	this.placar_oficial_mandante = placar_oficial_mandante;
    }

    public String getHora_realizacao() {
	return hora_realizacao;
    }

    public void setHora_realizacao(String hora_realizacao) {
	this.hora_realizacao = hora_realizacao;
    }

    public String getData_realizacao() {
	return data_realizacao;
    }

    public void setData_realizacao(String data_realizacao) {
	this.data_realizacao = data_realizacao;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + (cancelado ? 1231 : 1237);
	result = prime * result + ((data_realizacao == null) ? 0 : data_realizacao.hashCode());
	result = prime * result + (decisivo ? 1231 : 1237);
	result = prime * result + ((equipe_mandante == null) ? 0 : equipe_mandante.hashCode());
	result = prime * result + (int) (equipe_mandante_id ^ (equipe_mandante_id >>> 32));
	result = prime * result + ((equipe_visitante == null) ? 0 : equipe_visitante.hashCode());
	result = prime * result + (int) (equipe_visitante_id ^ (equipe_visitante_id >>> 32));
	result = prime * result + (int) (escalacao_mandante_id ^ (escalacao_mandante_id >>> 32));
	result = prime * result + (int) (escalacao_visitante_id ^ (escalacao_visitante_id >>> 32));
	result = prime * result + ((fase == null) ? 0 : fase.hashCode());
	result = prime * result + (int) (fase_id ^ (fase_id >>> 32));
	result = prime * result + ((hora_realizacao == null) ? 0 : hora_realizacao.hashCode());
	result = prime * result + (int) (jogo_id ^ (jogo_id >>> 32));
	result = prime * result + placar_oficial_mandante;
	result = prime * result + placar_oficial_visitante;
	result = prime * result + ((placar_penaltis_mandante == null) ? 0 : placar_penaltis_mandante.hashCode());
	result = prime * result + ((placar_penaltis_visitante == null) ? 0 : placar_penaltis_visitante.hashCode());
	result = prime * result + rodada;
	result = prime * result + ((sede == null) ? 0 : sede.hashCode());
	result = prime * result + (int) (sede_id ^ (sede_id >>> 32));
	result = prime * result + (suspenso ? 1231 : 1237);
	result = prime * result + ((vencedor_jogo == null) ? 0 : vencedor_jogo.hashCode());
	result = prime * result + (wo ? 1231 : 1237);
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
	Jogo other = (Jogo) obj;
	if (cancelado != other.cancelado)
	    return false;
	if (data_realizacao == null) {
	    if (other.data_realizacao != null)
		return false;
	} else if (!data_realizacao.equals(other.data_realizacao))
	    return false;
	if (decisivo != other.decisivo)
	    return false;
	if (equipe_mandante == null) {
	    if (other.equipe_mandante != null)
		return false;
	} else if (!equipe_mandante.equals(other.equipe_mandante))
	    return false;
	if (equipe_mandante_id != other.equipe_mandante_id)
	    return false;
	if (equipe_visitante == null) {
	    if (other.equipe_visitante != null)
		return false;
	} else if (!equipe_visitante.equals(other.equipe_visitante))
	    return false;
	if (equipe_visitante_id != other.equipe_visitante_id)
	    return false;
	if (escalacao_mandante_id != other.escalacao_mandante_id)
	    return false;
	if (escalacao_visitante_id != other.escalacao_visitante_id)
	    return false;
	if (fase == null) {
	    if (other.fase != null)
		return false;
	} else if (!fase.equals(other.fase))
	    return false;
	if (fase_id != other.fase_id)
	    return false;
	if (hora_realizacao == null) {
	    if (other.hora_realizacao != null)
		return false;
	} else if (!hora_realizacao.equals(other.hora_realizacao))
	    return false;
	if (jogo_id != other.jogo_id)
	    return false;
	if (placar_oficial_mandante != other.placar_oficial_mandante)
	    return false;
	if (placar_oficial_visitante != other.placar_oficial_visitante)
	    return false;
	if (placar_penaltis_mandante == null) {
	    if (other.placar_penaltis_mandante != null)
		return false;
	} else if (!placar_penaltis_mandante.equals(other.placar_penaltis_mandante))
	    return false;
	if (placar_penaltis_visitante == null) {
	    if (other.placar_penaltis_visitante != null)
		return false;
	} else if (!placar_penaltis_visitante.equals(other.placar_penaltis_visitante))
	    return false;
	if (rodada != other.rodada)
	    return false;
	if (sede == null) {
	    if (other.sede != null)
		return false;
	} else if (!sede.equals(other.sede))
	    return false;
	if (sede_id != other.sede_id)
	    return false;
	if (suspenso != other.suspenso)
	    return false;
	if (vencedor_jogo == null) {
	    if (other.vencedor_jogo != null)
		return false;
	} else if (!vencedor_jogo.equals(other.vencedor_jogo))
	    return false;
	if (wo != other.wo)
	    return false;
	return true;
    }

    @Override
    public String toString() {
	return "Jogo [jogo_id=" + jogo_id + ", rodada=" + rodada + ", vencedor_jogo=" + vencedor_jogo + ", equipe_mandante_id="
		+ equipe_mandante_id + ", equipe_visitante_id=" + equipe_visitante_id + ", escalacao_mandante_id=" + escalacao_mandante_id
		+ ", escalacao_visitante_id=" + escalacao_visitante_id + ", cancelado=" + cancelado + ", suspenso=" + suspenso + ", wo="
		+ wo + ", decisivo=" + decisivo + ", placar_penaltis_mandante=" + placar_penaltis_mandante + ", placar_penaltis_visitante="
		+ placar_penaltis_visitante + ", fase_id=" + fase_id + ", fase=" + fase + ", equipe_visitante=" + equipe_visitante
		+ ", equipe_mandante=" + equipe_mandante + ", sede_id=" + sede_id + ", sede=" + sede + ", placar_oficial_visitante="
		+ placar_oficial_visitante + ", placar_oficial_mandante=" + placar_oficial_mandante + ", hora_realizacao=" + hora_realizacao
		+ ", data_realizacao=" + data_realizacao + "]";
    }

}

package css_evento_rifa_dto;

public class eventoDTO {
	int codigo_evento, entrada_evento, ativo_evento;
	String nome_evento;
	
	public int getCodigo_evento() {
		return codigo_evento;
	}
	public void setCodigo_evento(int codigo_evento) {
		this.codigo_evento = codigo_evento;
	}
	public int getEntrada_evento() {
		return entrada_evento;
	}
	public void setEntrada_evento(int entrada_evento) {
		this.entrada_evento = entrada_evento;
	}
	public int getAtivo_evento() {
		return ativo_evento;
	}
	public void setAtivo_evento(int ativo_evento) {
		this.ativo_evento = ativo_evento;
	}
	public String getNome_evento() {
		return nome_evento;
	}
	public void setNome_evento(String nome_evento) {
		this.nome_evento = nome_evento;
	}
}

package css_evento_rifa_dto;

public class rifaDTO {  
    int codigo_rifa, codigo_evento, cpf_cliente,quantidade_bilhete,ativo_rifa;
	String telefone_cliente, nome_cliente, nome_funcionario,data_venda;
	
	public String getData_venda() {
		return data_venda;
	}
	public void setData_venda(String string) {
		this.data_venda = string;
	}
	public int getQuantidade_bilhete() {
		return quantidade_bilhete;
	}
	public void setQuantidade_bilhete(int quantidade_bilhete) {
		this.quantidade_bilhete = quantidade_bilhete;
	}
	public int getCodigo_rifa() {
		return codigo_rifa;
	}
	public void setCodigo_rifa(int codigo_rifa) {
		this.codigo_rifa = codigo_rifa;
	}
	public int getCodigo_evento() {
		return codigo_evento;
	}
	public void setCodigo_evento(int codigo_evento) {
		this.codigo_evento = codigo_evento;
	}
	public int getCpf_cliente() {
		return cpf_cliente;
	}
	public void setCpf_cliente(int cpf_cliente) {
		this.cpf_cliente = cpf_cliente;
	}
	public String getTelefone_cliente() {
		return telefone_cliente;
	}
	public void setTelefone_cliente(String telefone_cliente) {
		this.telefone_cliente = telefone_cliente;
	}
	public String getNome_cliente() {
		return nome_cliente;
	}
	public void setNome_cliente(String nome_cliente) {
		this.nome_cliente = nome_cliente;
	}
	public String getNome_funcionario() {
		return nome_funcionario;
	}
	public void setNome_funcionario(String nome_funcionario) {
		this.nome_funcionario = nome_funcionario;
	}
	public int getAtivo_rifa() {
		return ativo_rifa;
	}
	public void setAtivo_rifa(int ativo_rifa) {
		this.ativo_rifa = ativo_rifa;
	}
}

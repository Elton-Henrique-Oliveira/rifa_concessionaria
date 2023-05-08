package css_evento_rifa_dto;

public class funcionarioDTO {
	int codigo_funcionario, cpf_funcionario;
	String nome_funcionario, telefone_funcionario;
		
	public int getCodigo_funcionario() {
		return codigo_funcionario;
	}
	public void setCodigo_funcionario(int codigo_funcionario) {
		this.codigo_funcionario = codigo_funcionario;
	}
	public int getCpf_funcionario() {
		return cpf_funcionario;
	}
	public void setCpf_funcionario(int cpf_funcionario) {
		this.cpf_funcionario = cpf_funcionario;
	}
	public String getNome_funcionario() {
		return nome_funcionario;
	}
	public void setNome_funcionario(String nome_funcionario) {
		this.nome_funcionario = nome_funcionario;
	}
	public String getTelefone_funcionario() {
		return telefone_funcionario;
	}
	public void setTelefone_funcionario(String telefone_funcionario) {
		this.telefone_funcionario = telefone_funcionario;
	}
}

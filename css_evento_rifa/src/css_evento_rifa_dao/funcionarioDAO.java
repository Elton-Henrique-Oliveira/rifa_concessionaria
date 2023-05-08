package css_evento_rifa_dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class funcionarioDAO {
	Connection conn;
	PreparedStatement pstm;
	ResultSet rs;

	private String sql = "";
	
	public ResultSet buscaFuncionarios(int cpf_funcionario, String nome_funcionario, int codigo_funcionario) {
		
		String sql_aux = "";
		
		sql = "select *";
		sql += " from tb_funcionario";
		if(cpf_funcionario > 0 || nome_funcionario.trim().equals("") == false || codigo_funcionario > 0) {
			sql += " where";
		}
		if(cpf_funcionario > 0) {
			if(sql_aux.trim().equals("") == false) {
				sql_aux += " and";
			}
			sql_aux += " cpffuncionario = " + cpf_funcionario;
		}
		if(codigo_funcionario > 0) {
			if(sql_aux.trim().equals("") == false) {
				sql_aux += " and";
			}
			sql_aux += " idfuncionario = " + codigo_funcionario;
		}
		if(nome_funcionario.trim().equals("") == false) {
			if(sql_aux.trim().equals("") == false) {
				sql_aux += " and";
			}
			sql_aux += " nomefuncionario = "+nome_funcionario;
		}
		sql += sql_aux;
		sql += " order by idfuncionario";
		
		conn = new conexaoDAO().conectaBD();
		try {

			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			
		} catch (SQLException error) {
			JOptionPane.showMessageDialog(null, sql + "funcionarioPesquisa" + error);
		}
		return rs;
	}
	
	public void fechaConexao() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

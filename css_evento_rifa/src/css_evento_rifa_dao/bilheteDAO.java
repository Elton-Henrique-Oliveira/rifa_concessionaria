package css_evento_rifa_dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class bilheteDAO {
	Connection conn;
	PreparedStatement pstm;
	ResultSet rs;

	private String sql = "";

	public void criarBilhete(int codigo_rifa, int cpf_cliente, int quantidade_bilhete) {

		sql = "";

		conn = new conexaoDAO().conectaBD();

		for (int i = 0; i < quantidade_bilhete; i++) {
			sql = "insert into tb_bilhete (idrifa,cpfcliente)";
			sql += " values (" + codigo_rifa + "," + cpf_cliente + ");\n";

			try {
				pstm = conn.prepareStatement(sql);
				pstm.execute();
				pstm.close();

			} catch (SQLException error) {
				JOptionPane.showMessageDialog(null, sql + " bilhete cadastro" + error);
			}
		}

		fechaConexao();
	}
	
	public ResultSet buscarBilhetes(String cpf_cliente, String codigo_rifa) {
		String sql_aux = "";

		sql  = "select tb_bilhete.idbilhete as bilhete,tb_bilhete.idrifa as rifa,tb_bilhete.cpfcliente as cpf,tb_rifa.nomefuncionario as funcionario,tb_rifa.nomecliente as cliente,tb_rifa.telefonecliente as telefone,tb_rifa.datavenda as data";
		sql += " from tb_bilhete";
		sql += " inner join tb_rifa on tb_rifa.idrifa = tb_bilhete.idrifa";
		
		if (cpf_cliente.trim().equals("") == false || codigo_rifa.trim().equals("") == false) {
			sql += " where";
		}
		if (cpf_cliente.trim().equals("") == false) {
			if (sql_aux.trim().equals("") == false) {
				sql_aux += " and";
			}
			sql_aux += " tb_rifa.cpfcliente	 = " + cpf_cliente;
		}
		if (codigo_rifa.trim().equals("") == false) {
			if (sql_aux.trim().equals("") == false) {
				sql_aux += " and";
			}
			sql_aux += " tb_rifa.idrifa = " + codigo_rifa;
		}
		sql += sql_aux;
		sql += " order by tb_bilhete.idbilhete";

		conn = new conexaoDAO().conectaBD();
		try {

			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();

		} catch (SQLException error) {
			JOptionPane.showMessageDialog(null, sql + "rifa buscar todos" + error);
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

package css_evento_rifa_dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class eventoDAO {
	Connection conn;
	PreparedStatement pstm;
	ResultSet rs;

	private String sql = "";
	
	public ResultSet buscaEvento() {
		
		sql  = "select *";
		sql += " from tb_evento";
		sql += " where ativoevento = 0";

		conn = new conexaoDAO().conectaBD();
		try {

			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			
		} catch (SQLException error) {
			JOptionPane.showMessageDialog(null, sql + "eventosPesquisa" + error);
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

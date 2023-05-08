package css_evento_rifa_dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import css_evento_rifa_dto.rifaDTO;

public class rifaDAO {
	Connection conn;
	PreparedStatement pstm;
	ResultSet rs;

	private String sql = "";

	public void cadastrarBilhete(rifaDTO objbilheteDTO) {

		sql = "insert into tb_rifa (idevento,cpfcliente,telefonecliente,nomecliente,nomefuncionario,quantiabilhete,ativorifa,datavenda)";
		sql += " values (" + objbilheteDTO.getCodigo_evento() + "";
		sql += "," + objbilheteDTO.getCpf_cliente() + "";
		sql += ",'" + objbilheteDTO.getTelefone_cliente() + "'";
		sql += ",'" + objbilheteDTO.getNome_cliente() + "'";
		sql += ",'" + objbilheteDTO.getNome_funcionario() + "'";
		sql += "," + objbilheteDTO.getQuantidade_bilhete() + "";
		sql += "," + objbilheteDTO.getAtivo_rifa() + "";
		sql += ",'" + objbilheteDTO.getData_venda() + "');";

		System.out.println(sql);
		conn = new conexaoDAO().conectaBD();
		try {

			pstm = conn.prepareStatement(sql);
			pstm.execute();
			pstm.close();

		} catch (SQLException error) {
			JOptionPane.showMessageDialog(null, sql + " bilhete cadastro" + error);
		}

		fechaConexao();

	}

	public ResultSet buscarRifas(String codigo_evento, String cpf_cliente, String codigo_rifa) {
		String sql_aux = "";

		sql  = "select tb_rifa.idrifa as rifa,tb_rifa.quantiabilhete as quantidade,tb_evento.nomeevento as evento,tb_rifa.nomefuncionario as funcionario,tb_rifa.nomecliente as cliente,tb_rifa.telefonecliente as telefone,tb_rifa.cpfcliente as cpf,tb_rifa.datavenda as data";
		sql += " from tb_rifa";
		sql += " inner join tb_evento on tb_evento.idevento = tb_rifa.idevento";
		if (cpf_cliente.trim().equals("") == false || codigo_evento.trim().equals("") == false || codigo_rifa.trim().equals("") == false) {
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
		if (codigo_evento.trim().equals("") == false) {
			if (sql_aux.trim().equals("") == false) {
				sql_aux += " and";
			}
			sql_aux += " tb_rifa.idevento = " + codigo_evento;
		}
		sql += sql_aux;
		sql += " order by tb_rifa.idrifa";

		conn = new conexaoDAO().conectaBD();
		try {

			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();

		} catch (SQLException error) {
			JOptionPane.showMessageDialog(null, sql + "rifa buscar todos" + error);
		}

		return rs;
	}

	public ResultSet buscarUltimaRifa(int indicador) {
		sql = "select *";
		sql += " from tb_rifa";
		if (indicador == 1) {
			sql += " where ativorifa = 0";
		}
		sql += " order by idrifa desc";

		conn = new conexaoDAO().conectaBD();
		try {

			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();

		} catch (SQLException error) {
			JOptionPane.showMessageDialog(null, sql + "rifa buscar" + error);
		}

		return rs;
	}

	public void alteraFeito(int codigo_rifa) {
		sql = "update tb_rifa set ativorifa = 1 where idrifa = " + codigo_rifa;

		conn = new conexaoDAO().conectaBD();
		try {

			pstm = conn.prepareStatement(sql);
			pstm.execute();
			pstm.close();

		} catch (SQLException error) {
			JOptionPane.showMessageDialog(null, sql + " bilhete cadastro" + error);
		}

		fechaConexao();
	}

	public void fechaConexao() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

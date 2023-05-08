package css_evento_rifa_dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class conexaoDAO {

	@SuppressWarnings("resource")
	public Connection conectaBD() {
		Connection conn = null;
		String complemento = "";

		complemento = pegaUsuarioSenha();

		try {
			String url = "jdbc:mysql://sql795.main-hosting.eu/u400453406_banco_esperime?" + complemento;
			conn = DriverManager.getConnection(url);
		} catch (SQLException error) {
			JOptionPane.showMessageDialog(null, error.getMessage());
		}
		return conn;
	}

	private String pegaUsuarioSenha() {
		String retorno = "";
		String usuario = "";
		String senha = "";
		String curDir = System.getProperty("user.dir");
		int primeiro = 0;

		File arquivo = new File(curDir + "/informacoes.txt");

		try {
			try (FileReader fr = new FileReader(arquivo)) {
				BufferedReader br = new BufferedReader(fr);

				try {
					String linha = br.readLine();

					while (linha != null) {
						if (primeiro == 0) {
							usuario = linha;
							primeiro = 1;
						} else {
							senha = linha;
						}
						linha = br.readLine();
					}
					;
					fr.close();

				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				throw e;
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		retorno = "user=" + usuario + "&password=" + senha;
		
		return retorno;
	}

}

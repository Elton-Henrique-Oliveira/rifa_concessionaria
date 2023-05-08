package css_evento_rifa_aplicacao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import css_evento_rifa_dao.rifaDAO;
import css_evento_rifa_dao.bilheteDAO;
import css_evento_rifa_dao.eventoDAO;
import css_evento_rifa_dao.funcionarioDAO;
import css_evento_rifa_dto.rifaDTO;
import css_evento_rifa_modelos.TableModelBilhetes;
import css_evento_rifa_modelos.TableModelRifas;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class evento_aplicacao {

	private JFrame frmEventoRifaCss;
	private JTextField campo_nome;
	private JTextField campo_telefone;
	private JTextField campo_cpf;
	private JTextField campo_quantidade;
	private JLayeredPane layeredPane_1;
	private JLabel lbl_mensagem_quantidade;
	private JButton btnNewButton;
	private JLabel lbl_mensagem_cpf;
	private JLabel lbl_mensagem_telefone;
	private JLabel lbl_mensagem_nome;
	private JLayeredPane layeredPane;
	private JTabbedPane tabbedPane;
	private JLabel lbl_mensagem_funcionario;
	private JComboBox<String> combo_funcionario;
	private JButton btnCalcular;
	private JLabel lblNewLabel;
	private JLabel campo_valor;
	private JLabel lbl_custo;
	private JLabel campo_valor_rifa;
	private JButton btnReplicar;
	private JLabel lbl_ultima_quantidade;
	private JLabel lbl_ultima_cpf;
	private JLabel lbl_ultima_telefone;
	private JLabel lbl_ultima_nome;
	private JLabel lbl_ultima_funcionario;
	private JLabel lbl_mensagem_quantidade_1;
	private JLabel lbl_mensagem_cpf_1;
	private JLabel lbl_mensagem_telefone_1;
	private JLabel lbl_mensagem_funcionario_1;
	private JLabel lbl_mensagem_nome_1;
	private JLabel lbl_custo_1;
	private JPanel panel;
	private JButton btnDistribuir;
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	private JLabel lbl_mensagem_data;
	private JLabel lbl_ultima_data;
	private JLabel lbl_evento_aba2;
	private JTextField campo_aba2_evento;
	private JTable tabela_rifa;
	private JButton botao_consultar_rifa;
	private JScrollPane scrollPane;
	private JPanel painel_consulta_rifas;
	private JTextField campo_aba2_cpf;
	private JTextField campo_aba2_codigo;
	private JPanel panel_1_1_1;
	private JLayeredPane layeredPane_3;
	private JLabel lbl_codigo_aba2;
	private JLabel lbl_cpf_aba2;
	private JTextField campo_aba3_cpf;
	private JTextField campo_aba3_rifa;
	private JTable tabela_bilhetes;
	private JScrollPane scrollPane_1;
	private JLabel lbl_cpf_aba2_1;
	private JLabel lbl_codigo_aba2_1;
	private JButton botao_consultar_aba3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					evento_aplicacao window = new evento_aplicacao();
					window.frmEventoRifaCss.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @throws SQLException
	 */
	public evento_aplicacao() throws SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws SQLException
	 */
	private void initialize() throws SQLException {
		frmEventoRifaCss = new JFrame();
		frmEventoRifaCss.setTitle("Evento de rifa");
		frmEventoRifaCss.setBounds(100, 100, 1189, 484);
		frmEventoRifaCss.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frmEventoRifaCss.getContentPane().add(tabbedPane, BorderLayout.CENTER);

		layeredPane = new JLayeredPane();
		tabbedPane.addTab("Registro", null, layeredPane, null);

		lbl_mensagem_nome = new JLabel("Nome");
		lbl_mensagem_nome.setFont(new Font("Arial", Font.BOLD, 15));
		lbl_mensagem_nome.setBounds(58, 130, 104, 35);
		layeredPane.add(lbl_mensagem_nome);

		lbl_mensagem_telefone = new JLabel("Telefone");
		lbl_mensagem_telefone.setFont(new Font("Arial", Font.BOLD, 15));
		lbl_mensagem_telefone.setBounds(58, 176, 104, 35);
		layeredPane.add(lbl_mensagem_telefone);

		lbl_mensagem_cpf = new JLabel("CPF");
		lbl_mensagem_cpf.setFont(new Font("Arial", Font.BOLD, 15));
		lbl_mensagem_cpf.setBounds(58, 222, 104, 35);
		layeredPane.add(lbl_mensagem_cpf);

		campo_nome = new JTextField();
		campo_nome.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));
		campo_nome.setBounds(165, 130, 322, 35);
		layeredPane.add(campo_nome);
		campo_nome.setColumns(10);

		campo_telefone = new JTextField();
		campo_telefone.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));
		campo_telefone.setColumns(10);
		campo_telefone.setBounds(165, 176, 125, 35);
		layeredPane.add(campo_telefone);

		campo_cpf = new JTextField();
		campo_cpf.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));
		campo_cpf.setColumns(10);
		campo_cpf.setBounds(165, 222, 125, 35);
		layeredPane.add(campo_cpf);

		btnNewButton = new JButton("Vender");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int opcao = -1;

					Object[] options = { "Confirmar", "Cancelar" };
					opcao = JOptionPane.showOptionDialog(null, "Você deseja realmente confirmar a venda?", "Informação",
							JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
					
					if (opcao == 0) {
						registrarVenda();
					}

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));
		btnNewButton.setBounds(58, 342, 195, 35);
		layeredPane.add(btnNewButton);

		campo_quantidade = new JTextField();
		campo_quantidade.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));
		campo_quantidade.setColumns(10);
		campo_quantidade.setBounds(165, 268, 125, 35);
		layeredPane.add(campo_quantidade);

		lbl_mensagem_quantidade = new JLabel("Quantidade");
		lbl_mensagem_quantidade.setFont(new Font("Arial", Font.BOLD, 15));
		lbl_mensagem_quantidade.setBounds(58, 268, 104, 35);
		layeredPane.add(lbl_mensagem_quantidade);

		lbl_mensagem_funcionario = new JLabel("Funcionario");
		lbl_mensagem_funcionario.setFont(new Font("Arial", Font.BOLD, 15));
		lbl_mensagem_funcionario.setBounds(58, 84, 104, 35);
		layeredPane.add(lbl_mensagem_funcionario);

		combo_funcionario = new JComboBox<String>();
		combo_funcionario.setBounds(165, 84, 322, 35);
		layeredPane.add(combo_funcionario);

		btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculaValor();
			}
		});
		btnCalcular.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));
		btnCalcular.setBounds(292, 342, 195, 35);
		layeredPane.add(btnCalcular);

		lblNewLabel = new JLabel("Valor $");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel.setBounds(338, 176, 57, 35);
		layeredPane.add(lblNewLabel);

		campo_valor = new JLabel("");
		campo_valor.setFont(new Font("Arial", Font.BOLD, 15));
		campo_valor.setBounds(405, 176, 82, 35);
		layeredPane.add(campo_valor);

		lbl_custo = new JLabel("Bilhete $");
		lbl_custo.setFont(new Font("Arial", Font.BOLD, 15));
		lbl_custo.setBounds(58, 21, 104, 35);
		layeredPane.add(lbl_custo);

		campo_valor_rifa = new JLabel("");
		campo_valor_rifa.setFont(new Font("Arial", Font.BOLD, 15));
		campo_valor_rifa.setBounds(166, 21, 104, 35);
		layeredPane.add(campo_valor_rifa);

		panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(628, 11, 530, 395);
		layeredPane.add(panel);
		panel.setLayout(null);

		lbl_custo_1 = new JLabel("\u00DAltima compra");
		lbl_custo_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_custo_1.setFont(new Font("Arial", Font.BOLD, 15));
		lbl_custo_1.setBounds(27, 11, 493, 35);
		panel.add(lbl_custo_1);

		lbl_mensagem_nome_1 = new JLabel("Nome");
		lbl_mensagem_nome_1.setFont(new Font("Arial", Font.BOLD, 15));
		lbl_mensagem_nome_1.setBounds(57, 103, 104, 35);
		panel.add(lbl_mensagem_nome_1);

		lbl_mensagem_funcionario_1 = new JLabel("Funcionario");
		lbl_mensagem_funcionario_1.setFont(new Font("Arial", Font.BOLD, 15));
		lbl_mensagem_funcionario_1.setBounds(57, 57, 104, 35);
		panel.add(lbl_mensagem_funcionario_1);

		lbl_mensagem_telefone_1 = new JLabel("Telefone");
		lbl_mensagem_telefone_1.setFont(new Font("Arial", Font.BOLD, 15));
		lbl_mensagem_telefone_1.setBounds(57, 149, 104, 35);
		panel.add(lbl_mensagem_telefone_1);

		lbl_mensagem_cpf_1 = new JLabel("CPF");
		lbl_mensagem_cpf_1.setFont(new Font("Arial", Font.BOLD, 15));
		lbl_mensagem_cpf_1.setBounds(57, 195, 104, 35);
		panel.add(lbl_mensagem_cpf_1);

		lbl_mensagem_quantidade_1 = new JLabel("Quantidade");
		lbl_mensagem_quantidade_1.setFont(new Font("Arial", Font.BOLD, 15));
		lbl_mensagem_quantidade_1.setBounds(57, 241, 104, 35);
		panel.add(lbl_mensagem_quantidade_1);

		lbl_ultima_funcionario = new JLabel("");
		lbl_ultima_funcionario.setFont(new Font("Arial", Font.BOLD, 15));
		lbl_ultima_funcionario.setBounds(181, 57, 339, 35);
		panel.add(lbl_ultima_funcionario);

		lbl_ultima_nome = new JLabel("");
		lbl_ultima_nome.setFont(new Font("Arial", Font.BOLD, 15));
		lbl_ultima_nome.setBounds(181, 103, 339, 35);
		panel.add(lbl_ultima_nome);

		lbl_ultima_telefone = new JLabel("");
		lbl_ultima_telefone.setFont(new Font("Arial", Font.BOLD, 15));
		lbl_ultima_telefone.setBounds(181, 149, 339, 35);
		panel.add(lbl_ultima_telefone);

		lbl_ultima_cpf = new JLabel("");
		lbl_ultima_cpf.setFont(new Font("Arial", Font.BOLD, 15));
		lbl_ultima_cpf.setBounds(181, 195, 339, 35);
		panel.add(lbl_ultima_cpf);

		lbl_ultima_quantidade = new JLabel("");
		lbl_ultima_quantidade.setFont(new Font("Arial", Font.BOLD, 15));
		lbl_ultima_quantidade.setBounds(181, 241, 98, 35);
		panel.add(lbl_ultima_quantidade);

		btnReplicar = new JButton("Replicar");
		btnReplicar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				replicarUltimaVenda();
			}
		});
		btnReplicar.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));
		btnReplicar.setBounds(57, 303, 204, 35);
		panel.add(btnReplicar);

		btnDistribuir = new JButton("Distribuir");
		btnDistribuir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					distribuirBilhete();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnDistribuir.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));
		btnDistribuir.setBounds(285, 303, 204, 35);
		panel.add(btnDistribuir);

		lbl_mensagem_data = new JLabel("Data");
		lbl_mensagem_data.setFont(new Font("Arial", Font.BOLD, 15));
		lbl_mensagem_data.setBounds(289, 241, 41, 35);
		panel.add(lbl_mensagem_data);

		lbl_ultima_data = new JLabel("");
		lbl_ultima_data.setFont(new Font("Arial", Font.BOLD, 15));
		lbl_ultima_data.setBounds(340, 241, 180, 35);
		panel.add(lbl_ultima_data);

		layeredPane_1 = new JLayeredPane();
		tabbedPane.addTab("Consulta Rifas", null, layeredPane_1, null);

		painel_consulta_rifas = new JPanel();
		painel_consulta_rifas.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Rifa",
				TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.text));
		painel_consulta_rifas.setBackground(SystemColor.activeCaption);
		painel_consulta_rifas.setBounds(0, 0, 1168, 417);
		layeredPane_1.add(painel_consulta_rifas);
		painel_consulta_rifas.setLayout(null);

		lbl_evento_aba2 = new JLabel("Evento");
		lbl_evento_aba2.setFont(new Font("Arial", Font.BOLD, 15));
		lbl_evento_aba2.setBounds(10, 22, 62, 31);
		painel_consulta_rifas.add(lbl_evento_aba2);

		campo_aba2_evento = new JTextField();
		campo_aba2_evento.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					try {
						carregaTabelaRifa();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		campo_aba2_evento.setFont(new Font("Arial", Font.BOLD, 15));
		campo_aba2_evento.setBounds(76, 22, 107, 31);
		painel_consulta_rifas.add(campo_aba2_evento);
		campo_aba2_evento.setColumns(10);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 79, 1148, 327);
		painel_consulta_rifas.add(scrollPane);

		tabela_rifa = new JTable();
		scrollPane.setViewportView(tabela_rifa);
		tabela_rifa.setFont(new Font("Arial", Font.BOLD, 14));

		botao_consultar_rifa = new JButton("Consultar");
		botao_consultar_rifa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					carregaTabelaRifa();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		botao_consultar_rifa.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));
		botao_consultar_rifa.setBounds(788, 21, 370, 31);
		painel_consulta_rifas.add(botao_consultar_rifa);

		campo_aba2_cpf = new JTextField();
		campo_aba2_cpf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					try {
						carregaTabelaRifa();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		campo_aba2_cpf.setFont(new Font("Arial", Font.BOLD, 15));
		campo_aba2_cpf.setColumns(10);
		campo_aba2_cpf.setBounds(296, 22, 107, 31);
		painel_consulta_rifas.add(campo_aba2_cpf);

		lbl_cpf_aba2 = new JLabel("CPF");
		lbl_cpf_aba2.setFont(new Font("Arial", Font.BOLD, 15));
		lbl_cpf_aba2.setBounds(230, 22, 62, 31);
		painel_consulta_rifas.add(lbl_cpf_aba2);

		lbl_codigo_aba2 = new JLabel("Rifa");
		lbl_codigo_aba2.setFont(new Font("Arial", Font.BOLD, 15));
		lbl_codigo_aba2.setBounds(453, 22, 62, 31);
		painel_consulta_rifas.add(lbl_codigo_aba2);

		campo_aba2_codigo = new JTextField();
		campo_aba2_codigo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					try {
						carregaTabelaRifa();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		campo_aba2_codigo.setFont(new Font("Arial", Font.BOLD, 15));
		campo_aba2_codigo.setColumns(10);
		campo_aba2_codigo.setBounds(519, 22, 107, 31);
		painel_consulta_rifas.add(campo_aba2_codigo);

		layeredPane_3 = new JLayeredPane();
		tabbedPane.addTab("Consulta Bilhetes", null, layeredPane_3, null);

		panel_1_1_1 = new JPanel();
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setBorder(
				new TitledBorder(null, "Bilhetes", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.text));
		panel_1_1_1.setBackground(SystemColor.activeCaption);
		panel_1_1_1.setBounds(0, 0, 1168, 417);
		layeredPane_3.add(panel_1_1_1);

		botao_consultar_aba3 = new JButton("Consultar");
		botao_consultar_aba3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					carregaTabelaBilhetes();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		botao_consultar_aba3.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));
		botao_consultar_aba3.setBounds(788, 21, 370, 31);
		panel_1_1_1.add(botao_consultar_aba3);

		campo_aba3_cpf = new JTextField();
		campo_aba3_cpf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					try {
						carregaTabelaBilhetes();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		campo_aba3_cpf.setFont(new Font("Arial", Font.BOLD, 15));
		campo_aba3_cpf.setColumns(10);
		campo_aba3_cpf.setBounds(76, 21, 107, 31);
		panel_1_1_1.add(campo_aba3_cpf);

		lbl_cpf_aba2_1 = new JLabel("CPF");
		lbl_cpf_aba2_1.setFont(new Font("Arial", Font.BOLD, 15));
		lbl_cpf_aba2_1.setBounds(10, 21, 62, 31);
		panel_1_1_1.add(lbl_cpf_aba2_1);

		lbl_codigo_aba2_1 = new JLabel("Rifa");
		lbl_codigo_aba2_1.setFont(new Font("Arial", Font.BOLD, 15));
		lbl_codigo_aba2_1.setBounds(233, 21, 62, 31);
		panel_1_1_1.add(lbl_codigo_aba2_1);

		campo_aba3_rifa = new JTextField();
		campo_aba3_rifa.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					try {
						carregaTabelaBilhetes();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		campo_aba3_rifa.setFont(new Font("Arial", Font.BOLD, 15));
		campo_aba3_rifa.setColumns(10);
		campo_aba3_rifa.setBounds(299, 21, 107, 31);
		panel_1_1_1.add(campo_aba3_rifa);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 86, 1148, 320);
		panel_1_1_1.add(scrollPane_1);

		tabela_bilhetes = new JTable();
		scrollPane_1.setViewportView(tabela_bilhetes);
		tabela_bilhetes.setFont(new Font("Arial", Font.BOLD, 14));

		consultaFuncionarios();
		buscarPrecoEvento();
		ultimaCompra();
	}

	@SuppressWarnings("static-access")
	private void carregaTabelaRifa() throws SQLException {
		ArrayList<Object> dados = new ArrayList<>();
		String[] colunas = new String[] { "ID", "Evento", "Qtd", "Nome Funcionario", "Nome", "Telefone", "CPF",
				"Data" };
		String mensagemErro = "";
		String codigo_evento = "", codigo_rifa = "", cpf = "";
		ResultSet rs = null;

		if (campo_aba2_codigo.getText().matches("\\d+") == false
				&& campo_aba2_codigo.getText().trim().equals("") == false) {
			mensagemErro += "\nO campo de rifa só aceita valores numericos!";
		}
		if (campo_aba2_cpf.getText().matches("\\d+") == false && campo_aba2_cpf.getText().trim().equals("") == false) {
			mensagemErro += "\nO campo de cpf só aceita valores numericos!";
		}
		if (campo_aba2_evento.getText().matches("\\d+") == false
				&& campo_aba2_evento.getText().trim().equals("") == false) {
			mensagemErro += "\nO campo de evento só aceita valores numericos!";
		}

		if (mensagemErro.trim().equals("") == true) {
			codigo_evento = campo_aba2_evento.getText();
			cpf = campo_aba2_cpf.getText();
			codigo_rifa = campo_aba2_codigo.getText();

			rifaDAO objrifaDAO = new rifaDAO();
			rs = objrifaDAO.buscarRifas(codigo_evento, cpf, codigo_rifa);
			while (rs.next() == true) {
				dados.add(new Object[] { rs.getInt("rifa"), rs.getString("evento"), rs.getInt("quantidade"),
						rs.getString("funcionario"), rs.getString("cliente"), rs.getString("telefone"),
						rs.getString("cpf"), rs.getString("data") });
			}
			rs.close();
		} else {
			JOptionPane.showMessageDialog(null, mensagemErro);
		}

		try {

			TableModelRifas modelo = new TableModelRifas(dados, colunas);
			tabela_rifa.setModel(modelo);
			tabela_rifa.getColumnModel().getColumn(0).setPreferredWidth(50);
			tabela_rifa.getColumnModel().getColumn(0).setResizable(false);
			tabela_rifa.getColumnModel().getColumn(1).setPreferredWidth(183);
			tabela_rifa.getColumnModel().getColumn(1).setResizable(false);
			tabela_rifa.getColumnModel().getColumn(2).setPreferredWidth(50);
			tabela_rifa.getColumnModel().getColumn(2).setResizable(false);
			tabela_rifa.getColumnModel().getColumn(3).setPreferredWidth(200);
			tabela_rifa.getColumnModel().getColumn(3).setResizable(false);
			tabela_rifa.getColumnModel().getColumn(4).setPreferredWidth(200);
			tabela_rifa.getColumnModel().getColumn(4).setResizable(false);
			tabela_rifa.getColumnModel().getColumn(5).setPreferredWidth(203);
			tabela_rifa.getColumnModel().getColumn(5).setResizable(false);
			tabela_rifa.getColumnModel().getColumn(6).setPreferredWidth(100);
			tabela_rifa.getColumnModel().getColumn(6).setResizable(false);
			tabela_rifa.getColumnModel().getColumn(7).setPreferredWidth(159);
			tabela_rifa.getColumnModel().getColumn(7).setResizable(false);
			tabela_rifa.getTableHeader().setReorderingAllowed(false);
			tabela_rifa.setAutoResizeMode(tabela_rifa.AUTO_RESIZE_OFF);
			tabela_rifa.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		} catch (

		Exception error) {
			JOptionPane.showMessageDialog(null, "Erro ao preencher tabela" + error);
		}
	}

	@SuppressWarnings("static-access")
	private void carregaTabelaBilhetes() throws SQLException {
		ArrayList<Object> dados = new ArrayList<>();
		String[] colunas = new String[] { "Bilhete", "Rifa", "CPF", "Nome cliente", "Nome Funcionario", "Telefone",
				"Data" };
		String mensagemErro = "";
		String codigo_rifa = "", cpf = "";
		ResultSet rs = null;

		if (campo_aba3_cpf.getText().matches("\\d+") == false && campo_aba3_cpf.getText().trim().equals("") == false) {
			mensagemErro += "\nO campo de cpf só aceita valores numericos!";
		}
		if (campo_aba3_rifa.getText().matches("\\d+") == false
				&& campo_aba3_rifa.getText().trim().equals("") == false) {
			mensagemErro += "\nO campo de rifa só aceita valores numericos!";
		}

		if (mensagemErro.trim().equals("") == true) {
			cpf = campo_aba3_cpf.getText();
			codigo_rifa = campo_aba3_rifa.getText();

			bilheteDAO objbilheteDAO = new bilheteDAO();
			rs = objbilheteDAO.buscarBilhetes(cpf, codigo_rifa);
			while (rs.next() == true) {
				dados.add(new Object[] { rs.getInt("bilhete"), rs.getInt("rifa"), rs.getInt("cpf"),
						rs.getString("funcionario"), rs.getString("cliente"), rs.getString("telefone"),
						rs.getString("data") });
			}
			rs.close();
		} else {
			JOptionPane.showMessageDialog(null, mensagemErro);
		}

		try {

			TableModelBilhetes modelo = new TableModelBilhetes(dados, colunas);
			tabela_bilhetes.setModel(modelo);
			tabela_bilhetes.getColumnModel().getColumn(0).setPreferredWidth(50);
			tabela_bilhetes.getColumnModel().getColumn(0).setResizable(false);
			tabela_bilhetes.getColumnModel().getColumn(1).setPreferredWidth(183);
			tabela_bilhetes.getColumnModel().getColumn(1).setResizable(false);
			tabela_bilhetes.getColumnModel().getColumn(2).setPreferredWidth(50);
			tabela_bilhetes.getColumnModel().getColumn(2).setResizable(false);
			tabela_bilhetes.getColumnModel().getColumn(3).setPreferredWidth(293);
			tabela_bilhetes.getColumnModel().getColumn(3).setResizable(false);
			tabela_bilhetes.getColumnModel().getColumn(4).setPreferredWidth(303);
			tabela_bilhetes.getColumnModel().getColumn(4).setResizable(false);
			tabela_bilhetes.getColumnModel().getColumn(5).setPreferredWidth(100);
			tabela_bilhetes.getColumnModel().getColumn(5).setResizable(false);
			tabela_bilhetes.getColumnModel().getColumn(6).setPreferredWidth(150);
			tabela_bilhetes.getColumnModel().getColumn(6).setResizable(false);
			tabela_bilhetes.getTableHeader().setReorderingAllowed(false);
			tabela_bilhetes.setAutoResizeMode(tabela_bilhetes.AUTO_RESIZE_OFF);
			tabela_bilhetes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		} catch (

		Exception error) {
			JOptionPane.showMessageDialog(null, "Erro ao preencher tabela" + error);
		}
	}

	private void registrarVenda() throws SQLException {

		int cpf = 0, quantidade = 0, evento = 1;
		String nomeFuncionario = "", nomeCliente = "", telefoneCliente = "", mensagemErro = "";

		if (campo_cpf.getText().trim().equals("") == true) {
			mensagemErro += "\nO campo cpf não pode ser vaziu!";
		}
		if (campo_cpf.getText().matches("\\d+") == false) {
			mensagemErro += "\nO campo de cpf só pode conter numeros!";
		}
		if (campo_quantidade.getText().trim().equals("") == true) {
			mensagemErro += "\nO campo de quantidade não pode ser vaziu!";
		}
		if (campo_quantidade.getText().matches("\\d+") == false) {
			mensagemErro += "\nO campo de quantidade só pode conter numeros!";
		}
		if (combo_funcionario.getSelectedItem().equals("") == true) {
			mensagemErro += "\nO campo de funcionariodeve ser selecionado!";
		}
		if (campo_nome.getText().trim().equals("") == true) {
			mensagemErro += "\nO campo nome do cliente não pode ser vaziu!";
		}
		if (campo_telefone.getText().trim().equals("") == true) {
			mensagemErro += "\nO campo telefone não pode ser vaziu!";
		}
		if (telefoneCliente.length() > 8) {
			mensagemErro += "\nO telefone não pode ter mais que 8 caracteres!";
		}
		if (campo_cpf.getText().length() > 6) {
			mensagemErro += "\nO cpf não pode ter mais que 6 caracteres!";
		}

		if (mensagemErro.trim().equals("") == true) {

			cpf = Integer.parseInt(campo_cpf.getText());
			quantidade = Integer.parseInt(campo_quantidade.getText());
			nomeFuncionario = (String) combo_funcionario.getSelectedItem();
			nomeCliente = campo_nome.getText();
			telefoneCliente = campo_telefone.getText();

			rifaDTO objrifaDTO = new rifaDTO();
			objrifaDTO.setCodigo_evento(evento);
			objrifaDTO.setCpf_cliente(cpf);
			objrifaDTO.setNome_cliente(nomeCliente);
			objrifaDTO.setNome_funcionario(nomeFuncionario);
			objrifaDTO.setQuantidade_bilhete(quantidade);
			objrifaDTO.setTelefone_cliente(telefoneCliente);
			objrifaDTO.setAtivo_rifa(0);
			objrifaDTO.setData_venda(dtf.format(LocalDateTime.now()));

			rifaDAO objrifaDAO = new rifaDAO();
			objrifaDAO.cadastrarBilhete(objrifaDTO);

			calculaValor();
			ultimaCompra();
			distribuirBilhete();
		} else {
			JOptionPane.showMessageDialog(null, mensagemErro);
		}
	}

	private void calculaValor() {
		int quantidade = 0, valor = 0, bilhete = 0;

		quantidade = Integer.parseInt(campo_quantidade.getText());
		bilhete = Integer.parseInt(campo_valor_rifa.getText());

		if (quantidade > 0) {
			valor = bilhete * quantidade;
			campo_valor.setText("" + valor);
		} else {
			campo_valor.setText("0");
		}
	}

	private void consultaFuncionarios() throws SQLException {
		ResultSet rs = null;

		funcionarioDAO objfuncionarioDAO = new funcionarioDAO();
		rs = objfuncionarioDAO.buscaFuncionarios(0, "", 0);

		while (rs.next() == true) {
			combo_funcionario.addItem(rs.getString("nomefuncionario"));
		}
		rs.close();

		objfuncionarioDAO.fechaConexao();
	}

	private void buscarPrecoEvento() throws SQLException {
		ResultSet rs = null;

		eventoDAO objeventosDAO = new eventoDAO();
		rs = objeventosDAO.buscaEvento();

		if (rs.next() == true) {
			this.campo_valor_rifa.setText("" + rs.getInt("valorentrada"));
		}
		rs.close();

		objeventosDAO.fechaConexao();
	}

	private void ultimaCompra() throws SQLException {
		ResultSet rs = null;

		rifaDAO objrifaDAO = new rifaDAO();
		rs = objrifaDAO.buscarUltimaRifa(0);

		if (rs.next() == true) {
			lbl_ultima_funcionario.setText(rs.getString("nomefuncionario"));
			lbl_ultima_cpf.setText("" + rs.getInt("cpfcliente"));
			lbl_ultima_nome.setText(rs.getString("nomecliente"));
			lbl_ultima_telefone.setText(rs.getString("telefonecliente"));
			lbl_ultima_quantidade.setText("" + rs.getInt("quantiabilhete"));
			lbl_ultima_data.setText("" + rs.getString("datavenda"));
		}
		rs.close();

		objrifaDAO.fechaConexao();
	}

	private void replicarUltimaVenda() {
		combo_funcionario.setSelectedItem(lbl_ultima_funcionario.getText());
		campo_nome.setText(lbl_ultima_nome.getText());
		campo_cpf.setText(lbl_ultima_cpf.getText());
		campo_quantidade.setText(lbl_ultima_quantidade.getText());
		campo_telefone.setText(lbl_ultima_telefone.getText());
	}

	private void distribuirBilhete() throws SQLException {
		bilheteDAO objbilheteDAO;

		ResultSet rs = null;

		rifaDAO objrifaDAO = new rifaDAO();
		rs = objrifaDAO.buscarUltimaRifa(1);

		while (rs.next() == true) {
			objbilheteDAO = new bilheteDAO();
			objbilheteDAO.criarBilhete(rs.getInt("idrifa"), rs.getInt("cpfcliente"), rs.getInt("quantiabilhete"));
			objrifaDAO.alteraFeito(rs.getInt("idrifa"));
		}
		rs.close();
	}
}

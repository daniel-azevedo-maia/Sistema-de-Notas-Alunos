package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import classesdoprojeto.Aluno;
import classesdoprojeto.Boletim;
import classesdoprojeto.Disciplina;
import persistencia.Conexão;
import persistencia.JDBCAluno;
import javax.swing.ImageIcon;

public class BoletimFrame extends JInternalFrame {
	private JTable tabela;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BoletimFrame frame = new BoletimFrame(null, null, null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("serial")
	public BoletimFrame(Aluno aln, Disciplina disc, Boletim boletim) {
		setFrameIcon(new ImageIcon("C:\\Users\\Daniel Azevedo\\Downloads\\iconeMenor.png"));
		
		setTitle("Boletim do Aluno");
		setBounds(100, 100, 618, 404);

		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);

		JPanel Boletim = new JPanel();
		getContentPane().add(Boletim, BorderLayout.CENTER);
		Boletim.setLayout(null);

		JLabel lblNewLabel = new JLabel("Boletim de " + aln.getNome() + " - Matrícula " + aln.getMatricula());
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(20, 28, 582, 14);
		Boletim.add(lblNewLabel);

		JSeparator separator = new JSeparator();
		separator.setBounds(20, 65, 449, 17);
		Boletim.add(separator);

		JButton gerarRelatorio = new JButton("Exportar relat\u00F3rio para o bloco de notas");
		gerarRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Criando um arquivo
				try {
					String nomeArq = "Boletim de " + aln.getNome() + ".txt";
					File meuArquivo = new File(nomeArq);
					if (meuArquivo.createNewFile()) {
						System.out.println("Arquivo criado com sucesso!");
					} else {
						System.out.println("O arquivo já existe!");
					}
				} catch (IOException ex) {
					System.out.println("Um erro ocorreu!");
					ex.printStackTrace();
				}

				// Exibição de tudo:

				// Escrevendo em um arquivo:

				try {

					String ArqEscrito = "Boletim de " + aln.getNome() + ".txt";
					FileWriter meuEscrito = new FileWriter(ArqEscrito);
					System.out.println("Escrito com sucesso!");

					meuEscrito.write("--- Dados do aluno ---\n");

					// Exibindo dados cadastrais:
					meuEscrito.write("\tNome: " + aln.getNome() + "\n");
					meuEscrito.write("\tSexo: " + aln.getSexo() + "\n");
					meuEscrito.write("\tCPF: " + aln.getCpf() + "\n");
					meuEscrito.write("\tMatrícula: " + aln.getMatricula() + "\n");
					meuEscrito.write("\tSérie: " + aln.getSerie() + "\n");
					meuEscrito.write("\tTurno: " + aln.getTurno() + "\n");
					meuEscrito.write("\tTurma: " + aln.getTurma() + "\n");
					meuEscrito.write("\n");
					meuEscrito.write("--- Boletim do aluno ---\n");
					meuEscrito.write("\nNOTAS:\n");

					// Exibindo disciplinas

					for (Disciplina d : aln.getBoletim().getDisciplinas()) {
						meuEscrito.write("\n\t" + d.getNomeDisc() + ": " + "\n");
						for (int k = 0; k < d.getNotas().length; k++) {
							meuEscrito.write("\t" + d.getNotas()[k]);
							meuEscrito.write("\n");
						}
					}

					meuEscrito.close();

				} catch (IOException ex) {
					System.out.println("Ocorreu um erro ao escrever no arquivo.");
					ex.printStackTrace();
				}
				
				JOptionPane.showMessageDialog(null, "Informações do aluno registradas em arquivo. Confira o arquivo gerado na mesma pasta deste programa.");

			}
		});
		gerarRelatorio.setBounds(10, 289, 282, 28);
		Boletim.add(gerarRelatorio);

		JButton btnNewButton = new JButton("Voltar ao menu");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Boletim.setVisible(false);
			}
		});
		btnNewButton.setBounds(139, 328, 153, 24);
		Boletim.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Sair");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_1.setBounds(305, 329, 123, 23);
		Boletim.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Registrar no banco de dados");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Ao clicar em REGISTRAR NO BANCO DE DADOS, SERÁ FEITO ISSO:

				// Persistindo no banco de dados:
				Conexão fábrica = new Conexão();
				JDBCAluno gerente = new JDBCAluno(fábrica.abrirConexão());

				// Realizando a inserção:
				gerente.inserirAluno(aln);
				
				JOptionPane.showMessageDialog(null, "Aluno inserido no banco de dados com sucesso!");

				fábrica.fecharConexão();

			}
		});
		btnNewButton_2.setBounds(306, 289, 286, 30);
		Boletim.add(btnNewButton_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 65, 582, 217);
		Boletim.add(scrollPane);
		
		
		tabela = new JTable();
		scrollPane.setViewportView(tabela);
		tabela.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Disciplina", "Nota 1", "Nota 2", "Nota 3", "Nota 4", "M\u00E9dia", "Situa\u00E7\u00E3o"
			}
		));
		
		DefaultTableModel modelo = (DefaultTableModel)tabela.getModel();
		modelo.setNumRows(0);

		for (int i = 0; i < aln.getBoletim().getDisciplinas().size(); i++) {

			Object[] dados = { aln.getBoletim().getDisciplinas().get(i).getNomeDisc(),
					aln.getBoletim().getDisciplinas().get(i).getNotas()[0],
					aln.getBoletim().getDisciplinas().get(i).getNotas()[1],
					aln.getBoletim().getDisciplinas().get(i).getNotas()[2],
					aln.getBoletim().getDisciplinas().get(i).getNotas()[3],
					aln.getBoletim().getDisciplinas().get(i).getMedia_geral(),
					aln.getBoletim().getDisciplinas().get(i).getSituacao() };

			modelo.addRow(dados);

		}

	}
}

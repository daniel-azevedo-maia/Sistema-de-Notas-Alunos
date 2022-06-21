
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.Label;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

public class InserirDisc extends JInternalFrame {
	private JTextField nomeDisc;
	private JTextField nota1;
	private JTextField nota2;
	private JTextField nota3;
	private JTextField nota4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InserirDisc frame = new InserirDisc();
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
	public InserirDisc() {
		setBounds(100, 100, 530, 352);

		setClosable(true);
		setMaximizable(true);

		JPanel finserirdisc = new JPanel();
		finserirdisc.setBorder(
				new TitledBorder(null, "Cadastro de disciplina", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(finserirdisc, BorderLayout.CENTER);
		finserirdisc.setLayout(null);

		JLabel lblDisciplina = new JLabel("Cadastro de nova disciplina");
		lblDisciplina.setFont(new Font("Nirmala UI", Font.BOLD, 15));
		lblDisciplina.setBounds(30, 27, 372, 43);
		finserirdisc.add(lblDisciplina);

		JSeparator separator = new JSeparator();
		separator.setBounds(30, 77, 449, 17);
		finserirdisc.add(separator);

		Label label = new Label("Disciplina:");
		label.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 13));
		label.setBounds(30, 100, 80, 22);
		finserirdisc.add(label);

		nomeDisc = new JTextField();
		nomeDisc.setColumns(10);
		nomeDisc.setBounds(123, 102, 173, 20);
		finserirdisc.add(nomeDisc);

		Label label_1 = new Label("Nota 1:");
		label_1.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 13));
		label_1.setBounds(30, 128, 55, 22);
		finserirdisc.add(label_1);

		nota1 = new JTextField();
		nota1.setColumns(10);
		nota1.setBounds(123, 130, 69, 20);
		finserirdisc.add(nota1);

		Label label_1_1 = new Label("Nota 2:");
		label_1_1.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 13));
		label_1_1.setBounds(30, 156, 55, 22);
		finserirdisc.add(label_1_1);

		nota2 = new JTextField();
		nota2.setColumns(10);
		nota2.setBounds(123, 156, 69, 20);
		finserirdisc.add(nota2);

		Label label_1_2 = new Label("Nota 3:");
		label_1_2.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 13));
		label_1_2.setBounds(30, 184, 55, 22);
		finserirdisc.add(label_1_2);

		nota3 = new JTextField();
		nota3.setColumns(10);
		nota3.setBounds(123, 186, 69, 20);
		finserirdisc.add(nota3);

		Label label_1_3 = new Label("Nota 4:");
		label_1_3.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 13));
		label_1_3.setBounds(30, 212, 55, 22);
		finserirdisc.add(label_1_3);

		nota4 = new JTextField();
		nota4.setColumns(10);
		nota4.setBounds(123, 214, 69, 20);
		finserirdisc.add(nota4);

		JButton cadastrarDisc = new JButton("Cadastrar disciplina");
		cadastrarDisc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String disciplina = nomeDisc.getText();
				double n1 = Double.parseDouble(nota1.getText());
				double n2 = Double.parseDouble(nota2.getText());
				double n3 = Double.parseDouble(nota3.getText());
				double n4 = Double.parseDouble(nota4.getText());

				AlunoNovo aln = new AlunoNovo();
				JOptionPane.showMessageDialog(null, aln.nome);

			}
		});
		cadastrarDisc.setBounds(28, 253, 164, 43);
		finserirdisc.add(cadastrarDisc);

		JButton limpar = new JButton("Limpar");
		limpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				nomeDisc.setText("");
				nota1.setText("");
				nota2.setText("");
				nota3.setText("");
				nota4.setText("");

			}
		});
		limpar.setBounds(202, 253, 97, 43);
		finserirdisc.add(limpar);

		JButton sair = new JButton("Sair");
		sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				finserirdisc.setVisible(false);
			}
		});
		sair.setBounds(309, 253, 97, 43);
		finserirdisc.add(sair);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(30, 307, 449, 17);
		finserirdisc.add(separator_1);

	}
}

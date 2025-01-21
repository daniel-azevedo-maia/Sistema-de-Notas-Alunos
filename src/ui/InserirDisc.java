package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import domain.Aluno;
import domain.Boletim;
import domain.Disciplina;

import javax.swing.ImageIcon;

public class InserirDisc extends JInternalFrame {

	private JTextField nomeDisc;
	private JTextField nota1;
	private JTextField nota2;
	private JTextField nota3;
	private JTextField nota4;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				InserirDisc frame = new InserirDisc(null, null, null);
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public InserirDisc(Aluno aln, Disciplina disc, Boletim boletim) {
		System.out.println("Iniciando criação da janela InserirDisc...");

		setFrameIcon(new ImageIcon("C:\\Users\\Daniel Azevedo\\Downloads\\iconeMenor.png"));
		setTitle("Cadastro de Disciplinas");

		setBounds(100, 100, 530, 352);
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);

		JPanel finserirdisc = new JPanel();
		finserirdisc.setBackground(SystemColor.control);
		finserirdisc.setBorder(new TitledBorder(null, "Cadastro de Disciplina", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(finserirdisc, BorderLayout.CENTER);
		finserirdisc.setLayout(null);

		JLabel labelDisciplina = new JLabel("Cadastro de disciplina");
		labelDisciplina.setFont(new Font("Nirmala UI", Font.BOLD, 15));
		labelDisciplina.setBounds(30, 27, 225, 43);
		finserirdisc.add(labelDisciplina);

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

		JButton cadastrarDisc = new JButton("Adicionar");
		cadastrarDisc.addActionListener(e -> {
			System.out.println("Botão 'Adicionar' pressionado.");

			if (nomeDisc.getText().isEmpty() || nota1.getText().isEmpty() || nota2.getText().isEmpty() || nota3.getText().isEmpty() || nota4.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Preencha todos os campos para prosseguir!");
				return;
			}

			try {
				String disciplina = nomeDisc.getText();
				double n1 = Double.parseDouble(nota1.getText());
				double n2 = Double.parseDouble(nota2.getText());
				double n3 = Double.parseDouble(nota3.getText());
				double n4 = Double.parseDouble(nota4.getText());

				Disciplina novaDisciplina = new Disciplina();
				novaDisciplina.setNomeDisc(disciplina);
				novaDisciplina.setNotas(new double[]{n1, n2, n3, n4});
				novaDisciplina.mediaFinal();

				System.out.println("Disciplina criada: " + novaDisciplina.getNomeDisc());
				System.out.println("Notas: " + n1 + ", " + n2 + ", " + n3 + ", " + n4);

				boletim.getDisciplinas().add(novaDisciplina);
				aln.setBoletim(boletim);

				JOptionPane.showMessageDialog(null, "Disciplina cadastrada com sucesso!");
				nomeDisc.setText("");
				nota1.setText("");
				nota2.setText("");
				nota3.setText("");
				nota4.setText("");

			} catch (NumberFormatException ex) {
				System.out.println("Erro ao converter notas: " + ex.getMessage());
				JOptionPane.showMessageDialog(null, "Notas devem ser valores numéricos válidos!");
			}
		});
		cadastrarDisc.setBounds(28, 253, 136, 43);
		finserirdisc.add(cadastrarDisc);

		JButton limpar = new JButton("Limpar");
		limpar.addActionListener(e -> {
			System.out.println("Botão 'Limpar' pressionado.");
			nomeDisc.setText("");
			nota1.setText("");
			nota2.setText("");
			nota3.setText("");
			nota4.setText("");
		});
		limpar.setBounds(304, 253, 85, 43);
		finserirdisc.add(limpar);

		JButton sair = new JButton("Sair");
		sair.addActionListener(e -> {
			System.out.println("Botão 'Sair' pressionado.");
			dispose();
		});
		sair.setBounds(399, 253, 80, 43);
		finserirdisc.add(sair);

		JButton finalizar = new JButton("Finalizar");
		finalizar.addActionListener(e -> {
			System.out.println("Botão 'Finalizar' pressionado. Redirecionando para BoletimFrame...");
			BoletimFrame boletimFrame = new BoletimFrame(aln, new Disciplina(), boletim);
			getParent().add(boletimFrame);
			boletimFrame.setVisible(true);
			dispose();
		});
		finalizar.setBounds(174, 253, 120, 43);
		finserirdisc.add(finalizar);

		System.out.println("Janela InserirDisc criada com sucesso.");
	}
}

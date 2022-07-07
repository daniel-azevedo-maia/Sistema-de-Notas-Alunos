package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class Inserir extends JInternalFrame {
	private JTextField nome;
	private JTextField cpf;
	private JTextField matricula;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inserir frame = new Inserir(null, null, null, null);
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
	public Inserir(Aluno aln, Disciplina disc, Boletim boletim, List<Disciplina> disciplinas) {
		setTitle("Dados Pessoais e Escolares");
		setBounds(100, 100, 561, 371);

		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);

		JPanel inserir = new JPanel();

		inserir.setBackground(SystemColor.control);
		inserir.setBorder(
				new TitledBorder(null, "Cadastro de novo aluno", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(inserir, BorderLayout.CENTER);
		inserir.setLayout(null);

		JLabel lblNewLabel = new JLabel("Dados pessoais:");
		lblNewLabel.setFont(new Font("Nirmala UI", Font.BOLD, 15));
		lblNewLabel.setBounds(30, 27, 140, 43);
		inserir.add(lblNewLabel);

		JSeparator separator = new JSeparator();
		separator.setBounds(30, 81, 449, 17);
		inserir.add(separator);

		Label label = new Label("Nome:");
		label.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 13));
		label.setBounds(30, 104, 55, 22);
		inserir.add(label);

		Label label_1 = new Label("CPF:");
		label_1.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 13));
		label_1.setBounds(30, 132, 71, 22);
		inserir.add(label_1);

		Label label_1_1 = new Label("Matr\u00EDcula");
		label_1_1.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 13));
		label_1_1.setBounds(30, 160, 71, 22);
		inserir.add(label_1_1);

		Label serie = new Label("S\u00E9rie:");
		serie.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 13));
		serie.setBounds(30, 188, 71, 22);
		inserir.add(serie);

		Label turno = new Label("Turno:");
		turno.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 13));
		turno.setBounds(30, 216, 64, 22);
		inserir.add(turno);

		Label turma = new Label("Turma:");
		turma.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 13));
		turma.setBounds(30, 244, 71, 22);
		inserir.add(turma);

		// --------------------------------------------------------
		JRadioButton primeiroAno = new JRadioButton("1\u00BA ano");
		primeiroAno.setSelected(true);
		primeiroAno.setBounds(107, 187, 64, 23);
		inserir.add(primeiroAno);

		JRadioButton segundoAno = new JRadioButton("2\u00BA ano");
		segundoAno.setBounds(176, 187, 64, 23);
		inserir.add(segundoAno);

		JRadioButton terceiroAno = new JRadioButton("3\u00BA ano");
		terceiroAno.setBounds(242, 188, 89, 23);
		inserir.add(terceiroAno);

		ButtonGroup botaoSerie = new ButtonGroup();
		botaoSerie.add(primeiroAno);
		botaoSerie.add(segundoAno);
		botaoSerie.add(terceiroAno);

		// --------------------------------------------------------

		JRadioButton manha = new JRadioButton("Manh\u00E3");
		manha.setSelected(true);
		manha.setBounds(107, 216, 71, 23);
		inserir.add(manha);

		JRadioButton tarde = new JRadioButton("Tarde");
		tarde.setBounds(176, 216, 64, 23);
		inserir.add(tarde);

		ButtonGroup botaoTurno = new ButtonGroup();
		botaoTurno.add(manha);
		botaoTurno.add(tarde);

		// --------------------------------------------------------

		JRadioButton a = new JRadioButton("A");
		a.setSelected(true);
		a.setBounds(107, 243, 33, 23);
		inserir.add(a);

		JRadioButton b = new JRadioButton("B");
		b.setBounds(176, 244, 33, 23);
		inserir.add(b);

		JRadioButton c = new JRadioButton("C");
		c.setBounds(242, 243, 33, 23);
		inserir.add(c);

		ButtonGroup botaoTurma = new ButtonGroup();
		botaoTurma.add(a);
		botaoTurma.add(b);
		botaoTurma.add(c);

		// --------------------------------------------------------

		JRadioButton masculino = new JRadioButton("M");
		masculino.setSelected(true);
		masculino.setBounds(340, 105, 45, 23);
		inserir.add(masculino);

		JRadioButton feminino = new JRadioButton("F");
		feminino.setBounds(387, 105, 33, 23);
		inserir.add(feminino);

		ButtonGroup botaoSexo = new ButtonGroup();
		botaoSexo.add(masculino);
		botaoSexo.add(feminino);

		// --------------------------------------------------------

		nome = new JTextField();
		nome.setBounds(107, 106, 173, 20);
		inserir.add(nome);
		nome.setColumns(10);

		cpf = new JTextField();
		cpf.setColumns(10);
		cpf.setBounds(107, 132, 334, 20);
		inserir.add(cpf);

		matricula = new JTextField();
		matricula.setColumns(10);
		matricula.setBounds(107, 160, 334, 20);
		inserir.add(matricula);

		JButton cadastrar = new JButton("Cadastrar");
		cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String nomeAluno = nome.getText();
				String cpfAluno = cpf.getText();
				String matriculaAluno = matricula.getText();

				String sexo;
				if (masculino.isSelected()) {
					sexo = "Masculino";
				} else {
					sexo = "Feminino";
				}

				String serie;
				if (primeiroAno.isSelected()) {
					serie = "1º ano";
				} else if (segundoAno.isSelected()) {
					serie = "2º ano";
				} else {
					serie = "3º ano";
				}

				String turno;
				if (manha.isSelected()) {
					turno = "Manhã";
				} else {
					turno = "Tarde";
				}

				String turma;
				if (a.isSelected()) {
					turma = "A";
				} else if (b.isSelected()) {
					turma = "B";
				} else {
					turma = "C";
				}

				/*
				 * JOptionPane.showMessageDialog(null, "Aluno cadastrado! Nome: " + nomeAluno +
				 * "\nCPF: " + cpfAluno + "\nMatrícula: " + matriculaAluno + "\nSexo: " + sexo +
				 * "\nSérie: " + serie + "\nTurno: " + turno + "\nTurma: " + turma);
				 */

				JOptionPane.showMessageDialog(null, "Aluno cadastrado com sucesso!");

				aln.setNome(nomeAluno);
				aln.setCpf(cpfAluno);
				aln.setMatricula(matriculaAluno);
				aln.setSexo(sexo);
				aln.setSerie(serie);
				aln.setTurno(turno);
				aln.setTurma(turma);

				// OBS.: SÓ IRÁ ADICIONAR NA LISTA DE ALUNOS APÓS SETAR DISCIPLINAS E NOTAS!
				InserirDisc finserirdisc = new InserirDisc(aln, disc, boletim, disciplinas);

				getParent().add(finserirdisc);
				finserirdisc.setVisible(true);
				dispose();

				finserirdisc.setSize(550, 400); // define o seu tamanho
				finserirdisc.setLocation(55, 5); // define onde estará na tela

			}
		});
		cadastrar.setBounds(29, 291, 114, 31);
		inserir.add(cadastrar);

		JButton limpar = new JButton("Limpar");
		limpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				nome.setText("");
				cpf.setText("");
				matricula.setText("");
				masculino.setSelected(true);
				primeiroAno.setSelected(true);
				manha.setSelected(true);
				a.setSelected(true);

			}
		});
		limpar.setBounds(153, 291, 100, 31);
		inserir.add(limpar);

		JButton voltar = new JButton("Voltar");
		voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		voltar.setBounds(263, 291, 100, 31);
		inserir.add(voltar);

		Label sexo = new Label("Sexo:");
		sexo.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 13));
		sexo.setBounds(290, 104, 44, 22);
		inserir.add(sexo);

	}

}

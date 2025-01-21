package ui;

import domain.Aluno;
import domain.Boletim;
import domain.Disciplina;
import util.JanelaUtils;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Inserir extends JInternalFrame {

	private JTextField nome;
	private JTextField cpf;
	private JTextField matricula;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				Inserir frame = new Inserir(null, null, null, null);
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public Inserir(Aluno aln, Disciplina disc, Boletim boletim, List<Disciplina> disciplinas) {
		System.out.println("Iniciando criação da janela de Inserção...");

		setTitle("Dados Pessoais e Escolares");
		setBounds(100, 100, 561, 400);
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);

		JPanel inserir = new JPanel();
		inserir.setBackground(SystemColor.control);
		inserir.setBorder(new TitledBorder(null, "Cadastro de novo aluno", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(inserir, BorderLayout.CENTER);
		inserir.setLayout(null);

		JLabel lblDadosPessoais = new JLabel("Dados pessoais:");
		lblDadosPessoais.setFont(new Font("Nirmala UI", Font.BOLD, 15));
		lblDadosPessoais.setBounds(30, 27, 140, 43);
		inserir.add(lblDadosPessoais);

		JSeparator separator = new JSeparator();
		separator.setBounds(30, 81, 449, 17);
		inserir.add(separator);

		Label labelNome = new Label("Nome:");
		labelNome.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 13));
		labelNome.setBounds(30, 104, 55, 22);
		inserir.add(labelNome);

		nome = new JTextField();
		nome.setBounds(107, 106, 173, 20);
		inserir.add(nome);
		nome.setColumns(10);

		Label labelCpf = new Label("CPF:");
		labelCpf.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 13));
		labelCpf.setBounds(30, 132, 71, 22);
		inserir.add(labelCpf);

		cpf = new JTextField();
		cpf.setColumns(10);
		cpf.setBounds(107, 132, 334, 20);
		inserir.add(cpf);

		Label labelMatricula = new Label("Matrícula:");
		labelMatricula.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 13));
		labelMatricula.setBounds(30, 160, 71, 22);
		inserir.add(labelMatricula);

		matricula = new JTextField();
		matricula.setColumns(10);
		matricula.setBounds(107, 160, 334, 20);
		inserir.add(matricula);

		Label labelSerie = new Label("Série:");
		labelSerie.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 13));
		labelSerie.setBounds(30, 188, 71, 22);
		inserir.add(labelSerie);

		JRadioButton primeiroAno = new JRadioButton("1º ano");
		primeiroAno.setSelected(true);
		primeiroAno.setBounds(107, 187, 80, 23);
		inserir.add(primeiroAno);

		JRadioButton segundoAno = new JRadioButton("2º ano");
		segundoAno.setBounds(190, 187, 80, 23);
		inserir.add(segundoAno);

		JRadioButton terceiroAno = new JRadioButton("3º ano");
		terceiroAno.setBounds(270, 187, 80, 23);
		inserir.add(terceiroAno);

		ButtonGroup grupoSerie = new ButtonGroup();
		grupoSerie.add(primeiroAno);
		grupoSerie.add(segundoAno);
		grupoSerie.add(terceiroAno);

		Label labelTurno = new Label("Turno:");
		labelTurno.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 13));
		labelTurno.setBounds(30, 216, 71, 22);
		inserir.add(labelTurno);

		JRadioButton manha = new JRadioButton("Manhã");
		manha.setSelected(true);
		manha.setBounds(107, 216, 80, 23);
		inserir.add(manha);

		JRadioButton tarde = new JRadioButton("Tarde");
		tarde.setBounds(190, 216, 80, 23);
		inserir.add(tarde);

		ButtonGroup grupoTurno = new ButtonGroup();
		grupoTurno.add(manha);
		grupoTurno.add(tarde);

		Label labelTurma = new Label("Turma:");
		labelTurma.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 13));
		labelTurma.setBounds(30, 244, 71, 22);
		inserir.add(labelTurma);

		JRadioButton turmaA = new JRadioButton("A");
		turmaA.setSelected(true);
		turmaA.setBounds(107, 243, 50, 23);
		inserir.add(turmaA);

		JRadioButton turmaB = new JRadioButton("B");
		turmaB.setBounds(160, 243, 50, 23);
		inserir.add(turmaB);

		JRadioButton turmaC = new JRadioButton("C");
		turmaC.setBounds(213, 243, 50, 23);
		inserir.add(turmaC);

		ButtonGroup grupoTurma = new ButtonGroup();
		grupoTurma.add(turmaA);
		grupoTurma.add(turmaB);
		grupoTurma.add(turmaC);

		JButton cadastrar = new JButton("Cadastrar");
		cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Botão 'Cadastrar' pressionado.");
				System.out.println("Nome: " + nome.getText());
				System.out.println("CPF: " + cpf.getText());
				System.out.println("Matrícula: " + matricula.getText());

				String serie = primeiroAno.isSelected() ? "1º ano" : segundoAno.isSelected() ? "2º ano" : "3º ano";
				String turno = manha.isSelected() ? "Manhã" : "Tarde";
				String turma = turmaA.isSelected() ? "A" : turmaB.isSelected() ? "B" : "C";

				System.out.println("Série: " + serie);
				System.out.println("Turno: " + turno);
				System.out.println("Turma: " + turma);

				if (nome.getText().isEmpty() || cpf.getText().isEmpty() || matricula.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos para prosseguir!");
				} else {
					System.out.println("Cadastro validado.");

					// Configurar dados do aluno
					Aluno aluno = new Aluno();
					aluno.setNome(nome.getText());
					aluno.setCpf(cpf.getText());
					aluno.setMatricula(matricula.getText());
					aluno.setSerie(serie);
					aluno.setTurno(turno);
					aluno.setTurma(turma);

					System.out.println("Redirecionando para a tela de Cadastro de Disciplinas...");
					InserirDisc inserirDisc = new InserirDisc(aln, new Disciplina(), new Boletim());
					getParent().add(inserirDisc);
					inserirDisc.setVisible(true);

					inserirDisc.setSize(530, 352); // Define o tamanho
					JanelaUtils.centralizarJanela(getParent(), inserirDisc); // Centraliza no contêiner

					dispose();

				}
			}
		});

		cadastrar.setBounds(30, 300, 120, 30);
		inserir.add(cadastrar);

		JButton limpar = new JButton("Limpar");
		limpar.addActionListener(e -> {
			System.out.println("Botão 'Limpar' pressionado.");
			nome.setText("");
			cpf.setText("");
			matricula.setText("");
			primeiroAno.setSelected(true);
			manha.setSelected(true);
			turmaA.setSelected(true);
		});
		limpar.setBounds(160, 300, 120, 30);
		inserir.add(limpar);

		JButton voltar = new JButton("Voltar");
		voltar.addActionListener(e -> {
			System.out.println("Botão 'Voltar' pressionado.");
			dispose();
		});
		voltar.setBounds(290, 300, 120, 30);
		inserir.add(voltar);

		System.out.println("Janela de Inserção criada com sucesso.");
	}
}

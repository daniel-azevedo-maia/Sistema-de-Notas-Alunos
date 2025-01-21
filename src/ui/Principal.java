package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import domain.Aluno;
import domain.Boletim;
import domain.Disciplina;
import util.JanelaUtils;

import java.awt.Toolkit;

public class Principal extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);

		EventQueue.invokeLater(() -> {

			try {
				Principal frame = new Principal();
				JanelaUtils.centralizarJanelaNaTela(frame); // Centraliza o JFrame
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public Principal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Daniel Azevedo\\Downloads\\cadastroAluno.png"));
		setTitle("Cadastro de Alunos - Por: Daniel Azevedo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 685, 465);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JDesktopPane desktop = new JDesktopPane();
		desktop.setBackground(new Color(0, 0, 128));
		contentPane.add(desktop, BorderLayout.CENTER);

		JLabel lblCadastroDeAlunos = new JLabel("Cadastro de Alunos e Notas");
		lblCadastroDeAlunos.setForeground(new Color(255, 255, 255));
		lblCadastroDeAlunos.setVerticalAlignment(SwingConstants.TOP);
		lblCadastroDeAlunos.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroDeAlunos.setFont(new Font("Calibri", Font.BOLD, 30));
		lblCadastroDeAlunos.setBounds(135, 41, 408, 37);
		desktop.add(lblCadastroDeAlunos);

		JLabel lblNewLabel = new JLabel("Desenvolvido por Daniel Azevedo de Oliveira Maia - 2022 ");
		lblNewLabel.setFont(new Font("Microsoft JhengHei", Font.BOLD, 13));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(160, 372, 357, 14);
		desktop.add(lblNewLabel);

		JButton listar = new JButton("Consultar notas");
		listar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Consultar fconsultar = new Consultar();

				desktop.add(fconsultar);
			
				
				fconsultar.setVisible(true);

				fconsultar.setSize(658, 416); // define o seu tamanho
				fconsultar.setLocation(0, 0); // define onde estará na tela

			}
		});
		listar.setForeground(new Color(0, 0, 139));
		listar.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		listar.setBackground(UIManager.getColor("Button.focus"));
		listar.setBounds(239, 145, 197, 27);
		desktop.add(listar);

		JButton sair = new JButton("Sair");
		sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				System.exit(0);
			}
		});
		sair.setForeground(new Color(0, 0, 139));
		sair.setFont(new Font("MS UI Gothic", Font.BOLD, 16));
		sair.setBackground(UIManager.getColor("Button.focus"));
		sair.setBounds(239, 296, 197, 27);
		desktop.add(sair);

		JButton sobre = new JButton("Sobre");
		
		sobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"Desenvolvido por: Daniel Azevedo de O. Maia\nGitHub: https://github.com/daniel-azevedo-maia\nLinkedIn: https://linkedin.com/in/daniel-azevedo-maia");
			}
		});
		sobre.setForeground(new Color(0, 0, 139));
		sobre.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		sobre.setBackground(UIManager.getColor("Button.focus"));
		sobre.setBounds(239, 258, 197, 27);
		desktop.add(sobre);

		JSeparator separator = new JSeparator();
		separator.setBounds(116, 347, 460, 2);
		desktop.add(separator);

		JButton cadastrar = new JButton("Cadastrar novo");
		cadastrar.addActionListener(e -> {
			System.out.println("Botão 'Cadastrar Novo' pressionado.");

			Aluno aln = new Aluno();
			Disciplina disc = new Disciplina();
			Boletim boletim = new Boletim();
			List<Disciplina> disciplinas = new ArrayList<>();

			Inserir finserir = new Inserir(aln, disc, boletim, disciplinas);
			desktop.add(finserir);
			finserir.setVisible(true);

			finserir.setSize(550, 400); // Define o tamanho
			JanelaUtils.centralizarJanela(desktop, finserir); // Centraliza o frame
		});

		cadastrar.setForeground(new Color(0, 0, 139));
		cadastrar.setBackground(UIManager.getColor("Button.focus"));
		cadastrar.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		cadastrar.setBounds(239, 97, 197, 37);
		desktop.add(cadastrar);
		
		JButton btnAlterarDadosDo = new JButton("Atualizar dados");
		btnAlterarDadosDo.setForeground(new Color(0, 0, 139));
		btnAlterarDadosDo.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		btnAlterarDadosDo.setBackground(UIManager.getColor("Button.focus"));
		btnAlterarDadosDo.setBounds(239, 183, 197, 27);
		desktop.add(btnAlterarDadosDo);
		
		JButton btnRemoverDados = new JButton("Remover dados");
		btnRemoverDados.setForeground(new Color(0, 0, 139));
		btnRemoverDados.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		btnRemoverDados.setBackground(UIManager.getColor("Button.focus"));
		btnRemoverDados.setBounds(239, 220, 197, 27);
		desktop.add(btnRemoverDados);
	}
}

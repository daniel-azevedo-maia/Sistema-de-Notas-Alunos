package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class Principal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
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

		JButton listar = new JButton("Alunos cadastrados");
		listar.setForeground(new Color(0, 0, 139));
		listar.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		listar.setBackground(UIManager.getColor("Button.focus"));
		listar.setBounds(239, 170, 197, 57);
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
		sair.setBounds(239, 286, 197, 37);
		desktop.add(sair);

		JButton sobre = new JButton("Sobre");
		sobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Desenvolvido por: Daniel Azevedo de O. Maia\nGitHub: https://github.com/daniel-azevedo-maia\nLinkedIn: https://www.linkedin.com/in/daniel-azevedo-0a9952221/");
			}
		});
		sobre.setForeground(new Color(0, 0, 139));
		sobre.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		sobre.setBackground(UIManager.getColor("Button.focus"));
		sobre.setBounds(239, 238, 197, 37);
		desktop.add(sobre);

		JSeparator separator = new JSeparator();
		separator.setBounds(116, 347, 460, 2);
		desktop.add(separator);

		JButton cadastrar = new JButton("Cadastrar novo aluno");
		cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Inserir finserir = new Inserir();
				desktop.add(finserir);
				finserir.setVisible(true);

				finserir.setSize(550, 400); //define o seu tamanho
				finserir.setLocation(55, 5); //define onde estará na tela

			}
		});
		cadastrar.setForeground(new Color(0, 0, 139));
		cadastrar.setBackground(UIManager.getColor("Button.focus"));
		cadastrar.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		cadastrar.setBounds(239, 97, 197, 62);
		desktop.add(cadastrar);
	}
}

package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import domain.Aluno;
import domain.Boletim;
import domain.Disciplina;
import repository.Conexao;
import repository.JDBCAluno;

import javax.swing.ImageIcon;

public class BoletimFrame extends JInternalFrame {

    private JTable tabela;

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

    public BoletimFrame(Aluno aln, Disciplina disc, Boletim boletim) {
        setFrameIcon(new ImageIcon("C:\\Users\\Daniel Azevedo\\Downloads\\iconeMenor.png"));
        setTitle("Boletim do Aluno");
        setBounds(100, 100, 618, 404);

        // Centralizar o BoletimFrame no JDesktopPane
        addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentShown(java.awt.event.ComponentEvent evt) {
                if (getParent() != null) {
                    int parentWidth = getParent().getWidth();
                    int parentHeight = getParent().getHeight();
                    int frameWidth = getWidth();
                    int frameHeight = getHeight();
                    setLocation((parentWidth - frameWidth) / 2, (parentHeight - frameHeight) / 2);
                }
            }
        });

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

        JButton gerarRelatorio = new JButton("Exportar relatório para o bloco de notas");
        gerarRelatorio.addActionListener(e -> {
            // Lógica para gerar relatório
            System.out.println("Exportando relatório...");
        });
        gerarRelatorio.setBounds(10, 289, 282, 28);
        Boletim.add(gerarRelatorio);

        JButton btnNewButton = new JButton("Voltar ao menu");
        btnNewButton.addActionListener(e -> dispose());
        btnNewButton.setBounds(139, 328, 153, 24);
        Boletim.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Sair");
        btnNewButton_1.addActionListener(e -> System.exit(0));
        btnNewButton_1.setBounds(305, 329, 123, 23);
        Boletim.add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("Registrar no banco de dados");
        btnNewButton_2.addActionListener(e -> {
            System.out.println("Registrando no banco de dados...");
        });
        btnNewButton_2.setBounds(306, 289, 286, 30);
        Boletim.add(btnNewButton_2);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(20, 65, 582, 217);
        Boletim.add(scrollPane);

        tabela = new JTable();
        scrollPane.setViewportView(tabela);
        tabela.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{"Disciplina", "Nota 1", "Nota 2", "Nota 3", "Nota 4", "Média", "Situação"}
        ));

        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setNumRows(0);

        for (int i = 0; i < aln.getBoletim().getDisciplinas().size(); i++) {
            Object[] dados = {
                    aln.getBoletim().getDisciplinas().get(i).getNomeDisc(),
                    aln.getBoletim().getDisciplinas().get(i).getNotas()[0],
                    aln.getBoletim().getDisciplinas().get(i).getNotas()[1],
                    aln.getBoletim().getDisciplinas().get(i).getNotas()[2],
                    aln.getBoletim().getDisciplinas().get(i).getNotas()[3],
                    aln.getBoletim().getDisciplinas().get(i).getMedia_geral(),
                    aln.getBoletim().getDisciplinas().get(i).getSituacao()
            };
            modelo.addRow(dados);
        }
    }

}

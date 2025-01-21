package ui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import repository.Conexao;
import repository.DadosAlunoQuery;
import repository.JDBCAluno;

public class Consultar extends JInternalFrame {

    private JTextField campoMat;
    private JTable tabela;
    private JTextField campoAluno;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Consultar frame = new Consultar();

                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Consultar() {
        setTitle("Consulta de alunos");
        setBounds(100, 100, 661, 352);

        setClosable(true);
        setMaximizable(true);
        setIconifiable(true);
        getContentPane().setLayout(null);

        JLabel lblConsultaDeAlunos = new JLabel("Consulta de alunos:");
        lblConsultaDeAlunos.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblConsultaDeAlunos.setBounds(10, 28, 582, 14);
        getContentPane().add(lblConsultaDeAlunos);

        JSeparator separator = new JSeparator();
        separator.setBounds(10, 51, 441, 2);
        getContentPane().add(separator);

        JLabel lblInformeAMatrcula = new JLabel("Matr\u00EDcula:");
        lblInformeAMatrcula.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblInformeAMatrcula.setBounds(10, 68, 72, 14);
        getContentPane().add(lblInformeAMatrcula);

        campoMat = new JTextField();
        campoMat.setBounds(77, 66, 241, 20);
        getContentPane().add(campoMat);
        campoMat.setColumns(10);

        JButton btnNewButton = new JButton("Pesquisar");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Conexao fabrica = new Conexao();
                JDBCAluno gerente = new JDBCAluno(fabrica.abrirConexao());
                ArrayList<DadosAlunoQuery> dadosAluno = gerente.consultarAluno(campoMat.getText());
                fabrica.fecharConexao();

                DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();

                modelo.setNumRows(0);

                campoAluno.setText(dadosAluno.get(0).getNome());

                for (DadosAlunoQuery d : dadosAluno) {
                    Object[] dados = {d.getDisciplina(), d.getNota1(), d.getNota2(), d.getNota3(), d.getNota4(),
                            d.getMedia(), d.getSituacao()};
                    modelo.addRow(dados);
                }

            }
        });
        btnNewButton.setBounds(323, 65, 121, 23);
        getContentPane().add(btnNewButton);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 143, 625, 154);
        getContentPane().add(scrollPane);

        tabela = new JTable();

        scrollPane.setViewportView(tabela);
        tabela.setModel(new DefaultTableModel(new Object[][]{}, new String[]{"Disciplina", "Nota 1", "Nota 2",
                "Nota 3", "Nota 4", "M\u00E9dia", "Situa\u00E7\u00E3o"}) {
            boolean[] columnEditables = new boolean[]{false, true, true, true, true, true, true};

            public boolean isCellEditable(int row, int column) {
                return columnEditables[column];
            }
        });

        JLabel lblAluno = new JLabel("Aluno:");
        lblAluno.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblAluno.setBounds(10, 102, 65, 14);
        getContentPane().add(lblAluno);

        campoAluno = new JTextField();
        campoAluno.setEnabled(false);
        campoAluno.setColumns(10);
        campoAluno.setBounds(77, 100, 241, 20);
        getContentPane().add(campoAluno);
        tabela.getColumnModel().getColumn(0).setPreferredWidth(50);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(50);
        tabela.getColumnModel().getColumn(2).setPreferredWidth(50);
        tabela.getColumnModel().getColumn(3).setPreferredWidth(50);
        tabela.getColumnModel().getColumn(4).setPreferredWidth(50);
        tabela.getColumnModel().getColumn(5).setPreferredWidth(50);

    }
}

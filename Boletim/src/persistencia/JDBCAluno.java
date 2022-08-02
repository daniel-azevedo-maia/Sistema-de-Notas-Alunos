package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import classesdoprojeto.Aluno;

public class JDBCAluno {

	Connection conex�o;

	/*
	 * Vamos fazer isso para que, quando criarmos um novo objeto da classe JDBC, na
	 * tela da aplica��o (vis�o), criarmos passando um objeto da classe Conex�o,
	 * para poder fazer as opera��es.
	 */
	public JDBCAluno(Connection conex�o) {
		this.conex�o = conex�o;
	}

	public void inserirAluno(Aluno aln) {

		PreparedStatement ps;

		try {

			for (int i = 0; i < aln.getBoletim().getDisciplinas().size(); i++) {

				String sql = "insert into aluno (Aluno, Matr�cula, Disciplina, nota1, nota2, nota3, nota4, M�dia, Situa��o) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
				ps = this.conex�o.prepareStatement(sql);

				ps.setString(1, aln.getNome());
				ps.setString(2, aln.getMatricula());

				ps.setString(3, aln.getBoletim().getDisciplinas().get(i).getNomeDisc());
				ps.setString(4, String.valueOf(aln.getBoletim().getDisciplinas().get(i).getNotas()[0]));
				ps.setString(5, String.valueOf(aln.getBoletim().getDisciplinas().get(i).getNotas()[1]));
				ps.setString(6, String.valueOf(aln.getBoletim().getDisciplinas().get(i).getNotas()[2]));
				ps.setString(7, String.valueOf(aln.getBoletim().getDisciplinas().get(i).getNotas()[3]));
				ps.setString(8, String.valueOf(aln.getBoletim().getDisciplinas().get(i).getMedia_geral()));
				ps.setString(9, String.valueOf(aln.getBoletim().getDisciplinas().get(i).getSituacao()));

				ps.execute();

			}

		} catch (

		SQLException e) {
			e.printStackTrace();
		}

	}

	public ArrayList<DadosAlunoQuery> consultarAluno(String mat) {

		ArrayList<DadosAlunoQuery> infos = new ArrayList<DadosAlunoQuery>();
		String sql = "select * from aluno where Matr�cula = '" + mat + "'";

		try {
			Statement declara��o = conex�o.createStatement();
			ResultSet resposta = declara��o.executeQuery(sql);

			while (resposta.next()) {

				String nome = resposta.getString("Aluno");
				String disc = resposta.getString("Disciplina");
				String nota1 = resposta.getString("nota1");
				String nota2 = resposta.getString("nota2");
				String nota3 = resposta.getString("nota3");
				String nota4 = resposta.getString("nota4");
				String media = resposta.getString("M�dia");
				String situacao = resposta.getString("Situa��o");

				DadosAlunoQuery d = new DadosAlunoQuery(nome, disc, nota1, nota2, nota3, nota4, media, situacao);
				infos.add(d);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return infos;
	}

	public boolean validaAluno(String mat) {

		String sql = "select Matr�cula from aluno where Matr�cula = '" + mat + "'";

		try {
			Statement declara��o = conex�o.createStatement();
			ResultSet resposta = declara��o.executeQuery(sql);
			
			while (resposta.next()) {
				if (resposta.getString("Matr�cula").equals(mat)) {
					return false;
				} 
			}

			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;

	}

	public void apagarTudo() {
		String sql = "delete from produto";

		PreparedStatement ps;

		try {
			ps = this.conex�o.prepareStatement(sql);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

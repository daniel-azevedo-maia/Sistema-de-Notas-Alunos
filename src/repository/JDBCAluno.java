package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import domain.Aluno;

public class JDBCAluno {

	Connection conexao;

	/*
	 * Vamos fazer isso para que, quando criarmos um novo objeto da classe JDBC, na
	 * tela da aplicação (visão), criarmos passando um objeto da classe Conexão,
	 * para poder fazer as operações.
	 */
	public JDBCAluno(Connection conexao) {
		this.conexao = conexao;
	}

	public void inserirAluno(Aluno aln) {
		System.out.println("Método inserirAluno chamado."); // Verificar se o método está sendo executado
		PreparedStatement ps;

		try {
			for (int i = 0; i < aln.getBoletim().getDisciplinas().size(); i++) {
				System.out.println("Inserindo disciplina: " + aln.getBoletim().getDisciplinas().get(i).getNomeDisc());

				String sql = "INSERT INTO Aluno (nome, matricula, disciplina, nota1, nota2, nota3, nota4, media, situacao) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
				ps = this.conexao.prepareStatement(sql);

				// Debug dos valores
				System.out.println("Dados sendo inseridos: ");
				System.out.println("Nome: " + aln.getNome());
				System.out.println("Matrícula: " + aln.getMatricula());
				System.out.println("Disciplina: " + aln.getBoletim().getDisciplinas().get(i).getNomeDisc());
				System.out.println("Notas: " + aln.getBoletim().getDisciplinas().get(i).getNotas()[0] + ", "
						+ aln.getBoletim().getDisciplinas().get(i).getNotas()[1] + ", "
						+ aln.getBoletim().getDisciplinas().get(i).getNotas()[2] + ", "
						+ aln.getBoletim().getDisciplinas().get(i).getNotas()[3]);
				System.out.println("Média: " + aln.getBoletim().getDisciplinas().get(i).getMedia_geral());
				System.out.println("Situação: " + aln.getBoletim().getDisciplinas().get(i).getSituacao());

				ps.setString(1, aln.getNome());
				ps.setString(2, aln.getMatricula());
				ps.setString(3, aln.getBoletim().getDisciplinas().get(i).getNomeDisc());
				ps.setDouble(4, aln.getBoletim().getDisciplinas().get(i).getNotas()[0]);
				ps.setDouble(5, aln.getBoletim().getDisciplinas().get(i).getNotas()[1]);
				ps.setDouble(6, aln.getBoletim().getDisciplinas().get(i).getNotas()[2]);
				ps.setDouble(7, aln.getBoletim().getDisciplinas().get(i).getNotas()[3]);
				ps.setDouble(8, aln.getBoletim().getDisciplinas().get(i).getMedia_geral());
				ps.setString(9, aln.getBoletim().getDisciplinas().get(i).getSituacao());

				System.out.println("Query preparada: " + ps.toString()); // Mostra a query preparada

				ps.execute();
			}
		} catch (SQLException e) {
			System.out.println("Erro ao inserir no banco: " + e.getMessage());
			e.printStackTrace();
		}
	}


	public ArrayList<DadosAlunoQuery> consultarAluno(String mat) {

		ArrayList<DadosAlunoQuery> infos = new ArrayList<DadosAlunoQuery>();
		String sql = "select * from aluno where matricula = '" + mat + "'";

		try {
			Statement declaracao = conexao.createStatement();
			ResultSet resposta = declaracao.executeQuery(sql);

			while (resposta.next()) {

				String nome = resposta.getString("Aluno");
				String disc = resposta.getString("Disciplina");
				String nota1 = resposta.getString("nota1");
				String nota2 = resposta.getString("nota2");
				String nota3 = resposta.getString("nota3");
				String nota4 = resposta.getString("nota4");
				String media = resposta.getString("Média");
				String situacao = resposta.getString("Situação");

				DadosAlunoQuery d = new DadosAlunoQuery(nome, disc, nota1, nota2, nota3, nota4, media, situacao);
				infos.add(d);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return infos;
	}

	public static String formatQuery(String query, Object... params) {
		for (Object param : params) {
			query = query.replaceFirst("\\?", param instanceof String ? "'" + param + "'" : param.toString());
		}
		return query;
	}


	public boolean validaAluno(String mat) {

		String sql = "select Matricula from aluno where Matricula = '" + mat + "'";

		try {
			Statement declaracao = conexao.createStatement();
			ResultSet resposta = declaracao.executeQuery(sql);
			
			while (resposta.next()) {
				if (resposta.getString("Matricula").equals(mat)) {
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
			ps = this.conexao.prepareStatement(sql);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

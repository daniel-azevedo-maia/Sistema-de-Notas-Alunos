
package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexao {

	private Connection conexao;

	public Connection abrirConexao() {
		System.out.println("Tentando abrir conexão com o banco...");
		String url = "jdbc:mysql://localhost:3306/alunos?useTimezone=true&serverTimezone=UTC";
		String user = "root";
		String password = "root";

		try {
			conexao = DriverManager.getConnection(url, user, password);
			System.out.println("Conexão estabelecida com sucesso.");
		} catch (SQLException e) {
			System.out.println("Erro ao abrir conexão: " + e.getMessage());
			e.printStackTrace();
		}

		return conexao;
	}


	public void fecharConexao() {
		try {
			conexao.close();
		} catch (SQLException ex) {
			Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
		}

	}
}
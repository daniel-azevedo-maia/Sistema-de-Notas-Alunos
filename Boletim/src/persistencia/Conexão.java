
package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexão {

	private Connection conexão;

	// Vai retornar uma conexão:
	public Connection abrirConexão() {
		String url = "jdbc:mysql://localhost:3306/alunos?useTimezone=true&serverTimezone=UTC";
		String user = "root";
		String password = "";

		try {
			conexão = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conexão;
	}

	public void fecharConexão() {
		try {
			conexão.close();
		} catch (SQLException ex) {
			Logger.getLogger(Conexão.class.getName()).log(Level.SEVERE, null, ex);
		}

	}
}
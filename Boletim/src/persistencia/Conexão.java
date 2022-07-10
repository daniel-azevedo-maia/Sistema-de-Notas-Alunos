
package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conex�o {

	private Connection conex�o;

	// Vai retornar uma conex�o:
	public Connection abrirConex�o() {
		String url = "jdbc:mysql://localhost:3306/alunos?useTimezone=true&serverTimezone=UTC";
		String user = "root";
		String password = "";

		try {
			conex�o = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conex�o;
	}

	public void fecharConex�o() {
		try {
			conex�o.close();
		} catch (SQLException ex) {
			Logger.getLogger(Conex�o.class.getName()).log(Level.SEVERE, null, ex);
		}

	}
}
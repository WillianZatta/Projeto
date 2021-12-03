package basico;

import java.sql.Connection;
import java.sql.DriverManager;

public class PostgresConnection {

	private String usuario = "postgres";
	private String senha = "123456";
	private Connection connection;
	
	private Connection getConn() throws Exception{
		try {
			/**
			 * Importação do Driver de conexão com PostgreSQL
			 * Sem isso, não funciona!
			 */
			Class.forName("org.postgresql.Driver");
			String url = "jdbc:postgresql://localhost:5432/sistema";
			connection = DriverManager.
					getConnection(url, usuario, senha);
			return connection;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public Connection getInstance()throws Exception {
		if (connection == null) {
			return getConn();
		}
		return connection;
	}
	
	public void close()throws Exception {
		if (connection != null) {
			connection.close();
		}
	}
}

package jpa;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;



public class test {
//we testin'
	public static void main(String[] args) throws NamingException, SQLException {

		InitialContext ctx = new InitialContext();
		DataSource ds = (DataSource) ctx.lookup("jdbc/DemoJNDI");

		Connection conn = (Connection) ds.getConnection();

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * from Orders LIMIT 1");

			rs = stmt.getResultSet();
			while (rs.next()) {
				System.out.println(rs.getString("CustomerID"));
			}
		} finally {
			conn.close();
		}

	}

}

package jpa;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class test {
//we testin'

	@EJB
	private CustomersFacade CF;

	public static void main(String[] args) throws NamingException, SQLException {
		test t = new test();
		
		for (Customers customer : t.CF.findAll()) {
			System.out.println(customer);
		}
		
		
	}
}

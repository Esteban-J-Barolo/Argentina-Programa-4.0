package Clase14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDeDatos {
	
	private Connection con;
	private Statement cSQL;
	
	public void registrar() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Error en el registro a la BD");
		}
	}
	
	public void conectar() {
		try {
			this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/qatar2022","root","nabetse");
			this.cSQL = con.createStatement();
		} catch (SQLException e) {
			System.out.println("Error en la conección a la BD");
		}
	}
	
	public ResultSet consultar(String consulta) {
		try {
			
			ResultSet resp = this.cSQL.executeQuery(consulta);
			return resp;
		} catch (SQLException e) {
			System.out.println("Error en la consulta a la BD");
		}
		return null;
	}
	
	public void insertar(String consulta) {
		try {
			this.cSQL.executeUpdate(consulta);
		} catch (SQLException e) {
			System.out.println("Error en la inserción a la BD");
		}
	}

}

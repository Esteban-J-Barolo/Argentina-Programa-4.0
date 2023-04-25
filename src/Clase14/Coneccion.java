package Clase14;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Coneccion {

	public static void main(String[] args) {
		BaseDeDatos bd = new BaseDeDatos();
		
		bd.registrar();
		
		bd.conectar();
		
		String consulta = "INSERT INTO Qatar2022.Departamento\r\n"
				+ "VALUES 	('Sistema',33249.59),\r\n"
				+ "	        ('Compras',23254.49),\r\n"
				+ "         ('Logística',30256.33);";
		bd.insertar(consulta);
		
		consulta = "INSERT INTO Qatar2022.Empleado\r\n"
				+ "VALUES 	(1001,'Esteban','Barolo','Argentina','Sistema'),\r\n"
				+ "			(1002,'Juan','Rodriguez','Argentina','Logística'),\r\n"
				+ "        	(1003,'Gabriel','Gimenez','Argentina','Logística');";
		bd.insertar(consulta);
		
		consulta = "UPDATE Qatar2022.Empleado\r\n"
				+ "SET nacionalidad='Brasil' WHERE dni=1001;";
		bd.insertar(consulta);
		
		consulta = "DELETE FROM Qatar2022.Departamento\r\n"
				+ "WHERE tipo='Compras';";
		bd.insertar(consulta);
		
			
		consulta = "SELECT nombre, apellido FROM Qatar2022.Empleado em WHERE em.departamento='Logística';";
		ResultSet resp = bd.consultar(consulta);
		try {
			while(resp.next()) System.out.println(resp.getString(1)+"\t"+resp.getString(2));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		consulta = "SELECT *	FROM Qatar2022.Departamento dep ORDER BY  1 ASC;";
		resp = bd.consultar(consulta);
		try {
			while(resp.next()) System.out.println(resp.getString(1)+"\t"+resp.getDouble(2));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

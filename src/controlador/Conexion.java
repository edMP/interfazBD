package controlador;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class Conexion {
	
	public Conexion() {
		
	}
	/*
	 * metodo que devuelve la conexion a la base de datos
	 * 
	 */
	private static Connection conect=null; 

	public  Connection conect() throws SQLException, ClassNotFoundException {

		// objeto de conecciont igualado a null para darle balor posterior mente
		 
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// url de la base de datos
			conect = DriverManager.getConnection("jdbc:mysql://localhost:3306/tienda", "root", "");
			
		} catch (SQLException ex) {
            throw new SQLException(ex);
        } catch (ClassNotFoundException ex) {
            throw new ClassCastException(ex.getMessage());
        }
		return conect;
	}
	
	public   void Dicsconnect() throws SQLException{
		if(conect!=null) {
			conect.close();
		}
		
	}

	
}

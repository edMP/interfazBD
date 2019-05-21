package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import modelo.Users;
import vista.Admin;
import vista.Employes;

public class Services_users {
	private final String table_users = "users";

	public Services_users() {

	}
	List<Users> users;

	Conexion conn;
	Connection conect;

	public void save_user(Users Users) throws SQLException, ClassNotFoundException {
		conn = new Conexion();
		conect = conn.conect();
		try {
			PreparedStatement query;
			if (Users.getNum_employ() == null) {
				query = conect.prepareStatement("INSERT INTO" + this.table_users
						+ "(num,DNI,name,password,sales,tipe) VALUES(?,?,?,?,?,?,?)");
				query.setString(1, Users.getDni());
				query.setString(2, Users.getName());
				query.setString(3, Users.getPassword());
				query.setInt(4, Users.getSales());
				query.setInt(5, Users.getType());

			} else {
				query = conect.prepareStatement("UPDATE" + this.table_users
						+ "SET DNI=?,name=?,password=?,sales=?,tipe=? WHERE num_employ=?");

				query.setString(1, Users.getDni());
				query.setString(2, Users.getName());
				query.setString(3, Users.getPassword());
				query.setInt(4, Users.getSales());
				query.setInt(5, Users.getType());
				query.setInt(6, Users.getNum_employ());
			}
			query.executeQuery();

		} catch (SQLException e) {
			throw new SQLException(e);
		}
	}

	public List<Users> all() throws SQLException, ClassNotFoundException {
		conn = new Conexion();
		conect = conn.conect();
		 users = new ArrayList<>();
		try {
			PreparedStatement query = conect
					.prepareStatement("SELECT * FROM " + this.table_users + " ORDER BY num_employ");
			ResultSet result = query.executeQuery();
			while (result.next()) {
				users.add(new Users(result.getInt("num_employ"), result.getString("DNI"), result.getString("name"),
						result.getString("password"), result.getInt("sale"), 
						result.getInt("type")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	public void erase(Users users) throws SQLException, ClassNotFoundException {
		conn = new Conexion();
		conect = conn.conect();
		try {
			PreparedStatement query = conect
					.prepareStatement("DELETE FROM" + this.table_users + "WHERE num_employes=?");
			query.setInt(1, users.getNum_employ());
			query.executeQuery();

		} catch (SQLException e) {
			throw new SQLException(e);
		}

	}

	public void check_users(String DNI, String password) throws ClassNotFoundException, SQLException {
		 all();
		for (Users user : users) {
			if (user.getDni().equals(DNI) && user.getPassword().equals(password)) {

				if (user.getType() == 0) {
					Admin ad = new Admin(user, users);
				}
				if (user.getType() == 1) {

					Employes em = new Employes(user);

				} if(user.getType()>1){
					JOptionPane.showMessageDialog(null,"unknown role","ALERT", JOptionPane.WARNING_MESSAGE);
				}if(user.getType()<0) {
					JOptionPane.showMessageDialog(null,"unknown role","ALERT", JOptionPane.WARNING_MESSAGE);
				}

			}
		}

	}

}

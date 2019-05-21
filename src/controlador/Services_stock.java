package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Stock;

public class Services_stock {
	private final String table_stock = "Stock";
	
	public Services_stock() {
		
	}
	List<Stock>stock;
	Conexion conn;

	Connection conect;

	public void save_stock( Stock Stock) throws SQLException, ClassNotFoundException {
		conn= new Conexion();
		conect=conn.conect();
		try {
			PreparedStatement query;
			if (Stock.getId() == null) {

				query = conect.prepareStatement(
						"INSERT INTO" + this.table_stock + "(name,description,quantity,price) VALUES(?,?,?,?)");
				query.setString(1, Stock.getName());
				query.setInt(2, Stock.getQuantity());
				query.setFloat(3, Stock.getPrice());
			} else {
				query = conect.prepareStatement(
						"UPDATE" + this.table_stock + "SET name=?,description=?,quantity=?,price=? WHERE id=?");
				query.setString(1, Stock.getName());
				query.setInt(2, Stock.getQuantity());
				query.setFloat(3, Stock.getPrice());
				query.setInt(4, Stock.getId());

			}

		} catch (SQLException e) {
			throw new SQLException(e);
		}

	}

	public List<Stock> all() throws SQLException, ClassNotFoundException {
		conn= new Conexion();
		conect=conn.conect();
		stock = new ArrayList<>();
		try {
			PreparedStatement query = conect.prepareStatement("SELECT * FROM " + this.table_stock + " ORDER BY id");
			ResultSet result = query.executeQuery();
			while (result.next()) {
				stock.add(new Stock(result.getInt("id"), result.getString("name"), 
						result.getInt("quantity"), result.getFloat("price")));
			}
		} catch (SQLException e) {
			throw new SQLException(e);
		}
		return stock;
	}

	public void erase( Stock stock) throws SQLException, ClassNotFoundException {
		conn= new Conexion();
		conect=conn.conect();
		try {
			PreparedStatement query = conect.prepareStatement("DELETE FROM" + this.table_stock + "WHERE ID=?");
			query.setInt(1, stock.getId());
			query.executeQuery();
		} catch (SQLException e) {
			throw new SQLException(e);
		}

	}

}

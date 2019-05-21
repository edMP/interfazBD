package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import controlador.Services_stock;
import controlador.Services_users;
import modelo.Stock;
import modelo.Users;

public class Admin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel jp, jp2, jp3;
	JLabel jl1, jl2, jl3;
	JButton jb1;
	JTabbedPane dial1;
	JTable tab, tab2;
	JScrollPane scp;

	public Admin(Users user, List<Users> users) throws ClassNotFoundException, SQLException {
		super("Admin");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setSize(500, 500);
		this.setLocationRelativeTo(null);
		components(users);
		
	}

	public void components(List<Users> users) throws ClassNotFoundException, SQLException {
		Services_stock sc=new Services_stock();
		sc.all();

		dial1 = new JTabbedPane();

		jp = new JPanel();
		jp.setLayout(null);
		jl1 = new JLabel("esta es la pestanna1 ");
		jl1.setBounds(10, 0, 200, 20);

		jp2 = new JPanel();
		jp2.setLayout(null);
		jl2 = new JLabel("esta es la  pestanna 2");
		jl2.setBounds(10, 0, 200, 20);

		jp3 = new JPanel();
		jp3.setLayout(null);
		jl3 = new JLabel("esta es la pestanna 3");
		jl3.setBounds(10, 0, 200, 20);

		DefaultTableModel model = new DefaultTableModel();

		tab = new JTable(model);
		JTableHeader th = tab.getTableHeader();

		model.addColumn("num employes");
		model.addColumn("name ");
		model.addColumn("sale ");

		Object O[][] = null;
		for (int i = 0; i < users.size(); i++) {
			model.addRow(O);
			Users usuario = (Users) users.get(i);
			model.setValueAt(usuario.getNum_employ(), i, 0);
			model.setValueAt(usuario.getName(), i, 1);
			model.setValueAt(usuario.getSales(), i, 2);
		}

		tab.setBounds(10, 30, 500, 200);
		
		
		
		DefaultTableModel model_stock = new DefaultTableModel();

		tab2 = new JTable(model_stock);
		JTableHeader thstock = tab2.getTableHeader();

		model_stock.addColumn("id");
		model_stock.addColumn("name ");
		model_stock.addColumn("quantity ");
		model_stock.addColumn("price ");

		Object L[][] = null;
		for (int x = 0; x < sc.all().size(); x++) {
			model_stock.addRow(L);
			Stock stock = (Stock)sc.all().get(x);
			model_stock.setValueAt(stock.getId(), x, 0);
			model_stock.setValueAt(stock.getName(), x, 1);
			model_stock.setValueAt(stock.getQuantity(), x, 2);
			model_stock.setValueAt(stock.getPrice(), x, 2);
			
		}
		
		jb1=new JButton("erase");
		jb1.setBounds(300, 400, 100,30);
		
		
		
		
		
		
		jp.add(jb1);
		tab2.setBounds(10, 30, 500, 200);

//		jp.add(scp);
//		jp.add(tab);
		
		jp.add(tab);

		tab.add(th);
		jp.add(jl1);
		tab2.add(thstock);
		jp2.add(tab2);
		jp2.add(jl2);
		jp3.add(jl3);

		dial1.addTab("Users", jp);
		dial1.addTab("Stock", jp2);
		dial1.addTab("grafica", jp3);
		add(dial1);
		setVisible(true);

	}

	protected Services_users Services_users() {
		// TODO Auto-generated method stub
		return null;
	}

}

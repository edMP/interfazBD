package vista;

import java.awt.Color;
import java.awt.Font;
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
import modelo.Stock;
import modelo.Users;

public class Employes extends JFrame {
	 	
	JPanel jp,jp2;
	JLabel jl1,jl2,jl3;
	JButton jb1;
	JTabbedPane dial1;
	JTable tab;
	JScrollPane scp;
	
		public Employes(Users user) throws ClassNotFoundException, SQLException {
			
			
			super("employes");
			this.setLayout(null);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
			this.setResizable(false);
			this.setSize(500,600);
			this.setLocationRelativeTo(null);
			components(user);
		}
			
			public void components(Users user) throws ClassNotFoundException, SQLException {
				Services_stock sc=new Services_stock();
				sc.all();
			
			JPanel jp=new JPanel();
			jp.setLayout(null);
			jp.setSize(this.getWidth(),this.getHeight());
			
			
			
			jp2=new JPanel();
			jp2.setBounds(30, 10, 100, 150);
			jp2.setBackground(Color.red);
			jp2.setVisible(true);
			
			Font f=new Font("Elephant",1,25);
			
			jl1=new JLabel("User: "+user.getName());
			jl1.setBounds(150, 15, 300, 100);
			jl1.setFont(f);
			
			jl2=new JLabel("Nº: "+user.getNum_employ());
			jl2.setBounds(150,40,100,100);
			jl2.setFont(f);
			
			jl3=new JLabel("Sales: "+user.getSales());
			jl3.setBounds(150, 65, 300, 100);
			jl3.setFont(f);
			
			jb1=new JButton("sale");
			jb1.setBounds(300, 500, 100,30);
			
			DefaultTableModel model_stock = new DefaultTableModel();

			tab = new JTable(model_stock);
			JTableHeader thstock = tab.getTableHeader();

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

			tab.setBounds(10, 300, 500, 200);
			jp.add(tab);
			jp.add(jb1);
			jp.add(jl3);
			jp.add(jl2);
			jp.add(jl1);
			jp.add(jp2);
			this.add(jp);
			this.setVisible(true);
			
	 }

}

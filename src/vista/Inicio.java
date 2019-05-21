package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controlador.Services_users;

public class Inicio extends JFrame implements ActionListener{
	JFrame jf1;
	JTextField jt;
	JLabel jl1,jl2;
	JPasswordField jps;
	JPanel jp;
	JButton jb1;
	JButton jb2;
	
	public Inicio() {
		jf1=new JFrame("inicio");
		jf1.setSize(400,200);
		jf1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf1.setResizable(false);
		jf1.setLayout(null);
		jf1.setLocationRelativeTo(null);
		
		jp=new JPanel();
		jp.setSize(jf1.getWidth(),jf1.getHeight());
		jp.setLayout(null);
		
			
		jl1=new JLabel("DNI: ");
		jl1.setBounds(50,40,100,30);
		
		jt=new JTextField();
		jt.setBounds( 120, 40, 150, 30);
		
		
		jl2=new JLabel("password: ");
		jl2.setBounds(55,80,100,30);
		
		jps=new JPasswordField("Texto oculto");
		jps.setBounds(120, 80, 150, 30);
		
		jb1=new JButton("login");
		jb1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Services_users su=new Services_users();
				try {
					su.check_users(jt.getText(), new String(jps.getPassword()));
					
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					
					e1.printStackTrace();
				}
				
			}
				
		});

		
		jb1.setBounds(120, 120, 100, 30);
		
		jp.add(jb1);
		jp.add(jps);
		jp.add(jl2);
		jp.add(jt);	
		jp.add(jl1);
		jf1.add(jp);
		jf1.setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("hola");
		
	}

}

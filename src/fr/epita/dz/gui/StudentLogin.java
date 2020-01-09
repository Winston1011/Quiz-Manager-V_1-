package fr.epita.dz.gui;

import javax.swing.JFrame;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class StudentLogin extends JFrame {
	 
	    
	public StudentLogin() { 
		setSize(400,260);
		JLabel a=new JLabel("User"); 
		JLabel b=new JLabel("Password");
		JTextField c=new JTextField(15);
		JPasswordField d=new JPasswordField(15);
		d.setEchoChar('*');
		JButton e=new JButton("Login");
		JButton f=new JButton("Reset");
		JButton g=new JButton("Register");
		setVisible(true);
		Container dz=getContentPane();
		dz.add(a);
		dz.add(b);
		dz.add(c);
		dz.add(d);
		dz.add(e);
		dz.add(f);
		dz.add(g);
		setBounds(400,400,400,250);
		dz.setLayout(null);

		a.setBounds(70,40,80,22);
		b.setBounds(70,80,80,22);
		c.setBounds(130,40,200,22);
		d.setBounds(130,80,200,22);
		e.setBounds(165,140,90,30);
		f.setBounds(55,140,90,30);
		g.setBounds(265,140,90,30);
		
		f.addActionListener(new ActionListener() {
 
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				c.setText("");
				d.setText("");
			}
			
		});
		e.addActionListener(new ActionListener() {
			 
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				if(c.getText().trim().equals("Winston")&&new String(d.getPassword()).equals("110150")) {
					JOptionPane.showMessageDialog(null,"Login Success");
					new MainFrame();
					
				}else {
					JOptionPane.showMessageDialog(null, "Login Failed");
				}
			}	
		});
		g.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new StudentRegister();
			}
			
		});

		
	}
		public static void main(String[] args) {
			new StudentLogin();
			
		}
		
	}





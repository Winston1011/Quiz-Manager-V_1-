package fr.epita.dz.gui;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class StudentRegister extends JFrame {
	public StudentRegister() {
		setSize(400,250);
		JLabel a=new JLabel("User"); 
		JLabel b=new JLabel("Password");
		JLabel D1=new JLabel("Reassure Password");
		JTextField c=new JTextField(15);
		JPasswordField d=new JPasswordField(15);
//		JPasswordField D=new JPasswordField(15);
		d.setEchoChar('.');
//		D.setEchoChar('.');
		JButton e=new JButton("Register");
		JButton f=new JButton("Reset");
		JButton g=new JButton("Back");
		setVisible(true);
		Container dz=getContentPane();
		dz.add(a);
		dz.add(b);
		dz.add(c);
		dz.add(d);
		dz.add(e);
		dz.add(f);
		dz.add(g);
//		dz.add(D);
		setBounds(400,400,400,250);
		dz.setLayout(null);
		a.setBounds(70,40,80,22);
		b.setBounds(70,80,80,22);
		c.setBounds(130,40,200,22);
		d.setBounds(130,80,200,22);
		e.setBounds(165,140,80,30);
		f.setBounds(55,140,80,30);
		g.setBounds(265,140,80,30);
		g.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new StudentLogin();
				
			}
			
		});
	}

}



package frame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.beans.Statement;
import java.sql.*;

import frame.check;
import db.DB;

import javax.swing.*;

import com.sun.corba.se.pept.transport.Connection;
import com.sun.glass.events.WindowEvent;
import com.sun.javafx.font.Disposer;
import com.sun.org.apache.xml.internal.security.Init;

public class frame {
	static JFrame frame = new JFrame();
	static JPanel panel = new JPanel();
	public static void main(String args[]) {
		framee(true);
//		frame.addWindowListener(new CloseHandler());
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
//	public static class CloseHandler extends WindowAdapter{
//		public void windowClosing(WindowEvent e){
//			System.out.println("asd");
//			System.exit(0);
//		}
//	}
	public static void framee (boolean flag){
		JButton button = new JButton();
		final JTextField username = new JTextField();
		JTextArea usernameArea = new JTextArea();
		final JTextField password = new JTextField();
		JTextArea passwordArea = new JTextArea();
		
		button.setText("登录");
		usernameArea.setText("用户名");
		usernameArea.setEditable(false);
		usernameArea.setBackground(null);
		passwordArea.setText("密码");
		passwordArea.setEditable(false);
		passwordArea.setBackground(null);
		
		button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				check.click(username.getText(),password.getText());
			}
		});
		if (flag){
			panel.add(username);
			panel.add(password);
			panel.add(button);
			panel.add(usernameArea);
			panel.add(passwordArea);
			panel.setLayout(null);
			
			usernameArea.setBounds(60,30,50,20);
			//                  
			passwordArea.setBounds(60,130,30,20);
			username.setBounds(60,60,100,20);
			password.setBounds(60,160,100,20);
			button.setBounds(200,160,100,20);
		}
		else {
			JLabel label = new JLabel();
			label.setText("登录成功");
			panel.removeAll();
			panel.add(label);
			panel.setLayout(null);
			panel.repaint();
			label.setBounds(150,100,100,50);
			label.setBackground(null);
		}
		
		frame.getContentPane().add(panel);
		frame.setSize(400,300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(new WindowAdapter(){
			public void windowClosing(java.awt.event.WindowEvent e){
				file.deletefile();
				System.exit(0);
			}
		});
	}
	public static void init(){
		
	}
	public static void login(){
		framee(false);
	}
}


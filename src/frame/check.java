package frame;

import java.beans.Statement;
import java.sql.*;

import javax.swing.*;

import com.sun.corba.se.pept.transport.Connection;

import db.*;

public class check {
	public static void click(String username,String password){
		java.sql.Connection conn = DB.getConn();
		java.sql.Statement stmt = DB.getStatement(conn);
		String sql = "select * from userinfo where username = '"+username+"'";
		ResultSet rs = DB.getResultSet(stmt, sql);
		boolean flag = false;
		try {
			if(!rs.next()) {
				JOptionPane.showMessageDialog(null, "�û�������", "��ʾ", JOptionPane.ERROR_MESSAGE);
				System.out.println("�û�������2:");
				flag = false;
			} else {
				if(!password.equals(rs.getString("password"))) {
					JOptionPane.showMessageDialog(null, "�������", "��ʾ", JOptionPane.ERROR_MESSAGE);
					System.out.println("���벻��ȷ:");
					flag = false;
				} else
				if (!rs.getString("status").equals("1")){
					JOptionPane.showMessageDialog(null, "�û�����", "��ʾ", JOptionPane.ERROR_MESSAGE);
					System.out.println("�û�����");
					flag = false;
				}
				else
				{flag = true;
				
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.close(conn);
			DB.close(stmt);
			DB.close(rs);
		}
		if (flag){
			file.createfile();
			frame.login();
		}
	}
}

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
				JOptionPane.showMessageDialog(null, "用户不存在", "提示", JOptionPane.ERROR_MESSAGE);
				System.out.println("用户不存在2:");
				flag = false;
			} else {
				if(!password.equals(rs.getString("password"))) {
					JOptionPane.showMessageDialog(null, "密码错误", "提示", JOptionPane.ERROR_MESSAGE);
					System.out.println("密码不正确:");
					flag = false;
				} else
				if (!rs.getString("status").equals("1")){
					JOptionPane.showMessageDialog(null, "用户过期", "提示", JOptionPane.ERROR_MESSAGE);
					System.out.println("用户过期");
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

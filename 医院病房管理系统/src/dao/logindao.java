package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import containt.containt;

public class Logindao {
	Connection conn = null;

//	 链接数据库
		public Logindao(){
			containt ct = new containt();
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection(ct.url, ct.username, ct.password);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
	


		// 登录用户
		public boolean userlogin(String id, String password) {
			
			PreparedStatement ps;
			try {
			ps = conn.prepareStatement("select * from user where id=? and password=?");
			ps.setString(1, id);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				//后期删除
				return true;
			}else {
				//后期删除
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "数据库链接失败", "提示信息", JOptionPane.WARNING_MESSAGE);
			return false;
		}

	}

}

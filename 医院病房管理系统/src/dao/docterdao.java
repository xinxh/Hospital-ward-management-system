package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import containt.containt;
import javabean.docterb;

public class docterdao {
	Connection conn = null;

//	 链接数据库
	public docterdao() {
		containt ct = new containt();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(ct.url, ct.username, ct.password);
			System.out.println("ok");
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("fail");
			e.printStackTrace();
		}
	}

//查询医生
	public void seedocter() {
		PreparedStatement ps;
		docterb dob= new docterb();
		try {
			JOptionPane.showMessageDialog(null, "数据库链接成功", "提示信息", JOptionPane.WARNING_MESSAGE);
			ps = conn.prepareStatement("select * from docter where dno=?");
			System.out.println(dob.getDno());
			ps.setString(1, dob.getDno());
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				
				JOptionPane.showMessageDialog(null, "有这个人", "提示信息", JOptionPane.WARNING_MESSAGE);
				
			} else {
				JOptionPane.showMessageDialog(null, "没这个人", "提示信息", JOptionPane.WARNING_MESSAGE);

			}
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "数据库链接失败", "提示信息", JOptionPane.WARNING_MESSAGE);
			
		}
	}
}

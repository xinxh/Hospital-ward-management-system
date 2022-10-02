package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
import containt.containt;
import javabean.Doctor;
import javabean.Office;

public class Doctordao {
	Connection conn = null;

//	 链接数据库
	public Doctordao() {
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

//医生个人信息查询（普通）
	public void seedoctor(JTextField dname, JTextField dage, JTextField career, String dno) {
		PreparedStatement ps;
		try {
			if(conn==null) {
				JOptionPane.showMessageDialog(null, "数据库链接失败!", "提示信息", JOptionPane.WARNING_MESSAGE);
			}else {
				JOptionPane.showMessageDialog(null, "数据库链接成功", "提示信息", JOptionPane.WARNING_MESSAGE);
			}

			ps = conn.prepareStatement("select * from doctor where dno=?");
			ps.setString(1, dno);
			ResultSet rs = ps.executeQuery();

			if (rs.next()==true) {
				JOptionPane.showMessageDialog(null, "有这个人", "提示信息", JOptionPane.WARNING_MESSAGE);
				dname.setText(rs.getString("Dname"));
				dage.setText(rs.getString("Dage"));
				career.setText(rs.getString("Career"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "查询失败", "提示信息", JOptionPane.WARNING_MESSAGE);
		}
	}


//添加医生
	public void DoctorInsert(Doctor doctor, Office office) {
		PreparedStatement ps;
		PreparedStatement ps1;//查询科室号
		try {
				ps1 = conn.prepareStatement("select * from office where Oname=?");//查询科室号
				ps1.setString(1, office.getOname());
				ResultSet rs1 = ps1.executeQuery();
					ps = conn.prepareStatement("insert into doctor(Dno,Dname,Dsex,Dage,Career,Contact,Ono) values(?,?,?,?,?,?,?)");
					ps.setString(1, doctor.getDno());
					ps.setString(2, doctor.getDname());
					ps.setString(3, doctor.getDsex());
					ps.setString(4, doctor.getDage());
					ps.setString(5, doctor.getCareer());
					ps.setString(6, doctor.getContact());
					while (rs1.next()) {
						ps.setString(7, rs1.getString("Ono"));
					}
				ps.execute();
			JOptionPane.showMessageDialog(null, "插入成功", "提示信息", JOptionPane.WARNING_MESSAGE);
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "插入失败", "提示信息", JOptionPane.WARNING_MESSAGE);
		}
	}




//信息更改_医生

}

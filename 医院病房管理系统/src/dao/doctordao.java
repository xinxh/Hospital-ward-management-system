package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
import containt.containt;
import javabean.doctorb;

public class doctordao {
	Connection conn = null;

//	 链接数据库
	public doctordao() {
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

//医生查询
	public doctorb seedoctor(JTextPane dname,JTextPane dage,JComboBox dsex,JTextPane contact,JTextPane career,JComboBox dono,String dno) {
		PreparedStatement ps;
		doctorb db = new doctorb();
		try {
			if(conn==null) {
				JOptionPane.showMessageDialog(null, "数据库链接失败!", "提示信息", JOptionPane.WARNING_MESSAGE);
			}else {
				JOptionPane.showMessageDialog(null, "数据库链接成功", "提示信息", JOptionPane.WARNING_MESSAGE);
			}

			ps = conn.prepareStatement("select * from doctor where dno=?");
			System.out.println(dno);
			ps.setString(1, dno);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()==true) {
				JOptionPane.showMessageDialog(null, "有这个人", "提示信息", JOptionPane.WARNING_MESSAGE);
				dname.setText(rs.getString("Dname"));
				dsex.removeAllItems();
				dsex.addItem(rs.getString("Dsex"));
				dage.setText(rs.getString("Dage"));
				career.setText(rs.getString("Career"));
				contact.setText(rs.getString("Contact"));
				String ono = rs.getString("Ono");
				//设置第二个下拉框
				ps = conn.prepareStatement("select * from office where ono=?");
				ps.setString(1, ono);
				ResultSet result = ps.executeQuery();

				dono.removeAllItems();//移除默认的一些下拉选项
				while (result.next()){
					dono.addItem(result.getString("Oname"));
				}
			} else {
				JOptionPane.showMessageDialog(null, "没这个人", "提示信息", JOptionPane.WARNING_MESSAGE);
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "查询失败", "提示信息", JOptionPane.WARNING_MESSAGE);
		}
		return null;
	}
//病人查询
    public void seepatient(JTextField pname, JTextField page, JComboBox psex, JTextField sicken, JTextField surplus, JTextField dname_p, JTextField nname_p, String pno) {
		PreparedStatement ps;
		doctorb db = new doctorb();
		try {
			if(conn==null) {
				JOptionPane.showMessageDialog(null, "数据库链接失败!", "提示信息", JOptionPane.WARNING_MESSAGE);
			}else {
				JOptionPane.showMessageDialog(null, "数据库链接成功", "提示信息", JOptionPane.WARNING_MESSAGE);
			}
			ps = conn.prepareStatement("select * from doctor where pno=?");
			System.out.println(pno);
			ps.setString(1, pno);
			ResultSet rs = ps.executeQuery();

			if (rs.next()==true) {
				JOptionPane.showMessageDialog(null, "有这个人", "提示信息", JOptionPane.WARNING_MESSAGE);
				pname.setText(rs.getString("Pname"));
				page.setText(rs.getString("Page"));
				psex.removeAllItems();
				psex.addItem(rs.getString("Psex"));
				sicken.setText(rs.getString("Sicken"));
				surplus.setText(rs.getString("Surplus"));
				dname_p.setText(rs.getString("Dname_p"));
				nname_p.setText(rs.getString("Nname_p"));
			}
		}catch (Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "查询失败", "提示信息", JOptionPane.WARNING_MESSAGE);
		}
    }
//护士查询
	public void seepatient(JTextPane nname, JTextPane nage, JComboBox nsex, JTextPane contact, JTextPane career, JComboBox nono, String nno) {
		PreparedStatement ps;
		doctorb db = new doctorb();
		try {
			if(conn==null) {
				JOptionPane.showMessageDialog(null, "数据库链接失败!", "提示信息", JOptionPane.WARNING_MESSAGE);
			}else {
				JOptionPane.showMessageDialog(null, "数据库链接成功", "提示信息", JOptionPane.WARNING_MESSAGE);
			}
			ps = conn.prepareStatement("select * from doctor where nno=?");
			System.out.println(nno);
			ps.setString(1, nno);
			ResultSet rs = ps.executeQuery();

			if (rs.next()==true) {
				JOptionPane.showMessageDialog(null, "有这个人", "提示信息", JOptionPane.WARNING_MESSAGE);
				nname.setText(rs.getString("Pname"));
				nage.setText(rs.getString("Page"));
				nsex.removeAllItems();
				nsex.addItem(rs.getString("Psex"));
				contact.setText(rs.getString("Sicken"));
				career.setText(rs.getString("Surplus"));
				String ono = rs.getString("Ono");
				//设置第二个下拉框
				ps = conn.prepareStatement("select * from office where ono=?");
				ps.setString(1, ono);
				ResultSet result = ps.executeQuery();
				nono.removeAllItems();//移除默认的一些下拉选项
				while (result.next()){
					nono.addItem(result.getString("Oname"));
				}
			}
		}catch (Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "查询失败", "提示信息", JOptionPane.WARNING_MESSAGE);
		}
	}





}

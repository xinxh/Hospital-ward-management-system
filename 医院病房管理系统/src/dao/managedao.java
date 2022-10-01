package dao;

import containt.containt;
import javabean.doctorb;
import javax.swing.*;
import java.sql.*;
import java.time.Clock;

public class managedao {
    Connection conn = null;

    //	 链接数据库
    public managedao() {
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
    public doctorb seedoctor(JTextPane dname, JTextPane dage, JComboBox dsex, JTextPane contact, JTextPane career, JComboBox dono, String dno) {
        PreparedStatement ps;
        try {
            if(conn==null) {
                JOptionPane.showMessageDialog(null, "数据库链接失败!", "提示信息", JOptionPane.WARNING_MESSAGE);
            }else {
                JOptionPane.showMessageDialog(null, "数据库链接成功", "提示信息", JOptionPane.WARNING_MESSAGE);
            }

            ps = conn.prepareStatement("select * from doctor where dno=?");
            System.out.println("医生编号"+dno);
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

                //设置第二个下拉框
                String ono = rs.getString("Ono");
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
        try {
            if(conn==null) {
                JOptionPane.showMessageDialog(null, "数据库链接失败!", "提示信息", JOptionPane.WARNING_MESSAGE);
            }else {
                JOptionPane.showMessageDialog(null, "数据库链接成功", "提示信息", JOptionPane.WARNING_MESSAGE);
            }
            ps = conn.prepareStatement("select * from patient where pno=?");
            ps.setString(1, pno);
            ResultSet rs = ps.executeQuery();

            if (rs.next()==true) {
                JOptionPane.showMessageDialog(null, "有这个人", "提示信息", JOptionPane.WARNING_MESSAGE);
                pname.setText(rs.getString("Pname"));
                page.setText(rs.getString("Page"));
                psex.removeAllItems();
                psex.addItem(rs.getString("Psex"));
                sicken.setText(rs.getString("Sicken"));
                //查询第二个表
                String dno = rs.getString("Dno");
                ps = conn.prepareStatement("select * from doctor where dno=?");
                ps.setString(1, dno);
                ResultSet rs2 = ps.executeQuery();
                while (rs2.next()){//主治医生名
                    dname_p.setText(rs2.getString("Dname"));
                }
                //查询第三个表
                String nno = rs.getString("Nno");
                ps = conn.prepareStatement("select * from nurse where nno=?");
                ps.setString(1, nno);
                ResultSet rs3 = ps.executeQuery();
                while (rs3.next()){//责任护士名
                    nname_p.setText(rs3.getString("Nname"));
                }
                //查询第四个表
                ps = conn.prepareStatement("select * from surplus where pno=?");
                ps.setString(1, pno);
                ResultSet rs4 = ps.executeQuery();
                if (rs4.next()==false){
                    surplus.setText("");//清空余额
                }else {
                    while (rs4.next()) {//查询余额
                        surplus.setText(rs4.getString("Surplus"));//余额
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "查询失败", "提示信息", JOptionPane.WARNING_MESSAGE);
        }
    }
    //护士查询
    public void seepatient(JTextPane nname, JTextPane nage, JComboBox nsex, JTextPane ncontact, JTextPane ncareer, String nno) {
        PreparedStatement ps;
        try {
            if(conn==null) {
                JOptionPane.showMessageDialog(null, "数据库链接失败!", "提示信息", JOptionPane.WARNING_MESSAGE);
            }else {
                JOptionPane.showMessageDialog(null, "数据库链接成功", "提示信息", JOptionPane.WARNING_MESSAGE);
            }
            ps = conn.prepareStatement("select * from nurse where nno=?");
            System.out.println("护士编号"+nno);
            ps.setString(1, nno);
            ResultSet rs = ps.executeQuery();

            if (rs.next()==true) {
                JOptionPane.showMessageDialog(null, "有这个人", "提示信息", JOptionPane.WARNING_MESSAGE);
                nname.setText(rs.getString("Nname"));
                nage.setText(rs.getString("Nage"));
                nsex.removeAllItems();
                nsex.addItem(rs.getString("Nsex"));
                ncontact.setText(rs.getString("Contact"));
                ncareer.setText(rs.getString("Career"));
            }
        }catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "查询失败", "提示信息", JOptionPane.WARNING_MESSAGE);
        }
    }






}

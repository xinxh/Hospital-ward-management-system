package dao;

import containt.containt;
import javabean.Mark;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;


public class Managedao {
    static Connection conn = null;

    //链接数据库
    public Managedao() {
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
    public void seedoctor(JTextPane dname, JTextPane dage, JComboBox dsex, JTextPane contact, JTextPane career, JComboBox dono, String dno) {
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
                    dono.addItem(result.getString("Oname"));//设置科室名称
                }
            } else {
                JOptionPane.showMessageDialog(null, "没这个人", "提示信息", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "查询失败", "提示信息", JOptionPane.WARNING_MESSAGE);
        }
    }

    //删除医生
    public void deletedoctor(String doctorno) {
        PreparedStatement ps;
        try {
            if(conn==null) {
                JOptionPane.showMessageDialog(null, "数据库链接失败!", "提示信息", JOptionPane.WARNING_MESSAGE);
            }else {
                JOptionPane.showMessageDialog(null, "数据库链接成功", "提示信息", JOptionPane.WARNING_MESSAGE);
            }
            ps = conn.prepareStatement("delete from doctor where dno=?");
            ps.setString(1, doctorno);
            int a= JOptionPane.showConfirmDialog(null, "确定要删除吗？", "提示信息", JOptionPane.YES_NO_OPTION);
            if (a==JOptionPane.YES_NO_OPTION){
                ps.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "删除失败", "提示信息", JOptionPane.WARNING_MESSAGE);
        }
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
                    while (rs4.next()) {//查询余额
                        surplus.setText("");//清空余额
                        surplus.setText(rs4.getString("Surplus"));//余额
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "查询失败", "提示信息", JOptionPane.WARNING_MESSAGE);
        }
    }

    //删除病人
    public void deletepatient(String doctorno) {
        PreparedStatement ps;
        try {
            if(conn==null) {
                JOptionPane.showMessageDialog(null, "数据库链接失败!", "提示信息", JOptionPane.WARNING_MESSAGE);
            }else {
                JOptionPane.showMessageDialog(null, "数据库链接成功", "提示信息", JOptionPane.WARNING_MESSAGE);
            }
            ps = conn.prepareStatement("delete from patient where pno=?");
            ps.setString(1, doctorno);
            int a= JOptionPane.showConfirmDialog(null, "确定要删除吗？", "提示信息", JOptionPane.YES_NO_OPTION);
            if (a==JOptionPane.YES_NO_OPTION){
                ps.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "删除失败", "提示信息", JOptionPane.WARNING_MESSAGE);
        }
    }


    //护士查询
    public void seenurse(JTextPane nname, JTextPane nage, JComboBox nsex, JTextPane ncontact, JTextPane ncareer, String nno) {
        PreparedStatement ps;
        try {
            if(conn==null) {
                JOptionPane.showMessageDialog(null, "数据库链接失败!", "提示信息", JOptionPane.WARNING_MESSAGE);
            }else {
                JOptionPane.showMessageDialog(null, "数据库链接成功", "提示信息", JOptionPane.WARNING_MESSAGE);
            }
            ps = conn.prepareStatement("select * from nurse where nno=?");
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

    //删除护士
    public void deletenurse(String nurseno) {
        PreparedStatement ps;
        try {
            if(conn==null) {
                JOptionPane.showMessageDialog(null, "数据库链接失败!", "提示信息", JOptionPane.WARNING_MESSAGE);
            }else {
                JOptionPane.showMessageDialog(null, "数据库链接成功", "提示信息", JOptionPane.WARNING_MESSAGE);
            }
            ps = conn.prepareStatement("delete from nurse where nno=?");
            ps.setString(1, nurseno);
            int a= JOptionPane.showConfirmDialog(null, "确定要删除吗？", "提示信息", JOptionPane.YES_NO_OPTION);
            if (a==JOptionPane.YES_NO_OPTION){
                ps.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "删除失败", "提示信息", JOptionPane.WARNING_MESSAGE);
        }
    }


    //病房号查寻
    public static ArrayList<Mark> room(){
        PreparedStatement ps;
        ArrayList<Mark> arr = new ArrayList<>();
        try  {
            ps = conn.prepareStatement("select mno from mark ");
            ResultSet resultSet = ps.executeQuery();
            while(resultSet.next()){
                Mark mark = new Mark();
                mark.setMno(resultSet.getString("Mno"));
                arr.add(mark);
            }
        }
        catch  (SQLException  e)  {
            e.printStackTrace();
        }
        return arr;
    }

    //病床删除
    public void deletebed(String mno_b, String mno_m) {
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("delete from bed where bno=?");
            String bno = mno_m+"-" + mno_b;
            ps.setString(1, bno);
            int a= JOptionPane.showConfirmDialog(null, "确定要删除吗？", "提示信息", JOptionPane.YES_NO_OPTION);
            if (a==JOptionPane.YES_NO_OPTION){
                ps.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "删除失败", "提示信息", JOptionPane.WARNING_MESSAGE);
        }
    }

    //病房删除
    public void deleteroom(String mno_m) {
            PreparedStatement ps;
            PreparedStatement ps1;
            try {
                int a= JOptionPane.showConfirmDialog(null, "确定要删除吗？", "提示信息", JOptionPane.YES_NO_OPTION);
                if (a==JOptionPane.YES_NO_OPTION){
                    ps = conn.prepareStatement("delete from bed where bno=?");//先删病床
                    String bno1= mno_m+"-1";
                    ps.setString(1, bno1);
                    ps.executeUpdate();
                    String bno2= mno_m+"-2";
                    ps = conn.prepareStatement("delete from bed where bno=?");//先删病床
                    ps.setString(1, bno2);
                    ps.executeUpdate();
                    String bno3= mno_m+"-3";
                    ps = conn.prepareStatement("delete from bed where bno=?");//先删病床
                    ps.setString(1, bno3);
                    ps.executeUpdate();
                    String bno4= mno_m+"-4";
                    ps = conn.prepareStatement("delete from bed where bno=?");//先删病床
                    ps.setString(1, bno4);
                    ps.executeUpdate();

                    ps1 = conn.prepareStatement("delete from mark where mno=?");//再删病房
                    ps1.setString(1, mno_m);
                    ps1.executeUpdate();
                }
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "删除失败", "提示信息", JOptionPane.WARNING_MESSAGE);
            }


    }




}

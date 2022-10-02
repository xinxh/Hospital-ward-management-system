package dao;

import containt.containt;

import javax.swing.*;
import java.sql.*;

public class Patientdao {
    Connection conn = null;
    //	 链接数据库
    public Patientdao() {
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

//患者查询个人信息
public void seepatient(JTextField pname, JTextField page, JTextField surplus, JTextField dname_p, JTextField nname_p, JTextField sickroom, JTextArea cure, String pno) {
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
            String mno=rs.getString("Mno");
            String bno= rs.getString("Bno");
            sickroom.setText(mno+"号房 "+bno+"号床");
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
                    surplus.setText(rs4.getString("Surplus"));//余额
            }
            //查询第五个表
            ps = conn.prepareStatement("select * from cure where pno=?");
            ps.setString(1, pno);
            ResultSet rs5 = ps.executeQuery();
                while (rs5.next()) {//查询治疗方案
                    cure.setText(rs5.getString("Cname"));//治疗方案名字
            }
        }
    }catch (Exception e){
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "查询失败", "提示信息", JOptionPane.WARNING_MESSAGE);
    }
    }

//余额缴费
public void Balance_payment(JTextField pname, JTextField surplus, JTextField sickroom, JTextField pno, String patientno) {
    PreparedStatement ps;
    try {
        if(conn==null) {
            JOptionPane.showMessageDialog(null, "数据库链接失败!", "提示信息", JOptionPane.WARNING_MESSAGE);
        }else {
            JOptionPane.showMessageDialog(null, "数据库链接成功", "提示信息", JOptionPane.WARNING_MESSAGE);
        }
        ps = conn.prepareStatement("select * from patient where pno=?");
        ps.setString(1, patientno);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            JOptionPane.showMessageDialog(null, "欢迎进入缴费界面", "提示信息", JOptionPane.WARNING_MESSAGE);
            pno.setText(patientno);
            pname.setText(rs.getString("Pname"));
            String mno=rs.getString("Mno");
            String bno= rs.getString("Bno");
            sickroom.setText(mno+"号房 "+bno+"号床");
            //查询第四个表
            ps = conn.prepareStatement("select * from surplus where pno=?");
            ps.setString(1, patientno);
            ResultSet rs1 = ps.executeQuery();
            while (rs1.next()) {//查询余额
                surplus.setText(rs1.getString("Surplus"));//余额
            }
        }
    }catch (Exception e){
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "查询失败", "提示信息", JOptionPane.WARNING_MESSAGE);
    }
}

//新增病人
    public void PatientInsert(String addpno, String addpname, String addpage, String addnname, String adddname,String adddsicken, String addpsex, String addmno, String addbed) {
        PreparedStatement ps;
        try {

            ps = conn.prepareStatement("insert into patient(Pno,Pname,Psex,Mno,Page,Bno,Dno,Nno,Sicken) values(?,?,?,?,?,?,?,?,?)");
            ps.setString(1, addpno);
            ps.setString(2, addpname);
            ps.setString(3, addpsex);
            ps.setString(4, addmno);//
            ps.setString(5, addpage);
            String sick = addmno+ "-" +addbed;
            ps.setString(6, sick);//
            ps.setString(7, adddname);//
            ps.setString(8, addnname);//
            ps.setString(9, adddsicken);

            ps.execute();

            JOptionPane.showMessageDialog(null, "插入成功", "提示信息", JOptionPane.WARNING_MESSAGE);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "插入失败", "提示信息", JOptionPane.WARNING_MESSAGE);
        }
    }


}

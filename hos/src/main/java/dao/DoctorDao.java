package dao;

import containt.contains;
import javabean.DoctorB;
import javabean.OfficeB;

import javax.swing.*;
import java.sql.*;

public class DoctorDao {
    Connection conn = null;

    //	 链接数据库
    public DoctorDao() {
        contains ct = new contains();
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
            ps = conn.prepareStatement("select * from doctor where dno=?");
            ps.setString(1, dno);
            ResultSet rs = ps.executeQuery();

            if (rs.next() == true) {
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
    public void DoctorInsert(DoctorB doctorb, OfficeB officeb) {
        PreparedStatement ps;
        PreparedStatement ps1;//查询科室号
        try {
            ps1 = conn.prepareStatement("select * from office where Oname=?");//查询科室号
            ps1.setString(1, officeb.getOname());
            ResultSet rs1 = ps1.executeQuery();
            ps = conn.prepareStatement("insert into doctor(Dno,Dname,Dsex,Dage,Career,Contact,Ono) values(?,?,?,?,?,?,?)");
            ps.setString(1, doctorb.getDno());
            ps.setString(2, doctorb.getDname());
            ps.setString(3, doctorb.getDsex());
            ps.setString(4, doctorb.getDage());
            ps.setString(5, doctorb.getCareer());
            ps.setString(6, doctorb.getContact());
            while (rs1.next()) {
                ps.setString(7, rs1.getString("Ono"));
            }
            ps.execute();
            JOptionPane.showMessageDialog(null, "插入成功", "提示信息", JOptionPane.WARNING_MESSAGE);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "插入失败,请检查后重试", "提示信息", JOptionPane.WARNING_MESSAGE);
        }
    }

    //医生的排班表格
    public void show(Object doctor[][]) {
        try {
            PreparedStatement ps = conn.prepareStatement("select * from doctor");

            ResultSet rs = ps.executeQuery();

            int count = 0;
            while (rs.next()) {
                doctor[count][0] = rs.getString("Dno");
                doctor[count][1] = rs.getString("Dname");
                doctor[count][2] = rs.getString("Dsex");
                doctor[count][3] = rs.getString("Career");
                doctor[count][4] = rs.getString("Contact");
                PreparedStatement ps1 = conn.prepareStatement("select * from doctor_scheduling where dno_scheduling=?");
                ps1.setString(1,rs.getString("Dno"));
                ResultSet rs1 = ps1.executeQuery();
                    while (rs1.next()) {
                        if (rs1.getString("Dno_scheduling").equals(rs.getString("Dno"))){
                            doctor[count][5] = rs1.getString("Time");
                        }
                    }
                count++;
            }


        } catch (SQLException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
    }

    //医生的患者表格
    public void show(Object doctor_p[][], String doctorno) {
        try {
            PreparedStatement ps1 = conn.prepareStatement("select * from patient where dno=?");
            ps1.setString(1, doctorno);
            ResultSet rs1 = ps1.executeQuery();

            int count = 0;
            while (rs1.next()) {
                doctor_p[count][0] = rs1.getString("Pno");
                doctor_p[count][1] = rs1.getString("Pname");
                doctor_p[count][2] = rs1.getString("Psex");
                doctor_p[count][3] = rs1.getString("Sicken");

                PreparedStatement ps2 = conn.prepareStatement("select * from cure where pno=?");
                ps2.setString(1, rs1.getString("Pno"));
                ResultSet rs2 = ps2.executeQuery();
                while (rs2.next()) {
                    doctor_p[count][4] = rs2.getString("Cname");
                }
                count++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //诊断结束
    public void deletepatient(DoctorB doctorB) {
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("update patient set dno=? where pno=?");
            ps.setString(2, doctorB.getPno_d());
            ps.setString(1, "");
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "结束成功", "提示信息", JOptionPane.WARNING_MESSAGE);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "结束失败", "提示信息", JOptionPane.WARNING_MESSAGE);

        }
    }

    //更改治疗方案
    public void updatecure(DoctorB db1) {
        PreparedStatement ps;
        PreparedStatement ps1;

        try {
            ps1 = conn.prepareStatement("select * from cure where pno=?");
            ps1.setString(1,db1.getPno_d1());
            ResultSet rs= ps1.executeQuery();
            if (rs.next()==true){
                ps = conn.prepareStatement("update cure set cname=? where pno=?");
                ps.setString(2, db1.getPno_d1());
                ps.setString(1, db1.getCure_d());
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "更改成功", "提示信息", JOptionPane.WARNING_MESSAGE);

            }else{
                JOptionPane.showMessageDialog(null, "没有此人", "提示信息", JOptionPane.WARNING_MESSAGE);

            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "更改失败", "提示信息", JOptionPane.WARNING_MESSAGE);

        }
    }
}

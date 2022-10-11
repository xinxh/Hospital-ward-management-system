package dao;

import containt.contains;
import javabean.PatientB;

import javax.swing.*;
import java.sql.*;

public class PatientDao {
    Connection conn = null;

    //	 链接数据库
    public PatientDao() {
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

    //患者查询个人信息
    public PatientB seepatient(JTextField pname, JTextField page, JTextField surplus, JTextField dname_p, JTextField nname_p, JTextField sickroom, JTextArea cure, String pno) {
        PreparedStatement ps;
        PatientB patientB = new PatientB();
        patientB.setPno_c(pno);
        try {
            ps = conn.prepareStatement("select * from patient where pno=?");
            ps.setString(1, patientB.getPno_c());
            ResultSet rs = ps.executeQuery();
            if (rs.next() == true) {
                patientB.setPname_c(rs.getString("Pname"));
                pname.setText(patientB.getPname_c());
                patientB.setPage_c(rs.getString("Page"));
                page.setText(patientB.getPage_c());
                patientB.setMon_c(rs.getString("Mno"));
                patientB.setBno_c(rs.getString("Bno"));
                sickroom.setText(patientB.getMon_c() + "房 " + patientB.getBno_c() + "床");
                //查询第二个表

                String dno = rs.getString("Dno");
                ps = conn.prepareStatement("select * from doctor where dno=?");
                ps.setString(1, dno);
                ResultSet rs2 = ps.executeQuery();
                while (rs2.next()) {//主治医生名
                    dname_p.setText(rs2.getString("Dname"));
                }
                //查询第三个表
                String nno = rs.getString("Nno");
                ps = conn.prepareStatement("select * from nurse where nno=?");
                ps.setString(1, nno);
                ResultSet rs3 = ps.executeQuery();
                while (rs3.next()) {//责任护士名
                    nname_p.setText(rs3.getString("Nname"));
                }
                //查询第四个表
                ps = conn.prepareStatement("select * from surplus where pno=?");
                ps.setString(1, pno);
                ResultSet rs4 = ps.executeQuery();
                while (rs4.next()) {//查询余额
                    patientB.setSurplus_c(rs4.getString("Surplus"));
                    surplus.setText(patientB.getSurplus_c());//余额
                }
                //查询第五个表
                ps = conn.prepareStatement("select * from cure where pno=?");
                ps.setString(1, pno);
                ResultSet rs5 = ps.executeQuery();
                while (rs5.next()) {//查询治疗方案
                    cure.setText(rs5.getString("Cname"));//治疗方案名字
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "查询失败", "提示信息", JOptionPane.WARNING_MESSAGE);
        }
        return patientB;
    }

    //新增病人
    public void PatientInsert(PatientB pb) {
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("insert into patient(Pno,Pname,Psex,Mno,Page,Bno,Dno,Nno,Sicken) values(?,?,?,?,?,?,?,?,?)");
            ps.setString(1, pb.getPno_add());
            ps.setString(2, pb.getPname_add());
            ps.setString(3, pb.getPsex_add());
            ps.setString(4, pb.getMno_add());//
            ps.setString(5, pb.getPage_add());
            String sick = pb.getMno_add() + "-" + pb.getBed_add();
            ps.setString(6, sick);//
            ps.setString(7, pb.getDname_add());//
            ps.setString(8, pb.getNname_add());//
            ps.setString(9, pb.getCure_add());

            ps.execute();

            JOptionPane.showMessageDialog(null, "插入成功", "提示信息", JOptionPane.WARNING_MESSAGE);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "插入失败,请检查后重试", "提示信息", JOptionPane.WARNING_MESSAGE);
        }
    }


    //添加余额
    public void newsurplusZ(PatientB pat) {
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("select surplus from surplus  where pno=?");
            ps.setString(1, pat.getPno_c());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String su = rs.getString("surplus");
                String newsu = pat.getNewsurplus_c();
                int su_jiu = Integer.parseInt(su);
                int su_new = Integer.parseInt(newsu);
                int surplus = su_jiu + su_new;
                String nn = String.valueOf(surplus);
                ps = conn.prepareStatement("update surplus set surplus=? where pno=?");
                ps.setString(1, nn);
                ps.setString(2, pat.getPno_c());
                ps.execute();
            }
            JOptionPane.showMessageDialog(null, "缴费成功", "提示信息", JOptionPane.WARNING_MESSAGE);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "缴费失败,请检查后重试", "提示信息", JOptionPane.WARNING_MESSAGE);
        }
    }

}

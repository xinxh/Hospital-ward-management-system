package dao;

import containt.contains;
import javabean.SickRoomB;

import javax.swing.*;
import java.sql.*;

public class SickroomDao {
    Connection conn = null;

    //	 链接数据库
    public SickroomDao() {
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

    //病房添加
    public void SickroomInsert(SickRoomB sickRoomb) {
        PreparedStatement ps;
        PreparedStatement ps1;
        try {
            ps = conn.prepareStatement("insert ignore into mark(Mno,Mname) values(?,?)");
            ps.setString(1, sickRoomb.getMno());
            ps.setString(2, sickRoomb.getMname());
            ps.execute();
            ps1 = conn.prepareStatement("insert into bed(Bno,Mno,Status) values(?,?,?)");
            String bno = sickRoomb.getMno() + "-" + sickRoomb.getNno();
            ps1.setString(1, bno);
            ps1.setString(2, sickRoomb.getMno());
            ps1.setString(3, sickRoomb.getStatus());
            ps1.execute();
            JOptionPane.showMessageDialog(null, "插入成功", "提示信息", JOptionPane.WARNING_MESSAGE);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, ",请检查后重试", "提示信息", JOptionPane.WARNING_MESSAGE);
        }
    }

    //病床表格
    public void show(Object info[][]) {
        try {
            PreparedStatement ps = conn.prepareStatement("select * from bed");
            ResultSet rs = ps.executeQuery();
            int count = 0;
            while (rs.next()) {
                info[count][0] = rs.getString("Mno");
                info[count][1] = rs.getString("Bno");
                info[count][2] = rs.getString("Status");
                count++;
            }
        } catch (SQLException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
    }

    //病人的出入院表格
    public void showpatient(Object[][] patient) {
        try {
            PreparedStatement ps = conn.prepareStatement("select * from patient");//列出病人的表（7）行
            ResultSet rs = ps.executeQuery();
            int count = 0;
            while (rs.next()) {
                patient[count][0] = rs.getString("Pno");
                patient[count][1] = rs.getString("Pname");
                patient[count][2] = rs.getString("Psex");
                patient[count][3] = rs.getString("Page");
                patient[count][4] = rs.getString("Sicken");
                patient[count][5] = rs.getString("Mno");
                patient[count][6] = rs.getString("Bno");

                count++;
            }


        } catch (SQLException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
    }

    //病人出院
    public void delete(SickRoomB sb) {
        try {
            PreparedStatement ps = conn.prepareStatement("select bno from patient where pno=?");//查找病人的床位好
            ps.setString(1, sb.getPno_room());
            ResultSet rs = ps.executeQuery();
            while (rs.next() == true) {
                PreparedStatement ps1 = conn.prepareStatement("update bed set status=? where bno=?");//更新床位状态
                ps1.setString(1, "未分配");
                ps1.setString(2, rs.getString("Bno"));
                ps1.executeUpdate();
            }
            PreparedStatement ps2 = conn.prepareStatement("update patient set mno=?,bno=? where pno=?");//更新病人信息
            ps2.setString(1, " ");
            ps2.setString(2, " ");
            ps2.setString(3, sb.getPno_room());
            ps2.executeUpdate();
//
            JOptionPane.showMessageDialog(null, "已出院", "提示信息", JOptionPane.WARNING_MESSAGE);

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "修改失败", "提示信息", JOptionPane.WARNING_MESSAGE);

        }
    }

    //病人住院
    public void join(SickRoomB sb) {
        try {
            PreparedStatement ps1 = conn.prepareStatement("update bed set status=? where bno=?");//更新床位状态
            ps1.setString(1, "已分配");
            ps1.setString(2, sb.getNno_room());
            ps1.executeUpdate();

            PreparedStatement ps2 = conn.prepareStatement("update patient set mno=?,bno=?");//插入病房信息
            ps2.setString(1, sb.getMno_room());
            ps2.setString(2, sb.getNno_room());
            ps2.executeUpdate();
            JOptionPane.showMessageDialog(null, "已住院", "提示信息", JOptionPane.WARNING_MESSAGE);

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "修改失败", "提示信息", JOptionPane.WARNING_MESSAGE);

        }
    }

    //病床表-住院部
    public void showsickroom(Object[][] room) {
        try {
            PreparedStatement ps2 = conn.prepareStatement("select * from bed");//列出病人的表（7）行
            ResultSet rs2 = ps2.executeQuery();
            int count = 0;
            while (rs2.next()) {
                room[count][0] = rs2.getString("Mno");
                room[count][1] = rs2.getString("Bno");
                room[count][2] = rs2.getString("Status");
                count++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

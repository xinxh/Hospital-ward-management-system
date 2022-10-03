package dao;

import containt.containt;

import javax.swing.*;
import java.sql.*;

public class NurseDao {
    //	 链接数据库
    Connection conn = null;
    public NurseDao() {
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

//添加护士
    public void NurseInsert(String addnno, String addnname, String addnage, String addncareer, String adddmno_n, String addncontact, String addnsex) {
       PreparedStatement ps;
            try {
                ps = conn.prepareStatement("insert into nurse(Nno,Nname,Nsex,Mno,Nage,Contact,Career) values(?,?,?,?,?,?,?)");
                ps.setString(1, addnno);
                ps.setString(2, addnname);
                ps.setString(3, addnsex);
                ps.setString(4, adddmno_n);
                ps.setString(5, addnage);
                ps.setString(6, addncontact);
                ps.setString(7, addncareer);
                ps.execute();

                JOptionPane.showMessageDialog(null, "插入成功", "提示信息", JOptionPane.WARNING_MESSAGE);
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "插入失败", "提示信息", JOptionPane.WARNING_MESSAGE);
            }


    }

    //护士排班表格
    public void show(Object nurse[][]) {
        try {
            PreparedStatement ps=conn.prepareStatement("select * from nurse");
            PreparedStatement ps1=conn.prepareStatement("select * from nurse_scheduling");
            ResultSet rs=ps.executeQuery();
            ResultSet rs1=ps1.executeQuery();
            int count=0;
            while(rs.next()) {
                nurse[count][0]=rs.getString("Nno");
                nurse[count][1]=rs.getString("Nname");
                nurse[count][2]=rs.getString("Nsex");
                nurse[count][3]=rs.getString("Contact");
                count++;
            }
            count=0;
            while(rs1.next()) {
                nurse[count][4]=rs1.getString("Time");
                count++;
            }
        } catch (SQLException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
    }



}

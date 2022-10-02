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

//删除护士


//信息更改_护士


}

package dao;

import containt.contains;
import javabean.LoginB;

import javax.swing.*;
import java.sql.*;

public class LoginDao {
    Connection conn = null;

    //	 链接数据库
    public LoginDao() {
        contains ct = new contains();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(ct.url, ct.username, ct.password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }


    //选择登录用户
    public LoginB userlogin1(String id, String password) {
        PreparedStatement ps;
        LoginB ld = new LoginB();
        try {
            //管理员
            ps = conn.prepareStatement("select * from user where id=? and password=?");
            ps.setString(1, id);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String a = rs.getString("id");
                if (a.contains("root")) {
                    ld.setAdmin("1");
                } else if (a.contains("d")) {
                    ld.setDoctor("1");
                } else if (a.contains("p")) {
                    ld.setPatient("1");
                } else if (a.contains("n")) {
                    ld.setNurse("1");
                }

            } else {
                JOptionPane.showMessageDialog(null, "用户名或者密码错误", "提示信息", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "数据库链接失败", "提示信息", JOptionPane.WARNING_MESSAGE);

        }
        return ld;
    }

}

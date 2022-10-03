package dao;

import containt.containt;
import javabean.SickRoom;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Sickroomdao {
    Connection conn = null;

    //	 链接数据库
    public Sickroomdao() {
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

//病房添加
public void SickroomInsert(SickRoom sickRoom){
        PreparedStatement ps;
        PreparedStatement ps1;
        try {
            ps = conn.prepareStatement("insert ignore into mark(Mno,Mname) values(?,?)");
            ps.setString(1, sickRoom.getMno());
            ps.setString(2, sickRoom.getMname());
            ps.execute();
            ps1 = conn.prepareStatement("insert into bed(Bno,Mno,Status) values(?,?,?)");
            String bno = sickRoom.getMno()+ "-" + sickRoom.getNno();
            ps1.setString(1, bno);
            ps1.setString(2, sickRoom.getMno());
            ps1.setString(3, sickRoom.getStatus());
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
			PreparedStatement ps=conn.prepareStatement("select * from bed");
			ResultSet rs=ps.executeQuery();
			int count=0;
			while(rs.next()) {
				info[count][0]=rs.getString("Mno");
				info[count][1]=rs.getString("Bno");
				info[count][2]=rs.getString("Status");
				count++;
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
    }


}

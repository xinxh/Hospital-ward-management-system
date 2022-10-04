package dao;

import containt.contains;
import javabean.DoctorB;
import javabean.MarkB;
import javabean.NurseB;
import javabean.PatientB;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

@SuppressWarnings("all")
public class ManageDao {

    static Connection conn = null;

    //链接数据库
    public ManageDao() {

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


    ////////////////////////////////////////////
    //医生姓名列表
    public static ArrayList<MarkB> doctor() {
        PreparedStatement ps;
        ArrayList<MarkB> arr = new ArrayList<>();
        try {
            ps = conn.prepareStatement("select dname from doctor ");
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                MarkB markb = new MarkB();
                markb.setDname(resultSet.getString("Dname"));
                arr.add(markb);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arr;
    }

    //医生查询
    public void seedoctor(JTextPane dname, JTextPane dage, JComboBox dsex, JTextPane contact, JTextPane career, JComboBox dono, DoctorB doctorb) {
        //todo 判断有无这个人
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("select * from doctor where dno=?");
            ps.setString(1, doctorb.getDno());
            ResultSet rs = ps.executeQuery();
            if (rs.next() == true) {
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
                while (result.next()) {
                    String[] department = new String[]{"内科", "外科", "妇科", "儿科", "辅助检查科室", "精神科", "五官科", "肛肠科"};
                    //添加组件内容
                    dono.addItem(result.getString("Oname"));//设置科室名称
                    for (int i = 0; i < department.length; i++) {
                        dono.addItem(department[i]);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "没有该用户", "提示信息", JOptionPane.WARNING_MESSAGE);


            }

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    //删除医生
    public void deletedoctor(DoctorB doctorno) {

        PreparedStatement ps;
        PreparedStatement ps8;//查询有没有该用户
        try {
            ps8 = conn.prepareStatement("select * from doctor where dno=?");
            ps8.setString(1, doctorno.getDno());
            ResultSet rs8 = ps8.executeQuery();
            if (rs8.next() == true) {
                ps = conn.prepareStatement("delete from doctor where dno=?");
                ps.setString(1, doctorno.getDno());
                int a = JOptionPane.showConfirmDialog(null, "确定要删除吗？", "提示信息", JOptionPane.YES_NO_OPTION);
                if (a == JOptionPane.YES_NO_OPTION) {
                    ps.executeUpdate();
                }

                JOptionPane.showMessageDialog(null, "删除成功", "提示信息", JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "没有该用户", "提示信息", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "删除失败", "提示信息", JOptionPane.WARNING_MESSAGE);

        }
    }

    //医生信息更改
    public void update_doctor(JTextPane dname, JTextPane dage, JComboBox dsex, JTextPane contact, JTextPane career, JComboBox dono, DoctorB doctorb) {
        dname.setText(doctorb.getDname_g());
        dsex.removeAllItems();
        dsex.addItem(doctorb.getDsex_g());
        dage.setText(doctorb.getDage_g());
        career.setText(doctorb.getCareer_g());
        contact.setText(doctorb.getContact_g());
        dono.addItem(doctorb.getDno_g());//设置科室名称

        PreparedStatement ps;
        PreparedStatement ps1;//查询科室号
        PreparedStatement ps2;//更新外界
        try {
            ps1 = conn.prepareStatement("select * from office where Oname=?");//查询科室号
            ps1.setString(1, doctorb.getDono_g());
            ResultSet rs1 = ps1.executeQuery();

            ps2 = conn.prepareStatement("update doctor_scheduling set Dname_scheduling=? where Dno_scheduling=?");//更新外界
            ps2.setString(1, doctorb.getDname_g());
            ps2.setString(2, doctorb.getDno_g());
            System.out.println(doctorb.getDno());
            System.out.println(doctorb.getDno_g());
            ps2.executeUpdate();

            ps = conn.prepareStatement("update doctor set Dname=?,Dsex=?,Dage=?,Career=?,Contact=?,Ono=? where Dno=?");
            ps.setString(1, doctorb.getDname_g());
            ps.setString(2, doctorb.getDsex_g());
            ps.setString(3, doctorb.getDage_g());
            ps.setString(4, doctorb.getCareer_g());
            ps.setString(5, doctorb.getContact_g());
            ps.setString(7, doctorb.getDno_g());
            while (rs1.next()) {
                ps.setString(6, rs1.getString("Ono"));
            }
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "插入成功", "提示信息", JOptionPane.WARNING_MESSAGE);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "插入失败,请检查后重试,请检查后重试", "提示信息", JOptionPane.WARNING_MESSAGE);
        }
    }


    //////////////////////////////////////////////////
    //病人查询
    public void seepatient(JTextField pname, JTextField page, JComboBox psex, JTextField sicken, JTextField surplus, JComboBox dname_p, JComboBox nname_p, String pno) {

        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("select * from patient where pno=?");
            ps.setString(1, pno);
            ResultSet rs = ps.executeQuery();

            if (rs.next() == true) {
                pname.setText(rs.getString("Pname"));
                page.setText(rs.getString("Page"));
                psex.removeAllItems();
                psex.addItem(rs.getString("Psex"));
                psex.addItem("男");
                psex.addItem("女");

                sicken.setText(rs.getString("Sicken"));
                //查询第二个表
                String dno = rs.getString("Dno");
                ps = conn.prepareStatement("select * from doctor where dno=?");
                ps.setString(1, dno);
                ResultSet rs2 = ps.executeQuery();
                dname_p.removeAllItems();
                while (rs2.next()) {//主治医生名
                    dname_p.addItem(rs2.getString("Dname"));
                    String[] dname = new String[]{"张三", "张四", "张五", "王三", "王四", "王五"
                            , "李三", "李四", "张五", "赵三", "赵四", "赵五", "高三", "高四", "高五"};
                    //添加组件内容
                    for (int i = 0; i < dname.length; i++) {
                        dname_p.addItem(dname[i]);
                    }
                }

                //查询第三个表
                nname_p.removeAllItems();//移除默认的一些下拉选项
                String nno = rs.getString("Nno");
                ps = conn.prepareStatement("select * from nurse where nno=?");
                ps.setString(1, nno);
                ResultSet rs3 = ps.executeQuery();
                while (rs3.next()) {//责任护士名
                    nname_p.addItem(rs3.getString("Nname"));
                    String[] nname = new String[]{"张三", "张二", "小麦", "小红", "小王", "小猪",
                            "小扎", "小店", "小明", "小马", "小美", "小猫", "小东", "夏普", "达到",
                            "张高", "张发", "张但", "张补", "张胡"};
                    //添加组件内容
                    for (int i = 0; i < nname.length; i++) {
                        nname_p.addItem(nname[i]);
                    }
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
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "查询失败", "提示信息", JOptionPane.WARNING_MESSAGE);


        }
    }

    //删除病人
    public void deletepatient(String doctorno) {
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("delete from patient where pno=?");
            ps.setString(1, doctorno);
            int a = JOptionPane.showConfirmDialog(null, "确定要删除吗？", "提示信息", JOptionPane.YES_NO_OPTION);
            if (a == JOptionPane.YES_NO_OPTION) {
                ps.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "删除失败", "提示信息", JOptionPane.WARNING_MESSAGE);
        }
    }

    //病人信息修改
    public void update_patient(PatientB p) {

        PreparedStatement ps;
        PreparedStatement ps1;//更新余额
        PreparedStatement ps2;//设置主治医生名字
        PreparedStatement ps3;//设置责任护士名字
        try {
            ps1 = conn.prepareStatement("update surplus set surplus=?,pname=? where pno=?");//更新余额
            ps1.setString(1, p.getSurplus());
            ps1.setString(2, p.getPname());
            ps1.setString(3, p.getPno());
            ps1.executeUpdate();

            ps2 = conn.prepareStatement("select dno from doctor where dname=?");//设置主治医生名字
            ps2.setString(1, p.getDname_p());
            ResultSet rs2 = ps2.executeQuery();

            ps3 = conn.prepareStatement("select nno from nurse where nname=?");//设置责任护士名字
            ps3.setString(1, p.getNname_p());
            ResultSet rs3 = ps3.executeQuery();

            ps = conn.prepareStatement("update patient set Pname=?,Psex=?,Page=?,Dno=?,Nno=?,Sicken=? where Pno=?");
            ps.setString(1, p.getPname());
            ps.setString(2, p.getPsex());
            ps.setString(3, p.getPage());
            while (rs2.next()) {
                ps.setString(4, rs2.getString("Dno"));
            }
            while (rs3.next()) {
                ps.setString(5, rs3.getString("Nno"));
            }
            ps.setString(6, p.getSicken());
            ps.setString(7, p.getPno());
            ps.executeUpdate();
            /*          */

            JOptionPane.showMessageDialog(null, "插入成功", "提示信息", JOptionPane.WARNING_MESSAGE);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "插入失败,请检查后重试,请检查后重试", "提示信息", JOptionPane.WARNING_MESSAGE);
        }
    }

    ////////////////////////////////////////////////////////////
    //护士查询
    public void seenurse(JTextPane nname, JTextPane nage, JComboBox nsex, JTextPane ncontact, JTextPane ncareer, String nno) {
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("select * from nurse where nno=?");
            ps.setString(1, nno);
            ResultSet rs = ps.executeQuery();

            if (rs.next() == true) {
                nname.setText(rs.getString("Nname"));
                nage.setText(rs.getString("Nage"));
                nsex.removeAllItems();
                nsex.addItem(rs.getString("Nsex"));
                ncontact.setText(rs.getString("Contact"));
                ncareer.setText(rs.getString("Career"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "查询失败", "提示信息", JOptionPane.WARNING_MESSAGE);
        }
    }

    //删除护士
    public void deletenurse(String nurseno) {

        PreparedStatement ps;
        PreparedStatement ps8;//查询有没有该用户
        try {
            ps8 = conn.prepareStatement("select * from nurse where nno=?");
            ps8.setString(1, nurseno);
            ResultSet rs8 = ps8.executeQuery();
            if (rs8.next() == true) {
                ps = conn.prepareStatement("delete from nurse where nno=?");
                ps.setString(1, nurseno);
                int a = JOptionPane.showConfirmDialog(null, "确定要删除吗？", "提示信息", JOptionPane.YES_NO_OPTION);
                if (a == JOptionPane.YES_NO_OPTION) {
                    ps.executeUpdate();
                }


            } else {
                JOptionPane.showMessageDialog(null, "没有该用户", "提示信息", JOptionPane.WARNING_MESSAGE);


            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "删除失败", "提示信息", JOptionPane.WARNING_MESSAGE);


        }
    }

    //护士姓名列表
    public static ArrayList<MarkB> nurse() {
        PreparedStatement ps;
        ArrayList<MarkB> arr = new ArrayList<>();
        try {
            ps = conn.prepareStatement("select nname from nurse ");
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                MarkB markb = new MarkB();
                markb.setNname(resultSet.getString("Nname"));
                arr.add(markb);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arr;
    }

    //护士信息更改
    public void update_nurse(NurseB nurseb) {
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("update nurse set Nname=?,Nsex=?,Nage=?,Contact=?,Career=? where Nno=?");
            ps.setString(1, nurseb.getNname());
            ps.setString(2, nurseb.getNsex());
            ps.setString(3, nurseb.getNage());
            ps.setString(4, nurseb.getContact());
            ps.setString(5, nurseb.getCareer());
            ps.setString(6, nurseb.getNno());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "插入成功", "提示信息", JOptionPane.WARNING_MESSAGE);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "插入失败,请检查后重试,请检查后重试", "提示信息", JOptionPane.WARNING_MESSAGE);
        }
    }

    ////////////////////////////////////////////////////////////////////////////////
    //病房号查寻
    public static ArrayList<MarkB> room() {
        PreparedStatement ps;
        ArrayList<MarkB> arr = new ArrayList<>();
        try {
            ps = conn.prepareStatement("select mno from mark ");
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                MarkB markb = new MarkB();
                markb.setMno(resultSet.getString("Mno"));
                arr.add(markb);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arr;
    }

    //病床删除
    public void deletebed(String mno_b, String mno_m) {

        PreparedStatement ps;

        try {
            ps = conn.prepareStatement("delete from bed where bno=?");
            String bno = mno_m + "-" + mno_b;
            ps.setString(1, bno);
            int a = JOptionPane.showConfirmDialog(null, "确定要删除吗？", "提示信息", JOptionPane.YES_NO_OPTION);
            if (a == JOptionPane.YES_NO_OPTION) {
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
            int a = JOptionPane.showConfirmDialog(null, "确定要删除吗？", "提示信息", JOptionPane.YES_NO_OPTION);
            if (a == JOptionPane.YES_NO_OPTION) {
                ps = conn.prepareStatement("delete from bed where bno=?");//先删病床
                String bno1 = mno_m + "-1";
                ps.setString(1, bno1);
                ps.executeUpdate();
                String bno2 = mno_m + "-2";
                ps = conn.prepareStatement("delete from bed where bno=?");//先删病床
                ps.setString(1, bno2);
                ps.executeUpdate();
                String bno3 = mno_m + "-3";
                ps = conn.prepareStatement("delete from bed where bno=?");//先删病床
                ps.setString(1, bno3);
                ps.executeUpdate();
                String bno4 = mno_m + "-4";
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

    //病房和病床信息更改
    public void update_sickroom(String bno_b, String status_b, String mno_b) {
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("update bed set Status=? where Mno=? and Bno=?");
            String bno = mno_b + "-" + bno_b;
            ps.setString(1, status_b);
            ps.setString(2, mno_b);
            ps.setString(3, bno);


            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "更新成功", "提示信息", JOptionPane.WARNING_MESSAGE);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "更新失败，请检查信息", "提示信息", JOptionPane.WARNING_MESSAGE);
        }
    }


}

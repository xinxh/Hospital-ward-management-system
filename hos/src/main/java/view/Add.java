package view;

import dao.DoctorDao;
import dao.NurseDao;
import dao.PatientDao;
import dao.SickroomDao;
import javabean.DoctorB;
import javabean.OfficeB;
import javabean.PatientB;
import javabean.SickRoomB;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Add extends JFrame {

    private static String text;
    private JComboBox oname_d;
    private JComboBox nsex;
    private JComboBox nono;
    private JComboBox ono_d;
    private JComboBox dsex;
    private JPanel contentPane;
    private JTextField nname_p;
    private JTextField textField_12;
    private JTextField dname;
    private JTextField dno;
    private JTextField dage;
    private JTextField career_d;
    private JTextField contact_d;
    private JTextField nname;
    private JTextField nno;
    private JTextField nage;
    private JTextField ncareer;
    private JTextField ncontact;
    private JTextField mno;
    private JTextField mname;
    private JComboBox bname;
    private JComboBox status;
    private JTextField mno_p;

    /**
     * Create the frame.
     */
    public Add(String text) {
        this.text = text;
    }

    public Add() {
        this(text);
        SickroomDao sk = new SickroomDao();
        DoctorDao dc = new DoctorDao();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setBounds(100, 100, 598, 401);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        String[] department = new String[]{"内科", "外科", "妇科", "儿科", "辅助检查科室", "精神科", "五官科", "肛肠科"};

        // 病人
        JPanel addpatient = new JPanel();
        addpatient.setBounds(0, 0, 581, 361);
        contentPane.add(addpatient);
        addpatient.setLayout(null);
        addpatient.setVisible(false);
        JLabel pnamelabel = new JLabel("姓名");
        pnamelabel.setBounds(357, 27, 40, 15);
        addpatient.add(pnamelabel);

        JLabel pnolabel = new JLabel("病人身份证");
        pnolabel.setBounds(63, 27, 75, 15);
        addpatient.add(pnolabel);

        JLabel pagelabel = new JLabel("年龄");
        pagelabel.setBounds(357, 85, 40, 15);
        addpatient.add(pagelabel);

        JLabel psexlabel = new JLabel("性别");
        psexlabel.setBounds(63, 85, 40, 15);
        addpatient.add(psexlabel);

        JLabel lblNewLabel_4 = new JLabel("患病");
        lblNewLabel_4.setBounds(63, 151, 40, 15);
        addpatient.add(lblNewLabel_4);

        JLabel dnamelabel_p = new JLabel("主治医生");
        dnamelabel_p.setBounds(357, 151, 59, 15);
        addpatient.add(dnamelabel_p);

        JLabel nname_plabel = new JLabel("责任护士");
        nname_plabel.setBounds(357, 210, 59, 15);
        addpatient.add(nname_plabel);

        JTextField pname = new JTextField();
        pname.setBounds(426, 24, 66, 21);
        pname.setColumns(10);
        addpatient.add(pname);

        JTextField pno = new JTextField();
        pno.setBounds(131, 24, 106, 21);
        pno.setColumns(10);
        addpatient.add(pno);

        JTextField page = new JTextField();
        page.setBounds(426, 82, 66, 21);
        page.setColumns(10);
        addpatient.add(page);

        JTextField dname_p = new JTextField();
        dname_p.setBounds(426, 148, 66, 21);
        dname_p.setColumns(10);
        addpatient.add(dname_p);

        nname_p = new JTextField();
        nname_p.setColumns(10);
        nname_p.setBounds(426, 207, 66, 21);
        addpatient.add(nname_p);

        JTextField cure = new JTextField();
        cure.setColumns(10);
        cure.setBounds(131, 148, 66, 21);
        addpatient.add(cure);

        JComboBox psex = new JComboBox();
        psex.setBounds(131, 81, 66, 23);
        addpatient.add(psex);
        psex.addItem("男");
        psex.addItem("女");

        JButton 确认添加_p = new JButton("确认");
        确认添加_p.setBounds(236, 313, 93, 23);
        addpatient.add(确认添加_p);

        JLabel room_p = new JLabel("房间号");
        room_p.setBounds(63, 207, 40, 15);
        addpatient.add(room_p);

        mno_p = new JTextField();
        mno_p.setColumns(10);
        mno_p.setBounds(131, 204, 66, 21);
        addpatient.add(mno_p);

        JLabel bed_p_1 = new JLabel("病床号");
        bed_p_1.setBounds(63, 263, 40, 15);
        addpatient.add(bed_p_1);

        JComboBox bed_p = new JComboBox();
        bed_p.setBounds(132, 259, 66, 23);
        addpatient.add(bed_p);
        bed_p.addItem("1");
        bed_p.addItem("2");
        bed_p.addItem("3");
        bed_p.addItem("4");

        确认添加_p.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 进行输入框判断，为空则不进行登录操作。
                if (pno.getText().isEmpty() || pname.getText().isEmpty() || page.getText().isEmpty()
                        || nname_p.getText().isEmpty() || dname_p.getText().isEmpty() || cure.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "输入的信息有误", "提示信息", JOptionPane.WARNING_MESSAGE);
                } else {

                    PatientB pB = new PatientB();
                    pB.setPno_add(pno.getText());
                    pB.setPname_add(pname.getText());
                    pB.setPage_add(page.getText());
                    pB.setNname_add(nname_p.getText());
                    pB.setDname_add(dname_p.getText());
                    pB.setCure_add(cure.getText());
                    pB.setMno_add(mno_p.getText());
                    pB.setPsex_add(psex.getSelectedItem().toString());
                    pB.setBed_add(bed_p.getSelectedItem().toString());

                    PatientDao pad = new PatientDao();
                    pad.PatientInsert(pB);
                }
            }
        });

        // 护士
        JPanel addnurse = new JPanel();
        contentPane.add(addnurse);
        addnurse.setBounds(0, 0, 581, 361);
        addnurse.setLayout(null);
        addnurse.setVisible(false);

        JLabel nnamelabel = new JLabel("姓名");
        nnamelabel.setBounds(363, 39, 40, 15);
        addnurse.add(nnamelabel);

        JLabel nnolabel = new JLabel("护士编号");
        nnolabel.setBounds(69, 39, 75, 15);
        addnurse.add(nnolabel);

        JLabel nagelabel = new JLabel("年龄");
        nagelabel.setBounds(363, 97, 40, 15);
        addnurse.add(nagelabel);

        JLabel nsexlabel = new JLabel("性别");
        nsexlabel.setBounds(69, 97, 40, 15);
        addnurse.add(nsexlabel);

        JLabel sickroomlabel = new JLabel("病房号");
        sickroomlabel.setBounds(69, 163, 40, 15);
        addnurse.add(sickroomlabel);

        JLabel ncareerlabel = new JLabel("职称");
        ncareerlabel.setBounds(363, 163, 50, 15);
        addnurse.add(ncareerlabel);

        JLabel ncontactlabel = new JLabel("联系方式");
        ncontactlabel.setBounds(69, 222, 59, 15);
        addnurse.add(ncontactlabel);

        nname = new JTextField();
        nname.setColumns(10);
        nname.setBounds(432, 36, 66, 21);
        addnurse.add(nname);

        nno = new JTextField();
        nno.setColumns(10);
        nno.setBounds(137, 36, 106, 21);
        addnurse.add(nno);

        nage = new JTextField();
        nage.setColumns(10);
        nage.setBounds(432, 95, 66, 21);
        addnurse.add(nage);

        ncareer = new JTextField();
        ncareer.setColumns(10);
        ncareer.setBounds(432, 160, 66, 21);
        addnurse.add(ncareer);

        ncontact = new JTextField();
        ncontact.setColumns(10);
        ncontact.setBounds(137, 219, 106, 21);
        addnurse.add(ncontact);

        JTextField mno_n = new JTextField();
        mno_n.setBounds(137, 159, 66, 23);
        addnurse.add(mno_n);

        nsex = new JComboBox();
        nsex.setBounds(137, 93, 66, 23);
        addnurse.add(nsex);
        nsex.addItem("男");
        nsex.addItem("女");

        JButton n确认添加 = new JButton("确认");
        n确认添加.setBounds(244, 287, 93, 23);
        addnurse.add(n确认添加);
        n确认添加.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 进行输入框判断，为空则不进行登录操作。
                if (nno.getText().isEmpty() || nname.getText().isEmpty() || nage.getText().isEmpty()
                        || ncareer.getText().isEmpty() || mno_n.getText().isEmpty() || ncontact.getText().isEmpty() || nsex.getSelectedItem().toString().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "输入的信息有误", "提示信息", JOptionPane.WARNING_MESSAGE);
                } else {
                    String addnno = nno.getText();// 获取文本值
                    String addnname = nname.getText();// 获取文本值
                    String addnage = nage.getText();// 获取文本值
                    String addncareer = ncareer.getText();// 获取文本值
                    String adddmno_n = mno_n.getText();// 获取文本值
                    String addncontact = ncontact.getText();// 获取文本值
                    String addnsex = nsex.getSelectedItem().toString();// 获取文本值

                    NurseDao nd = new NurseDao();
                    nd.NurseInsert(addnno, addnname, addnage, addncareer, adddmno_n, addncontact, addnsex);

                }
            }
        });

        // 医生
        JPanel adddoctor = new JPanel();
        adddoctor.setBounds(0, 0, 581, 361);
        contentPane.add(adddoctor);
        adddoctor.setLayout(null);
        adddoctor.setVisible(false);

        JLabel dnamelabel = new JLabel("姓名");
        dnamelabel.setBounds(363, 39, 40, 15);
        adddoctor.add(dnamelabel);

        JLabel dnolabel = new JLabel("医生编号");
        dnolabel.setBounds(69, 39, 75, 15);
        adddoctor.add(dnolabel);

        JLabel dagelabel = new JLabel("年龄");
        dagelabel.setBounds(363, 97, 40, 15);
        adddoctor.add(dagelabel);

        JLabel dsexlabel = new JLabel("性别");
        dsexlabel.setBounds(69, 97, 40, 15);
        adddoctor.add(dsexlabel);

        JLabel onolabel = new JLabel("科室");
        onolabel.setBounds(69, 163, 40, 15);
        adddoctor.add(onolabel);

        JLabel careerlabel = new JLabel("职称");
        careerlabel.setBounds(363, 163, 50, 15);
        adddoctor.add(careerlabel);

        JLabel contactlabel = new JLabel("联系方式");
        contactlabel.setBounds(69, 222, 59, 15);
        adddoctor.add(contactlabel);

        dname = new JTextField();
        dname.setColumns(10);
        dname.setBounds(413, 36, 85, 21);
        adddoctor.add(dname);

        dno = new JTextField();
        dno.setColumns(10);
        dno.setBounds(137, 36, 106, 21);
        adddoctor.add(dno);

        dage = new JTextField();
        dage.setColumns(10);
        dage.setBounds(413, 95, 85, 21);
        adddoctor.add(dage);

        career_d = new JTextField();
        career_d.setColumns(10);
        career_d.setBounds(411, 160, 87, 21);
        adddoctor.add(career_d);

        contact_d = new JTextField();
        contact_d.setColumns(10);
        contact_d.setBounds(137, 219, 106, 21);
        adddoctor.add(contact_d);

        dsex = new JComboBox();
        dsex.setBounds(137, 93, 66, 23);
        adddoctor.add(dsex);
        dsex.addItem("男");
        dsex.addItem("女");

        oname_d = new JComboBox();
        oname_d.setBounds(137, 159, 66, 23);
        adddoctor.add(oname_d);
        for (int i = 0; i < department.length; i++) {
            oname_d.addItem(department[i]);
        }

        JButton 确认添加 = new JButton("确认");
        确认添加.setBounds(244, 287, 93, 23);
        adddoctor.add(确认添加);
        确认添加.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (dno.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "请输入的编号输入有误", "提示信息", JOptionPane.WARNING_MESSAGE);
                } else {
                    DoctorB doctorb = new DoctorB();
                    doctorb.setDno(String.valueOf(dno.getText()));
                    doctorb.setDname(String.valueOf(dname.getText()));
                    doctorb.setDage(String.valueOf(dage.getText()));
                    doctorb.setCareer(String.valueOf(career_d.getText()));
                    doctorb.setDsex(String.valueOf(dsex.getSelectedItem()));
                    doctorb.setContact(String.valueOf(contact_d.getText()));

                    OfficeB officeb = new OfficeB();
                    officeb.setOname(String.valueOf(oname_d.getSelectedItem()));

                    dc.DoctorInsert(doctorb, officeb);


                }
            }
        });

        // 病房病床
        JPanel addsickroom = new JPanel();
        contentPane.add(addsickroom);
        addsickroom.setBounds(0, 0, 581, 361);
        addsickroom.setLayout(null);

        JLabel mmolabel = new JLabel("输入病房编号");
        mmolabel.setBounds(104, 86, 93, 15);
        addsickroom.add(mmolabel);

        JLabel bnolabel = new JLabel("输入病床编号");
        bnolabel.setBounds(104, 178, 93, 15);
        addsickroom.add(bnolabel);

        JLabel 分配状态 = new JLabel("状态");
        分配状态.setBounds(298, 178, 47, 15);
        addsickroom.add(分配状态);

        JLabel mmolabel_1 = new JLabel("输入病房号");
        mmolabel_1.setBounds(298, 83, 71, 15);
        addsickroom.add(mmolabel_1);

        mno = new JTextField();
        mno.setColumns(10);
        mno.setBounds(200, 83, 66, 21);
        addsickroom.add(mno);

        mname = new JTextField();
        mname.setColumns(10);
        mname.setBounds(372, 80, 66, 21);
        addsickroom.add(mname);

        bname = new JComboBox();
        bname.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        bname.setBounds(207, 174, 66, 23);
        addsickroom.add(bname);
        bname.addItem("1");
        bname.addItem("2");
        bname.addItem("3");
        bname.addItem("4");

        status = new JComboBox();
        status.setBounds(372, 174, 66, 23);
        addsickroom.add(status);
        status.addItem("未分配");
        status.addItem("已分配");

        JButton 确认添加_sickroom = new JButton("确认");
        确认添加_sickroom.setBounds(234, 283, 93, 23);
        addsickroom.add(确认添加_sickroom);

        确认添加_sickroom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 进行输入框判断，为空则不进行登录操作。
                // 病房病床添加
                if (mno.getText().isEmpty() || mname.getText().isEmpty()
                        || bname.getSelectedItem().toString().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "请输入的房号或床号输入有误", "提示信息", JOptionPane.WARNING_MESSAGE);
                } else {
                    SickRoomB sickRoomb = new SickRoomB();
                    sickRoomb.setMno(mno.getText());
                    sickRoomb.setMname(mname.getText());
                    sickRoomb.setNno(bname.getSelectedItem().toString());
                    sickRoomb.setStatus(status.getSelectedItem().toString());
                    sk.SickroomInsert(sickRoomb);
                }
            }
        });

        // 选择跳转的功能
        switch (text) {
            case "patient" : {
                adddoctor.setVisible(false);
                addsickroom.setVisible(false);
                addnurse.setVisible(false);
                addpatient.setVisible(true);
            }
            case "doctor" : {
                addsickroom.setVisible(false);
                addnurse.setVisible(false);
                addpatient.setVisible(false);
                adddoctor.setVisible(true);
            }
            case "sickroom" : {
                addnurse.setVisible(false);
                addpatient.setVisible(false);
                adddoctor.setVisible(false);
                addsickroom.setVisible(true);
            }
            case "nurse" : {
                addsickroom.setVisible(false);
                addpatient.setVisible(false);
                adddoctor.setVisible(false);
                addnurse.setVisible(true);
            }
        }

    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Add frame = new Add();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}

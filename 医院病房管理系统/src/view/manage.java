package view;

import dao.DoctorDao;
import dao.ManageDao;
import dao.NurseDao;
import dao.SickroomDao;
import javabean.DoctorB;
import javabean.MarkB;
import javabean.NurseB;
import javabean.PatientB;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

@SuppressWarnings({"all"})
public class manage extends JFrame {


    private JComboBox dname_p;
    private JComboBox nname_p;
    private JComboBox nsex;
    private static JPanel contentPane;
    private JTextField dno;
    private JTextField pname;
    private JTextField surplus;
    private JTextField sicken;
    private JTextField page;
    private JTextField nno;
    private JTextField tz;
    private JTable table;
    private JTextField pno;
    private JTextPane dname;
    private JTextPane dage;
    private JComboBox dsex;
    private JTextPane contact;
    private JTextPane career;
    private JComboBox dono;
    private JComboBox psex;
    private JComboBox nono;
    private JTable table_2;
    private JTable table_3;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    manage frame = new manage();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public manage() {


        setTitle("管理系统");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(456, 222, 700, 400);
        this.setVisible(true);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnNewButton_2 = new JButton("床位管理");
        btnNewButton_2.setBounds(10, 170, 93, 45);
        contentPane.add(btnNewButton_2);

        JButton btnNewButton_1 = new JButton("病人管理");
        btnNewButton_1.setBounds(10, 95, 93, 45);
        contentPane.add(btnNewButton_1);

        JButton btnNewButton = new JButton("医生管理");
        btnNewButton.setBounds(10, 22, 93, 45);
        contentPane.add(btnNewButton);

        JButton btnNewButton_3 = new JButton("护士管理");
        btnNewButton_3.setBounds(10, 247, 93, 45);
        contentPane.add(btnNewButton_3);

// 右边panel
        JPanel panel = new JPanel();
        panel.setBounds(103, 0, 581, 361);
        contentPane.add(panel);
        tz = new JTextField();
        ManageDao madao = new ManageDao();

        panel.setLayout(null);
        String[] department = new String[]{"内科", "外科", "妇科", "儿科", "辅助检查科室", "精神科", "五官科", "肛肠科"};

        //todo 病床panel
        JPanel sickroomp = new JPanel();
        sickroomp.setLayout(null);
        sickroomp.setBounds(0, 0, 581, 361);
        sickroomp.setVisible(false);
        panel.add(sickroomp);

        JLabel 病房号label = new JLabel("病房号");
        病房号label.setBounds(64, 21, 51, 24);
        sickroomp.add(病房号label);

        JLabel 病床号label = new JLabel("病床号");
        病床号label.setBounds(234, 21, 51, 24);
        sickroomp.add(病床号label);

        JLabel 状态label = new JLabel("状态");
        状态label.setBounds(402, 21, 36, 24);
        sickroomp.add(状态label);

        JLabel 病房label = new JLabel("病房");
        病房label.setBounds(64, 63, 29, 24);
        sickroomp.add(病房label);

        JLabel 病床label = new JLabel("病床");
        病床label.setBounds(64, 83, 29, 24);
        sickroomp.add(病床label);

        JComboBox mno = new JComboBox();
        mno.setBounds(110, 22, 47, 23);
        ArrayList<MarkB> markBS = ManageDao.room();
        for (MarkB markb : markBS) {
            mno.addItem(markb.getMno());
        }
        sickroomp.add(mno);

        JComboBox bno = new JComboBox();
        bno.setBounds(282, 22, 62, 23);
        bno.addItem("1");
        bno.addItem("2");
        bno.addItem("3");
        bno.addItem("4");
        sickroomp.add(bno);

        JComboBox status = new JComboBox();
        status.setBounds(439, 22, 62, 23);
        status.addItem("已分配");
        status.addItem("未分配");
        sickroomp.add(status);

        JButton 添加病房 = new JButton("添加病房");
        添加病房.setBounds(64, 263, 93, 23);
        sickroomp.add(添加病房);

        JButton 添加病床 = new JButton("添加病床");
        添加病床.setBounds(64, 308, 93, 23);
        sickroomp.add(添加病床);


        JButton 病床信息更改 = new JButton("病床信息更改");
        病床信息更改.setBounds(400, 263, 111, 68);
        sickroomp.add(病床信息更改);
        病床信息更改.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String bno_b = bno.getSelectedItem().toString();// 获取文本值
                String mno_b = mno.getSelectedItem().toString();// 获取文本值
                String status_b = status.getSelectedItem().toString();// 获取文本值
                madao.update_sickroom(bno_b, status_b, mno_b);//删除
            }
        });

        JButton 删除病房 = new JButton("删除病房");
        删除病房.setBounds(251, 263, 93, 23);
        sickroomp.add(删除病房);
        删除病房.addItemListener(new ItemListener() {
            public void itemStateChanged(final ItemEvent e) {
                int index = mno.getSelectedIndex();
                if (index != 0) { // ==0表示选中的事第一个
                    System.out.println(index);
                }
            }
        });
        删除病房.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String mno_m = mno.getSelectedItem().toString();// 获取文本值
                madao.deleteroom(mno_m);//删除
            }
        });

        JButton 删除病床 = new JButton("删除病床");
        删除病床.setBounds(251, 308, 93, 23);
        sickroomp.add(删除病床);
        删除病床.addItemListener(new ItemListener() {
            public void itemStateChanged(final ItemEvent e) {
                int index = mno.getSelectedIndex();
                if (index != 0) { // ==0表示选中的事第一个
                    System.out.println(index);
                }
            }

        });
        删除病床.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String mno_b = bno.getSelectedItem().toString();// 获取文本值
                String mno_m = mno.getSelectedItem().toString();// 获取文本值
                madao.deletebed(mno_b, mno_m);//删除
            }
        });


        //表格病床
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(111, 63, 390, 175);
        sickroomp.add(scrollPane);

        JPanel tb = new JPanel();
        tb.setBounds(111, 63, 390, 175);
        tb.setLayout(new BorderLayout());
        scrollPane.add(tb);

        Object[][] data = new Object[50][5];
        String[] columnNames = {"房间号", "病床号", "状态"};

        JTable table_1 = new JTable(data, columnNames);
        tb.add(table_1, BorderLayout.CENTER);
        scrollPane.setViewportView(tb);
        JTableHeader header = table_1.getTableHeader();
        tb.add(header, BorderLayout.NORTH);

        //todo 病人panel
        JPanel patientp = new JPanel();
        patientp.setLayout(null);
        patientp.setBounds(0, 0, 581, 361);
        patientp.setVisible(false);
        panel.add(patientp);

        JLabel 姓名label = new JLabel("姓名");
        姓名label.setBounds(41, 30, 29, 15);
        patientp.add(姓名label);

        JLabel 性别label = new JLabel("性别");
        性别label.setBounds(219, 30, 29, 15);
        patientp.add(性别label);

        JLabel 年龄label = new JLabel("年龄");
        年龄label.setBounds(406, 30, 29, 15);
        patientp.add(年龄label);

        JLabel 患病label = new JLabel("患病");
        患病label.setBounds(41, 79, 29, 15);
        patientp.add(患病label);

        JLabel 余额label = new JLabel("余额");
        余额label.setBounds(41, 134, 29, 15);
        patientp.add(余额label);

        JLabel 住址医生label = new JLabel("主治医生");
        住址医生label.setBounds(217, 74, 61, 24);
        patientp.add(住址医生label);

        JLabel 责任护士label = new JLabel("责任护士");
        责任护士label.setBounds(406, 74, 61, 24);
        patientp.add(责任护士label);

        JLabel 患者身份证label = new JLabel("患者身份证");
        患者身份证label.setBounds(41, 302, 68, 24);
        patientp.add(患者身份证label);

        JButton 查询 = new JButton("查询");
        查询.setBounds(296, 303, 93, 23);
        patientp.add(查询);
        查询.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (pno.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "请输入编号", "提示信息", JOptionPane.WARNING_MESSAGE);
                } else {
                    String patientno = pno.getText();// 获取文本值
                    madao.seepatient(pname, page, psex, sicken, surplus, dname_p, nname_p, patientno);
                }
            }
        });

        JButton 添加患者 = new JButton("添加患者");
        添加患者.setBounds(453, 162, 93, 23);
        patientp.add(添加患者);

        JButton 删除患者 = new JButton("删除患者");
        删除患者.setBounds(453, 228, 93, 23);
        patientp.add(删除患者);
        删除患者.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 进行输入框判断，为空则不进行登录操作。
                if (pno.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "请输入编号输入有误", "提示信息", JOptionPane.WARNING_MESSAGE);
                } else {
                    String patientno = pno.getText();// 获取文本值
                    madao.seepatient(pname, page, psex, sicken, surplus, dname_p, nname_p, patientno);//先默认查询
                    madao.deletepatient(patientno);//删除
                }
            }
        });

        JButton 信息更改 = new JButton("信息更改");
        信息更改.setBounds(453, 303, 93, 23);
        patientp.add(信息更改);
        信息更改.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (pno.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "请输入编号输入有误", "提示信息", JOptionPane.WARNING_MESSAGE);
                } else {
                    PatientB p = new PatientB();
                    p.setPno(String.valueOf(pno.getText()));
                    p.setPname(String.valueOf(pname.getText()));
                    p.setPage(String.valueOf(page.getText()));
                    p.setPsex(String.valueOf(psex.getSelectedItem()));
                    p.setSicken(String.valueOf(sicken.getText()));
                    p.setSurplus(String.valueOf(surplus.getText()));
//todo 病人的信息更改
                    p.setDname_p(String.valueOf(dname_p.getSelectedItem()));
                    p.setNname_p(String.valueOf(nname_p.getSelectedItem()));
                    madao.update_patient(p);
                }
            }
        });

        pname = new JTextField();
        pname.setColumns(10);
        pname.setBounds(68, 27, 90, 20);
        patientp.add(pname);

        surplus = new JTextField();
        surplus.setColumns(10);
        surplus.setBounds(70, 131, 90, 20);
        patientp.add(surplus);

        sicken = new JTextField();
        sicken.setColumns(10);
        sicken.setBounds(70, 76, 90, 21);
        patientp.add(sicken);

        page = new JTextField();
        page.setColumns(10);
        page.setBounds(466, 27, 80, 20);
        patientp.add(page);

        pno = new JTextField();
        pno.setColumns(10);
        pno.setBounds(119, 304, 139, 21);
        patientp.add(pno);

        psex = new JComboBox();
        psex.setBounds(277, 26, 80, 23);
        psex.addItem("男");
        psex.addItem("女");
        patientp.add(psex);

        dname_p = new JComboBox();
        dname_p.setBounds(277, 75, 80, 23);
        patientp.add(dname_p);
        ArrayList<MarkB> marks1 = ManageDao.doctor();
        for (MarkB markb : marks1) {
            dname_p.addItem(markb.getDname());
        }

        nname_p = new JComboBox();
        nname_p.setBounds(466, 75, 80, 23);
        patientp.add(nname_p);
        ArrayList<MarkB> marks2 = ManageDao.nurse();
        for (MarkB markb : marks2) {
            nname_p.addItem(markb.getNname());
        }


        //todo 医生panel
        JPanel doctorp = new JPanel();
        doctorp.setLayout(null);
        doctorp.setBounds(0, 0, 581, 361);
        doctorp.setVisible(false);
        panel.add(doctorp);

        JLabel 医生编号label = new JLabel("医生编号");
        医生编号label.setBounds(49, 306, 62, 26);
        doctorp.add(医生编号label);

        JLabel 姓名label1 = new JLabel("姓名");
        姓名label1.setBounds(19, 21, 47, 26);
        doctorp.add(姓名label1);

        JLabel 性别label1 = new JLabel("性别");
        性别label1.setBounds(213, 21, 30, 26);
        doctorp.add(性别label1);

        JLabel 年龄label1 = new JLabel("年龄");
        年龄label1.setBounds(329, 21, 30, 26);
        doctorp.add(年龄label1);

        JLabel 联系方式label = new JLabel("联系方式");
        联系方式label.setBounds(19, 70, 53, 26);
        doctorp.add(联系方式label);

        JLabel 科室label = new JLabel("科室");
        科室label.setBounds(213, 70, 30, 26);
        doctorp.add(科室label);

        JLabel 职称label = new JLabel("职称");
        职称label.setBounds(329, 70, 30, 26);
        doctorp.add(职称label);

        JLabel 患者信息label = new JLabel("患者信息");
        患者信息label.setBounds(19, 133, 53, 26);
        doctorp.add(患者信息label);

        JButton 删除医生 = new JButton("删除医生");
        删除医生.setBounds(456, 260, 93, 23);
        doctorp.add(删除医生);
        删除医生.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 进行输入框判断，为空则不进行登录操作。
                if (dno.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "请输入编号输入有误", "提示信息", JOptionPane.WARNING_MESSAGE);
                } else {
                    DoctorB db = new DoctorB();
                    db.setDno(String.valueOf(dno.getText()));
                    madao.seedoctor(dname, dage, dsex, contact, career, dono, db);//先默认查询
                    madao.deletedoctor(db);//删除}
                }
            }
        });

        JButton 信息更改1 = new JButton("信息更改");
        信息更改1.setBounds(456, 308, 93, 23);
        doctorp.add(信息更改1);
        信息更改1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (dno.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "请输入编号输入有误", "提示信息", JOptionPane.WARNING_MESSAGE);
                } else {
                    DoctorB doctorb = new DoctorB();
                    doctorb.setDno_g(String.valueOf(dno.getText()));
                    doctorb.setDname_g(String.valueOf(dname.getText()));
                    doctorb.setDage_g(String.valueOf(dage.getText()));
                    doctorb.setDsex_g(String.valueOf(dsex.getSelectedItem()));
                    doctorb.setContact_g(String.valueOf(contact.getText()));
                    doctorb.setCareer_g(String.valueOf(career.getText()));
                    doctorb.setDono_g(String.valueOf(dono.getSelectedItem()));
                    madao.update_doctor(dname, dage, dsex, contact, career, dono, doctorb);
                }
            }
        });

        JButton 新建医生 = new JButton("新建医生");
        新建医生.setBounds(456, 212, 93, 23);
        doctorp.add(新建医生);

        JButton 确定 = new JButton("确定");
        确定.setBounds(247, 308, 93, 23);
        doctorp.add(确定);
        确定.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (dno.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "请输入编号输入有误", "提示信息", JOptionPane.WARNING_MESSAGE);
                } else {
                    DoctorB doctorb = new DoctorB();
                    doctorb.setDno(String.valueOf(dno.getText()));
                    madao.seedoctor(dname, dage, dsex, contact, career, dono, doctorb);
                }
            }
        });

        dno = new JTextField();
        dno.setColumns(10);
        dno.setBounds(110, 309, 114, 21);
        doctorp.add(dno);

        dname = new JTextPane();
        dname.setBounds(76, 26, 114, 21);
        doctorp.add(dname);

        dage = new JTextPane();
        dage.setBounds(369, 26, 62, 21);
        doctorp.add(dage);

        contact = new JTextPane();
        contact.setBounds(76, 70, 114, 21);
        doctorp.add(contact);

        career = new JTextPane();
        career.setBounds(369, 75, 62, 21);
        doctorp.add(career);


        dsex = new JComboBox();
        dsex.setBounds(247, 24, 44, 23);
        doctorp.add(dsex);
        dsex.addItem("男");
        dsex.addItem("女");

        dono = new JComboBox();
        dono.setBounds(247, 72, 62, 23);
        for (int i = 0; i < department.length; i++) {
            dono.addItem(department[i]);
        }
        doctorp.add(dono);

        JScrollPane scrollPane_2 = new JScrollPane();
        scrollPane_2.setBounds(76, 108, 355, 186);
        doctorp.add(scrollPane_2);

        JPanel panel_2 = new JPanel();
        scrollPane_2.setViewportView(panel_2);
        panel_2.setLayout(new BorderLayout(0, 0));

        Object[][] data_d = new Object[20][6];
        String[] columnNames_d = {"医生号", "姓名", "性别", "职位", "联系方式", "值班时间"};

        table_3 = new JTable(data_d, columnNames_d);
        table_3.getColumnModel().getColumn(0).setPreferredWidth(40);
        table_3.getColumnModel().getColumn(1).setPreferredWidth(50);
        table_3.getColumnModel().getColumn(2).setPreferredWidth(30);
        table_3.getColumnModel().getColumn(3).setPreferredWidth(50);
        table_3.getColumnModel().getColumn(4).setPreferredWidth(80);//
        table_3.getColumnModel().getColumn(5).setPreferredWidth(80);
        panel_2.add(table_3, BorderLayout.CENTER);
        JTableHeader header_d = table_3.getTableHeader();
        panel_2.add(header_d, BorderLayout.NORTH);


        //todo 护士panel
        JPanel nursep = new JPanel();
        nursep.setLayout(null);
        nursep.setBounds(0, 0, 581, 361);
        nursep.setVisible(false);
        panel.add(nursep);

        JLabel 护士编号label = new JLabel("护士编号");
        护士编号label.setBounds(61, 306, 62, 26);
        nursep.add(护士编号label);

        JLabel 姓名label11 = new JLabel("姓名");
        姓名label11.setBounds(19, 21, 44, 26);
        nursep.add(姓名label11);

        JLabel 性别label11 = new JLabel("性别");
        性别label11.setBounds(368, 21, 30, 26);
        nursep.add(性别label11);

        JLabel 年龄label11 = new JLabel("年龄");
        年龄label11.setBounds(227, 21, 30, 26);
        nursep.add(年龄label11);

        JLabel 联系方式label1 = new JLabel("联系方式");
        联系方式label1.setBounds(19, 70, 53, 26);
        nursep.add(联系方式label1);


        JLabel 职称label1 = new JLabel("职称");
        职称label1.setBounds(227, 70, 30, 26);
        nursep.add(职称label1);

        JLabel 排版信息label = new JLabel("排班信息");
        排版信息label.setBounds(19, 108, 53, 26);
        nursep.add(排版信息label);

        nno = new JTextField();
        nno.setColumns(10);
        nno.setBounds(141, 309, 114, 21);
        nursep.add(nno);

        nsex = new JComboBox();
        nsex.setBounds(402, 24, 44, 23);
        nsex.addItem("男");
        nsex.addItem("女");
        nursep.add(nsex);

        JTextPane nname = new JTextPane();
        nname.setBounds(76, 26, 114, 21);
        nursep.add(nname);

        JTextPane nage = new JTextPane();
        nage.setBounds(267, 26, 77, 21);
        nursep.add(nage);

        JTextPane ncontact = new JTextPane();
        ncontact.setBounds(76, 70, 114, 21);
        nursep.add(ncontact);

        JTextPane ncareer = new JTextPane();
        ncareer.setBounds(267, 75, 77, 21);
        nursep.add(ncareer);

        JButton 确定1 = new JButton("确定");
        确定1.setBounds(282, 308, 93, 23);
        nursep.add(确定1);
        确定1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (nno.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "请输入编号", "提示信息", JOptionPane.WARNING_MESSAGE);
                } else {
                    String nurseno = nno.getText();// 获取文本值
                    madao.seenurse(nname, nage, nsex, ncontact, ncareer, nurseno);
                }
            }
        });

        JButton 删除护士 = new JButton("删除护士");
        删除护士.setBounds(456, 260, 93, 23);
        nursep.add(删除护士);
        删除护士.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 进行输入框判断，为空则不进行登录操作。
                if (nno.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "请输入编号输入有误", "提示信息", JOptionPane.WARNING_MESSAGE);
                } else {
                    String nurseno = nno.getText();// 获取文本值
                    madao.seenurse(nname, nage, nsex, ncontact, ncareer, nurseno);//先默认查询
                    madao.deletenurse(nurseno);//删除
                }
            }
        });

        JButton 信息更改11 = new JButton("信息更改");
        信息更改11.setBounds(456, 308, 93, 23);
        nursep.add(信息更改11);
        信息更改11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (nno.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "请输入编号输入有误", "提示信息", JOptionPane.WARNING_MESSAGE);
                } else {
                    NurseB nurseb = new NurseB();
                    nurseb.setNno(String.valueOf(nno.getText()));
                    nurseb.setNname(String.valueOf(nname.getText()));
                    nurseb.setNage(String.valueOf(nage.getText()));
                    nurseb.setNsex(String.valueOf(nsex.getSelectedItem()));
                    nurseb.setContact(String.valueOf(ncontact.getText()));
                    nurseb.setCareer(String.valueOf(ncareer.getText()));
                    madao.update_nurse(nurseb);
                }
            }
        });


        JButton 新建护士 = new JButton("新建护士");
        新建护士.setBounds(456, 212, 93, 23);
        nursep.add(新建护士);

        //表格护士
        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(76, 108, 375, 175);
        nursep.add(scrollPane_1);

        JPanel panel_1 = new JPanel();
        scrollPane_1.setViewportView(panel_1);
        panel_1.setLayout(new BorderLayout(0, 0));

        Object[][] data_n = new Object[20][5];
        String[] columnNames_n = {"护士号", "姓名", "性别", "联系方式", "值班时间"};

        table_2 = new JTable(data_n, columnNames_n);
        table_2.getColumnModel().getColumn(0).setPreferredWidth(10);
        table_2.getColumnModel().getColumn(1).setPreferredWidth(10);
        table_2.getColumnModel().getColumn(2).setPreferredWidth(10);
        table_2.getColumnModel().getColumn(3).setPreferredWidth(50);
        table_2.getColumnModel().getColumn(4).setPreferredWidth(50);//
        panel_1.add(table_2, BorderLayout.CENTER);
        JTableHeader header_n = table_2.getTableHeader();
        panel_1.add(header_n, BorderLayout.NORTH);

//设置panel的可见性
        btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                patientp.setVisible(false);
                sickroomp.setVisible(false);
                doctorp.setVisible(false);
                nursep.setVisible(true);
                NurseDao nd = new NurseDao();
                nd.show(data_n);
            }
        });

        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                patientp.setVisible(false);
                sickroomp.setVisible(false);
                nursep.setVisible(false);
                doctorp.setVisible(true);
                DoctorDao dd = new DoctorDao();
                dd.show(data_d);
            }
        });

        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                sickroomp.setVisible(false);
                nursep.setVisible(false);
                doctorp.setVisible(false);
                patientp.setVisible(true);
            }

        });
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                nursep.setVisible(false);
                doctorp.setVisible(false);
                patientp.setVisible(false);
                sickroomp.setVisible(true);
                SickroomDao sd = new SickroomDao();
                sd.show(data);
            }
        });
// 新建功能
        新建医生.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tz.setText("doctor");
                String tt = tz.getText();
                new Add(tt);
                new Add();
            }
        });
        新建护士.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tz.setText("nurse");
                String tt = tz.getText();
                new Add(tt);
                new Add();
            }
        });
        添加患者.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tz.setText("patient");
                String tt = tz.getText();
                new Add(tt);
                new Add();
            }
        });
        添加病房.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ArrayList<MarkB> markBS = ManageDao.room();
                for (MarkB markb : markBS) {
                    mno.addItem(markb.getMno());
                }
                tz.setText("sickroom");
                String tt = tz.getText();
                new Add(tt);
                new Add();
            }
        });
        添加病床.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tz.setText("sickroom");
                String tt = tz.getText();
                new Add(tt);
                new Add();
            }
        });
    }
}

package view;

import dao.DoctorDao;
import dao.SickroomDao;
import javabean.DoctorB;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class doctor extends JFrame {

    private Object[] columnNames_d_p;
    private Object[][] data_d_p;
    private JTextField dno;
    private JPanel contentPane;
    private JTextField dname;
    private JTextField dage;
    private JTextField career;
    private JTable patient;
    private JScrollPane scrollPane;
    private JTable table;
    private JTextField pno_d;
    private JTextField pno_d1;

    /**
     * Create the frame.
     */
    public doctor() {
        setTitle("医生系统");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(456, 22, 581, 361);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        DoctorDao docdao = new DoctorDao();

        JLabel dpnolabel = new JLabel("医生编号");
        dpnolabel.setBounds(76, 293, 58, 15);
        contentPane.add(dpnolabel);

        JLabel dnamelabel = new JLabel("姓名");
        dnamelabel.setBounds(27, 25, 33, 15);
        contentPane.add(dnamelabel);

        JLabel dagelabel = new JLabel("年龄");
        dagelabel.setBounds(183, 25, 33, 15);
        contentPane.add(dagelabel);

        JLabel careerlabel = new JLabel("职称");
        careerlabel.setBounds(312, 25, 33, 15);
        contentPane.add(careerlabel);

//		JLabel pictures = new JLabel("照片");
//		pictures.setBounds(445, 22, 93, 109);
//		contentPane.add(pictures);

        JLabel patientlabel = new JLabel("当前患者");
        patientlabel.setBounds(27, 84, 58, 15);
        contentPane.add(patientlabel);

        dno = new JTextField();
        dno.setColumns(10);
        dno.setBounds(134, 290, 130, 21);
        contentPane.add(dno);

        dname = new JTextField();
        dname.setColumns(10);
        dname.setBounds(86, 22, 66, 21);
        contentPane.add(dname);

        dage = new JTextField();
        dage.setColumns(10);
        dage.setBounds(214, 22, 66, 21);
        contentPane.add(dage);

        career = new JTextField();
        career.setColumns(10);
        career.setBounds(340, 22, 79, 21);
        contentPane.add(career);

        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(76, 84, 345, 194);
        contentPane.add(scrollPane_1);



        JPanel panel = new JPanel();
        scrollPane_1.setViewportView(panel);
        panel.setLayout(new BorderLayout(0, 0));

        data_d_p = new Object[10][6];
        columnNames_d_p = new Object[]{"患者号", "姓名", "性别", "患病", "治疗方案"};
        DefaultTableModel model = new DefaultTableModel(data_d_p,columnNames_d_p);

        table = new JTable(model);
        panel.add(table, BorderLayout.CENTER);
        table = new JTable(data_d_p, columnNames_d_p);
        panel.add(table, BorderLayout.CENTER);
        JTableHeader header_d = table.getTableHeader();
        panel.add(header_d, BorderLayout.NORTH);


        JButton btnNewButton_1 = new JButton("查询");
        btnNewButton_1.setBounds(327, 289, 93, 23);
        contentPane.add(btnNewButton_1);
        btnNewButton_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 进行输入框判断，为空则不进行登录操作。
                if (dno.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "请输入编号", "提示信息", JOptionPane.WARNING_MESSAGE);
                } else {
                    String doctorno = dno.getText();// 获取文本值
                    docdao.show(data_d_p, doctorno);
                    UpdateTable();
                    docdao.seedoctor(dname, dage, career, doctorno);


                }
            }
        });

        JButton jieshu = new JButton("诊断结束");
        jieshu.setBounds(462, 289, 93, 23);
        contentPane.add(jieshu);
        jieshu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DoctorB doctorB = new DoctorB();
                doctorB.setPno_d(pno_d.getText());
                DoctorDao db1 = new DoctorDao();
                db1.deletepatient(doctorB);
                UpdateTable();
            }
        });

        pno_d = new JTextField();
        pno_d.setBounds(489, 257, 66, 21);
        contentPane.add(pno_d);
        pno_d.setColumns(10);

        JLabel lblNewLabel = new JLabel("患者号");
        lblNewLabel.setBounds(442, 263, 54, 15);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("治疗方案");
        lblNewLabel_1.setBounds(431, 111, 54, 15);
        contentPane.add(lblNewLabel_1);

        JTextArea cure_d = new JTextArea();
        cure_d.setBounds(450, 136, 105, 78);
        cure_d.setLineWrap(true);   //实现自动换行
        contentPane.add(cure_d);

        JButton btnNewButton_2 = new JButton("更改方案");
        btnNewButton_2.setBounds(462, 224, 93, 23);
        contentPane.add(btnNewButton_2);
        btnNewButton_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DoctorB db1 = new DoctorB();
                db1.setPno_d1(pno_d1.getText());
                db1.setCure_d(cure_d.getText());
                DoctorDao dd1 = new DoctorDao();
                dd1.updatecure(db1);
                UpdateTable();
            }
        });




        JLabel lblNewLabel_2 = new JLabel("患者号");
        lblNewLabel_2.setBounds(431, 81, 54, 15);
        contentPane.add(lblNewLabel_2);

        pno_d1 = new JTextField();
        pno_d1.setColumns(10);
        pno_d1.setBounds(470, 78, 66, 21);
        contentPane.add(pno_d1);



    }

    public void UpdateTable(){

        //更新JTable中数据的做法
        //更新数据Object[][]  data;
        DefaultTableModel model = new DefaultTableModel(data_d_p,columnNames_d_p);
        table.setModel(model);//完成数据更新
        //设置只能选中单行
        table.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        // 设置table内容居中
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(JLabel.CENTER);
    }
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    doctor frame = new doctor();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}

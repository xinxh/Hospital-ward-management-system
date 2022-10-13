package view;

import dao.PatientDao;
import javabean.PatientB;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class patient extends JFrame {

    private JTextArea cure;
    private JPanel contentPane;
    private JTextField pname;
    private JTextField dname_p;
    private JTextField page;
    private JTextField nname_p;
    private JTextField surplus;
    private JTextField sickroom;
    private JTextField pno;
    private PatientB patientB;


    /**
     * Create the frame.
     */
    public patient() {
        setTitle("患者系统");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(456, 222, 581, 361);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        PatientDao padao = new PatientDao();

        JLabel pnamelabel = new JLabel("姓名");
        pnamelabel.setBounds(34, 21, 33, 15);
        contentPane.add(pnamelabel);

        JLabel pagelabel = new JLabel("年龄");
        pagelabel.setBounds(190, 21, 33, 15);
        contentPane.add(pagelabel);

        JLabel surpluslabel = new JLabel("余额");
        surpluslabel.setBounds(373, 21, 33, 15);
        contentPane.add(surpluslabel);

        JLabel dnamelabel = new JLabel("主治医师");
        dnamelabel.setBounds(34, 68, 57, 15);
        contentPane.add(dnamelabel);

        JLabel nnamelabel = new JLabel("责任护士");
        nnamelabel.setBounds(190, 68, 57, 15);
        contentPane.add(nnamelabel);

        JLabel curelabel = new JLabel("治疗方案");
        curelabel.setBounds(34, 145, 57, 15);
        contentPane.add(curelabel);

        JLabel idlabel = new JLabel("身份证");
        idlabel.setBounds(93, 297, 48, 15);
        contentPane.add(idlabel);

        JLabel lblNewLabel_4 = new JLabel("病房信息");
        lblNewLabel_4.setBounds(373, 68, 64, 15);
        contentPane.add(lblNewLabel_4);


        pname = new JTextField();
        pname.setBounds(93, 18, 66, 21);
        contentPane.add(pname);
        pname.setColumns(10);

        dname_p = new JTextField();
        dname_p.setColumns(10);
        dname_p.setBounds(93, 65, 66, 21);
        contentPane.add(dname_p);

        page = new JTextField();
        page.setColumns(10);
        page.setBounds(259, 18, 66, 21);
        contentPane.add(page);

        nname_p = new JTextField();
        nname_p.setColumns(10);
        nname_p.setBounds(257, 65, 66, 21);
        contentPane.add(nname_p);

        surplus = new JTextField();
        surplus.setColumns(10);
        surplus.setBounds(442, 18, 99, 21);
        contentPane.add(surplus);

        sickroom = new JTextField();
        sickroom.setColumns(10);
        sickroom.setBounds(442, 65, 99, 21);
        contentPane.add(sickroom);

        cure = new JTextArea();
        cure.setBounds(93, 140, 252, 145);
        contentPane.add(cure);


        pno = new JTextField();
        pno.setColumns(10);
        pno.setBounds(151, 294, 130, 21);
        contentPane.add(pno);

        //todo 查询
        JButton btnNewButton_1 = new JButton("查询");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 进行输入框判断，为空则不进行登录操作。
                if (pno.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "请输入身份证号", "提示信息", JOptionPane.WARNING_MESSAGE);
                } else {
                    String patientno = pno.getText();// 获取文本值
                    patientB = padao.seepatient(pname, page, surplus, dname_p, nname_p, sickroom, cure, patientno);
                }
            }
        });
        btnNewButton_1.setBounds(344, 293, 93, 23);
        contentPane.add(btnNewButton_1);
//todo 缴费
        JButton btnNewButton = new JButton("在线缴费");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (pno.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "请输入身份证号", "提示信息", JOptionPane.WARNING_MESSAGE);
                } else {
                    new pay(patientB);
                }
            }
        });
        btnNewButton.setBounds(448, 203, 93, 23);
        contentPane.add(btnNewButton);


    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    patient frame = new patient();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


}

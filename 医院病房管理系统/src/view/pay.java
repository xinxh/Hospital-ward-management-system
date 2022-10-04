package view;

import dao.PatientDao;
import javabean.PatientB;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class pay extends JFrame {

    private String patientno;
    private JPanel sickroomlabel;
    private JTextField pno;
    private JTextField pname;
    private JTextField surplus;
    private JTextField sickroom;
    private JTextField newsurplus;


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PatientB patientB = new PatientB();
                    pay frame = new pay(patientB);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    //有参构造
    public pay(PatientB pat) {

        setTitle("缴费系统");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(446, 235, 581, 361);
        sickroomlabel = new JPanel();
        sickroomlabel.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.setVisible(true);
        PatientDao padao = new PatientDao();
        setContentPane(sickroomlabel);
        sickroomlabel.setLayout(null);

        JLabel idlabel = new JLabel("身份证");
        idlabel.setBounds(59, 64, 48, 15);
        sickroomlabel.add(idlabel);

        JLabel pnamelabel = new JLabel("姓名");
        pnamelabel.setBounds(59, 128, 41, 15);
        sickroomlabel.add(pnamelabel);

        JLabel surpluslabel = new JLabel("当前余额");
        surpluslabel.setBounds(329, 125, 57, 15);
        sickroomlabel.add(surpluslabel);

        JLabel lblNewLabel_1_2 = new JLabel("床位");
        lblNewLabel_1_2.setBounds(329, 61, 41, 15);
        sickroomlabel.add(lblNewLabel_1_2);

        JLabel surpluslabel2 = new JLabel("缴费金额");
        surpluslabel2.setBounds(106, 217, 54, 15);
        sickroomlabel.add(surpluslabel2);

        pno = new JTextField(pat.getPno_c());
        pno.setBounds(117, 61, 173, 21);
        sickroomlabel.add(pno);
        pno.setColumns(10);

        pname = new JTextField(pat.getPname_c());
        pname.setBounds(117, 125, 66, 21);
        sickroomlabel.add(pname);
        pname.setColumns(10);

        surplus = new JTextField(pat.getSurplus_c());
        surplus.setBounds(396, 122, 79, 21);
        sickroomlabel.add(surplus);
        surplus.setColumns(10);

        sickroom = new JTextField(pat.getBno_c());
        sickroom.setColumns(10);
        sickroom.setBounds(396, 58, 66, 21);
        sickroomlabel.add(sickroom);

        newsurplus = new JTextField();
        newsurplus.setColumns(10);
        newsurplus.setBounds(170, 214, 79, 21);
        sickroomlabel.add(newsurplus);

        JButton btnNewButton = new JButton("确认缴费");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnNewButton.setBounds(321, 213, 93, 23);
        sickroomlabel.add(btnNewButton);

    }
}

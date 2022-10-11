package view;

import dao.SickroomDao;
import javabean.SickRoomB;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Inpatient extends JFrame {

    private JPanel contentPane;
    private JTextField pno;
    private JTable table;
    private JTable table_1;
    private JTextField mno_r;
    private JTextField bno_r;
    private JTextField mno_rr;
    private JTextField bno_rr;
    private JTextField pno_rr;

    /**
     * Create the frame.
     */
    public Inpatient() {
        setTitle("住院部系统");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(456, 22, 581, 361);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);


        JLabel id = new JLabel("患者号");
        id.setBounds(462, 87, 43, 15);
        contentPane.add(id);

        pno = new JTextField();
        pno.setColumns(10);
        pno.setBounds(510, 84, 43, 21);
        contentPane.add(pno);

        JLabel id_1 = new JLabel("病房号");
        id_1.setBounds(462, 218, 43, 15);
        contentPane.add(id_1);

        mno_rr = new JTextField();
        mno_rr.setColumns(10);
        mno_rr.setBounds(510, 215, 43, 21);
        contentPane.add(mno_rr);

        JLabel id_2 = new JLabel("病床号");
        id_2.setBounds(462, 261, 43, 15);
        contentPane.add(id_2);

        bno_rr = new JTextField();
        bno_rr.setColumns(10);
        bno_rr.setBounds(510, 258, 43, 21);
        contentPane.add(bno_rr);


        JLabel id_3 = new JLabel("患者号");
        id_3.setBounds(462, 182, 43, 15);
        contentPane.add(id_3);

        pno_rr = new JTextField();
        pno_rr.setColumns(10);
        pno_rr.setBounds(510, 179, 43, 21);
        contentPane.add(pno_rr);


        Object[][] patient = new Object[15][7];
        String[] columnNames_d_p = {"患者号", "姓名", "性别", "年龄", "患病", "病房号", "病床号"};


        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(12, 67, 438, 119);
        contentPane.add(scrollPane);

        JPanel panel = new JPanel();
        scrollPane.setViewportView(panel);
        panel.setLayout(new BorderLayout(0, 0));

        table = new JTable(patient, columnNames_d_p);
        table.getColumnModel().getColumn(0).setPreferredWidth(40);
        table.getColumnModel().getColumn(1).setPreferredWidth(50);
        table.getColumnModel().getColumn(2).setPreferredWidth(30);
        table.getColumnModel().getColumn(3).setPreferredWidth(50);
        table.getColumnModel().getColumn(4).setPreferredWidth(50);//
        table.getColumnModel().getColumn(5).setPreferredWidth(50);//
        table.getColumnModel().getColumn(6).setPreferredWidth(50);//
        panel.add(table, BorderLayout.CENTER);
        JTableHeader header_d = table.getTableHeader();
        panel.add(header_d, BorderLayout.NORTH);

        SickroomDao sickroomDao = new SickroomDao();
        sickroomDao.showpatient(patient);


        Object[][] room = new Object[40][3];
        String[] columnNames_room = {"病房号", "病床号", "状态"};

        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(12, 196, 438, 119);
        contentPane.add(scrollPane_1);

        JPanel panel_1 = new JPanel();
        scrollPane_1.setViewportView(panel_1);
        panel_1.setLayout(new BorderLayout(0, 0));

        table_1 = new JTable(room, columnNames_room);
        table_1.getColumnModel().getColumn(0).setPreferredWidth(40);
        table_1.getColumnModel().getColumn(1).setPreferredWidth(50);
        table_1.getColumnModel().getColumn(2).setPreferredWidth(30);
        panel_1.add(table_1, BorderLayout.CENTER);
        JTableHeader header_room = table_1.getTableHeader();
        panel_1.add(header_room, BorderLayout.NORTH);

        SickroomDao sickroomDao1 = new SickroomDao();
        sickroomDao1.showsickroom(room);

        JButton btnNewButton = new JButton("住院");
        btnNewButton.setBounds(462, 289, 93, 23);
        contentPane.add(btnNewButton);
        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SickRoomB sb = new SickRoomB();
                sb.setMno_room(String.valueOf(mno_rr.getText()));
                sb.setNno_room(String.valueOf(bno_rr.getText()));
                sb.setPno_rr(String.valueOf(bno_rr.getText()));
                sb.setStatus_room("已分配");
                SickroomDao sk = new SickroomDao();
                sk.join(sb);

                SickroomDao sickroomDao = new SickroomDao();
                sickroomDao.showsickroom(room);
            }
        });

        JButton btnNewButton_1 = new JButton("出院");
        btnNewButton_1.setBounds(462, 127, 93, 23);
        contentPane.add(btnNewButton_1);
        btnNewButton_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SickRoomB sb = new SickRoomB();
                sb.setPno_room(String.valueOf(pno.getText()));
                SickroomDao sk = new SickroomDao();
                sk.delete(sb);
                SickroomDao sickroomDao = new SickroomDao();
                sickroomDao.showpatient(patient);
            }
        });


        JLabel picture = new JLabel(new ImageIcon("D:\\gc\\eclipse-workspace\\医院病房管理系统\\res\\zyb.png"));
        picture.setBounds(12, 12, 543, 52);
        contentPane.add(picture);


    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Inpatient frame = new Inpatient();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}

package view;

import dao.DoctorDao;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class doctor extends JFrame {

    private JTextField dno;
    private JPanel contentPane;
    private JTextField dname;
    private JTextField dage;
    private JTextField career;
    private JTable patient;
    private JScrollPane scrollPane;
    private JTable table;

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
        careerlabel.setBounds(330, 28, 33, 15);
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
        career.setBounds(361, 25, 79, 21);
        contentPane.add(career);

        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(95, 84, 345, 194);
        contentPane.add(scrollPane_1);

        JPanel panel = new JPanel();
        scrollPane_1.setViewportView(panel);
        panel.setLayout(new BorderLayout(0, 0));

        Object[][] data_d_p = new Object[8][6];
        String[] columnNames_d_p = {"患者号", "姓名", "性别", "患病", "治疗方案"};

        table = new JTable();
        panel.add(table, BorderLayout.CENTER);
        table = new JTable(data_d_p, columnNames_d_p);
        table.getColumnModel().getColumn(0).setPreferredWidth(40);
        table.getColumnModel().getColumn(1).setPreferredWidth(50);
        table.getColumnModel().getColumn(2).setPreferredWidth(30);
        table.getColumnModel().getColumn(3).setPreferredWidth(50);
        table.getColumnModel().getColumn(4).setPreferredWidth(80);//
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
                    docdao.seedoctor(dname, dage, career, doctorno);

                }
            }
        });


    }
}

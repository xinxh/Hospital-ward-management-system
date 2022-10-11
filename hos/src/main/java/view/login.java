package view;

import dao.LoginDao;
import javabean.LoginB;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("all")
public class login extends JFrame {

    private JPanel contentPane;
    private JTextField username;
    private JPasswordField password;
    private JButton loginButton;

    public login() {
        setTitle("登录系统");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 558, 362);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);


        JLabel lblNewLabel = new JLabel("账号");
        lblNewLabel.setBounds(114, 84, 54, 26);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("密码");
        lblNewLabel_1.setBounds(114, 138, 54, 26);
        contentPane.add(lblNewLabel_1);

        // 登录按钮
        loginButton = new JButton("登录");
        // 创建监听
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 监听各个按钮
                // 进行输入框判断，为空则不进行登录操作。
                if (username.getText().isEmpty() || password.getPassword().toString().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "请输入用户名和密码", "提示信息", JOptionPane.WARNING_MESSAGE);
                } else {
                    String uname = username.getText();
                    String pawd = password.getText();
                    LoginDao logind = new LoginDao();
                    LoginB loginB = logind.userlogin1(uname, pawd);

                    if (loginB.getAdmin() == "1") {
                        manage manage = new manage();
                        manage.setVisible(true);
                        dispose();
                    } else if (loginB.getDoctor() == "1") {
                        doctor doctor = new doctor();
                        doctor.setVisible(true);
                        dispose();
                    } else if (loginB.getNurse() == "1") {
                        Inpatient inpatient = new Inpatient();
                        inpatient.setVisible(true);
                        dispose();
                    } else if (loginB.getPatient() == "1") {
                        patient patient = new patient();
                        patient.setVisible(true);
                        dispose();
                    }
                }
            }
        });
        loginButton.setBounds(202, 203, 93, 23);
        contentPane.add(loginButton);

        username = new JTextField();
        username.setBounds(192, 85, 116, 26);
        contentPane.add(username);
        username.setColumns(10);

        password = new JPasswordField();
        password.setToolTipText("");
        password.setBounds(192, 139, 116, 26);
        contentPane.add(password);
        password.setColumns(16);


        // 背景设置
        JLabel bg = new JLabel(new ImageIcon("D:\\gc\\eclipse-workspace\\医院病房管理系统\\res\\login1.jpg"));
        bg.setBounds(0, 0, 542, 323);
        contentPane.add(bg);

    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    login frame = new login();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


}

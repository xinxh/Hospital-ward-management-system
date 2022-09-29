package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import containt.containt;
import dao.logindao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JPasswordField;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JPasswordField password;

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

	/**
	 * Create the frame.
	 */
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
		JButton loginButton = new JButton("登录");
		// 创建监听
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 监听各个按钮

				// 进行输入框判断，为空则不进行登录操作。
				if (username.getText().isEmpty() || password.getPassword().toString().isEmpty()) {
					JOptionPane.showMessageDialog(null, "请输入用户名和密码", "提示信息", JOptionPane.WARNING_MESSAGE);
					
				}else {

				String uname = username.getText();
				String pawd = password.getText();
				logindao ld = new logindao();

				if (ld.userlogin(uname, pawd)) {
					JOptionPane.showMessageDialog(null, "登录成功", "提示信息", JOptionPane.WARNING_MESSAGE);
					new manage();
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "账号或者密码错误", "提示信息", JOptionPane.WARNING_MESSAGE);
					
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

	}

}

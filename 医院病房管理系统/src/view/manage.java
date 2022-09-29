package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.docterdao;
import javabean.docterb;

import javax.swing.JPopupMenu;
import java.awt.Component;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextArea;

public class manage extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTable table;
	private JTable table_1;
	private JTextField textField_9;

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

	/**
	 * Create the frame.
	 */
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
		panel.setLayout(null);
		String[] department = new String[] { " ", "计科", "软工", "智科", "信安", "信抗" };

		// 病床panel
		JPanel sickroomp = new JPanel();
		sickroomp.setLayout(null);
		sickroomp.setBounds(0, 0, 581, 361);
		sickroomp.setVisible(false);
		panel.add(sickroomp);

		JLabel lblNewLabel11 = new JLabel("病房号");
		lblNewLabel11.setBounds(64, 21, 51, 24);
		sickroomp.add(lblNewLabel11);

		JButton btnNewButton11 = new JButton("添加病房");
		
		btnNewButton11.setBounds(64, 263, 93, 23);
		sickroomp.add(btnNewButton11);

		JButton btnNewButton_111 = new JButton("删除病房");
		btnNewButton_111.setBounds(251, 263, 93, 23);
		sickroomp.add(btnNewButton_111);

		JButton btnNewButton_211 = new JButton("病房信息更改");
		btnNewButton_211.setBounds(414, 263, 111, 23);
		sickroomp.add(btnNewButton_211);

		JButton btnNewButton_31 = new JButton("添加病床");
		
		btnNewButton_31.setBounds(64, 308, 93, 23);
		sickroomp.add(btnNewButton_31);

		JButton btnNewButton_1_1 = new JButton("删除病床");
		btnNewButton_1_1.setBounds(251, 308, 93, 23);
		sickroomp.add(btnNewButton_1_1);

		JButton btnNewButton_2_1 = new JButton("病床信息更改");
		btnNewButton_2_1.setBounds(414, 308, 111, 23);
		sickroomp.add(btnNewButton_2_1);

		JLabel lblNewLabel_21 = new JLabel("病床号");
		lblNewLabel_21.setBounds(234, 21, 51, 24);
		sickroomp.add(lblNewLabel_21);

		JLabel lblNewLabel_2_1 = new JLabel("状态");
		lblNewLabel_2_1.setBounds(402, 21, 36, 24);
		sickroomp.add(lblNewLabel_2_1);

		table_1 = new JTable();
		table_1.setBounds(110, 63, 408, 178);
		sickroomp.add(table_1);

		JLabel lblNewLabel11_1 = new JLabel("病房");
		lblNewLabel11_1.setBounds(64, 63, 29, 24);
		sickroomp.add(lblNewLabel11_1);

		JLabel lblNewLabel11_1_1 = new JLabel("病床");
		lblNewLabel11_1_1.setBounds(64, 83, 29, 24);
		sickroomp.add(lblNewLabel11_1_1);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(110, 22, 47, 23);
		comboBox_1.addItem("");
		comboBox_1.addItem("201");
		sickroomp.add(comboBox_1);

		JComboBox comboBox_1_1 = new JComboBox();
		comboBox_1_1.setBounds(282, 22, 62, 23);
		comboBox_1_1.addItem("");
		comboBox_1_1.addItem("1");
		comboBox_1_1.addItem("2");
		comboBox_1_1.addItem("3");
		comboBox_1_1.addItem("4");
		sickroomp.add(comboBox_1_1);

		JComboBox comboBox_1_2 = new JComboBox();
		comboBox_1_2.setBounds(439, 22, 62, 23);
		comboBox_1_2.addItem("");
		comboBox_1_2.addItem("已分配");
		comboBox_1_2.addItem("未分配");
		sickroomp.add(comboBox_1_2);

		// 护士panel
		JPanel nursep = new JPanel();
		nursep.setLayout(null);
		nursep.setBounds(0, 0, 581, 361);
		nursep.setVisible(false);
		JLabel lblNewLabel111 = new JLabel("护士编号");
		lblNewLabel111.setBounds(49, 306, 62, 26);
		nursep.add(lblNewLabel111);
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(141, 309, 90, 21);
		nursep.add(textField_8);

		JButton btnNewButton_41 = new JButton("确定");
		btnNewButton_41.setBounds(282, 308, 93, 23);
		nursep.add(btnNewButton_41);

		JTextPane textPane1 = new JTextPane();
		textPane1.setBounds(76, 26, 114, 21);
		nursep.add(textPane1);

		JLabel lblNewLabel_1111 = new JLabel("姓名");
		lblNewLabel_1111.setBounds(19, 21, 44, 26);
		nursep.add(lblNewLabel_1111);

		JLabel lblNewLabel_1_11 = new JLabel("性别");
		lblNewLabel_1_11.setBounds(213, 21, 30, 26);
		nursep.add(lblNewLabel_1_11);

		JLabel lblNewLabel_1_21 = new JLabel("年龄");
		lblNewLabel_1_21.setBounds(329, 21, 30, 26);
		nursep.add(lblNewLabel_1_21);

		JTextPane textPane_1_111 = new JTextPane();
		textPane_1_111.setBounds(369, 26, 36, 21);
		nursep.add(textPane_1_111);

		JLabel lblNewLabel_1_31 = new JLabel("联系方式");
		lblNewLabel_1_31.setBounds(19, 70, 53, 26);
		nursep.add(lblNewLabel_1_31);

		JLabel lblNewLabel_1_41 = new JLabel("科室");
		lblNewLabel_1_41.setBounds(213, 70, 30, 26);
		nursep.add(lblNewLabel_1_41);

		JLabel lblNewLabel_1_51 = new JLabel("职称");
		lblNewLabel_1_51.setBounds(329, 70, 30, 26);
		nursep.add(lblNewLabel_1_51);

		JTextPane textPane_21 = new JTextPane();
		textPane_21.setBounds(76, 70, 114, 21);
		nursep.add(textPane_21);

		JTextPane textPane_1_311 = new JTextPane();
		textPane_1_311.setBounds(369, 75, 36, 21);
		nursep.add(textPane_1_311);

		JButton btnNewButton_4_11 = new JButton("删除护士");
		btnNewButton_4_11.setBounds(456, 260, 93, 23);
		nursep.add(btnNewButton_4_11);

		JButton btnNewButton_4_21 = new JButton("信息更改");
		btnNewButton_4_21.setBounds(456, 308, 93, 23);
		nursep.add(btnNewButton_4_21);

		JButton btnNewButton_4_31 = new JButton("新建护士");

		btnNewButton_4_31.setBounds(456, 212, 93, 23);
		nursep.add(btnNewButton_4_31);

		JComboBox comboBox_31 = new JComboBox();
		comboBox_31.setBounds(247, 24, 44, 23);
		comboBox_31.addItem("男");
		comboBox_31.addItem("女");
		nursep.add(comboBox_31);

		JComboBox comboBox_3_11 = new JComboBox();
		comboBox_3_11.setBounds(247, 72, 62, 23);
		nursep.add(comboBox_3_11);

		table = new JTable();
		table.setBounds(78, 136, 368, 147);
		nursep.add(table);
		panel.add(nursep);
		JLabel lblNewLabel_1_31_1 = new JLabel("排班信息");
		lblNewLabel_1_31_1.setBounds(19, 136, 53, 26);
		nursep.add(lblNewLabel_1_31_1);
		for (int i = 0; i < department.length; i++) {
			comboBox_3_11.addItem(department[i]);
		}

		

		// 医生panel
		JPanel docterp = new JPanel();
		docterp.setLayout(null);
		docterp.setBounds(0, 0, 581, 361);
		docterp.setVisible(false);
		panel.add(docterp);
		JLabel lblNewLabel = new JLabel("医生编号");
		lblNewLabel.setBounds(49, 306, 62, 26);
		docterp.add(lblNewLabel);
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(121, 309, 90, 21);
		docterp.add(textField_1);
		JButton btnNewButton_4 = new JButton("确定查询");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String docterdno=textField_1.getText();//获取文本值
				docterb dob= new docterb();
				dob.setDno(docterdno);//stedno
				docterdao docdao= new docterdao();
				
			}
		});
		btnNewButton_4.setBounds(247, 308, 93, 23);
		docterp.add(btnNewButton_4);
		JTextPane textPane = new JTextPane();
		textPane.setBounds(76, 26, 114, 21);
		docterp.add(textPane);
		JLabel lblNewLabel_1 = new JLabel("姓名");
		lblNewLabel_1.setBounds(19, 21, 47, 26);
		docterp.add(lblNewLabel_1);
		JLabel lblNewLabel_1_1 = new JLabel("性别");
		lblNewLabel_1_1.setBounds(213, 21, 30, 26);
		docterp.add(lblNewLabel_1_1);
		JLabel lblNewLabel_1_2 = new JLabel("年龄");
		lblNewLabel_1_2.setBounds(329, 21, 30, 26);
		docterp.add(lblNewLabel_1_2);
		JTextPane textPane_1_1 = new JTextPane();
		textPane_1_1.setBounds(369, 26, 36, 21);
		docterp.add(textPane_1_1);
		JLabel lblNewLabel_1_3 = new JLabel("联系方式");
		lblNewLabel_1_3.setBounds(19, 70, 53, 26);
		docterp.add(lblNewLabel_1_3);
		JLabel lblNewLabel_1_4 = new JLabel("科室");
		lblNewLabel_1_4.setBounds(213, 70, 30, 26);
		docterp.add(lblNewLabel_1_4);
		JLabel lblNewLabel_1_5 = new JLabel("职称");
		lblNewLabel_1_5.setBounds(329, 70, 30, 26);
		docterp.add(lblNewLabel_1_5);
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setBounds(76, 70, 114, 21);
		docterp.add(textPane_2);
		JTextPane textPane_1_3 = new JTextPane();
		textPane_1_3.setBounds(369, 75, 36, 21);
		docterp.add(textPane_1_3);
		JButton btnNewButton_4_1 = new JButton("删除医生");
		btnNewButton_4_1.setBounds(456, 260, 93, 23);
		docterp.add(btnNewButton_4_1);
		JButton btnNewButton_4_2 = new JButton("信息更改");
		btnNewButton_4_2.setBounds(456, 308, 93, 23);
		docterp.add(btnNewButton_4_2);
		JButton btnNewButton_4_3 = new JButton("新建医生");
		btnNewButton_4_3.setBounds(456, 212, 93, 23);
		docterp.add(btnNewButton_4_3);
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(247, 24, 44, 23);
		comboBox_3.addItem("男");
		comboBox_3.addItem("女");
		docterp.add(comboBox_3);
		JComboBox 医生科室 = new JComboBox();
		医生科室.setToolTipText("12");
		医生科室.setBounds(247, 72, 62, 23);
		for (int i = 0; i < department.length; i++) {
			医生科室.addItem(department[i]);}
		docterp.add(医生科室);
		JLabel lblNewLabel_1_3_1 = new JLabel("患者信息");
		lblNewLabel_1_3_1.setBounds(19, 133, 53, 26);
		docterp.add(lblNewLabel_1_3_1);
		JTextArea textArea = new JTextArea();
		textArea.setBounds(76, 134, 329, 149);
		docterp.add(textArea);

		// 病人panel
		JPanel patientp = new JPanel();
		patientp.setLayout(null);
		patientp.setBounds(0, 0, 581, 361);
		patientp.setVisible(false);
		panel.add(patientp);

		JLabel lblNewLabel1 = new JLabel("姓名");
		lblNewLabel1.setBounds(41, 30, 29, 15);
		patientp.add(lblNewLabel1);

		JLabel lblNewLabel_11 = new JLabel("性别");
		lblNewLabel_11.setBounds(201, 30, 29, 15);
		patientp.add(lblNewLabel_11);

		JLabel lblNewLabel_2 = new JLabel("年龄");
		lblNewLabel_2.setBounds(360, 30, 29, 15);
		patientp.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("患病");
		lblNewLabel_3.setBounds(41, 79, 29, 15);
		patientp.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("余额");
		lblNewLabel_4.setBounds(41, 134, 29, 15);
		patientp.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("主治医生");
		lblNewLabel_5.setBounds(199, 74, 61, 24);
		patientp.add(lblNewLabel_5);

		JLabel lblNewLabel_5_1 = new JLabel("责任护士");
		lblNewLabel_5_1.setBounds(360, 74, 61, 24);
		patientp.add(lblNewLabel_5_1);

		JButton btnNewButton1 = new JButton("添加患者");

		btnNewButton1.setBounds(418, 144, 93, 23);
		patientp.add(btnNewButton1);

		JButton btnNewButton_11 = new JButton("删除患者");
		btnNewButton_11.setBounds(418, 210, 93, 23);
		patientp.add(btnNewButton_11);

		JButton btnNewButton_21 = new JButton("信息更改");
		btnNewButton_21.setBounds(418, 285, 93, 23);
		patientp.add(btnNewButton_21);

		JTextField tz = new JTextField();
		tz.setColumns(10);
		tz.setBounds(68, 27, 68, 21);

		tz.setVisible(false);
		patientp.add(tz);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(68, 27, 68, 21);
		patientp.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(270, 76, 66, 21);
		patientp.add(textField_3);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(418, 76, 66, 21);
		patientp.add(textField_4);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(70, 131, 66, 21);
		patientp.add(textField_5);

		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(70, 76, 66, 21);
		patientp.add(textField_6);

		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(420, 27, 66, 21);
		patientp.add(textField_7);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(270, 26, 53, 23);
		comboBox.addItem("男");
		comboBox.addItem("女");
		patientp.add(comboBox);

		JLabel lblNewLabel_5_2 = new JLabel("患者身份证");
		lblNewLabel_5_2.setBounds(41, 302, 68, 24);
		patientp.add(lblNewLabel_5_2);

		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(119, 304, 139, 21);
		patientp.add(textField_9);

		JButton btnNewButton_21_1 = new JButton("查询");
		btnNewButton_21_1.setBounds(296, 303, 93, 23);
		patientp.add(btnNewButton_21_1);

//按钮事件
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				patientp.setVisible(false);
				sickroomp.setVisible(false);
				docterp.setVisible(false);
				nursep.setVisible(true);
			}
		});

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				patientp.setVisible(false);
				sickroomp.setVisible(false);
				nursep.setVisible(false);
				docterp.setVisible(true);
			}
		});

		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				sickroomp.setVisible(false);
				nursep.setVisible(false);
				docterp.setVisible(false);
				patientp.setVisible(true);
			}

		});
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				nursep.setVisible(false);
				docterp.setVisible(false);
				patientp.setVisible(false);
				sickroomp.setVisible(true);

			}
		});
		// 新建功能
		btnNewButton_4_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tz.setText("docter");
				String tt = tz.getText();
				new add(tt);
				new add(tt);
				new add();
			}
		});
		btnNewButton_4_31.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tz.setText("nurse");
				String tt = tz.getText();
				new add(tt);
				new add(tt);
				new add();
				
			}
		});
		btnNewButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tz.setText("patient");
				String tt = tz.getText();
				new add(tt);
				new add();
			}
		});
		btnNewButton11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tz.setText("sickroom");
				String tt = tz.getText();
				new add(tt);
				new add(tt);
				new add();
			}
		});
		btnNewButton_31.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tz.setText("sickroom");
				String tt = tz.getText();
				new add(tt);
				new add(tt);
				new add();
			}
		});

	}

	
}

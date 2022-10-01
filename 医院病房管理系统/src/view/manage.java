package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.doctordao;
import dao.managedao;
import javabean.doctorb;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextArea;

public class manage extends JFrame {

	private final JComboBox nsex;
	private JPanel contentPane;
	private JTextField dno;
	private JTextField pname;
	private JTextField dname_p;
	private JTextField nname_p;
	private JTextField surplus;
	private JTextField sicken;
	private JTextField page;
	private JTextField nno;
	private JTable table;
	private JTable table_1;
	private JTextField pno;
	private JTextPane dname;
	private JTextPane dage;
	private JComboBox dsex;
	private JTextPane contact;
	private JTextPane career;
	private JComboBox dono;
	private JTable 患者信息table;

	private doctorb doc;
	private JComboBox psex;
	private JComboBox nono;

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

		doctordao docdao = new doctordao();
		managedao madao = new managedao();

		doctorb docb = new doctorb();
		panel.setLayout(null);
		String[] department = new String[] { "精神科", "内科", "外科", "眼科", "皮肤科", "妇科","儿科","急诊","血液科" };






// 护士panel
		JPanel nursep = new JPanel();
		nursep.setLayout(null);
		nursep.setBounds(0, 0, 581, 361);
		nursep.setVisible(false);

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
		排版信息label.setBounds(19, 136, 53, 26);
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
				// 进行输入框判断，为空则不进行登录操作。
				if (nno.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "请输入编号", "提示信息", JOptionPane.WARNING_MESSAGE);
				} else {
					String nurseno = nno.getText();// 获取文本值
					madao.seepatient(nname, nage, nsex, ncontact, ncareer, nurseno);
				}
			}
		});

		JButton 删除护士 = new JButton("删除护士");
		删除护士.setBounds(456, 260, 93, 23);
		nursep.add(删除护士);

		JButton 信息更改11 = new JButton("信息更改");
		信息更改11.setBounds(456, 308, 93, 23);
		nursep.add(信息更改11);

		JButton 新建护士 = new JButton("新建护士");
		新建护士.setBounds(456, 212, 93, 23);
		nursep.add(新建护士);

		table = new JTable();
		table.setBounds(78, 136, 368, 147);
		nursep.add(table);
		panel.add(nursep);
		
		// 病人panel
				JPanel patientp = new JPanel();
				patientp.setLayout(null);
				patientp.setBounds(0, 0, 581, 361);
				patientp.setVisible(false);
				panel.add(patientp);

				JLabel 姓名label = new JLabel("姓名");
				姓名label.setBounds(41, 30, 29, 15);
				patientp.add(姓名label);

				JLabel 性别label = new JLabel("性别");
				性别label.setBounds(201, 30, 29, 15);
				patientp.add(性别label);

				JLabel 年龄label = new JLabel("年龄");
				年龄label.setBounds(360, 30, 29, 15);
				patientp.add(年龄label);

				JLabel 患病label = new JLabel("患病");
				患病label.setBounds(41, 79, 29, 15);
				patientp.add(患病label);

				JLabel 余额label = new JLabel("余额");
				余额label.setBounds(41, 134, 29, 15);
				patientp.add(余额label);

				JLabel 住址医生label = new JLabel("主治医生");
				住址医生label.setBounds(199, 74, 61, 24);
				patientp.add(住址医生label);

				JLabel 责任护士label = new JLabel("责任护士");
				责任护士label.setBounds(360, 74, 61, 24);
				patientp.add(责任护士label);

				JLabel 患者身份证label = new JLabel("患者身份证");
				患者身份证label.setBounds(41, 302, 68, 24);
				patientp.add(患者身份证label);

				JButton 查询 = new JButton("查询");
				查询.setBounds(296, 303, 93, 23);
				patientp.add(查询);
				查询.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// 进行输入框判断，为空则不进行登录操作。
						if (pno.getText().isEmpty()) {
							JOptionPane.showMessageDialog(null, "请输入编号", "提示信息", JOptionPane.WARNING_MESSAGE);
						} else {
							String patientno = pno.getText();// 获取文本值
							madao.seepatient(pname, page, psex,sicken,surplus,dname_p,nname_p, patientno);
						}
					}
				});

				JButton 添加患者 = new JButton("添加患者");
				添加患者.setBounds(418, 144, 93, 23);
				patientp.add(添加患者);

				JButton 删除患者 = new JButton("删除患者");
				删除患者.setBounds(418, 210, 93, 23);
				patientp.add(删除患者);

				JButton 信息更改 = new JButton("信息更改");

				信息更改.setBounds(418, 285, 93, 23);
				patientp.add(信息更改);

				pname = new JTextField();
				pname.setColumns(10);
				pname.setBounds(68, 27, 90, 20);
				patientp.add(pname);

				dname_p = new JTextField();
				dname_p.setColumns(10);
				dname_p.setBounds(259, 76, 80, 20);
				patientp.add(dname_p);

				nname_p = new JTextField();
				nname_p.setColumns(10);
				nname_p.setBounds(418, 76, 80, 20);
				patientp.add(nname_p);

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
				page.setBounds(420, 27, 80, 20);
				patientp.add(page);

				pno = new JTextField();
				pno.setColumns(10);
				pno.setBounds(119, 304, 139, 21);
				patientp.add(pno);

				psex = new JComboBox();
				psex.setBounds(259, 26, 53, 23);
				psex.addItem("男");
				psex.addItem("女");
				patientp.add(psex);
				
				
				// 医生panel
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

				JButton 信息更改1 = new JButton("信息更改");
				信息更改1.setBounds(456, 308, 93, 23);
				doctorp.add(信息更改1);

				JButton 新建医生 = new JButton("新建医生");
				新建医生.setBounds(456, 212, 93, 23);
				doctorp.add(新建医生);

				JButton 确定 = new JButton("确定");
				确定.setBounds(247, 308, 93, 23);
				doctorp.add(确定);
				确定.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// 进行输入框判断，为空则不进行登录操作。
						if (dno.getText().isEmpty()) {
							JOptionPane.showMessageDialog(null, "请输入编号输入有误", "提示信息", JOptionPane.WARNING_MESSAGE);
						} else {
							String doctorno = dno.getText();// 获取文本值
							madao.seedoctor(dname, dage, dsex, contact, career, dono, doctorno);
						}
					}
				});

				dno = new JTextField();
				dno.setColumns(10);
				dno.setBounds(110, 309, 114, 21);
				doctorp.add(dno);

				dname = new JTextPane();
				dname.setBounds(76, 26, 114, 21);
				dname.setText(docb.getDname());
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

				患者信息table = new JTable();
				患者信息table.setBounds(76, 139, 355, 144);
				doctorp.add(患者信息table);
				
				
				// 病床panel
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

				JButton 添加病房 = new JButton("添加病房");
				添加病房.setBounds(64, 263, 93, 23);
				sickroomp.add(添加病房);

				JButton 删除病房 = new JButton("删除病房");
				删除病房.setBounds(251, 263, 93, 23);
				sickroomp.add(删除病房);

				JButton 病房信息更改 = new JButton("病房信息更改");
				病房信息更改.setBounds(414, 263, 111, 23);
				sickroomp.add(病房信息更改);

				JButton 添加病床 = new JButton("添加病床");
				添加病床.setBounds(64, 308, 93, 23);
				sickroomp.add(添加病床);

				JButton 删除病床 = new JButton("删除病床");
				删除病床.setBounds(251, 308, 93, 23);
				sickroomp.add(删除病床);

				JButton 病床信息更改 = new JButton("病床信息更改");
				病床信息更改.setBounds(414, 308, 111, 23);
				sickroomp.add(病床信息更改);

				table_1 = new JTable();
				table_1.setBounds(110, 63, 408, 178);
				sickroomp.add(table_1);

				JComboBox mno = new JComboBox();
				mno.setBounds(110, 22, 47, 23);
				mno.addItem("101");
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
		
		

//设置panel的可见性
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				patientp.setVisible(false);
				sickroomp.setVisible(false);
				doctorp.setVisible(false);
				nursep.setVisible(true);
			}
		});

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				patientp.setVisible(false);
				sickroomp.setVisible(false);
				nursep.setVisible(false);
				doctorp.setVisible(true);
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

			}
		});
// 新建功能
		新建医生.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pname.setText("doctor");
				String tt = pname.getText();
				new Add(tt);
				new Add();
			}
		});
		新建护士.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pname.setText("nurse");
				String tt = pname.getText();
				new Add(tt);
				new Add();

			}
		});
		添加患者.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pname.setText("patient");
				String tt = pname.getText();
				new Add(tt);
				new Add();
			}
		});
		添加病房.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pname.setText("sickroom");
				String tt = pname.getText();
				new Add(tt);
				new Add();
			}
		});
		添加病床.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pname.setText("sickroom");
				String tt = pname.getText();
				new Add(tt);
				new Add();
			}
		});

	}

}

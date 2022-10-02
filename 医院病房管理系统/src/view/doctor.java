package view;

import dao.Doctordao;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class doctor extends JFrame {

	private JTextField dno;
	private JPanel contentPane;
	private JTextField dname;
	private JTextField dage;
	private JTextField career;
	private JTable patient;

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
		Doctordao docdao = new Doctordao();
		
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
		careerlabel.setBounds(310, 25, 33, 15);
		contentPane.add(careerlabel);

		JLabel pictures = new JLabel("照片");
		pictures.setBounds(445, 22, 93, 109);
		contentPane.add(pictures);

		JLabel patientlabel = new JLabel("当前患者");
		patientlabel.setBounds(27, 97, 58, 15);
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
		career.setBounds(341, 22, 79, 21);
		contentPane.add(career);

		patient = new JTable();
		patient.setBounds(86, 97, 334, 161);
		contentPane.add(patient);

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
					docdao.seedoctor(dname, dage,career, doctorno);
				}
			}
		});

		JButton btnNewButton_1_1 = new JButton("诊断结束");
		btnNewButton_1_1.setBounds(445, 235, 93, 23);
		contentPane.add(btnNewButton_1_1);
	}
}

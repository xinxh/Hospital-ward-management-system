package view;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class add extends JFrame {

	private JPanel contentPane;
	private static String text;
	private JTextField textField_10;
	private JTextField textField_12;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_11;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					add frame = new add();
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
	// 构造方法
	public add(String text) {
		this.text = text;
	}

	public add() {
		this(text);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		setBounds(100, 100, 598, 401);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// 病房病床
		JPanel addsickroom = new JPanel();
		contentPane.add(addsickroom);
		addsickroom.setBounds(0, 0, 581, 361);
		addsickroom.setLayout(null);

		JLabel lblNewLabel_5_2 = new JLabel("输入病房号");
		lblNewLabel_5_2.setBounds(184, 67, 71, 15);
		addsickroom.add(lblNewLabel_5_2);

		JLabel lblNewLabel_2_1_2 = new JLabel("输入病床号");
		lblNewLabel_2_1_2.setBounds(184, 160, 71, 15);
		addsickroom.add(lblNewLabel_2_1_2);

		textField_17 = new JTextField();
		textField_17.setColumns(10);
		textField_17.setBounds(289, 64, 66, 21);
		addsickroom.add(textField_17);

		JButton btnNewButton_1_2 = new JButton("确认");
		btnNewButton_1_2.setBounds(234, 283, 93, 23);
		addsickroom.add(btnNewButton_1_2);

		textField_18 = new JTextField();
		textField_18.setColumns(10);
		textField_18.setBounds(289, 157, 66, 21);
		addsickroom.add(textField_18);

		// 护士
		JPanel addnurse = new JPanel();
		contentPane.add(addnurse);
		addnurse.setBounds(0, 0, 581, 361);
		addnurse.setLayout(null);

		JLabel lblNewLabel_5_1 = new JLabel("姓名");
		lblNewLabel_5_1.setBounds(363, 39, 40, 15);
		addnurse.add(lblNewLabel_5_1);

		JLabel lblNewLabel_1_2_1 = new JLabel("护士编号");
		lblNewLabel_1_2_1.setBounds(69, 39, 75, 15);
		addnurse.add(lblNewLabel_1_2_1);

		JLabel lblNewLabel_2_1_1 = new JLabel("年龄");
		lblNewLabel_2_1_1.setBounds(363, 91, 40, 15);
		addnurse.add(lblNewLabel_2_1_1);

		JLabel lblNewLabel_3_1_1 = new JLabel("性别");
		lblNewLabel_3_1_1.setBounds(69, 97, 40, 15);
		addnurse.add(lblNewLabel_3_1_1);

		JLabel lblNewLabel_4_2_1 = new JLabel("科室");
		lblNewLabel_4_2_1.setBounds(69, 163, 40, 15);
		addnurse.add(lblNewLabel_4_2_1);

		JLabel lblNewLabel_4_1_1_1 = new JLabel("职称");
		lblNewLabel_4_1_1_1.setBounds(363, 163, 50, 15);
		addnurse.add(lblNewLabel_4_1_1_1);

		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(432, 36, 66, 21);
		addnurse.add(textField_11);

		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(137, 36, 106, 21);
		addnurse.add(textField_13);

		textField_14 = new JTextField();
		textField_14.setColumns(10);
		textField_14.setBounds(432, 88, 66, 21);
		addnurse.add(textField_14);

		textField_15 = new JTextField();
		textField_15.setColumns(10);
		textField_15.setBounds(432, 160, 66, 21);
		addnurse.add(textField_15);

		JComboBox comboBox_1_2 = new JComboBox();
		comboBox_1_2.setBounds(137, 87, 66, 23);
		addnurse.add(comboBox_1_2);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("联系方式");
		lblNewLabel_1_1_1_1.setBounds(69, 222, 59, 15);
		addnurse.add(lblNewLabel_1_1_1_1);

		textField_16 = new JTextField();
		textField_16.setColumns(10);
		textField_16.setBounds(137, 219, 106, 21);
		addnurse.add(textField_16);

		JButton btnNewButton_1_1 = new JButton("确认");
		btnNewButton_1_1.setBounds(244, 287, 93, 23);
		addnurse.add(btnNewButton_1_1);

		JComboBox comboBox_1_1_1 = new JComboBox();
		comboBox_1_1_1.setBounds(137, 159, 66, 23);
		addnurse.add(comboBox_1_1_1);

		// 医生
		JPanel adddocter = new JPanel();
		adddocter.setBounds(0, 0, 581, 361);
		contentPane.add(adddocter);
		adddocter.setLayout(null);

		JLabel lblNewLabel_5 = new JLabel("姓名");
		lblNewLabel_5.setBounds(363, 39, 40, 15);
		adddocter.add(lblNewLabel_5);

		JLabel lblNewLabel_1_2 = new JLabel("医生编号");
		lblNewLabel_1_2.setBounds(69, 39, 75, 15);
		adddocter.add(lblNewLabel_1_2);

		JLabel lblNewLabel_2_1 = new JLabel("年龄");
		lblNewLabel_2_1.setBounds(363, 91, 40, 15);
		adddocter.add(lblNewLabel_2_1);

		JLabel lblNewLabel_3_1 = new JLabel("性别");
		lblNewLabel_3_1.setBounds(69, 97, 40, 15);
		adddocter.add(lblNewLabel_3_1);

		JLabel lblNewLabel_4_2 = new JLabel("科室");
		lblNewLabel_4_2.setBounds(69, 163, 40, 15);
		adddocter.add(lblNewLabel_4_2);

		JLabel lblNewLabel_4_1_1 = new JLabel("职称");
		lblNewLabel_4_1_1.setBounds(363, 163, 50, 15);
		adddocter.add(lblNewLabel_4_1_1);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(432, 36, 66, 21);
		adddocter.add(textField_5);

		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(137, 36, 106, 21);
		adddocter.add(textField_6);

		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(432, 88, 66, 21);
		adddocter.add(textField_7);

		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(432, 160, 66, 21);
		adddocter.add(textField_8);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(137, 87, 66, 23);
		adddocter.add(comboBox_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("联系方式");
		lblNewLabel_1_1_1.setBounds(69, 222, 59, 15);
		adddocter.add(lblNewLabel_1_1_1);

		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(137, 219, 106, 21);
		adddocter.add(textField_9);

		JButton btnNewButton_1 = new JButton("确认");
		btnNewButton_1.setBounds(244, 287, 93, 23);
		adddocter.add(btnNewButton_1);

		JComboBox comboBox_1_1 = new JComboBox();
		comboBox_1_1.setBounds(137, 159, 66, 23);
		adddocter.add(comboBox_1_1);

		// 病人
		JPanel addpatient = new JPanel();
		addpatient.setBounds(0, 0, 581, 361);
		contentPane.add(addpatient);
		addpatient.setLayout(null);
		addpatient.setVisible(false);

		JLabel lblNewLabel = new JLabel("姓名");
		lblNewLabel.setBounds(357, 27, 40, 15);
		addpatient.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("病人身份证");
		lblNewLabel_1.setBounds(63, 27, 75, 15);
		addpatient.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("年龄");
		lblNewLabel_2.setBounds(357, 79, 40, 15);
		addpatient.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("性别");
		lblNewLabel_3.setBounds(63, 85, 40, 15);
		addpatient.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("患病");
		lblNewLabel_4.setBounds(63, 151, 40, 15);
		addpatient.add(lblNewLabel_4);

		JLabel lblNewLabel_4_1 = new JLabel("主治医生");
		lblNewLabel_4_1.setBounds(357, 151, 59, 15);
		addpatient.add(lblNewLabel_4_1);

		JTextField textField = new JTextField();
		textField.setBounds(426, 24, 66, 21);
		textField.setColumns(10);
		addpatient.add(textField);

		JTextField textField_1 = new JTextField();
		textField_1.setBounds(131, 24, 106, 21);
		textField_1.setColumns(10);
		addpatient.add(textField_1);

		JTextField textField_2 = new JTextField();
		textField_2.setBounds(426, 76, 66, 21);
		textField_2.setColumns(10);
		addpatient.add(textField_2);

		JTextField textField_3 = new JTextField();
		textField_3.setBounds(426, 148, 66, 21);
		textField_3.setColumns(10);
		addpatient.add(textField_3);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(131, 75, 66, 23);
		addpatient.add(comboBox);

		JLabel lblNewLabel_1_1 = new JLabel("联系方式");
		lblNewLabel_1_1.setBounds(63, 210, 59, 15);
		addpatient.add(lblNewLabel_1_1);

		JTextField textField_4 = new JTextField();
		textField_4.setBounds(131, 207, 106, 21);
		textField_4.setColumns(10);
		addpatient.add(textField_4);

		JButton btnNewButton = new JButton("确认");
		btnNewButton.setBounds(238, 275, 93, 23);
		addpatient.add(btnNewButton);

		JLabel lblNewLabel_4_1_2 = new JLabel("责任护士");
		lblNewLabel_4_1_2.setBounds(357, 210, 59, 15);
		addpatient.add(lblNewLabel_4_1_2);

		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(426, 207, 66, 21);
		addpatient.add(textField_10);

		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(131, 148, 66, 21);
		addpatient.add(textField_12);
		
		// 选择跳转的功能
		if (text.equals("patient")) {
			adddocter.setVisible(false);
			addsickroom.setVisible(false);
			addnurse.setVisible(false);
			addpatient.setVisible(true);

		} else if (text.equals("docter")) {

			addsickroom.setVisible(false);
			addnurse.setVisible(false);
			addpatient.setVisible(false);
			adddocter.setVisible(true);

		} else if (text.equals("sickroom")) {

			addnurse.setVisible(false);
			addpatient.setVisible(false);
			adddocter.setVisible(false);
			addsickroom.setVisible(true);

		} else if (text.equals("nurse")) {

			addsickroom.setVisible(false);

			addpatient.setVisible(false);
			adddocter.setVisible(false);
			addnurse.setVisible(true);

		}

	}
}

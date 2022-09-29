package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;

public class docter extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					docter frame = new docter();
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
	public docter() {
		setTitle("医生系统");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(456, 22, 581, 361);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("医生编号");
		lblNewLabel_5.setBounds(76, 293, 58, 15);
		contentPane.add(lblNewLabel_5);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(134, 290, 130, 21);
		contentPane.add(textField);
		
		JButton btnNewButton_1 = new JButton("查询");
		btnNewButton_1.setBounds(327, 289, 93, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("姓名");
		lblNewLabel.setBounds(27, 25, 33, 15);
		contentPane.add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(86, 22, 66, 21);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel_1 = new JLabel("年龄");
		lblNewLabel_1.setBounds(183, 25, 33, 15);
		contentPane.add(lblNewLabel_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(214, 22, 66, 21);
		contentPane.add(textField_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("职称");
		lblNewLabel_1_1.setBounds(310, 25, 33, 15);
		contentPane.add(lblNewLabel_1_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(341, 22, 66, 21);
		contentPane.add(textField_3);
		
		JLabel lblNewLabel_2 = new JLabel("照片");
		lblNewLabel_2.setBounds(445, 22, 93, 109);
		contentPane.add(lblNewLabel_2);
		
		table = new JTable();
		table.setBounds(86, 97, 321, 161);
		contentPane.add(table);
		
		JLabel lblNewLabel_3 = new JLabel("当前患者");
		lblNewLabel_3.setBounds(27, 97, 58, 15);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton_1_1 = new JButton("诊断结束");
		btnNewButton_1_1.setBounds(445, 235, 93, 23);
		contentPane.add(btnNewButton_1_1);
	}
}

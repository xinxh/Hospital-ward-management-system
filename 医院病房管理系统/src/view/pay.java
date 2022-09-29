package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class pay extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pay frame = new pay();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @return 
	 */
	
	
	public pay() {
		setTitle("缴费系统");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(446, 235, 581, 361);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setVisible(true);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("身份证");
		lblNewLabel.setBounds(42, 24, 48, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("姓名");
		lblNewLabel_1.setBounds(42, 68, 41, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("当前余额");
		lblNewLabel_1_1.setBounds(300, 68, 57, 15);
		contentPane.add(lblNewLabel_1_1);
		
		textField = new JTextField();
		textField.setBounds(100, 21, 173, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(100, 65, 66, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(367, 65, 79, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_1_2 = new JLabel("床位");
		lblNewLabel_1_2.setBounds(300, 24, 41, 15);
		contentPane.add(lblNewLabel_1_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(367, 21, 66, 21);
		contentPane.add(textField_3);
		
		JLabel lblNewLabel_2 = new JLabel("缴费金额");
		lblNewLabel_2.setBounds(85, 278, 54, 15);
		contentPane.add(lblNewLabel_2);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(149, 275, 79, 21);
		contentPane.add(textField_4);
		
		JButton btnNewButton = new JButton("确认缴费");
		
		btnNewButton.setBounds(300, 274, 93, 23);
		contentPane.add(btnNewButton);
		
		table = new JTable();
		table.setBounds(100, 133, 409, 112);
		contentPane.add(table);
		
		JLabel lblNewLabel_2_1 = new JLabel("已使用药品");
		lblNewLabel_2_1.setBounds(24, 133, 66, 15);
		contentPane.add(lblNewLabel_2_1);
	}
}

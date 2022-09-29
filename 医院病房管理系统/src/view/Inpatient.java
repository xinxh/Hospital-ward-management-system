package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class Inpatient extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;

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

	/**
	 * Create the frame.
	 */
	public Inpatient() {
		setTitle("住院部系统");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(456, 22, 581, 361);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		String[] department = new String[] { " ", "计科", "软工", "智科", "信安", "信抗" };
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(10, 86, 430, 226);
		contentPane.add(table);
		String[] columnNames =  
	        { "姓名", "学号", "性别", "工期", "学院", "学校" }; 
		 Object[][] obj = new Object[2][6];  
		 for (int i = 0; i < 2; i++)  
	        {  
	            for (int j = 0; j < 6; j++)  
	            {  
	                switch (j)  
	                {  
	                case 0:  
	                    obj[i][j] = "赵匡义";  
	                    break;  
	                case 1:  
	                    obj[i][j] = "123215";  
	                    break;  
	                case 2:  
	                    obj[i][j] = "男";  
	                    break;  
	                case 3:  
	                    obj[i][j] = "两年";  
	                    break;  
	                case 4:  
	                    obj[i][j] = "计算机技术学院";  
	                    break;  
	                case 5:  
	                    obj[i][j] = "北京理工大学";  
	                    break;  
	                }  
	            }  
	        }  
		
		
		JLabel lblNewLabel = new JLabel("患者姓名");
		lblNewLabel.setBounds(23, 25, 54, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("身份证");
		lblNewLabel_1.setBounds(205, 25, 43, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("科室");
		lblNewLabel_2.setBounds(449, 70, 36, 15);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(96, 22, 43, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(258, 22, 121, 21);
		contentPane.add(textField_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(495, 66, 60, 23);
		for (int i = 0; i < department.length; i++) {
			comboBox.addItem(department[i]);
		}
		;
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("住院");
		btnNewButton.setBounds(462, 160, 93, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("出院");
		btnNewButton_1.setBounds(462, 231, 93, 23);
		contentPane.add(btnNewButton_1);
	}

}

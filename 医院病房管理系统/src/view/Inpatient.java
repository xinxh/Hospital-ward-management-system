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
	private JTextField pname;
	private JTextField pno;

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
		
		
		JLabel patientlabel = new JLabel("患者姓名");
		patientlabel.setBounds(23, 25, 54, 15);
		contentPane.add(patientlabel);
		
		JLabel id = new JLabel("身份证");
		id.setBounds(205, 25, 43, 15);
		contentPane.add(id);
		
		JLabel onolabel = new JLabel("科室");
		onolabel.setBounds(428, 25, 36, 15);
		contentPane.add(onolabel);
		
		pname = new JTextField();
		pname.setBounds(96, 22, 66, 21);
		contentPane.add(pname);
		pname.setColumns(10);
		
		pno = new JTextField();
		pno.setColumns(10);
		pno.setBounds(258, 22, 121, 21);
		contentPane.add(pno);
		
		JComboBox ono = new JComboBox();
		ono.setBounds(474, 21, 60, 23);
		for (int i = 0; i < department.length; i++) {
			ono.addItem(department[i]);
		}
		;
		contentPane.add(ono);
		
		JButton btnNewButton = new JButton("住院");
		btnNewButton.setBounds(462, 160, 93, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("出院");
		btnNewButton_1.setBounds(462, 231, 93, 23);
		contentPane.add(btnNewButton_1);
	}

}

package view;

import dao.Patientdao;

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

	private String patientno;
	private JPanel sickroomlabel;
	private JTextField pno;
	private JTextField pname;
	private JTextField surplus;
	private JTextField sickroom;
	private JTextField newsurplus;
	private JTable drug;




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
//有参构造
//无参构造
	public pay() {
		setTitle("缴费系统");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(446, 235, 581, 361);
		sickroomlabel = new JPanel();
		sickroomlabel.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setVisible(true);
		Patientdao padao=new Patientdao();
		setContentPane(sickroomlabel);
		sickroomlabel.setLayout(null);
		
		JLabel idlabel = new JLabel("身份证");
		idlabel.setBounds(42, 24, 48, 15);
		sickroomlabel.add(idlabel);

		JLabel druglabel = new JLabel("已使用药品");
		druglabel.setBounds(24, 133, 66, 15);
		sickroomlabel.add(druglabel);
		
		JLabel pnamelabel = new JLabel("姓名");
		pnamelabel.setBounds(42, 68, 41, 15);
		sickroomlabel.add(pnamelabel);
		
		JLabel surpluslabel = new JLabel("当前余额");
		surpluslabel.setBounds(300, 68, 57, 15);
		sickroomlabel.add(surpluslabel);

		JLabel lblNewLabel_1_2 = new JLabel("床位");
		lblNewLabel_1_2.setBounds(300, 24, 41, 15);
		sickroomlabel.add(lblNewLabel_1_2);

		JLabel surpluslabel2 = new JLabel("缴费金额");
		surpluslabel2.setBounds(85, 278, 54, 15);
		sickroomlabel.add(surpluslabel2);

		pno = new JTextField();
		pno.setBounds(100, 21, 173, 21);
		sickroomlabel.add(pno);
		pno.setColumns(10);
		
		pname = new JTextField();
		pname.setBounds(100, 65, 66, 21);
		sickroomlabel.add(pname);
		pname.setColumns(10);
		
		surplus = new JTextField();
		surplus.setBounds(367, 65, 79, 21);
		sickroomlabel.add(surplus);
		surplus.setColumns(10);
		
		sickroom = new JTextField();
		sickroom.setColumns(10);
		sickroom.setBounds(367, 21, 66, 21);
		sickroomlabel.add(sickroom);

		newsurplus = new JTextField();
		newsurplus.setColumns(10);
		newsurplus.setBounds(149, 275, 79, 21);
		sickroomlabel.add(newsurplus);
		
		JButton btnNewButton = new JButton("确认缴费");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton.setBounds(300, 274, 93, 23);
		sickroomlabel.add(btnNewButton);
		
		drug = new JTable();
		drug.setBounds(100, 133, 409, 112);
		sickroomlabel.add(drug);

	}
}

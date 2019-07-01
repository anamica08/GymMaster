import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class VIEWMYMEMBER extends JFrame {

	private JPanel contentPane;
	private JTable table;
	public Connection con;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public void  VIEWMYMEMBER(){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VIEWMYMEMBER frame = new VIEWMYMEMBER();
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
	public VIEWMYMEMBER() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(10, 81, 336, 169);
		contentPane.add(table);
		
		JLabel lblWelcomeTrainer = new JLabel("WELCOME TRAINER");
		lblWelcomeTrainer.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblWelcomeTrainer.setBounds(128, 11, 204, 14);
		contentPane.add(lblWelcomeTrainer);
		
		JLabel lblYourMember = new JLabel("YOUR MEMBER");
		lblYourMember.setBounds(170, 36, 127, 14);
		contentPane.add(lblYourMember);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				trainerpage t1= new trainerpage();
				t1.trainerpage();
			
			}
		});
		btnBack.setBounds(335, 9, 89, 23);
		contentPane.add(btnBack);
		
		JButton btnLoad = new JButton("LOAD ");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connectiondb o1=new Connectiondb();
					con=o1.connectionMYSQL(); 
					PreparedStatement pst = con.prepareStatement("select member_id ,name,sex, age,routine_id from member where trainer_id="+Integer.parseInt(textField.getText()));
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					}catch(Exception e7)
					{
						System.out.println("exception occured"+e7);
					}
			}
		});
		btnLoad.setBounds(10, 9, 89, 23);
		contentPane.add(btnLoad);
		
		JLabel lblNewLabel = new JLabel("MEMBER ID");
		lblNewLabel.setBounds(10, 67, 73, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setBounds(109, 67, 46, 14);
		contentPane.add(lblName);
		
		JLabel label = new JLabel("");
		label.setBounds(180, 61, 27, 14);
		contentPane.add(label);
		
		JLabel lblYourId = new JLabel("your id");
		lblYourId.setBounds(345, 36, 46, 14);
		contentPane.add(lblYourId);
		
		textField = new JTextField();
		textField.setBounds(338, 50, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblSex = new JLabel("SEX");
		lblSex.setBounds(170, 67, 46, 14);
		contentPane.add(lblSex);
		
		JLabel lblAge = new JLabel("AGE");
		lblAge.setBounds(217, 67, 46, 14);
		contentPane.add(lblAge);
		
		JLabel lblRoutineid = new JLabel("ROUTINE_ID");
		lblRoutineid.setBounds(277, 67, 69, 14);
		contentPane.add(lblRoutineid);
	}
}

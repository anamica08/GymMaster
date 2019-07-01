import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class updatehealthdetails extends JFrame {

	private JPanel contentPane;
	public Connection con;
	public Statement stmt; 
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public void updatehealthdetails(){
		EventQueue.invokeLater(new Runnable() {
			public void  run() {
				try {
					updatehealthdetails frame = new updatehealthdetails();
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
	public updatehealthdetails() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUpdateDetails = new JLabel("UPDATE DETAILS");
		lblUpdateDetails.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblUpdateDetails.setBounds(10, 50, 229, 14);
		contentPane.add(lblUpdateDetails);
		
		JLabel lblMemberId = new JLabel("MEMBER ID");
		lblMemberId.setBounds(47, 106, 92, 14);
		contentPane.add(lblMemberId);
		
		JLabel lblMonth = new JLabel("MONTH");
		lblMonth.setBounds(47, 137, 46, 14);
		contentPane.add(lblMonth);
		
		JLabel lblYear = new JLabel("YEAR");
		lblYear.setBounds(47, 168, 46, 14);
		contentPane.add(lblYear);
		
		JLabel lblWeight = new JLabel("WEIGHT");
		lblWeight.setBounds(47, 199, 46, 14);
		contentPane.add(lblWeight);
		
		textField = new JTextField();
		textField.setBounds(128, 103, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(128, 134, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(128, 165, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(128, 196, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					Connectiondb o2=new Connectiondb();
					con=o2.connectionMYSQL(); 
					PreparedStatement pst = con.prepareStatement("insert into healthdetails(member_id,month,year,weight) values (?,?,?,?)");
					pst.setString(1, textField.getText()); 
					pst.setString(2, textField_1.getText());
					pst.setString(3, textField_2.getText());
					pst.setInt(4, Integer.parseInt(textField_3.getText()));
					
					pst.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "DATA SAVED");
					
					
					}catch(Exception e1)
					{
						
						System.out.println("exception occured"+e1);
					}
		
			}
		});
		btnUpdate.setBounds(105, 227, 89, 23);
		contentPane.add(btnUpdate);
		
		JButton btnViewUpdate = new JButton("VIEW UPDATE");
		btnViewUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				HEALTHDETAILS o1= new HEALTHDETAILS();
					o1.HEALTHDETAILS();
					
			}
		});
		btnViewUpdate.setBounds(313, 10, 111, 23);
		contentPane.add(btnViewUpdate);
		
		JLabel lblWelcomeOperator = new JLabel("WELCOME OPERATOR");
		lblWelcomeOperator.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblWelcomeOperator.setBounds(93, 14, 210, 14);
		contentPane.add(lblWelcomeOperator);
	}
}

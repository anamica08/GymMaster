import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class ENTERACCOUNTDETAILS extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	public Connection con;

	/**
	 * Launch the application.
	 */
	public void  ENTERACCOUNTDETAILS()  {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ENTERACCOUNTDETAILS frame = new ENTERACCOUNTDETAILS();
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
	public ENTERACCOUNTDETAILS() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAccountId = new JLabel("ACCOUNT ID");
		lblAccountId.setBounds(10, 53, 80, 14);
		contentPane.add(lblAccountId);
		
		JLabel lblMemberId = new JLabel("MEMBER ID");
		lblMemberId.setBounds(20, 78, 64, 14);
		contentPane.add(lblMemberId);
		
		JLabel lblPackageId = new JLabel("PACKAGE ID");
		lblPackageId.setBounds(10, 103, 64, 14);
		contentPane.add(lblPackageId);
		
		JLabel lblModeOfPayment = new JLabel("MODE OF PAYMENT");
		lblModeOfPayment.setBounds(10, 177, 112, 14);
		contentPane.add(lblModeOfPayment);
		
		JLabel lblPayDate = new JLabel("PAY DATE");
		lblPayDate.setBounds(230, 53, 80, 14);
		contentPane.add(lblPayDate);
		
		JLabel lblPeriod = new JLabel("PERIOD");
		lblPeriod.setBounds(230, 78, 46, 14);
		contentPane.add(lblPeriod);
		
		JLabel lblMembershipOption = new JLabel("MEMBERSHIP OPTION");
		lblMembershipOption.setBounds(230, 103, 124, 14);
		contentPane.add(lblMembershipOption);
		
		JLabel lblPackageName = new JLabel("PACKAGE NAME");
		lblPackageName.setBounds(10, 152, 80, 14);
		contentPane.add(lblPackageName);
		
		textField = new JTextField();
		textField.setBounds(100, 50, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(94, 75, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(100, 100, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(100, 143, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(110, 174, 86, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(302, 50, 86, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(298, 75, 86, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(348, 100, 86, 20);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					Connectiondb o2=new Connectiondb();
					con=o2.connectionMYSQL(); 
					PreparedStatement pst = con.prepareStatement("insert into account(account_id,member_id,package_id,mode_of_payment,pay_date, period,membership_option,package_name) values (?,?,?,?,?,?,?,?)");
					pst.setInt(1,Integer.parseInt( textField.getText()));	
					pst.setString(2, textField_1.getText());
					pst.setString(3, textField_2.getText());
					pst.setString(4, textField_4.getText());
					pst.setString(5, textField_5.getText());
					pst.setInt(6,Integer.parseInt( textField_6.getText()));
					pst.setString(7, textField_7.getText());
					pst.setString(8, textField_3.getText());
							
				
					pst.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "DATA SAVED");
					setVisible(false);
					
					}catch(Exception e1)
					{
						
						System.out.println("exception occured"+e1);
					}
		
		
			}
		});
		btnAdd.setBounds(295, 204, 89, 23);
		contentPane.add(btnAdd);
		
		JLabel lblEnterAccountDetails = new JLabel("ENTER ACCOUNT DETAILS");
		lblEnterAccountDetails.setBounds(140, 11, 149, 14);
		contentPane.add(lblEnterAccountDetails);
		
		JLabel lbllumpsummonthOnMonth = new JLabel("(  Lumpsum/");
		lbllumpsummonthOnMonth.setBounds(358, 114, 126, 42);
		contentPane.add(lbllumpsummonthOnMonth);
		
		JLabel lblMonthOnMonth = new JLabel("month on month  )");
		lblMonthOnMonth.setBounds(342, 131, 92, 25);
		contentPane.add(lblMonthOnMonth);
		
		JLabel label = new JLabel("(6/12)");
		label.setBounds(388, 78, 46, 14);
		contentPane.add(label);
		
		JLabel lblpkpkpk = new JLabel("(pk1/pk2/pk3)");
		lblpkpkpk.setBounds(100, 118, 86, 14);
		contentPane.add(lblpkpkpk);
	}
}

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import net.proteanit.sql.DbUtils;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;

public class MEMBERACCOUNT extends JFrame {

	private JPanel contentPane;
	private JTable table;
	public Connection con;
	public Statement stmt;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public void MEMBERACCOUNT() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MEMBERACCOUNT frame = new MEMBERACCOUNT();
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
	public MEMBERACCOUNT() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 587, 419);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//String[] columns = {"account_id","member_id","package_id","mode of payment", "pay date","period" , "membership_option","package name"};
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"membershi_option", "member_id"
			}
		));
		table.getColumnModel().getColumn(0).setMinWidth(25);
		table.setBounds(14, 152, 557, 189);
		contentPane.add(table);
		
		JLabel lblWelcomeOperator = new JLabel("WELCOME OPERATOR");
		lblWelcomeOperator.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblWelcomeOperator.setBounds(207, 5, 168, 23);
		contentPane.add(lblWelcomeOperator);
		
		JButton btnLoad = new JButton("LOAD");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {   
				Connectiondb o1=new Connectiondb();
				con=o1.connectionMYSQL(); 
				//PreparedStatement pst = con.prepareStatement("select m.member_id , a.account_id , p.package_id , p.period,p.membership_option, p.package_name from member m , account a , package p where m.member_id = a.member_id and a.package_id = p.package_id");
				//String[] columns = {"account_id","member_id","package_id","mode of payment", "pay date","period" , "membership_option","package name"};
				
				PreparedStatement pst = con.prepareStatement("select * from account");
				ResultSet rs = pst.executeQuery();
				
				table.setModel(DbUtils.resultSetToTableModel(rs));
				}catch(Exception e4)
				{
					e4.printStackTrace();
				}
			}
			
		});
		btnLoad.setBounds(33, 70, 89, 23);
		contentPane.add(btnLoad);
		
		JLabel lblMemberAccountInfo = new JLabel("MEMBER ACCOUNT INFO");
		lblMemberAccountInfo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMemberAccountInfo.setBounds(217, 41, 158, 14);
		contentPane.add(lblMemberAccountInfo);
		
		JLabel lblMembershipid = new JLabel("member");
		lblMembershipid.setBounds(82, 127, 81, 14);
		contentPane.add(lblMembershipid);
		
		JLabel lblAccountid = new JLabel("account_id");
		lblAccountid.setBounds(14, 129, 81, 14);
		contentPane.add(lblAccountid);
		
		JLabel lblPackageid = new JLabel("package");
		lblPackageid.setBounds(147, 127, 65, 14);
		contentPane.add(lblPackageid);
		
		JLabel lblModeOf = new JLabel("mode of");
		lblModeOf.setBounds(234, 113, 46, 14);
		contentPane.add(lblModeOf);
		
		JLabel lblPayment = new JLabel("payment");
		lblPayment.setBounds(234, 127, 74, 14);
		contentPane.add(lblPayment);
		
		JLabel lblPay = new JLabel("pay");
		lblPay.setBounds(318, 113, 46, 14);
		contentPane.add(lblPay);
		
		JLabel lblDate = new JLabel("date");
		lblDate.setBounds(318, 127, 46, 14);
		contentPane.add(lblDate);
		
		JLabel lblPeriod = new JLabel("period");
		lblPeriod.setBounds(363, 127, 46, 14);
		contentPane.add(lblPeriod);
		
		JLabel lblMembership = new JLabel("membership");
		lblMembership.setBounds(423, 113, 96, 14);
		contentPane.add(lblMembership);
		
		JLabel lblOption = new JLabel("option");
		lblOption.setBounds(433, 127, 46, 14);
		contentPane.add(lblOption);
		
		JLabel lblPackageName = new JLabel("package name");
		lblPackageName.setBounds(492, 127, 96, 14);
		contentPane.add(lblPackageName);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				ONE o1= new ONE();
					o1.ONE();
					
			}
		});
		btnBack.setBounds(472, 7, 89, 23);
		contentPane.add(btnBack);
		
		JButton btnPackages = new JButton("PACKAGES");
		btnPackages.setBounds(14, 7, 89, 23);
		contentPane.add(btnPackages);
		
		JButton button = new JButton("ADD NEW ACCOUNT");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 ENTERACCOUNTDETAILS e1=  new ENTERACCOUNTDETAILS();
				 e1.ENTERACCOUNTDETAILS();
				
			}
		});
		button.setBounds(404, 346, 167, 23);
		contentPane.add(button);
		
		JButton btnDeleteAccountId = new JButton("DELETE ACCOUNT ID");
		btnDeleteAccountId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connectiondb o2=new Connectiondb();
					con=o2.connectionMYSQL();
					int temp = Integer.parseInt(textField.getText());
					PreparedStatement pst = con.prepareStatement("delete from account where account_id="+temp);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "DATA DELETED");
					
				}catch(Exception ex) {
					//ex.printStackTrace();
					System.out.println("exception occured"+ex);
				}
			}
		});
		btnDeleteAccountId.setBounds(24, 346, 158, 23);
		contentPane.add(btnDeleteAccountId);
		
		textField = new JTextField();
		textField.setBounds(194, 346, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
	}
}

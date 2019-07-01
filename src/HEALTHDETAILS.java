import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class HEALTHDETAILS extends JFrame {

	private JPanel contentPane;
	private JTable table;

	public Connection con;
	public Statement stmt; 

	/**
	 * Launch the application.
	 */
	public void  HEALTHDETAILS(){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HEALTHDETAILS frame = new HEALTHDETAILS();
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
	public HEALTHDETAILS() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 593, 375);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(10, 82, 557, 194);
		contentPane.add(table);
		
		JLabel lblHealthDetails = new JLabel("HEALTH DETAILS ");
		lblHealthDetails.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblHealthDetails.setBounds(10, 0, 127, 31);
		contentPane.add(lblHealthDetails);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				ONE o1= new ONE();
					o1.ONE();;
					
			}
		});
		btnBack.setBounds(445, 15, 89, 23);
		contentPane.add(btnBack);
		
		JLabel lblMemberid = new JLabel("member_id");
		lblMemberid.setBounds(10, 57, 73, 14);
		contentPane.add(lblMemberid);
		
		JLabel lblMembername = new JLabel("member_name");
		lblMembername.setBounds(93, 57, 104, 14);
		contentPane.add(lblMembername);
		
		JLabel lblWeight = new JLabel("weight");
		lblWeight.setBounds(503, 57, 46, 14);
		contentPane.add(lblWeight);
		
		JLabel lblWelcome = new JLabel("WELCOME ");
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblWelcome.setBounds(227, 15, 98, 14);
		contentPane.add(lblWelcome);
		
		JLabel lblMonth = new JLabel("month");
		lblMonth.setBounds(347, 57, 46, 14);
		contentPane.add(lblMonth);
		
		JLabel lblYear = new JLabel("year");
		lblYear.setBounds(431, 57, 46, 14);
		contentPane.add(lblYear);
		
		JButton btnUpdateDetails = new JButton("update details");
		btnUpdateDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				updatehealthdetails o1= new updatehealthdetails();
					o1.updatehealthdetails();;
					
				
			}
		});
		btnUpdateDetails.setBounds(394, 302, 155, 23);
		contentPane.add(btnUpdateDetails);
		
		JButton btnLoad = new JButton("LOAD");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				Connectiondb o1=new Connectiondb();
				con=o1.connectionMYSQL(); 
				PreparedStatement pst = con.prepareStatement("SELECT M.MEMBER_ID ,M.NAME,M.SEX,M.AGE, H.MONTH, H.YEAR,H.WEIGHT FROM MEMBER M ,HEALTHDETAILS H WHERE M.MEMBER_ID=H.MEMBER_ID");
				ResultSet rs = pst.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));
				}catch(Exception e5)
				{
					e5.printStackTrace();
				}
			}
			
		});
		btnLoad.setBounds(0, 34, 89, 23);
		contentPane.add(btnLoad);
		
		JLabel lblSex = new JLabel("sex");
		lblSex.setBounds(191, 57, 46, 14);
		contentPane.add(lblSex);
		
		JLabel lblAge = new JLabel("age");
		lblAge.setBounds(262, 57, 46, 14);
		contentPane.add(lblAge);
	}
}

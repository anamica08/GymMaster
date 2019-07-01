//import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.Statement;

//import javax.swing.JScrollBar;
//import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ADDMEMBER extends JFrame {

	private JPanel contentPane;
	private JTextField member_idtxt;
	private JTextField nametxt;
	private JTextField sextxt;
	private JTextField account_idtxt;
	private JTextField routine_idtxt;
	private JTextField trainer_idtxt;
	public Connection con1;
	public Statement stmt; 
	private JTextField agetxt;

	/**
	 * Launch the application.
	 */
	public void AddMember() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ADDMEMBER frame = new ADDMEMBER();
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
	public ADDMEMBER() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddMember = new JLabel("ADD MEMBER");
		lblAddMember.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAddMember.setBounds(165, 3, 165, 33);
		contentPane.add(lblAddMember);
		
		JLabel lblMemberId = new JLabel("MEMBER ID ");
		lblMemberId.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMemberId.setBounds(91, 47, 86, 14);
		contentPane.add(lblMemberId);
		
		JLabel lblMemeberName = new JLabel(" NAME");
		lblMemeberName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMemeberName.setBounds(101, 72, 101, 14);
		contentPane.add(lblMemeberName);
		
		JLabel lblNewLabel = new JLabel("SEX");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(111, 97, 46, 14);
		contentPane.add(lblNewLabel);
		
		member_idtxt = new JTextField();
		member_idtxt.setBounds(244, 47, 86, 20);
		contentPane.add(member_idtxt);
		member_idtxt.setColumns(10);
		
		nametxt = new JTextField();
		nametxt.setBounds(244, 70, 86, 20);
		contentPane.add(nametxt);
		nametxt.setColumns(10);
		
		sextxt = new JTextField();
		sextxt.setBounds(244, 95, 86, 20);
		contentPane.add(sextxt);
		sextxt.setColumns(10);
		
		JButton btnAddMember = new JButton("ADD ");
		btnAddMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					Connectiondb o2=new Connectiondb();
					con1=o2.connectionMYSQL(); 
				PreparedStatement pst = con1.prepareStatement("insert into member(member_id,name,sex,age,account_id,trainer_id,routine_id) values (?,?,?,?,?,?,?)");
					//PreparedStatement pst = con1.prepareStatement("insert into member2(member_id,name,age) values (?,?,?)");
					/*pst.setInt(1,20);
					pst.setString(2, "param");*/
					pst.setString(1,member_idtxt.getText());
					pst.setString(2,nametxt.getText()); 
					pst.setString(3,sextxt.getText());
					pst.setInt(4,Integer.parseInt(agetxt.getText()));
					pst.setInt(5,Integer.parseInt(account_idtxt.getText()));
					pst.setInt(6,Integer.parseInt(routine_idtxt.getText()));
					pst.setInt(7,Integer.parseInt(trainer_idtxt.getText()));
					
					pst.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "DATA SAVED");
					
					
					}catch(Exception e1)
					{
						//e1.printStackTrace();
						System.out.println("exception occured"+e1);
					}
		
			}
		});
		btnAddMember.setBounds(333, 227, 101, 23);
		contentPane.add(btnAddMember);
		
		JButton btnBackj = new JButton("BACK");
		btnBackj.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				Two o1= new Two();
				o1.two();;
				
			}
		});
		btnBackj.setBounds(335, 11, 89, 23);
		contentPane.add(btnBackj);
		
		JLabel lblTrainerAssigned = new JLabel("TRAINER ASSIGNED(ID)");
		lblTrainerAssigned.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTrainerAssigned.setBounds(69, 207, 149, 14);
		contentPane.add(lblTrainerAssigned);
		
		account_idtxt = new JTextField();
		account_idtxt.setBounds(244, 149, 86, 20);
		contentPane.add(account_idtxt);
		account_idtxt.setColumns(10);
		
		JLabel lblRoutineId = new JLabel("ROUTINE ID");
		lblRoutineId.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblRoutineId.setBounds(91, 182, 101, 14);
		contentPane.add(lblRoutineId);
		
		JLabel lblAccountId = new JLabel("ACCOUNT ID");
		lblAccountId.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAccountId.setBounds(91, 151, 86, 14);
		contentPane.add(lblAccountId);
		
		routine_idtxt = new JTextField();
		routine_idtxt.setBounds(244, 180, 86, 20);
		contentPane.add(routine_idtxt);
		routine_idtxt.setColumns(10);
		
		trainer_idtxt = new JTextField();
		trainer_idtxt.setBounds(244, 209, 86, 20);
		contentPane.add(trainer_idtxt);
		trainer_idtxt.setColumns(10);
		
		JLabel lblAge = new JLabel("AGE");
		lblAge.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAge.setBounds(101, 126, 46, 14);
		contentPane.add(lblAge);
		
		agetxt = new JTextField();
		agetxt.setBounds(244, 124, 86, 20);
		contentPane.add(agetxt);
		agetxt.setColumns(10);
	}
}

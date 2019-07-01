import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class viewtrainer extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField trainertxt;
	private JTextField nametxt;
	private JTextField salarytxt;
	private JTextField pwdtxt;

	public Connection con;
	public Statement stmt; 
	private JTextField extxt;

	/**
	 * Launch the application.
	 */
	public void viewtrainer() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewtrainer frame = new viewtrainer();
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
	public viewtrainer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 603, 461);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(162, 101, 403, 248);
		contentPane.add(table);
		
		JLabel lblTrainerid = new JLabel("trainer_id");
		lblTrainerid.setBounds(10, 114, 67, 14);
		contentPane.add(lblTrainerid);
		
		trainertxt = new JTextField();
		trainertxt.setBounds(66, 111, 86, 20);
		contentPane.add(trainertxt);
		trainertxt.setColumns(10);
		
		JLabel lblName = new JLabel("name");
		lblName.setBounds(10, 180, 46, 14);
		contentPane.add(lblName);
		
		JLabel exptxt = new JLabel("experience");
		exptxt.setBounds(10, 220, 80, 14);
		contentPane.add(exptxt);
		
		nametxt = new JTextField();
		nametxt.setBounds(66, 177, 86, 20);
		contentPane.add(nametxt);
		nametxt.setColumns(10);
		
		JLabel lblSalary = new JLabel("salary");
		lblSalary.setBounds(10, 263, 46, 14);
		contentPane.add(lblSalary);
		
		salarytxt = new JTextField();
		salarytxt.setBounds(66, 260, 86, 20);
		contentPane.add(salarytxt);
		salarytxt.setColumns(10);
		
		JButton btnAddTrainer = new JButton("ADD TRAINER");
		btnAddTrainer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					Connectiondb o2=new Connectiondb();
					con=o2.connectionMYSQL(); 
					PreparedStatement pst = con.prepareStatement("insert into trainer(trainer_id, password , name,experience,salary) values (?,?,?,?,?)");
					pst.setInt(1, Integer.parseInt(trainertxt.getText()));
					pst.setInt(2,Integer.parseInt(pwdtxt.getText()));
					pst.setString(3, nametxt.getText()); 
					pst.setInt(4, Integer.parseInt(extxt.getText()));
					pst.setInt(5,Integer.parseInt(salarytxt.getText()));
				
					pst.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "DATA SAVED");
					
					
					}catch(Exception e1)
					{
						
						System.out.println("exception occured"+e1);
					}
		
				
			}
		});
		btnAddTrainer.setBounds(10, 302, 116, 23);
		contentPane.add(btnAddTrainer);
		
		JLabel lblWelcomeOperator = new JLabel("WELCOME OPERATOR");
		lblWelcomeOperator.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblWelcomeOperator.setBounds(283, 3, 172, 14);
		contentPane.add(lblWelcomeOperator);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				ONE o1= new ONE();
					o1.ONE();;
					
				
			}
		});
		btnBack.setBounds(465, 0, 89, 23);
		contentPane.add(btnBack);
		
		JButton btnLoadTrainerInfo = new JButton("LOAD TRAINER INFO");
		btnLoadTrainerInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					Connectiondb o1=new Connectiondb();
					con=o1.connectionMYSQL(); 
					PreparedStatement pst = con.prepareStatement("select * from trainer");
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					}catch(Exception e)
					{
						e.printStackTrace();
					}
			}
		});
		btnLoadTrainerInfo.setBounds(175, 49, 190, 23);
		contentPane.add(btnLoadTrainerInfo);
		
		JLabel lblTrainerid_1 = new JLabel("TRAINER_ID");
		lblTrainerid_1.setBounds(175, 76, 67, 14);
		contentPane.add(lblTrainerid_1);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setBounds(252, 76, 89, 14);
		contentPane.add(lblPassword);
		
		JLabel lblName_1 = new JLabel("NAME");
		lblName_1.setBounds(335, 76, 46, 14);
		contentPane.add(lblName_1);
		
		JLabel lblExperience = new JLabel("EXPERIENCE");
		lblExperience.setBounds(409, 76, 86, 14);
		contentPane.add(lblExperience);
		
		JLabel lblSalary_1 = new JLabel("SALARY");
		lblSalary_1.setBounds(491, 76, 46, 14);
		contentPane.add(lblSalary_1);
		
		JLabel lblPassword_1 = new JLabel("password");
		lblPassword_1.setBounds(10, 150, 67, 14);
		contentPane.add(lblPassword_1);
		
		JLabel label = new JLabel("");
		label.setBounds(56, 92, 46, 14);
		contentPane.add(label);
		
		pwdtxt = new JTextField();
		pwdtxt.setBounds(66, 142, 86, 20);
		contentPane.add(pwdtxt);
		pwdtxt.setColumns(10);
		
		JLabel lblTrainerRegistration = new JLabel("TRAINER REGISTRATION");
		lblTrainerRegistration.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTrainerRegistration.setBounds(10, 3, 204, 33);
		contentPane.add(lblTrainerRegistration);
		
		extxt = new JTextField();
		extxt.setBounds(66, 217, 86, 20);
		contentPane.add(extxt);
		extxt.setColumns(10);
		
		JButton btnDeleteTrainer = new JButton("DELETE TRAINER");
		btnDeleteTrainer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connectiondb o2=new Connectiondb();
					con=o2.connectionMYSQL();
					PreparedStatement pst = con.prepareStatement("delete from trainer where trainer_id = " +Integer.parseInt(trainertxt.getText()));
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "DATA DELETED");
					
				}catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		btnDeleteTrainer.setBounds(10, 336, 116, 23);
		contentPane.add(btnDeleteTrainer);
	}
}

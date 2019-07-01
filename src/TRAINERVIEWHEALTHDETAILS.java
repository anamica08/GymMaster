import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class TRAINERVIEWHEALTHDETAILS extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	public Connection con;
	/**
	 * Launch the application.
	 */
	public void TRAINERVIEWHEALTHDETAILS(){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TRAINERVIEWHEALTHDETAILS frame = new TRAINERVIEWHEALTHDETAILS();
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
	public TRAINERVIEWHEALTHDETAILS() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(33, 81, 366, 141);
		contentPane.add(table);
		
		JButton btnLoad = new JButton("LOAD");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					Connectiondb o1=new Connectiondb();
					con=o1.connectionMYSQL(); 
					PreparedStatement pst = con.prepareStatement("SELECT M.MEMBER_ID ,M.NAME,M.SEX,M.AGE, H.MONTH, H.YEAR,H.WEIGHT FROM MEMBER M ,HEALTHDETAILS H WHERE M.MEMBER_ID=H.MEMBER_ID and trainer_id="+Integer.parseInt(textField.getText()));
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					}catch(Exception e5)
					{
						e5.printStackTrace();
					}
			}
		});
		btnLoad.setBounds(10, 21, 89, 23);
		contentPane.add(btnLoad);
		
		JLabel lblYourId = new JLabel("YOUR ID");
		lblYourId.setBounds(33, 233, 46, 14);
		contentPane.add(lblYourId);
		
		textField = new JTextField();
		textField.setBounds(75, 230, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblHealthDetailsOf = new JLabel("MONTHLY HEALTH DETAILS OF YOUR MEMBER");
		lblHealthDetailsOf.setBounds(109, 25, 241, 14);
		contentPane.add(lblHealthDetailsOf);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				trainerpage t1= new trainerpage();
				t1.trainerpage();
			}
		});
		btnBack.setBounds(335, 0, 89, 23);
		contentPane.add(btnBack);
		
		JLabel lblWelcomeTrainer = new JLabel("WELCOME TRAINER");
		lblWelcomeTrainer.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblWelcomeTrainer.setBounds(139, 4, 171, 14);
		contentPane.add(lblWelcomeTrainer);
	}
}

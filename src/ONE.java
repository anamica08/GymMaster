import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.DropMode;

public class ONE extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	
	public void ONE() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ONE frame = new ONE();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public ONE() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblWelcomeAdmin = new JLabel("WELCOME OPERATOR");
		lblWelcomeAdmin.setFont(new Font("Book Antiqua", Font.BOLD | Font.ITALIC, 18));
		lblWelcomeAdmin.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeAdmin.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
			}
		});
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		contentPane.add(lblWelcomeAdmin);
		
		JLabel label = new JLabel("");
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		contentPane.add(label_1);
		
		JButton btnAccountDetails = new JButton("Account Details");
		btnAccountDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					setVisible(false);
					MEMBERACCOUNT t1= new MEMBERACCOUNT();
					t1.MEMBERACCOUNT();;
				
					}catch(Exception e2)
					{
						e2.printStackTrace();
					}
				
			}
		});
		
		JButton btnNewButton = new JButton("Member Registration");
		btnNewButton.setBackground(new Color(176, 196, 222));
		btnNewButton.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
		buttonGroup.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//setvisible(false);
				setVisible(false);
				Two o1= new Two();
				o1.two();
				
				
			}
		});
		
		JButton btnMonthlyHealthDetails = new JButton("Monthly Health Details");
		btnMonthlyHealthDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					setVisible(false);
					HEALTHDETAILS t1= new HEALTHDETAILS();
					t1.HEALTHDETAILS();
				
					}catch(Exception e2)
					{
						e2.printStackTrace();
					}
				
			}
		});
		btnMonthlyHealthDetails.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 14));
		contentPane.add(btnMonthlyHealthDetails);
		contentPane.add(btnNewButton);
		btnAccountDetails.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 14));
		contentPane.add(btnAccountDetails);
		
		JButton btnPackageDetails = new JButton("PACKAGE DETAILS");
		btnPackageDetails.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
		btnPackageDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		contentPane.add(btnPackageDetails);
		
		JButton btnTrainerRegistration = new JButton("Trainer Registration");
		btnTrainerRegistration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					setVisible(false);
					viewtrainer t1= new viewtrainer();
					t1.viewtrainer();
				
					}catch(Exception e2)
					{
						e2.printStackTrace();
					}
			}
		});
		btnTrainerRegistration.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 14));
		contentPane.add(btnTrainerRegistration);
		
		JButton btnLogOut = new JButton("LOG OUT");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnLogOut.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
		contentPane.add(btnLogOut);
	}

}

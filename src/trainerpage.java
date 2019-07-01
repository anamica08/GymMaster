import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class trainerpage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public void trainerpage() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					trainerpage frame = new trainerpage();
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
	public trainerpage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel(); 
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("MONTHLY HEALTH DETAILS");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					setVisible(false);
					TRAINERVIEWHEALTHDETAILS t1= new TRAINERVIEWHEALTHDETAILS();
					t1.TRAINERVIEWHEALTHDETAILS();;
				
					}catch(Exception e2)
					{
						e2.printStackTrace();
					}
			}
		});
		btnNewButton.setBounds(60, 64, 295, 54);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("ROUTINE TABLE");
		btnNewButton_1.setBounds(60, 115, 295, 54);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("WELCOME TRAINER");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(119, 11, 250, 31);
		contentPane.add(lblNewLabel);
		
		JButton btnLogOut = new JButton("LOG OUT");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				
			}
		});
		btnLogOut.setBounds(318, 227, 89, 23);
		contentPane.add(btnLogOut);
		
		JButton btnNewButton_2 = new JButton("MEMBER ASSIGNED");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				VIEWMYMEMBER o1= new VIEWMYMEMBER();
					o1.VIEWMYMEMBER();
					
			}
		});
		btnNewButton_2.setBounds(60, 168, 295, 48);
		contentPane.add(btnNewButton_2);
	}
}

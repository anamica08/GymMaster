
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class GymMasterStart extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GymMasterStart frame = new GymMasterStart();
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
	public GymMasterStart() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 493, 351);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHelperToManage = new JLabel("HELPER TO MANAGE YOUR GYM");
		lblHelperToManage.setForeground(new Color(139, 0, 0));
		lblHelperToManage.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		lblHelperToManage.setBounds(156, 92, 201, 41);
		contentPane.add(lblHelperToManage);
		
		JButton btnNewButton = new JButton("TRAINER");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				TRAINERlogin t1= new TRAINERlogin();
				t1.TrainerLogin();
				
			}
		});
		btnNewButton.setBounds(96, 252, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnOperator = new JButton("OPERATOR");     
		btnOperator.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			  OPERATORlogin o1= new OPERATORlogin();
				o1.Operatorlogin();
				
			}
		});
		btnOperator.setBounds(329, 252, 111, 23);
		contentPane.add(btnOperator);
		
		JLabel lblLoginPanel = new JLabel("LOGIN PANEL");
		lblLoginPanel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblLoginPanel.setBounds(205, 187, 129, 23);
		contentPane.add(lblLoginPanel);
		
		JLabel lblGymMaster = new JLabel("GYM MASTER");
		lblGymMaster.setFont(new Font("Tahoma", Font.BOLD, 51));
		lblGymMaster.setBounds(55, 0, 408, 135);
		contentPane.add(lblGymMaster);
	}
}

//(101,98)operator
//(102,765)
//(201,98) trainer
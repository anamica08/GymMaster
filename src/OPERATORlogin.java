import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.JComboBox;
public class OPERATORlogin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	public Connection con;
	public Statement stmt;
	private JTextField textField_1;
	/**
	 * Launch the application.
	 */
	public void Operatorlogin() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OPERATORlogin frame = new OPERATORlogin();
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
	public OPERATORlogin() {
		Connectiondb obj1=new Connectiondb();
		con=obj1.connectionMYSQL();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("OPERATOR ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(166, 101, 100, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblPleaseLogin = new JLabel("PLEASE LOGIN");
		lblPleaseLogin.setForeground(new Color(255, 0, 0));
		lblPleaseLogin.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPleaseLogin.setBounds(34, 37, 187, 35);
		contentPane.add(lblPleaseLogin);
		
		textField = new JTextField();
		textField.setBounds(268, 101, 127, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPassword.setBounds(181, 144, 85, 14);
		contentPane.add(lblPassword);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			try {
				int id;
				int pswd;
				stmt=con.createStatement();
				ResultSet rs= stmt.executeQuery("select * from gym_operator");
			
				while(rs.next())  
				{
					id=rs.getInt(1);
					pswd=rs.getInt(2);
				  //	con.close(); 
					if(id==Integer.parseInt(textField.getText()) && pswd==Integer.parseInt(textField_1.getText()))
					{
						//JOptionPane.showMessageDialog(null, "Sucessfully login");
						setVisible(false);
						ONE t1= new ONE();
						t1.ONE();
					}
				}
				
			}catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, e);
			}
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLogin.setBounds(231, 185, 89, 23);
		contentPane.add(btnLogin);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Anamika\\Pictures\\494939-login\\png\\008-user.png"));
		lblNewLabel_1.setBounds(34, 83, 137, 118);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(267, 141, 128, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label = new JLabel("*10_");
		label.setBounds(378, 119, 46, 14);
		contentPane.add(label);
	}
}


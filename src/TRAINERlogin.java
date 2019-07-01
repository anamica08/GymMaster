import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
public class TRAINERlogin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	public Connection con;
	public Statement stmt; 
	public int id;
	public int pswd;
	/**
	 * Launch the application.
	 */
	public void TrainerLogin() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TRAINERlogin frame = new TRAINERlogin();
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
	public TRAINERlogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTrainerId = new JLabel("TRAINER ID");
		lblTrainerId.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTrainerId.setBounds(156, 98, 124, 14);
		contentPane.add(lblTrainerId);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPassword.setBounds(163, 138, 101, 14);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(274, 95, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(274, 135, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					Connectiondb o1=new Connectiondb();
					con=o1.connectionMYSQL();
					stmt=con.createStatement();
					ResultSet rs = stmt.executeQuery("select trainer_id , password from trainer");
					while(rs.next())
					{
						
						id=Integer.parseInt(rs.getString(1));
						pswd=Integer.parseInt(rs.getString(2));
					
					
					
						//int i=Integer.parseInt(textField_1.getText());
						if(id==Integer.parseInt(textField.getText())&& pswd==Integer.parseInt(textField_1.getText()))
						{
							JOptionPane.showMessageDialog(null, "Sucessfully login");
							setVisible(false);
							trainerpage t= new trainerpage();
							t.trainerpage();
						}
					}	
					
				}catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, "fail to fetch");
				}
			}
			
		});
		
		
		btnLogin.setBounds(205, 180, 89, 23);
		contentPane.add(btnLogin);
		
		JLabel lblPleaseLogin = new JLabel("PLEASE LOGIN");
		lblPleaseLogin.setForeground(Color.RED);
		lblPleaseLogin.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPleaseLogin.setBounds(38, 34, 138, 14);
		contentPane.add(lblPleaseLogin);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Anamika\\Pictures\\494939-login\\png\\008-user.png"));
		lblNewLabel.setBounds(38, 95, 95, 108);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("*20__");
		label.setBounds(351, 115, 46, 14);
		contentPane.add(label);
	}
}

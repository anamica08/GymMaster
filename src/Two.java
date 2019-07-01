import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

import javax.sql.RowSetMetaData;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Two extends JFrame {

	public Connection con;
	public Statement stmt; 
	private JPanel contentPane;
	private JTable table;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public void two() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Two frame = new Two();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
					
				}
			}
		});
	}
	//Connection con = null;
	
	/**
	 * Create the frame.
	 */
	public Two() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 653, 482);
		contentPane =  new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.light"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		/*String data[][]=null;
		String column[]=null;
		try
		{
			
			Connectiondb o1=new Connectiondb();
			con=o1.connectionMYSQL(); 
			PreparedStatement p = con.prepareStatement("select * from member",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = p.executeQuery();
			
			java.sql.ResultSetMetaData r = rs.getMetaData();
			int cols=r.getColumnCount();
			column=new String[cols];
			for(int i=1;i<=cols;i++)
			{
				column[i-1]=r.getColumnName(i);
			}
			
			rs.last();
			int rows=rs.getRow();
			rs.beforeFirst();
			data=new String[rows][cols];
			int count=0;
			
			while(rs.next())
			{
				for(int i=1;i<=cols;i++){
					data[count][i-1]=rs.getString(i);
				}
				count++;
			}
			
				
		}catch(Exception E)
		{
			JOptionPane.showMessageDialog(null, E);
		}*/

		
		JLabel lblWelcomeOeraor = new JLabel("WELCOME OPERATOR");
		lblWelcomeOeraor.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 15));
		lblWelcomeOeraor.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnLogOut = new JButton("BACK");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			ONE o1= new ONE();
				o1.ONE();
				
				
			}
		});
		btnLogOut.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 14));
		
		JLabel lblMemberRegister = new JLabel("MEMBER REGISTRATION");
		lblMemberRegister.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connectiondb o2=new Connectiondb();
					con=o2.connectionMYSQL();
					PreparedStatement pst = con.prepareStatement("delete from member where member_id = '"+textField.getText()+"'");
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "DATA DELETED");
					
				}catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		btnDelete.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 14));
		btnDelete.setBackground(new Color(119, 136, 153));
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				ADDMEMBER a = new ADDMEMBER();
				a.AddMember();
			}
		});
		btnAdd.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 14));
		btnAdd.setBackground(Color.LIGHT_GRAY);
		
		table = new JTable();
		table.setForeground(Color.BLACK);
		table.setSurrendersFocusOnKeystroke(true);
		table.setFillsViewportHeight(true);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setToolTipText("MEMBER ID\r\nNAME\r\nSEX\r\n");
		table.setRowSelectionAllowed(false);
		
		JButton btnLoad = new JButton("LOAD");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				Connectiondb o1=new Connectiondb();
				con=o1.connectionMYSQL(); 
				PreparedStatement pst = con.prepareStatement("select * from member");
				ResultSet rs = pst.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));
				}catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		});
		btnLoad.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		
		JLabel lblMemberid = new JLabel("member_id");
		
		JLabel lblName = new JLabel("name");
		
		JLabel lblSex = new JLabel("sex");
		
		JLabel lblRoutineid = new JLabel("routine_id");
		
		JLabel lblAcountid = new JLabel("acount_id");
		
		JLabel lblTrainerid = new JLabel("trainer_id");
		
		JLabel lblAge = new JLabel("age");
		
		JLabel lblMemberId = new JLabel("MEMBER ID ");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblToDeleteA = new JLabel("TO DELETE A ENTRY ENTER MEMBER ID");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(table, GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblMemberid)
										.addComponent(btnLoad))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblMemberRegister, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
											.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(82)
											.addComponent(lblWelcomeOeraor, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(38)
											.addComponent(lblName)
											.addGap(52)
											.addComponent(lblSex)
											.addGap(42)
											.addComponent(lblAge)
											.addGap(50)
											.addComponent(lblRoutineid)
											.addGap(18)
											.addComponent(lblAcountid)
											.addPreferredGap(ComponentPlacement.RELATED)))
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(btnLogOut, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(btnDelete))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(27)
											.addComponent(lblTrainerid))))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(65)
							.addComponent(lblMemberId)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(56)
							.addComponent(lblToDeleteA, GroupLayout.PREFERRED_SIZE, 314, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblWelcomeOeraor, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnLogOut, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMemberRegister)
						.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(9)
					.addComponent(btnLoad)
					.addGap(4)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMemberid)
						.addComponent(lblName)
						.addComponent(lblSex)
						.addComponent(lblRoutineid)
						.addComponent(lblAcountid)
						.addComponent(lblTrainerid)
						.addComponent(lblAge))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
					.addGap(29)
					.addComponent(lblToDeleteA)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMemberId))
					.addContainerGap(27, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}

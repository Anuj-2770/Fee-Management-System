package fee_Management_System;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtfname;
	private JPasswordField txtpass;
	private JLabel lblerror;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 443);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 0, 554, 77);
		panel.setBackground(new Color(255, 0, 255));
		contentPane.add(panel);
		
		JLabel lblNewLabel_2 = new JLabel("");
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setIcon(new ImageIcon(login.class.getResource("/fee_Management_System/logologin1.jpg")));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel.setForeground(new Color(128, 64, 64));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name:");
		lblNewLabel_1.setBounds(53, 162, 99, 24);
		lblNewLabel_1.setBackground(new Color(0, 0, 0));
		lblNewLabel_1.setForeground(new Color(255, 0, 128));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password:");
		lblNewLabel_1_1.setBounds(53, 226, 99, 24);
		lblNewLabel_1_1.setForeground(new Color(255, 0, 128));
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		contentPane.add(lblNewLabel_1_1);
		
		txtfname = new JTextField();
		txtfname.setBounds(204, 166, 113, 20);
		contentPane.add(txtfname);
		txtfname.setColumns(10);
		
		txtpass = new JPasswordField();
		txtpass.setBounds(204, 230, 113, 20);
		contentPane.add(txtpass);
		
		JButton btnNewButton = new JButton("signin");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				login l1 = new login();
				l1.setVisible(true);
				login.this.dispose();
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBounds(53, 338, 89, 23);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.setBackground(new Color(255, 128, 0));
		contentPane.add(btnNewButton);
		
		JButton btnLogin = new JButton("login");
		btnLogin.addActionListener(new ActionListener() {
			
			void varification(String fname1,String pass1) {
	try {
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fee_Management_System","root","Anujyadav@9005");
					String sql = "select * from signup where fname=? and password=?";

					PreparedStatement st = con.prepareStatement(sql);
					
					st.setString(1, fname1);
					
					st.setString(2,pass1 );
					   ResultSet rs = st.executeQuery();
					   while(rs.next()) {
						   HomePage hp = new HomePage();
						   hp.setVisible(true);
						   login.this.dispose();
					   }
	}
	catch(Exception e) {
		                 JOptionPane.showMessageDialog(null, "Incorrect Name or Password...");
	                  }
	
			}
			public void actionPerformed(ActionEvent e) {
				String fname1,pass1;
				fname1 = txtfname.getText();
				pass1 = txtpass.getText();
				if(fname1.equals("") || pass1.equals("")) {
					lblerror.setText("please enter the correct Name and Password...");
				}
				else {
					varification(fname1,pass1);
				}
			}
		});
		btnLogin.setBounds(207, 304, 89, 23);
		btnLogin.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnLogin.setBackground(new Color(255, 128, 0));
		contentPane.add(btnLogin);
		
		JButton btnClear = new JButton("clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
              txtfname.setText("");
              txtpass.setText("");
				
			}
		});
		btnClear.setBounds(349, 338, 89, 23);
		btnClear.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnClear.setBackground(new Color(255, 128, 0));
		contentPane.add(btnClear);
		
		lblerror = new JLabel("");
		lblerror.setForeground(new Color(255, 0, 128));
		lblerror.setBounds(53, 273, 335, 20);
		contentPane.add(lblerror);
	}
}

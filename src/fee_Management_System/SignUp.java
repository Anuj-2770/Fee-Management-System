package fee_Management_System;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Window;
import java.awt.Color;
import com.toedter.calendar.JDateChooser;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import javax.swing.JComboBox;

public class SignUp<Login> extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFirst;
	private JTextField textLast;
	private JPasswordField password1;
	private JPasswordField password2;
	private JLabel lblmerror;
	private JLabel lblPasserror;
	private JLabel lblcpass;
	private JDateChooser textdob;
	private JComboBox<String> comboGender;
	private JTextField textMob;
	
	String fname, lname, gender, pass, cpass,mobile;
	Date dob;

	/**
	 * Launch the application.
	 */
	
	int id =0;
	ResultSet rs = null;
	int getId() {
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fee_Management_System","root","Anujyadav@9005");
			String sql = "select  max(id) from signup";
			Statement st = con.createStatement();
			rs = st.executeQuery(sql);
//			while(rs.next()) {
//				id++;
//			//	id = getInt(1);
//			}
			
			if (rs.next()) {
			    id = rs.getInt(1) + 1; // max(id) + 1
			}

			}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		return id;
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp frame = new SignUp();
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
	public SignUp() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 716, 501);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 255, 255));
		panel.setBounds(0, 0, 700, 84);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("SignUp");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setBackground(new Color(0, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 38));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("FName :");
		lblNewLabel_1.setForeground(new Color(128, 0, 255));
		lblNewLabel_1.setBackground(new Color(240, 240, 240));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(33, 122, 85, 21);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("LName :");
		lblNewLabel_1_1.setForeground(new Color(128, 0, 255));
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_1.setBackground(UIManager.getColor("Button.background"));
		lblNewLabel_1_1.setBounds(33, 166, 85, 21);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("D.O.B");
		lblNewLabel_1_2.setForeground(new Color(128, 0, 255));
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_2.setBackground(UIManager.getColor("Button.background"));
		lblNewLabel_1_2.setBounds(33, 198, 85, 21);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Gender :");
		lblNewLabel_1_3.setForeground(new Color(128, 0, 255));
		lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_3.setBackground(UIManager.getColor("Button.background"));
		lblNewLabel_1_3.setBounds(33, 231, 85, 21);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Password :");
		lblNewLabel_1_4.setForeground(new Color(128, 0, 255));
		lblNewLabel_1_4.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_4.setBackground(UIManager.getColor("Button.background"));
		lblNewLabel_1_4.setBounds(33, 269, 85, 21);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Confirm Password :");
		lblNewLabel_1_5.setForeground(new Color(128, 0, 255));
		lblNewLabel_1_5.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_5.setBackground(UIManager.getColor("Button.background"));
		lblNewLabel_1_5.setBounds(33, 301, 157, 28);
		contentPane.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("Mobile No: ");
		lblNewLabel_1_6.setForeground(new Color(128, 0, 255));
		lblNewLabel_1_6.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_6.setBackground(UIManager.getColor("Button.background"));
		lblNewLabel_1_6.setBounds(33, 359, 97, 21);
		contentPane.add(lblNewLabel_1_6);
		
		textFirst = new JTextField();
		textFirst.setBounds(187, 124, 86, 20);
		contentPane.add(textFirst);
		textFirst.setColumns(10);
		
		textLast = new JTextField();
		textLast.setBounds(187, 155, 86, 20);
		contentPane.add(textLast);
		textLast.setColumns(10);
		
		password1 = new JPasswordField();
		password1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				passwordCheck();
			}
			@Override
			public void keyReleased(KeyEvent e) {
				passwordCheck();
			}
			@Override
			public void keyTyped(KeyEvent e) {
				passwordCheck();
			}
		});
		password1.setBounds(187, 271, 86, 21);
		contentPane.add(password1);
		
		password2 = new JPasswordField();
		password2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				confirmPass();
			}
			@Override
			public void keyReleased(KeyEvent e) {
				confirmPass();
			}
			@Override
			public void keyTyped(KeyEvent e) {
				confirmPass();
			}
		});
		password2.setBounds(187, 307, 86, 21);
		contentPane.add(password2);
		
		textMob = new JTextField();
		textMob.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				 mobileCheck();
			}
			@Override
			public void keyReleased(KeyEvent e) {
				mobileCheck();
			}
			@Override
			public void keyTyped(KeyEvent e) {
				mobileCheck();
			}
		});
		textMob.setBounds(187, 361, 86, 20);
		contentPane.add(textMob);
		textMob.setColumns(10);
		
	    textdob = new JDateChooser();
		textdob.setBounds(187, 198, 147, 20);
		contentPane.add(textdob);
		
		comboGender = new JComboBox<>(new String[]{"Male", "Female", "Other"});
		comboGender.setBounds(187, 231, 147, 20);
		contentPane.add(comboGender);

		
		JButton btnlogin = new JButton("Login");
		btnlogin.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			login l1 = new login();
			 l1.setVisible(true);
			SignUp.this.dispose();
			}
		});
		btnlogin.setForeground(new Color(128, 0, 64));
		btnlogin.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnlogin.setBounds(70, 412, 89, 23);
		contentPane.add(btnlogin);
		
		JButton btnsignup = new JButton("Sign Up");
		btnsignup.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				validation();
				if(validation()) {
					insertData();
				}
				else {
					JOptionPane.showMessageDialog(null,"Validation issue.");
				}
				
			}
			 
			void insertData() {
				SimpleDateFormat s1 = new SimpleDateFormat("yyyy-MM-dd");
				 String mydob = s1.format(dob);
				try {
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fee_Management_System","root","Anujyadav@9005");
					//String sql = "insert into signup values(?,?,?,?,?,?,?)";
					String sql = "INSERT INTO signup(id, fname, lname, gender, password, dob, mobile) VALUES (?, ?, ?, ?, ?, ?, ?)";

					PreparedStatement st = con.prepareStatement(sql);
					  st.setInt(1,getId());
					  st.setString(2, fname);
					  st.setString(3, lname);
					  st.setString(4, gender);
					  st.setString(5, pass);
					  st.setString(6, mydob);
					  st.setString(7, mobile);
					  int i = st.executeUpdate();
					  if(i>0) {
						  JOptionPane.showMessageDialog(null,"record insert successfully:");
					  }
					  else {
						  JOptionPane.showMessageDialog(null,"record insert not successfully:");
					  }
				}
				catch(Exception e) {
					e.printStackTrace();
					
				}
			}
			boolean validation()
			{
	 			 fname = textFirst.getText();	
	 			 lname = textLast.getText();	
	 			 gender = (String) comboGender.getSelectedItem();
	 			 pass =new String(password1.getPassword());	
	 			 cpass =new String(password2.getPassword());		
	 			 mobile = textMob.getText();
	 			 dob = textdob.getDate();
	 			 
	 			 if (fname.trim().isEmpty()) {
	 	            JOptionPane.showMessageDialog(null, "Please enter the first name...");
	 	            return false;
	 	        }	 
	 			 
	 			 if (lname.trim().isEmpty()) {
		 	            JOptionPane.showMessageDialog(null, "Please enter the last name....");
		 	            return false;
		 	        }	 
	 			 
	 			 if (gender.trim().isEmpty()) {
		 	            JOptionPane.showMessageDialog(null, "Please enter the  gender...");
		 	            return false;
		 	        }	 
	 			 
	 			 if (pass.trim().isEmpty()) {
		 	            JOptionPane.showMessageDialog(null, "Please enter the password......");
		 	            return false;
		 	        }	 
	 			 if (cpass.trim().isEmpty()) {
		 	            JOptionPane.showMessageDialog(null, "Please enter the confirm password....");
		 	            return false;
		 	        }
	 			 
	 			if (cpass.trim().isEmpty()) {
	 			    JOptionPane.showMessageDialog(null, "Please confirm your password.");
	 			    return false;
	 			}
	 			if (!pass.equals(cpass)) {
	 			    JOptionPane.showMessageDialog(null, "Passwords do not match.");
	 			    return false;
	 			}
	 			if (dob == null) {
	 			    JOptionPane.showMessageDialog(null, "Please select your Date of Birth.");
	 			    return false;
	 			}
	 			if (mobile.trim().isEmpty() || !mobile.matches("\\d{10}")) {
	 			    JOptionPane.showMessageDialog(null, "Enter valid 10-digit mobile number.");
	 			    return false;
	 			}
	 			 return true;
			}
			

			
			
		});
		btnsignup.setForeground(new Color(128, 0, 64));
		btnsignup.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnsignup.setBounds(245, 413, 89, 23);
		contentPane.add(btnsignup);
		
		JButton btnclear = new JButton("Clear");
		btnclear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				 textFirst.setText("");	
	 			 textLast.setText("");	
	 			// comboGender).clearSelection();
	 			 password1.setText("");	
	 			 password2.setText("");		
	 			 textMob.setText("");
	 			lblcpass.setText("");
				
				
			}
		});
		btnclear.setForeground(new Color(128, 0, 0));
		btnclear.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnclear.setBounds(426, 413, 89, 23);
		contentPane.add(btnclear);
		
	    lblmerror = new JLabel("");
		lblmerror.setForeground(new Color(255, 0, 0));
		lblmerror.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblmerror.setBounds(341, 357, 349, 21);
		contentPane.add(lblmerror);
		
	    lblPasserror = new JLabel("");
		lblPasserror.setForeground(Color.RED);
		lblPasserror.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblPasserror.setBounds(322, 269, 349, 21);
		contentPane.add(lblPasserror);
		
		lblcpass = new JLabel("");
		lblcpass.setForeground(Color.RED);
		lblcpass.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblcpass.setBounds(308, 310, 349, 21);
		contentPane.add(lblcpass);
		
//		JComboBox<String> textGen = new JComboBox<>(new String[] {"Male", "Female", "Other"});
//
//		textGen.setEditable(true);
//		textGen.setForeground(new Color(0, 0, 0));
//		textGen.setFont(new Font("Times New Roman", Font.PLAIN, 18));
//		textGen.setToolTipText("Male");
//		textGen.setBounds(187, 232, 86, 22);
//		contentPane.add(textGen);
		comboGender = new JComboBox<>();
		comboGender.addItem("Male");
		comboGender.addItem("Female");
		comboGender.addItem("Other");
		comboGender.setBounds(187, 231, 147, 20);
		contentPane.add(comboGender);

	}

	protected void passwordCheck() {
		// TODO Auto-generated method stub
		String pass =new String(password1.getPassword());	
			
			if(pass.length() >= 8) 
			{
				lblPasserror.setText("");
			}
			else
			{
				lblPasserror.setText("Enter 8 digit password....");
			}
	}

	protected void mobileCheck() {
		// TODO Auto-generated method stub
		 mobile = textMob.getText();
			if(mobile.length()==10) 
			{
				 lblmerror.setText("");
			}
			 else 
			 {
				 lblmerror.setText("Plese enter 10 digit mobile number..");
			 }
		
	}
	protected boolean confirmPass()
	{
		String pass =new String(password1.getPassword());	
		String cpass =new String(password2.getPassword());	
		if (!pass.equals(cpass)) {
		    lblcpass.setText("Passwords do not match!");
		    return false;
		} else {
		    lblcpass.setText("password match");
		}
		return true;

	}
	
}

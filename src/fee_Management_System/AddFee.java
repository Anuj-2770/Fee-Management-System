package fee_Management_System;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Window;

import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import com.toedter.calendar.JDateChooser;

public class AddFee extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtreceipt;
	private JTextField txtcheck;
	private JTextField txtroll;
	private JTextField txtyear2;
	private JTextField txtyear1;
	private JTextField txthead;
	private JTextField txtamount;
	private JTextField txtcgst;
	private JTextField txtsgst;
	private JTextField txttotal;
	private JTextField txtbank;
	private JTextField txttotalinword;
	private JTextField txtdd;
	private JLabel lbldd;
	private JLabel lblcheck;
	private JLabel lblbank;
	private JTextField txtreceive;
	private JDateChooser dateChooser;
	private JComboBox<String> txtmop;
	private JComboBox<String> txtcourse;
	private JTextArea textArea;
	private JTextField txtgstin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddFee frame = new AddFee();
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
	
	 public void displaycashfirst() {
		 
			lbldd.setVisible(false);
			lblcheck.setVisible(false);
			lblbank.setVisible(false);
			txtdd.setVisible(false);
			txtcheck.setVisible(false);
			txtbank.setVisible(false);
			 
		 }
	 public class NumberToWordsConverter {

		    private static final String[] units = {
		        "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", 
		        "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", 
		        "Sixteen", "Seventeen", "Eighteen", "Nineteen"
		    };

		    private static final String[] tens = {
		        "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
		    };

		    public static String convertToWords(int number) {
		        if (number == 0) {
		            return "Zero Only";
		        }

		        return convert(number).trim() + "Only";
		    }

		    private static String convert(int number) {
		        if (number < 20) {
		            return units[number];
		        } else if (number < 100) {
		            return tens[number / 10] + " " + units[number % 10];
		        } else if (number < 1000) {
		            return units[number / 100] + " Hundred " + convert(number % 100);
		        } else if (number < 100000) {
		            return convert(number / 1000) + " Thousand " + convert(number % 1000);
		        } else if (number < 10000000) {
		            return convert(number / 100000) + " Lakh " + convert(number % 100000);
		        } else {
		            return convert(number / 10000000) + " Crore " + convert(number % 10000000);
		        }
		    }

		    // Example usage
		    public static void main(String[] args) {
		        int amount = 1234567;
		        String result = convertToWords(amount);
		        System.out.println("In words: " + result);
		    }
		}

	 
	 boolean validation() {
		 
		 
		 if(txtreceive.getText().equals("")) {
			 JOptionPane.showMessageDialog(this, "please Enter receiver Name first");
			 return false;
		 }
		 if(txtamount.getText().equals("") || !txtamount.getText().matches("\\d+")) {
			    JOptionPane.showMessageDialog(this, "Please enter amount (in numbers only)");
			    return false;
			}

		 if(txtreceipt.getText().equals("")) {
			 JOptionPane.showMessageDialog(this, "please Enter receipt number");
			 return false;
		 }
		  if (dateChooser == null || dateChooser.getDate() == null) {
	            JOptionPane.showMessageDialog(this, "Please select a date");
	            return false;
	        }
		 if(txtroll.getText().equals("")) {
			 JOptionPane.showMessageDialog(this, "please Enter roll number");
			 return false;
		 }
		  if(txtmop.getSelectedItem().toString().equalsIgnoreCase("check")) {
			     if(txtcheck.getText().equals("")) {
					 JOptionPane.showMessageDialog(this, "please Enter cheque number");
					 return false;
			      }
				  if(txtbank.getText().equals("")) {
						 JOptionPane.showMessageDialog(this, "please Enter Bank Name");
						 return false;
				  }
			  
		  }
		  if(txtmop.getSelectedItem().toString().equalsIgnoreCase("dd")) {
			     if(txtdd.getText().equals("")) {
					 JOptionPane.showMessageDialog(this, "please Enter DD number");
					 return false;
			      }
				  if(txtbank.getText().equals("")) {
						 JOptionPane.showMessageDialog(this, "please Enter Bank Name");
						 return false;
				  }
			  
		  }
		 return true;
	 }
	 
	 public void fillComboBox() {
		 try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
				
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fee_Management_System","root","Anujyadav@9005");
				String sql = "select  Cname from course";
				PreparedStatement st = con.prepareStatement(sql);
				 ResultSet rs = st.executeQuery();
			while(rs.next()) {
				
				txtcourse.addItem(rs.getString("Cname"));
			
			}
			 
		 }
		 catch(Exception e) {
			 e.printStackTrace();
		 }
	 }
	
	 public int getRecieptNo() {
		 int rnumber =0;
		 try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
				
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fee_Management_System","root","Anujyadav@9005");
				String sql = "select  max(reciept_no) from fees_details";
				PreparedStatement st = con.prepareStatement(sql);
				 ResultSet rs = st.executeQuery();
			if(rs.next()==true) {
				rnumber = rs.getInt(1);
			}
			 
		 }
		 catch(Exception e) {
			 e.printStackTrace();
		 }
		return rnumber;
	 }
	 
	 public String insertData() {
		 String status ="";
		 
		 int reciept_no = Integer.parseInt(txtreceipt.getText());
		 String Rname = txtreceive.getText();
		 String rollno = txtroll.getText();
		 String paymentmode = txtmop.getSelectedItem().toString();
		 String chequeno = txtcheck.getText();
		 String ddno = txtdd.getText();
		 String bankname = txtbank.getText();
		 String gstin = txtgstin.getText();
		 String course = txtcourse.getSelectedItem().toString();
		 float total = Float.parseFloat(txttotal.getText());
		 SimpleDateFormat sd1 = new SimpleDateFormat("yyyy-MM-dd");
		 String date = sd1.format(dateChooser.getDate());
		 float amount = Float.parseFloat(txtamount.getText());
		 float cgst = Float.parseFloat(txtcgst.getText());
		 float sgst = Float.parseFloat(txtsgst.getText());
		 String totalinword = txttotalinword.getText();
		 String remark = textArea.getText();
		 int year1st = Integer.parseInt(txtyear1.getText());
		 int year2nd = Integer.parseInt(txtyear2.getText());
		 
		 try {
			 
			    Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fee_Management_System","root","Anujyadav@9005");
				String sql = "insert into fees_details values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement st = con.prepareStatement(sql);
				st.setInt(1, reciept_no);
				st.setString(2,Rname);
				st.setString(3,rollno);
				st.setString(4,paymentmode);
				st.setString(5,chequeno);
				st.setString(6,ddno);
				st.setString(7,bankname);
				st.setString(8, gstin);
				st.setString(9,course);
				st.setFloat(10, total);
				st.setString(11,date);
				st.setFloat(12, amount);
				st.setFloat(13, cgst);
				st.setFloat(14, sgst);
				st.setString(15,totalinword);
				st.setString(16,remark);
				st.setInt(17, year1st);
				st.setInt(18,year2nd);
				int c = st.executeUpdate();
				if(c==1) {
					status = "success";
					
				}
				else
				{
					status = "failed";
				}
				
				
			 
			 
		 }
		 catch(Exception e1) {
			 e1.printStackTrace();	 
		 }
		 	return status;	 
	 }
	

	public AddFee() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 974, 695);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 958, 74);
		panel.setBackground(new Color(0, 0, 255));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add fee");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(491, 11, 87, 36);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 75, 203, 556);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("HOME");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HomePage hp = new HomePage();
				hp.setVisible(true);
				AddFee.this.dispose();
			}
		});
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton.setBounds(26, 52, 133, 23);
		panel_1.add(btnNewButton);
		
		JButton btnSearchRecords = new JButton("Search Records");
		btnSearchRecords.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 HomePage hp = new HomePage();
				   hp.setVisible(true);
				   AddFee.this.dispose();
			}
		});
		btnSearchRecords.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnSearchRecords.setBackground(Color.GREEN);
		btnSearchRecords.setBounds(20, 115, 139, 23);
		panel_1.add(btnSearchRecords);
		
		JButton btnEditCourse = new JButton("Edit  Course");
		btnEditCourse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AddFee af = new AddFee();
				af.setVisible(true);
				AddFee.this.dispose();
			}
		});
		btnEditCourse.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnEditCourse.setBackground(Color.GREEN);
		btnEditCourse.setBounds(26, 297, 133, 23);
		panel_1.add(btnEditCourse);
		
		JButton btnViewCourses = new JButton("View Courses ");
		btnViewCourses.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 HomePage hp = new HomePage();
				   hp.setVisible(true);
				   AddFee.this.dispose();
			}
		});
		btnViewCourses.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnViewCourses.setBackground(Color.GREEN);
		btnViewCourses.setBounds(26, 249, 133, 23);
		panel_1.add(btnViewCourses);
		
		JButton btnViewAllRecords = new JButton("View All Records ");
		btnViewAllRecords.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 HomePage hp = new HomePage();
				   hp.setVisible(true);
				   AddFee.this.dispose();
			}
		});
		btnViewAllRecords.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnViewAllRecords.setBackground(Color.GREEN);
		btnViewAllRecords.setBounds(26, 358, 133, 23);
		panel_1.add(btnViewAllRecords);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SignUp<?> su = new SignUp<Object>();
				su.setVisible(true);
				AddFee.this.dispose();
			}
		});
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnBack.setBackground(Color.GREEN);
		btnBack.setBounds(26, 425, 133, 23);
		panel_1.add(btnBack);
		
		JButton btnLogout = new JButton("LOGOUT");
		btnLogout.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnLogout.setBackground(Color.GREEN);
		btnLogout.setBounds(26, 494, 133, 23);
		panel_1.add(btnLogout);
		
		JButton btnSearchRecords_1 = new JButton("Add Course");
		btnSearchRecords_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnSearchRecords_1.setBackground(Color.GREEN);
		btnSearchRecords_1.setBounds(20, 172, 139, 23);
		panel_1.add(btnSearchRecords_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(143, 188, 143));
		panel_2.setBounds(203, 74, 755, 556);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
	    JLabel lblreceipt = new JLabel("Receipt No:");
		lblreceipt.setBackground(new Color(240, 230, 140));
		lblreceipt.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblreceipt.setBounds(40, 27, 92, 25);
		panel_2.add(lblreceipt);
		
		JLabel lblmop = new JLabel("Mode Of payment:");
		lblmop.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblmop.setBackground(new Color(240, 230, 140));
		lblmop.setBounds(40, 63, 115, 17);
		panel_2.add(lblmop);
		
	    lblcheck = new JLabel("Check No:");
		lblcheck.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblcheck.setBackground(new Color(240, 230, 140));
		lblcheck.setBounds(40, 95, 65, 17);
		panel_2.add(lblcheck);
		
		lbldd = new JLabel("DD No:");
		lbldd.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lbldd.setBackground(new Color(240, 230, 140));
		lbldd.setBounds(40, 95, 65, 17);
		panel_2.add(lbldd);
		
		
		txtmop = new JComboBox<>(new String[] {"GPAY", "PHONEPAY", "PAYTM", "CHECK", "CASH", "DD"});
		txtmop.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtmop.setSelectedIndex(4); // optional
		txtmop.setBounds(165, 61, 120, 22);
		panel_2.add(txtmop);

		txtmop.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        switch (txtmop.getSelectedItem().toString().toUpperCase()) {
		            case "DD":
		                lbldd.setVisible(true);
		                txtdd.setVisible(true);
		                lblcheck.setVisible(false);
		                txtcheck.setVisible(false);
		                lblbank.setVisible(true);
		                txtbank.setVisible(true);
		                break;
		            case "CHECK":
		                lbldd.setVisible(false);
		                txtdd.setVisible(false);
		                lblcheck.setVisible(true);
		                txtcheck.setVisible(true);
		                lblbank.setVisible(true);
		                txtbank.setVisible(true);
		                break;
		            default:
		                lbldd.setVisible(false);
		                txtdd.setVisible(false);
		                lblcheck.setVisible(false);
		                txtcheck.setVisible(false);
		                lblbank.setVisible(false);
		                txtbank.setVisible(false);
		        }
		    }
		});

		txtmop = new JComboBox<>();
		txtmop.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtmop.setModel(new DefaultComboBoxModel(new String[] {"GPAY", "PHONEPAY", "PAYTM", "CHECK", "CASH", "DD"}));
		txtmop.setSelectedIndex(4);
		txtmop.setBounds(165, 61, 83, 22);
		panel_2.add(txtmop);
		
		txtreceipt = new JTextField();
		txtreceipt.setBounds(165, 30, 86, 20);
		panel_2.add(txtreceipt);
		txtreceipt.setColumns(10);
		
		
		int r = getRecieptNo();
		r++;
		txtreceipt.setText(Integer.toString(r));
		
		txtcheck = new JTextField();
		txtcheck.setBounds(162, 94, 86, 20);
		panel_2.add(txtcheck);
		txtcheck.setColumns(10);
		
		lblbank = new JLabel("Bank Name:");
		lblbank.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblbank.setBounds(319, 93, 83, 20);
		panel_2.add(lblbank);

		txtbank = new JTextField();
		txtbank.setBounds(431, 94, 86, 20);
		panel_2.add(txtbank);
		txtbank.setColumns(10);

		txtdd = new JTextField();
		txtdd.setBounds(162, 94, 86, 20);
		panel_2.add(txtdd);
		txtdd.setColumns(10);
		
		displaycashfirst();
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(95, 158, 160));
		panel_3.setBounds(0, 127, 716, 429);
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1_3 = new JLabel("Recived from for the given year :");
		lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1_3.setBackground(new Color(240, 230, 140));
		lblNewLabel_1_3.setBounds(43, 41, 219, 25);
		panel_3.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("To");
		lblNewLabel_1_4.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1_4.setBackground(new Color(240, 230, 140));
		lblNewLabel_1_4.setBounds(366, 43, 15, 21);
		panel_3.add(lblNewLabel_1_4);
		
		txtyear2 = new JTextField();
		txtyear2.setColumns(10);
		txtyear2.setBounds(405, 44, 72, 19);
		panel_3.add(txtyear2);
		
		txtyear1 = new JTextField();
		txtyear1.setColumns(10);
		txtyear1.setBounds(268, 44, 72, 20);
		panel_3.add(txtyear1);
		
		JLabel lblNewLabel_1_5 = new JLabel("Course :");
		lblNewLabel_1_5.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1_5.setBackground(new Color(240, 230, 140));
		lblNewLabel_1_5.setBounds(43, 77, 72, 25);
		panel_3.add(lblNewLabel_1_5);
		
		JComboBox<?> txtcoursename = new JComboBox();
		txtcoursename.setModel(new DefaultComboBoxModel(new String[] {"BTECH", "MTECH", "MCA", "BBA", "BCA"}));
		txtcoursename.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtcoursename.setBounds(168, 79, 83, 22);
		panel_3.add(txtcoursename);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(220, 20, 60));
		separator.setBounds(0, 113, 713, 25);
		panel_3.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(new Color(220, 20, 60));
		separator_1.setBounds(0, 144, 723, 2);
		panel_3.add(separator_1);
		
		JLabel lblNewLabel_1_5_1 = new JLabel("Sr No :");
		lblNewLabel_1_5_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1_5_1.setBackground(new Color(240, 230, 140));
		lblNewLabel_1_5_1.setBounds(43, 113, 72, 25);
		panel_3.add(lblNewLabel_1_5_1);
		
		JLabel lblNewLabel_1_5_2 = new JLabel("Head");
		lblNewLabel_1_5_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1_5_2.setBackground(new Color(240, 230, 140));
		lblNewLabel_1_5_2.setBounds(309, 113, 72, 25);
		panel_3.add(lblNewLabel_1_5_2);
		
		JLabel lblNewLabel_1_5_3 = new JLabel("Amounts ");
		lblNewLabel_1_5_3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1_5_3.setBackground(new Color(240, 230, 140));
		lblNewLabel_1_5_3.setBounds(609, 113, 72, 25);
		panel_3.add(lblNewLabel_1_5_3);
		
		txthead = new JTextField();
		txthead.setColumns(10);
		txthead.setBounds(168, 149, 309, 25);
		panel_3.add(txthead);
		
		txtamount = new JTextField();
		txtamount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                     String s1 = txtamount.getText();
                     float amt = Float.parseFloat(s1);
                     
                     float cgst = amt*0.07f;
                     float sgst = amt*0.07f;
                     txtcgst.setText(Float.toString(cgst));
                     txtsgst.setText(Float.toString(sgst));
                     
                     float total = amt + cgst + sgst;
                     txttotal.setText(Float.toString(total));
                     
                     txttotalinword.setText(NumberToWordsConverter.convert((int)total));
                     
                     
                     
                     
			 }
		});
		txtamount.setColumns(10);
		txtamount.setBounds(608, 144, 86, 20);
		panel_3.add(txtamount);
		
		txtcgst = new JTextField();
		txtcgst.setColumns(10);
		txtcgst.setBounds(609, 176, 86, 20);
		panel_3.add(txtcgst);
		
		txtsgst = new JTextField();
		txtsgst.setColumns(10);
		txtsgst.setBounds(609, 207, 86, 20);
		panel_3.add(txtsgst);
		
		txttotal = new JTextField();
		txttotal.setColumns(10);
		txttotal.setBounds(609, 275, 86, 20);
		panel_3.add(txttotal);
		
		JLabel lblNewLabel_1_5_4 = new JLabel("CGST :");
		lblNewLabel_1_5_4.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1_5_4.setBackground(new Color(240, 230, 140));
		lblNewLabel_1_5_4.setBounds(490, 176, 72, 25);
		panel_3.add(lblNewLabel_1_5_4);
		
		JLabel lblNewLabel_1_5_5 = new JLabel("SGST :");
		lblNewLabel_1_5_5.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1_5_5.setBackground(new Color(240, 230, 140));
		lblNewLabel_1_5_5.setBounds(490, 207, 72, 25);
		panel_3.add(lblNewLabel_1_5_5);
		
		JLabel lblNewLabel_1_5_6 = new JLabel("Total amount");
		lblNewLabel_1_5_6.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1_5_6.setBackground(new Color(240, 230, 140));
		lblNewLabel_1_5_6.setBounds(490, 275, 95, 25);
		panel_3.add(lblNewLabel_1_5_6);
		
		JLabel lblNewLabel_1_5_7 = new JLabel("Remark");
		lblNewLabel_1_5_7.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1_5_7.setBackground(new Color(240, 230, 140));
		lblNewLabel_1_5_7.setBounds(43, 272, 72, 25);
		panel_3.add(lblNewLabel_1_5_7);
		
		textArea = new JTextArea();
		textArea.setBounds(168, 275, 309, 99);
		panel_3.add(textArea);
		
		JLabel lblNewLabel_1_5_7_1 = new JLabel("Receiver Signature");
		lblNewLabel_1_5_7_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1_5_7_1.setBackground(new Color(240, 230, 140));
		lblNewLabel_1_5_7_1.setBounds(490, 398, 204, 25);
		panel_3.add(lblNewLabel_1_5_7_1);
		
		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setBackground(new Color(220, 20, 60));
		separator_1_2.setBounds(494, 262, 239, 2);
		panel_3.add(separator_1_2);
		
		JSeparator separator_1_2_1 = new JSeparator();
		separator_1_2_1.setBackground(new Color(220, 20, 60));
		separator_1_2_1.setBounds(494, 385, 239, 2);
		panel_3.add(separator_1_2_1);
		
		JLabel lblNewLabel_1_6_1 = new JLabel("Total in word");
		lblNewLabel_1_6_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1_6_1.setBackground(new Color(240, 230, 140));
		lblNewLabel_1_6_1.setBounds(43, 236, 95, 25);
		panel_3.add(lblNewLabel_1_6_1);
		
		txttotalinword = new JTextField();
		txttotalinword.setColumns(10);
		txttotalinword.setBounds(168, 236, 309, 25);
		panel_3.add(txttotalinword);
		
		JLabel lblNewLabel_1_5_8 = new JLabel("Receiver'Name");
		lblNewLabel_1_5_8.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1_5_8.setBackground(new Color(240, 230, 140));
		lblNewLabel_1_5_8.setBounds(43, 5, 101, 25);
		panel_3.add(lblNewLabel_1_5_8);
		
		txtreceive = new JTextField();
		txtreceive.setColumns(10);
		txtreceive.setBounds(163, 8, 177, 20);
		panel_3.add(txtreceive);
		
		JLabel lblNewLabel_2 = new JLabel("Date :");
		lblNewLabel_2.setBounds(319, 33, 60, 14);
		panel_2.add(lblNewLabel_2);
		
	    dateChooser = new JDateChooser();
		dateChooser.setBounds(402, 27, 115, 20);
		panel_2.add(dateChooser);
		
		JLabel lblNewLabel_2_1 = new JLabel("Roll No:");
		lblNewLabel_2_1.setBounds(319, 65, 60, 14);
		panel_2.add(lblNewLabel_2_1);
		
		txtroll = new JTextField();
		txtroll.setColumns(10);
		txtroll.setBounds(402, 58, 115, 20);
		panel_2.add(txtroll);
		
		
		JButton btnNewButton_1 = new JButton("Print");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(validation()==true) {
					String s = insertData();
					
					if(s.equals("success")) {
						JOptionPane.showMessageDialog(null, "Record insert successfully:");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Record insert Unsuccessfully:");
					}
				}
			}
		});
		btnNewButton_1.setBackground(new Color(192, 192, 192));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(630, 0, 95, 23);
		panel_2.add(btnNewButton_1);
		
		JLabel lblCourse = new JLabel("Subject :");
		lblCourse.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblCourse.setBackground(new Color(240, 230, 140));
		lblCourse.setBounds(546, 63, 65, 17);
		panel_2.add(lblCourse);
		
		txtcourse = new JComboBox<String>();
		txtcourse.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				String s1 = txtcourse.getSelectedItem().toString();
				txthead.setText(s1);
			}
		});
		fillComboBox(); // populate ComboBox first

		if (txtcourse.getItemCount() > 0) {
		    txtcourse.setSelectedIndex(0); // safely select first item
		}

		txtcourse.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtcourse.setBounds(630, 61, 95, 22);
		panel_2.add(txtcourse);
		
		JLabel lblGstin = new JLabel("GSTIN");
		lblGstin.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblGstin.setBackground(new Color(240, 230, 140));
		lblGstin.setBounds(546, 97, 60, 17);
		panel_2.add(lblGstin);
		
		txtgstin = new JTextField();
		txtgstin.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtgstin.setBackground(new Color(144, 238, 144));
		txtgstin.setText("AVC5677GHJ");
		txtgstin.setBounds(633, 94, 92, 20);
		panel_2.add(txtgstin);
		txtgstin.setColumns(10);
		
		//fillComboBox();
	}
}

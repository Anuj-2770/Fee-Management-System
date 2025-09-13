package fee_Management_System;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.FlowLayout;

public class HomePage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage frame = new HomePage();
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
	public HomePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 858, 599);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 0, 128));
		panel.setBounds(0, 0, 853, 81);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("HOME PAGE");
		lblNewLabel.setIcon(new ImageIcon(HomePage.class.getResource("/fee_Management_System/images.png")));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 32));
		lblNewLabel.setBounds(302, 11, 279, 49);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(81, 174, 114));
		panel_1.setBounds(0, 81, 853, 606);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel2 = new JPanel();
		panel2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Color c1 = new Color(100,100,100);
				panel2.setBackground(c1);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Color c1 = new Color(240,240,240);
				panel2.setBackground(c1);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				AddFee af = new AddFee();
				af.setVisible(true);
				HomePage.this.dispose();
			}
		});
		panel2.setBounds(23, 51, 169, 73);
		panel_1.add(panel2);
		
		JLabel searchbar = new JLabel("ADD FEE");
		searchbar.setForeground(new Color(0, 128, 255));
		searchbar.setBounds(49, 25, 68, 30);
		searchbar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Color c1 = new Color(16);
				searchbar.setBackground(c1);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Color c1 = new Color(240,240,240);
				searchbar.setBackground(c1);
			}
			
		});
		panel2.setLayout(null);
		searchbar.setFont(new Font("Tahoma", Font.BOLD, 14));
		searchbar.setOpaque(true);
		panel2.add(searchbar);
		
		JPanel panel2_1 = new JPanel();
		panel2_1.setLayout(null);
		panel2_1.setBounds(292, 47, 169, 77);
		panel_1.add(panel2_1);
		
		JLabel searchbar_1 = new JLabel("VIEW COURSE");
		searchbar_1.setOpaque(true);
		searchbar_1.setForeground(new Color(0, 128, 255));
		searchbar_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		searchbar_1.setBounds(26, 22, 116, 30);
		panel2_1.add(searchbar_1);
		
		JPanel panel2_3 = new JPanel();
		panel2_3.setLayout(null);
		panel2_3.setBounds(305, 180, 156, 73);
		panel_1.add(panel2_3);
		
		JLabel searchbar_3 = new JLabel("EDIT COURSE");
		searchbar_3.setOpaque(true);
		searchbar_3.setForeground(new Color(0, 128, 255));
		searchbar_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		searchbar_3.setBounds(24, 21, 122, 30);
		panel2_3.add(searchbar_3);
		
		JPanel panel2_3_1 = new JPanel();
		panel2_3_1.setLayout(null);
		panel2_3_1.setBounds(36, 180, 156, 73);
		panel_1.add(panel2_3_1);
		
		JLabel searchbar_3_1 = new JLabel("   search");
		searchbar_3_1.setOpaque(true);
		searchbar_3_1.setForeground(new Color(0, 128, 255));
		searchbar_3_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		searchbar_3_1.setBounds(49, 21, 68, 30);
		panel2_3_1.add(searchbar_3_1);
		
		JPanel panel2_3_2 = new JPanel();
		panel2_3_2.setLayout(null);
		panel2_3_2.setBounds(531, 180, 156, 73);
		panel_1.add(panel2_3_2);
		
		JLabel searchbar_3_2 = new JLabel(" VIEW REPORT");
		searchbar_3_2.setOpaque(true);
		searchbar_3_2.setForeground(new Color(0, 128, 255));
		searchbar_3_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		searchbar_3_2.setBounds(26, 21, 120, 30);
		panel2_3_2.add(searchbar_3_2);
		
		JPanel panel2_2 = new JPanel();
		panel2_2.setLayout(null);
		panel2_2.setBounds(531, 51, 169, 73);
		panel_1.add(panel2_2);
		
		JLabel searchbar_2 = new JLabel("RECOURD");
		searchbar_2.setOpaque(true);
		searchbar_2.setForeground(new Color(0, 128, 255));
		searchbar_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		searchbar_2.setBounds(47, 21, 85, 30);
		panel2_2.add(searchbar_2);
		
		JPanel panel2_2_1 = new JPanel();
		panel2_2_1.setLayout(null);
		panel2_2_1.setBounds(36, 319, 130, 54);
		panel_1.add(panel2_2_1);
		
		JLabel searchbar_2_1 = new JLabel("  LOGOUT");
		searchbar_2_1.setOpaque(true);
		searchbar_2_1.setForeground(new Color(0, 128, 255));
		searchbar_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		searchbar_2_1.setBounds(10, 11, 95, 30);
		panel2_2_1.add(searchbar_2_1);
		
		JPanel panel2_2_2 = new JPanel();
		panel2_2_2.setLayout(null);
		panel2_2_2.setBounds(310, 313, 107, 54);
		panel_1.add(panel2_2_2);
		
		JLabel searchbar_2_2 = new JLabel("   ABOUT US");
		searchbar_2_2.setOpaque(true);
		searchbar_2_2.setForeground(new Color(0, 128, 255));
		searchbar_2_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		searchbar_2_2.setBounds(10, 11, 87, 30);
		panel2_2_2.add(searchbar_2_2);
	}
}

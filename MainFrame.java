package ecare;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 535, 441);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(21, 65, 473, 305);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton userLogin = new JButton("USER LOGIN");
		userLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userLogin s=new userLogin();
				s.setVisible(true);
				dispose();
			}
		});
		userLogin.setFont(new Font("Segoe UI Variable", Font.BOLD, 13));
		userLogin.setBounds(155, 75, 132, 42);
		panel.add(userLogin);
		
		JButton adminLogin = new JButton("ADMIN LOGIN");
		adminLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminlogin s=new adminlogin();
				s.setVisible(true);
				dispose();
			}
		});
		adminLogin.setFont(new Font("Segoe UI Variable", Font.BOLD, 13));
		adminLogin.setBounds(155, 137, 132, 42);
		panel.add(adminLogin);
		
		JButton registration = new JButton("REGISTRATION");
		registration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registration s=new Registration();
				s.setVisible(true);
				dispose();
			}
		});
		registration.setFont(new Font("Segoe UI Variable", Font.BOLD, 13));
		registration.setBounds(155, 201, 132, 42);
		panel.add(registration);
		
		JLabel lblNewLabel = new JLabel("MAIN MENU");
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 18));
		lblNewLabel.setBounds(155, 20, 138, 45);
		panel.add(lblNewLabel);
		
		JLabel heading = new JLabel("E-CARE MANAGEMENT SYSTEM");
		heading.setFont(new Font("Segoe UI Variable", Font.BOLD, 18));
		heading.setBounds(111, 11, 275, 44);
		contentPane.add(heading);
	}
}

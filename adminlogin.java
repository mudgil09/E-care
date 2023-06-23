package ecare;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class adminlogin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminlogin frame = new adminlogin();
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
	public adminlogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 535, 441);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(38, 44, 427, 316);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 53, 407, 159);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel username = new JLabel("USER NAME:");
		username.setFont(new Font("Segoe UI Variable", Font.BOLD, 14));
		username.setBounds(56, 46, 91, 25);
		panel_1.add(username);
		
		JLabel password = new JLabel("PASSWORD:");
		password.setFont(new Font("Segoe UI Variable", Font.BOLD, 14));
		password.setBounds(56, 94, 91, 25);
		panel_1.add(password);
		
		textField = new JTextField();
		textField.setBounds(146, 44, 199, 34);
		panel_1.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(146, 92, 199, 34);
		panel_1.add(passwordField);
		
		JLabel lblNewLabel = new JLabel("ADMIN LOGIN");
		lblNewLabel.setFont(new Font("Segoe UI Variable", Font.BOLD, 19));
		lblNewLabel.setBounds(138, 15, 152, 28);
		panel.add(lblNewLabel);
		
		JButton NEXT = new JButton("NEXT");
		NEXT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dbcon db=new dbcon();
				try {
					if(db.checkAdmin(textField.getText(), passwordField.getText())==1){
						adminView av=new adminView();
						av.setVisible(true);
						dispose();
					}
					else{
						JOptionPane.showMessageDialog(null, "Incorrect password retry!");
						textField.setText("");
						passwordField.setText("");
					}
				} catch (HeadlessException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		NEXT.setFont(new Font("Segoe UI Black", Font.BOLD, 13));
		NEXT.setBounds(222, 244, 97, 43);
		panel.add(NEXT);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame mf=new MainFrame();
				mf.setVisible(true);
				dispose();
			}
		});
		btnBack.setFont(new Font("Segoe UI Black", Font.BOLD, 13));
		btnBack.setBounds(91, 244, 97, 43);
		panel.add(btnBack);
	}
}

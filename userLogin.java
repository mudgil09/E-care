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
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class userLogin extends JFrame {

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
					userLogin frame = new userLogin();
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
	public userLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 535, 441);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBounds(0, 0, 521, 404);
		contentPane.add(contentPane_1);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(38, 44, 427, 316);
		contentPane_1.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(10, 53, 407, 159);
		panel.add(panel_1);
		
		JLabel username = new JLabel("USER NAME:");
		username.setFont(new Font("Segoe UI Variable", Font.BOLD, 14));
		username.setBounds(56, 46, 91, 25);
		panel_1.add(username);
		
		JLabel password = new JLabel("PASSWORD:");
		password.setFont(new Font("Segoe UI Variable", Font.BOLD, 14));
		password.setBounds(56, 94, 91, 25);
		panel_1.add(password);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(146, 44, 199, 34);
		panel_1.add(textField);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(146, 92, 199, 34);
		panel_1.add(passwordField);
		
		JLabel userlogin = new JLabel("USER LOGIN");
		userlogin.setFont(new Font("Segoe UI Variable", Font.BOLD, 19));
		userlogin.setBounds(145, 15, 152, 28);
		panel.add(userlogin);
		
		JButton NEXT = new JButton("NEXT");
		NEXT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dbcon db = new dbcon();
				try {
					if(db.checkUser(textField.getText(), passwordField.getText())){
						userview sUserview = new userview(textField.getText());
						sUserview.setVisible(true);
						dispose();
					}
					else{
						JOptionPane.showMessageDialog(null, "Incorrect password retry!");
						textField.setText("");
						passwordField.setText("");
					}
				} catch (HeadlessException | SQLException | ClassNotFoundException e1) {
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
				MainFrame sMainFrame = new MainFrame();
				sMainFrame.setVisible(false);
				dispose();
			}
		});
		btnBack.setFont(new Font("Segoe UI Black", Font.BOLD, 13));
		btnBack.setBounds(91, 244, 97, 43);
		panel.add(btnBack);
		
		
	}

}

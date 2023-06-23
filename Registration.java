package ecare;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Registration extends JFrame {

	private JPanel contentPane;
	private JTextField uid;
	private JTextField Password;
	private JTextField Email;
	private JTextField Phoneno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration frame = new Registration();
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
	public Registration() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 535, 441);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 10, 501, 384);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 49, 481, 276);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel UID = new JLabel("UID:");
		UID.setFont(new Font("Segoe UI Black", Font.BOLD, 13));
		UID.setBounds(25, 45, 67, 32);
		panel_1.add(UID);
		
		JLabel pass = new JLabel("Password:");
		pass.setFont(new Font("Segoe UI Black", Font.BOLD, 13));
		pass.setBounds(25, 87, 91, 32);
		panel_1.add(pass);
		
		JLabel PhoneNumber = new JLabel("Phone No:");
		PhoneNumber.setFont(new Font("Segoe UI Black", Font.BOLD, 13));
		PhoneNumber.setBounds(25, 172, 119, 32);
		panel_1.add(PhoneNumber);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Segoe UI Black", Font.BOLD, 13));
		lblEmail.setBounds(25, 130, 102, 32);
		panel_1.add(lblEmail);
		
		JLabel lblLocation = new JLabel("Location:");
		lblLocation.setFont(new Font("Segoe UI Black", Font.BOLD, 13));
		lblLocation.setBounds(25, 214, 102, 32);
		panel_1.add(lblLocation);
		
		uid = new JTextField();
		uid.setBounds(134, 47, 219, 32);
		panel_1.add(uid);
		uid.setColumns(10);
		
		Password = new JTextField();
		Password.setColumns(10);
		Password.setBounds(134, 89, 219, 32);
		panel_1.add(Password);
		
		Email = new JTextField();
		Email.setColumns(10);
		Email.setBounds(134, 132, 219, 32);
		panel_1.add(Email);
		
		Phoneno = new JTextField();
		Phoneno.setColumns(10);
		Phoneno.setBounds(134, 172, 219, 32);
		panel_1.add(Phoneno);
		
		JTextArea Location = new JTextArea();
		Location.setBounds(137, 219, 216, 44);
		panel_1.add(Location);
		
		JButton save = new JButton("SAVE AND BACK");
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dbcon db=new dbcon();
				if(db.EnternewRegistration(uid.getText(), Password.getText(), Email.getText(), Phoneno.getText(), Location.getText())==1){
					MainFrame mf=new MainFrame();
					mf.setVisible(true);
					dispose();
				}
				else{
					JOptionPane.showMessageDialog(null, "retry registration not successfull !");
				}
			}
		});
		save.setFont(new Font("Segoe UI Variable", Font.BOLD, 11));
		save.setBounds(262, 332, 123, 42);
		panel.add(save);
		
		JButton btnBack = new JButton("back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBack.setFont(new Font("Segoe UI Variable", Font.BOLD, 12));
		btnBack.setBounds(88, 332, 123, 42);
		panel.add(btnBack);
		
		JLabel lblNewLabel = new JLabel("REGISTRATION FORM");
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		lblNewLabel.setBounds(153, 11, 199, 28);
		panel.add(lblNewLabel);
	}
}

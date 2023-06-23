package ecare;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class userview extends JFrame {

	private JPanel contentPane;
	private JTextField devicetype;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					userview frame = new userview("Pandusai");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param username 
	 */
	public userview(String username) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 535, 441);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(10, 10, 501, 384);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("HI WELCOME BACK "+username);
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 10, 432, 31);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Device Type (Phone,Tab,TV, Laptop):");
		lblNewLabel_1.setFont(new Font("MS PGothic", Font.BOLD, 12));
		lblNewLabel_1.setBounds(10, 72, 211, 31);
		panel.add(lblNewLabel_1);
		
		devicetype = new JTextField();
		devicetype.setBounds(216, 72, 247, 31);
		panel.add(devicetype);
		devicetype.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Discribe your device details:");
		lblNewLabel_1_1.setFont(new Font("MS PGothic", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(10, 124, 172, 31);
		panel.add(lblNewLabel_1_1);
		
		JTextArea devicedetails = new JTextArea();
		devicedetails.setBounds(216, 113, 247, 48);
		panel.add(devicedetails);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Issue with device:");
		lblNewLabel_1_1_1.setFont(new Font("MS PGothic", Font.BOLD, 12));
		lblNewLabel_1_1_1.setBounds(10, 179, 172, 31);
		panel.add(lblNewLabel_1_1_1);
		
		JTextArea issue = new JTextArea();
		issue.setBounds(216, 171, 247, 81);
		panel.add(issue);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("System Specifications:");
		lblNewLabel_1_1_1_1.setFont(new Font("MS PGothic", Font.BOLD, 12));
		lblNewLabel_1_1_1_1.setBounds(10, 275, 172, 31);
		panel.add(lblNewLabel_1_1_1_1);
		
		JTextArea sysspec = new JTextArea();
		sysspec.setBounds(216, 262, 247, 58);
		panel.add(sysspec);
		
		JButton raiseissue = new JButton("submit isssue");
		raiseissue.setFont(new Font("Segoe UI Variable", Font.BOLD, 15));
		raiseissue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dbcon db=new dbcon();
				String id=db.getId();
					if(db.EnterCompliant(id, devicetype.getText(), devicedetails.getText(), issue.getText(), sysspec.getText())==1){
						JOptionPane.showMessageDialog(null, " details entered !");
						accknowledgement ack=new accknowledgement(id);
						ack.setVisible(true);
						dispose();
						
						
					}
					else{
						JOptionPane.showMessageDialog(null, "details not entered retry!");
						
					}
				}
		});
		raiseissue.setBounds(313, 330, 150, 44);
		panel.add(raiseissue);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(ABORT);
			}
		});
		btnExit.setFont(new Font("Segoe UI Variable", Font.BOLD, 15));
		btnExit.setBounds(32, 330, 150, 44);
		panel.add(btnExit);
	}
}

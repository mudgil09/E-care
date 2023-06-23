package ecare;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class accknowledgement extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					accknowledgement frame = new accknowledgement("sdfasdfdsf");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param id 
	 */
	public accknowledgement(String id) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 535, 441);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(101, 10, 301, 384);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SuccessFull Submission!✅");
		lblNewLabel.setFont(new Font("MS UI Gothic", Font.BOLD, 20));
		lblNewLabel.setBounds(34, 10, 257, 36);
		panel.add(lblNewLabel);
		
		JLabel TockenNumber = new JLabel("TOCKEN NUMBER");
		TockenNumber.setFont(new Font("SansSerif", Font.BOLD, 15));
		TockenNumber.setBounds(72, 74, 153, 43);
		panel.add(TockenNumber);
		
		JLabel tockenpin = new JLabel("XXXXXXXXXXXXX\r\n");
		tockenpin.setFont(new Font("SansSerif", Font.BOLD, 15));
		tockenpin.setBounds(82, 127, 153, 43);
		panel.add(tockenpin);
		tockenpin.setText(id);
		
		JButton btnNewButton = new JButton("EXIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(ABORT);
			}
		});
		btnNewButton.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		btnNewButton.setBounds(72, 180, 153, 51);
		panel.add(btnNewButton);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(10, 52, 281, 260);
		panel.add(panel_1);
	}

}

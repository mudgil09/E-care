package ecare;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class entryofSolution extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					entryofSolution frame = new entryofSolution("");
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
	public entryofSolution(String id) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 535, 441);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Suggestion:");
		lblNewLabel.setFont(new Font("MS PGothic", Font.BOLD, 16));
		lblNewLabel.setBounds(37, 74, 121, 25);
		contentPane.add(lblNewLabel);
		
		JTextArea sugges = new JTextArea();
		sugges.setBounds(131, 52, 364, 67);
		contentPane.add(sugges);
		
		JLabel lblAdvice = new JLabel("Advice:");
		lblAdvice.setFont(new Font("MS PGothic", Font.BOLD, 16));
		lblAdvice.setBounds(37, 159, 121, 25);
		contentPane.add(lblAdvice);
		
		JTextArea advice = new JTextArea();
		advice.setBounds(131, 138, 364, 82);
		contentPane.add(advice);
		
		JLabel lblPrevention = new JLabel("Prevention:");
		lblPrevention.setFont(new Font("MS PGothic", Font.BOLD, 16));
		lblPrevention.setBounds(37, 264, 121, 25);
		contentPane.add(lblPrevention);
		
		JTextArea prevention = new JTextArea();
		prevention.setBounds(131, 239, 364, 90);
		contentPane.add(prevention);
		
		JLabel lblSolutionForTocken = new JLabel("Solution for Tocken Number :"+id);
		lblSolutionForTocken.setFont(new Font("MS PGothic", Font.BOLD, 16));
		lblSolutionForTocken.setBounds(37, 10, 458, 25);
		contentPane.add(lblSolutionForTocken);
		
		JButton save = new JButton("save and back");
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dbcon db=new dbcon();
				if(db.EnterSolution(id, sugges.getText(), advice.getText(), prevention.getText())==1){
					dispose();
					adminView ad=new adminView();
					ad.setVisible(true);
				}
				else{
					JOptionPane.showMessageDialog(null, "issue not entered ! retry");
				}

			}
		});
		save.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
		save.setBounds(322, 346, 173, 48);
		contentPane.add(save);
		
		JButton btnExit = new JButton("exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(ABORT);
			}
		});
		btnExit.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
		btnExit.setBounds(131, 346, 173, 48);
		contentPane.add(btnExit);
	}

}

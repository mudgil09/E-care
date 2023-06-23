package ecare;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class adminView extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField tockenentry;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminView frame = new adminView();
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
	public adminView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 535, 441);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(203, 197, 202));
		panel.setBounds(10, 21, 501, 354);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("TOCKEN NUMBERS");
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 17, 137, 25);
		panel.add(lblNewLabel);
		
		/*JScrollPane sc=new JScrollPane();
		sc.setBounds(10, 52, 137, 292);
		panel.add(sc);
		DefaultTableModel model=new DefaultTableModel();
		String [] col= {"tockens"};
		model.setColumnIdentifiers(col);
		dbcon db=new dbcon();
		ArrayList<String> sr=db.getTockens();
		Iterator sf=sr.iterator();
		while(sf.hasNext()) {
			String sg[] = null;
			sg[0]=(String) sf.next();
			model.addRow(sg);
		}
		JTable table=new JTable(model);
		sc.setViewportView(table);*/
		
		JLabel lblNewLabel_1 = new JLabel("ENTER TOCKEN NUMBER");
		lblNewLabel_1.setFont(new Font("MS PGothic", Font.BOLD, 15));
		lblNewLabel_1.setBounds(237, 86, 213, 25);
		panel.add(lblNewLabel_1);
		
		tockenentry = new JTextField();
		tockenentry.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tockenentry.setBounds(237, 125, 191, 32);
		panel.add(tockenentry);
		tockenentry.setColumns(10);
		
		JButton gotoentrysolution = new JButton("search and open");
		gotoentrysolution.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				entryofSolution entryofSolution = new entryofSolution(String.valueOf(tockenentry.getText()));
				entryofSolution.setVisible(true);
				dispose();
			}

		});
		gotoentrysolution.setFont(new Font("MS PGothic", Font.BOLD, 14));
		gotoentrysolution.setBounds(261, 181, 143, 32);
		panel.add(gotoentrysolution);
		
		
		JButton EXIT = new JButton("EXIT");
		EXIT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				System.exit(ABORT);
			}
		});
		EXIT.setFont(new Font("MS PGothic", Font.BOLD, 14));
		EXIT.setBounds(261, 223, 143, 32);
		panel.add(EXIT);
	}
}

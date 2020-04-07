package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTable;

public class Menu_Authen {

	private JFrame frmAuthentification;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu_Authen window = new Menu_Authen();
					window.frmAuthentification.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Menu_Authen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAuthentification = new JFrame();
		frmAuthentification.getContentPane().setBackground(Color.CYAN);
		frmAuthentification.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 11));
		frmAuthentification.setForeground(Color.WHITE);
		frmAuthentification.getContentPane().setForeground(Color.WHITE);
		frmAuthentification.setTitle("AUTHENTIFICATION");
		frmAuthentification.setBounds(100, 100, 450, 300);
		frmAuthentification.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAuthentification.getContentPane().setLayout(null);
		
		JLabel lblIdentifiant = new JLabel("IDENTIFIANT");
		lblIdentifiant.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblIdentifiant.setBounds(52, 23, 159, 26);
		frmAuthentification.getContentPane().add(lblIdentifiant);
		
		table = new JTable();
		table.setBounds(52, 163, 266, 37);
		frmAuthentification.getContentPane().add(table);
		
		table_1 = new JTable();
		table_1.setForeground(Color.GREEN);
		table_1.setBounds(52, 60, 266, 37);
		frmAuthentification.getContentPane().add(table_1);
		
		JLabel lblMdp = new JLabel("MDP");
		lblMdp.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 16));
		lblMdp.setBounds(52, 131, 57, 21);
		frmAuthentification.getContentPane().add(lblMdp);
	}
}

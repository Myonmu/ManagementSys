package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;

public class Quota {

	private JFrame frmQuota;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Quota window = new Quota();
					window.frmQuota.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Quota() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmQuota = new JFrame();
		frmQuota.getContentPane().setBackground(Color.GRAY);
		frmQuota.setTitle("Quota");
		frmQuota.setBounds(100, 100, 450, 300);
		frmQuota.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmQuota.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(148, 99, 142, 23);
		frmQuota.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnDefinirQuota = new JButton("Definir quota");
		btnDefinirQuota.setBounds(148, 147, 142, 23);
		frmQuota.getContentPane().add(btnDefinirQuota);
		
		JLabel label = new JLabel("");
		label.setBounds(32, 36, 46, 14);
		frmQuota.getContentPane().add(label);
	}
}

package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;

public class Creer_étudiant extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Creer_étudiant frame = new Creer_étudiant();
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
	public Creer_étudiant() {
		setTitle("Creer_etudiant");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 686, 328);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(453, 56, 154, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNom = new JLabel("NOM:");
		lblNom.setBounds(404, 59, 57, 21);
		contentPane.add(lblNom);
		
		textField_1 = new JTextField();
		textField_1.setBounds(453, 113, 154, 27);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblPrenom = new JLabel("PRENOM:");
		lblPrenom.setBounds(386, 119, 75, 21);
		contentPane.add(lblPrenom);
		
		textField_2 = new JTextField();
		textField_2.setBounds(453, 172, 154, 27);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblTelephone = new JLabel("EMAIL:");
		lblTelephone.setBounds(397, 175, 82, 21);
		contentPane.add(lblTelephone);
		
		textField_3 = new JTextField();
		textField_3.setBounds(453, 223, 47, 27);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblGroupnum = new JLabel("GROUPNUM:");
		lblGroupnum.setBounds(370, 226, 91, 21);
		contentPane.add(lblGroupnum);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setBackground(Color.GREEN);
		btnAjouter.setBounds(41, 84, 89, 84);
		contentPane.add(btnAjouter);
	}

}

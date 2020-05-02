package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTable;

public class Créer_enseignant extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Créer_enseignant frame = new Créer_enseignant();
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
	public Créer_enseignant() {
		setTitle("Cr\u00E9er_enseignant");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 653, 318);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNom = new JLabel("NOM:");
		lblNom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNom.setBounds(301, 57, 46, 14);
		contentPane.add(lblNom);
		
		JLabel lblPrenom = new JLabel("PRENOM:");
		lblPrenom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrenom.setBounds(278, 115, 103, 14);
		contentPane.add(lblPrenom);
		
		JLabel lblTelephone = new JLabel("TELEPHONE:");
		lblTelephone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTelephone.setBounds(275, 183, 106, 14);
		contentPane.add(lblTelephone);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setBackground(Color.GREEN);
		btnAjouter.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAjouter.setBounds(52, 87, 89, 71);
		contentPane.add(btnAjouter);
		
		textField = new JTextField();
		textField.setBounds(357, 56, 176, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(357, 114, 176, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(357, 182, 176, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
	}
}

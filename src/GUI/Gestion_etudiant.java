package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Gestion_etudiant extends JFrame {

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
					Gestion_etudiant frame = new Gestion_etudiant();
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
	public Gestion_etudiant() {
		setTitle("Gestion_etudiant");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 709, 397);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(490, 47, 149, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNom = new JLabel("NOM:");
		lblNom.setBounds(446, 51, 59, 21);
		contentPane.add(lblNom);
		
		JLabel lblPrenom = new JLabel("PRENOM:");
		lblPrenom.setBounds(437, 106, 68, 21);
		contentPane.add(lblPrenom);
		
		textField_1 = new JTextField();
		textField_1.setBounds(490, 102, 149, 29);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblEmail = new JLabel("EMAIL:");
		lblEmail.setBounds(446, 155, 68, 21);
		contentPane.add(lblEmail);
		
		textField_2 = new JTextField();
		textField_2.setBounds(490, 151, 149, 29);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(490, 205, 52, 29);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblGroupnum = new JLabel("GROUPNUM:");
		lblGroupnum.setBounds(422, 209, 89, 21);
		contentPane.add(lblGroupnum);
		
		JButton btnListe = new JButton("Liste");
		btnListe.setBackground(Color.GREEN);
		btnListe.setBounds(55, 69, 115, 87);
		contentPane.add(btnListe);
		
		JButton btnNewButton = new JButton("Chercher/Modifier/Supprimer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Modifier_etudiant w = new Modifier_etudiant();
				w.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(58, 208, 244, 29);
		contentPane.add(btnNewButton);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Creer_étudiant w = new Creer_étudiant();
				w.setVisible(true);
				dispose();
			}
		});
		btnAjouter.setBounds(55, 264, 247, 29);
		contentPane.add(btnAjouter);
	}
}

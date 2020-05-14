
package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.EnseignantDAO;
import models.Enseignant;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Creer_enseignant extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblUsername;
	private JTextField textField_3;
	private JLabel lblTelephone_2;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Creer_enseignant frame = new Creer_enseignant();
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
	public Creer_enseignant() {
		setTitle("Cr\u00E9er_enseignant");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 653, 318);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNom = new JLabel("NOM:");
		lblNom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNom.setBounds(304, 57, 46, 14);
		contentPane.add(lblNom);
		
		JLabel lblPrenom = new JLabel("PRENOM:");
		lblPrenom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrenom.setBounds(278, 101, 103, 14);
		contentPane.add(lblPrenom);
		
		JLabel lblTelephone = new JLabel("TELEPHONE:");
		lblTelephone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTelephone.setBounds(257, 147, 106, 14);
		contentPane.add(lblTelephone);
		
		textField = new JTextField();
		textField.setBounds(357, 56, 176, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(357, 100, 176, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(357, 146, 176, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		lblUsername = new JLabel("USERNAME:");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsername.setBounds(257, 187, 106, 14);
		contentPane.add(lblUsername);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(357, 186, 176, 20);
		contentPane.add(textField_3);
		
		lblTelephone_2 = new JLabel("PASSWORD:");
		lblTelephone_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTelephone_2.setBounds(257, 229, 106, 14);
		contentPane.add(lblTelephone_2);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(357, 228, 176, 20);
		contentPane.add(textField_4);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EnseignantDAO dao = new EnseignantDAO();
				
				int res = dao.add(new Enseignant(textField_3.getText(), 
									   textField_4.getText(), 
									   
									   textField.getText(), 
									   
									   textField_1.getText(),
									   
									   textField_2.getText()));
				
				if(res==1) {

					JOptionPane.showMessageDialog(contentPane, res + " enseignant ajoute");
					dispose();
					Gestion_enseignant g = new Gestion_enseignant();
				}else {
					JOptionPane.showMessageDialog(contentPane, "ERREUR, Verifiez vos champs d'entree");
				}
			}
		});
		btnAjouter.setBackground(Color.GREEN);
		btnAjouter.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAjouter.setBounds(52, 87, 89, 71);
		contentPane.add(btnAjouter);
	}

}


package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.EnseignantDAO;
import models.Enseignant;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Modifier_enseigant extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Enseignant e = new Enseignant();
					Modifier_enseigant frame = new Modifier_enseigant(e);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param enseignant 
	 */
	public Modifier_enseigant(Enseignant enseignant) {
		setTitle("Modif/supp_ensei");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 675, 372);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblVeuillezEntrerLes = new JLabel("Veuillez entrer les modifications souhait\u00E9es");
		lblVeuillezEntrerLes.setForeground(Color.RED);
		lblVeuillezEntrerLes.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblVeuillezEntrerLes.setBounds(155, 28, 369, 14);
		contentPane.add(lblVeuillezEntrerLes);
		
		JLabel lblNom = new JLabel("Nom:");
		lblNom.setBounds(214, 109, 46, 14);
		contentPane.add(lblNom);
		
		textField = new JTextField();
		textField.setBounds(256, 106, 178, 20);
		textField.setText(enseignant.getNom());
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(256, 150, 178, 20);
		textField_1.setText(enseignant.getPrenom());
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblPrnom = new JLabel("Pr\u00E9nom:");
		lblPrnom.setBounds(200, 153, 63, 14);
		contentPane.add(lblPrnom);
		
		textField_2 = new JTextField();
		textField_2.setBounds(256, 188, 178, 20);
		textField_2.setText(enseignant.getTel());
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblTlphone = new JLabel("T\u00E9l\u00E9phone:");
		lblTlphone.setBounds(189, 191, 71, 14);
		contentPane.add(lblTlphone);
		
		textField_3 = new JTextField();
		textField_3.setBounds(256, 268, 178, 20);
		textField_3.setText(enseignant.getPassword());
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblIdentifiant = new JLabel("Password:");
		lblIdentifiant.setBounds(189, 271, 71, 14);
		contentPane.add(lblIdentifiant);
		
		textField_4 = new JTextField();
		textField_4.setBounds(256, 228, 178, 20);
		textField_4.setText(enseignant.getUsername());
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(189, 231, 63, 14);
		contentPane.add(lblUsername);
		
		JButton btnNewButton = new JButton("Confirmer_modif");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EnseignantDAO dao = new EnseignantDAO();
				
				int res = dao.modify(new Enseignant(enseignant.getID(),
										  textField_4.getText(), 
										  textField_3.getText(), 
										  textField.getText(), 
										  textField_1.getText(), 
										  textField_2.getText()));
				
				JOptionPane.showMessageDialog(contentPane, res + " enseignant modifi�?");
			}
		});
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.setBounds(464, 149, 169, 96);
		contentPane.add(btnNewButton);
		
		JButton btnSupprimerenseignant = new JButton("Supprimer_enseignant");
		btnSupprimerenseignant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EnseignantDAO dao = new EnseignantDAO();
				int res = 0;
				int n = JOptionPane.showConfirmDialog(contentPane, 
				"Voulez vous supprimer l'enseignant " + enseignant.getNom() + " ?","Attention ",JOptionPane.YES_NO_OPTION);
				
				if(n == JOptionPane.YES_OPTION) {
					res = dao.delete(enseignant);
					
				}else if(n == JOptionPane.NO_OPTION){
					
				}
				
				if(res == 1) {

					JOptionPane.showMessageDialog(contentPane, res + " Enseignant supprim?");
					
				}
			}
		});
		btnSupprimerenseignant.setBackground(Color.RED);
		btnSupprimerenseignant.setBounds(10, 150, 169, 98);
		contentPane.add(btnSupprimerenseignant);
	}

}

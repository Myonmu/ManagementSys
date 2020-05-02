package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;

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
					Modifier_enseigant frame = new Modifier_enseigant();
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
	public Modifier_enseigant() {
		setTitle("Modif/supp_ensei");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(256, 150, 178, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblPrnom = new JLabel("Pr\u00E9nom:");
		lblPrnom.setBounds(200, 153, 63, 14);
		contentPane.add(lblPrnom);
		
		textField_2 = new JTextField();
		textField_2.setBounds(256, 188, 178, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblTlphone = new JLabel("T\u00E9l\u00E9phone:");
		lblTlphone.setBounds(189, 191, 71, 14);
		contentPane.add(lblTlphone);
		
		textField_3 = new JTextField();
		textField_3.setBounds(256, 268, 178, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblIdentifiant = new JLabel("Password:");
		lblIdentifiant.setBounds(189, 271, 71, 14);
		contentPane.add(lblIdentifiant);
		
		textField_4 = new JTextField();
		textField_4.setBounds(256, 228, 178, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(189, 231, 63, 14);
		contentPane.add(lblUsername);
		
		JButton btnNewButton = new JButton("Confirmer_modif");
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.setBounds(464, 149, 169, 96);
		contentPane.add(btnNewButton);
		
		JButton btnSupprimerenseignant = new JButton("Supprimer_enseignant");
		btnSupprimerenseignant.setBackground(Color.RED);
		btnSupprimerenseignant.setBounds(10, 150, 169, 98);
		contentPane.add(btnSupprimerenseignant);
	}

}

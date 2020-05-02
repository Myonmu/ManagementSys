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

public class Modifier_etudiant extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Modifier_etudiant frame = new Modifier_etudiant();
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
	public Modifier_etudiant() {
		setTitle("modif_supp_etudiant");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 699, 404);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(342, 50, 130, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNom = new JLabel("NOM:");
		lblNom.setBounds(286, 53, 46, 14);
		contentPane.add(lblNom);
		
		textField_1 = new JTextField();
		textField_1.setBounds(342, 95, 130, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblPrenom = new JLabel("PRENOM:");
		lblPrenom.setBounds(272, 98, 72, 14);
		contentPane.add(lblPrenom);
		
		textField_2 = new JTextField();
		textField_2.setBounds(342, 137, 130, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblEmail = new JLabel("EMAIL:");
		lblEmail.setBounds(286, 140, 74, 14);
		contentPane.add(lblEmail);
		
		textField_3 = new JTextField();
		textField_3.setBounds(342, 185, 130, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblUsername = new JLabel("USERNAME:");
		lblUsername.setBounds(260, 188, 84, 14);
		contentPane.add(lblUsername);
		
		textField_4 = new JTextField();
		textField_4.setBounds(342, 232, 130, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblPassword = new JLabel("PASSWORD:");
		lblPassword.setBounds(255, 235, 89, 14);
		contentPane.add(lblPassword);
		
		textField_5 = new JTextField();
		textField_5.setBounds(342, 276, 46, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblGroupnum = new JLabel("GROUPNUM:");
		lblGroupnum.setBounds(255, 279, 89, 14);
		contentPane.add(lblGroupnum);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.setBackground(Color.GREEN);
		btnModifier.setBounds(28, 137, 122, 82);
		contentPane.add(btnModifier);
		
		JButton btnNewButton = new JButton("Supprimer");
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setBounds(540, 137, 122, 82);
		contentPane.add(btnNewButton);
	}

}

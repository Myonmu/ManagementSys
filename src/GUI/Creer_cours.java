package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class Creer_cours extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Creer_cours frame = new Creer_cours();
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
	public Creer_cours() {
		setTitle("Cours");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 417);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCrerCours = new JLabel("Cr\u00E9er cours");
		lblCrerCours.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCrerCours.setBounds(296, 33, 161, 25);
		contentPane.add(lblCrerCours);
		
		textField = new JTextField();
		textField.setBounds(268, 82, 122, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(268, 132, 122, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNomDuCours = new JLabel("Nom du cours");
		lblNomDuCours.setBounds(167, 84, 80, 17);
		contentPane.add(lblNomDuCours);
		
		JLabel lblMasseHoraire = new JLabel("Masse horaire");
		lblMasseHoraire.setBounds(167, 135, 80, 14);
		contentPane.add(lblMasseHoraire);
		
		JButton btnTerminer = new JButton("Terminer");
		btnTerminer.setBounds(520, 37, 101, 31);
		contentPane.add(btnTerminer);
		
		JButton btnNewButton = new JButton("Confirmer");
		btnNewButton.setBounds(520, 82, 101, 70);
		contentPane.add(btnNewButton);
		
		textField_2 = new JTextField();
		textField_2.setBounds(535, 185, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(535, 216, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(535, 247, 86, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(535, 278, 86, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(535, 309, 86, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnAjouterAuPlanning = new JButton("Ajouter au planning");
		btnAjouterAuPlanning.setBounds(494, 340, 148, 23);
		contentPane.add(btnAjouterAuPlanning);
		
		JButton btnPlanning = new JButton("Planning");
		btnPlanning.setBackground(Color.GREEN);
		btnPlanning.setForeground(Color.BLACK);
		btnPlanning.setBounds(49, 184, 89, 56);
		contentPane.add(btnPlanning);
		
		textField_7 = new JTextField();
		textField_7.setBounds(59, 247, 52, 20);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblGroupe = new JLabel("Groupe");
		lblGroupe.setBounds(10, 250, 52, 17);
		contentPane.add(lblGroupe);
	}

}

package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Modif_supp extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Modif_supp frame = new Modif_supp();
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
	public Modif_supp() {
		setTitle("Cours");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 657, 370);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblModifiersupprimer = new JLabel("Modifier/Supprimer");
		lblModifiersupprimer.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblModifiersupprimer.setForeground(Color.RED);
		lblModifiersupprimer.setBounds(231, 11, 193, 22);
		contentPane.add(lblModifiersupprimer);
		
		JLabel lblGroupe = new JLabel("Groupe");
		lblGroupe.setBounds(42, 50, 46, 17);
		contentPane.add(lblGroupe);
		
		textField = new JTextField();
		textField.setBounds(98, 48, 54, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnPlanning = new JButton("Planning");
		btnPlanning.setBackground(Color.GREEN);
		btnPlanning.setBounds(63, 100, 89, 58);
		contentPane.add(btnPlanning);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBounds(185, 255, 89, 23);
		contentPane.add(btnSupprimer);
		
		JButton btnConfirmer = new JButton("Confirmer");
		btnConfirmer.setBounds(354, 255, 89, 23);
		contentPane.add(btnConfirmer);
		
		textField_1 = new JTextField();
		textField_1.setBounds(371, 154, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(371, 119, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(371, 88, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(371, 185, 86, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(371, 216, 86, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(354, 48, 119, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblNomDuCours = new JLabel("Nom du cours");
		lblNomDuCours.setBounds(427, 23, 86, 14);
		contentPane.add(lblNomDuCours);
		
		JLabel lblNewLabel = new JLabel("jour");
		lblNewLabel.setBounds(334, 91, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblA = new JLabel("a");
		lblA.setBounds(346, 122, 15, 14);
		contentPane.add(lblA);
		
		JLabel lblType = new JLabel("Type");
		lblType.setBounds(332, 157, 29, 14);
		contentPane.add(lblType);
		
		JLabel lblDure = new JLabel("Dur\u00E9e");
		lblDure.setBounds(332, 188, 29, 14);
		contentPane.add(lblDure);
		
		JLabel lblEnseignant = new JLabel("Enseignant");
		lblEnseignant.setBounds(311, 216, 67, 14);
		contentPane.add(lblEnseignant);
	}

}

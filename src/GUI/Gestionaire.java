package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Gestionaire extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gestionaire frame = new Gestionaire();
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
	public Gestionaire() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 517, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGestionnaire = new JLabel("GESTIONNAIRE");
		lblGestionnaire.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblGestionnaire.setForeground(Color.RED);
		lblGestionnaire.setBounds(178, 11, 160, 34);
		contentPane.add(lblGestionnaire);
		
		JButton btnCrerUnCours = new JButton("Cr\u00E9er un cours");
		btnCrerUnCours.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Creer_cours g = new Creer_cours();
				g.setVisible(true);	
				dispose();
			}
		});
		btnCrerUnCours.setBounds(10, 62, 140, 23);
		contentPane.add(btnCrerUnCours);
		
		JButton btnModifiersupp = new JButton("Modifier/Supp");
		btnModifiersupp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Modif_supp h = new Modif_supp();
				h.setVisible(true);
				dispose();
			}
		});
		btnModifiersupp.setBounds(10, 96, 140, 23);
		contentPane.add(btnModifiersupp);
		
		JButton btnGestionDenseignant = new JButton("Gestion d'enseignant");
		btnGestionDenseignant.setBounds(10, 130, 140, 42);
		contentPane.add(btnGestionDenseignant);
		
		JButton btnGestionDtudiant = new JButton("Gestion d'\u00E9tudiant");
		btnGestionDtudiant.setBounds(10, 183, 140, 42);
		contentPane.add(btnGestionDtudiant);
		
		JButton btnCrerUnType = new JButton("Cr\u00E9er un type d'absence");
		btnCrerUnType.setBounds(324, 78, 167, 41);
		contentPane.add(btnCrerUnType);
		
		JButton btnTraiterUnJustificatif = new JButton("Traiter un justificatif");
		btnTraiterUnJustificatif.setBounds(324, 130, 167, 42);
		contentPane.add(btnTraiterUnJustificatif);
		
		JButton btnDfinirQuota = new JButton("D\u00E9finir quota");
		btnDfinirQuota.setBounds(324, 183, 167, 42);
		contentPane.add(btnDfinirQuota);
	}

}

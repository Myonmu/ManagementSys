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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		
		JButton btnCrerUnCours = new JButton("Gestion cours");
		btnCrerUnCours.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Modif_supp g = new Modif_supp();
				g.setVisible(true);	
			}
			
		});
		btnCrerUnCours.setBounds(10, 77, 140, 42);
		contentPane.add(btnCrerUnCours);
		
		
		

		JButton btnGestionDenseignant = new JButton("Gestion d'enseignant");
		btnGestionDenseignant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Gestion_enseignant n = new Gestion_enseignant();
				n.setVisible(true);
				
				
			}
		});
		btnGestionDenseignant.setBounds(10, 130, 140, 42);
		contentPane.add(btnGestionDenseignant);
		
		JButton btnGestionDtudiant = new JButton("Gestion d'\u00E9tudiant");
		btnGestionDtudiant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Gestion_etudiant n = new Gestion_etudiant();
				n.setVisible(true);
				
			}
		});
		btnGestionDtudiant.setBounds(10, 183, 140, 42);
		contentPane.add(btnGestionDtudiant);
		
		JButton btnCrerUnType = new JButton("Cr\u00E9er un type d'absence");
		btnCrerUnType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Typeabs w = new Typeabs();
				w.setVisible(true);
				
			}
		});
		btnCrerUnType.setBounds(324, 96, 167, 23);
		contentPane.add(btnCrerUnType);
		
		JButton btnTraiterUnJustificatif = new JButton("Traiter des absences");
		btnTraiterUnJustificatif.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AbsenceGUI absGUI=new AbsenceGUI() ;
				absGUI.readEtuAbsence(0);
			}
			
		});
		btnTraiterUnJustificatif.setBounds(324, 130, 167, 42);
		contentPane.add(btnTraiterUnJustificatif);
		
		JButton btnDfinirQuota = new JButton("D\u00E9finir quota");
		btnDfinirQuota.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				QuotaGUI qt=new QuotaGUI();
				qt.quota();
			}
			
		});
		btnDfinirQuota.setBounds(324, 183, 167, 42);
		contentPane.add(btnDfinirQuota);
		
		JButton btnGestionPlanning = new JButton("Gestion planning");
		btnGestionPlanning.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				PlanningGUI plGUI=new PlanningGUI();
				plGUI.readAllPlanning();
			}
			
		});
		btnGestionPlanning.setBounds(324, 62, 167, 23);
		contentPane.add(btnGestionPlanning);
		setVisible(true);
	}
}

package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;

public class Menu_etudiant {

	private JFrame frmMenuEtudiant;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu_etudiant window = new Menu_etudiant();
					window.frmMenuEtudiant.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Menu_etudiant() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMenuEtudiant = new JFrame();
		frmMenuEtudiant.getContentPane().setBackground(Color.DARK_GRAY);
		frmMenuEtudiant.setTitle("Menu etudiant");
		frmMenuEtudiant.setBounds(100, 100, 450, 300);
		frmMenuEtudiant.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMenuEtudiant.getContentPane().setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 141, 424, 2);
		frmMenuEtudiant.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(204, 0, 30, 143);
		frmMenuEtudiant.getContentPane().add(separator_1);
		
		JLabel lblDeposerJustificatif = new JLabel("Deposer justificatif");
		lblDeposerJustificatif.setForeground(Color.WHITE);
		lblDeposerJustificatif.setBackground(Color.WHITE);
		lblDeposerJustificatif.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 15));
		lblDeposerJustificatif.setBounds(22, 14, 153, 20);
		frmMenuEtudiant.getContentPane().add(lblDeposerJustificatif);
		
		JLabel lblConsulterAbsences = new JLabel("Consulter absences");
		lblConsulterAbsences.setForeground(Color.WHITE);
		lblConsulterAbsences.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 15));
		lblConsulterAbsences.setBounds(244, 11, 153, 27);
		frmMenuEtudiant.getContentPane().add(lblConsulterAbsences);
		
		JLabel lblConsulterPlanning = new JLabel("Consulter Planning");
		lblConsulterPlanning.setForeground(Color.WHITE);
		lblConsulterPlanning.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 15));
		lblConsulterPlanning.setBounds(143, 154, 143, 27);
		frmMenuEtudiant.getContentPane().add(lblConsulterPlanning);
		
		JButton btnAbsenceAnticipe = new JButton("absence anticip\u00E9e");
		btnAbsenceAnticipe.setBackground(Color.WHITE);
		btnAbsenceAnticipe.setBounds(32, 45, 153, 23);
		frmMenuEtudiant.getContentPane().add(btnAbsenceAnticipe);
		
		JButton btnAbsenceEffective = new JButton("absence effective");
		btnAbsenceEffective.setBackground(Color.WHITE);
		btnAbsenceEffective.setBounds(32, 79, 153, 23);
		frmMenuEtudiant.getContentPane().add(btnAbsenceEffective);
		
		JButton btnAbsencesNonJustifies = new JButton("absences non justifi\u00E9es");
		btnAbsencesNonJustifies.setBackground(Color.RED);
		btnAbsencesNonJustifies.setBounds(229, 49, 195, 20);
		frmMenuEtudiant.getContentPane().add(btnAbsencesNonJustifies);
		
		JButton btnListeDesCours = new JButton("Liste des cours");
		btnListeDesCours.setBackground(Color.GREEN);
		btnListeDesCours.setBounds(153, 192, 143, 23);
		frmMenuEtudiant.getContentPane().add(btnListeDesCours);
	}
}

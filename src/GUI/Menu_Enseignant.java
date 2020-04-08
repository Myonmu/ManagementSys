package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;

public class Menu_Enseignant {

	private JFrame frmMenuEnseignant;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu_Enseignant window = new Menu_Enseignant();
					window.frmMenuEnseignant.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Menu_Enseignant() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMenuEnseignant = new JFrame();
		frmMenuEnseignant.getContentPane().setBackground(Color.CYAN);
		frmMenuEnseignant.setTitle("Menu Enseignant");
		frmMenuEnseignant.setBounds(100, 100, 450, 300);
		frmMenuEnseignant.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMenuEnseignant.getContentPane().setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 142, 434, 2);
		frmMenuEnseignant.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(210, 0, 2, 139);
		frmMenuEnseignant.getContentPane().add(separator_1);
		
		JLabel lblFaireLappel = new JLabel("Faire l'appel");
		lblFaireLappel.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 15));
		lblFaireLappel.setBounds(41, 11, 133, 37);
		frmMenuEnseignant.getContentPane().add(lblFaireLappel);
		
		JLabel lblConsulterPlanning = new JLabel("Consulter planning");
		lblConsulterPlanning.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 15));
		lblConsulterPlanning.setBounds(248, 17, 157, 25);
		frmMenuEnseignant.getContentPane().add(lblConsulterPlanning);
		
		JLabel lblConsulterAbsences = new JLabel("Consulter absences");
		lblConsulterAbsences.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 15));
		lblConsulterAbsences.setBounds(142, 149, 149, 20);
		frmMenuEnseignant.getContentPane().add(lblConsulterAbsences);
		
		JButton btnMajAbsences = new JButton("Maj absences");
		btnMajAbsences.setBounds(26, 59, 148, 23);
		frmMenuEnseignant.getContentPane().add(btnMajAbsences);
		
		JButton btnChoixtudiant = new JButton("Choix \u00E9tudiant");
		btnChoixtudiant.setBounds(126, 191, 162, 23);
		frmMenuEnseignant.getContentPane().add(btnChoixtudiant);
		
		JButton btnPlanning = new JButton("Planning");
		btnPlanning.setBounds(277, 59, 89, 23);
		frmMenuEnseignant.getContentPane().add(btnPlanning);
		
		frmMenuEnseignant.show();
	}
}

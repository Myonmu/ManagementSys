package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DAO.CoursDAO;
import DAO.EnseignantDAO;
import models.Cours;
import models.Enseignant;
import models.Etudiant;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Modif_supp extends JFrame {

	private JPanel contentPane;
	private JTable table;

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
		
		table = new JTable();

		Object header[] = {"Nom", "Masse hotaire", "ID_Enseignant"};

		DefaultTableModel model = new DefaultTableModel(header, 0);
		
		model.addRow(header);
		
		CoursDAO cours_dao = new CoursDAO();
		
		ArrayList<Cours> liste_cours = cours_dao.readAll();
		
		for(int i = 0; i < liste_cours.size(); i++) {
			Object[] table_cours = 
				{
					liste_cours.get(i).getNom(), 
					liste_cours.get(i).getMasse(),
					liste_cours.get(i).getEnsPar(),
				};
			model.addRow(table_cours);
		}
		
		table.setModel(model);
		table.setBounds(31, 40, 267, 213);
		contentPane.add(table);
		
		JLabel lblModifiersupprimer = new JLabel("Modifier/Supprimer");
		lblModifiersupprimer.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblModifiersupprimer.setForeground(Color.RED);
		lblModifiersupprimer.setBounds(72, 7, 193, 22);
		contentPane.add(lblModifiersupprimer);
		
		JButton btnConfirmer = new JButton("Modifier/supprimer");
		btnConfirmer.setBackground(Color.RED);
		btnConfirmer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cours c = new Cours();
				c = liste_cours.get(table.getSelectedRow()-1);
				conf_modif_supp w = new conf_modif_supp(c);
				w.setVisible(true);
			}
		});
		btnConfirmer.setBounds(95, 264, 154, 55);
		contentPane.add(btnConfirmer);
		
		JButton btnAjouterUnEnseignant = new JButton("Ajouter un cours");
		btnAjouterUnEnseignant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Creer_cours n = new Creer_cours();
				n.setVisible(true);
			}
		});
		btnAjouterUnEnseignant.setBackground(Color.GREEN);
		btnAjouterUnEnseignant.setBounds(363, 121, 160, 55);
		contentPane.add(btnAjouterUnEnseignant);
		
	
		
	}
}

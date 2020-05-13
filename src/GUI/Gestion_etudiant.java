package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DAO.EnseignantDAO;
import DAO.EtudiantDAO;
import models.Enseignant;
import models.Etudiant;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Gestion_etudiant extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gestion_etudiant frame = new Gestion_etudiant();
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
	public Gestion_etudiant() {
		setTitle("Gestion_etudiant");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 709, 397);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Creer_etudiant w = new Creer_etudiant();
				w.setVisible(true);

			}
		});
		btnAjouter.setBounds(436, 85, 247, 29);
		contentPane.add(btnAjouter);
		
		table = new JTable();

		Object header[] = {"Nom", "Prenom", "email","gr_num"};

		DefaultTableModel model = new DefaultTableModel(header, 0);
		
		model.addRow(header);
		
		EtudiantDAO etu_dao = new EtudiantDAO();
		
		ArrayList<Etudiant> liste_etudiant = etu_dao.readAll();
		
		for(int i = 0; i < liste_etudiant.size(); i++) {
			Object[] table_etudiant = 
				{
					liste_etudiant.get(i).getNom(), 
					liste_etudiant.get(i).getPrenom(),
					liste_etudiant.get(i).getEmail(),
					liste_etudiant.get(i).getGr()
				};
			model.addRow(table_etudiant);
		}
		
		table.setModel(model);
		table.setBounds(29, 26, 353, 298);
		contentPane.add(table);
		
		JButton btnNewButton = new JButton("Modifier/Supprimer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Etudiant etu = new Etudiant();
				etu = liste_etudiant.get(table.getSelectedRow()-1);
				Modifier_etudiant w = new Modifier_etudiant(etu);
				w.setVisible(true);

			}
		});
		btnNewButton.setBounds(436, 29, 244, 29);
		contentPane.add(btnNewButton);
		
	}
}

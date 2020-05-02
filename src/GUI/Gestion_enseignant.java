package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DAO.EnseignantDAO;
import models.Enseignant;

public class Gestion_enseignant extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gestion_enseignant frame = new Gestion_enseignant();
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
	@SuppressWarnings("serial")
	public Gestion_enseignant() {
		setTitle("Gestion-Enseignant");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 647, 363);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNom = new JLabel("NOM:");
		lblNom.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNom.setBounds(40, 30, 46, 14);
		contentPane.add(lblNom);
		
		JLabel lblPrnom = new JLabel("Pr\u00E9nom:");
		lblPrnom.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPrnom.setBounds(118, 30, 63, 14);
		contentPane.add(lblPrnom);
		
		JLabel lblTelephone = new JLabel("Telephone:");
		lblTelephone.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTelephone.setBounds(206, 30, 91, 14);
		contentPane.add(lblTelephone);
		
		JButton btnNewButton_1 = new JButton("Ajouter");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Créer_enseignant w = new Créer_enseignant();
				w.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setBounds(377, 102, 244, 23);
		contentPane.add(btnNewButton_1);
		
		table = new JTable();

		Object header[] = {"Nom", "Prenom", "telephone"};

		DefaultTableModel model = new DefaultTableModel(header, 0);
		
		EnseignantDAO ens_dao = new EnseignantDAO();
		
		ArrayList<Enseignant> liste_enseignant = ens_dao.readAll();
		
		for(int i = 0; i < liste_enseignant.size(); i++) {
			Object[] table_enseignant = 
				{
					liste_enseignant.get(i).getNom(), 
					liste_enseignant.get(i).getPrenom(),
					liste_enseignant.get(i).getTel(),
				};
			model.addRow(table_enseignant);
		}
		
		table.setModel(model);
		table.setBounds(29, 55, 267, 258);
		contentPane.add(table);
		
		JButton btnChercher = new JButton("Modifier/Supprimer");
		btnChercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Modifier_enseigant w = new Modifier_enseigant(liste_enseignant.get(table.getSelectedRow()));
				w.setVisible(true);
				dispose();
			}
		});
		btnChercher.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnChercher.setBounds(377, 26, 244, 23);
		contentPane.add(btnChercher);

	}
}

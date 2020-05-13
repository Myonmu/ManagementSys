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

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Creer_cours extends JDialog {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	
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
		setModal(true);
		setTitle("Cours");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		
		table = new JTable();

		Object header[] = {"Nom", "Prenom", "telephone"};

		DefaultTableModel model = new DefaultTableModel(header, 0);
		
		model.addRow(header);
		
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
		table.setBounds(109, 182, 512, 168);
		contentPane.add(table);
		
		JButton btnAjouterAuPlanning = new JButton("Creer");
		btnAjouterAuPlanning.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!textField.getText().isEmpty() && !textField_1.getText().isEmpty()) {
					
					try {
						CoursDAO c = new CoursDAO();
						int res = c.add(new Cours(textField.getText(), 
												  Integer.valueOf(textField_1.getText()), 
												  liste_enseignant.get(table.getSelectedColumn()-1).getID()));
						
						if(res == 1) {
							JOptionPane.showMessageDialog(contentPane, res + " Cour cree");
						}
					} catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(contentPane, "La masse horaire doit etre un entier");
					} catch (ArrayIndexOutOfBoundsException e) {
						JOptionPane.showMessageDialog(contentPane, "Aucun enseignant selectionne");
					}
					
				}else {
					JOptionPane.showMessageDialog(contentPane, "Veuillez remplir tout les champs");
				}
			}
		});
		btnAjouterAuPlanning.setBounds(473, 106, 148, 46);
		contentPane.add(btnAjouterAuPlanning);
	}

}

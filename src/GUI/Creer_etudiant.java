package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.EnseignantDAO;
import DAO.EtudiantDAO;
import DAO.GroupeDAO;
import models.Enseignant;
import models.Etudiant;
import models.Groupe;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class Creer_etudiant extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Creer_etudiant frame = new Creer_etudiant();
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
	public Creer_etudiant() {
		setTitle("Creer_etudiant");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 374, 328);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(116, 48, 154, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNom = new JLabel("NOM:");
		lblNom.setBounds(44, 51, 57, 21);
		contentPane.add(lblNom);
		
		textField_1 = new JTextField();
		textField_1.setBounds(116, 92, 154, 27);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblPrenom = new JLabel("PRENOM:");
		lblPrenom.setBounds(44, 95, 75, 21);
		contentPane.add(lblPrenom);
		
		textField_2 = new JTextField();
		textField_2.setBounds(116, 148, 154, 27);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblTelephone = new JLabel("EMAIL:");
		lblTelephone.setBounds(44, 151, 82, 21);
		contentPane.add(lblTelephone);
		
		JLabel lblGroupnum = new JLabel("GROUPNUM:");
		lblGroupnum.setBounds(44, 202, 91, 21);
		contentPane.add(lblGroupnum);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(116, 195, 152, 27);
		GroupeDAO dao = new GroupeDAO();
		ArrayList<Groupe>liste = new ArrayList<Groupe>();
		liste = dao.readGrList();
		String[] liste_groupe = new String[liste.size()];
		int[] liste_id = new int[liste.size()];
		
		for(int i = 0; i < liste.size(); i++) {
			liste_groupe[i] = "Num : " + liste.get(i).getNum() + 
						   " - Capacity : " + liste.get(i).getCap();
			
			liste_id[i] = liste.get(i).getID();
		}
		comboBox.setModel(new DefaultComboBoxModel(liste_groupe));
		contentPane.add(comboBox);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EtudiantDAO dao = new EtudiantDAO();
				Etudiant temp=new Etudiant(textField.getText(),textField_1.getText(),textField_2.getText(),
						liste_id[comboBox.getSelectedIndex()]);
				temp.randomizer();
				int res = dao.add(temp);
				
				if(res==1) {

					JOptionPane.showMessageDialog(contentPane, res + " etudiant ajoute");
					dispose();

					
					Gestion_etudiant g = new Gestion_etudiant();
				}else {
					JOptionPane.showMessageDialog(contentPane, "ERREUR, Verifiez vos champs d'entree");
				}
				
			}
		});
		btnAjouter.setBackground(Color.GREEN);
		btnAjouter.setBounds(44, 234, 226, 27);
		contentPane.add(btnAjouter);
		
		JLabel lblCreationNouvelEtudiant = new JLabel("Creation nouvel etudiant");
		lblCreationNouvelEtudiant.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCreationNouvelEtudiant.setBounds(83, 23, 197, 14);
		contentPane.add(lblCreationNouvelEtudiant);
	}

}


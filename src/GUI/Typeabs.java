package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.AbsTypeDAO;
import models.AbsenceType;
import models.Enseignant;
import models.Etudiant;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Typeabs extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Typeabs frame = new Typeabs();
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
	public Typeabs() {
		setTitle("Type_abscence");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 681, 344);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(207, 39, 291, 59);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblDescription = new JLabel("Description:");
		lblDescription.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDescription.setBounds(94, 55, 140, 23);
		contentPane.add(lblDescription);
		
		
		JButton btnAjouterAbsence = new JButton("Ajouter");
		btnAjouterAbsence.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AbsTypeDAO dao= new AbsTypeDAO();
				int res = dao.add(new AbsenceType(
						0,
						textField.getText()
						)
						   
						);
	if(res==1) {
		JOptionPane.showMessageDialog(contentPane, res + "type absence ajoute");
		
		Gestion_etudiant g = new Gestion_etudiant();
	}else {
		JOptionPane.showMessageDialog(contentPane, "ERREUR, Verifiez vos champs d'entree");
	}
				
			}
		});
		btnAjouterAbsence.setBackground(Color.RED);
		btnAjouterAbsence.setForeground(Color.BLACK);
		btnAjouterAbsence.setBounds(444, 234, 146, 34);
		contentPane.add(btnAjouterAbsence);
	}
}

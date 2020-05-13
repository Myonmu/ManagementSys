package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.CoursDAO;
import DAO.EnseignantDAO;
import models.Cours;
import models.Enseignant;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class conf_modif_supp extends JFrame {

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
					Cours c = new Cours();
					conf_modif_supp frame = new conf_modif_supp(c);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param c 
	 */
	public conf_modif_supp(Cours c) {
		setTitle("conf_mod_supp");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 593, 320);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(230, 57, 131, 20);
		textField.setText(c.getNom());
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(230, 120, 131, 20);
		textField_1.setText(String.valueOf(c.getMasse()));
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(230, 191, 131, 20);
		textField_2.setText(String.valueOf(c.getEnsPar()));
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNom = new JLabel("Nom:");
		lblNom.setBounds(159, 63, 75, 14);
		contentPane.add(lblNom);
		
		JLabel lblMasseh = new JLabel("Masse_H:");
		lblMasseh.setBounds(159, 126, 75, 14);
		contentPane.add(lblMasseh);
		
		JLabel lblNom_1_1 = new JLabel("Ens_par:");
		lblNom_1_1.setBounds(159, 197, 75, 14);
		contentPane.add(lblNom_1_1);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CoursDAO dao = new CoursDAO();
				int res = 0;
				int n = JOptionPane.showConfirmDialog(contentPane, 
				"Voulez vous supprimer le cours " + c.getNom() + " ?","Attention ",JOptionPane.YES_NO_OPTION);
				
				if(n == JOptionPane.YES_OPTION) {
					res = dao.delete(c);
					
				}else if(n == JOptionPane.NO_OPTION){
					
				}
				
				if(res == 1) {
					JOptionPane.showMessageDialog(contentPane, res + " Cours supprimé");
					
				}
			}
		});
		btnSupprimer.setBackground(Color.RED);
		btnSupprimer.setBounds(20, 120, 89, 60);
		contentPane.add(btnSupprimer);
		
		JButton btnNewButton = new JButton("Conf_modif");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
CoursDAO dao = new CoursDAO();
				
				int res = dao.modify(new Cours(c.getID(),
										  textField.getText(), 
										  Integer.valueOf((textField_1.getText())), 
										  Integer.valueOf(textField_2.getText())
										  
						));
				
				JOptionPane.showMessageDialog(contentPane, res + " cours modifié!");
			}
		});
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.setBounds(424, 120, 89, 60);
		contentPane.add(btnNewButton);
	}
}

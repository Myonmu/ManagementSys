package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JTextField;

import DAO.UserDAO;
import models.User;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class Menu_Authen {

	protected static final String String = null;
	private JFrame frmAuthentification;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu_Authen window = new Menu_Authen();
					window.frmAuthentification.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Menu_Authen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAuthentification = new JFrame();
		frmAuthentification.getContentPane().setBackground(SystemColor.menu);
		frmAuthentification.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 11));
		frmAuthentification.setForeground(Color.WHITE);
		frmAuthentification.getContentPane().setForeground(Color.WHITE);
		frmAuthentification.setTitle("AUTHENTIFICATION");
		frmAuthentification.setBounds(100, 100, 450, 300);
		frmAuthentification.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAuthentification.getContentPane().setLayout(null);
		
		JLabel lblIdentifiant = new JLabel("IDENTIFIANT");
		lblIdentifiant.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblIdentifiant.setBounds(52, 57, 159, 26);
		frmAuthentification.getContentPane().add(lblIdentifiant);
		
		JLabel lblMdp = new JLabel("MDP");
		lblMdp.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 16));
		lblMdp.setBounds(52, 131, 57, 21);
		frmAuthentification.getContentPane().add(lblMdp);
		
		textField = new JTextField();
		textField.setBounds(52, 94, 311, 26);
		frmAuthentification.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(52, 156, 311, 26);
		frmAuthentification.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			
			
			//Logique de connexion
			public void actionPerformed(ActionEvent arg0) {
			//Cr閍tion d'un utilisateur standard avec les valeurs des textField 
			User user = new User(textField.getText(), textField_1.getText());
			
			//Appel de la m閠hode DAO pour recuperer un User
			UserDAO dao =new UserDAO();
			
			//R閟ultat de la requete; 
			int access = dao.login(user);
				switch (access)
				{
				case 1:
					EnseignantGUI ensGUI=new EnseignantGUI();
					ensGUI.enseignantMenu();
					frmAuthentification.dispose();
					JOptionPane.showMessageDialog(frmAuthentification, "Enseignant Connect�!");
					break;
				case 2:
					
					EtudiantGUI etuGUI=new EtudiantGUI();
					etuGUI.etudiantMenu();
					JOptionPane.showMessageDialog(null, "Etudiant Connect�!");
					frmAuthentification.dispose();
					break;
					 
					
				case 3: 
					
					Gestionaire m = new Gestionaire();
					frmAuthentification.dispose();
					JOptionPane.showMessageDialog(frmAuthentification, "Gestionnaire Connect�!");
					break;
				
				default:
					JOptionPane.showMessageDialog(frmAuthentification, "Invalid Username or Password");
				}
			}
		});
		btnLogin.setBounds(159, 210, 110, 26);
		frmAuthentification.getContentPane().add(btnLogin);
	}
}

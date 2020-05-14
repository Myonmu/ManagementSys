package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextField;

import DAO.ConstantsDAO;
import DAO.CoursDAO;
import models.Cours;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class quota {

	private JFrame frmQuota;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					quota window = new quota();
					window.frmQuota.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public quota() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmQuota = new JFrame();
		frmQuota.getContentPane().setBackground(Color.GRAY);
		frmQuota.setTitle("Quota");
		frmQuota.setBounds(100, 100, 450, 300);
		frmQuota.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmQuota.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(163, 131, 130, 20);
		frmQuota.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(43, 33, 115, 14);
		ConstantsDAO quota= new ConstantsDAO();
		lblNewLabel.setText("Le quota est :"+ quota.readQ());
		frmQuota.getContentPane().add(lblNewLabel);
		
		JButton btnDfinirQuota = new JButton("D\u00E9finir quota");
		btnDfinirQuota.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
ConstantsDAO dao = new ConstantsDAO();
				
				int res = dao.modifyQ( 
										  Integer.valueOf((textField.getText())
										  
										  
						));
				
				JOptionPane.showMessageDialog(frmQuota, res + " cours modifie!");
			}
		});
		btnDfinirQuota.setBounds(163, 179, 130, 23);
		frmQuota.getContentPane().add(btnDfinirQuota);
		
		
	}

}

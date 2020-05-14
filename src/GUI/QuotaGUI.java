package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import DAO.ConstantsDAO;
import DAO.CoursDAO;
import Other.Mail;
import models.Cours;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.awt.event.ActionEvent;
/**
 * 
 * @author Hippocrate
 *
 */
public class QuotaGUI extends JDialog{

	/**
	 * Everything about quota
	 */
	public void quota() {
		setModal(true);
		setSize(300,120);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("Quota");
		JPanel panel=new JPanel(new BorderLayout());
		
		
		ConstantsDAO cd=new ConstantsDAO();
		int quota=cd.readQ();
		String q=Integer.toString(quota);
		if(quota==-1) {
			q="PAS DE QUOTA";
		}
		JLabel desc=new JLabel("Quota Actuel: "+q);
		panel.add(desc,BorderLayout.NORTH);
		
		JTextField tf=new JTextField();
		tf.setText("Entrez un nouvel quota ici");
		tf.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				tf.setText("");
			}
		});
		JButton btn=new JButton("Modifier");
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(tf.getText()!="") {
					try{cd.modifyQ(Integer.parseInt(tf.getText()));
					}
					catch(NumberFormatException e1) {
						JOptionPane.showMessageDialog(null, "Hmmm...Ce n'est pas un nombre...");
					}
				}else {
					JOptionPane.showMessageDialog(null, "Hmmm...so empty...");
				}
				int quota=cd.readQ();
				String q=Integer.toString(quota);
				if(quota==-1) {
					q="PAS DE QUOTA";
				}
				desc.setText("Quota Actuel: "+q);
				remove(panel);
				add(panel);
				revalidate();
				repaint();
			}
			
		});
		JButton mailing=new JButton("Send Warning");
		mailing.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Mail m=new Mail();
				m.sendMultiWarning();
			}
			
		});
		panel.add(mailing,BorderLayout.CENTER);
		Box bx=Box.createHorizontalBox();
		bx.add(tf);
		bx.add(btn);
		panel.add(bx,BorderLayout.SOUTH);
		add(panel);
		setVisible(true);
		
	}

}

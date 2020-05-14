package GUI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import DAO.EtudiantDAO;
import DAO.PlanningDAO;
import DAO.SessionDAO;
import models.Etudiant;
import models.PlanningAff;
import models.Session;

/**
 * 
 * @author Hippocrate
 *
 */
public class SessionGUI extends JDialog {
	private static int selectedID=0;
	/**
	 * Reads every session
	 */
	public void readSession() {
		selectedID=0;
		setModal(true);
		setSize(250,300);
		setTitle("Session");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
		JPanel panel=new JPanel(new BorderLayout());
		Object[] tableHead= {"ID","NO.","Date debut"};
		DefaultTableModel model=new DefaultTableModel(tableHead,0);
		SessionDAO sessDAO=new SessionDAO();
		for(Session i:sessDAO.readAll()) {
			Object[] row= {i.getID(),i.getNum(),i.getDate()};
			model.addRow(row);
		}
		JTable table=new JTable(model);
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				if(table.getSelectedRow()>-1) {
					selectedID=(int) table.getModel().getValueAt(table.getSelectedRow(), 0);
				}
			}
			
		});
		//Buttons
				Box buttons=Box.createHorizontalBox();
				//Add
				JButton addBtn=new JButton("Creer");
				addBtn.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						selectedID=0;
						SessionGUI sGUI=new SessionGUI();
						sGUI.editSession();
						model.setRowCount(0);
						for(Session i:sessDAO.readAll()) {
							Object[] row= {i.getID(),i.getNum(),i.getDate()};
							model.addRow(row);
							
						}
						remove(panel);
						add(panel);
						revalidate();
						repaint();
					}
					
				});
				buttons.add(addBtn);
				//Modify
				JButton modButton=new JButton("Modifier");
				modButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						if(selectedID!=0) {
							SessionGUI sGUI=new SessionGUI();
							sGUI.editSession();
							remove(panel);
							add(panel);
							revalidate();
							repaint();
						    }else {
							JOptionPane.showMessageDialog(null, "Vouz devez choisir une Session!");
						}
						model.setRowCount(0);
						for(Session i:sessDAO.readAll()) {
							Object[] row= {i.getID(),i.getNum(),i.getDate()};
							model.addRow(row);
							
						}
						remove(panel);
						add(panel);
						revalidate();
						repaint();
					}
				});
				buttons.add(modButton);
				//Delete
				JButton deleteBtn=new JButton("Supprimer");
				deleteBtn.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						if(selectedID!=0) {
							if(JOptionPane.showConfirmDialog(null, "Vous voulez supprimer cette Session?")==0) {
								if(sessDAO.delete(sessDAO.searchByID(selectedID))!=0) {
									JOptionPane.showMessageDialog(null, "Session suprimee.");
								}else {
									JOptionPane.showMessageDialog(null,"Congrats, you have found a bug!");
								}
								model.setRowCount(0);
								for(Session i:sessDAO.readAll()) {
									Object[] row= {i.getID(),i.getNum(),i.getDate()};
									model.addRow(row);
								}
								remove(panel);
								add(panel);
								revalidate();
								repaint();
								
							}
						}else {
							JOptionPane.showMessageDialog(null, "Vous devez choisir une Session.");
						}
						
					}
					
				});
				buttons.add(deleteBtn);		
		panel.add(table.getTableHeader(),BorderLayout.NORTH);
		panel.add(table,BorderLayout.CENTER);
		panel.add(buttons,BorderLayout.SOUTH);
		add(panel);
		setVisible(true);
	}
	public void editSession() {
		setModal(true);
		setSize(200,150);
		setTitle("Edit Session");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		SessionDAO sessDAO=new SessionDAO();
		
		JPanel panel=new JPanel(new BorderLayout());
		JLabel num=new JLabel("Numero") ;
		JTextField numTF=new JTextField();
		JLabel date=new JLabel("Date de Debut (DD/MM/YYYY)");
		JTextField dateTF=new JTextField();
		Session sess=new Session(0, 0, "");
		if(selectedID!=0) {
			sess=sessDAO.searchByID(selectedID);
			numTF.setText(Integer.toString(sess.getNum()));
			dateTF.setText(sess.getDate());
		}
		JButton confirm=new JButton("Confirmer");
		confirm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Session sess=new Session(0, 0, "");
				try {
					sess.setID(selectedID);
				sess.setNum(Integer.parseInt(numTF.getText()));
				sess.setDate(dateTF.getText());
				SessionDAO sessDAO=new SessionDAO();
				if(selectedID==0) {
					if(sessDAO.add(sess)!=0) {
						JOptionPane.showMessageDialog(null, "Session creee.");
						dispose();
						selectedID=0;
					}else {
						JOptionPane.showMessageDialog(null, "Hmmm...Mysterieux...");
					}
				}else {
					if(sessDAO.modify(sess)!=0) {
						JOptionPane.showMessageDialog(null, "Session modifiee");
						dispose();
					}else {
						JOptionPane.showMessageDialog(null, "Hmmm...Mysterieux...");
					}
				}
				}
				catch(NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Hmmm...le numero n'est pas vraiment un numero...");
				}
				System.out.println(numTF.getText());
				System.out.println(dateTF.getText());
				
				
			}
			
		});
		
		Box mainBox=Box.createVerticalBox();
		mainBox.add(num);
		mainBox.add(numTF);
		mainBox.add(date);
		mainBox.add(dateTF);
		mainBox.add(confirm);
		panel.add(mainBox,BorderLayout.CENTER);
		add(panel);
		setVisible(true);
	}
	
}

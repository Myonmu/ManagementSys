package GUI;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import DAO.*;
import models.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class AbsenceGUI extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static int selectedID=0;
	public static int etuID=0;
	/**
	 * Shows a student's absence record
	 * @param etuID
	 * if etuID is 0, then all absence record will be shown. 
	 */
	public void readEtuAbsence(int etuID) {
		//WINDOW SET UP
		selectedID=0;
		this.setSize(800,600);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setTitle("Absences");
		this.setLocationRelativeTo(null);
		
		JPanel panel=new JPanel(new BorderLayout());
		//CREATING ABSENCE TABLE
		AbsenceDAO absDAO=new AbsenceDAO();
		Object[] columnheads= {"ID","Matiere","Type","Date","Duree","Justificatif","Etat","Commentaire","etuID","idPlan"};
		DefaultTableModel model=new DefaultTableModel(columnheads,0);
		for(AbsenceAff i: absDAO.readAff()) {
			Object[] row= {i.getId(),i.getMatiere(),i.getType(),i.getDate(),i.getHeure(),i.getJust(),i.getEtat(),
			i.getComment(),i.getEtu(),i.getPlan()};
			if(i.getEtu()==etuID||etuID==0) {
				model.addRow(row);
			}
		}
		JTable table=new JTable(model);
		TableColumnModel cm=table.getColumnModel();
		cm.removeColumn(cm.getColumn(cm.getColumnIndex("etuID")));
		cm.removeColumn(cm.getColumn(cm.getColumnIndex("idPlan")));
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				if(table.getSelectedRow()>-1) {
					selectedID=(int) table.getModel().getValueAt(table.getSelectedRow(), 0);
					//System.out.println(selectedID);
				}
				
			}
		});
		//adding table to the panel
		panel.add(table.getTableHeader(),BorderLayout.NORTH);
		panel.add(table,BorderLayout.CENTER);
		//CREATING BUTTONS
		//SHOW JUST
		JButton showJust = new JButton("Afficher");
		showJust.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JustificatifGUI justGUI=new JustificatifGUI();
				if(selectedID!=0) {
					justGUI.show(selectedID);
					selectedID=0;
					}
				else {
					JOptionPane.showMessageDialog(null, "Vous devez choisir l'absence!");
				}
			}
		});
		//UPLOAD JUST
		JButton deposeJust = new JButton("Deposer"); 
		deposeJust.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JustificatifGUI justGUI=new JustificatifGUI();
				if(selectedID!=0) {
					justGUI.deposer(selectedID);
					model.setRowCount(0);
					for(AbsenceAff i: absDAO.readAff()) {
						if(i.getEtu()==etuID||etuID==0) {
							Object[] row= {i.getId(),i.getMatiere(),i.getType(),i.getDate(),i.getHeure(),i.getJust(),i.getEtat(),
									i.getComment(),i.getEtu(),i.getPlan()};
									model.addRow(row);
							}
						}
					remove(panel);
					add(panel);
					revalidate();
					repaint();
					selectedID=0;
					}
				else {
					JOptionPane.showMessageDialog(null, "Vous devez choisir l'absence!");
				}
				
			}
		});
		//TREATE JUST
		JButton traiterJust = new JButton("Traiter");
		traiterJust.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JustificatifGUI justGUI=new JustificatifGUI();
				justGUI.traiter(selectedID);
				model.setRowCount(0);
				for(AbsenceAff i: absDAO.readAff()) {
					if(i.getEtu()==etuID||etuID==0) {
						Object[] row= {i.getId(),i.getMatiere(),i.getType(),i.getDate(),i.getHeure(),i.getJust(),i.getEtat(),
								i.getComment(),i.getEtu(),i.getPlan()};
								model.addRow(row);
						}
					}
				remove(panel);
				add(panel);
				revalidate();
				repaint();
				selectedID=0;
			}
		});
		Box hbox=Box.createHorizontalBox();
		hbox.add(deposeJust);
		hbox.add(showJust);
		
		panel.add(hbox,BorderLayout.SOUTH);
		//DELETE ABSENCE
		JButton deleteAbs=new JButton("Supprimer");
		deleteAbs.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AbsenceDAO absDAO=new AbsenceDAO();
				if(JOptionPane.showConfirmDialog(null, "Vous voulez vraiment supprimer cette absence?")==0) {
					absDAO.delete(absDAO.searchByID(selectedID));
					model.setRowCount(0);
					for(AbsenceAff i: absDAO.readAff()) {
						if(i.getEtu()==etuID||etuID==0) {
							Object[] row= {i.getId(),i.getMatiere(),i.getType(),i.getDate(),i.getHeure(),i.getJust(),i.getEtat(),
									i.getComment(),i.getEtu(),i.getPlan()};
									model.addRow(row);
							}
						}
					remove(panel);
					add(panel);
					revalidate();
					repaint();
					selectedID=0;
				}
			}
		});
		if(userID.USERTYPE==3) {
			hbox.add(traiterJust);
			hbox.add(deleteAbs);
		}
		//showing the window
		add(panel);
		setVisible(true);
		
		
	}
	/**
	 * Declare an absence, must be a sub-GUI after a planning selection GUI
	 * @param planID
	 */
	public void declarer(int planID) {
		//setup window
		setModal(true);
		this.setTitle("Creation Absence");
		this.setSize(300,150);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		//setup textfields
		//Date
		Box mainBox=Box.createVerticalBox();
		Box dateBox=Box.createHorizontalBox();
		JLabel dateLabel=new JLabel("Semaine");
		JTextField dateTF=new JTextField();
		dateBox.add(dateLabel);
		dateBox.add(dateTF);
		mainBox.add(dateBox);
		//Etu
		
		JLabel etuLabel=new JLabel("Etudiant");
		JButton selectEtu=new JButton("Select");
		selectEtu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//TODO Paste Etudiant selection here
				etuID=0;
				
			}
		});
		Box etuBox=Box.createHorizontalBox();
		etuBox.add(etuLabel);
		etuBox.add(selectEtu);
		if(userID.USERTYPE!=2) {
			mainBox.add(etuBox);
		}
		//button
		JButton confirm=new JButton("Confirmer");
		confirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AbsenceDAO absDAO=new AbsenceDAO() ;
				Absence abs=new Absence(planID,Integer.parseInt(dateTF.getText()),0,"");
				if(userID.USERTYPE==2) {
					abs.setEtu(userID.ID);
				}	else {
					abs.setEtu(etuID);
				}
				if(absDAO.addNoJust(abs)!=0) {
					JOptionPane.showMessageDialog(null, "Absence declaree");
				}else {
					JOptionPane.showMessageDialog(null, "Erreur");
				}
			}
		});
		mainBox.add(confirm);
		//assemble
		JPanel panel=new JPanel();
		panel.add(mainBox);
		this.add(panel);
		this.setVisible(true);
	}
	public static void main(String[] arg) {
		userID.setUSERTYPE(3);
		AbsenceGUI absGUI=new AbsenceGUI();
		absGUI.readEtuAbsence(1);
	}
	
		
		
	}


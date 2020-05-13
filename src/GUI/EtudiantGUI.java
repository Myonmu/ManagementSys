package GUI;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import DAO.*;
import models.*;

/**
 * Everything a student can do. Connection tree:
 * etudiantMenu() - readPlanning() - declarer() (Absence)
 * 				  - readEtuAbsence()(Absence)  - deposer() (justificatif)
 * 								               - Afficher() (justificatif)
 * @author Hippocrates
 *
 */
public class EtudiantGUI extends JDialog{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static int selectedID=0;
	/**
	 * Student menu
	 */
	public void etudiantMenu() {
		this.setSize(50,100);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setTitle("Benvenuto, Studiando.");
		Box mainBox=Box.createVerticalBox();
		//Buttons
		//Planning
		JButton plBtn=new JButton("Planning");
		plBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				EtudiantGUI etuGUI=new EtudiantGUI();
				etuGUI.readPlanning();
			}
			
		});
		mainBox.add(plBtn);
		//Absence
		JButton absBtn=new JButton("Absences");
		absBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AbsenceGUI absGUI=new AbsenceGUI();
				absGUI.readEtuAbsence(userID.ID);
			}
			
		});
		//Assemble
		mainBox.add(absBtn);
		JPanel panel=new JPanel(new BorderLayout());
		panel.add(mainBox,BorderLayout.CENTER);
		add(panel);
		setVisible(true);
		
	}
	
	
	
	
	/**
	 * Reads the student's planning, when logged in as student.
	 */
	public void readPlanning() {
		selectedID=0;
		setModal(true);
		//window setup
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("Planning");
		
		setSize(800,500);
		setLocationRelativeTo(null);		
		JPanel panel=new JPanel(new BorderLayout());
				
		//Creating planning table
				
		PlanningDAO plDAO=new PlanningDAO();
		GroupeDAO grDAO=new GroupeDAO();
		EtudiantDAO etuDAO=new EtudiantDAO();
		int grID=grDAO.searchByID(etuDAO.searchByID(userID.ID).getGr()).getID();
		Object[] columnHeads= {"ID","Session","Jour","Heure","Matiere","Type","Duree","Groupe","Enseignant","idEns","idMat"};
		DefaultTableModel model=new DefaultTableModel(columnHeads,0);
		//A Planning is considered in a Enseignant's table if he teaches it or is responsible for the course
		for(PlanningAff i:plDAO.readPlanningAff()) {
			if(i.getGroupe()==grID) {
				Object[] row= {i.getId(),i.getSession(),i.getDow(),i.getHoraire(),i.getMatiere(),i.getType(),i.getDuree()
						,i.getGroupe(),i.getEns(),i.getIdEns(),i.getIdMat()};
				model.addRow(row);
			}
		}
		JTable table=new JTable(model);
		TableColumnModel cm=table.getColumnModel();
		//Hide id columns
		cm.removeColumn(cm.getColumn(cm.getColumnIndex("idEns")));
		cm.removeColumn(cm.getColumn(cm.getColumnIndex("idMat")));
		//adding listSelectionListener
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
				
		//creating buttons
		JButton button1=new JButton("Declarer Absence");
		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AbsenceGUI absGUI=new AbsenceGUI();
				if(selectedID!=0) {
				    absGUI.declarer(selectedID);
				    selectedID=0;
				}
				else {
					JOptionPane.showMessageDialog(null, "Vous devez choisir un Planning!");
				}
			}	
		});
		
		Box hbox=Box.createHorizontalBox();
		hbox.add(button1);
		panel.add(hbox,BorderLayout.SOUTH);
				
		//showing the window
		add(panel);
		setVisible(true);
	}
	/**
	 * For student selection
	 * @return selected student's id
	 */
	public int etuSelect() {
		selectedID=0;
		this.setSize(800,500);
		this.setLocationRelativeTo(null);
		this.setTitle("Etudiant selection");
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setModal(true);
		
		Object[] tableHead= {"ID","Nom","Prenom"};
		DefaultTableModel model=new DefaultTableModel(tableHead,0);
		EtudiantDAO etuDAO=new EtudiantDAO();
		for(Etudiant i:etuDAO.readAll()) {
			Object[] row= {i.getID(),i.getNom(),i.getPrenom()};
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
		
		JPanel panel=new JPanel(new BorderLayout());
		panel.add(table.getTableHeader(),BorderLayout.NORTH);
		panel.add(table,BorderLayout.CENTER);
		
		//button
		JButton confirm=new JButton("Confirmer") ;
		confirm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(selectedID!=0) {
					JOptionPane.showMessageDialog(null, "Etudiant Selectione");
					dispose();
				}	
			}
		});
		panel.add(confirm,BorderLayout.SOUTH);
		add(panel);
		setVisible(true);
		System.out.println(selectedID);
		return selectedID;
		
	}
	/**
	 * TODO To be deleted
	 * @param arg
	 */
	public static void main(String[] arg) {
		userID.setUserID(1);
		userID.setUSERTYPE(2);
		EtudiantGUI etuGui=new EtudiantGUI();
		etuGui.etudiantMenu();
	}
}

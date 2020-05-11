package GUI;
import models.*;
import DAO.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
public class EnseignantGUI extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static int selectedID=0;
	/**
	 * Reads the prof's planning
	 */
	public void readPlanning() {
		selectedID=0;
		//window setup
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("Planning");
		setSize(800,500);
		setLocationRelativeTo(null);
		JPanel panel=new JPanel(new BorderLayout());
		
		//Creating planning table
		
		PlanningDAO plDAO=new PlanningDAO();
		CoursDAO csDAO=new CoursDAO();
		ArrayList<Integer> idMat=new ArrayList<>();
		for(Cours i:csDAO.searchByEns(userID.ID)) {
			idMat.add(i.getEnsPar());
		}
		Object[] columnHeads= {"ID","Session","Jour","Heure","Matiere","Type","Duree","Groupe","Enseignant","idEns","idMat"};
		DefaultTableModel model=new DefaultTableModel(columnHeads,0);
		//A Planning is considered in a Enseignant's table if he teaches it or is responsible for the course
		for(PlanningAff i:plDAO.readPlanningAff()) {
			if(i.getIdEns()==userID.ID||idMat.contains(i.getIdMat())) {
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
				absGUI.declarer(selectedID);
				model.setRowCount(0);
				for(PlanningAff i:plDAO.readPlanningAff()) {
					if(i.getIdEns()==userID.ID||idMat.contains(i.getIdMat())) {
						Object[] row= {i.getId(),i.getSession(),i.getDow(),i.getHoraire(),i.getMatiere(),i.getType(),i.getDuree()
								,i.getGroupe(),i.getEns(),i.getIdEns(),i.getIdMat()};
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
		JButton button2=new JButton("Affcher Absences");
		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO copy show-absence GUI here
				AbsenceGUI absGUI=new AbsenceGUI();
				absGUI.readPlanningAbsence(selectedID);
				selectedID=0;
			}
			
		});

		Box hbox=Box.createHorizontalBox();
		hbox.add(button1);
		hbox.add(button2);
		panel.add(hbox,BorderLayout.SOUTH);
		
		//showing the window
		add(panel);
		setVisible(true);
	}
	
	public void enseignantMenu() {
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("Benvenuto, Insegnante.");
		setSize(200,100);
		setLocationRelativeTo(null);
		JPanel panel=new JPanel(new BorderLayout());
		Box mainBox=Box.createVerticalBox();
		selectedID=0;
		//Buttons
		//Planning
		JButton planningBtn=new JButton("Consulter Planning");
		planningBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				EnseignantGUI ensGUI=new EnseignantGUI();
				ensGUI.readPlanning();
			}
			
		});
		mainBox.add(planningBtn);
		//Student List(Absence)
		JButton absBtn=new JButton("Absence des etudiants");
		absBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				selectedID=0;
				EtudiantGUI etuGUI=new EtudiantGUI();
				selectedID=etuGUI.etuSelect();
				AbsenceGUI absGUI=new AbsenceGUI();
				absGUI.readEtuAbsence(selectedID);
			}
			
		});
		mainBox.add(absBtn);
		
		panel.add(mainBox,BorderLayout.CENTER);
		add(panel);
		setVisible(true);
	}

	public static void main(String[] arg) {
		EnseignantGUI ensGUI=new EnseignantGUI();
		ensGUI.enseignantMenu();
	}
}

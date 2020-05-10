package GUI;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import DAO.*;
import models.*;
public class PlanningGUI extends JFrame{
	static int selectedID=0;
	static int sessionID=0;
	static int matID=0;
	static int dow=0;
	static String type="";
	public void readAllPlanning() {
		selectedID=0;
		//window setup
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("Planning");
		setLocationRelativeTo(null);
		setSize(800,500);
		
		JPanel panel=new JPanel(new BorderLayout());
		
		//Creating planning table
		
		PlanningDAO plDAO=new PlanningDAO();
		CoursDAO csDAO=new CoursDAO();
		Object[] columnHeads= {"ID","Session","Jour","Heure","Matiere","Type","Duree","Groupe","Enseignant","idEns","idMat"};
		DefaultTableModel model=new DefaultTableModel(columnHeads,0);
		//A Planning is considered in a Enseignant's table if he teaches it or is responsible for the course
		for(PlanningAff i:plDAO.readPlanningAff()) {
				Object[] row= {i.getId(),i.getSession(),i.getDow(),i.getHoraire(),i.getMatiere(),i.getType(),i.getDuree()
						,i.getGroupe(),i.getEns(),i.getIdEns(),i.getIdMat()};
				model.addRow(row);
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
		
		//Buttons
		//Add
		JButton addBtn=new JButton("Creer");
		
		//Modify
		//Delete
		
	}
	/**
	 * This GUI combines add/modify. If selectedID is 0 while add button is pressed, this GUI functions 
	 * as ADD, and if selectedID is not 0 while button modify is pressed, this GUI functions as MODIFY.
	 */
	public void editPlanning() {
		
		Planning target=new Planning(0, 0, 0, 0, "", "", 0, 0, 0);
		if(selectedID!=0) {
			PlanningDAO plDAO=new PlanningDAO();
			target=plDAO.searchByID(selectedID);
		}
		
		this.setSize(500,300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setTitle("Creation Planning");
		
		//Components
		//Session Combobox
		sessionID=0;
		JLabel session=new JLabel("Session");
		JComboBox<Session> sessionCB= new JComboBox<Session>();
		sessionCB.setMaximumRowCount(10);
		SessionDAO sesDAO=new SessionDAO();
		SessionRenderer sesRend=new SessionRenderer();
		sessionCB.setRenderer(sesRend);
		for(Session i: sesDAO.readAll()) {
			sessionCB.addItem(i);
		}
		sessionCB.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED) {
					sessionID=((Session) sessionCB.getSelectedItem()).getID();
				}
			}
			
		});
		Box sesBox=Box.createHorizontalBox();
		sesBox.add(session);
		sesBox.add(sessionCB);
		//Matiere Combobox
		matID=0;
		JLabel matiere=new JLabel("Matiere");
		JComboBox<Cours> matCB=new JComboBox<Cours>();
		matCB.setMaximumRowCount(10);
		MatiereRenderer matRend=new MatiereRenderer();
		matCB.setRenderer(matRend);
		CoursDAO crDAO=new CoursDAO();
		for(Cours i: crDAO.readAll()) {
			matCB.addItem(i);
		}
		matCB.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED) {
					matID=((Cours) matCB.getSelectedItem()).getID();
				}
			}
			
		});
		Box matBox=Box.createHorizontalBox();
		matBox.add(matiere);
		matBox.add(matCB);
		
		//DOW Combobox
		dow=0;
		JLabel dowLabel=new JLabel("Jour");
		String[] dowList= {"Lundi","Mardi","Mecredi","Jeudi","Vendredi"};
		JComboBox<String> dowCB= new JComboBox<String>();
		for(String i:dowList) {
			dowCB.addItem(i);
		}
		dowCB.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED) {
					dow=dowCB.getSelectedIndex()+1; //TODO Verify if it is necessary to add 1
				}
			}
			
		});
		Box dowBox=Box.createHorizontalBox();
		dowBox.add(dowLabel);
		dowBox.add(dowCB);
		
	    //Horaire txtField
		JTextField horaireTF=new JTextField();
		JLabel horaireLabel=new JLabel("Commence A");
		Box horaireBox=Box.createHorizontalBox();
		horaireBox.add(horaireLabel);
		horaireBox.add(horaireTF);
		//type 
		type="";
		JLabel typeLabel=new JLabel("Type");
		String[] typeList= {"AMPHI","TD","TP","DS"};
		JComboBox<String> typeCB= new JComboBox<String>();
		for(String i:typeList) {
			typeCB.addItem(i);
		}
		dowCB.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED) {
					type=(String)typeCB.getSelectedItem();
				}
			}
		});
		Box typeBox=Box.createHorizontalBox();
		typeBox.add(typeLabel);
		typeBox.add(typeCB);
		//Duree
		JTextField dureeTF=new JTextField();
		JLabel dureeLabel=new JLabel("Duree");
		Box dureeBox=Box.createHorizontalBox();
		dureeBox.add(horaireLabel);
		dureeBox.add(horaireTF);
		//Groupe cb
		
		
		
	}
	
	
	/**
	 * Renderer for the Session Combobox
	 * 
	 */
	class SessionRenderer extends DefaultListCellRenderer{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			Object translated=((Session)value).getNum()+" "+((Session)value).getDate();
			super.getListCellRendererComponent(list,translated,index,isSelected,cellHasFocus);
			return this;
		}
	}
	/**
	 * Renderer for the course combobox
	 * @author miska
	 *
	 */
	class MatiereRenderer extends DefaultListCellRenderer{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			Object translated=((Cours)value).getNom();
			super.getListCellRendererComponent(list,translated,index,isSelected,cellHasFocus);
			return this;
		}
	}
	/**
	 * Renderer for the group combobox
	 * @author miska
	 *
	 */
	class GroupeRenderer extends DefaultListCellRenderer{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			Object translated=((Groupe)value).getNum();
			super.getListCellRendererComponent(list,translated,index,isSelected,cellHasFocus);
			return this;
		}
	}
	/**
	 * Renderer for the enseignant combobox
	 * @author miska
	 *
	 */
	class EnseignantRenderer extends DefaultListCellRenderer{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			Object translated=((Enseignant)value).getNom()+" "+((Enseignant)value).getPrenom();
			super.getListCellRendererComponent(list,translated,index,isSelected,cellHasFocus);
			return this;
		}
	}
	
}

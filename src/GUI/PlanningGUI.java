package GUI;
import java.awt.BorderLayout;
import java.awt.Component;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import DAO.*;
import models.*;
/**
 * 
 * @author Hippocrate
 *
 */
public class PlanningGUI extends JDialog{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static int selectedID=0;
	static int sessionID=1;
	static int matID=1;
	static int dow=1;
	static String type="AMPHI";
	static int groupeID=1;
	static int enseignantID=1;
	static boolean state=false;
	/**
	 * reads all planning (user-friendly style)
	 */
	public void readAllPlanning() {
		selectedID=0;
		//window setup
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("Planning");
		
		setSize(800,500);
		setLocationRelativeTo(null);
		final JPanel panel=new JPanel(new BorderLayout());
		
		//Creating planning table
		
		PlanningDAO plDAO=new PlanningDAO();
		final Object[] columnHeads= {"ID","Session","Jour","Heure","Matiere","Type","Duree","Groupe","Enseignant","idEns","idMat"};
		DefaultTableModel model=new DefaultTableModel(columnHeads,0);
		//A Planning is considered in a Enseignant's table if he teaches it or is responsible for the course
		for(PlanningAff i:plDAO.readPlanningAff()) {
				Object[] row= {i.getId(),i.getSession(),i.getDow(),i.getHoraire(),i.getMatiere(),i.getType(),i.getDuree()
						,i.getGroupe(),i.getEns(),i.getIdEns(),i.getIdMat()};
				model.addRow(row);
		}
		final JTable table=new JTable(model);
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
		Box buttons=Box.createHorizontalBox();
		//Add
		JButton addBtn=new JButton("Creer");
		addBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				selectedID=0;
				PlanningGUI plGUI=new PlanningGUI();
				DefaultTableModel modelMod=plGUI.editPlanning((DefaultTableModel)table.getModel());		
				table.setModel(modelMod);
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
					PlanningGUI plGUI=new PlanningGUI();
					DefaultTableModel modelMod=plGUI.editPlanning((DefaultTableModel)table.getModel());		
					table.setModel(modelMod);
					remove(panel);
					add(panel);
					revalidate();
					repaint();
				    }else {
					JOptionPane.showMessageDialog(null, "Vouz devez choisir un Planning!");
				}
			}
		});
		buttons.add(modButton);
		//Delete
		JButton deleteBtn=new JButton("Supprimer");
		deleteBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(selectedID!=0) {
					if(JOptionPane.showConfirmDialog(null, "Vous voulez supprimer ce Planning?")==0) {
						PlanningDAO plDAO=new PlanningDAO();
						plDAO.delete(plDAO.searchByID(selectedID));
						DefaultTableModel modelMod=new DefaultTableModel(columnHeads, 0);
						for(PlanningAff i:plDAO.readPlanningAff()) {
							Object[] row= {i.getId(),i.getSession(),i.getDow(),i.getHoraire(),i.getMatiere(),i.getType(),i.getDuree()
									,i.getGroupe(),i.getEns(),i.getIdEns(),i.getIdMat()};
							modelMod.addRow(row);
						}
						table.setModel(modelMod);
						TableColumnModel cm=table.getColumnModel();
						//Hide id columns
						cm.removeColumn(cm.getColumn(cm.getColumnIndex("idEns")));
						cm.removeColumn(cm.getColumn(cm.getColumnIndex("idMat")));
						remove(panel);
						add(panel);
						revalidate();
						repaint();
						
					}
				}else {
					JOptionPane.showMessageDialog(null, "Vous devez choisir un Planning.");
				}
				
			}
			
		});
		buttons.add(deleteBtn);
		//Absence declare
		JButton declareBtn=new JButton("Declarer Absence");
		declareBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AbsenceGUI absGUI=new AbsenceGUI() ;
				if(selectedID!=0) {
				absGUI.declarer(selectedID);}
				else {
					JOptionPane.showMessageDialog(null, "Vous devez choisir un Planning.");
				}
			}
			
		});
		buttons.add(declareBtn);
		
		panel.add(buttons,BorderLayout.SOUTH);
		this.add(panel);
		this.setVisible(true);
	}
	/**
	 * This GUI combines add/modify. If selectedID is 0 while add button is pressed, this GUI functions 
	 * as ADD, and if selectedID is not 0 while button modify is pressed, this GUI functions as MODIFY.
	 */
	public DefaultTableModel editPlanning(DefaultTableModel model) {
		this.setModal(true);
		Planning target=new Planning(0, 0, 0, 0, "", "", 0, 0, 0);
		if(selectedID!=0) {
			PlanningDAO plDAO=new PlanningDAO();
			target=plDAO.searchByID(selectedID);
		}
		
		this.setSize(500,300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setTitle("Planning");
		
		//Components
		//Session Combobox
		sessionID=1;
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
		matID=1;
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
		dow=1;
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
					dow=dowCB.getSelectedIndex()+1; 
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
		type="AMPHI";
		JLabel typeLabel=new JLabel("Type");
		String[] typeList= {"AMPHI","TD","TP","DS"};
		JComboBox<String> typeCB= new JComboBox<String>();
		for(String i:typeList) {
			typeCB.addItem(i);
		}
		typeCB.addItemListener(new ItemListener() {
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
		JLabel dureeLabel=new JLabel("Duree(minutes)");
		Box dureeBox=Box.createHorizontalBox();
		dureeBox.add(dureeLabel);
		dureeBox.add(dureeTF);
		//Groupe cb
		groupeID=1;
		JLabel grLabel=new JLabel("Groupe");
		GroupeDAO grDAO=new GroupeDAO();
		GroupeRenderer grRend=new GroupeRenderer();
		JComboBox<Groupe>grCB= new JComboBox<Groupe>();
		grCB.setRenderer(grRend);
		for(Groupe i:grDAO.readGrList()) {
			grCB.addItem(i);
		}
		grCB.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED) {
					groupeID=((Groupe)grCB.getSelectedItem()).getID(); 
				}
			}
			
		});
		Box groupeBox=Box.createHorizontalBox();
		groupeBox.add(grLabel);
		groupeBox.add(grCB);
		
		//Ens CB
		enseignantID=1;
		JLabel ensLabel=new JLabel("Enseignant");
		EnseignantDAO ensDAO=new EnseignantDAO();
		EnseignantRenderer ensRend=new EnseignantRenderer();
		JComboBox<Enseignant>ensCB= new JComboBox<Enseignant>();
		ensCB.setRenderer(ensRend);
		for(Enseignant i:ensDAO.readAll()) {
			ensCB.addItem(i);
		}
		ensCB.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED) {
					enseignantID=((Enseignant)ensCB.getSelectedItem()).getID(); 
					System.out.println(enseignantID);
				}
			}
			
		});
		Box ensBox=Box.createHorizontalBox();
		ensBox.add(ensLabel);
		ensBox.add(ensCB);
		//Modification mode
		if(selectedID!=0) {
			matCB.setSelectedItem(crDAO.searchByID(target.getMat()));
			sessionCB.setSelectedItem(sesDAO.searchByID(target.getSess()));
			dowCB.setSelectedIndex(target.getDow()-1);
			horaireTF.setText(target.getHoraire());
			typeCB.setSelectedItem(target.getType());
			dureeTF.setText(Integer.toString(target.getDuree()));
			grCB.setSelectedItem(grDAO.searchByID(target.getGr()));
			ensCB.setSelectedItem(ensDAO.searchByID(target.getEns()));
		}
		//Button
		JButton confirm=new JButton("Confirmer");
		confirm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				PlanningDAO plDAO=new PlanningDAO();
				Planning target=new Planning(0, 0, 0, 0, "", "", 0, 0, 0);
				target.setDow(dow);
				target.setHoraire(horaireTF.getText());
				target.setEns(enseignantID);
				target.setGr(groupeID);
				try {
				target.setDuree(Integer.parseInt(dureeTF.getText()));}
				catch(NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "The duration...is not a number...");
				}
				target.setMat(matID);
				target.setSess(sessionID);
				target.setType(type);
				if(selectedID==0) {
					if(plDAO.add(target)!=0) {
						JOptionPane.showMessageDialog(null, "Planning Cree.");
						dispose();
					}
				}else {
					target.setID(selectedID);
					if(plDAO.modify(target)!=0) {
						JOptionPane.showMessageDialog(null, "Planning Modifie.");
						dispose();
					}
				}
				model.setRowCount(0);
				for(PlanningAff i:plDAO.readPlanningAff()) {
					Object[] row= {i.getId(),i.getSession(),i.getDow(),i.getHoraire(),i.getMatiere(),i.getType(),i.getDuree()
							,i.getGroupe(),i.getEns(),i.getIdEns(),i.getIdMat()};
					model.addRow(row);
				}
				
				
			}
			
		});
		//Assemble
		Box mainBox=Box.createVerticalBox();
		mainBox.add(sesBox);
		mainBox.add(matBox);
		mainBox.add(dowBox);
		mainBox.add(horaireBox);
		mainBox.add(typeBox);
		mainBox.add(dureeBox);
		mainBox.add(groupeBox);
		mainBox.add(ensBox);
		mainBox.add(confirm);
		JPanel panel=new JPanel(new BorderLayout());
		panel.add(mainBox,BorderLayout.CENTER);
		this.add(panel);
		this.setVisible(true);
		return model;
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
			Object translated=((Session)value).getNum()+"   "+((Session)value).getDate();
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
			Object translated=((Groupe)value).getNum()+"   CAP:"+((Groupe)value).getCap();
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
			Object translated=((Enseignant)value).getID()+"   "+((Enseignant)value).getNom()+" "+((Enseignant)value).getPrenom();
			super.getListCellRendererComponent(list,translated,index,isSelected,cellHasFocus);
			return this;
		}
	}
	
	public static void main(String[] args) {
		PlanningGUI plGUI=new PlanningGUI();
		plGUI.readAllPlanning();
	}
}

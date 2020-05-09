package GUI;
import java.awt.BorderLayout;
import java.awt.Component;
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
		//Modify
		//Delete
		
	}
	
	public void addPlanning() {
		this.setSize(500,300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setTitle("Creation Planning");
		
		//Components
		JLabel session=new JLabel("Session");
		JComboBox sessionCB= new JComboBox();
		
		
		
	}
	
	
	class sessionRenderer extends DefaultListCellRenderer{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			Object translated=((Session)value).getNum()+" "+((Session)value).getDate();
			super.getListCellRendererComponent(list,translated,index,isSelected,cellHasFocus);
			return this;
		}
	}
	class matiereRenderer extends DefaultListCellRenderer{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			Object translated=((Cours)value).getNom();
			super.getListCellRendererComponent(list,translated,index,isSelected,cellHasFocus);
			return this;
		}
	}
	class groupeRenderer extends DefaultListCellRenderer{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			Object translated=((Groupe)value).getNum();
			super.getListCellRendererComponent(list,translated,index,isSelected,cellHasFocus);
			return this;
		}
	}
	
}

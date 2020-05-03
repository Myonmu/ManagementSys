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
public class AbsenceGUI extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static int selectedID=0;
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
			if(i.getEtu()==etuID) {
				Object[] row= {i.getId(),i.getMatiere(),i.getType(),i.getDate(),i.getHeure(),i.getJust(),i.getEtat(),
						i.getComment(),i.getEtu(),i.getPlan()};
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
		JButton showJust = new JButton("Afficher");
		showJust.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JustificatifGUI justGUI=new JustificatifGUI();
				if(selectedID!=0) {
					justGUI.show(selectedID);}
				else {
					JOptionPane.showMessageDialog(null, "Vous devez choisir l'absence!");
				}
			}
		});
		JButton deposeJust = new JButton("Deposer"); 
		deposeJust.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JustificatifGUI justGUI=new JustificatifGUI();
				if(selectedID!=0) {
					justGUI.deposer(selectedID);}
				else {
					JOptionPane.showMessageDialog(null, "Vous devez choisir l'absence!");
				}
				
			}
		});
		JButton traiterJust = new JButton("Traiter");
		traiterJust.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JustificatifGUI justGUI=new JustificatifGUI();
				justGUI.traiter(selectedID);
			}
		});
		Box hbox=Box.createHorizontalBox();
		hbox.add(deposeJust);
		hbox.add(showJust);
		panel.add(hbox,BorderLayout.SOUTH);
		
		//showing the window
		add(panel);
		setVisible(true);
		
		
	}
	
	public void declarerEtu(int planID) {
		
	}
	public static void main(String[] arg) {
		AbsenceGUI absGUI=new AbsenceGUI();
		absGUI.readEtuAbsence(1);
	}
	
		
		
	}


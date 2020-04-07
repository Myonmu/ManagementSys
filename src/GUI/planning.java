package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;

public class planning {

	private JFrame frmPlanning;
	private JTable table;
	private JTextField txtListeDesCours;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					planning window = new planning();
					window.frmPlanning.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public planning() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPlanning = new JFrame();
		frmPlanning.getContentPane().setBackground(Color.CYAN);
		frmPlanning.setTitle("Planning");
		frmPlanning.setBounds(100, 100, 450, 300);
		frmPlanning.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPlanning.getContentPane().setLayout(null);
		
		table = new JTable();
		table.setBackground(Color.LIGHT_GRAY);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"", "Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", null},
				{"8h-10h", "Thermo", "ATS", "Lv2", "Pdl", null, null},
				{"10h-12h", "Anglais", null, "Proba", "Lifi", null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		table.setBounds(34, 53, 370, 48);
		frmPlanning.getContentPane().add(table);
		
		txtListeDesCours = new JTextField();
		txtListeDesCours.setBackground(Color.GREEN);
		txtListeDesCours.setText("Liste des cours de la semaine");
		txtListeDesCours.setBounds(121, 11, 177, 20);
		frmPlanning.getContentPane().add(txtListeDesCours);
		txtListeDesCours.setColumns(10);
	}
}

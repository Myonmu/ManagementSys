package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;

public class absc_non_justif {

	private JFrame frmMenutudiant;
	private JTable table;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					absc_non_justif window = new absc_non_justif();
					window.frmMenutudiant.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public absc_non_justif() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMenutudiant = new JFrame();
		frmMenutudiant.getContentPane().setBackground(Color.DARK_GRAY);
		frmMenutudiant.setTitle("Menu \u00E9tudiant");
		frmMenutudiant.setBounds(100, 100, 450, 300);
		frmMenutudiant.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMenutudiant.getContentPane().setLayout(null);
		
		JLabel lblMaListeDabsence = new JLabel("Ma liste d'absence non justifi\u00E9es:");
		lblMaListeDabsence.setBackground(new Color(240, 240, 240));
		lblMaListeDabsence.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 15));
		lblMaListeDabsence.setBounds(108, 11, 277, 33);
		frmMenutudiant.getContentPane().add(lblMaListeDabsence);
		
		table = new JTable();
		table.setBackground(Color.RED);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Oumar Ndiaye"},
				{"Absence 1:01/01/2019"},
				{"Absence 2:15/03/2019"},
				{"Absence 3:10/04/2019"},
			},
			new String[] {
				"Oumar Ndiaye"
			}
		));
		table.setBounds(10, 55, 291, 64);
		frmMenutudiant.getContentPane().add(table);
	}
}

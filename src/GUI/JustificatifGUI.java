package GUI;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import models.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import DAO.*;

/***
 * This class includes 2 GUIs, one for "uploading" a Justificatif and the other for treating a existing Justificatif.
 * Each must be used after receiving an ABSENCE ID from Absence GUIs.
 * @author Hippocrate
 *
 */
public class JustificatifGUI extends JDialog {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static String trajectory="Pas de fichier choisi.";
	static boolean selected=false;
	static int assign=1; //AbsenceType ID to assign
	/**
	 * Renderer for the combobox
	 * @author miska
	 */
	class CustomRenderer extends DefaultListCellRenderer{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			 	Object translated=((AbsenceType) value).getNom();			 		
	            super.getListCellRendererComponent(list, translated, index, cellHasFocus, cellHasFocus);
			return this;
		}
	}
	
	/**
	 * Saving an image's trajectory in the database, and attach it to an absence object.
	 * @param absID the ID of the absence object.
	 */
	public void deposer(int absID) {	
		selected=false;
		this.setModal(true);
		final JPanel panel=new JPanel();
		setTitle("Deposer justificatif");
		setSize(500,75);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		final JLabel img=new JLabel();
		final ImageIcon icon=new ImageIcon();
		img.setIcon(icon);
		Box hbox=Box.createHorizontalBox();
		final JTextField tf1=new JTextField(trajectory);
		tf1.setEditable(false);
		JButton btn1=new JButton("BROWSE");
		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc=new JFileChooser();
				fc.setFileFilter(new FileNameExtensionFilter("image(*.jpg, *.png, *.gif)", "jpg", "png", "gif"));
				fc.setMultiSelectionEnabled(false);
				int rVal=fc.showOpenDialog(null);
				if(rVal==JFileChooser.APPROVE_OPTION) {
					selected=true;
					trajectory=fc.getSelectedFile().getAbsolutePath();
					tf1.setText(trajectory);
					try {
						BufferedImage bi=ImageIO.read(new File(trajectory));
						BufferedImage nbi=scale(bi);
						setSize(500,nbi.getHeight()+115);
						setLocationRelativeTo(null);
						icon.setImage(nbi);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					remove(panel);
					add(panel);
					revalidate();
					repaint();
				}
			}
			
		});
		hbox.add(tf1);
		hbox.add(btn1);

		JButton btn2=new JButton("DEPOSER CE FICHIER");
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(selected) {
					int confirm=JOptionPane.showConfirmDialog(null, "Vous voulez deposer ce fichier?");
					if(confirm==0) {
						Justificatif just=new Justificatif(0,trajectory);
						JustificatifDAO jDAO=new JustificatifDAO();
						
						if(jDAO.add(just)!=0) {
							just=jDAO.searchByTrj(trajectory);
							AbsenceDAO absDAO=new AbsenceDAO();
							Absence temp=absDAO.searchByID(absID);
							temp.setJust(just.getID());
							
							if(absDAO.modify(temp)!=0) {
								JOptionPane.showMessageDialog(null, "Votre fichier a bien ete enregistre.");
								dispose();
							}
							else {
								JOptionPane.showMessageDialog(null, "Erreur");
							}
						}	
					}
				}else {
					JOptionPane.showMessageDialog(null, "Pas de fichier choisi!");
				}
			}
			
		});
		
		panel.add(hbox,BorderLayout.NORTH);
		panel.add(img,BorderLayout.CENTER);
		panel.add(btn2,BorderLayout.SOUTH);
		add(panel);
		setVisible(true);
		
	}
	/**
	 * Opens a justificatif image, than assign an absenceType to the absence.
	 * @param absID 
	 */
	public void traiter(int absID) {
		this.setModal(true);
		assign=1;
		final JPanel panel=new JPanel();
		setTitle("Justificatif");
		setSize(800,650);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		//Retrieving target justificatif and paint it on a JLabel
		AbsenceDAO absDAO=new AbsenceDAO();
		JustificatifDAO justDAO=new JustificatifDAO();
		String imgTrj=justDAO.searchByID(absDAO.searchByID(absID).getJust()).getTrj();
		JLabel imgLabel=new JLabel();
		ImageIcon icon=new ImageIcon();
		if(imgTrj!="") {
			try {
				BufferedImage img=scale(ImageIO.read(new File(imgTrj)));
				icon.setImage(img);
				imgLabel.setIcon(icon);
			} catch (NullPointerException e) {
				JOptionPane.showMessageDialog(null,"Cette absence n'a pas de Justificatif associe.");
				e.printStackTrace();
			} catch(IOException e) {
				JOptionPane.showMessageDialog(null,"Erreur");
			}
		}else {
			JOptionPane.showMessageDialog(null,"Cette absence n'a pas de Justificatif associe.");
		}
		//Retrieving all absenceType and fill them into a JComboBox
		AbsTypeDAO typeDAO=new AbsTypeDAO();
		JComboBox<AbsenceType> cb=new JComboBox<AbsenceType>();
		cb.setMaximumRowCount(5);
		CustomRenderer rd=new CustomRenderer();
		cb.setRenderer(rd);
		for(AbsenceType i:typeDAO.readAll()) {
			cb.addItem(i);
		}
		cb.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED) {
					assign=((AbsenceType) cb.getSelectedItem()).getID();
					System.out.println(assign);
				}
			}
			
		});
		//Comment box
		JTextField tf=new JTextField("Pas de commentaire");
		tf.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				tf.setText("");
			}
		});
		//Confirmation button
		JButton confirm=new JButton("Confirmer");
		confirm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
					AbsenceDAO absDAO=new AbsenceDAO();
					Absence abs=absDAO.searchByID(absID);
					abs.setEtat(assign);
					System.out.println(assign);
					abs.setComment(tf.getText());
					if(absDAO.modify(abs)!=0) {
						JOptionPane.showMessageDialog(null, "Le justificatif a bien ete traite.");
						dispose();
					}else {
						JOptionPane.showMessageDialog(null, "Erreur");
					}
				}
			
			
		});
		
		//put components together
		Box vBox=Box.createVerticalBox();
		vBox.add(imgLabel);
		vBox.add(cb);
		vBox.add(tf);
		vBox.add(confirm);
		panel.add(vBox);
		add(panel);
		setVisible(true);
		
		
	}
	public void show(int absID) {
		this.setModal(true);
		final JPanel panel=new JPanel();
		setTitle("Justificatif");
		setSize(800,650);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		//Retrieving target justificatif and paint it on a JLabel
		AbsenceDAO absDAO=new AbsenceDAO();
		JustificatifDAO justDAO=new JustificatifDAO();
		String imgTrj=justDAO.searchByID(absDAO.searchByID(absID).getJust()).getTrj();
		JLabel imgLabel=new JLabel();
		ImageIcon icon=new ImageIcon();

		try {
			BufferedImage img=scale(ImageIO.read(new File(imgTrj)));
			icon.setImage(img);
			imgLabel.setIcon(icon);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null,"Erreur");
			e.printStackTrace();
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "Justificatif n'existe pas");
		}
		
		//put components together
		Box vBox=Box.createVerticalBox();
		vBox.add(imgLabel);
		panel.add(vBox);
		add(panel);
		setVisible(true);
		
		
	}
	/**
	 * Scales an image
	 * @param img
	 * @return scaled image with no dimension larger than 500pxls
	 */
	public static BufferedImage scale(Image img) {
		int height=img.getHeight(null);
		int width=img.getWidth(null);
		int scaleHeight=height;
		int scaleWidth=width;
		if(height>500||width>500) {
			if(height>width) {
				scaleHeight=500;
				scaleWidth=(int)(width*((double)500/height));
			}
			else {
				scaleWidth=500;
				scaleHeight=(int)(height*((double)500/width));
			}
		}
		BufferedImage output=new BufferedImage(scaleWidth,scaleHeight, BufferedImage.TYPE_INT_RGB);
		Graphics2D graphics2D = output.createGraphics();
	    graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    graphics2D.drawImage(img, 0, 0, scaleWidth, scaleHeight, null);
	    return output;
	}
	
	
    /**
     * For testing, to be deleted
     * @param arg
     */
	public static void main(String[] arg) {
		//TODO Delete this after test
		
		JustificatifGUI j=new JustificatifGUI();
		j.traiter(1);
	}
	

}

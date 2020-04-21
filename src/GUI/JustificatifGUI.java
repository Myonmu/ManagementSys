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
public class JustificatifGUI extends JFrame {
	
	public static String trajectory="Pas de fichier choisi.";
	public static boolean selected=false;
	/**
	 * Saving an image's trajectory in the database, and attach it to an absence object.
	 * @param absID the ID of the absence object.
	 */
	public void deposer(int absID) {	
		final JPanel panel=new JPanel();
		setTitle("Deposer justificatif");
		setSize(500,75);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

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
						// TODO Auto-generated catch block
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
	 * Scales an image
	 * @param img
	 * @return
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
		j.deposer(1);
	}

}

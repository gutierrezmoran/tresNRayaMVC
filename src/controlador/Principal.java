package controlador;

import java.awt.EventQueue;

import javax.swing.ImageIcon;

public class Principal {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ParaTresNRayaUI frame = new ParaTresNRayaUI();
					frame.setVisible(true);
					frame.setIconImage(new ImageIcon(getClass().getResource("../img/icon.jpg")).getImage());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

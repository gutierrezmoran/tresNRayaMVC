package vista;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import java.awt.Component;

public class Botonera extends JPanel {

	private JButton botones[][];
	private int ladoBoton = 124;
	private final int MAXR = 45;
	private final int MAXG = 220;
	private final int MAXB = 160;
	private final int MINR = 40;
	private final int MING = 190;
	private final int MINB = 110;

	public Botonera() {
		iniciarBotonera();
	}

	/**
	 * Inicializa la botonera
	 */
	private void iniciarBotonera() {
		this.botones = new JButton[3][3];

		int coordenadaXBoton = 0;
		int coordenadaYBoton = 0;

		for (int i = 0; i < this.botones.length; i++) {
			for (int j = 0; j < this.botones[i].length; j++) {
				this.botones[i][j] = new JButton();
				asignarPropiedadesBoton(i, j, coordenadaXBoton, coordenadaYBoton);
				this.add(this.botones[i][j]);
				coordenadaXBoton += this.ladoBoton + 3;
			}
			coordenadaXBoton = 0;
			coordenadaYBoton += this.ladoBoton + 3;
		}
	}

	/**
	 * Genera un numero aleatorio entre un maximo y un minimo
	 * 
	 * @param max
	 *            Valor maximo
	 * @param min
	 *            Valor minimo
	 * @return Retorna un valor entero
	 */
	private int generarColor(int max, int min) {
		return (int) (Math.random() * (max - min + 1) + min);
	}

	/**
	 * Genera un color
	 * 
	 * @param MAXR
	 *            Valor maximo de Red
	 * @param MINR
	 *            Valor minimo de Red
	 * @param MAXG
	 *            Valor maximo de Green
	 * @param MING
	 *            Valor minimo de Green
	 * @param MAXB
	 *            Valor maximo de Blue
	 * @param MINB
	 *            Valor minimo de Blue
	 * @return Retorna una instancia de la clase Color con unas propiedades RGB
	 */
	public Color obtenerBackgroundBoton(int MAXR, int MINR, int MAXG, int MING, int MAXB, int MINB) {
		return new Color(generarColor(MAXR, MINR), generarColor(MAXG, MING), generarColor(MAXB, MINB));
	}

	/**
	 * Asigna propiedades a un boton
	 * 
	 * @param i
	 *            Posicion dentro de matriz
	 * @param j
	 *            Posicion dentro de matriz
	 * @param coordenadaXBoton
	 *            Coordenada del eje X
	 * @param coordenadaYBoton
	 *            Coordenada del eje Y
	 */
	private void asignarPropiedadesBoton(int i, int j, int coordenadaXBoton, int coordenadaYBoton) {
		this.setVisible(false);
		this.botones[i][j].setName(String.valueOf(i) + String.valueOf(j));
		this.botones[i][j].setBounds(coordenadaXBoton, coordenadaYBoton, this.ladoBoton, this.ladoBoton);
		this.botones[i][j].setBackground(
				obtenerBackgroundBoton(this.MAXR, this.MINR, this.MAXG, this.MING, this.MAXB, this.MINB));
		this.botones[i][j].setFont(new Font("Microsoft JhengHei UI Light", Font.PLAIN, 130));
		this.botones[i][j].setBorder(null);
		this.botones[i][j].setFocusPainted(false); // quita borde foco
		this.botones[i][j].setForeground(new Color(0, 0, 0));
		this.botones[i][j].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		int a = i;
		int b = j;
		this.botones[i][j].addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				if (botones[a][b].isEnabled()) {
					botones[a][b].setBackground(new Color(178, 255, 208));
					botones[a][b].setBorder(null);
				}
			}

			public void mouseExited(MouseEvent e) {
				if (botones[a][b].isEnabled()) {
					botones[a][b].setBackground(obtenerBackgroundBoton(MAXR, MINR, MAXG, MING, MAXB, MINB));
				}
			}
		});
	}

	public int getMAXR() {
		return MAXR;
	}

	public int getMAXG() {
		return MAXG;
	}

	public int getMAXB() {
		return MAXB;
	}

	public int getMINR() {
		return MINR;
	}

	public int getMING() {
		return MING;
	}

	public int getMINB() {
		return MINB;
	}

	public JButton[][] getBotones() {
		return botones;
	}

	public void setBotones(JButton[][] botones) {
		this.botones = botones;
	}
}
